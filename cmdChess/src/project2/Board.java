package project2;

import static java.lang.Math.abs;

/**
 *
 * @author Gthanasis
 */
public abstract class Board 
{
   private Piece[][] pieces = new Piece[8][8];
   private final Color a = Color.WHITE;
   private final Color b = Color.BLACK;
   private Location loc;
   private int scorea=0,scoreb=0;
   private int l;

   public Board(){}
 
   public Board(int i)
   {
       l=i;
   }
   public int get()
   {
       return l;
   }
   
   public Piece getPieceAt(Location loc)
   {
       return pieces[loc.getRow()][7-loc.getCol()];
   }
   
   public Piece getPieceAt(int r, int c)
   {
       return pieces[r][7-c];
   }
   
    public void setPiece(Piece[][] pc)
   {
       for(int i=0;i<8;i++)
           for(int j=0;j<8;j++)
                pieces[i][7-j]=pc[i][j];
   }
   
    void init()
    {
        Board br;
        br=new Board(1){};
        for(int i=2; i<6; i++){
            for(int j=0; j<8; j++){
                pieces[i][j]=new Empty(i,j,a,br);
            }
        }
       
            for(int i=0; i<8; i++){ 
                    pieces[6][i]=(new Pawn(1,i,b,br));
            }
            
            pieces[7][0]=(new Rook(0,0,b,br));
            
            pieces[7][7]=(new Rook(0,7,b,br));
            
            pieces[7][2]=(new Bishop(0, 2, b,br));
            
            pieces[7][5]=(new Bishop(0, 5, b,br));
            
            pieces[7][1]=(new Knight(0, 1, b,br));
            
            pieces[7][6]=(new Knight(0, 6, b,br));
            
            pieces[7][4]=(new Queen(0, 4, b,br));
            
            pieces[7][3]=(new King(0, 3, b,br));
        
            
        for(int i=0; i<8; i++){ 
                    pieces[1][i]=(new Pawn(6,i,a,br));
            }
            
            pieces[0][0]=(new Rook(7, 0, a,br));
            
            pieces[0][7]=(new Rook(7, 7, a,br));
            
            pieces[0][2]=(new Bishop(7, 2, a,br));
            
            pieces[0][5]=(new Bishop(7, 5, a,br));
            
            pieces[0][1]=(new Knight(7, 1, a,br));
            
            pieces[0][6]=(new Knight(7, 6, a,br));
            
            pieces[0][4]=(new Queen(7, 4, a,br));
            
            pieces[0][3]=(new King(7, 3, a,br));
            
            print();
        
    }
public void print()
{/*Εκτύπωση κομματιών χωρίς αποθήκευση σε στρινγκ μετά απο αυτή ακολουθεί 
    και η συνάρτηση toString() που μπορεί να κάνει το ίδιο αλλά τα αποθηκέυει σε κατάλληλο αλφαριθμητικό*/
            System.out.print("  ");
            for(char ch = 'a' ; ch <= 'h' ; ch++ )
                System.out.print(ch);
            System.out.println();
            for (int i=7;i>=0;i--){
                System.out.print((i+1)+" ");
                for (int j=7;j>=0;j--){
                    if(pieces[i][j]!=null)
                   if (pieces[i][j].toString().equals("r") ){
                    //if (pieces[i][j].c==0 ||pieces[i][j].c==7){ 
                        if (pieces[i][j].color==a)
                            System.out.print("R");
                        else  
                            System.out.print("r");
                    }
                   
                    else if (pieces[i][j].toString().equals("b")){ 
                         if (pieces[i][j].color==a)
                            System.out.print("B");
                        else  
                            System.out.print("b");
                    }
                    else if (pieces[i][j].toString().equals("k")){ 
                         if (pieces[i][j].color==a)
                            System.out.print("K");
                        else  
                            System.out.print("k");
                    }
                    else if (pieces[i][j].toString().equals("q")){ 
                        if (pieces[i][j].color==a)
                            System.out.print("Q");
                        else  
                            System.out.print("q");
                    }
                    else if (pieces[i][j].toString().equals("n")){
                       
                         if (pieces[i][j].color==a)
                            System.out.print("N");
                        else  
                            System.out.print("n");
                    }
                    
                    
                    else if (pieces[i][j].toString().equals("p")){
                        if (pieces[i][j].color==a)
                            System.out.print("P");
                        else  
                            System.out.print("p");
                        }
                    
                    else System.out.print(" ");
                }
                System.out.print(" "+(i+1));
                System.out.print("     |");
                if (i==7) System.out.print("          SCORE");
                else if (i==5) System.out.print("     WHITE  |  BLACK");
                else if (i==3) System.out.printf("       %d         %d", scorea, scoreb);
                System.out.println();
            }
             System.out.print("  ");
         for(char ch = 'a' ; ch <= 'h' ; ch++ )
                System.out.print(ch);
         System.out.println();
}
 
@Override
public String toString()
{
        String str;
            str=("  ");
            for(char ch = 'a' ; ch <= 'h' ; ch++ )
                str=str+ch;
            str=str+"\n";
            for (int i=7;i>=0;i--){
                str=str+((i+1)+" ");
                for (int j=7;j>=0;j--){
                    if(pieces[i][j]!=null)
                   if (pieces[i][j].toString().equals("r") ){
                        if (pieces[i][j].color==a)
                            str=str+"R";
                        else  
                            str=str+"r";
                    }
                   
                    else if (pieces[i][j].toString().equals("b")){ 
                         if (pieces[i][j].color==a)
                            str=str+"B";
                        else  
                            str=str+"b";
                    }
                    else if (pieces[i][j].toString().equals("k")){ 
                         if (pieces[i][j].color==a)
                            str=str+"K";
                        else  
                            str=str+"k";
                    }
                    else if (pieces[i][j].toString().equals("q")){ 
                        if (pieces[i][j].color==a)
                            str=str+"Q";
                        else  
                            str=str+"q";
                    }
                    else if (pieces[i][j].toString().equals("n")){
                       
                         if (pieces[i][j].color==a)
                            str=str+"N";
                        else  
                            str=str+"n";
                    }
                    
                    
                    else if (pieces[i][j].toString().equals("p")){
                        if (pieces[i][j].color==a)
                            str=str+"P";
                        else  
                            str=str+"p";
                        }
                    
                    else str=str+" ";
                }
                str=str+(" "+(i+1));
                str=str+"\n";
            }
             str=str+("  ");
         for(char ch = 'a' ; ch <= 'h' ; ch++ )
                str=str+(ch);
         str=str+"\n";
         //System.out.println(str);
         return str;
}

public void movePiece(Location from, Location to)
{//kinhsh kommatiou otan h telikh thesh einai kenh
    int r,c,r2,c2;
    r=from.getRow();
    c=from.getCol();
    r2=to.getRow();
    c2=to.getCol();
    Piece temp = pieces[r][7-c];
    pieces[r][7-c] = pieces[r2][7-c2];
    pieces[r2][7-c2] = temp;
}
        
public void movePieceCapturing(Location from, Location to)
{//kinhsh kommatiou otan h telikh thesh einai kateilhmenh apo antipalo kommati
    int r,c,r2,c2;
    r=from.getRow();
    c=from.getCol();
    r2=to.getRow();
    c2=to.getCol();
    Piece temp = pieces[r][7-c];
    Board bb=temp.brd;
    String s = pieces[r2][7-c2].toString();
    Color cl = pieces[r2][7-c2].color;
    pieces[r][7-c] = new Empty(r,7-c,a,bb);
    pieces[r2][7-c2] = temp;
    if(cl==a){//auxhsh antistoixou score
        if(s.equals("p"))scoreb++;
        else if(s.equals("r"))scoreb+=5;
        else if(s.equals("n"))scoreb+=3;
        else if(s.equals("b"))scoreb+=3;
        else if(s.equals("q"))scoreb+=9;
    }
    else{
        if(s.equals("p"))scorea++;
        else if(s.equals("r"))scorea+=5;
        else if(s.equals("n"))scorea+=3;
        else if(s.equals("b"))scorea+=3;
        else if(s.equals("q"))scorea+=9;
    }
}
        
public boolean freeHorizontalPath(Location from, Location to)
{
    return (to.getRow() == from.getRow());
}

public int movePawn(Location from, Location to)
{//kapoioi apo tous elegxous gia th kinhshs tou pioniou sthn katallhlh kateuthunsh
    if (freeVerticalPath(from, to)){
        //if(pieces[from.getRow()][7-from.getCol()]!=null)
         if(pieces[from.getRow()][7-from.getCol()].color==a){
            if (from.getRow()==1||from.getRow()==6){
                        if (abs(to.getRow()-from.getRow())>=1 && abs(to.getRow()-from.getRow())<=2){
                            for(int i=(to.getRow());i>(to.getRow()-abs(to.getRow()-from.getRow()));i--){
                                for(int j=(7-from.getCol());j>=(7-to.getCol());j--){
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else{
                                        System.out.println("\n--There is another piece in this position\n");
                                        return -1;
                                    }
                                }    
                            }
                                return 1;
                        }
            }
                        else if ((to.getRow()-from.getRow())==1){
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                return 1;
                            }
                            else{
                                System.out.println("\n--There is another piece in this position\n");
                                return -1;
                            }
                        
                    }
                    else{    
                        return -1;
                    }
                        
                    
         }
         else {
                        if (abs(to.getRow()-from.getRow())>=1 && abs(to.getRow()-from.getRow())<=2){
                            try{
                           for(int i=abs(from.getRow()-1);i>=abs(to.getRow());i--){
                                for(int j=abs(7-to.getCol());j>=abs(7-to.getCol());j--){
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else{
                                        System.out.println("\n--There is another piece in this position\n");
                                        return -1;
                                    }
                                }    
                            }
                            }catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("\n--There is another piece in this position\n");
                                return -1;
                            }
                                return 1;
                        }
         
                        else if ((to.getRow()-from.getRow())==-1){
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                return 1;
                            }
                            else{
                                System.out.println("\n--There is another piece in this position\n");
                                return -1;
                            }
                        
                    }
                    else{
                        return -1;
                    }   
         }
    }
    else if (freeDiagonalPath(from, to)||freeAntidiagonalPath(from, to)){
        if (abs(to.getRow()-from.getRow())==1||abs(to.getCol()-from.getCol())==1){
            if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
               return 2;
            }
        }
    }
        return -1;
}
        
public int moveRook(Location from, Location to)
{//elegxoi gia kinhshs tou purgou ekei pou prepei
    if (freeVerticalPath(from, to)){
                       if(to.getRow()>from.getRow()){
                            for(int i=(to.getRow())-1;i>(to.getRow()-abs(to.getRow()-from.getRow()));i--){
                                for(int j=(7-from.getCol());j>=(7-to.getCol());j--){/*elegxos gia kena sta endiamesa tetragona tou komatiou kai ths telikhs theshs
                                    **afou to komati den mporei na perasei an uparxei allo komati ekei*/
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else return -1;
                                }    
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       }
                       else{
                           for(int i=abs(from.getRow()-1);i>=abs(to.getRow());i--){
                                for(int j=abs(7-to.getCol());j>=abs(7-to.getCol());j--){
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else return -1;
                                }    
                            }
                           if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       }
                       
                       
                                return 1;
                                
         }
    else if (freeHorizontalPath(from, to)){
                       if(to.getCol()>from.getCol()){
                            for(int i=abs(to.getRow());i>=abs(to.getRow());i--){
                                 for(int j=(to.getCol())-1;j>(to.getCol())-abs(to.getCol()-from.getCol());j--){
                                     /*elegxos gia kena sta endiamesa tetragona tou komatiou kai ths telikhs theshs
                                    **afou to komati den mporei na perasei an uparxei allo komati ekei*/
                                    if (pieces[to.getRow()][7-j].toString().equals("e")){
                                    }
                                    else return -1;
                                }    
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       }
                       else{
                           for(int i=abs(to.getRow());i>=abs(to.getRow());i--){
                                for(int j=abs(7-(to.getCol())-1);j>(7-from.getCol());j--){
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else return -1;
                                }    
                            }
                           if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       }
                                return 1;                       
    }
      
        return -1;
}

public int moveBishop(Location from, Location to)
{//kapoioi apo tous elegxous gia th kinhshs tou axiomatikou stis katallhles kateuthunseis
   if(to.getRow()>from.getRow()){
    if (freeDiagonalPath(from, to)){
                       int j=(to.getCol()-1);
                            for(int i=(to.getRow()-1);i>(to.getRow())-abs(to.getRow()-from.getRow());i--){
                                /*elegxos gia kena sta endiamesa tetragona tou komatiou kai ths telikhs theshs
                                    **afou to komati den mporei na perasei an uparxei allo komati ekei*/
                                if (j>(to.getCol())-abs(to.getCol()-from.getCol())){               
                                    if (pieces[i][7-j].toString().equals("e")){
                                    }
                                    else return -1;
                                }
                                j--;
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                                return 1;
                                
         }
    else if (freeAntidiagonalPath(from, to)){
                       int j=abs(7-(to.getCol()+1));
                            for(int i=(to.getRow()-1);i>(to.getRow()-abs(to.getRow()-from.getRow()));i--){
                              if(j>(7-from.getCol())){
                                    if (pieces[i][j].toString().equals("e")){
                                        System.out.println(i+" "+j);
                                    }
                                    else return -1;
                                }    
                              j--;
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       
                      
                                return 1;                       
    }
    else System.out.println("Bishops can only move diagonally or antidiagonally");
      
        return -1;
}
   else{
           if (freeDiagonalPath(from, to)){
                       int j=(7-from.getCol());
                            for(int i=abs(from.getRow()-1);i>=abs(to.getRow());i--){
                              if(j<=abs(7-(to.getCol()))){
                                    if (pieces[i][j].toString().equals("e")){
                                    }
                                    else return -1;
                                }    
                              j++;
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       
                      
                                return 1;  
                                
         }
    else if (freeAntidiagonalPath(from, to)){
                       int j=(to.getCol()-1);
                            for(int i=(to.getRow()+1);i>(to.getRow())-abs(to.getRow()-from.getRow());i--){
                                if (j>(to.getCol())-abs(to.getCol()-from.getCol())){
                                    if (pieces[i][7-j].toString().equals("e")){

                                    }
                                    else return -1;
                                }
                                j--;
                            }
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                                    }
                       
                      
                                return 1;
                                                 
    }
    else System.out.println("Bishops can only move diagonally or antidiagonally");
      
        return -1;
       
       
   }
}

public int moveKnight(Location from, Location to)
{// kinhsh tou ippou
        if (freeKnightsPath(from, to)){
            /*elegxos mono an to tetragono sto opoio paei einai keno*/
                                     if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                        return 1;
                                    }
                                    else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){
                                        //an einai idiou xromatos den mporei na paei
                                        return -1;
                                    }
                                     else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;/*an einai diaforetikou epistrefei ton katallhlo arithmo sto knight etsi oste na kalestei 
                                             h movepiececapturing apo ekei kai na 'faei'-apomakrunei to antipalo kommati*/
                                    }   
                       }
        return -1;
}
int moveKing(Location from, Location to)
{//kinhsh tou basilia
        if (freeVerticalPath(from, to)){
            if ((to.getRow()-from.getRow())==1){
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                return 1;
                            }
                            else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                            }
                            else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                            }          
                    }            
        }
        if (freeHorizontalPath(from, to)){
            if (abs(7-to.getCol()-(7-from.getCol()))==1){
                            if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                return 1;
                            }
                            else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){

                                        return -1;
                            }
                            else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                            }          
                    }            
        }
        else if (freeDiagonalPath(from, to)||freeAntidiagonalPath(from, to)){
            if (abs(to.getRow()-from.getRow())==1||abs(to.getCol()-from.getCol())==1){
                if (pieces[to.getRow()][7-to.getCol()].toString().equals("e")){
                                return 1;
                            }
                            else if(pieces[to.getRow()][7-to.getCol()].color==pieces[from.getRow()][7-from.getCol()].color){
                                        return -1;
                            }
                            else if (!pieces[to.getRow()][7-to.getCol()].toString().equals("e")&&pieces[to.getRow()][7-to.getCol()].color!=pieces[from.getRow()][7-from.getCol()].color){
                                             return 2;
                            }          
        }
    }
        return -1;
}



public boolean freeVerticalPath(Location from, Location to)
{
    return (to.getCol() == from.getCol());
}
        
public boolean freeDiagonalPath(Location from, Location to)
{
    return (to.getRow() - from.getRow() == to.getCol() - from.getCol());
}
       
public boolean freeAntidiagonalPath(Location from, Location to)
{
    return (abs(to.getRow() - from.getRow()) == abs((7-to.getCol()) - (7-from.getCol())));
}

public boolean freeKnightsPath(Location from, Location to)
{
    boolean knight;
    knight = (to.getRow() == from.getRow() - 2 || to.getRow() == from.getRow() + 2);
    if (knight)
        knight = (to.getCol() == from.getCol() - 1 || to.getCol() == from.getCol() + 1 );
    if (knight) return true;
    knight = (to.getRow() == from.getRow() - 1 || to.getRow() == from.getRow() + 1);
    if (knight)
        knight = (to.getCol() == from.getCol() - 2 || to.getCol() == from.getCol() + 2 );
    return knight;
}
     
    

}

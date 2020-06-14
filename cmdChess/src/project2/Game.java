package project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import java.util.Scanner;

/**
 *
 * @author Gthanasis
 */
public class Game 
{
    private File d ;
    private Piece[][] fpiece = new Piece[8][8];//pinakas me ta kommatia pou apothukeuontai sto arxeio
    private int r,c,r2,c2;
    private final Board b1=new Board(1){};
    Scanner ans = new Scanner(System.in);
    private Location loc1,loc2;
    private Piece p;
    private Color a=Color.BLACK,b;
    private int caught=1;
    
    public void play()
    { 
        a=a.Color(a);
        String ans;
         b1.init();
         Scanner sc = new Scanner(System.in);
         while(true){
            while(caught==1){
                try{
                    b=a.nextColor();
                    System.out.println("\n"+b+":Make your move or enter a command: ");
                    ans=sc.nextLine();
                    caught=0;
                    handleMove(ans);
                }catch(StringIndexOutOfBoundsException es){
                    caught=1;
                    System.out.println("Incompatible character. Please try again!!!");
                    b=a.nextColor();
                }
            }
            caught=1;
         } 
    }
    
    public void handleMove(String moveString)
    {
        Location loc2=new Location(moveString){};
        InvalidMoveException exc;
        InvalidLocationException lexc;
        if(moveString.charAt(0)!=':'){
            try{
               if(moveString.length()!=4){//perissoteroi h ligoteroi xarakthres apo to epitrepto megethos
                    lexc = new InvalidLocationException("Too many or too little letters to function!!!");//dhmiourgei exception
                    throw lexc;//kai th petaei
                }
                else if (abs(moveString.charAt(0)-'a')>7||abs(moveString.charAt(2)-'a')>7||abs(moveString.charAt(1)-'1')>7||abs(moveString.charAt(3)-'1')>7){ 
                    lexc = new InvalidLocationException("Wrong command Out of bounds");//suntaktika sfalmata kai mh epitreptoi ektos orio xarakthres
                    throw lexc;
                }
                 else if((moveString.charAt(0)-'a' == moveString.charAt(2)-'a') && (moveString.charAt(1)-'1'==moveString.charAt(3)-'1')){//arxikh thesh idia me th telikh
                    lexc = new InvalidLocationException("You are already there\n");
                    throw lexc;
                }
            }
            catch(InvalidLocationException e){
                caught=1;
                b=a.nextColor();
                System.out.println(e.getMessage());
                return;
            }
           loc2.Locationfrom(moveString);//briskei th thesh tou trexon komatiou se periptosh pou xreiastei
           r = loc2.getRow();
           c = loc2.getCol();
           loc2=new Location(moveString){};//briskei th thesh sthn opoia tha metaferthei to kommati
           r2 = loc2.getRow();
           c2 =loc2.getCol();
           System.out.println();
           loc2=new Location(r,c){};
           loc1=new Location(r2,c2){};
           p=b1.getPieceAt(r, c);/*briskei poio komati brisketai sth thesh, kurie to kalesa kai me th getPiece(loc1) 
           **apla epeidh etsi to eixa arxika kai to xa dokimasei se oles tis periptoseis fobhthika na to allaxo kai 
           afou den eipate aparaithta na th xrhsimopoihsoume apla na mh thn alalxoume to afhsa etsi*/
           try{
           if (p.color!=this.b){//gia lathos xroma h seira tou paikth den xanetai
               exc = new InvalidMoveException("Wrong player");
               throw exc;
           }
           p.brd=b1;
           if(!p.toString().equals("e")){//elegxos an petuxe h kinhsh tou komatiou
            p.r=r;
            p.c=c;
            p.moveTo(loc1);
                    if (p.check()){//h kinhsh pragmatopoihthike
                        System.out.println("ok move checked ");                       
                    }
                    else{//uphrxe sfalma opote kai kanoume throw to MoveException
                        exc = new InvalidMoveException(p.emessage());
                        throw exc;
                    }           
           }
           else {//an sth thesh den uparxei kommati kai einai kenh
                b1.print();
                exc = new InvalidMoveException("There is no piece there");
                throw exc;
           }
           }catch(InvalidMoveException e){
                caught=1;
                this.b=a.nextColor(); 
                System.out.println(e.getMessage());
                return;
            }
        }
        
        else if(moveString.equals(":h")){
            printHelp();
            
            b=a.nextColor();
            
        }
        else if(moveString.equals(":s")){
            saveGame();
            b=a.nextColor();
        }
        else if(moveString.equals(":o")){
           if(exitGame()){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    fpiece[i][j]=new Empty(i,j,a, b1);
                }
            }
            openGame();
           }
           else b=a.nextColor();
          
        }
        else if(moveString.equals(":x")){
            if(exitGame()==true){
                System.out.println("The program is about to exit..."); 
                System.exit(0); 
            }
            else  b=a.nextColor();
        }
        else{
            System.out.println("Wrong command!!!Please move a piece or enter one of the available commands\n:h :s :o :x");
        }
       
         
    }

        
    public void saveGame()
    {//apothukeush paixnidiou
        System.out.println("Please give the name of the file in which you want to save");
        String fname;
        fname=ans.nextLine();
        d = new File(fname+".txt");
        try {
            PrintWriter pw = new PrintWriter(d);
            
            for(int i=0;i<8;i++)/*kanei save ta stoixeia tou pianaka apo th board
                kai to xroma tou teleutaiou paikth pou epaixe*/
                for(int j=0;j<8;j++)
                    pw.println(b1.getPieceAt(i,j).toString()+" "+b1.getPieceAt(i,j).color);
            pw.println(b+"");
            pw.close();
            System.out.println("\nGame Saved Succesfully\n");//h apothukeush petuxe
        }
        catch (FileNotFoundException e) {
            System.out.println("Error writing to the file");//to arxeio den brethike h den eixame dikaiomata h genika kapoio sfalma
        }
    }

        
    public void openGame()
    {
        //fortonoume apo to arxeio ta apothukeumena stoixeia ston pinaka
        try {
            String k="",l="";
            System.out.println("Please give the name of the file you want to load");
            String fname;
            fname=ans.nextLine();
            d = new File(fname+".txt");
            FileInputStream fis = new FileInputStream(d);
            System.out.println("Game Loaded...");
        Scanner myScanner = new Scanner(fis);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (myScanner.hasNext()) {
                    k = myScanner.next();
                }
                else return;
                if (myScanner.hasNext()) {
                    l = myScanner.next();
                }
                else return;
                    if (k.equals("p") && l.equals("WHITE"))
                        fpiece[i][j]=new Pawn(i,j,Color.WHITE, b1);
                    else if (k.equals("p") && l.equals("BLACK"))
                        fpiece[i][j]=new Pawn(i,j,Color.BLACK, b1);
                    else if (k.equals("b") && l.equals("WHITE"))
                        fpiece[i][j]=new Bishop(i,j,Color.WHITE, b1);
                    else if (k.equals("b") && l.equals("BLACK"))
                        fpiece[i][j]=new Bishop(i,j,Color.BLACK, b1);
                    else if (k.equals("n") && l.equals("WHITE"))
                        fpiece[i][j]=new Knight(i,j,Color.WHITE, b1);
                    else if (k.equals("n") && l.equals("BLACK"))
                        fpiece[i][j]=new Knight(i,j,Color.BLACK, b1);
                    else if (k.equals("r") && l.equals("WHITE"))
                        fpiece[i][j]=new Rook(i,j,Color.WHITE, b1);
                    else if (k.equals("r") && l.equals("BLACK"))
                        fpiece[i][j]=new Rook(i,j,Color.BLACK, b1);
                    else if (k.equals("q") && l.equals("WHITE"))
                        fpiece[i][j]=new Queen(i,j,Color.WHITE, b1);
                    else if (k.equals("q") && l.equals("BLACK"))
                        fpiece[i][j]=new Queen(i,j,Color.BLACK, b1);
                    else if (k.equals("k") && l.equals("WHITE"))
                        fpiece[i][j]=new King(i,j,Color.WHITE, b1);
                    else if (k.equals("k") && l.equals("BLACK"))
                        fpiece[i][j]=new King(i,j,Color.BLACK, b1);
                    else fpiece[i][j]=new Empty(i,j,Color.WHITE, b1);
                if (myScanner.hasNextLine())  
                  myScanner.nextLine();  
            }
        }
        if (myScanner.hasNextLine()) {/*kanoume to xroma idio me to xroma tou paikth pou epaixe teleutaios sto apothukeumeno paixnidi
            etsi oste na sunexistei h partida apo to hmeio pou teleiose*/
            l = myScanner.nextLine();
                if(l.equals("WHITE")&& b==Color.WHITE || (l.equals("BLACK")&& b==Color.BLACK))
                    b=a.nextColor();
        }
        myScanner.close();
        b1.setPiece(fpiece);//pername ta apothukeumena stoixeia ston pinaka tou board 
        b1.print();//kai h ektuposh
        }catch (FileNotFoundException e) {
            System.out.println("Error reading from the file");//to arxeio den brethike h den eixame dikaioma gia read
        }
         
    }

        
    public boolean exitGame()
    {//exodos apo to paixnidi
        int k=1;
        String out;
            while(true){
            System.out.println("Do you really want to exit (Y/N or y/n) ");
            out = ans.nextLine();
            if (out.equals("Y")||out.equals("y"))
                    return true;
            else if(out.equals("N")||out.equals("n"))
                    return false;
            }      
    }

        
    public void printHelp()
    {//ektuposh bohtheias
        System.out.println("\n--HELP--\n");
        System.out.println("This is a 2d game of chess in which most chess rules");
        System.out.println("are applied. If you dont know the rules you may check");
        System.out.println("https://en.wikipedia.org/wiki/Rules_of_chess");
        System.out.println("To move a piece, give piece's current location to the location where it will be moved");
        System.out.println("ForExample: If a pawn is at a2 'a2a4' will move it from a2 to a4");
        System.out.println("There are also these available commands:\n");
        System.out.println("Save current game--Press ':s' to save and then type the name you want it to have");
        System.out.println("Open-Load a saved game--Press ':o' to open and then type the name of file you want to open");     
        System.out.println("Exit the game--Press ':e' to exit y/Y(yes) to exit or n/N to stay");
        System.out.println("View this help board--Press ':h'");
        System.out.println("This project-app was created by Galatis Athanasios ':h'");
        System.out.println("Hope you'll enjoy!!!");
        System.out.println("\n--------\n");
    }
}

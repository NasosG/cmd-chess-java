package project2;

/**
 *
 * @author Gthanasis
 */
public class King extends Piece
{
    private boolean ch;
     public King(int r,int c,Color color,Board brd)
        {
             super(r,c,color,brd);
        }
     
     
     @Override
     public void moveTo(Location newLoc)
        {
           Location from =new Location(r,c){};
            if (brd.moveKing(from,newLoc)==1){                   
                                brd.movePiece(from,newLoc);
                        brd.print();
                        ch =true;
            }
            else if(brd.moveKing(from,newLoc)==2){
                                 brd.movePieceCapturing(from,newLoc);
                                 brd.print();
                                 ch=true;
            }
            else{
                        brd.print();
                        ch = false;
            }
          
        }
     
     
     
     @Override
       public String toString()
       {
                return "k";
       }
     @Override
        public boolean check()
        {
               return ch;
        }
             
       @Override
        public String emessage()
        {
                return ("--The king can move only one square horizontally, vertically, or diagonally\nIt also cannot move if the square is occupied by any piece of the same color\n"); 
        }
}

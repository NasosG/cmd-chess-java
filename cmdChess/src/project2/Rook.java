package project2;

/**
 *
 * @author Gthanasis
 */
public class Rook extends Piece
{
    private boolean ch;
    Board b1=new Board(){};
      public Rook(int r,int c,Color color,Board brd)
        {
             super(r,c,color,brd);
        }
      
      
    @Override
      public void moveTo(Location newLoc)
        {
           Location from =new Location(r,c){};
            if (brd.moveRook(from,newLoc)==1){                    
                                brd.movePiece(from,newLoc);
                        brd.print();
                        ch = true;
            }
            else if(brd.moveRook(from,newLoc)==2){
                                 brd.movePieceCapturing(from,newLoc);
                                 brd.print();
                                 ch = true;
            }
            else{                     
                        brd.print();
                        ch = false;
            }
          
        }
      
      
      
      
      @Override
            public String toString()
            {
                return "r";
            }
            
    @Override
         public boolean check()
        {
               return ch;
        }
         
          @Override
        public String emessage()
        {
                return ("\n--The rook moves any number of squares vertically or horizontally\nIt also cannot move if the square is occupied by any piece of the same color\n");
        }
}

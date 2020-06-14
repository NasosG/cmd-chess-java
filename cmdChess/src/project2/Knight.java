package project2;

/**
 *
 * @author Gthanasis
 */
public class Knight extends Piece
{
    private boolean ch;
     public Knight(int r,int c,Color color,Board brd)
        {
             super(r,c,color,brd);
        }
     
     
     
     @Override
     public void moveTo(Location newLoc)
        {
           Location from =new Location(r,c){};
            if (brd.moveKnight(from,newLoc)==1){                    
                                brd.movePiece(from,newLoc);
                        brd.print();
                        ch = true;
            }
            else if(brd.moveKnight(from,newLoc)==2){
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
                return "n";
        }
     @Override
        public boolean check()
        {
               return ch;
        }
             
              @Override
        public String emessage()
        {
                return ("\n--Knight moves two squares horizontally and one square vertically or vice versa, making a shape which looks like 'L' or 'Γ'\nIts the only piece which can jump over another pieces of the same colour\n"); 
        }
}

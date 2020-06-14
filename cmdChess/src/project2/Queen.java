package project2;

/**
 *
 * @author Gthanasis
 */
public class Queen extends Piece
{
    private boolean ch;
     public Queen(int r,int c,Color color,Board brd)
        {
            super(r,c,color,brd);
        }
     
     
     @Override
     public void moveTo(Location newLoc)
        {
           Location from = new Location(r,c){};
            if (brd.freeVerticalPath(from,newLoc)||brd.freeHorizontalPath(from,newLoc)){
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
            else if(brd.freeDiagonalPath(from,newLoc) || brd.freeAntidiagonalPath(from,newLoc)){
                if (brd.moveBishop(from,newLoc)==1){                   
                        brd.movePiece(from,newLoc);
                        brd.print();
                        ch = true;
                }
                else if(brd.moveBishop(from,newLoc)==2){
                    brd.movePieceCapturing(from,newLoc);
                    brd.print();
                    ch = true;
                }
                else{
                    brd.print();
                    ch = false;
                }
            }
        }
     
     @Override
            public String toString()
            {
                return "q";
            }
     @Override
             public boolean check()
        {
               return ch;
        }
             
              @Override
        public String emessage()
        {
                return ("\n--Considered as the most powerful piece in the game\nThe queen can move any number of squares diagonally, horizontally, or vertically.\nBut It cannot move if the square is occupied by any piece of the same color\n");
        }
}

package project2;
/**
 *
 * @author Gthanasis
 */

  public class Pawn extends Piece
    {
      private boolean ch;
       Board b1=new Board(){};
        public Pawn(int r,int c,Color color,Board brd)
        {
            super(r,c,color,brd);
        }
               
        
        
       @Override
        public void moveTo(Location newLoc)
        {
            Location from =new Location(r,c){};
            if (brd.movePawn(from,newLoc)==1){                    
                                brd.movePiece(from,newLoc);
                        brd.print();
                        ch = true;
            }
            else if(brd.movePawn(from,newLoc)==2){
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
        public boolean check()
        {
               return ch;
        }
        
        
            @Override
            public String toString()
            {
                return "p";
            }
            
             @Override
        public String emessage()
        {
                return ("\n--Sorry but pawns generally can only move one square. The first time a pawn is moved, ")
                      +("it has the option of advancing two squares and it can take pieces by advancing ")
                      +("one square\ndiagonally or antidiagonally and finally they can't move to a square if it is occupied by any same color piece.\n"); 
        }
        
    }
        
    
      




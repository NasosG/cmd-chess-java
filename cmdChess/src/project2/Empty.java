package project2;

/**
 *
 * @author Gthanasis
 */

    public class Empty extends Piece
{
     public Empty(int r,int c,Color color,Board brd)
        {
             super(r,c,color,brd);
        }
     @Override
            public String toString()
            {
                return "e";
            }
     @Override
        public boolean check()
        {
               return false;
        }
     
}



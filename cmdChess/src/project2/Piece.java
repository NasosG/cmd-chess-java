package project2;

/**
 *
 * @author Gthanasis
 */
public class Piece 
{
int r;
int c;
Color color;
Board brd;
    public Piece(int r, int c,Color color,Board brd) 
    {
        super();
        this.r = r;
        this.c = c;
        this.color = color;
        this.brd=brd;
    }
    void moveTo(Location newLoc){}
     public boolean check()
        {
               return false;
        }
    @Override
    public String toString()
    {
        return "";
    }
    
    public String emessage()
    {
          return "b";
    }
  
    
}

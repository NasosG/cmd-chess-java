package project2;

/**
 *
 * @author Gthanasis
 */
public enum Color 
{
     BLACK,WHITE;
     
     Color a;
     
     public Color Color(Color b)
     {
         a=b;
         return a;
     }
     
    public Color nextColor()
    {
        if (a==Color.BLACK) {
            a=Color.WHITE;
            return Color.WHITE;
        }
        else {
            a=Color.BLACK;
            return Color.BLACK;
        }
    }
    
}

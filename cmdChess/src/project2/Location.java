package project2;

/**
 *
 * @author Gthanasis
 */
public abstract class Location 
{
    int rows,cols;
    public Location(int r, int c)
    {
        rows=r;
        cols=c;
    }
     
    
    public Location(String loc)
    {
        
        for (int i=0;i<loc.length();i++) {
          if (i>=2)
            if (loc.charAt(i)>='a' && loc.charAt(i)<='h') {
                cols=loc.charAt(i)-'a';
            }
            else if (loc.charAt(i)>='1' && loc.charAt(i)<='8') {
                rows=loc.charAt(i)-'1';
            }
            else{
                System.out.println("Error");
            }
        }
    }
    
    public void Locationfrom(String loc)
    {
        for (int i=0;i<loc.length();i++) {
          if (i>=2)
            if (loc.charAt(i)>='a' && loc.charAt(i)<='h') {
                cols=loc.charAt(0)-'a';
            }
            else if (loc.charAt(i)>='1' && loc.charAt(i)<='8') {
                rows=loc.charAt(1)-'1';
            }
            else{
                System.out.println("Error");
            }
        }
    }
    
    int getRow()
    {
        return rows;
    }
    
    int getCol()
    {
        return cols;
    }
        
    @Override
    public String toString()
    {
        
        return (rows + ""+ cols );

    }
}

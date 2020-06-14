package project2;

/**
 *
 * @author Gthanasis
 */
public class Project2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int n=1;
        System.out.println("\t\t\t\t ________     _         _      ________     _________     _________    ");
        System.out.println("\t\t\t\t|  _____/    | |       | |    |  _____/    |  ______/    |  ______/    ");
        System.out.println("\t\t\t\t| |          | |       | |    | |          | |           | |           ");
        System.out.println("\t\t\t\t| |          | |_______| |    | |____      | |______     | |______     ");
        System.out.println("\t\t\t\t| |          | |_______| |    | |___/      \\______  |    \\______  |  ");
        System.out.println("\t\t\t\t| |          | |       | |    | |                 | |           | |    ");
        System.out.println("\t\t\t\t| |______    | |       | |    | |______     ______| |     ______| |    ");       
        System.out.println("\t\t\t\t|________\\   |_|       |_|    |________\\   |________|    |________|  ");
        
        System.out.println();
        System.out.println("\t\t\t\t\t\t\tLoading....");
        for(int l=0;l<11;l++){      //ena fake loading to opoio einai grhgoro se periptosh pou to susthma einai palaiotero
          for (double i=0;i<20000000;i++){ }
          if(n==1)
            System.out.print("\t\t\t\t\t\t\t|");
                System.out.print("_");
                n=0;
        } System.out.print("|");
                    
       for(int k = 0; k < 2; k++)
                System.out.println();
       Game game1 = new Game();
       game1.play();
    }
}

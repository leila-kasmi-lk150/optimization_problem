
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Leila
 */
public class Main {
    // Distance Methode
    public static double distance(double x1, double y1,double x2, double y2){
        double z =Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        return z;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Noeuds: ");
        int noeuds = scanner.nextInt();
        
        // Enter Coordinates x,y of Noeud
        double[][] arr= new double[noeuds][2];
        for(int i=0;i<noeuds; i++){
        System.out.print("Enter x of Noeuds"+i+" : ");
        arr[i][0]=scanner.nextFloat();
        System.out.print("Enter y of Noeuds"+i+" : ");
        arr[i][1]=scanner.nextFloat();
        }
        
        // calculate distance between noedes and insert it in Des Array
        double[][] Des = new double[noeuds][noeuds];
        for(int i=0; i<noeuds;i++){
            for(int j=0; j<noeuds;j++){
                Des[i][j]=distance(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
            }
        }
        
        // print Des arr
        String formatDes;
        for(int i=0; i<noeuds;i++){
            for(int j=0; j<noeuds;j++){
                formatDes= String.format("%.2f", Des[i][j]);
                System.out.print("Des["+i+"]"+"["+j+"]: "+formatDes+ " | ");
            }
            System.out.println();
        }
        
        // greedy algorithm
        System.out.println("====== Greedy Algorithm ======");
        ArrayList<Integer> route = new ArrayList<>();
        route.add(0);
        int nextNoeud=0;
        int NoeudsExist = noeuds-1;
        int getNoeuds;
        double destance=0;
        while(NoeudsExist>0){
            getNoeuds=nextNoeud;
            double min = Double.MAX_VALUE;
            for (int j = 1; j < noeuds; j++) {
                if (Des[getNoeuds][j] < min && !route.contains(j)) {
                    min = Des[getNoeuds][j];
                    nextNoeud = j;
                }
            }
            System.out.println("Des["+getNoeuds+"]["+nextNoeud+ "] --->" +Des[getNoeuds][nextNoeud]);
            destance+=Des[getNoeuds][nextNoeud];
            route.add(nextNoeud);
            NoeudsExist--;
        }
        
        System.out.println("Low cost cycle using Greedy Algorithm: " + route);
        System.out.println("Total Distance: "+destance);
        
        // Random Search
        System.out.println("====== Random Search ======");
        ArrayList<Integer> route2 = new ArrayList<>();
        route2.add(0);
        int getNoeuds2=0;
        double destance2=0;
        ArrayList<Integer> allNoeuds = new ArrayList<>();
        for (int i = 0; i < noeuds; i++) {
            allNoeuds.add(i);
        }
        Collections.shuffle(allNoeuds);
        //while(NoeudsExist2>0){
           /*getNoeuds2=randomNoeud;
            do {
                randomNoeud = random.nextInt(noeuds-1);
            } while (route.contains(randomNoeud));
            destance2+=Des[getNoeuds2][randomNoeud];
            */
        for (int i : allNoeuds) {
            if (!route2.contains(i)) {
                route2.add(i);
                destance2+=Des[getNoeuds2][i];
                System.out.println("Des["+getNoeuds2+"]["+i+ "] --->" +Des[getNoeuds2][i]);
                getNoeuds2=i;
            }
        }
            //NoeudsExist2--;
        //}
        
        System.out.println("low cost cycle using Random Search: " + route2);
        System.out.println("Total Distance: "+destance2);
    }
    
}

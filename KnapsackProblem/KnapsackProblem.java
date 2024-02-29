

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Leila
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter knapsack size: ");
        int knapsackSize = scanner.nextInt();
        System.out.print("Enter number of objects: ");
        int nbrObj = scanner.nextInt();
        //int[] sizeObjects = new int[nbrObj];
        ArrayList<Integer> profitObjects = new ArrayList<>();
        ArrayList<Integer> sizeObjects = new ArrayList<>();
        
        // Enter size and profit of object
        for(int i=0; i<nbrObj; i++){
            int input;
            // enter size of project and check if sizeObject > knapsack size
            do {                
                System.out.print("Enter size of object "+i+" : ");
                input = scanner.nextInt();
                if(input>knapsackSize){
                    System.out.println("Size of object"+i+" should be small then knapsack size !");
                }else{
                    sizeObjects.add(input);
                }
            } while (input>knapsackSize);
            // enter profit of object
            System.out.print("Enter profit of object "+i+" : ");
            profitObjects.add(scanner.nextInt());
        }
        System.out.println("*********************************");
        System.out.println("size Objectse --> "+sizeObjects);
        System.out.println("profit Objects --> "+profitObjects);
        System.out.println("*********************************");
        // Now we will fill the knapsack randomly
        // zero means the object is not in the knapsack
        // one means it is in
        
        ArrayList<Integer> knapsack = new ArrayList<>();
        // function objectif --> total profit sack --> max
        // profitSack --> sum of the number of profits that where entered in the sack
        //sizeAll --> sum size all object that entered
        int profitSack, sizeAll;
        Random random = new Random();
        do {            
            sizeAll=0;
            profitSack=0;
            knapsack.clear();
            int x;
            for (int i = 0; i < nbrObj; i++) {
               x=random.nextInt(2);
               knapsack.add(x);
               sizeAll += x * sizeObjects.get(i);
               profitSack += x * profitObjects.get(i);
            }
        } while (sizeAll > knapsackSize);
       System.out.println("knapsack --> "+knapsack);
       System.out.println("sizeAll --> "+sizeAll);
       System.out.println("profitSack  --> "+profitSack);
       System.out.println("*********************************");
        
        ArrayList<Integer> knapsack2 = new ArrayList<>();
        knapsack2.addAll(knapsack);
        int profitSack2, sizeAll2;
        int nbrItr=6;
        do {  
            sizeAll2=0;
            profitSack2=0;
            int x = random.nextInt(nbrObj);
            do {                
                if (knapsack2.get(x)==1) {
                    knapsack2.set(x, 0);
                } else {
                    knapsack2.set(x, 1);
                }
                for (int i = 0; i < nbrObj; i++) {
                    sizeAll2 += knapsack2.get(i) * sizeObjects.get(i);
                    profitSack2 += knapsack2.get(i) * profitObjects.get(i);
                    
                }
                System.out.println("---------------");
                System.out.println("knapsack "+nbrItr+" -->" +knapsack2);
                System.out.println("sizeAll "+nbrItr+" -->"+sizeAll2);
                System.out.println("profitSack "+nbrItr+" -->"+profitSack2);
            } while (sizeAll2 > knapsackSize);
            if (profitSack2 > profitSack) {
                profitSack= profitSack2;
                sizeAll= sizeAll2;
                knapsack.clear();
                knapsack .addAll(knapsack2);
                
            }
            nbrItr--;
        } while (nbrItr>0);
        
        System.out.println("Final Knapsack "+knapsack);
        System.out.println("Final Knapsack size "+sizeAll);
        System.out.println("Final Knapsack profit "+profitSack);
    }
    
}


import java.util.ArrayList;

/**
 *
 * @author Leila
 * 
 * This class just for return double and array
 */
public class Result {
    private double x;
    private ArrayList<Integer> arr;

    public Result(double x, ArrayList<Integer> arr) {
        this.x = x;
        this.arr = arr;
    }

    public double getFloat(){
        return x;
    }
    public ArrayList<Integer> getArr(){
        return arr;
    }
}

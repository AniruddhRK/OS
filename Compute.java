import java.util.LinkedList;
import java.util.ListIterator;
abstract public class Compute {
    public static void doComputation(LinkedList<Process> pQueue){
        ListIterator<Process> lit = pQueue.listIterator();
        while(lit.hasNext()){
            if(lit.hasPrevious()) {
                Process prev = lit.previous();
                lit.next();
                lit.next().compute(prev);
            }
            else
                lit.next().compute();
        }
    }
}

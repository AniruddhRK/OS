import java.util.Comparator;
public class fifoArrange implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        if(o1.arrivalTime<o2.arrivalTime)
            return -1;
        else if(o1.arrivalTime>o2.arrivalTime)
            return 1;
        return 0;
    }
}

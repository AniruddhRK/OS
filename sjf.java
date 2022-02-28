import java.util.Comparator;

public class sjf implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
            if(o1.arrivalTime == o2.arrivalTime) {
            if (o1.burstTime < o2.burstTime)
            return -1;
            if (o1.burstTime>o2.burstTime)
            return 1;
            return 0;
            }
            else if(o1.arrivalTime<o2.arrivalTime){
            return -1;
            }
            else
            return 1;
            }
}

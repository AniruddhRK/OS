import java.util.Comparator;

public class sjfArrange implements Comparator<Process> {
    static int Time=0;
    @Override
    public int compare(Process o1, Process o2) {
        if(o1.arrivalTime<=Time){
            if(o2.arrivalTime<=Time){
                if(o1.burstTime<o2.burstTime)
                    return -1;
                if(o1.burstTime==o2.burstTime) {
                    if (o1.pID < o2.pID)
                        return -1;
                    else
                        return 1;
                }
                return 1;
            }
            else
                return -1;
        }
        return 0;
    }
    public void setTime(int tConsumed) {
        Time = tConsumed;
    }
}

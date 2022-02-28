import java.util.*;
public class scheduling extends Compute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<Process> comparator = new fifoArrange();
        LinkedList<Process> pQueue = new LinkedList<>();
        int pId =1;
        int choice;
        while(true){
            System.out.println("1. Add a Process\n2. Compute TAT and WT[FIFO]\n3. Compute TAT and WT [SJF]\n4. View Computed Data\n5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    Process p = new Process();
                    p.setDetails(sc,pId++);
                    pQueue.add(p);
                    break;
                case 2:
                    pQueue.sort(comparator);
                    doComputation(pQueue);
                    break;
                case 3:
                    pQueue.sort(new sjf());
                    pQueue.forEach(k->System.out.println(k.pID));
                    ArrayList<Process> tempQueue = new ArrayList<>(pQueue);
                    LinkedList<Process> arr = new LinkedList<>();
                    arr.add(tempQueue.remove(0));
                    int tConsumed = arr.get(0).burstTime;
                    while(arr.size()!=pQueue.size()){
                        new sjfArrange().setTime(tConsumed);
                        tempQueue.sort(new sjfArrange());
                        tConsumed+=tempQueue.get(0).burstTime;
                        arr.add(tempQueue.remove(0));
                    }
                    pQueue = arr;
                    doComputation(pQueue);
                    break;
                case 4:
                    System.out.format("%-17s%-17s%-17s%-17s\n","Process ID","Completion Time","Turn Around Time","Waiting Time");
                    for(Process P:pQueue)
                        System.out.format("%-17d%-17d%-17d%-17d\n",P.pID,P.completionTime,P.turnAroundTime,P.waitingTime);
                    break;
                case 5:
                    System.exit(0);

            }
    }
}
}

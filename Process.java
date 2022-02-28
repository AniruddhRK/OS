import java.util.Scanner;
public class Process {
    public int pID,arrivalTime,completionTime,burstTime,waitingTime,turnAroundTime;
    public void setDetails(Scanner sc,int pID){
        System.out.println("Enter the Arrival Time: ");
        this.arrivalTime = sc.nextInt();
        System.out.println("Enter the Burst Time: ");
        this.burstTime = sc.nextInt();
        this.pID = pID;
    }
    public void compute(Process ...prev){
        if(prev.length>0) {
            this.completionTime = prev[0].completionTime + this.burstTime;
        }
        else{
            this.completionTime = this.burstTime+this.arrivalTime;
        }
        this.turnAroundTime = this.completionTime - this.arrivalTime;
        this.waitingTime = this.turnAroundTime-this.burstTime;
    }
}

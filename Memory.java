import java.util.LinkedList;
import java.util.Scanner;

public class Memory {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number of partition: ");
        int partitionNumber = reader.nextInt();
        LinkedList<Partition> partitions = new LinkedList<Partition>();
        LinkedList<Process> processes = new LinkedList<Process>();

        for (int i = 0; i < partitionNumber; i++) {
            System.out.print("Partition" + i + ": ");
            int partitionSize = reader.nextInt();
            Partition partition = new Partition(partitionSize);
            partitions.add(partition);
        }
        System.out.println("Enter number of processes: ");
        int processNumber = reader.nextInt();
        for (int i = 1; i <= processNumber; i++) {
            System.out.print("Process" + i + ": ");
            int processSize = reader.nextInt();
            Process process = new Process(processSize);
            processes.add(process);
        }

        Scanner policy = new Scanner(System.in);
        System.out.println("Select the policy you want to apply:\n1. First fit\n2. Worst fit\n3. Best fit");
        while (true) {

            System.out.println("Select policy:");

            int policyNum = policy.nextInt();

            Scanner compacting = new Scanner(System.in);

            switch (policyNum) {
                case 1:
                    FirstFit firstFit = new FirstFit(partitions, processes);
                    firstFit.display();

                    System.out.println("Do you want to compact? 1.yes 2.no");
                    int compact = compacting.nextInt();
                    if(compact == 1){
                        Compaction compaction = new Compaction(firstFit.getPartitions());
                        compaction.display();
                    }
                    break;
                case 2:
                    WorstFit worstFit = new WorstFit(partitions, processes);
                    worstFit.display();

                    System.out.println("Do you want to compact? 1.yes 2.no");
                    int compact1 = compacting.nextInt();
                    if(compact1==1){
                        Compaction compaction = new Compaction(worstFit.getPartitions());
                        compaction.display();
                    }
                    break;
                case 3:
                    BestFit bestFit = new BestFit(partitions, processes);
                    bestFit.display();

                    System.out.println("Do you want to compact? 1.yes 2.no");
                    int compact2 = compacting.nextInt();
                    if(compact2==1){
                        Compaction compaction = new Compaction(bestFit.getPartitions());
                        compaction.display();
                    }

                    break;
            }
        }
    }
}

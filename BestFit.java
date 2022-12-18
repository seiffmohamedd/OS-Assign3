import java.util.LinkedList;

public class BestFit {

    private LinkedList <Partition> partitionList = new LinkedList<Partition>();

    private LinkedList <Process>   processesList = new LinkedList <Process>();

    private LinkedList <Process>   unallocatedProcesses = new LinkedList<Process>();



    private void goBest(){
        for (int i = 0; i < processesList.size(); i++) {

            Process process = processesList.get(i);
            int min = 1000000,idx = -1;

            for (int j = 0; j < partitionList.size(); j++) {

                Partition partition = partitionList.get(j);

                if( min > (partition.getSize() - process.getSize()) && (partition.getSize() - process.getSize()) >=0 && partition.isAvailable())
                {
                    min = partition.getSize() - process.getSize();
                    idx = j;
                }

            }

            if( idx == -1 )
            {
                unallocatedProcesses.add(process);
                continue;
            }
            else
            {
                Partition p =  partitionList.get(idx);

                p.setAvailable(false);
                p.setSize(process.getSize());
                p.setProcess(process);

                partitionList.set(idx,p);

                if(min > 0){

                    Partition.setCnt(Partition.getCnt()+1);

                    Partition newPart = new Partition(p.getName(),Partition.getCnt(),min);

                    partitionList.add(idx+1,newPart);
                }
            }

        }
    }

    public BestFit(final LinkedList<Partition> partitionList, final LinkedList<Process> processesList) {
        for (Partition partition:partitionList) {
            Partition tmp = new Partition(partition.getName(),partition.getId(),partition.getSize(),partition.isAvailable(),partition.getProcess());
            this.partitionList.add(tmp);
        }
        for (Process process:processesList) {
            Process tmp = new Process(process.getName(),process.getId(),process.getSize());
            this.processesList.add(tmp);
        }
//        for (Partition part: this.partitionList) {
//            System.out.println(part.getSize()+ " " + part.isAvailable());
//        }
        goBest();
    }
    public void display(){

        for (Partition p : this.partitionList) {
            if (!p.isAvailable()) {
                System.out.println(
                        p.getName() + " " + p.getId() + " (" + p.getSize() + ") => " +
                                p.getProcess().getName() + " " + p.getProcess().getId()
                );
            }
            else {
                System.out.println(
                        p.getName() + " " + p.getId() + " (" + p.getSize() + ") => External fragment"
                );
            }
        }

        for (Process process : unallocatedProcesses) {
            System.out.println(
                    process.getName() + " " + process.getId() + " can not be allocated"
            );
        }
    }

    public LinkedList<Partition> getPartitionList() {
        return partitionList;
    }

    public LinkedList<Process> getUnallocatedProcesses() {
        return unallocatedProcesses;
    }
}

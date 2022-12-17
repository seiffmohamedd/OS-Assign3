import java.util.LinkedList;

public class FirstFit {

    private LinkedList <Partition> partitionList = new LinkedList<Partition>();

    private LinkedList <Process>   processesList = new LinkedList<Process>();

    private LinkedList <Process>   unallocatedProcesses = new LinkedList<Process>();

    private void First(){

        for (int i = 0; i < processesList.size(); i++) {

            Process process = processesList.get(i);
            int sub = 0,idx = -1;

            for (int j = 0; j < partitionList.size(); j++) {

                Partition partition = partitionList.get(j);

                if((partition.getSize() >= process.getSize()) && partition.isAvailable())
                {
                    sub = partition.getSize() - process.getSize();
                    idx = j;
                    break;
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
                if(sub > 0){
                    Partition.setCnt(Partition.getCnt()+1);
                    Partition newPart = new Partition(p.getName(),Partition.getCnt(),sub);
                    partitionList.add(idx+1,newPart);
                }
            }
        }
    }

    public FirstFit(LinkedList<Partition> partitionList, LinkedList<Process> processesList) {
        this.partitionList = partitionList;
        this.processesList = processesList;
        First();
    }

    public void display(){

        for (Partition p : partitionList) {
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
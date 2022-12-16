import java.util.LinkedList;

public class BestFit {

    private LinkedList <Partition> partitionList = new LinkedList<Partition>();

    private LinkedList <Process>   processesList = new LinkedList<Process>();

    private void goBest(){
        for (int i = 0; i < processesList.size(); i++) {


            Process process = processesList.get(i);
            int min = 1000000,idx = 0;

            for (int j = 0; j < partitionList.size(); j++) {
                Partition partition = partitionList.get(j);
                if( min < partition.getSize() - process.getSize() && partition.getSize() - process.getSize() >=0 && partition.isAvailable()){
                    min = partition.getSize() - process.getSize();
                    idx = j;
                }
            }


        }
    }

    public BestFit(LinkedList<Partition> partitionList, LinkedList<Process> processesList) {
        this.partitionList = partitionList;
        this.processesList = processesList;
        goBest();
    }
    public void display(){

    }
}

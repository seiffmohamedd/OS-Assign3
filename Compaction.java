import java.util.LinkedList;

public class Compaction {
    private LinkedList<Partition> partitions = new LinkedList<Partition>();
    private LinkedList<Partition> compacted = new LinkedList<Partition>();
    private LinkedList<Process> unallocatedProcesses = new LinkedList<Process>();

    private void checkUnallocated() {
//        for (Partition part: this.compacted) {
//            System.out.println(part.getSize()+ " " + part.isAvailable());
//        }

        BestFit bestFit = new BestFit(compacted, unallocatedProcesses);
        bestFit.display();
    }

    public void letsCompact() {
        int compactedSize = 0;
        for (Partition partition : partitions) {
            if (partition.isAvailable()) {
                compactedSize += partition.getSize();
            } else {
                compacted.add(partition);
            }
        }
        Partition tmp = partitions.get(0);
        Partition.setCnt(Partition.getCnt() + 1);
        Partition remainingFragment = new Partition(tmp.getName(), Partition.getCnt(), compactedSize);
        compacted.add(remainingFragment);
        checkUnallocated();
    }

    public Compaction(BestFit bestFit) {
        this.partitions = bestFit.getPartitionList();
        this.unallocatedProcesses = bestFit.getUnallocatedProcesses();
    }
    public Compaction(WorstFit worstFit) {
        this.partitions = worstFit.getPartitionList();
        this.unallocatedProcesses = worstFit.getUnallocatedProcesses();
    }
    public Compaction(FirstFit firstFit) {
        this.partitions = firstFit.getPartitionList();
        this.unallocatedProcesses = firstFit.getUnallocatedProcesses();
    }


}

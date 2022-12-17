import javax.lang.model.type.NullType;
import java.util.regex.Pattern;

public class Partition {
    private static int cnt = 0;
    private String name;
    private int id;
    private int size;
    private boolean available;
    private Process process;


    public Partition(String n, int ID, int elSize){
        this.name = n;
        this.id = ID;
        this.size = elSize;
        this.available = true;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getSize() {
        return size;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public static void setCnt(int cnt) {
        Partition.cnt = cnt;
    }

    public Process getProcess() {
        return process;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

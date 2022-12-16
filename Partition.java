import java.util.regex.Pattern;

public class Partition {
    private static int cnt = 0;
    private String name;
    private int id;
    private int size;
    private boolean available = true;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public boolean isAvailable() {
        return available;
    }

    public Partition(String n, int ID, int elSize){
        this.name = n;
        this.id = ID;
        this.size = elSize;
        cnt++;
    }

}

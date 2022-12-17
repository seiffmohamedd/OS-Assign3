public class Process {
    private String name;
    private int id;
    private int size;


    public Process(String n , int ID,int elSizeee){
        this.name = n;
        this.id = ID;
        this.size = elSizeee;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }
}

package uni;
import java.util.ArrayList;

public class Major {
    private static int idCounter = 0;
    private int id;
    private String name;
    private final int capacity;
    private int numberOfStudents = 0;
    private static ArrayList<Major> majorList = new ArrayList<>();

    public Major(String name, int capacity) {
        this.id = idCounter++;
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addStudent() {
        if (numberOfStudents < capacity) {
            numberOfStudents++;
        } else {
            System.out.println("ظرفیت رشته " + name + " تکمیل شده است.");
        }
    }

    public static Major findByID(int id) {
        for (Major major : majorList) {
            if (major.getId() == id) {
                return major;
            }
        }
        return null;
    }
}
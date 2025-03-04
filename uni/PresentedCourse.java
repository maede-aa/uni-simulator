package uni;
import java.util.ArrayList;

public class PresentedCourse {
    private static int idCounter = 1;
    private int id;
    private int courseID;
    private int professorID;
    private int capacity;
    private ArrayList<Integer> studentIds = new ArrayList<>();
    private static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.id = idCounter++;
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        presentedCourseList.add(this);
    }

    public int getId() {
        return id;
    }

    public int getCourseID() {
        return courseID;
    }

    public void addStudent(int studentID) {
        if (studentIds.size() < capacity) {
            studentIds.add(studentID);
        } else {
            System.out.println("ظرفیت درس پر شده است.");
        }
    }

    public static PresentedCourse findByID(int id) {
        for (PresentedCourse pc : presentedCourseList) {
            if (pc.getId() == id) {
                return pc;
            }
        }
        return null;
    }
}
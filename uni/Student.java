package uni;
import java.util.ArrayList;

public class Student {
    private static int idCounter = 1;
    private int id;
    private int personID;
    private final int entranceYear;
    private int majorID;
    private String studentID;
    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int personID, int entranceYear, int majorID) {
        this.id = idCounter++;
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        this.studentID = generateStudentID();
        studentList.add(this);

        Major major = Major.findByID(majorID);
        if (major != null) {
            major.addStudent();
        }
    }

    private String generateStudentID() {
        Major major = Major.findByID(majorID);
        if (major != null) {
            return entranceYear + String.format("%02d", major.getId()) + String.format("%03d", id);
        } else {
            return entranceYear + String.format("%04d", id);
        }
    }

    public int getId() {
        return id;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getMajorID() {
        return majorID;
    }

    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
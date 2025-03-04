package uni;
import java.util.ArrayList;

public class Professor {
    private static int idCounter = 1;
    private int id;
    private int personID;
    private int majorID;
    private static ArrayList<Professor> professorList = new ArrayList<>();

    public Professor(int personID, int majorID) {
        this.id = idCounter++;
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public int getId() {
        return id;
    }

    public int getPersonID() {
        return personID;
    }

    public int getMajorID() {
        return majorID;
    }

    public static ArrayList<Professor> getProfessorList() {
        return professorList;
    }

    public static Professor findByID(int id) {
        for (Professor p : professorList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
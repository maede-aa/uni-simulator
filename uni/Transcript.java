package uni;
import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<Grade> grades = new ArrayList<>();
    private static ArrayList<Transcript> transcriptList = new ArrayList<>();

    private static class Grade {
        private int presentedCourseID;
        private double grade;

        public Grade(int presentedCourseID, double grade) {
            this.presentedCourseID = presentedCourseID;
            this.grade = grade;
        }

        public int getPresentedCourseID() {
            return presentedCourseID;
        }

        public double getGrade() {
            return grade;
        }
    }

    public Transcript(int studentID) {
        this.studentID = studentID;
        transcriptList.add(this);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        grades.add(new Grade(presentedCourseID, grade));
    }

    public void printTranscript() {
        System.out.println("کارنامه دانشجو " + studentID);
        for (Grade grade : grades) {
            PresentedCourse presentedCourse = PresentedCourse.findByID(grade.getPresentedCourseID());
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.getCourseID());
                if (course != null) {
                    System.out.println("درس " + course.getTitle() + " - نمره: " + grade.getGrade());
                }
            }
        }
    }

    public Double getGPA() {
        if (grades.isEmpty()) return 0.0;
        double totalGradePoints = 0;
        int totalUnits = 0;

        for (Grade grade : grades) {
            PresentedCourse presentedCourse = PresentedCourse.findByID(grade.getPresentedCourseID());
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.getCourseID());
                if (course != null) {
                    totalGradePoints += grade.getGrade() * course.getUnits();
                    totalUnits += course.getUnits();
                }
            }
        }

        if (totalUnits == 0) return 0.0;
        return Math.round((totalGradePoints / totalUnits) * 100.0) / 100.0;
    }

    public static Transcript findByStudentId(int studentId) {
        for (Transcript transcript : transcriptList) {
            if (transcript.getStudentID() == studentId) {
                return transcript;
            }
        }
        return null;
    }
}
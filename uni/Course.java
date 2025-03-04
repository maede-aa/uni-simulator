package uni;
import java.util.ArrayList;

public class Course {


        private static int idCounter = 1;
        private int id;
        private String title;
        private int units;
        private static ArrayList<Course> courseList = new ArrayList<>();

        public Course(String title, int units) {
            this.id = idCounter++;
            this.title = title;
            this.units = units;
            courseList.add(this);
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getUnits() {
            return units;
        }

        public static Course findByID(int id) {
            for (Course course : courseList) {
                if (course.getId() == id) {
                    return course;
                }
            }
            return null;
        }
    }
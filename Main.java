import uni.*;
import base.*;

public class Main {
    public static void main(String[] args) {

        Major major1 = new Major("علوم کامپیوتر", 50);
        Major major2 = new Major("ریاضی", 40);

        Person[] people = {
                new Person("کلثوم شب امتحانی", "2284763315"),
                new Person("اصغر پاس نشدنی", "6577846913"),
                new Person("قلی حذف ترمی", "234843196"),
                new Person("پروفسور سختگیران", "3451458697"),
                new Person("دکتر امتحان زاده", "6114635744")
        };

        Student[] students = {
                new Student(people[0].getId(), 1400, major1.getId()),
                new Student(people[1].getId(), 1401, major1.getId()),
                new Student(people[2].getId(), 1402, major2.getId())
        };

        System.out.println("اطلاعات دانشجوها:");
        for (Student student : students) {
            Person person = Person.findByID(student.getId());
            Major major = Major.findByID(student.getMajorID());
            System.out.println("دانشجو: " + person.getName() +
                    " - شماره دانشجویی: " + student.getStudentID() +
                    " - رشته تحصیلی: " + major.getName());
        }

        Professor[] professors = {
                new Professor(people[3].getId(), major1.getId()),
                new Professor(people[4].getId(), major2.getId())
        };

        System.out.println("\nاطلاعات اساتید:");
        for (Professor professor : professors) {
            Person person = Person.findByID(professor.getPersonID());
            Major major = Major.findByID(professor.getMajorID());
            if (person != null && major != null) {
                System.out.println("استاد: " + person.getName() +
                        " - رشته: " + major.getName());
            } else {
                System.out.println("اطلاعات استاد یا رشته نامشخص است !");
            }
        }

        Course[] courses = {
                new Course("برنامه‌نویسی پیشرفته", 3),
                new Course("پایگاه داده", 3),
                new Course("بهینه سازی خطی", 4)
        };

        PresentedCourse[] presentedCourses = {
                new PresentedCourse(courses[0].getId(), professors[0].getId(), 30),
                new PresentedCourse(courses[1].getId(), professors[0].getId(), 25),
                new PresentedCourse(courses[2].getId(), professors[1].getId(), 48)
        };

        presentedCourses[0].addStudent(students[0].getId());
        presentedCourses[0].addStudent(students[1].getId());
        presentedCourses[1].addStudent(students[0].getId());
        presentedCourses[1].addStudent(students[1].getId());
        presentedCourses[1].addStudent(students[2].getId());
        presentedCourses[2].addStudent(students[2].getId());

        Transcript[] transcripts = {
                new Transcript(students[0].getId()),
                new Transcript(students[1].getId()),
                new Transcript(students[2].getId())
        };

        transcripts[0].setGrade(presentedCourses[0].getId(), 18.5);
        transcripts[0].setGrade(presentedCourses[1].getId(), 16.0);
        transcripts[1].setGrade(presentedCourses[0].getId(), 17.0);
        transcripts[1].setGrade(presentedCourses[1].getId(), 19.0);
        transcripts[2].setGrade(presentedCourses[1].getId(), 15.5);
        transcripts[2].setGrade(presentedCourses[2].getId(), 20.0);

        System.out.println("\nکارنامه دانشجوها:");
        for (Transcript transcript : transcripts) {
            Student student = Student.findByID(transcript.getStudentID());
            Person person = Person.findByID(student.getId());
            System.out.println("\nدانشجو: " + person.getName());
            System.out.println("شماره دانشجویی: " + student.getStudentID());
            transcript.printTranscript();
            System.out.println("معدل: " + transcript.getGPA());
            System.out.println("-------------------------");
        }
    }
}
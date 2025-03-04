package base;
import java.util.ArrayList;

public class Person {

        private static int idCounter = 1;
        private int id;
        private String name;
        private String nationalID;
        private static ArrayList<Person> personList = new ArrayList<>();

        public Person(String name, String nationalID) {
            this.id = idCounter++;
            this.name = name;
            this.nationalID = nationalID;
            personList.add(this);
        }

        public int getId() { return id; }

        public String getName() { return name; }

        public String getNationalID() { return nationalID; }

        public static ArrayList<Person> getPersonList() {
            return personList;
        }

        public static Person findByID(int id) {
            for (Person p : personList) {
                if (p.getId() == id)
                    return p;
            }
            return null;
        }
    }

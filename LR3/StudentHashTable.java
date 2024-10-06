import java.util.HashMap;

class Student {
    private String name;
    private String surname;
    private int age;
    private double gpa;

    public Student(String name, String surname, int age, double gpa) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }
}

public class StudentHashTable {

    private HashMap<String, Student> studentMap;

    public StudentHashTable() {
        studentMap = new HashMap<>();
    }

    public void insertStudent(String studentID, Student student) {
        studentMap.put(studentID, student);
    }

    public Student searchStudent(String studentID) {
        return studentMap.get(studentID);
    }

    public void deleteStudent(String studentID) {
        studentMap.remove(studentID);
    }

    public static void main(String[] args) {
        StudentHashTable studentHashTable = new StudentHashTable();

        studentHashTable.insertStudent("23301", new Student("Артур", "Авзалов", 19, 3.5));
        studentHashTable.insertStudent("23302", new Student("Кирилл", "Долда", 19, 4.4));
        studentHashTable.insertStudent("23303", new Student("Андрей", "Каменский", 19, 3.9));
        studentHashTable.insertStudent("23304", new Student("Виктория", "Казанцева", 19, 4.8));
        studentHashTable.insertStudent("23305", new Student("Ирина", "Антонова", 20, 4.2));
        studentHashTable.insertStudent("23306", new Student("Егор", "Антонов", 19, 5.0));
        studentHashTable.insertStudent("23307", new Student("Николай", "Бакулин", 20, 4.4));
        studentHashTable.insertStudent("23308", new Student("Сергей", "Возжин", 19, 3.8));
        studentHashTable.insertStudent("23309", new Student("Владислав", "Юртаев", 19, 4.3));

        System.out.println("Найти студента с ID 23301:");
        Student student = studentHashTable.searchStudent("23301");
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Студент не найден.");
        }

        System.out.println("\nУдаление студента с ID 23301.");
        studentHashTable.deleteStudent("23301");

        System.out.println("\nПоиск студента с ID 23301:");
        student = studentHashTable.searchStudent("23301");
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Студент не найден.");
        }
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Etudiant> students = new ArrayList<>();
        StudentManagement management = new StudentManagement();

        students.add(new Etudiant(1, "Ali", 20));
        students.add(new Etudiant(2, "Amira", 22));
        students.add(new Etudiant(3, "Sami", 21));
        students.add(new Etudiant(4, "Nour", 23));

        System.out.println("Liste des étudiants :");
        management.displayStudents(students, System.out::println);

        System.out.println("\nÉtudiants âgés de plus de 21 ans :");
        management.displayStudentsByFilter(students, e -> e.getAge() > 21, System.out::println);

        String names = management.returnStudentsNames(students, Etudiant::getNom);
        System.out.println("\nNoms des étudiants : " + names);

        Etudiant newStudent = management.createStudent(() -> new Etudiant(5, "Sara", 24));
        students.add(newStudent);

        System.out.println("\nÉtudiants triés par ID :");
        List<Etudiant> sortedById = management.sortStudentsById(students, Comparator.comparingInt(Etudiant::getId));
        sortedById.forEach(System.out::println);

        System.out.println("\nUtilisation du stream pour afficher les étudiants :");
        management.convertToStream(students).forEach(System.out::println);
    }
}

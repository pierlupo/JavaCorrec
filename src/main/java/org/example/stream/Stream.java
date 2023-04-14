package org.example.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {
    public static void main() {
        // Create Teachers
        Teacher teacher1 = new Teacher(1, "John Doe", "Mathematics", 2010);
        Teacher teacher2 = new Teacher(2, "Jane Smith", "Physics", 2015);
        Teacher teacher3 = new Teacher(3, "Michael Johnson", "Chemistry", 2005);
        Teacher teacher4 = new Teacher(4, "Michel Papin", "Informatique", 2003);

        // Create Courses
        Course course1 = new Course(1, "Calculus", teacher1, 15);
        Course course2 = new Course(2, "Mechanics", teacher2, 10);
        Course course3 = new Course(3, "Organic Chemistry", teacher3, 12);
        Course course4 = new Course(3, "Java", teacher4, 12);

        // Create Students
        Student student1 = new Student(1, "Alice", 18);
        Student student2 = new Student(2, "Bob", 20);
        Student student3 = new Student(3, "Charlie", 19);
        Student student4 = new Student(4, "David", 21);
        Student student5 = new Student(5, "Eve", 22);

        // Assign Courses to Students
        student1.addCourse(course1);
        student1.addCourse(course2);


        student2.addCourse(course3);
        student2.addCourse(course1);


        student3.addCourse(course4);
        student3.addCourse(course3);
        student3.addCourse(course1);

        student4.addCourse(course3);
        student4.addCourse(course1);
        student4.addCourse(course2);
        student4.addCourse(course4);

        student5.addCourse(course1);
        student5.addCourse(course3);
        student5.addCourse(course2);

        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));
        List<Teacher> teachers = new ArrayList<>(Arrays.asList(teacher1, teacher2, teacher3, teacher4));
        List<Course> courses = new ArrayList<>(Arrays.asList(course1, course2, course3, course4));


//        1 -Sélectionner les Student qui ont un âge supérieur à 20ans ?


        List<Student> studentsOver18 = students.stream()
                .filter(s -> s.getAge() > 20)
                .collect(Collectors.toList());


//        2 -Transformer les Teacher en une liste de leurs noms ?

        List<String> teacherNames = teachers.stream()
                .map(Teacher::getName)
                .collect(Collectors.toList());


//        3 -Transformer les Teacher en une liste de leurs matières enseignées ?
        List<Teacher> allTeachers = courses.stream()
                .map(c -> c.getTeacher())
                .collect(Collectors.toList());

//        4 –Donnez-moi la liste des teachers en passant par les courses?

        List<Teacher> allTeachersByCourses = courses.stream()
                .map(c -> c.getTeacher())
                .collect(Collectors.toList());

//        5 -Calculer la somme de toutes les durées des cours ?

        int totalDuration = courses.stream()
                .mapToInt(Course::getDuration)
                .reduce(0, Integer::sum);

//        6 -Sélectionner les cours avec une durée supérieure à 11 heures, puis récupérer une liste de leurs noms triée par ordre alphabétique ?

        List<String> longCourseNames = courses.stream()
                .filter(c -> c.getDuration() > 11)
                .map(Course::getName)
                .sorted()
                .collect(Collectors.toList());

//        7 -Regrouper les Student par âge, puis afficher le nombre d'étudiants dans chaque groupe ?
        Map<Integer, Long> studentsByAge = students.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        studentsByAge.forEach((age, count) -> System.out.println("Age " + age + " : " + count + " students"));


//        8 –En passant parStudent, il faut récupérer une liste de Course et il faut garder les doublons.

        List<Course> allCourses = students.stream()
                .flatMap(s -> s.getCourses().stream())
                .collect(Collectors.toList());


//        9 -Regrouper les Teacher par année d'entrée en fonction, puis afficher le nombre d'enseignants dans chaque groupe ?(vous pouvez utiliser une collection comme map pour récupérer le resultat).

        Map<Integer, Long> teachersByYear = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getStartDate, Collectors.counting()));
        teachersByYear.forEach((year, count) -> System.out.println("Year " + year + " : " + count + " teachers"));


//        10 -Sélectionner les Student avec un âge compris entre 18 et 20ans, puis récupérer une liste de leurs Course triée par ordre alphabétique ?
        List<Course> selectedCourses = students.stream()
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 20)
                .flatMap(s -> s.getCourses().stream())
                .sorted(Comparator.comparing(Course::getName))
                .distinct()
                .collect(Collectors.toList());

//        11 -Compter le nombre d'étudiants dans chaque cours, puis récupérer une Map associant chaque Course à son nombre d'étudiants ?
        Map<Course, Long> studentsByCourse = students.stream()
                .flatMap(s -> s.getCourses().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


//        12 -Quel est le nombre moyen de cours suivis par les étudiants de plus de 20ans ?
        double avgCoursesForStudentsOver25 = students.stream()
                .filter(s -> s.getAge() > 25)
                .flatMap(s -> s.getCourses().stream())
                .distinct()
                .count() / (double) students.stream()
                .filter(s -> s.getAge() > 25)
                .count();

//        13 -Quels sont les noms des étudiants qui ont suivi tous les cours ?
        List<String> studentsWhoTookAllCourses = students.stream()
                .filter(s -> s.getCourses().size() == courses.size())
                .map(Student::getName)
                .collect(Collectors.toList());


    }

}

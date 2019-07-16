package exam;

import java.util.*;
import java.util.function.Consumer;

public class Practice6 {
    //    Дан список студентов.
    // Элемент списка содержит фамилию, имя, отчество, год рождения, курс, номер группы, оценки по пяти предметам.
    static List<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();
        students.add(new Student("Ivan", "Ivanov", "Ivanovich", 1995, 5, 108, new int[]{3, 2, 4, 5, 5}));
        students.add(new Student("Perto", "Petrov", "Petrovich", 1994, 3, 108, new int[]{3, 3, 4, 5, 5}));
        students.add(new Student("Roman", "Romanov", "Romanovich", 1992, 2, 209, new int[]{3, 2, 4, 3, 5}));

        // Упорядочите студентов по курсу, причем студенты одного курса располагались в алфавитном порядке.
        Collections.sort(students, new StudentsByCourceAndNameAscComparator());
        printStudents();


        // Определите самого старшего студента и самого младшего студентов.
        Collections.sort(students, new StudentsByYearAscComparator());
        System.out.println(students.get(students.size()));
        System.out.println(students.get(0));

        // Для каждой группы найдите лучшего с точки зрения успеваемости студента.
        for (Student st : students) {
            System.out.println(st);
        }
        // Найдите средний балл каждой группы по каждому предмету.

        Spliterator<Student> groups = new StudentsByGroupSpliterator().trySplit();

    }

    public static void printStudents() {
        for (Student st : students) {
            System.out.println(st);
        }
    }
}

class Student {
    public Student(String firstName, String lastName, String surName, int yearOfBirth, int cource, int group, int[] marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.yearOfBirth = yearOfBirth;
        this.cource = cource;
        this.group = group;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", yearOfBirth=" + getYearOfBirth() +
                ", cource=" + getCource() +
                ", group=" + getGroup() +
                ", marks=" + Arrays.toString(getMarks()) +
                '}';
    }

    private String firstName;
    private String lastName;
    private String surName;
    private int yearOfBirth;
    private int cource;
    private int group;
    private int[] marks;

    public String getFullName() {
        return getFirstName() + " " + getLastName() + " " + getSurName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getCource() {
        return cource;
    }

    public int getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }

    public int getMark(int markNumber) {
        return getMarks()[markNumber];
    }

    public int getMarksSum() {
        int sum = 0;
        for(int mark : marks) {
            sum+= mark;
        }
        return sum;
    }


}

class StudentsByCourceAndNameAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (Integer.compare(o1.getCource(), o2.getCource()) != 0) {
            return Integer.compare(o1.getCource(), o2.getCource());
        } else {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }
}

class StudentsByYearAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
    }
}

class StudentsByGroupSpliterator implements Spliterator<Student> {

    @Override
    public boolean tryAdvance(Consumer<? super Student> action) {
        return false;
    }

    @Override
    public Spliterator<Student> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}

class StudentsByMarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getMarksSum(), o2.getMarksSum());
    }
}
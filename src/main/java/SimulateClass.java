import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class SimulateClass {
    private static List<Student> students, studentsRo16, studentsRo17, studentsRo18, studentsRo19;
    private static List<Trainer> trainers;
    private static List<StudentsClass> studentClasses;
    private static Trainer trainer1, trainer2, trainer3;
    //private static List<StudentsClass> maxClassList;

    //////////varArgs
    private static String getLongestString(String... longestStringArray) {
        String auxString = "";
        for (String element : longestStringArray) {
            if (element.length() > auxString.length()) {
                auxString = element;
            }
        }
        return auxString;
    }

    public static void main(String[] args) {
        createClassHierarchy();
        //System.out.println("--------Trainers list--------");
        //printTrainers();

        //System.out.println("--------Students list--------");
        //printStudents();
        printStudentsClassList();                                     //groups
        //printMaxNoOfStudentsFromClass_classicMethod();                // first class with max number of students
        getAllClassNamesWithMaxNoOfStudents_classicMethod(studentClasses);        // class names with max number of students


        System.out.println("----- Clasele cu nr maxim de studenti: ---- Classic method---");
        for (StudentsClass element : getAllClassNamesWithMaxNoOfStudents_classicMethod(studentClasses)) {
            System.out.println("   " + element.getStudentClassName());
        }

        //printStudentsAlphabetically_LastNames();                      // sorted last names
        //printStudentsAlphabetically_FirstNames();                      // sorted first names
        //displayStudentsYougerThan(25);                                // students younger than integer years
        //displayStudentsgroupedByTrainer();
        displayAllStudentsWithPreviousJavaKnowledge();
        //displayMaxGroupWithoutPreviousJavaKnolede();
        //removeStudentsYoungerThanFromGroups(25);

        System.out.println("Triplu: "
                + tripleNumberOfStudentFromMaxGroup(getAllClassNamesWithMaxNoOfStudents_classicMethod(studentClasses)));

        System.out.println(getLongestString("Trainer1999", "Trainer12", "Trainer99999"));
        System.out.println(getLongestString("Trainer1999"));
        System.out.println(getLongestString());

    }

    //Display all students grouped by a trainer that teaches to them
    private static void displayStudentsgroupedByTrainer() {
        System.out.println("-----------Display all students grouped by a trainer------------");
        for (Trainer trainer : trainers) {
            System.out.println("\n" + trainer.getFirstName() + " has the following students: ");
            for (StudentsClass studentsClass : studentClasses) {
                if (trainer.equals(studentsClass.getTrainer())) {
                    System.out.println("* " + studentsClass.getStudentClassName() + " *");

                    for (Student student : studentsClass.getStudentList()) {
                        System.out.println(" -> " + student.getFirstName() + " " + student.getLastName());
                    }
                }
            }
        }
    }

    //Display all students with previous java knowledge
    private static void displayAllStudentsWithPreviousJavaKnowledge() {
        System.out.println("-----------Students with previous java knowledge------------");
        students.stream()
                .filter(student -> student != null && student.hasPreviousJavaKnowledge)
                //.filter(student -> method1() & method2()) //chiar daca prima returneaza false se executa a doua cu "&"
                .forEach(System.out::println);
    }

    //Display all students younger than 25, from all groups
    private static List<Student> displayStudentsYougerThan(int age) {
        //System.out.println("--------Student's lista younger than " + age);
        return students.stream()
                .filter(student -> Period.between(student.getDateOfBirth(), LocalDate.now()).getYears() < age)
                //.forEach(student -> System.out.println(student));
                .collect(Collectors.toList());
    }

    //Collect all students younger than 25, from all groups
    private static List<String> collectStudentsNamesYougerThan(int age) {
        return students.stream()
                .filter(student -> student.getAge() < age)
                .map(student -> student.getFirstName())
                .collect(Collectors.toList());
    }

    //Display all students in a group sorted alphabetically by lastName
    private static void printStudentsAlphabetically_LastNames() {                  // last names sorted
        System.out.println("---Display student's list alphabetically for last Names----------");
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(System.out::println);
    }

    private static void printStudentsAlphabetically_FirstNames() {
        System.out.println("----Display student's list alphabetically by first Names----");
        students.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(System.out::println);

    }

    //Display the group with the highest number of students with no previous java knowledge
    public static void displayMaxGroupWithoutPreviousJavaKnolede() {
        System.out.println("---Class with maximum number of Students with no previous java knowledge---");
        System.out.println(
                studentClasses.stream()
                        .max(Comparator.comparing(maxClass -> maxClass.getStudentList().stream()
                                .filter(student -> !student.isHasPreviousJavaKnowledge()).count()))
                        .get().toString()
        );

        //incercati sa faceti dintr-o singura iteratie verifici lista din grup, si updatezi lista
        //daca gasesti o lista mai mare cu studenti fara cunostinte
    }

    //Remove all the students younger than 20 from all groups
    private static void removeStudentsYoungerThanFromGroups(int age) {
        System.out.println("\n------Remove all the students younger than " + age + "\n");

        for (StudentsClass studentsClass : studentClasses) {
            List<Student> auxStudentList = new LinkedList<>();
            for (Student student : studentsClass.getStudentList()) {
                if (student.getAge() >= age) {
                    auxStudentList.add(student);
                }
            }
            studentsClass.setStudentList(auxStudentList);
        }
        System.out.print("Java classes after removing students younger than" + age + " years: " + studentClasses);
    }

    //Display the group with the maximum number of students
    private static void printMaxNoOfStudentsFromClass_classicMethod() { ////classic method

        System.out.println("---Clasele cu nr maxim de studenti------Classic method---");
        StudentsClass maxSizeClass = new StudentsClass(null, new LinkedList<>(), null);

        for (StudentsClass studentClass : studentClasses) {
            if (studentClass.getStudentList().size() > maxSizeClass.getStudentList().size()) {
                maxSizeClass = studentClass;
            }
        }
        System.out.println("Max class size is: " + maxSizeClass.getStudentClassName());
        System.out.println(maxSizeClass);
    }

    public static List<StudentsClass> getAllClassNamesWithMaxNoOfStudents_classicMethod(List<StudentsClass> groupList) {
        System.out.println("--Display all groups with maximum students number -----");
        List<StudentsClass> maxClassList = new ArrayList<>();
        StudentsClass maxClass = new StudentsClass(null, new LinkedList<>(), null);
        //set retine elemente neduplicate - Linked - ordinea insertiei
        //list retine si elemente duplicate
        //pt ordine alfabetica folosim -------- treeSet

        for (StudentsClass element : groupList) {
            if (element.getStudentList().size() > maxClass.getStudentList().size()) {
                maxClass = element;
                maxClassList = new ArrayList<>();
                maxClassList.add(element);

            } else if (element.getStudentList().size() == maxClass.getStudentList().size()) {
                maxClassList.add(element);
            }
        }
        return maxClassList;
    }

    // multiplicarea numarului de studenti din toate grupele din maxGroup
    private static int multiplyingNumberOfStudentFromMaxGroup(int multiplier, List<StudentsClass> maxClassList) {
        return maxClassList.size() * maxClassList.get(0).getStudentList().size() * multiplier;
    }

    private static int tripleNumberOfStudentFromMaxGroup(List<StudentsClass> maxClassList) {
        return multiplyingNumberOfStudentFromMaxGroup(3, maxClassList);
    }


    private static void printStudents() {
        System.out.println(students);
    }

    private static void printTrainers() {
        System.out.println(trainers);
    }

    private static void printStudentsClassList() {
        System.out.println(studentClasses);
    }


    /**
     * name and populate classes with students and trainers
     */

    private static void addStudents() {
        Student student01 = new Student("AAA", "xxx", LocalDate.of(1980, Month.DECEMBER, 31), false);
        Student student02 = new Student("XXX", "aaa", LocalDate.of(1980, Month.DECEMBER, 31), true);
        Student student03 = new Student("BBB", "bbb", LocalDate.of(1982, Month.DECEMBER, 31), false);
        Student student04 = new Student("CCC", "ccc", LocalDate.of(1985, Month.DECEMBER, 31), false);
        Student student05 = new Student("DDD", "ddd", LocalDate.of(1990, Month.DECEMBER, 31), false);
        Student student06 = new Student("EEE", "eee", LocalDate.of(1981, Month.DECEMBER, 31), false);
        Student student07 = new Student("FFF", "fff", LocalDate.of(1992, Month.DECEMBER, 31), false);
        Student student08 = new Student("GGG", "ggg", LocalDate.of(1995, Month.DECEMBER, 31), false);
        Student student09 = new Student("HHH", "hhh", LocalDate.of(2000, Month.DECEMBER, 31), false);
        Student student10 = new Student("III", "iii", LocalDate.of(2001, Month.DECEMBER, 31), false);
        Student student11 = new Student("JJJ", "jjj", LocalDate.of(1979, Month.DECEMBER, 31), false);
        Student student12 = new Student("KKK", "kkk", LocalDate.of(1989, Month.DECEMBER, 31), false);
        Student student13 = new Student("LLL", "lll", LocalDate.of(1996, Month.MARCH, 22), true);
        Student student14 = new Student("MMM", "mmm", LocalDate.of(1994, Month.DECEMBER, 31), false);
        Student student15 = new Student("NNN", "nnn", LocalDate.of(2002, Month.DECEMBER, 31), false);

        students = Arrays.asList(student11, student02, student03, student04, student05, student06, student07, student08, student09, student10, student01, student12, student13, student14, student15);
        studentsRo16 = Arrays.asList(student01, student02, student03, student04, student07);
        studentsRo17 = Arrays.asList(student08, student09);
        studentsRo18 = Arrays.asList(student10, student11, student12);
        studentsRo19 = Arrays.asList(student13, student14, student15, student05, student06);
    }

    private static void addTrainers() {
        trainer1 = new Trainer("Trainer1", "xxx", LocalDate.of(1980, Month.DECEMBER, 31), true);
        trainer2 = new Trainer("Trainer2", "yyy", LocalDate.of(1980, Month.DECEMBER, 31), true);
        trainer3 = new Trainer("Trainer3", "www", LocalDate.of(1980, Month.DECEMBER, 31), true);

        trainers = Arrays.asList(trainer1, trainer2, trainer3);
    }

    private static void addClasses() {
        StudentsClass ro16 = new StudentsClass(trainer1, studentsRo16, "Class_RO16");
        StudentsClass ro17 = new StudentsClass(trainer3, studentsRo17, "Class_RO17");
        StudentsClass ro18 = new StudentsClass(trainer2, studentsRo18, "Class_RO18");
        StudentsClass ro19 = new StudentsClass(trainer3, studentsRo19, "Class_RO19");

        studentClasses = Arrays.asList(ro16, ro17, ro18, ro19);
    }

    private static void createClassHierarchy() {
        addStudents();
        addTrainers();
        addClasses();
    }
}

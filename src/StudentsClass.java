import java.util.List;

public class StudentsClass {
    private Trainer trainer;
    private List<Student> studentList;
    private final String studentClassName; //final ca sa nu mai poata fi modificata dupa initializare

    public StudentsClass(Trainer trainer, List<Student> studentList, String studentClassName) {
        this.trainer = trainer;
        if (studentList.size() <= 5) {
            this.studentList = studentList;
        } else{
            throw new MaximumNumberOfStudentsReached("Students limit exceeded");
        }
        this.studentClassName = studentClassName;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Trainer getTrainer() {
        return trainer;
    }


    @Override
    public String toString() {
        return "StudentsClass{" +
                "trainer=" + trainer +
                ", studentList=" + studentList +
                ", className='" + studentClassName + '\'' +
                '}';
    }
}

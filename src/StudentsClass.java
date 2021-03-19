import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class StudentsClass {
    private Trainer trainer;
    private List<Student> studentList;
    public String className;

    public StudentsClass(Trainer trainer, List<Student> studentList, String className) {

        this.trainer = trainer;
        if (studentList.size() <= 5) {
            this.studentList = studentList;
        } else{

            throw new MaximumNumberOfStudentsReached("Students limit exceeded");
        }
        this.className = className;
    }

    /*public StudentsClass(Object trainer, LinkedHashSet<Object> objects) {
    }*/

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getClassName() {
        return className;
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
                ", className='" + className + '\'' +
                '}';
    }
}

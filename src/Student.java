import java.time.LocalDate;
import java.time.Period;

public class Student extends Person {
    boolean hasPreviousJavaKnowledge;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public String getLastName(){
        return super.getLastName();
    }

    public String getFirstName(){
        return super.getFirstName();
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }

    public int getAge(){
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    public LocalDate getDateOfBirth(){
        return super.getDateOfBirth();
    }

    public void setHasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    @Override
    public String toString() {
        return "\n    Student: " + super.toString() + " - HasPreviousJavaKnowledge: " + hasPreviousJavaKnowledge;
    }
}

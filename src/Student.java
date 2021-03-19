import java.time.LocalDate;

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
        return LocalDate.now().getYear() - super.getDateOfBirth().getYear();
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

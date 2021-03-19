import java.time.LocalDate;

public class Trainer extends Person {
    boolean isAuthorized;

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth, boolean isAuthorized) {
        super(firstName, lastName, dateOfBirth);
        this.isAuthorized = isAuthorized;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    @Override
    public String toString() {
        return "Trainer{" + super.toString()+
                " isAuthorized=" + isAuthorized +
                '}';
    }
}

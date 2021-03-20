import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimulateClassTest {

    @Test
    void getAllClassNamesWithMaxNoOfStudents_classicMethod(){
        //Given
        List<StudentsClass> groups= new ArrayList<>();
        Student student01 = new Student("AAA", "xxx", LocalDate.of(1980, Month.DECEMBER, 31), false);
        Student student02 = new Student("XXX", "aaa", LocalDate.of(1980, Month.DECEMBER, 31), true);

        List<Student> students = new LinkedList<>();
        students.add(student01);
        students.add(student02);

        StudentsClass ro16 = new StudentsClass(null, students, "Class_RO16");
        StudentsClass ro17 = new StudentsClass(null, students, "Class_RO17");

        groups.add(ro16);
        groups.add(ro17);

        //When
        //SimulateClass.getAllClassNamesWithMaxNoOfStudents_classicMethod(groups);
                //daca avem o metoda statica o apelam pe numele clasei
        //Then
        assertEquals(2,SimulateClass.getAllClassNamesWithMaxNoOfStudents_classicMethod(groups).size());

    }
}

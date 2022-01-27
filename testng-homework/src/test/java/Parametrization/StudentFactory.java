package Parametrization;
import org.testng.annotations.Factory;
public class StudentFactory {
    @Factory
    public Object[] doRegistrationUsingFactory() {
        return new Object[] {
                new FillStudentRegForm("firstName1","lastName1","Male","123123123"),
                new FillStudentRegForm("firstName2","lastName2","Female","456456456"),
                new FillStudentRegForm("firstName3","lastName3","Other","789789789")
        };
    }
}
package ex42;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testFileRead() throws IOException
    {
        String inputFile = "src/main/java/ex42/exercise42_input.txt";

        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        employeeList = App.readFile(employeeList, inputFile);

        String[] lastNameTest = {"Ling", "Johnson", "Jones", "Jones", "Swift", "Xiong", "Zarnecki"};
        int[] salaryTest = {55900, 56500, 46000, 34500, 14200, 65000, 51500};

        testEmployeeInfo(employeeList, lastNameTest, salaryTest);
    }

    public void testEmployeeInfo(ArrayList<Employee> employeeList, String[] lastName, int[] salary)
    {
        int i = 0;
        int j = 0;

        for(Employee element : employeeList)
        {
            assertEquals(lastName[i++], element.getLast());
            assertEquals(salary[j++], element.getSalary());
        }
    }
}
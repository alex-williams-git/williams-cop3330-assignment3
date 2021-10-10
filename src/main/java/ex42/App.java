/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex42;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException
    {
        // store input file path
        String inputFile = "src/main/java/ex41/exercise42_input.txt";

        // create arrayList to hold employees
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        // read employees into arrayList
        employeeList = readFile(employeeList, inputFile);

        // store output file path
        String outputFile = "src/main/java/ex41/exercise42_output.txt";

        // write employees into text file
        writeFile(employeeList, outputFile);
    }

    // read function
    public static ArrayList<Employee> readFile(ArrayList<Employee> employeeList, String inputFile) throws IOException
    {
        String splitter = ",";
        String line = "";

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        while((line = reader.readLine()) != null)
        {
            String[] tempArray = line.split(splitter);

            Employee tempEmployee = new Employee();
            tempEmployee.setFirst(tempArray[1]);
            tempEmployee.setLast(tempArray[0]);
            tempEmployee.setSalary(Integer.parseInt(tempArray[2]));

            employeeList.add(tempEmployee);
        }

        reader.close();

        return employeeList;
    }

    // write function
    public static void writeFile(ArrayList<Employee> employeeList, String outputFile) throws IOException
    {
        int length = employeeList.size();

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        writer.write(String.format("%-12s %-12s %-12s \n", "Last", "First", "Salary"));
        writer.write("--------------------------------\n");

        for(int i = 0; i < length; i++)
        {
            writer.write(String.format("%-12s %-12s %-12d\n", employeeList.get(i).getLast(), employeeList.get(i).getFirst(), employeeList.get(i).getSalary()));
        }

        writer.close();
    }
}

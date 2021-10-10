/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex42;

public class Employee {

    private String first;
    private String last;
    private int salary;

    public Employee()
    {
        this.first = "N/A";
        this.last = "N/A";
        this.salary = 0;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public void setLast(String last)
    {
        this.last = last;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public int getSalary()
    {
        return salary;
    }
}

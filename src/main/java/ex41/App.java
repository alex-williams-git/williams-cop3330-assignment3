/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex41;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException
    {
        // "C:\Users\link2\Documents\2021 Fall Term\COP3330 - OOP\exercise41_input.txt"

        // create arraylist to hold text file input
        ArrayList<String> inputLines = new ArrayList<String>();

        // store the file path for use in parameters
        String inputFile = "src/main/java/ex41/exercise41_input.txt";

        // write the text file input into the arraylist
        readFile(inputLines, inputFile);

        // sort the arraylist
        Collections.sort(inputLines);

        // store the file path for output
        String outputFile = "src/main/java/ex41/exercise41_output.txt";

        // write the arraylist into the text file
        writeFile(inputLines, outputFile);
    }

    public static ArrayList<String> readFile(ArrayList<String> inputLines, String inputFile) throws IOException
    {
        // create a reader
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String curLine = reader.readLine();

        // read lines into arraylist
        while(curLine != null)
        {
            inputLines.add(curLine);
            curLine = reader.readLine();
        }

        // close reader
        reader.close();

        return inputLines;
    }

    public static void writeFile(ArrayList<String> inputLines, String outputFile) throws IOException
    {
        // create a writer
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // write lines into new text file
        int length = inputLines.size();

        writer.write("There are a total of " + length + " names: \n");
        writer.write("----------------------------\n");

        for(String inputLine : inputLines)
        {
            writer.write(inputLine);
            writer.newLine();
        }

        // close writer
        writer.close();
    }
}

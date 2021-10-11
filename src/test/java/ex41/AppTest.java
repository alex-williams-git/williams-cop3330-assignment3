/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex41;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testEmployeeFunctions() throws IOException
    {
        String inputFile = "src/main/java/ex41/exercise41_input.txt";

        ArrayList<String> inputLines = new ArrayList<>();

        inputLines = App.readFile(inputLines, inputFile);

        // testing first file read
        String[] lastNameTest = {"Ling, Mai", "Johnson, Jim", "Zarnecki, Sabrina", "Jones, Chris", "Jones, Aaron", "Swift, Geoffrey", "Xiong, Fong"};
        testRead(inputLines, lastNameTest);

        Collections.sort(inputLines);

        // testing name sort
        String[] lastNameTest2 = {"Johnson, Jim", "Jones, Aaron", "Jones, Chris", "Ling, Mai", "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina"};
        testRead(inputLines, lastNameTest2);
    }

    public void testRead(ArrayList<String> inputLines, String[] lastNameArray)
    {
        int i = 0;

        for(String element : inputLines)
        {
            assertEquals(lastNameArray[i++], element);
        }
    }
}
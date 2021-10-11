package ex45;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testReplaceWord() throws IOException
    {
        String inputFile = "src/main/java/ex45/exercise45_input.txt";
        String outputFile = "src/main/java/ex45/exercise45_output.txt";
        String key = "utilize";
        String replacement = "use";

        App.replaceWord(inputFile, outputFile, key, replacement);
        Boolean bool = checkFile(outputFile, key);

        assertEquals(true, bool);
    }

    public Boolean checkFile(String outputFile, String key)
    {
        Scanner scan = new Scanner(outputFile);

        while(scan.hasNextLine())
        {
            String curLine = " ";
            curLine = scan.nextLine();

            if(curLine.contains(key))
                return false;
        }

        scan.close();
        return true;
    }
}
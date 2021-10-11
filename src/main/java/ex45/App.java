/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex45;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException
    {
        String inputFile = "src/main/java/ex45/exercise45_input.txt";
        String outputFile = scanInput();
        String key = "utilize";
        String replacement = "use";

        replaceWord(inputFile, outputFile, key, replacement);
    }

    static String scanInput()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the name of the output file? ");
        String ret = scan.nextLine();

        return ret;
    }

    static void replaceWord(String inputFile, String outputFile, String key, String replacement) throws IOException
    {
        Charset charSet = StandardCharsets.UTF_8;
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        BufferedWriter writer = Files.newBufferedWriter(outputPath, charSet);
        Scanner scan = new Scanner(inputPath, charSet.name());

        String curLine = "";

        while(scan.hasNextLine())
        {
            curLine = scan.nextLine();
            curLine = curLine.replaceAll(key, replacement);
            writer.write(curLine);
            writer.newLine();
        }

        scan.close();
        writer.close();
    }
}

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex43;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException
    {
        String[] filePath = scanIn();

        int valid = makeDirectory(filePath);

        if(valid == 1)
        {
            System.out.println("The directories were successfully created.");
        }else{
            System.out.println("Could not create the directories.");
        }
    }

    public static String[] scanIn()
    {
        String[] userInput = new String[4];

        Scanner scan = new Scanner(System.in);

        System.out.print("Site name: ");
        userInput[0] = scan.nextLine();

        System.out.print("Author: ");
        userInput[1] = scan.nextLine();

        System.out.print("Do you want a folder for Javascript? ");
        userInput[2] = scan.nextLine();

        System.out.print("Do you want a folder for CSS? ");
        userInput[3] = scan.nextLine();

        return userInput;
    }

    public static int makeDirectory(String[] path) throws IOException
    {
        Boolean Bool = false;

        String website_folder = "src/main/java/ex43/website";
        File file = new File(website_folder);
        Bool = file.mkdir();
        if(!Bool)
            return 0;

        String website_folder_name = "src/main/java/ex43/website/" + path[0];
        File file1 = new File(website_folder_name);
        Bool = file1.mkdir();
        if(!Bool)
            return 0;

        String htmlFileName = website_folder_name + "/index.html";
        File htmlFile = new File(htmlFileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile));
        writer.write("<html><title>" + path[0] + "</title></html>\n");
        writer.write("<meta name=\"" + path[1] + "\">\n");
        writer.close();

        if(path[2].equals("y"))
        {
            String js_folder_name = website_folder_name + "/js";
            File js_folder = new File(js_folder_name);
            Bool = js_folder.mkdir();
            if(!Bool)
                return 0;
        }

        if(path[3].equals("y"))
        {
            String css_folder_name = website_folder_name + "/css";
            File css_folder = new File(css_folder_name);
            Bool = css_folder.mkdir();
            if(!Bool)
                return 0;
        }

        return 1;
    }
}

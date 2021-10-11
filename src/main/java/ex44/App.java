/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex44;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class App {

    public static void main(String[] args) throws IOException
    {
        String inputPath = "src/main/java/ex44/exercise44_input.json";

        Product product = parseJSON(inputPath);

        trapInput(product);
    }

    static Product parseJSON(String inputPath) throws IOException
    {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        Product product = gson.fromJson(reader, Product.class);

        return product;
    }

    static void trapInput(Product product)
    {
        Scanner scan = new Scanner(System.in);
        boolean productExists = false;

        do
        {
            System.out.print("What is the product name? ");

            String tempSearch = scan.nextLine();

            for(individualProduct p1 : product.getProducts())
            {
                if(p1.getName().equals(tempSearch))
                {
                    System.out.println("Name: " + p1.getName() + "\nPrice: " + p1.getPrice() + "\nQuantity: " + p1.getQuantity());
                    productExists = true;
                }
            }

            if(!productExists)
            {
                System.out.println("Sorry. That product was not found in our inventory.");
            }

        }while(!productExists);
    }
}

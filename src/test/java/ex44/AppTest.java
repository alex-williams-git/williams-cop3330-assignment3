/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex44;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testParser() throws IOException
    {
        String inputPath = "src/main/java/ex44/exercise44_input.json";

        Product productResult = App.parseJSON(inputPath);

        List<individualProduct> productList = productResult.getProducts();

        String[] testList = {"Widget", "Thing", "Doodad"};
        Double[] testList2 = {25.0, 15.0, 5.0};
        Integer[] testList3 = {5, 5, 10};

        testListParse(productList, testList, testList2, testList3);
    }

    public void testListParse(List<individualProduct> productList, String[] nameList, Double[] priceList, Integer[] quantityList)
    {
        for(int i = 0; i < productList.size(); i++)
        {
            assertEquals(nameList[i], productList.get(i).getName());
            assertEquals(priceList[i], productList.get(i).getPrice());
            assertEquals(quantityList[i], productList.get(i).getQuantity());
        }
    }
}
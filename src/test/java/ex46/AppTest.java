package ex46;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test

    public void testWordFrequency() throws IOException
    {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        String inputFile = "src/main/java/ex46/exercise46_input.txt";

        wordMap = App.findFrequency(wordMap, inputFile);
        Integer[] testArray = {1, 2, 7};

        testFrequency(wordMap, testArray);

        List<Map.Entry<String, Integer>> sortedList = App.sortMap(wordMap);
        Integer[] testArray2 = {7, 2, 1};

        testSort(sortedList, testArray2);
    }

    public void testFrequency(HashMap<String, Integer> wordMap, Integer[] testArray)
    {
        int i = 0;

        for(Map.Entry element : wordMap.entrySet())
        {
            assertEquals(testArray[i++], element.getValue());
        }
    }

    public void testSort(List<Map.Entry<String, Integer>> sortedList, Integer[] testArray)
    {
        int i = 0;

        for(Map.Entry<String, Integer> element : sortedList)
        {
            assertEquals(testArray[i++], element.getValue());
        }
    }
}
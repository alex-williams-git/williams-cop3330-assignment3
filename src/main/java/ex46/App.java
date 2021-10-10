/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alexander Williams
 */

package ex46;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App {

    public static void main(String[] args) throws IOException
    {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        String inputFile = "src/main/java/ex46/exercise46_input.txt";

        wordMap = findFrequency(wordMap, inputFile);

        List<Map.Entry<String, Integer>> sortedList = sortMap(wordMap);

        printList(sortedList);
    }

    static HashMap<String, Integer> findFrequency(HashMap<String, Integer> wordMap, String inputFile) throws IOException
    {
        Scanner scan = new Scanner(new File(inputFile));

        while(scan.hasNext())
        {
            String tempWord = scan.next();

            if(wordMap.containsKey(tempWord))
            {
                int tempCount = wordMap.get(tempWord) + 1;
                wordMap.put(tempWord, tempCount);
            }
            else
            {
                wordMap.put(tempWord, 1);
            }
        }

        scan.close();

        return wordMap;
    }

    static List<Map.Entry<String, Integer>> sortMap(HashMap<String, Integer> wordMap)
    {
        List<Map.Entry<String, Integer>> mapToList = new LinkedList<Map.Entry<String, Integer>>(wordMap.entrySet());

        Collections.sort(mapToList, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> i, Map.Entry<String, Integer> j)
            {
                return j.getValue().compareTo(i.getValue());
            }
        });

        return mapToList;
    }

    static void printList(List<Map.Entry<String, Integer>> sortedList)
    {
        for(Map.Entry<String, Integer> word : sortedList)
        {
            System.out.print(word.getKey() + ":");

            for(int i = 0; i < word.getValue(); i++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

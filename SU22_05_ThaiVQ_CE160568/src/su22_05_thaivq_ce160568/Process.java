/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_05_thaivq_ce160568;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author thaiq
 */
public class Process {

    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    /**
     * count word in a string
     *
     * @param sentence
     * @return
     */
    public static int countWordsUsingStringTokenizer(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(sentence);
        return tokens.countTokens();
    }

    /**
     * display a world count
     *
     * @param input
     */
    public void countWords(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
        System.out.print("{");
        int count = 0;
        int len = wordCounter.size();
        for (String object : wordCounter.keySet()) {
            if (count == len - 1) {
                System.out.print(object + "=" + wordCounter.get(object));
            } else {
                System.out.print(object + "=" + wordCounter.get(object));
                System.out.print(", ");
            }
            count++;
        }
        System.out.print("}");
    }

    /**
     * count character in string
     *
     * @param str
     */
    public void CountChar(String str) {
        int counter[] = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            counter[str.charAt(i)]++;
        }
        char array[] = new char[str.length()];
        System.out.print("{");
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            int flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j] && array[j] != ' ') {
                    flag++;
                }
            }
            if (flag == 1) {
                System.out.print(str.charAt(i) + "=" + counter[str.charAt(i)] + ", ");
            }
        }
        System.out.print("}");
    }
}

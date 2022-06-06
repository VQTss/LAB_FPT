
package su22_05_thaivq_ce160568;

import java.util.Scanner;

/**
 *
 * @author thaiq
 */
public class SU22_05_ThaiVQ_CE160568 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Process p = new Process();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String t =  sc.nextLine();
        Strings s = new Strings(t);
        p.countWords(s.getStr());
        System.out.println("");
        p.CountChar(s.getStr());
    }
    
}

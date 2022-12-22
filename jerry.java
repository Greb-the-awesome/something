import java.util.*;
import java.io.*;

public class jerry {

    static int numChars = 20;
    static String genChars() {
        char[] alphabet = new char[26];
        for (int i = 65; i < 91; i++) {
            alphabet[i-65] = (char) i;
        }
        StringBuilder res = new StringBuilder();
        int a = (int) (Math.random()*26);
        for (int i=0; i<numChars; i++) {
            res.append(alphabet[a]);
            a = (int) (Math.random() * 26);
        }
        return res.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chars = genChars();
        chars = addSpaces(chars);
        System.out.println(chars);
        System.out.println("Press enter to start");
        readLine(br);
        long start = System.nanoTime();
        String s = readLine(br);
        long end = System.nanoTime();
        double time = (end - start)/(Math.pow(10, 9));
        System.out.println("you took " + time + " seconds");

        int correct = 0;
        int wrong = 0;
        /* this might be a problem if someone is off by one character and then everything will be messed up
        ex if its "abcdefgh" and I type "aabcdefg" then a lot of characters are wrong
        kinda their fault if they are off tho */
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == chars.charAt(i)) {correct++;}
            else {wrong++;}
        }
        int spaces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaces++;
            }
        }
        System.out.println("Correct: " + correct);
        System.out.println("Wrong: " + wrong);
        float percent = (float)wrong / (wrong + correct);
        double speed = numChars/5.0/time*60; // about 5 characters in every word
        System.out.println("percent wrong: " + percent);
        System.out.println("your typing speed: ");
        System.out.println("raw: " + ((spaces+1)/time*60) + "wpm");
        System.out.println("adjusted: " + speed + "wpm");
    }
    static String readLine(BufferedReader br) throws IOException {
        return br.readLine();
    }

    static String addSpaces(String s) {
        int curr = (int) (Math.random() * 3 + 4); //between 3 and 7 characters per word
        // so I split it into to substrings and added a space in between
        while (curr < s.length()) {
            StringBuffer s1 = new StringBuffer(s.substring(0, curr)); //strings are immutable so StringBuffer is faster
            StringBuffer s2 = new StringBuffer(s.substring(curr));
            s1.append(" ");
            s1.append(s2);
            s = s1.toString();
            curr += (int) (Math.random() * 3 + 4);
        }
        return s;
    }
}
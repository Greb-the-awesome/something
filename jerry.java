import java.util.*;
import java.io.*;

public class jerry {
    static int numChars = 10;
    static String genChars() {
        char[] alphabet = new char[26];
        for (int i = 65; i < 91; i++) {
            alphabet[i-65] = (char) i;
        }
        String res = "";
        int a = (int) Math.random()*26;
        for (int i=0; i<numChars; i++) {
            res += alphabet[a];
            a = (int) (Math.random() * 26);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chars = genChars();
        System.out.println(chars);
        System.out.println("Press enter to start");
        readLine(br);
        long start = System.nanoTime();
        String s = readLine(br);
        long end = System.nanoTime();
        System.out.println("you took " + String.valueOf(end - start) + " nanoseconds");

        int correct = 0;
        int wrong = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == chars.charAt(i)) {correct++;}
            else {wrong++;}
        }
        System.out.println("Correct: " + String.valueOf(correct));
        System.out.println("Wrong: " + String.valueOf(wrong));
        float percent = (float)wrong / correct;
        System.out.println("percent wrong: " + String.valueOf(percent));
    }
    static String readLine(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

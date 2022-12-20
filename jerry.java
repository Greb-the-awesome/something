import java.util.*;
import java.io.*;

public class jerry {
    static String genChars() {
        char[] alphabet = new char[26];
        for (int i = 65; i < 91; i++) {
            alphabet[i-65] = (char) i;
        }
        String res = "";
        int a = (int) Math.random()*26;
        for (int i=0; i<100; i++) {
            res += alphabet[a];
            a = (int) (Math.random() * 26);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long start = System.nanoTime();
        System.out.println(genChars());
        long end = System.nanoTime();
    }
    static String readLine(BufferedReader br) throws IOException {
        return br.readLine();
    }
}

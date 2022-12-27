import java.io.*;
import java.util.*;

 public class Main {
    static int[] full = new int[]{1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
         //input
         Scanner scanner = new Scanner(System.in);
         int[] cnt = new int[6];
         
         for (int i = 0; i < 6; i++) {
             cnt[i] = scanner.nextInt();
         }

         for (int i = 0; i < full.length; i++) {
             cnt[i] = full[i] - cnt[i];
             System.out.println(cnt[i]);
         }
     }
 }
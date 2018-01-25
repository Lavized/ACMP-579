import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Main.run();
    }

    private static void run() throws IOException {
        PrintWriter pw;
        Scanner sc;
        sc = new Scanner(new File("INPUT.TXT"));
        sc.useDelimiter(System.getProperty("line.separator"));
        int countOfNums = sc.nextInt();
        String readNums =  sc.next();

        String[] str = readNums.split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        sc.close();

        List<Integer> indexPlus = new ArrayList<>(nums.length);
        List<Integer> indexMinus = new ArrayList<>(nums.length);
        int sumPlus = 0;
        int sumMinus = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sumPlus += nums[i];
                indexPlus.add(i);
            }
            else if (nums[i] < 0 ){
                sumMinus += Math.abs(nums[i]);
                indexMinus.add(i);
            }
        }

        pw = new PrintWriter(new File("OUTPUT.TXT"));
        if (sumPlus > sumMinus) {
            pw.print(indexPlus.size()  );
            pw.println();
            for (int s : indexPlus) {
                pw.print(s + 1 +  " ");
            }
        }
        else {
            pw.print(indexMinus.size()  );
            pw.println();
            for (int s : indexMinus) {
                pw.print(s + 1  + " ");
            }
        }

        pw.close();

    }

}

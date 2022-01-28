package ak;

import java.util.Scanner;

/**
 * @author zhougy
 * @create 2022-01-11 14:30
 */
public class day01 {

    public static void main(String[] args) {
        String s = "";
        Scanner input = new Scanner(System.in);
        s = input.nextLine();
        int count4 = 0;
        int count7 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '4')
                count4++;
            if (s.charAt(i) == '7')
                count7++;
        }
        if (((count4 + count7) == 4||(count4 + count7) == 7) && (count4 != 0 || count7 != 0))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}

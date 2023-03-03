package love;
public class Malak {
    public static void main(String[] args) {
        int size = 10;
        String message = " I love You Malak";
        int n = message.length();
        int print_line = 4;
        for (int x = 0; x < size; x++) {
        for (int y = 0; y <= 4 * size; y++) {
                double dist1 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - size, 2));
                double dist2 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - 3 * size, 2));
                if (dist1 < size + 0.5 || dist2 < size + 0.5) {
                    System.out.printf("*");
                } else { System.out.printf(" ");   }
            } System.out.printf("\n"); }
        for (int x = 1; x < 2 * size; x++) {
            for (int y = 0; y < x; y++) {
                System.out.printf(" ");
            }for (int y = 0; y < 4 * size + 1 - 2 * x; y++) {
                if (x >= print_line - 1 && x <= print_line + 1) {
                    int idx = y - (4 * size - 2 * x - n) / 2;
                    if (idx < n && idx >= 0) {
                        if (x == print_line) {
                            System.out.printf("%c", message.charAt(idx));
                        } else { System.out.printf(" ");  }
                    } else {
                        System.out.printf("*");
                    } } else { System.out.printf("*");   }}
            System.out.printf("\n");
        }  } }

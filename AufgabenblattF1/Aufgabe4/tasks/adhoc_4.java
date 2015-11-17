
public class adhoc_4 {

    public static void main(String[] args) {
        strange_pattern(7, 0, 0);
    }

    private static void strange_pattern(int x, int y, int s) {

        print_row(x, y +1, s +y, s + x-1);

        System.out.println(" ");
        if (x > 1)
            strange_pattern(x - 1, y + 1, 0);
    }

    private static void print_row(int x, int y, int sx, int sy) {
        print_char(sx, ' ');
        print_char(x, '*');

        print_char(1, ' ');

        print_char(y, '*');
        print_char(sy, ' ');

        print_char(1, ' ');

        print_char(sy, ' ');
        print_char(y, '*');

        print_char(1, ' ');

        print_char(x, '*');
    }

    private static void print_char(int n, char c) {
        if(n > 0) {
            System.out.print(c);
            print_char(n -1, c);
        }
    }

}

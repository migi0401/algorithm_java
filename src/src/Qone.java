import java.util.Scanner;

public class Qone {
    static int max4(int a, int b, int c, int d){
        int max = a;

        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }
        if(d > max){
            max = d;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int a = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int b = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int c = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int d = sc.nextInt();
        System.out.println(max4(a,b,c,d));
    }
}

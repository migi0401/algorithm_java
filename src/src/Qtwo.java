import java.util.Scanner;

public class Qtwo {
    static int min3(int a,int b,int c){
        int min = a;
        if(b<min){
            min = b;
        }
        if(c<min){
            min = c;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int a = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int b = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int c = sc.nextInt();
        System.out.println(min3(a,b,c));
    }
}

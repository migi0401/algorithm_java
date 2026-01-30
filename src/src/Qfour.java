import java.util.Scanner;

public class Qfour {
    static int med(int a, int b, int c){
        if(a>=b){
            if(b>=c){
                return b;
            }
            else if(c>=a){
                return a;
            }
            else{
                return c;
            }
        }
        else if(a > c){ // a<b 일 때
            return a;
        }
        else if(b > c){ // a<b와 a<=c 일 때
            return c;
        }
        else{ // a<b , a<=c, b<=c 일 때
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        int a = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int b = sc.nextInt();
        System.out.print("숫자를 입력하세요: ");
        int c = sc.nextInt();
        System.out.println("중앙값은 "+med(a,b,c));
    }
}

import java.util.Scanner;

public class Qten {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a;
        int b;

        System.out.println("1부터 n까지의 합을 구합니다.");

        System.out.print("a의 값: ");
        a= sc.nextInt();

        do{
            System.out.print("b의 값: ");
            b=sc.nextInt();
            if(a>=b){
                System.out.println("a보다 큰 값을 입력하세요!");
            }
        }while(b<=a);

        int sum = b - a;

        System.out.println("b-a는 "+sum+"입니다.");
    }
}

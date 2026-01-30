import java.util.Scanner;

public class Qeleven {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a;

        System.out.println("자릿수를 구합니다.");

        System.out.print("양의 정수를 입력하세요: ");
        a= sc.nextInt();
        int sum = 0;

        do{
            a=a/10;
            sum+=1;
        }while(a>0);

        System.out.println("자릿수는 "+sum+"입니다.");
    }
}

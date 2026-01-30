import java.util.Scanner;

public class Qnine {
    static int sumof(int a, int b){
        int sum = 0;

        for(int i = a; i<=b; i++){
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("a와 b를 입력해주세요");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a부터 b까지의 합은 " + sumof(a,b));
    }
}

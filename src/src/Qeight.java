import java.util.Scanner;

public class Qeight {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("1부터 n까지의 가우스 덧셈, n을 입력하세요.");
        int n = sc.nextInt();

        int sum = 0;
        int k = 1;

        for(int i = 0; i < n/2; i++){
            sum += (n-i) + (n-(n-k));
            k++;
        }

        if(n%2!=0){ //홀수 처리
            sum += n/2+1;
        }
        System.out.println(sum);
    }
}

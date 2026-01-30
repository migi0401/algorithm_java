import java.util.Scanner;

public class Qseventeen {
    static void nPira(int n){
        int a = n;
        int b = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<a-1;j++){
                System.out.print(" ");
            }
            for(int k=1; k<=((i-1)*2+1); k++){
                System.out.print(b);
            }
            for(int j=0;j<a-1;j++){
                System.out.print(" ");
            }
            a--;
            b++;
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("피라미드를 출력합니다. 단 수를 입력하세요. ");
        n=sc.nextInt();

        nPira(n);
    }
}

import java.util.Scanner;

public class QArrTwo {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a){
        for(int i = 0; i<a.length/2;i++){
            for(int j =0; j<a.length;j++){
                System.out.print(a[j]+" ");
            }
            System.out.println();
            swap(a, i, a.length-i-1);
            System.out.println("a["+i+"]과 a["+(a.length-i-1)+"]를 교환합니다.");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = sc.nextInt();

        int[] x = new int[num];

        for(int i = 0; i<num; i++){
            System.out.print("x["+i+"] : ");
            x[i] = sc.nextInt();
        }

        reverse(x);

        for(int j =0; j<x.length;j++){
            System.out.print(x[j]+" ");
        }
        System.out.println();
        System.out.println("요소를 역순으로 정렬했습니다.");

    }
}

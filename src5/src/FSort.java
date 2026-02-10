import java.util.Scanner;

public class FSort {

    static void fSort(int[] a, int n, int max){
        int[] f = new int[max + 1];
        int[] b = new int[n];

        //1단계
        for(int i = 0; i < n; i++){
            f[a[i]]++;
        }

        //2단계: Add front of index
        for(int i = 1; i <= max; i++){
            f[i] += f[i - 1];
        }

        //3단계: Add Extra Array
        for(int i = n - 1; i >= 0; i--){
            b[--f[a[i]]] = a[i];
        }

        //4단계: Copy Extra Array
        for(int i = 0; i < n; i++){
            a[i] = b[i];
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.println("요솟수: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            do{
                System.out.print("x[" + i + "] : ");
                a[i] = sc.nextInt();
            }while(a[i] < 0);
        }

        int max = a[0];
        for(int i = 1; i < n; i++){
            if(a[i] > max){
                max = a[i];
            }
        }

        fSort(a, n, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }
    }
}

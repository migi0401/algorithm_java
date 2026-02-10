import java.util.Scanner;

public class HeapSort {

    static void swap(int[] a, int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void downHeap(int[] a, int left, int right){
        int temp = a[left];
        int child;
        int parent;

        for(parent = left; parent < (right + 1) / 2; parent = child){
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if(temp >= a[child]){
                break;
            }
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n){
        for(int i = (n - 1) / 2; i >= 0; i--){
            downHeap(a, i, n - 1);
        }

        for(int i = n - 1; i > 0; i--){
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("힙 정렬: ");
        System.out.println("요소수: " );
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            System.out.print("x["+i+"] = ");
            a[i] = sc.nextInt();
        }

        heapSort(a, n);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }
    }
}

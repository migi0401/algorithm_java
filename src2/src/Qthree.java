import java.util.Scanner;

class SearchTh {
    static int seqSearchSen(int[] a, int n, int key, int[] idx){ //보초법

        int j = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == key){
                idx[j++] = i;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num + 1];
        int[] id = new int[num+1];

        for(int i = 0; i < num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = seqSearchSen(x,num,key, id);

        System.out.println("키 값은 "+idx+"개 존재합니다.");
    }
}


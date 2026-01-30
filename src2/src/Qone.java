import java.util.Scanner;

class SeqSearch {
    static int seqSearchSen(int[] a, int n, int key){ //보초법

        for(int i = 0; i < n; i++){
            if(a[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num + 1];

        for(int i = 0; i < num; i++){
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = seqSearchSen(x,num,key);

        if(idx == 1){
            System.out.println("그 값의 요소가 없습니다.");
        }
        else{
            System.out.println(key + "은 x["+idx+"]에 있습니다.");
        }
    }
}


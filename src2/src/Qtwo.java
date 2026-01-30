import java.util.Scanner;

class Search {
    static int seqSearchSen(int[] a, int n, int key){ //보초법

        for(int i = 0; i < n; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print("----");
        }
        System.out.println();

        for(int i = 0; i < n; i++){
            System.out.print("   |");
            String spaceFormat = String.format("%%%ds", (i*3)+2);
            System.out.printf(spaceFormat, "*");
            System.out.println();

            System.out.print(i+"| ");
            for(int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
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

        seqSearchSen(x, num, key);

        int idx = seqSearchSen(x, num, key);

        if(idx == -1){
            System.out.println("없어");
        }else{
            System.out.println(x[idx]);
        }
    }
}



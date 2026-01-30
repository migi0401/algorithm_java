import java.util.Scanner;

 class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key){ //보초법
        int i = 0;

        a[n] = key; //배열의 마지막 요소에 찾고자 하는 키 값을 넣는다.(보초)

        while(true){
            if(a[i] == key){  //전에 있던 while문에서는 if문이 2개 있었다.
                break;
            }
            i++;
        }
        return i == n ? -1 : i;
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

import java.util.Arrays;
import java.util.Scanner;

class QSix{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차수능로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = sc.nextInt();

        for(int i = 1; i < num; i++){
            do{
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            }while(x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = Arrays.binarySearch(x,ky); //클래스 메서드

        if(idx < 0){
            System.out.println("삽입 포인트는 : " + (-idx-1));
        }
        else{
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
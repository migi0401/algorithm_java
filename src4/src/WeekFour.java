import java.util.Scanner;

class Hanoi{
    static void move(int no, int x, int y){
        if(no > 1){
            move(no - 1, x, 6 - x - y);
        }

        System.out.println("원반["+no+"]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if(no > 1){
            move(no - 1, 6 - x - y, y); //기둥 번호의 합이 6이므로 중간 기둥으로 구할 수 있다.
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = sc.nextInt();

        move(n, 1, 3);
    }
}

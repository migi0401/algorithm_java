import java.util.Scanner;

public class QArrEight {
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    static int isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0 || year %400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int y, int m, int d){
        while(--m > 0){
            d += mdays[isLeap(y)][m-1];
        }
        return d;
    }

    static int totalOfYear(int y){
        int total = 0;
        int counter = 0;

        while(counter < 12){
            total += mdays[isLeap(y)][counter++];
        }

        return total;
    }

    static int leftDayOfYear(int y, int m, int d){
        while(--m > 0){
            d += mdays[isLeap(y)][m-1];
        }
        int left = totalOfYear(y) - d;
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry;

        System.out.println("그 해 남은 일수를 구합니다.");

        do{
            System.out.print("년 : ");
            int year = sc.nextInt();
            System.out.print("월 : ");
            int month = sc.nextInt();
            System.out.print("일 : ");
            int day = sc.nextInt();

            System.out.printf("그 해 %d일 남았습니다.\n", leftDayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? (1. 예 / 0. 아니요");
            retry = sc.nextInt();
        }while(retry == 1);
    }
}

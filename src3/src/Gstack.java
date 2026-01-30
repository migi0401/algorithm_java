import java.util.Scanner;

public class Gstack<E> {
    private int max;
    private int ptr;
    private E [] stk; //임의의 데이터형 배열 본체 생성

    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try{
            stk = (E[]) new Object[max]; //임의의 데이터형이기 때문에 Object 타입으로
            //생성하고 E 타입으로 캐스팅 해야한다.
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public static class OverflowException extends RuntimeException{
        public OverflowException(){}
    }

    public static class EmptyStackException extends RuntimeException{
        public EmptyStackException(){}
    }

    public E push(E x) throws OverflowException{
        if(ptr >= max){
            throw new OverflowException();
        }
        return stk[ptr++] = x;
    }

    public E pop() throws EmptyStackException{
        if(ptr <= 0){
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public E peek() throws EmptyStackException{
        if(ptr <= 0){
            throw new EmptyStackException();
        }
        return stk[ptr - 1];
    }

    public void dump(){
        if(ptr <= 0){
            System.out.println("스택이 비어있습니다.");
        }
        else{
            for(int i = 0; i < ptr; i++){
                System.out.println(stk[i] + " ");
            }
            System.out.println();
        }
    }
    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }
}

class GstackTester{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Gstack<String> intStack =  new Gstack<>(10);

        while(true) {
            System.out.println("현재 데이터 수 : " + intStack.size() + "/" + intStack.capacity());
            System.out.print("1push  2pop  3peek 4dump : ");

            int menu = sc.nextInt();
            if (menu == 0) {
                break;
            }

            String x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.next();
                    try {
                        intStack.push(x);
                    } catch (Gstack.OverflowException ex) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = intStack.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyStackException ex) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = intStack.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyStackException ex) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 4:
                    intStack.dump();
                    break;
            }
        }
    }
}

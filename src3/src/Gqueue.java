import java.util.EmptyStackException;
import java.util.Scanner;

public class Gqueue<E> {
    private int max;
    private int ptr;
    private int front;
    private int rear;
    private E[] que;

    public Gqueue(int capacity){
        max = capacity;
        ptr = rear = front = 0;
        try{
            que = (E[])new Object[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public static class OverflowGQueueException extends RuntimeException {
        public OverflowGQueueException(){}
    }

    public static class EmptyGQueueException extends RuntimeException {
        public EmptyGQueueException(){}
    }

    public int size(){
        return ptr;
    }

    public int capacity(){
        return max;
    }

    public E enque(E x) throws Gqueue.OverflowGQueueException {
        if(ptr >= max){
            throw  new OverflowGQueueException();
        }
        que[rear++] = x;
        ptr++;
        if(rear == max){
            rear = 0;
        }
        return x;
    }

    public E deque() throws Gqueue.EmptyGQueueException {
        if(ptr <= 0){
            throw new EmptyGQueueException();
        }
        E x1 = que[front++];
        ptr--;
        if(front == max){
            front = 0;
        }
        return x1;
    }

    public E peek() throws EmptyStackException{
        if(ptr <= 0){
            throw new EmptyStackException();
        }
        return que[front];
    }

    public void dump(){
        if(ptr <= 0){
            System.out.println("큐가 비어있습니다.");
        }
        else{
            for(int i = 0; i < ptr; i++){
                System.out.println(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }
}

class GQueueTester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Gqueue<String> gQ = new Gqueue<>(10);

        while(true){
            System.out.println("현재 데이터 수 : " + gQ.size() + " / "
                    + gQ.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 " + "(4)덤프 (0)종료 : ");

            int menu = sc.nextInt();
            if(menu == 0){
                break;
            }

            String x;

            switch(menu){
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.next();
                    try{
                        gQ.enque(x);
                    }catch(IntQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try{
                        x = gQ.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 3:
                    try{
                        x = gQ.peek();
                        System.out.println("피크한 데이터는 " + x +"입니다.");
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있습니다.");
                    }
                    break;

                case 4:
                    gQ.dump();
                    break;
            }
        }
    }
}

import java.util.Scanner;

public class IntStack {
    private int max; //스택 용량
    private int ptr; //스택 포인터
    private int[] stk; //스택 본체

    public class EmptyStackException extends RuntimeException{
        public EmptyStackException(){}
    }

    public class OverflowException extends RuntimeException{
        public OverflowException(){}
    }

    public IntStack(int capacity){
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x) throws OverflowException{
        if(ptr >= max){
            throw new  OverflowException();
        }
        return stk[ptr++] = x; //푸시한 값을 반환
    }

    public int pop() throws EmptyStackException {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public int peek() throws EmptyStackException{
        if(ptr<=0){
            throw new EmptyStackException();
        }
        return stk[ptr-1];
    }

    public int indexOf(int x){
        for(int i = ptr - 1; i >= 0; i--){
            if(stk[i] == x){
                return i; //인덱스를 반환
            }
        }
        return -1;
    }

    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isEmpty(){
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= max;
    }

    public void dump(){
        if(ptr<=0){
            System.out.println("스택이 비어있습니다.");
        }
        else{
            for(int i = 0; i<ptr;i++){
                System.out.println(stk[i]+" ");
            }
            System.out.println();
        }
    }
}

class IntStackTester{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while(true){
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("1push  2pop  3peek  " +
                    "4capcity  5size 6isEmpty  " +
                    "7isFull 8clear 9indexOf 10dump : ");

            int menu = sc. nextInt();
            if(menu==0){
                break;
            }

            int x;
            switch(menu){
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try{
                        s.push(x);
                    }catch(IntStack.OverflowException e){
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try{
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x +"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 3:
                    try{
                        x = s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 4:
                    x = s.capacity();
                    System.out.println("스택의 최대 용량은 " + x +"입니다.");
                    break;
                case 5:
                    x = s.size();
                    System.out.println("스택에 저장된 데이터 수는 " + x + "입니다.");
                    break;
                case 6:
                    boolean y;
                    y = s.isEmpty();
                    if(y){
                        System.out.println("스택은 비어있습니다.");
                    }else{
                        System.out.println("스택은 비어있지 않습니다.");
                    }
                    break;
                case 7:
                    boolean z;
                    z = s.isFull();
                    if(z){
                        System.out.println("스택이 가득 차있습니다.");
                    }else{
                        System.out.println("스택은 가득 차지 않았습니다.");
                    }
                    break;
                case 8:
                    try{
                        s.clear();
                        System.out.println("stack을 비웠습니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 9:
                    System.out.print("검색할 값을 입력하세요 : ");
                    int search = sc.nextInt();
                    try{
                        System.out.println(search + "는 " + s.indexOf(search)+"에 있습니다");
                    }catch (IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 10:
                    s.dump();
                    break;
            }
        }
    }
}

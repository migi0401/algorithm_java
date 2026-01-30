import java.util.Scanner;

public class TwoStack {
    private int max;//스택 용량
    private int ptr;//스택 포인터
    private int ptr2;
    private int[] stk; //스택 본체

    public class EmptyStackException extends RuntimeException{
        public EmptyStackException(){}
    }

    public class OverflowException extends RuntimeException{
        public OverflowException(){}
    }

    public TwoStack(int capacity){
        ptr = 0;
        max = capacity;
        ptr2 = max;
        try{
            stk = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x) throws OverflowException{
        if(ptr >= ptr2){
            throw new  OverflowException();
        }
        return stk[ptr++] = x; //푸시한 값을 반환
    }

    public int push2(int x) throws OverflowException{
        if(ptr >= ptr2){
            throw new  OverflowException();
        }
        return stk[--ptr2] = x;
    }

    public int pop() throws EmptyStackException {
        if (ptr <= 0) {
            throw new EmptyStackException();
        }
        return stk[--ptr];
    }

    public int pop2() throws EmptyStackException {
        if (ptr2 >= max) {
            throw new EmptyStackException();
        }
        return stk[ptr2++];
    }

    public int peek() throws EmptyStackException{
        if(ptr<=0){
            throw new EmptyStackException();
        }
        return stk[ptr-1];
    }

    public int peek2() throws EmptyStackException{
        if(ptr2>=max){
            throw new EmptyStackException();
        }
        return stk[ptr2];
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isFull(){
        return ptr == ptr2;
    }

    public void dump(){
        if(ptr<=0){
            System.out.println("스택이 비어있습니다.");
        }
        else{
            for(int i = 0; i<max ;i++){
                System.out.println(stk[i]+" ");
            }
            System.out.println();
        }
    }
}

class TwoStackTester{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoStack s = new TwoStack(64);

        while(true){
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("1.앞에 push  2. 뒤에 push  3. 1스택 팝 4. 2스택 팝" +
                    "5. 1스택 피크 6. 2스택 피크 7. 덤프 : ");

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
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try{
                        s.push2(x);
                    }catch(IntStack.OverflowException e){
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 3:
                    try{
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x +"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                    case 4:
                    try{
                        x = s.pop2();
                        System.out.println("팝한 데이터는 " + x +"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 5:
                    try{
                        x = s.peek();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                    case 6:
                    try{
                        x = s.peek2();
                        System.out.println("피크한 데이터는 "+x+"입니다.");
                    }catch(IntStack.EmptyStackException e){
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;

                case 7:
                    s.dump();
                    break;
            }
        }
    }
}

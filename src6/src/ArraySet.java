public class ArraySet {
    private int max;
    private int num;
    private int[] set;

    public ArraySet(int capacity){
        num = 0;
        max = capacity;
        try{
            set = new int[max]; //집합 배열 생성
        }
        catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public int indexOf(int n){ //n찾아서 인덱스 반환
        for(int i = 0; i < num; i++){
            if(set[i] == n)
                return i;
        }
        return -1;
    }

    public boolean contains(int n){
        return indexOf(n) != -1;  //집합에 n이 있는지 확인
    }

    public boolean add(int n){
        if(num >= max || contains(n)) { //중복이지 않을 때 삽입
            return false;
        }
        else {
            set[num++] = n;  //집합에 n 추가
            return true;
        }
    }

    public boolean remove(int n){
        int idx;

        if(num <= 0 || (idx = indexOf(n)) == -1){
            return false;
        }
        else{
            set[idx] = set[--num]; //마지막 요소를 삭제한 곳으로 옮긴다.
            return true;
        }
    }
    //내 집합을 다른 집합에 복사
    public void copyTo(ArraySet s){
        int n = (s.max < num) ? s.max : num;
        for(int i = 0; i < n; i++){
            s.set[i] = set[i];
        }
        s.num = n;
    }
    //다른 집합을 내 집합에 복사
    public void copyFrom(ArraySet s){
        int n = (max < s.num) ? max : s.num;
        for(int i = 0; i < n; i++){
            set[i] = s.set[i];
        }
        num = n;
    }

    public boolean equalsTo(ArraySet s){
        if(num != s.num){
            return false;
        }

        for(int i = 0; i < num; i++){
            int j = 0;
            for(; j < s.num; j++){
                if(set[i] == s.set[j]){
                    break;
                }
            }
            if(j == s.num){
                return false;
            }
        }
        return true;
    }
    //합집합
    public void unionOf(ArraySet s1, ArraySet s2){
        copyFrom(s1);
        for(int i = 0; i < s2.num; i++){
            add(s2.set[i]);
        }
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("{ ");
        for(int i = 0; i < num; i++){
            sb.append(set[i] + " ");
        }
        sb.append("}");
        return sb.toString();
    }


    public static void main(String[] args){
            ArraySet s1 = new ArraySet(20);
            ArraySet s2 = new ArraySet(20);
            ArraySet s3 = new ArraySet(20);

            s1.add(10);
            s1.add(15);
            s1.add(20);
            s1.add(25);

            s1.copyTo(s2);
            s2.add(12);
            s2.remove(25);

            s3.copyFrom(s2);

            System.out.println("s1 = " + s1);
            System.out.println("s2 = " + s2);
            System.out.println("s3 = " + s3);

            System.out.println("집합 s1에 있는 15는 " +
                    (s1.contains(15) ? "포함됩니다." : "포함되지 않습니다."));

            System.out.println("집합 s2에 있는 25는 " +
                    (s2.contains(25) ? "포함됩니다." : "포함되지 않습니다."));

            System.out.println("집합 s1과 s2는 "+
                    (s1.equalsTo(s2)? "같습니다." : "같지 않습니다."));

            System.out.println("집합 s2과 s3는 "+
                    (s2.equalsTo(s3)? "같습니다." : "같지 않습니다."));

            s3.unionOf(s1, s2);

            System.out.println("집합 s1과 s2의 합집합은 " + s3 + "입니다.");
    }
}

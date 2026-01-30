import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class GenericSearch {
    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString(){
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER
                = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData>{
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Double.compare(o2.vision, o1.vision);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이나령", 162, 0.3),
        };

        System.out.print("시력이 몇인 사람을 찾고 있나요? : ");
        double vision = sc.nextDouble();
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER
        );

        if(idx<0){
            System.out.println("요소가 없습니다.");
        }
        else{
            System.out.println("x["+idx+"]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}

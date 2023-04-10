package DataStructure;
import java.util.PriorityQueue;
import java.util.Collections;

class Bass implements Comparable<Bass> {
    private int price;
    private String brand;

    public Bass(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public int getPrice() {
        return this.price;
    }

    public String getBrand() {
        return this.brand;
    }

    @Override
    public int compareTo(Bass bass) {
        if (this.price > bass.getPrice()) {
            return 1;
        } else if (this.price < bass.getPrice()){
            return -1;
        }
        return 0;
    }
}

public class PriorityQueueT {
    public static void main(String[] args) {
        PriorityQueue<Bass> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Bass(30, "Swing"));
        priorityQueue.add(new Bass(20, "Cort"));
        priorityQueue.add(new Bass(80, "Yamaha"));
        priorityQueue.add(new Bass(150, "Fender"));

        while (!priorityQueue.isEmpty()) {
            Bass bass = priorityQueue.poll();
            System.out.println("가격 : " + bass.getPrice() + "만원 / 브랜드명 : " + bass.getBrand());
        }
    }
}

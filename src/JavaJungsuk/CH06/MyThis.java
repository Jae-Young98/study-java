package JavaJungsuk.CH06;


class Guitar {
    String type;
    int price;

    public Guitar() {
        this("미입력", -1);
    }
    public Guitar(String type) {
        this(type, 0);
    }
    public Guitar(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public void showInfo() {
        System.out.println(type + "기타의 가격은 " + price);
    }
}
public class MyThis{
    public static void main(String[] args) {

        Guitar g1 = new Guitar();
        Guitar g2 = new Guitar("베이스");
        Guitar g3 = new Guitar("일렉", 500000);

        g1.showInfo();
        g2.showInfo();
        g3.showInfo();
    }
}

public class Normal extends Tarif {
    private int price;

    protected Normal(int price) {
        super(price);
    }


    public String getName() {
        return "normal";
    }
}

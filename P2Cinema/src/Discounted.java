public class Discounted extends Tarif{
    private int price;

    protected Discounted(int price) {
        super(price);
    }

    public String getName(){
        return "Discounted";
    }
}

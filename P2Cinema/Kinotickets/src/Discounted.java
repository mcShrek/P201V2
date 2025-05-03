public class Discounted extends Tarif{

    protected Discounted(int price) {

        super(price);
    }

    public String getName(){
        return "Discounted";
    }

    public int getPrice() {
        return super.getPrice() ;
    }
}

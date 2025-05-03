public class Normal extends Tarif {

    protected Normal(int price) {
        super(price);
    }


    public String getName() {
        return "normal";
    }

    @Override
    public int getPrice() {
        return super.getPrice() * 2;
    }
}

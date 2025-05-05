public abstract class Tarif {

    private double pricePerc;
    protected Tarif(double pricePerc) {
        this.pricePerc = pricePerc;
    }
    public abstract String getName();



    public double getPricePerc() {
        return pricePerc;
    }
    public void setPricePerc(double pricePerc) {
        this.pricePerc = pricePerc;
    }
}

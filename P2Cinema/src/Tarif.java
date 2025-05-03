public abstract class Tarif {
    private int price;

    protected Tarif(int price) {
        this.price = price;
    }

   public String getName(){
        return "test";
   };
}

public class TarifFactory {
   public static Tarif createTarif(String type, int price) {
        return switch(type.trim().toLowerCase()) {
            case "discounted" -> new Discounted(price);
            case "normal" -> new Normal(price);
            default -> throw new IllegalArgumentException();
        };

    }
}

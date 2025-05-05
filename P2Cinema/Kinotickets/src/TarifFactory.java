public class TarifFactory {
   public static Tarif createTarif(String type) {
        return switch(type.trim().toLowerCase()) {
            case "discounted" -> new Discounted();
            case "normal" -> new Normal();
            default -> throw new IllegalArgumentException();
        };

    }
}

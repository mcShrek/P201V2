public class ContainerFactory {

    public static Container createContainer(String type) {
        switch(type.trim().toLowerCase()) {
            case "goodscontainer" -> new GoodsContainer(50);
            case "specialcontainer" -> new SpecialContainer();
            default
        }
    }
}

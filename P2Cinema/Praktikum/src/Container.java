import java.util.ArrayList;
import java.util.List;

public abstract class Container {
    private static int maxId;
    private int id;
    private int maxCapacity;
    private List<Good> goods;

    protected Container(int capacity) {
        id = ++maxId;
        maxCapacity = capacity;
        goods = new ArrayList<>();
    }
    public void addGood(Good good) {
        if(goods.size() < maxCapacity) {
            goods.add(good);
        }
    }
    public boolean removeGood(Good good) {
        return goods.remove(good);
    }

    public int totalWeight() {
        int totalWeight = 0;
        for(Good good : goods) {
            totalWeight+= good.getWeight();
        }
        return totalWeight;
    }

 }

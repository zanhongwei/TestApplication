package contant.zhw.zxzq.com.testapplication.recyclerview;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class Fruit {
    private String name;
    private int fruitId;

    public Fruit(String name, int fruitId) {
        this.name = name;
        this.fruitId = fruitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }
}

package contant.zhw.zxzq.com.testapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import contant.zhw.zxzq.com.testapplication.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruit();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruit() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry = new Fruit("cherry",R.drawable.cherry);
            fruitList.add(cherry);
            Fruit hamimelon = new Fruit("hamimelon",R.drawable.hamimelon);
            fruitList.add(hamimelon);
            Fruit mango = new Fruit("mango",R.drawable.mango);
            fruitList.add(mango);
            Fruit orange = new Fruit("orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit pear = new Fruit("pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit pitaya = new Fruit("pitaya",R.drawable.pitaya);
            fruitList.add(pitaya);
            Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
        }
    }
}

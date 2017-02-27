package contant.zhw.zxzq.com.testapplication.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import contant.zhw.zxzq.com.testapplication.R;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.mImageView.setImageResource(fruit.getFruitId());
        holder.mTextView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_fruit);
            mTextView = (TextView) itemView.findViewById(R.id.tv_fruit);
        }
    }
}

package contant.zhw.zxzq.com.testapplication.fragmenttest.newsapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import contant.zhw.zxzq.com.testapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsTitleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news_title, container, false);
        RecyclerView newsTitleRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();

        for (int i = 1; i <=50 ; i++) {
            News news = new News();
            news.setTitle("this is title" + i);
            news.setContent(getRandomLengthContent("this is news content"+i+"."));
            newsList.add(news);
        }

        return newsList;
    }

    private String getRandomLengthContent(String s) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(s);
        }

        return builder.toString();
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

        private List<News> mNewsList;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    NewsActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleList.setText(news.getTitle());
        }

        public NewsAdapter(List<News> newsList){
            mNewsList = newsList;
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView newsTitleList;

            public ViewHolder(View itemView) {
                super(itemView);
                newsTitleList = (TextView) itemView.findViewById(R.id.news_title);
            }
        }
    }
}

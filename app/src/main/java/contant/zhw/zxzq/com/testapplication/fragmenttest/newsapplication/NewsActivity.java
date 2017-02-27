package contant.zhw.zxzq.com.testapplication.fragmenttest.newsapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import contant.zhw.zxzq.com.testapplication.R;

public class NewsActivity extends AppCompatActivity {

    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context,NewsActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");

        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(title,content);
    }
}

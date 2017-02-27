package contant.zhw.zxzq.com.testapplication.fragmenttest.newsapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import contant.zhw.zxzq.com.testapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {
    private View view;
    private TextView title;
    private TextView content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_news_content,container,false);
        return view;
    }

    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        title = (TextView) view.findViewById(R.id.news_title);
        content = (TextView) view.findViewById(R.id.content_tv);
        title.setText(newsTitle);
        content.setText(newsContent);
    }
}

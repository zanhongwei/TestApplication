package contant.zhw.zxzq.com.testapplication.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import contant.zhw.zxzq.com.testapplication.R;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mButton = (Button) findViewById(R.id.text_btn);
        mButton.setOnClickListener(this);
        replaceFragment(new RightFragment());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction mfragmentTransaction = fragmentManager.beginTransaction();
        mfragmentTransaction.replace(R.id.right_fragment,fragment);
        mfragmentTransaction.addToBackStack(null);
        mfragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_btn:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
        }
    }
}

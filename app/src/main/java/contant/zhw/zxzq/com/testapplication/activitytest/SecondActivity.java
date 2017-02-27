package contant.zhw.zxzq.com.testapplication.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import contant.zhw.zxzq.com.testapplication.R;

public class SecondActivity extends BaseActivity implements View.OnClickListener {

    private Button mButton;
    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent = getIntent();
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
//                String data = intent.getStringExtra("extra_data");
//                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent();
                intent1.putExtra("return","SecondActivity say : Hello FirstActivity");
                setResult(RESULT_OK,intent1);
                finish();
                break;
        }
    }
}

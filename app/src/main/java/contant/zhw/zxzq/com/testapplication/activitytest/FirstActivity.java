package contant.zhw.zxzq.com.testapplication.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import contant.zhw.zxzq.com.testapplication.R;

public class FirstActivity extends BaseActivity implements View.OnClickListener {

    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private EditText mEditText;
    private Button mButton4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mButton = (Button) findViewById(R.id.test1_btn);
        mButton2 = (Button) findViewById(R.id.destroy_btn);
        mButton3 = (Button) findViewById(R.id.test_intent_btn);

        //文本输入
        mEditText = (EditText) findViewById(R.id.et_text);
        mButton4 = (Button) findViewById(R.id.text_btn);

        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test1_btn:
                Toast.makeText(this, "点击了BUTTON1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.destroy_btn:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.test_intent_btn:
                String data = "extra_data";
                Intent intent1 = new Intent(FirstActivity.this,SecondActivity.class);
//                intent1.putExtra("extra_data",data);
                startActivityForResult(intent1,1);
                break;
            case R.id.text_btn:
                String msg = mEditText.getText().toString().trim();
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("return");
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}

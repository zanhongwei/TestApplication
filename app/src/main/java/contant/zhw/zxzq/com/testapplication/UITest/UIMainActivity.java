package contant.zhw.zxzq.com.testapplication.UITest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import contant.zhw.zxzq.com.testapplication.R;

public class UIMainActivity extends AppCompatActivity {


    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.progressBar2)
    ProgressBar mProgressBar2;

    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimain);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.progressBar_btn, R.id.alertDialog_btn, R.id.progressDialog_btn,R.id.prg_dlg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.progressBar_btn:
                mProgressBar.setVisibility(View.VISIBLE);
                break;
            case R.id.alertDialog_btn:
                mProgressBar.setVisibility(View.GONE);
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("This is Title");
                dialog.setMessage("Something is important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO: 2017/2/17 0017 确认后继续的动作
                    }
                });
                dialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO: 2017/2/17 0017 确认后取消的动作
                    }
                });
                dialog.show();
                break;
            case R.id.progressDialog_btn:
                mProgressBar.setVisibility(View.GONE);
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("This is progressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.prg_dlg:
                Log.e("aaa","点击了prg_dlg按钮");
                mProgressBar.setVisibility(View.GONE);
                mProgressBar2.setVisibility(View.VISIBLE);
                mProgressBar2.setProgress(progress);
                Log.e("aaa","刚要进入循环");
                Toast.makeText(this, "bbbbb", Toast.LENGTH_SHORT).show();
                // 利用timer模拟安装过程
//                final Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        if (progress>=100) {
////                          Toast.makeText(UIMainActivity.this, "定时器已取消", Toast.LENGTH_SHORT).show();
//                            mProgressBar2.setVisibility(View.GONE);
//                            AlertDialog.Builder dialog2 = new AlertDialog.Builder(UIMainActivity.this);
//                            dialog2.setTitle("安装");
//                            dialog2.setMessage("安装已完成，是否立即体验？");
//                            dialog2.setCancelable(false);
//                            dialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    // TODO: 2017/2/17 0017 体验
//                                }
//                            });
//                            dialog2.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    // TODO: 2017/2/17 0017 稍后体验
//                                }
//                            });
//                            dialog2.show();
//                            timer.cancel();
//                        }else {
//                        progress += 10;
//                        mProgressBar2.setProgress(progress);
//                        }
//                    }
//                },0,2000);

                do {

                    progress += 10;
                    mProgressBar2.setVisibility(View.VISIBLE);
                    mProgressBar2.setProgress(progress);
                    Toast.makeText(this, "AAAA", Toast.LENGTH_SHORT).show();
                    Log.e("aaa","进入循环");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while (progress < 100);

                AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
                dialog2.setTitle("安装");
                dialog2.setMessage("安装已完成，是否立即体验？");
                dialog2.setCancelable(false);
                dialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO: 2017/2/17 0017 确认后继续的动作
                    }
                });
                dialog2.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // TODO: 2017/2/17 0017 确认后取消的动作
                    }
                });
                dialog2.show();

                break;
        }
    }
}

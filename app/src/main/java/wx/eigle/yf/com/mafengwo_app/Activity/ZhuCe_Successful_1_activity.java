package wx.eigle.yf.com.mafengwo_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import wx.eigle.yf.com.mafengwo_app.MainActivity;
import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/21.
 */

public class ZhuCe_Successful_1_activity extends AppCompatActivity {
        private LinearLayout back_Btn;
    private Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce_successful_1_activity);

        handler=new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==1)
                {
                    Intent intent=new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);

            }
        }).start();


        back_Btn= (LinearLayout) findViewById(R.id.back_btn);
        back_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplication(),SheZhi_HuiYuanActivity.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

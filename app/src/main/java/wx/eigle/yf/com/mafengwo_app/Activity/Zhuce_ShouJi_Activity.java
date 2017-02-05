package wx.eigle.yf.com.mafengwo_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/20.
 */


public class Zhuce_ShouJi_Activity extends AppCompatActivity {
        private LinearLayout tiaojiaoBtn;
    private  LinearLayout back_btn2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce_shouji_layout);
        tiaojiaoBtn= (LinearLayout) findViewById(R.id.tijiaoBtn);
        tiaojiaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),SheZhi_HuiYuanActivity.class);
                startActivity(intent);
            }
        });

        back_btn2= (LinearLayout) findViewById(R.id.back_btn2);
        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),dengluAvtvity.class);
                startActivity(intent);
            }
        });

    }
}

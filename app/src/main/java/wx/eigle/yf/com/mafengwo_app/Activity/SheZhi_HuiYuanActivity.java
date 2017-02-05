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

public class SheZhi_HuiYuanActivity extends AppCompatActivity{
     private LinearLayout getBtn;
    private LinearLayout back_btn1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shezhi_huiyuan_layout);

        getBtn= (LinearLayout) findViewById(R.id.tijiaoBtn);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplication(),ZhuCe_Successful_activity.class);
                startActivity(intent);

            }
        });
        back_btn1= (LinearLayout) findViewById( R.id.back_btn1);
        back_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),Zhuce_ShouJi_Activity.class);
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

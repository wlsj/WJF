package wx.eigle.yf.com.mafengwo_app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/21.
 */

public class ZhuCe_Successful_activity extends AppCompatActivity {
            private TextView getBtn;
            private SharedPreferences sp;
             private String pwd;
             Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce_successful_activity);
        context=this;
        sp=getSharedPreferences("GuestureLockSP",MODE_PRIVATE);
        getBtn= (TextView) findViewById(R.id.getBtn_successful);
        pwd = sp.getString("pwd", null);
        if(TextUtils.isEmpty(pwd)){
            getBtn.setText("提交并设置密码");
        }else {
            getBtn.setText("提交并输入密码");
        }





        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplication(),GuestureLockActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();

    }
}

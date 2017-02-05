package wx.eigle.yf.com.mafengwo_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import wx.eigle.yf.com.mafengwo_app.MainActivity;
import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/17.
 */

public class dengluAvtvity extends AppCompatActivity {
    private LinearLayout dlBtn;
    private LinearLayout zcBtn;
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
             setContentView(R.layout.denglu_activity);

dlBtn= (LinearLayout) findViewById(R.id.dlBtn);
       zcBtn= (LinearLayout) findViewById(R.id.zcBtn);
dlBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getApplication(),MainActivity.class);
        startActivity(intent);
    }
});

       zcBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplication(), Zhuce_ShouJi_Activity.class);
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

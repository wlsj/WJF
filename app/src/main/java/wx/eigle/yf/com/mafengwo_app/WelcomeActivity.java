package wx.eigle.yf.com.mafengwo_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import wx.eigle.yf.com.mafengwo_app.Activity.dengluAvtvity;

/**
 * Created by Administrator on 2017/1/17.
 */

public class WelcomeActivity extends AppCompatActivity {
    private RollPagerView mRollPagerView;
    private FloatingActionButton floatingActionButton;
    private int c;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sharedPreferences = getSharedPreferences("c", MODE_WORLD_WRITEABLE);
        editor = sharedPreferences.edit();
        c = sharedPreferences.getInt("c", 0);

        if (c == 0) {
            setContentView(R.layout.welcome);

            floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplication(), dengluAvtvity.class);
                    startActivity(intent);
                }
            });


            mRollPagerView = (RollPagerView) findViewById(R.id.rollviewpager);
            mRollPagerView.setPlayDelay(0);
            //设置透明度
//        mRollPagerView.setAnimationDurtion(500);
            mRollPagerView.setHintView(new ColorPointHintView(getApplication(), Color.RED, Color.BLACK));
            mRollPagerView.setAdapter(new TestNormalAdapter());
        } else {
            Intent intent = new Intent(getApplication(), dengluAvtvity.class);
            startActivity(intent);
        }
        editor.putInt("c", ++c);
        editor.commit();
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.yd1,
                R.drawable.yd2,
                R.drawable.yd3,
                R.drawable.yd4,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }


}

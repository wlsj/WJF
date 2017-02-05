package wx.eigle.yf.com.mafengwo_app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import wx.eigle.yf.com.mafengwo_app.Entity.TabEntity;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment1;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment2;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment3;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment4;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment5;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragmentList;
    String[] mTitle = {"首页", "广告", "应用", "积分","商店"};
    private int[] mIconUnselectIds = {
            R.drawable.ic_home_line,
            R.drawable.ic_advertising_line,
            R.drawable.ic_application_line,
            R.drawable.ic_integral_line,
            R.drawable.ic_store_line
    };
    private int[] mIconSelectIds = {
            R.drawable.ic_home_pink,
            R.drawable.ic_advertising_pink,
            R.drawable.ic_application_pink,
            R.drawable.ic_integral_pink,
            R.drawable.ic_store_pink
    };
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager mViewPager;
    private CommonTabLayout mTabLayout;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionbars_null();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    setContentView(R.layout.activity_main);
                    actionbars_null();
                    fragmentList = new ArrayList<>();
                    fragmentList.add(new Fragment1());
                    fragmentList.add(new Fragment2());
                    fragmentList.add(new Fragment3());
                    fragmentList.add(new Fragment4());
                    fragmentList.add(new Fragment5());
                    for (int i = 0; i < mTitle.length; i++) {
                        mTabEntities.add(new TabEntity(mTitle[i], mIconSelectIds[i], mIconUnselectIds[i]));
                    }
                    mViewPager = (ViewPager) findViewById(R.id.vp_1);
                    mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList));
                    mTabLayout = (CommonTabLayout) findViewById(R.id.tab_1);
                    titile_1();

                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(1);

            }
        }).start();


    }



    private void titile_1() {
        mTabLayout.setTabData(mTabEntities);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            public void onTabReselect(int position) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mViewPager.setCurrentItem(0);
    }

    private void actionbars_null() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    }
}

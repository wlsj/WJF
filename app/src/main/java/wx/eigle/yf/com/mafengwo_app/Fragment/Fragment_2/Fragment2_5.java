package wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by yue on 2017/1/17.
 */

public class Fragment2_5 extends Fragment {
    private String[] title={"已缓存","正在缓存"};
    private SegmentTabLayout segmentTabLayout;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.fragment2_5,container,false);

        segmentTabLayout= (SegmentTabLayout) view.findViewById(R.id.tl_11);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager111);
        fragmentList=new ArrayList<>();
        fragmentList.add(new Fragment2_5_small1());
        fragmentList.add(new Fragment2_5_small2());
        segmentTabLayout.setTabData(title);
        segmentTabLayout.showDot(1);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager(),fragmentList));
        t1();
        return view;
    }
    public  void t1()
    {
        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(1);


    }




    class  MyAdapter extends FragmentPagerAdapter {
        private  List<Fragment>fragment;

        public MyAdapter(FragmentManager fm, List<Fragment>fragments) {
            super(fm);
            fragment=fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return fragment.get(position);
        }

        @Override
        public int getCount() {
            return fragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }




}

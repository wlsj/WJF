package wx.eigle.yf.com.mafengwo_app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2.Fragment2_1;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2.Fragment2_2;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2.Fragment2_3;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2.Fragment2_4;
import wx.eigle.yf.com.mafengwo_app.Fragment.Fragment_2.Fragment2_5;
import wx.eigle.yf.com.mafengwo_app.R;
import wx.eigle.yf.com.mafengwo_app.Activity.SimpleCardFragment;

/**
 * Created by Administrator on 2017/1/13.
 */

public class Fragment2 extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"未完成广告","推荐广告","我的订阅","我的收藏","缓存广告"};
    private MyPageerAdapter mAdapter;
    private List<Fragment> fragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.fragment2,container,false);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        ViewPager vp=(ViewPager) view.findViewById(R.id.viewpager1);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment2_1());
        fragmentList.add(new Fragment2_2());
        fragmentList.add(new Fragment2_3());
        fragmentList.add(new Fragment2_4());
        fragmentList.add(new Fragment2_5());
        mAdapter = new MyPageerAdapter(getChildFragmentManager(),fragmentList);
        vp.setAdapter(mAdapter);
        SlidingTabLayout tabLayout_2 = (SlidingTabLayout) view.findViewById(R.id.tablayout1);
        tabLayout_2.setViewPager(vp);
        vp.setCurrentItem(4);
        return view;
    }
    private class MyPageerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentLists;
        public MyPageerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            fragmentLists = fragmentList;
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentLists.get(position);
        }
        @Override
        public int getCount() {
            return fragmentLists.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}

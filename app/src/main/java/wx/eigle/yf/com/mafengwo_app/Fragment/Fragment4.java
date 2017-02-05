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

import wx.eigle.yf.com.mafengwo_app.Activity.SimpleCardFragment;
import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/13.
 */

public class Fragment4 extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"账户余额","信用查看","转账支付","积分管理"};
    private MyPageerAdapter mAdapter;
    private List<Fragment> fragmentList11;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=(View) inflater.inflate(R.layout.fragment4,container,false);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }
        ViewPager vp=(ViewPager) view.findViewById(R.id.viewpager);
        fragmentList11 = new ArrayList<>();
        fragmentList11.add(new Fragment4_small1());
        fragmentList11.add(new Fragment4_small2());
        fragmentList11.add(new Fragment4_small3());
        fragmentList11.add(new Fragment4_small4());

        mAdapter = new MyPageerAdapter(getChildFragmentManager(),fragmentList11);
        vp.setAdapter(mAdapter);
        SlidingTabLayout tabLayout_1 = (SlidingTabLayout) view.findViewById(R.id.tablayout11);
        tabLayout_1.setViewPager(vp);
        vp.setCurrentItem(0);

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

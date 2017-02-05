package wx.eigle.yf.com.mafengwo_app.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2016/12/1.
 */

public class SimpleCardFragment extends Fragment {
private String mTitle;

    public static  SimpleCardFragment getInstance(String title)
    {
        SimpleCardFragment sf=new SimpleCardFragment();
        sf.mTitle=title;
        return  sf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v=inflater.inflate(R.layout.fr_simple_card,null);
        TextView card_title_tv= (TextView) v.findViewById(R.id.card_title_tv);
        card_title_tv.setText(mTitle);
        return v;
    }



}

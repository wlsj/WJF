package wx.eigle.yf.com.mafengwo_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import wx.eigle.yf.com.mafengwo_app.Activity.Fragment4_small1_1;
import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/26.
 */

public class Fragment4_small1 extends Fragment {
    private LinearLayout zhuanbtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4_small1,container,false);
       zhuanbtn= (LinearLayout) view.findViewById(R.id.zhuan);
       zhuanbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getActivity(),Fragment4_small1_1.class);
               startActivity(intent);
           }
       });

        return  view;


    }
}

package wx.eigle.yf.com.mafengwo_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by yue on 2017/1/17.
 */

public class Fragment5 extends Fragment {
    private LinearLayout luoboBtn;
    private LinearLayout qqbtn;
    private LinearLayout dongtingBtn;
    private LinearLayout xinlangBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment5, container, false);
       luoboBtn= (LinearLayout) view.findViewById(R.id.luoboBtn);
        qqbtn= (LinearLayout) view.findViewById(R.id.qqBtn);
        dongtingBtn= (LinearLayout) view.findViewById(R.id.dongtingBtn);
        xinlangBtn= (LinearLayout) view.findViewById(R.id.xinlangBtn);
        luoboBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Fragment5_1.class);
                startActivity(intent);
            }
        });

        qqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Fragment5_2.class);
                startActivity(intent);
            }
        });

        dongtingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Fragment5_3.class);
                startActivity(intent);
            }
        });


        xinlangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Fragment5_4.class);
                startActivity(intent);
            }
        });





        return view;

    }


}

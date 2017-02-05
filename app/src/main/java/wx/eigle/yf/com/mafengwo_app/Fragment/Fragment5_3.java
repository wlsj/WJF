package wx.eigle.yf.com.mafengwo_app.Fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import wx.eigle.yf.com.mafengwo_app.MainActivity;
import wx.eigle.yf.com.mafengwo_app.R;

/**
 * Created by Administrator on 2017/1/25.
 */

public class Fragment5_3 extends AppCompatActivity {
    private ActionBar actionBar;
    private WebView webView;
    private ImageView back1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://3454.share.sj.360.cn/qcms/view/t/detail?sid=1810274");

        init();
    }

    private void init() {
        back1= (ImageView) findViewById(R.id.backimg);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Fragment5_3.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}

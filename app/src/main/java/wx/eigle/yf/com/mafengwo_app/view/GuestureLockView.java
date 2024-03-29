package wx.eigle.yf.com.mafengwo_app.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import wx.eigle.yf.com.mafengwo_app.R;
import wx.eigle.yf.com.mafengwo_app.Utils.ScreenUtils;


/**
 * Created by Administrator on 2016/5/29 0029.
 */
public class GuestureLockView extends ViewGroup {

    private int baseNum = 6;

    private int[] screenDispaly;

    private int d;
    /**
     * 声明一个集合用来封装坐标集合
     */
    private List<Point> list;
    private Context context;
    private Drawl drawl;

    /**
     * 包含9个ImageView的容器，初始化
     * @param context
     * @param callBack 手势绘制完毕的回调
     */
    public GuestureLockView(Context context, Drawl.GestureCallBack callBack) {
        super(context);
        screenDispaly = ScreenUtils.getScreenDispaly(context);
        d = screenDispaly[0]/3;
        this.list = new ArrayList<Point>();
        this.context = context;
        // 添加9个图标
        addChild();
        // 初始化一个可以画线的view
        drawl = new Drawl(context, list,callBack);
    }

    private void addChild(){
        for (int i = 0; i < 9; i++) {
            ImageView image = new ImageView(context);
            image.setBackgroundResource(R.drawable.ic_key_4);
            this.addView(image);

            // 第几行
            int row = i / 3;
            // 第几列
            int col = i % 3;

            // 定义点的每个属性
            int leftX = col*d+d/baseNum;
            int topY = row*d+d/baseNum;
            int rightX = col*d+d-d/baseNum;
            int bottomY = row*d+d-d/baseNum;

            Point p = new Point(leftX, rightX, topY, bottomY, image,i+1);

            this.list.add(p);
        }
    }


    public void setParentView(ViewGroup parent){
        // 得到屏幕的宽度
        int width = screenDispaly[0];
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, width);

        this.setLayoutParams(layoutParams);
        drawl.setLayoutParams(layoutParams);

        parent.addView(drawl);
        parent.addView(this);

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            //第几行
            int row = i/3;
            //第几列
            int col = i%3;
            View v = getChildAt(i);
            v.layout(col*d+d/baseNum, row*d+d/baseNum, col*d+d-d/baseNum, row*d+d-d/baseNum);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            v.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }


}

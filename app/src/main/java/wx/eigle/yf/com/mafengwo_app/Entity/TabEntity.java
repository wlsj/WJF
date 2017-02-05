package wx.eigle.yf.com.mafengwo_app.Entity;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by Administrator on 2017/1/13.
 */
public class TabEntity implements CustomTabEntity {
    public  String titile;
    public int sele;
    public  int un;
    public TabEntity(String titile, int sele, int un)
    {
        this.titile=titile;
        this.sele=sele;
        this.un=un;
    }

    @Override
    public String getTabTitle() {
        return titile;
    }

    @Override
    public int getTabSelectedIcon() {
        return sele;
    }

    @Override
    public int getTabUnselectedIcon() {
        return un;
    }
}

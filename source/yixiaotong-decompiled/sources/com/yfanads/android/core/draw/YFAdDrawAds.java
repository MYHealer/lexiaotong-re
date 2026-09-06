package com.yfanads.android.core.draw;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.yfanads.android.core.i;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdDrawAds extends i implements YFDrawSetting {
    private int expressHeight;
    private int expressWidth;
    private YFDrawListener listener;

    public YFAdDrawAds(Context context, YFDrawListener yFDrawListener) {
        super(context, yFDrawListener);
        try {
            setAdType(YFAdType.DRAW);
            this.listener = yFDrawListener;
            this.expressWidth = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
            this.expressHeight = ScreenUtil.px2dip(context, ScreenUtil.getScreenHeight(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        super.destroy();
        if (this.listener != null) {
            this.listener = null;
        }
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 5;
    }

    @Override // com.yfanads.android.core.draw.YFDrawSetting
    public int getExpressHeight() {
        return this.expressHeight;
    }

    @Override // com.yfanads.android.core.draw.YFDrawSetting
    public int getExpressWidth() {
        return this.expressWidth;
    }

    public void setExpressSize(int i, int i2) {
        this.expressWidth = i;
        this.expressHeight = i2;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity, ViewGroup viewGroup) {
        super.showAds(activity, viewGroup);
    }
}

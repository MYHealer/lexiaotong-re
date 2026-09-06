package com.yfanads.android.core.roll;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.core.i;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFRollAds extends i implements YFRollAdsSetting {
    private static final int MAX_NUMBER = 5;
    private int adsNumbers;
    private int isReadyIndex;
    private YFRollAdsListener listener;
    public int viewHeight;
    public int viewWidth;

    public YFRollAds(Context context, YFRollAdsListener yFRollAdsListener) {
        super(context, yFRollAdsListener);
        this.viewWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        this.viewHeight = 0;
        this.adsNumbers = 1;
        this.isReadyIndex = 0;
        setAdType(YFAdType.ROLL);
        this.listener = yFRollAdsListener;
        this.viewWidth = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
    }

    @Override // com.yfanads.android.core.roll.YFRollAdsSetting
    public void adapterRenderSuccess(SdkSupplier sdkSupplier, List<View> list) {
        YFLog.traceDebug("adapterRenderSuccess " + sdkSupplier);
        YFRollAdsListener yFRollAdsListener = this.listener;
        if (yFRollAdsListener != null) {
            yFRollAdsListener.onAdRenderSuccess(list);
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
        return 8;
    }

    @Override // com.yfanads.android.core.roll.YFRollAdsSetting
    public int getAdsNumbers() {
        return Math.min(this.adsNumbers, 5);
    }

    @Override // com.yfanads.android.core.roll.YFRollAdsSetting
    public int getReadyIndex() {
        return this.isReadyIndex;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewWidth() {
        return this.viewWidth;
    }

    public void setAdsNumbers(int i) {
        this.adsNumbers = i;
    }

    public void setViewAcceptedSize(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
    }

    public boolean isReady(int i) {
        this.isReadyIndex = i;
        return super.isReady();
    }
}

package com.yfanads.android.core.banner;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.core.i;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdBanner extends i implements YFBannerSetting {
    private YFBannerListener listener;
    public int viewHeight;
    public int viewWidth;

    public YFAdBanner(Context context, YFBannerListener yFBannerListener) {
        super(context, yFBannerListener);
        this.viewWidth = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        this.viewHeight = 0;
        try {
            setAdType(YFAdType.BANNER);
            this.listener = yFBannerListener;
            this.viewWidth = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
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
        return 4;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewWidth() {
        return this.viewWidth;
    }

    public void setViewAcceptedSize(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity, ViewGroup viewGroup) {
        super.showAds(activity, viewGroup);
    }

    @Override // com.yfanads.android.core.i
    public void onAdFailed(YFAdError yFAdError) {
        YFBannerListener yFBannerListener = this.listener;
        if (yFBannerListener != null) {
            yFBannerListener.onAdFailed(yFAdError);
        }
    }
}

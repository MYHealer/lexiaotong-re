package com.meishu.sdk.core.ad.draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.o1;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DrawAd extends com.meishu.sdk.core.ad.a implements IDrawAd {
    public static final int DRAW_AD_TYPE_EXPRESS = 2;
    public static final int DRAW_AD_TYPE_NATIVE = 1;
    private d adWrapper;
    public IDrawVideoListener listener;

    public interface IDrawVideoListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        void onVideoError(int i, int i2);

        void onVideoLoad();

        void pauseBtnClick();

        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    public DrawAd(d dVar, String str) {
        super(dVar, str);
        this.adWrapper = dVar;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void bindAdToView(ViewGroup viewGroup, ViewGroup viewGroup2, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public long getCurrentPosition() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public String getDescription() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }

    public IDrawVideoListener getDrawVideoListener() {
        return this.listener;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public String getIconUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public int getImageMode() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public List<String> getImageUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public int getInteractionType() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public String getSource() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public String getTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public boolean isPlaying() {
        return false;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public boolean isShowEndFrame() {
        return false;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void pause() {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void resume() {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setActivityForDownloadApp(Activity activity) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setCanClickVideo(boolean z) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setOnDrawVideoListener(IDrawVideoListener iDrawVideoListener) {
        this.listener = iDrawVideoListener;
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setPauseIcon(Bitmap bitmap, int i) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void stop() {
    }

    @Override // com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(Activity activity, ViewGroup viewGroup) {
        d dVar = this.adWrapper;
        if (dVar == null || dVar.getSdkAdInfo() == null) {
            return;
        }
        o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}

package com.meishu.sdk.core.ad.draw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IDrawAd extends IAd {
    void bindAdToView(ViewGroup viewGroup, ViewGroup viewGroup2, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener);

    void destroy();

    Bitmap getAdLogo();

    long getCurrentPosition();

    String getDescription();

    int getDrawType();

    long getDuration();

    String getIconUrl();

    int getImageMode();

    List<String> getImageUrl();

    int getInteractionType();

    String getSource();

    String getTitle();

    boolean isPlaying();

    boolean isShowEndFrame();

    void pause();

    void resume();

    void setActivityForDownloadApp(Activity activity);

    void setCanClickVideo(boolean z);

    void setCanInterruptVideoPlay(boolean z);

    void setOnDrawVideoListener(DrawAd.IDrawVideoListener iDrawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);

    void setVideoMute(boolean z);

    void showAd(Activity activity, ViewGroup viewGroup);

    void showAd(ViewGroup viewGroup);

    void stop();
}

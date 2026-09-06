package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface z1 {
    void destroy();

    View getRootView();

    boolean onBackPressed();

    void pause();

    void resume();

    void setAdInfo(MimoAdInfo mimoAdInfo);

    void setDownloadListener(r3 r3Var);

    void setMute(boolean z);

    void setRewardVideoAdViewListener(b2 b2Var);

    void setRewardViewCreateListener(a2 a2Var);

    void setVideoBitmap(Bitmap bitmap);
}

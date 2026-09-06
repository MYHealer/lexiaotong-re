package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface c0 {
    void destroy();

    View getRootView();

    float getTranslationX();

    boolean isStartBtnDownLoad();

    void pause();

    void resume();

    void setAdInfo(MimoAdInfo mimoAdInfo, boolean z);

    void setDownloadListener(r3 r3Var);

    void setTranslationX(float f);

    void setViewListener(b0 b0Var);
}

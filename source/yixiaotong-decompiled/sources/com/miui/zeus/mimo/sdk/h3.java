package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.view.View;
import com.miui.zeus.mimo.sdk.ad.template.TemplateUIController;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface h3 {
    void destroy();

    int getRequestMinHeight();

    int getRequestMinWidth();

    View getRootAdView();

    void pause();

    void resume();

    void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo);

    void setDownloadListener(r3 r3Var);

    void setMute(boolean z);

    void setTemplateUIControllerAdListener(TemplateUIController.a aVar);
}

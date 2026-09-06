package com.miui.zeus.mimo.sdk.view;

import android.app.Activity;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.w3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IBindDataView {
    void destroy();

    View getRootView();

    boolean onBackPressed();

    void pause();

    void resume();

    void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var);
}

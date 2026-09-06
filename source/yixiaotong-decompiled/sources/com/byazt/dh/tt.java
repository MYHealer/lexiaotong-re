package com.byazt.dh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface tt<T> extends com.byazt.oce.c {

    public enum c {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    void c();

    void c(int i);

    void c(Drawable drawable);

    void c(T t, WeakReference<Context> weakReference, boolean z);

    void c(boolean z);

    void tt();

    View ve();
}

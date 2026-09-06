package com.yfanads.android.callback;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface AdAdapterAction {
    void destroy(String str);

    void loadOnly(Context context);

    void show(Activity activity, ViewGroup viewGroup);

    void show(Activity activity, int... iArr);
}

package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}

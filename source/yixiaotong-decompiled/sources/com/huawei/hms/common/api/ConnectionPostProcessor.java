package com.huawei.hms.common.api;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface ConnectionPostProcessor {
    void run(HuaweiApiClient huaweiApiClient, WeakReference<Activity> weakReference);
}

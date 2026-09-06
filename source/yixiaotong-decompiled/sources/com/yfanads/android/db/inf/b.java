package com.yfanads.android.db.inf;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.db.f;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: Frequency.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9648a;
    public final String[] b;

    public b(String str, long j, String str2) {
        this.f9648a = j;
        Context context = YFAdsManager.getInstance().getContext();
        if (context == null) {
            YFLog.error("Frequency constructor context is null");
            return;
        }
        String strA = f.a(context, str2, str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.b = strA.split("&");
    }
}

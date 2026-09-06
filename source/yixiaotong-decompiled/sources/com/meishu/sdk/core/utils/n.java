package com.meishu.sdk.core.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: DownloadUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4922a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ DownloadUtils c;

    public n(DownloadUtils downloadUtils, String str, Context context) {
        this.c = downloadUtils;
        this.f4922a = str;
        this.b = context;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        String[] strArr;
        try {
            k0 k0Var = DownloadUtils.h.get(Integer.valueOf(DownloadUtils.a(this.f4922a)));
            if (k0Var != null && (strArr = k0Var.e) != null) {
                LogUtil.d("DownloadUtils", "Report send dn_succ");
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, str, new i());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int iA = DownloadUtils.a(this.f4922a);
        com.meishu.sdk.core.download.a.C0793a.f4782a.a(this.f4922a);
        NotificationManager notificationManager = this.c.f4863a;
        if (notificationManager != null) {
            notificationManager.cancel(iA);
        }
        DownloadUtils.a(this.b, this.f4922a);
        DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(this.f4922a)));
    }
}

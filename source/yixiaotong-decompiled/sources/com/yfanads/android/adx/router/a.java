package com.yfanads.android.adx.router;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.yfanads.android.adx.core.TransparentActivity;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: AdxRouter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements TransparentActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f9612a;
    public final /* synthetic */ b b;

    public a(b bVar, Activity activity) {
        this.b = bVar;
        this.f9612a = activity;
    }

    public final void a(String str, String str2, long j) {
        Log.d("ThirdAppLaunchAnalysis", "回调结果-->用户拒绝打开 " + str + "，原因: " + str2 + "，用时: " + j + "ms");
        if (TextUtils.isEmpty(this.b.b)) {
            return;
        }
        boolean zA = this.b.a(this.f9612a);
        YFLog.high("LaunchResult open url isOpenSuc " + zA);
        this.b.a(zA, new boolean[0]);
    }

    public final void a(String str, long j) {
        Log.d("ThirdAppLaunchAnalysis", "回调结果-->用户接受打开 " + str + "，用时: " + j + "ms");
        this.b.a(true, new boolean[0]);
    }
}

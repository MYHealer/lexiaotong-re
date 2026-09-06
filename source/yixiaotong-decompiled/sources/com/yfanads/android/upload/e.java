package com.yfanads.android.upload;

import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.io.File;

/* JADX INFO: compiled from: YFCrashHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e extends NetCallBack.NetCallBackString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f9688a;
    public final /* synthetic */ File b;

    public e(File file, File file2) {
        this.f9688a = file;
        this.b = file2;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onFailure */
    public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
        YFLog.error("zip upload fail.");
        f.b = false;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onResponse */
    public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
        f.b = false;
        YFLog.high("zip upload success.");
        YFUtil.deleteDirectory(this.f9688a.getPath());
        YFUtil.deleteDirectory(this.b.getPath());
    }
}

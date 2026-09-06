package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: ErrorReportUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f4929a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public p(String[] strArr, int i, String str) {
        this.f4929a = strArr;
        this.b = i;
        this.c = str;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            String[] strArr = this.f4929a;
            if (strArr != null) {
                z.a(strArr[0], Integer.valueOf(this.b), this.c);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

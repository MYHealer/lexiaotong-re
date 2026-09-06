package com.byazt.jb;

import okhttp3.internal.http2.Header;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 54})
public final class ve {
    public final int i;
    public final com.byazt.mk.a sp;
    public final com.byazt.mk.a x;
    public static final com.byazt.mk.a c = com.byazt.mk.a.c(com.huawei.openalliance.ad.constant.x.bQ);
    public static final com.byazt.mk.a tt = com.byazt.mk.a.c(Header.RESPONSE_STATUS_UTF8);
    public static final com.byazt.mk.a ve = com.byazt.mk.a.c(Header.TARGET_METHOD_UTF8);
    public static final com.byazt.mk.a uj = com.byazt.mk.a.c(Header.TARGET_PATH_UTF8);
    public static final com.byazt.mk.a n = com.byazt.mk.a.c(Header.TARGET_SCHEME_UTF8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.byazt.mk.a f2379a = com.byazt.mk.a.c(Header.TARGET_AUTHORITY_UTF8);

    public ve(String str, String str2) {
        this(com.byazt.mk.a.c(str), com.byazt.mk.a.c(str2));
    }

    public ve(com.byazt.mk.a aVar, String str) {
        this(aVar, com.byazt.mk.a.c(str));
    }

    public ve(com.byazt.mk.a aVar, com.byazt.mk.a aVar2) {
        this.sp = aVar;
        this.x = aVar2;
        this.i = aVar.sp() + 32 + aVar2.sp();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ve) {
            ve veVar = (ve) obj;
            if (this.sp.equals(veVar.sp) && this.x.equals(veVar.x)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.sp.hashCode() + 527) * 31) + this.x.hashCode();
    }

    public String toString() {
        return com.byazt.kh.ve.c("%s: %s", this.sp.c(), this.x.c());
    }
}

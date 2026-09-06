package com.yfanads.android.db.imp;

import java.util.HashMap;

/* JADX INFO: compiled from: MemAdsConfImp.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e implements com.yfanads.android.db.inf.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f9647a = new HashMap();

    @Override // com.yfanads.android.db.inf.a
    public final boolean a(String str, String str2) {
        f9647a.put(str, str2);
        return true;
    }

    @Override // com.yfanads.android.db.inf.a
    public final String load(String str) {
        return (String) f9647a.get(str);
    }
}

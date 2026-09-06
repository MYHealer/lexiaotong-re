package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.f;
import com.baidu.mobads.sdk.internal.u;
import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdservRemoteLoaderImpl implements u {
    @Override // com.baidu.mobads.sdk.internal.u
    public void startLoadRemotePhp(double d, an.b bVar) {
        f.a().a(d, bVar);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return f.a().a(str, str2, str3, classLoader);
    }
}

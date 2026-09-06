package com.meishu.sdk.core;

import com.meishu.sdk.platform.PlatformFactory;
import java.util.Map;

/* JADX INFO: compiled from: AdCore.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, e> f4755a = PlatformFactory.createAll();

    public static e a(String str) {
        return f4755a.get(str);
    }
}

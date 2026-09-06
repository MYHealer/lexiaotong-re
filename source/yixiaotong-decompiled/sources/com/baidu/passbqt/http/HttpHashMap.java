package com.baidu.passbqt.http;

import com.baidu.passbqt.NoProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class HttpHashMap implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f1926a = new HashMap();

    public Map a() {
        return this.f1926a;
    }

    public void a(String str) {
    }

    public void a(String str, String str2) {
        this.f1926a.put(str, str2);
    }

    public void a(Map<? extends String, ? extends String> map) {
        this.f1926a.putAll(map);
    }

    public String b(String str) {
        return this.f1926a.get(str);
    }
}

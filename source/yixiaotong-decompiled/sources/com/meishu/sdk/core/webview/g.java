package com.meishu.sdk.core.webview;

import android.text.TextUtils;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: H5LoadSate.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.meishu.sdk.core.webview.listener.g> f4980a = Collections.synchronizedList(new ArrayList());
    public final ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    public final List<String> c = Collections.synchronizedList(new ArrayList());
    public String d;
    public final String e;

    public g(String str) {
        this.e = str;
        this.d = str;
    }

    public void a(com.meishu.sdk.core.webview.listener.a aVar) {
        if (!(aVar instanceof com.meishu.sdk.core.webview.listener.g) || this.f4980a.contains(aVar)) {
            return;
        }
        this.f4980a.add((com.meishu.sdk.core.webview.listener.g) aVar);
    }

    public void a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && a(str) == -1) {
                LogUtil.dev("H5LoadSate", "recordErrorUrl:" + str);
                this.b.put(str, Integer.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !this.b.containsKey(str)) {
                return -1;
            }
            return this.b.get(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

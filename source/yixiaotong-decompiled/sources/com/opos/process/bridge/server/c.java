package com.opos.process.bridge.server;

import com.huawei.openalliance.ad.constant.x;
import com.opos.process.bridge.a.f;
import com.opos.process.bridge.a.h;
import com.opos.process.bridge.provider.ProcessBridgeLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f8424a = new c();
    private List<f> b = new CopyOnWriteArrayList();
    private List<f> c = new CopyOnWriteArrayList();
    private List<h> d = new CopyOnWriteArrayList();
    private final Map<String, List<a>> e = new ConcurrentHashMap();
    private List<a> f = Collections.synchronizedList(new ArrayList());
    private List<com.opos.process.bridge.a.c> g = Collections.synchronizedList(new ArrayList());

    private c() {
    }

    public static c a() {
        return f8424a;
    }

    public void a(String str, com.opos.process.bridge.a.b bVar) {
        ProcessBridgeLog.d("ProcessBridgeServer", "handleInterceptorResult:-" + str + x.A + bVar);
        if (this.g.size() > 0) {
            for (com.opos.process.bridge.a.c cVar : this.g) {
                ProcessBridgeLog.d("ProcessBridgeServer", "InterceptorResultHandler:" + cVar.getClass().getName());
                cVar.a(str, bVar);
            }
        }
    }

    public void a(String str, String str2, int i, String str3) {
        ProcessBridgeLog.d("ProcessBridgeServer", "handleException:" + str + x.A + str2 + x.A + i + x.A + str3);
        List<a> list = this.e.get(str);
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                ProcessBridgeLog.d("ProcessBridgeServer", "ExceptionHandler for moduleName:" + str + " --- " + aVar.getClass().getName());
                aVar.a(str2, i, str3);
            }
        }
        if (this.f.size() > 0) {
            for (a aVar2 : this.f) {
                ProcessBridgeLog.d("ProcessBridgeServer", "Global ExceptionHandler:" + aVar2.getClass().getName());
                aVar2.a(str2, i, str3);
            }
        }
    }

    public List<f> b() {
        ProcessBridgeLog.d("ProcessBridgeServer", "getPreLinkInterceptors:");
        return this.b;
    }

    public List<f> c() {
        ProcessBridgeLog.d("ProcessBridgeServer", "getServerInterceptors:");
        return this.c;
    }

    public List<h> d() {
        ProcessBridgeLog.d("ProcessBridgeServer", "getServerMethodInterceptors:");
        return this.d;
    }
}

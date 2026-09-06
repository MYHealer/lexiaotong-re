package com.hihonor.hianalytics.hnha;

import com.ubixnow.ooooo.oOOOoo00;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class b {
    private static b e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f3624a = null;
    private volatile boolean b = false;
    private volatile boolean c = false;
    private a d = null;

    public static b b() {
        return e;
    }

    public String a() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.c();
        }
        j2.c("ABDataCenter", "getABServerURL(): ABDataCenter needs init first");
        return "";
    }

    public String a(String str) {
        String str2;
        ConcurrentHashMap<String, c> concurrentHashMap = this.f3624a;
        if (concurrentHashMap == null) {
            j2.g("ABDataCenter", "getGroupID(): Experiment data is empty.");
            return "";
        }
        if (concurrentHashMap.get(str) == null) {
            str2 = "getGroupID: Not found getGroupId from expParamKey";
        } else {
            String strA = this.f3624a.get(str).a();
            if (strA != null) {
                return strA;
            }
            str2 = "getGroupID: groupId is null";
        }
        j2.c("ABDataCenter", str2);
        return "";
    }

    public void a(a aVar) {
        this.d = aVar;
        this.c = false;
        this.b = false;
    }

    public synchronized void a(boolean z) {
        this.c = z;
    }

    public String b(String str) {
        ConcurrentHashMap<String, c> concurrentHashMap = this.f3624a;
        if (concurrentHashMap == null) {
            j2.g("ABDataCenter", "getParamValue(): Experiment data is empty.");
            return "";
        }
        if (concurrentHashMap.get(str) != null) {
            return this.f3624a.get(str).b();
        }
        j2.g("ABDataCenter", "getParamValue() : No corresponding value was found.");
        return "";
    }

    public synchronized void b(boolean z) {
        this.b = z;
    }

    public void c(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("parameters");
        c[] cVarArr = new c[jSONArray.length()];
        ConcurrentHashMap<String, c> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("groupId");
            String string2 = jSONObject.getString("key");
            c cVar = new c(jSONObject.getString(oOOOoo00.OooOo0o), string);
            cVarArr[i] = cVar;
            concurrentHashMap.put(string2, cVar);
        }
        this.f3624a = concurrentHashMap;
    }

    public synchronized boolean c() {
        return this.c;
    }

    public String d() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.b();
        }
        j2.c("ABDataCenter", "getSecretKey(): ABDataCenter needs init first");
        return "";
    }

    public String e() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.d();
        }
        j2.c("ABDataCenter", "getUserID(): ABDataCenter needs init first");
        return "";
    }

    public synchronized boolean f() {
        return this.b;
    }
}

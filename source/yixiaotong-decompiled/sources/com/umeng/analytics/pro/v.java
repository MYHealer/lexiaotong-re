package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class v {
    private static final int c = 5;
    private static JSONArray d = new JSONArray();
    private static Object e = new Object();
    private final Map<String, Long> f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Stack<String> f9181a = new Stack<>();
    com.umeng.analytics.vshelper.a b = PageNameMonitor.getInstance();

    protected int a() {
        return 2;
    }

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (e) {
                    string = d.toString();
                    d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f9181a.size() != 0) {
            String[] strArr = {this.f9181a.peek()};
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, strArr, null, null);
        }
        this.b.customPageBegin(str);
        synchronized (this.f) {
            this.f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f9181a.push(str);
            }
        }
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f.containsKey(str)) {
            synchronized (this.f) {
                l = this.f.get(str);
                this.f.remove(str);
            }
            if (l == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f9181a.size() > 0 && str.equals(this.f9181a.peek())) {
                this.f9181a.pop();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, str);
                    jSONObject.put("duration", jCurrentTimeMillis);
                    jSONObject.put(d.x, l);
                    jSONObject.put("type", a());
                    d.put(jSONObject);
                    if (d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f9181a.size() == 0) {
                return;
            }
            UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
            return;
        }
        if (UMConfigure.isDebugLog() && this.f9181a.size() == 0) {
            UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }

    public void b() {
        String key;
        synchronized (this.f) {
            key = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}

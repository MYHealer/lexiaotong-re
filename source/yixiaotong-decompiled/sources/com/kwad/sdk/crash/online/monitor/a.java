package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static volatile boolean hasInit;

    static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void dC(final String str) {
        i.execute(new bi() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                c.d("perfMonitor.MonitorManager", "configStr:" + str);
                com.kwad.sdk.crash.online.monitor.a.c cVarGt = a.gt(str);
                c.d("perfMonitor.MonitorManager", cVarGt.toJson().toString());
                e.d(cVarGt.bfC);
                a.access$002(true);
            }
        });
    }

    public static com.kwad.sdk.crash.online.monitor.a.c gt(String str) {
        if (TextUtils.isEmpty(str)) {
            return Qv();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            c.w("perfMonitor.MonitorManager", e);
            return Qv();
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.c Qv() {
        com.kwad.sdk.crash.online.monitor.a.c cVar = new com.kwad.sdk.crash.online.monitor.a.c();
        cVar.bfC = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.bfC.bft = 5;
        return cVar;
    }
}

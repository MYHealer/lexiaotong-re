package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    public static final String TAG = "Ranger_b";
    private List<com.kwad.sdk.m.a.a> bmI;

    static class a {
        private static final b bmM = new b();
    }

    public static b TD() {
        return a.bmM;
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.m.a.a> list = dVar.bmI;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.bmI = list;
    }

    public final void start() {
        TE();
        List<com.kwad.sdk.m.a.a> list = this.bmI;
        if (list == null) {
            com.kwad.sdk.core.d.c.w(TAG, "aggregationCheckConfigList is null");
            return;
        }
        for (com.kwad.sdk.m.a.a aVar : list) {
            try {
                if (T(aVar.bna)) {
                    fD(aVar.bmZ);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
            try {
                if (aVar.bnb != null) {
                    a(aVar);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e2));
            }
        }
    }

    private void a(com.kwad.sdk.m.a.a aVar) {
        String strA = c.TI().a(aVar.bnb);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        E(aVar.bmZ, strA);
    }

    private boolean T(List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean zHv = false;
            for (String str : hw(it.next())) {
                zHv = hv(str);
                if (zHv) {
                    break;
                }
            }
            z &= zHv;
        }
        return z;
    }

    private static boolean hv(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String[] hw(String str) {
        if (str.contains("_")) {
            return str.split("_");
        }
        return new String[]{str};
    }

    public final void hx(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.NX().execute(new Runnable() { // from class: com.kwad.sdk.m.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bmI != null && !b.this.bmI.isEmpty()) {
                        for (com.kwad.sdk.m.a.a aVar : b.this.bmI) {
                            if (b.b(str, aVar.bnc)) {
                                b.fH(aVar.bmZ);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.NX().execute(new Runnable() { // from class: com.kwad.sdk.m.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.bmI != null && !b.this.bmI.isEmpty()) {
                        for (com.kwad.sdk.m.a.a aVar : b.this.bmI) {
                            if (b.a(stackTraceElementArr, aVar.bnd)) {
                                b.fJ(aVar.bmZ);
                            }
                        }
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w(b.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (!q.a(stackTraceElement).contains(str)) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void TE() {
        long jUD = q.UD();
        if (jUD <= 0) {
            return;
        }
        ba(jUD);
    }

    public final void TF() {
        boolean z = false;
        for (int i = 0; i < this.bmI.size(); i++) {
            com.kwad.sdk.m.a.a aVar = this.bmI.get(i);
            if (fE(aVar.bmZ)) {
                com.kwad.sdk.commercial.c.v(fF(aVar.bmZ));
                z = true;
            }
        }
        if (z) {
            return;
        }
        com.kwad.sdk.commercial.c.v(fF(-1));
    }

    public final void clearAll() {
        for (int i = 0; i < this.bmI.size(); i++) {
            fG(i);
            fI(i);
            fK(i);
            TG();
            fL(i);
        }
    }

    private static void fD(int i) {
        ai.a("ksadsdk_perf_ranger_v2", "aggregation_sdk" + ("_" + i), 1);
    }

    private static boolean fE(int i) {
        return ai.b("ksadsdk_perf_ranger_v2", new StringBuilder("aggregation_sdk").append(new StringBuilder("_").append(i).toString()).toString(), -1) == 1;
    }

    private static com.kwad.sdk.m.b.a.a fF(int i) {
        com.kwad.sdk.m.b.a.a aVar = new com.kwad.sdk.m.b.a.a();
        String str = "_" + i;
        aVar.fN(i);
        aVar.hz(ai.i("ksadsdk_perf_ranger_v2", "aggregation_version" + str, ""));
        aVar.fO(ai.b("ksadsdk_perf_ranger_v2", "crash_times" + str, 0));
        aVar.fP(ai.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, 0));
        aVar.bb(ai.b("ksadsdk_perf_ranger_v2", "ks_launch_delay", -1L));
        aVar.bc(ai.b("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + str, -1L));
        return aVar;
    }

    private static void E(int i, String str) {
        ai.h("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), str);
    }

    private static void fG(int i) {
        ai.h("ksadsdk_perf_ranger_v2", "aggregation_version" + ("_" + i), "");
    }

    public static void fH(int i) {
        String str = "_" + i;
        ai.a("ksadsdk_perf_ranger_v2", "crash_times" + str, ai.b("ksadsdk_perf_ranger_v2", "crash_times" + str, -1) + 1);
    }

    private static void fI(int i) {
        ai.a("ksadsdk_perf_ranger_v2", "crash_times" + ("_" + i), 0);
    }

    public static void fJ(int i) {
        String str = "_" + i;
        ai.a("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, ai.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, -1) + 1);
    }

    private static void fK(int i) {
        ai.a("ksadsdk_perf_ranger_v2", "call_ks_union_times" + ("_" + i), 0);
    }

    private static void ba(long j) {
        ai.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", j);
    }

    private static void TG() {
        ai.a("ksadsdk_perf_ranger_v2", "ks_launch_delay", 0L);
    }

    private static void fL(int i) {
        ai.a("ksadsdk_perf_ranger_v2", "aggregation_launch_delay" + ("_" + i), 0L);
    }
}

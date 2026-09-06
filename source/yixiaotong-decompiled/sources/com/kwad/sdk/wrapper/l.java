package com.kwad.sdk.wrapper;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l {
    private static a buc;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);

    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> bue;
        public List<C0772a> bug;

        /* JADX INFO: renamed from: com.kwad.sdk.wrapper.l$a$a, reason: collision with other inner class name */
        public static class C0772a extends com.kwad.sdk.core.response.a.a {
            public String buh;
            public String bui;
        }
    }

    public static boolean eN(Context context) {
        a aVar = buc;
        if (aVar == null || ar.R(aVar.bue) || ar.R(buc.bug) || !a(context, buc)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, buc)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.bue).iterator();
        while (it.hasNext()) {
            if (ar.a((String) it.next(), name)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0772a c0772a : new CopyOnWriteArrayList(aVar.bug)) {
            String str = c0772a.buh;
            String str2 = c0772a.bui;
            if (ar.a(str, className) && ar.a(str2, methodName)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }

    public static void Ov() {
        if (mHasInit.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.wrapper.l.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a unused = l.buc = new a();
                try {
                    l.buc.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.wrapper.l.1.1
                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return p(jSONObject);
                        }

                        private static JSONObject p(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

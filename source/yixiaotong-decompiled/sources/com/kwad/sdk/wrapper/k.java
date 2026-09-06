package com.kwad.sdk.wrapper;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class k {
    static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }

    static Context unwrapContextIfNeed(Context context) {
        if (be(context)) {
            context = bd(context);
        }
        if (!be(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i = 0; i < 10; i++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fx());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = bd(context);
            if (!be(context)) {
                return context;
            }
        }
        return context;
    }

    static Context eM(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(unwrapContextIfNeed(context).getApplicationContext());
        if (origApplicationContext instanceof Application) {
            return origApplicationContext;
        }
        for (int i = 0; i < 10; i++) {
            origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
            if (origApplicationContext instanceof Application) {
                return origApplicationContext;
            }
            if (be(origApplicationContext)) {
                origApplicationContext = bd(origApplicationContext);
            }
        }
        return origApplicationContext;
    }

    static boolean be(Context context) {
        return context instanceof ResContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Context bd(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }
}

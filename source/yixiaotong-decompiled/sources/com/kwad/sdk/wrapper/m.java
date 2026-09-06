package com.kwad.sdk.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class m {
    private static Application buj;

    public static void d(Application application) {
        if (buj == null) {
            buj = application;
        }
    }

    public static void E(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object objA = ab.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
            if (objA != null) {
                return ((Integer) objA).intValue();
            }
            return 0;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    private static boolean Ya() {
        if (f.XT().Wn()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        LayoutInflater layoutInflaterEU;
        try {
            layoutInflaterEU = eU(context);
            try {
                return layoutInflaterEU.inflate(i, viewGroup, z);
            } catch (RuntimeException e) {
                e = e;
                throw WrapperException.createFromInflater(layoutInflaterEU, e);
            }
        } catch (RuntimeException e2) {
            e = e2;
            layoutInflaterEU = null;
        }
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        LayoutInflater layoutInflaterEU;
        try {
            layoutInflaterEU = eU(context);
            try {
                return eU(context).inflate(i, viewGroup);
            } catch (RuntimeException e) {
                e = e;
                throw WrapperException.createFromInflater(layoutInflaterEU, e);
            }
        } catch (RuntimeException e2) {
            e = e2;
            layoutInflaterEU = null;
        }
    }

    public static Application Yb() {
        Ya();
        Application applicationYc = Yc();
        if (j.XY()) {
            buj = (Application) j.wrapContextIfNeed(applicationYc);
        }
        return buj;
    }

    private static Application Yc() {
        Context origApplicationContext;
        Application application = buj;
        if (application != null) {
            return application;
        }
        Context contextUd = ServiceProvider.Ud();
        if (contextUd instanceof Application) {
            Application application2 = (Application) contextUd;
            buj = application2;
            return application2;
        }
        Context origApplicationContext2 = StubApp.getOrigApplicationContext(contextUd.getApplicationContext());
        if (origApplicationContext2 instanceof Application) {
            Application application3 = (Application) origApplicationContext2;
            buj = application3;
            return application3;
        }
        if (be(origApplicationContext2)) {
            origApplicationContext = j.eM(origApplicationContext2);
        } else if (k.be(origApplicationContext2)) {
            origApplicationContext = k.eM(origApplicationContext2);
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(contextUd.getApplicationContext());
        }
        if (origApplicationContext instanceof Application) {
            buj = (Application) origApplicationContext;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.LW().getApplication();
            if (application4 != null) {
                buj = application4;
            } else if (origApplicationContext instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) origApplicationContext).getBaseContext();
                if (baseContext != null) {
                    baseContext = StubApp.getOrigApplicationContext(baseContext.getApplicationContext());
                }
                if (baseContext instanceof Application) {
                    buj = (Application) baseContext;
                }
            }
        }
        if (buj == null) {
            buj = Yd();
        }
        Application applicationER = eR(buj);
        buj = applicationER;
        return applicationER;
    }

    private static Application Yd() {
        Application application = (Application) ab.a(Val.AT, "currentApplication", new Object[0]);
        return application != null ? application : (Application) ab.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static Activity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context contextEP = eP(context);
        if (contextEP instanceof Activity) {
            return (Activity) contextEP;
        }
        com.kwad.sdk.core.c.b.LW();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static Context wrapContextIfNeed(Context context) {
        Context contextWrapContextIfNeed;
        if (!Ya() || !Ye()) {
            return context;
        }
        if (j.XY()) {
            contextWrapContextIfNeed = j.wrapContextIfNeed(context);
        } else {
            contextWrapContextIfNeed = k.wrapContextIfNeed(context);
        }
        return eO(contextWrapContextIfNeed);
    }

    public static boolean Ye() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu() || f.XT().XU();
    }

    private static Context eO(Context context) {
        if (j.XY() && !be(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fx()));
        } else if (!j.XY() && !k.be(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fx()));
        }
        return context;
    }

    public static Context eP(Context context) {
        Context contextUnwrapContextIfNeed;
        if (!Ya() || !Ye() || eS(context)) {
            return context;
        }
        if (be(context)) {
            contextUnwrapContextIfNeed = j.eL(context);
        } else {
            contextUnwrapContextIfNeed = k.unwrapContextIfNeed(context);
        }
        return eQ(contextUnwrapContextIfNeed);
    }

    private static Context eQ(Context context) {
        if (k.be(context) || (context instanceof b)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fx()));
        }
        return context;
    }

    private static Application eR(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fx() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu() + "--isInnerDex:" + f.XT().XU()));
        return null;
    }

    public static boolean eS(Context context) {
        return (be(context) || k.be(context)) ? false : true;
    }

    private static boolean be(Context context) {
        return context instanceof b;
    }

    public static Context eT(Context context) {
        try {
            if (k.be(context)) {
                context = k.bd(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (eS(context)) {
                return context;
            }
            for (int i = 0; i < 5; i++) {
                if (k.be(context)) {
                    context = k.bd(context);
                }
                if (context instanceof b) {
                    context = ((b) context).getDelegatedContext();
                }
                if (eS(context)) {
                    return context;
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return context;
    }

    public static LayoutInflater eU(Context context) {
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        if (k.be(contextWrapContextIfNeed)) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextWrapContextIfNeed);
            a(layoutInflaterFrom);
            return layoutInflaterFrom;
        }
        return LayoutInflater.from(contextWrapContextIfNeed);
    }

    public static LayoutInflater a(Context context, Context context2) {
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(bc(context)).cloneInContext(context2);
        a(layoutInflaterCloneInContext);
        return layoutInflaterCloneInContext;
    }

    private static Context bc(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    private static void a(LayoutInflater layoutInflater) {
        ab.a(layoutInflater, "mFactory", (Object) null);
        ab.a(layoutInflater, "mFactory2", (Object) null);
    }

    public static void u(Activity activity) {
        k.onDestroy(activity);
    }
}

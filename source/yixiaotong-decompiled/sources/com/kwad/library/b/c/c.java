package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.utils.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.c";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    static class a {
        private WeakReference<Context> aDW;
        private int aDX;
        private StackTraceElement[] aDY;
        private int aDZ;
        private long aEa;

        private a() {
            this.aDW = new WeakReference<>(null);
            this.aDX = 0;
            this.aDY = null;
            this.aDZ = 0;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        static /* synthetic */ int c(a aVar) {
            int i = aVar.aDX;
            aVar.aDX = i + 1;
            return i;
        }

        static /* synthetic */ int g(a aVar) {
            int i = aVar.aDZ;
            aVar.aDZ = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aDW = new WeakReference<>(null);
            this.aDX = 0;
            this.aDY = null;
            this.aDZ = 0;
            this.aEa = 0L;
        }
    }

    private static com.kwad.library.b.a cv(String str) {
        return com.kwad.library.solder.a.a.n(null, str);
    }

    public static Context m(Context context, String str) {
        Context gVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a aVarCv = cv(str);
        if (aVarCv == null || !aVarCv.isLoaded() || (context instanceof d) || b(str, context)) {
            return context;
        }
        Context contextA = a(str, context);
        if (contextA != null) {
            return contextA;
        }
        if (context instanceof ContextThemeWrapper) {
            gVar = new e((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            gVar = new f((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            gVar = new g(context, str);
        } else {
            gVar = new g(context, str);
        }
        a(str, context, gVar);
        return gVar;
    }

    public static Application c(Application application, String str) {
        new StringBuilder("wrapApplicationIfNeed start: ").append(application);
        com.kwad.library.b.c.a aVar = null;
        if (application == null) {
            return null;
        }
        com.kwad.library.b.a aVarCv = cv(str);
        new StringBuilder("wrapApplicationIfNeed plugin: ").append(aVarCv);
        if (aVarCv == null || !aVarCv.isLoaded() || (application instanceof d) || b(str, application)) {
            return application;
        }
        try {
            com.kwad.library.b.c.a aVar2 = new com.kwad.library.b.c.a(application, str);
            try {
                new StringBuilder("wrapApplicationIfNeed after create: ").append(aVar2);
                return aVar2;
            } catch (Throwable th) {
                th = th;
                aVar = aVar2;
                th.getMessage();
                th.printStackTrace();
                return aVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b = 0;
        if (aVar != null) {
            if (aVar.aDW.get() != context || Math.abs(System.currentTimeMillis() - aVar.aEa) >= 150) {
                aVar.clear();
                aVar.aDW = new WeakReference(context);
                aVar.aEa = System.currentTimeMillis();
            } else {
                a.c(aVar);
                if (aVar.aDX >= (context instanceof Application ? 15 : 5) && a(str, context, aVar)) {
                    aVar.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new a(b));
        }
        return false;
    }

    private static boolean a(String str, Context context, a aVar) {
        Context contextA = a(str, context);
        String name = contextA != null ? contextA.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.aDY)) {
            if (aVar.aDY != null) {
                aVar.clear();
                return false;
            }
            aVar.aDY = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.aDY = stackTrace;
        if (aVar.aDZ < 5) {
            return false;
        }
        Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a aVarCv = cv(str);
        if (aVarCv == null || !aVarCv.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof d) {
            return layoutInflater;
        }
        Context contextM = m(context, str);
        return contextM instanceof d ? layoutInflater.cloneInContext(contextM) : layoutInflater;
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

    public static Context unwrapContextIfNeed(Context context) {
        if (be(context)) {
            context = bd(context);
        }
        if (!be(context)) {
            return context;
        }
        for (int i = 0; i < 10; i++) {
            context = bd(context);
            if (!be(context)) {
                return context;
            }
        }
        return context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context bd(Context context) {
        return ((d) context).getDelegatedContext();
    }

    private static boolean be(Context context) {
        return context instanceof d;
    }

    static Resources a(Resources resources, String str) {
        com.kwad.library.b.a aVarCv = cv(str);
        if (aVarCv == null || !aVarCv.isLoaded()) {
            new StringBuilder("replaceExternalResources pluginId: ").append(str).append(" , plugin: ").append(aVarCv);
            return resources;
        }
        Resources resources2 = aVarCv.getResources();
        new StringBuilder("replaceExternalResources pluginId: ").append(str).append(", wrappedResources: ").append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        com.kwad.library.b.a aVarCv = cv(str);
        if (aVarCv == null || !aVarCv.isLoaded() || (resources = aVarCv.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = resources.newTheme();
        themeNewTheme.applyStyle(i, true);
        return themeNewTheme;
    }

    static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b bVarDG;
        com.kwad.library.b.a aVarCv = cv(str);
        return (aVarCv == null || !aVarCv.isLoaded() || (bVarDG = aVarCv.DG()) == null) ? classLoader : bVarDG;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof d ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    static int getThemeResId(Context context) {
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
}

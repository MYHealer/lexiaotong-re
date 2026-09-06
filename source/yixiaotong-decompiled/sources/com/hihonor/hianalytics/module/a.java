package com.hihonor.hianalytics.module;

import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.h;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.process.HiAnalyticsInstance;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, ISubModule> f3703a = new HashMap();
    private static HiAnalyticsInstance b;

    private static ISubModule a(String str) {
        ISubModule iSubModule;
        Map<String, ISubModule> map = f3703a;
        ISubModule iSubModule2 = map.get(str);
        if (iSubModule2 != null) {
            return iSubModule2;
        }
        synchronized (a.class) {
            ISubModule iSubModule3 = map.get(str);
            if (iSubModule3 != null) {
                return iSubModule3;
            }
            String strC = c(str);
            if (TextUtils.isEmpty(strC)) {
                j2.g("SubModuleManager", "checkAndLoadSubModule illegal moduleName=" + str);
                return null;
            }
            try {
                iSubModule = (ISubModule) Class.forName(strC).newInstance();
                try {
                    j2.c("SubModuleManager", "checkAndLoadSubModule moduleName=" + str + ",subModule=" + iSubModule);
                } catch (Throwable th) {
                    th = th;
                    iSubModule3 = iSubModule;
                    j2.c("SubModuleManager", "checkAndLoadSubModule moduleName=" + str + ",failE=" + SystemUtils.getDesensitizedException(th));
                    iSubModule = iSubModule3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (iSubModule != null) {
                f3703a.put(str, iSubModule);
            }
            return iSubModule;
        }
    }

    public static void a(String str, int i, Object... objArr) {
        ISubModule iSubModuleA = a(str);
        if (iSubModuleA == null) {
            j2.g("SubModuleManager", "callModule failModuleName=" + str + ",methodType=" + i + ",params=" + objArr.length);
            return;
        }
        try {
            iSubModuleA.call(i, objArr);
        } catch (Throwable th) {
            j2.g("SubModuleManager", "callModule moduleName=" + str + ",methodType=" + i + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static void b(String str) {
        if (b != null) {
            return;
        }
        synchronized (a.class) {
            if (b != null) {
                return;
            }
            HiAnalyticsAutoConfig hiAnalyticsAutoConfigD = h.d(str);
            if (hiAnalyticsAutoConfigD == null) {
                j2.a("SubModuleManager", "checkModuleInstance tag=" + str + ",autoConfig is null");
                return;
            }
            b = h.g(str);
            j2.c("SubModuleManager", "checkModuleInstance tag=" + str + ",autoConfig=" + hiAnalyticsAutoConfigD + ",instance=" + b);
            a(ModuleConstants.SUB_MODULE_AUTO, 1, b, hiAnalyticsAutoConfigD);
        }
    }

    private static String c(String str) {
        if (ModuleConstants.SUB_MODULE_AUTO.equals(str)) {
            return "com.hihonor.hianalytics.auto.AutoTrackModule";
        }
        return null;
    }
}

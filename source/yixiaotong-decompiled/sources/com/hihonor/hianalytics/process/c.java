package com.hihonor.hianalytics.process;

import android.text.TextUtils;
import com.hihonor.hianalytics.global.AutoCollectEventType;
import com.hihonor.hianalytics.hnha.a2;
import com.hihonor.hianalytics.hnha.g;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.n1;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.o;
import com.hihonor.hianalytics.util.p;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends d implements HiAnalyticsInstanceEx {
    c() {
        super("_instance_ex_tag");
    }

    private boolean a() throws IllegalAccessException, InvocationTargetException {
        boolean zA = p.a("global_v2", "isFirstRun", false);
        if (!zA) {
            p.b("global_v2", "isFirstRun", true);
        }
        return !zA;
    }

    private boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str2) || str.equals(str2)) ? false : true;
    }

    public void a(List<AutoCollectEventType> list) {
        n1 n1VarA;
        boolean z;
        String str;
        j2.c("HianalyticsSDK", "autoCollect() is executed.");
        if (!SystemUtils.a()) {
            str = "userManager.isUserUnlocked() == false";
        } else {
            if (list != null) {
                j2.c("HianalyticsSDK", "autoCollect() executed.");
                if (list.contains(AutoCollectEventType.APP_FIRST_RUN) && a()) {
                    j2.c("HianalyticsSDK", "autoCollect: APP_FIRST_RUN");
                    n1.a().c();
                }
                String strD = g.d();
                String strO = g.o();
                if (list.contains(AutoCollectEventType.APP_UPGRADE) && a(strD, strO)) {
                    j2.c("HianalyticsSDK", "autoCollect: APP_UPGRADE");
                    n1.a().a(strD, strO);
                }
                if (list.contains(AutoCollectEventType.APP_CRASH)) {
                    j2.c("HianalyticsSDK", "autoCollect: APP_CRUSH : true");
                    n1VarA = n1.a();
                    z = true;
                } else {
                    j2.c("HianalyticsSDK", "autoCollect: APP_CRUSH : false");
                    n1VarA = n1.a();
                    z = false;
                }
                n1VarA.a(z);
                return;
            }
            str = "autoCollect() eventTypes is null,End this method!";
        }
        j2.g("HianalyticsSDK", str);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstanceEx
    @Deprecated
    public void handleV1Cache() throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HianalyticsSDK", "userManager.isUserUnlocked() == false");
        } else {
            j2.c("HianalyticsSDK", "handleV1Cache() is executed.");
            a2.a("_instance_ex_tag");
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstanceEx
    public void onStartApp(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        j2.c("HianalyticsSDK", "onStartApp() is executed.");
        if (!SystemUtils.a()) {
            j2.g("HianalyticsSDK", "userManager.isUserUnlocked() == false");
        } else if (o.b("startType", str, 4096) && o.b("startCMD", str2, 4096)) {
            n1.a().b(str, str2);
        } else {
            j2.g("HianalyticsSDK", "onStartApp() Parameter error, please enter the correct parameter");
        }
    }
}

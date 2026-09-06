package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.support.HaStoreUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a1 f3675a = new a1();
    private Map<String, a1.b> b = new HashMap();
    private Map<String, a1.c> c = new HashMap();
    private boolean d = false;

    private void a() {
        if (this.d) {
            return;
        }
        j2.a("HaConfigManager", "cloud config no init");
        k();
    }

    private Map<String, a1.b> b() {
        a();
        return this.b;
    }

    private a1.a c() {
        a();
        return this.f3675a.a();
    }

    private a1 e() {
        a();
        return this.f3675a;
    }

    private a1 g(String str) {
        a1 a1VarA;
        if (TextUtils.isEmpty(str)) {
            j2.a("HaConfigManager", "parse2Object data is null");
            return new a1();
        }
        try {
            j2.a("HaConfigManager", "parse2Object data:" + str);
            a1VarA = a1.a(str);
        } catch (Exception e) {
            j2.b("HaConfigManager", "parse2Object e:" + SystemUtils.getDesensitizedException(e));
            a1VarA = null;
        }
        return a1VarA != null ? a1VarA : new a1();
    }

    private Map<String, a1.c> j() {
        a();
        return this.c;
    }

    public synchronized boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(str).optInt("configVersion");
            j2.a("HaConfigManager", "checkHasNewVersionData,currentVersion:" + this.f3675a.b() + ", newVersion:" + iOptInt);
            return iOptInt > this.f3675a.b();
        } catch (Exception e) {
            j2.b("HaConfigManager", "checkHasNewVersionData e:" + SystemUtils.getDesensitizedException(e));
            return false;
        }
    }

    public boolean b(String str) {
        StringBuilder sbAppend;
        String str2;
        Map<String, a1.b> mapB = b();
        if (mapB == null || mapB.isEmpty()) {
            sbAppend = new StringBuilder("checkIsBlackEvent event=").append(str);
            str2 = " empty blackEvent";
        } else {
            a1.b bVar = mapB.get(str);
            if (bVar == null || bVar.c() == -1 || bVar.b() == -1) {
                sbAppend = new StringBuilder("checkIsBlackEvent event=").append(str);
                str2 = " config is null";
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis < bVar.b() && jCurrentTimeMillis > bVar.c()) {
                    j2.a("HaConfigManager", "checkIsBlackEvent event=" + str + ",ct=" + jCurrentTimeMillis + ",st=" + bVar.c() + ",et=" + bVar.b());
                    return true;
                }
                sbAppend = new StringBuilder("checkIsBlackEvent event=").append(str);
                str2 = " not in effect period";
            }
        }
        j2.a("HaConfigManager", sbAppend.append(str2).toString());
        return false;
    }

    public int c(String str) {
        a1.c cVar = j().get(str);
        if (cVar != null && cVar.a() <= 1800 && cVar.a() >= 0) {
            return cVar.a() * 1000;
        }
        j2.a("HaConfigManager", "getActiveReportLimitPeriod config is null");
        return -1;
    }

    public int d() {
        return e().b();
    }

    public long d(String str) {
        a1.c cVar = j().get(str);
        if (cVar == null || cVar.b() > 1800 || cVar.b() < 0) {
            return -1L;
        }
        return ((long) cVar.b()) * 1000;
    }

    public int e(String str) {
        a1.c cVar = j().get(str);
        if (cVar == null || cVar.c() < 30 || cVar.c() > 1000) {
            return -1;
        }
        return cVar.c();
    }

    public int f() {
        int iC;
        a1.a aVarC = c();
        if (aVarC != null && (iC = aVarC.c()) >= 5) {
            return iC;
        }
        return -1;
    }

    public int f(String str) {
        a1.c cVar = j().get(str);
        if (cVar == null || cVar.d() < 10 || cVar.d() > 500) {
            return -1;
        }
        return cVar.d();
    }

    public int g() {
        a1.a aVarC = c();
        if (aVarC == null) {
            return -1;
        }
        return aVarC.f();
    }

    public int h() {
        a1.a aVarC = c();
        if (aVarC == null) {
            return -1;
        }
        int iE = aVarC.e();
        if (iE == 0) {
            return 0;
        }
        if (iE < 60) {
            return -1;
        }
        int iD = aVarC.d();
        return (iD <= 0 || iD > iE) ? iE : iE + iD;
    }

    public int i() {
        int iG;
        a1.a aVarC = c();
        if (aVarC != null && (iG = aVarC.g()) >= 0 && iG <= 200) {
            return iG;
        }
        return -1;
    }

    public synchronized void k() {
        if (this.d) {
            return;
        }
        n();
        this.d = true;
    }

    public Boolean l() {
        a1.a aVarC = c();
        if (aVarC == null) {
            return null;
        }
        return aVarC.a();
    }

    public Boolean m() {
        a1.a aVarC = c();
        if (aVarC == null) {
            return null;
        }
        return aVarC.b();
    }

    public synchronized void n() {
        j2.a("HaConfigManager", "refreshConfigInfo");
        String multiProcessString = HaStoreUtils.getMultiProcessString("analyticsCloudConfigInfo", "");
        if (!a(multiProcessString)) {
            j2.a("HaConfigManager", "refreshConfigInfo no data change, json:" + multiProcessString);
            return;
        }
        this.f3675a = g(multiProcessString);
        this.b = new HashMap();
        this.c = new HashMap();
        List<a1.b> listC = this.f3675a.c();
        if (listC != null && !listC.isEmpty()) {
            for (a1.b bVar : listC) {
                List<String> listA = bVar.a();
                if (listA != null && !listA.isEmpty()) {
                    Iterator<String> it = listA.iterator();
                    while (it.hasNext()) {
                        this.b.put(it.next(), bVar);
                    }
                }
            }
        }
        List<a1.c> listD = this.f3675a.d();
        if (listD != null && !listD.isEmpty()) {
            for (a1.c cVar : listD) {
                this.c.put(cVar.e(), cVar);
            }
        }
    }
}

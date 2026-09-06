package com.hihonor.hianalytics.hnha;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.openalliance.ad.constant.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class r2 {
    private static final String o = String.valueOf(1);
    private static final String p = String.valueOf(2);
    private static final String q = String.valueOf(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f3678a = false;
    private int b = -1;
    private int c = -1;
    private boolean d = true;
    private boolean e = false;
    private Map<String, String> f = new HashMap();
    private final Map<String, String> g = new HashMap();
    private final Map<String, String> h = new HashMap();
    private Map<String, String> i = new HashMap();
    private final Map<String, String> j = new HashMap();
    private final Map<String, String> k = new HashMap();
    private boolean l = true;
    private boolean m = false;
    private Map<String, Pair<Long, Long>> n = new HashMap();

    private void a() {
        List<String> listD = u.d();
        if (listD.isEmpty()) {
            return;
        }
        j2.a("LocalConfigManager", "checkAndMigrationOldExcludeData old size:" + listD.size());
        HashMap map = new HashMap();
        Iterator<String> it = listD.iterator();
        while (it.hasNext()) {
            map.put(it.next(), o);
        }
        u.a(map);
        u.a("excludeReportAppId", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, String str, boolean z) {
        a(list, true, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, boolean z) {
        a(list, false, null, z);
    }

    private synchronized void a(List<String> list, boolean z, String str, boolean z2) {
        Pair<Boolean, Map<String, String>> pairA;
        String str2;
        long jA = com.hihonor.hianalytics.util.r.a();
        if (z) {
            HashMap map = new HashMap();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                map.put(it.next(), str);
            }
            pairA = z2 ? u.a(map) : u.b(map);
        } else {
            pairA = z2 ? u.a(list) : u.b(list);
        }
        if (z2) {
            Map<String, String> map2 = (Map) pairA.second;
            this.f = map2;
            if (map2 == null) {
                this.f = new HashMap();
            }
            j2.d("LocalConfigManager", "doAddRemoveReportExcludeData spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",isSuccess=" + pairA.first + ",newSize=" + this.f.size() + ",isAdd=" + z + ",isAppId=" + z2 + ",nowValue=" + this.f);
            if (((Boolean) pairA.first).booleanValue()) {
                str2 = "com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_APP_ID_CHANGED";
                c(str2);
            }
        } else {
            Map<String, String> map3 = (Map) pairA.second;
            this.i = map3;
            if (map3 == null) {
                this.i = new HashMap();
            }
            j2.d("LocalConfigManager", "doAddRemoveReportExcludeData spendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",isSuccess=" + pairA.first + ",newSize=" + this.i.size() + ",isAdd=" + z + ",isAppId=" + z2 + ",nowValue=" + this.i);
            if (((Boolean) pairA.first).booleanValue()) {
                str2 = "com.hihonor.hianalytics.config.action.REPORT_EXCLUDE_TAG_CHANGED";
                c(str2);
            }
        }
    }

    private Map<String, Pair<Long, Long>> b(String str) {
        HashMap map = new HashMap();
        try {
            if (TextUtils.isEmpty(str)) {
                return map;
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("appId");
                if (!TextUtils.isEmpty(string)) {
                    long j = jSONObject.getLong("startTime");
                    long j2 = jSONObject.getLong(br.f.h);
                    if (j < j2) {
                        map.put(string, Pair.create(Long.valueOf(j), Long.valueOf(j2)));
                    }
                }
            }
        } catch (Throwable th) {
            j2.g("LocalConfigManager", "parseLimitReportData size=" + this.n.size() + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
        return map;
    }

    private synchronized void b() {
        long jA = com.hihonor.hianalytics.util.r.a();
        if (!this.e || !u.b(this.d)) {
            k();
        }
        a();
        g();
        m();
        if (!this.m || !u.a(this.l)) {
            l();
        }
        j2.a("LocalConfigManager", "doInit spendTime=" + com.hihonor.hianalytics.util.r.e(jA));
    }

    private synchronized String c() {
        try {
            if (this.n.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Pair<Long, Long>> entry : this.n.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                Pair<Long, Long> value = entry.getValue();
                jSONObject.put("appId", entry.getKey());
                jSONObject.put("startTime", ((Long) value.first).longValue());
                jSONObject.put(br.f.h, ((Long) value.second).longValue());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Throwable th) {
            j2.g("LocalConfigManager", "formatLimitReportData size=" + this.n.size() + ",failE=" + SystemUtils.getDesensitizedException(th));
            return "";
        }
    }

    private void c(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(g.p());
        intent.putExtra("sendProcessName", SystemUtils.getProcessName());
        com.hihonor.hianalytics.receiver.a.a(SystemUtils.getContext(), intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public synchronized void e(boolean z) {
        long jA = com.hihonor.hianalytics.util.r.a();
        boolean zB = u.b(z);
        j2.d("LocalConfigManager", "doChangeDataReportState spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isEnable=" + z + ",isSuccess=" + zB);
        if (zB) {
            this.d = z;
            c("com.hihonor.hianalytics.config.action.REPORT_SWITCH_CHANGED");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public synchronized void f(boolean z) {
        long jA = com.hihonor.hianalytics.util.r.a();
        boolean zA = u.a(z);
        j2.d("LocalConfigManager", "doChangeOwnDataReportState spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isEnable=" + z + ",isSuccess=" + zA);
        if (zA) {
            this.l = z;
            c("com.hihonor.hianalytics.config.action.OWN_REPORT_SWITCH_CHANGED");
        }
    }

    private void g() {
        if (!this.g.isEmpty()) {
            this.f = (Map) u.a(this.g).second;
        }
        if (!this.h.isEmpty()) {
            this.f = (Map) u.a(this.h.keySet()).second;
        }
        Map<String, String> map = this.f;
        if (map == null || map.isEmpty()) {
            g(true);
        }
        if (!this.j.isEmpty()) {
            this.i = (Map) u.b(this.j).second;
        }
        if (!this.k.isEmpty()) {
            this.i = (Map) u.b(this.k.keySet()).second;
        }
        Map<String, String> map2 = this.i;
        if (map2 == null || map2.isEmpty()) {
            g(false);
        }
    }

    private synchronized int j() {
        int i;
        i = 0;
        try {
            Iterator<Map.Entry<String, Pair<Long, Long>>> it = this.n.entrySet().iterator();
            long jB = com.hihonor.hianalytics.util.r.b();
            while (it.hasNext()) {
                Pair<Long, Long> value = it.next().getValue();
                if (value == null || jB <= ((Long) value.first).longValue() || jB >= ((Long) value.second).longValue()) {
                    it.remove();
                    i++;
                }
            }
        } catch (Throwable th) {
            j2.g("LocalConfigManager", "removeInvalidReportLimit size=" + this.n.size() + ",failE=" + SystemUtils.getDesensitizedException(th));
        }
        return i;
    }

    public synchronized int a(String str) {
        if (TextUtils.isEmpty(str)) {
            j2.a("LocalConfigManager", "checkReportableState isDataReport=" + this.d + ",size=" + this.f.size());
            return this.d ? 0 : 3;
        }
        String str2 = this.f.get(str);
        j2.a("LocalConfigManager", "checkReportableState isDataReport=" + this.d + ",currentAppIdExcludeType=" + str2 + ",size=" + this.f.size());
        if (q.equals(str2)) {
            return 5;
        }
        Pair<Long, Long> pair = this.n.get(str);
        if (pair != null) {
            long jB = com.hihonor.hianalytics.util.r.b();
            if (jB >= ((Long) pair.first).longValue() && jB <= ((Long) pair.second).longValue()) {
                return 6;
            }
            this.n.remove(str);
            u.a("limitReportData", c());
        }
        if (this.d) {
            return 0;
        }
        if (o.equals(str2)) {
            return 1;
        }
        return p.equals(str2) ? 2 : 3;
    }

    public void a(int i) {
        this.c = Math.max(i, this.c);
    }

    public synchronized void a(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            int iJ = j();
            long jA = com.hihonor.hianalytics.util.r.a();
            long jB = com.hihonor.hianalytics.util.r.b();
            this.n.put(str, Pair.create(Long.valueOf(jB), Long.valueOf(jB + (((long) i) * 1000))));
            String strC = c();
            boolean zA = u.a("limitReportData", strC);
            j2.c("LocalConfigManager", "updateReportLimit spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",appId=" + str + ",delaySecond=" + i + ",removeSize=" + iJ + ",isSuccess=" + zA + ",nowValue=" + strC);
            if (zA) {
                c("com.hihonor.hianalytics.config.action.LIMIT_REPORT_CHANGED");
            }
            return;
        }
        j2.g("LocalConfigManager", "updateReportLimit illegalAppId=" + str + ",delaySecond=" + i);
    }

    public synchronized void a(final List<String> list, int i, final boolean z) {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, String> map3;
        if (list != null) {
            if (!list.isEmpty()) {
                final String strValueOf = String.valueOf(i);
                if (SystemUtils.a()) {
                    t3.c(new r3() { // from class: com.hihonor.hianalytics.hnha.r2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(list, strValueOf, z);
                        }
                    });
                    return;
                }
                if (z) {
                    map = this.f;
                    map2 = this.g;
                    map3 = this.h;
                } else {
                    map = this.i;
                    map2 = this.j;
                    map3 = this.k;
                }
                for (String str : list) {
                    map.put(str, strValueOf);
                    map2.put(str, strValueOf);
                    map3.keySet().remove(str);
                }
                j2.d("LocalConfigManager", "addReportExcludeData in directBoot size=" + list.size() + ",nowSize=" + map.size() + ",unlockRemoveSize=" + map3.size() + ",unlockAddSize=" + map2.size() + ",isAppId:" + z);
                return;
            }
        }
        j2.e("LocalConfigManager", "addReportExcludeData empty excludeTypeList=" + list + ",isAppId:" + z);
    }

    public synchronized void a(Map<p0, Integer> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                Iterator<p0> it = map.keySet().iterator();
                while (it.hasNext()) {
                    p0 next = it.next();
                    if (next == null) {
                        j2.b("LocalConfigManager", "tagTypeInfo is null");
                    } else {
                        if (q.equals(this.i.get(next.b))) {
                        }
                    }
                    it.remove();
                }
            }
        }
    }

    public synchronized void a(final boolean z) {
        if (SystemUtils.a()) {
            t3.c(new r3() { // from class: com.hihonor.hianalytics.hnha.r2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e(z);
                }
            });
            return;
        }
        j2.d("LocalConfigManager", "changeDataReportState in directBoot isEnable=" + z);
        this.d = z;
        this.e = true;
    }

    public synchronized boolean a(String str, String str2) {
        boolean zEquals;
        String str3 = this.i.get(str2);
        if (TextUtils.isEmpty(str)) {
            j2.a("LocalConfigManager", "checkAllowReportByAppIdAndTagType isDataReport=" + this.d + ",size=" + this.f.size());
            if (!this.d) {
                return o.equals(str3) || p.equals(str3);
            }
            zEquals = q.equals(str3);
        } else {
            String str4 = this.f.get(str);
            j2.a("LocalConfigManager", "checkAllowReportByAppIdAndTagType isDataReport=" + this.d + ",currentAppIdExcludeType=" + str4 + ",currentTagExcludeType=" + str3 + ",size=" + this.f.size());
            String str5 = q;
            if (str5.equals(str4)) {
                return false;
            }
            if (!this.d) {
                String str6 = o;
                if (!str6.equals(str4)) {
                    String str7 = p;
                    if (!str7.equals(str4)) {
                        return str6.equals(str3) || str7.equals(str3);
                    }
                }
            }
            zEquals = str5.equals(str3);
        }
        return !zEquals;
    }

    public synchronized void b(final List<String> list, final boolean z) {
        Map<String, String> map;
        Map<String, String> map2;
        Map<String, String> map3;
        if (list != null) {
            if (!list.isEmpty()) {
                if (SystemUtils.a()) {
                    t3.c(new r3() { // from class: com.hihonor.hianalytics.hnha.r2$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(list, z);
                        }
                    });
                    return;
                }
                if (z) {
                    map = this.f;
                    map2 = this.g;
                    map3 = this.h;
                } else {
                    map = this.i;
                    map2 = this.j;
                    map3 = this.k;
                }
                for (String str : list) {
                    map3.put(str, o);
                    map2.keySet().remove(str);
                    map.keySet().remove(str);
                }
                j2.d("LocalConfigManager", "removeReportExcludeData in directBoot size=" + list.size() + ",nowSize=" + map.size() + ",unlockRemoveSize=" + map3.size() + ",unlockAddSize=" + map2.size() + ",isAppId:" + z);
                return;
            }
        }
        j2.e("LocalConfigManager", "removeReportExcludeData empty excludeTypeList=" + list + ",isAppId:" + z);
    }

    public void b(final boolean z) {
        if (SystemUtils.a()) {
            t3.c(new r3() { // from class: com.hihonor.hianalytics.hnha.r2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.f(z);
                }
            });
            return;
        }
        j2.d("LocalConfigManager", "changeOwnDataReportState in directBoot isEnable=" + z);
        this.l = z;
        this.m = true;
    }

    public int d() {
        int iA;
        int i = this.b;
        if (i >= 0 && i < 10000) {
            return i;
        }
        synchronized (this) {
            int iA2 = u.a("deviceGroupNum", -1);
            if (iA2 < 0 || iA2 >= 10000) {
                try {
                    iA = (int) (EncryptUtil.genSecureRandom().nextDouble() * 10000.0d);
                    j2.a("LocalConfigManager", "getDeviceGroup produceNum=" + iA);
                } catch (Throwable th) {
                    iA = com.hihonor.hianalytics.util.b.a(0, 10000);
                    j2.g("LocalConfigManager", "getDeviceGroup produceNum=" + iA + ",firstFailE=" + SystemUtils.getDesensitizedException(th));
                }
                int i2 = 1;
                if ((iA < 0) | (iA >= 10000)) {
                    iA = 1;
                }
                String strA = u.a("deviceGroupNum", (String) null, true, String.valueOf(iA));
                j2.a("LocalConfigManager", "getDeviceGroup setResultValue=" + strA);
                int iA3 = com.hihonor.hianalytics.util.b.a(strA, -1);
                if (!((iA3 < 0) | (iA3 >= 10000))) {
                    i2 = iA3;
                }
                this.b = i2;
            } else {
                j2.a("LocalConfigManager", "getDeviceGroup existNum=" + iA2);
                this.b = iA2;
            }
        }
        return this.b;
    }

    public int e() {
        int i = this.c;
        if (i < 2) {
            return 14;
        }
        if (i >= 2147483640) {
            return Integer.MAX_VALUE;
        }
        return i + 7;
    }

    public void f() {
        if (this.f3678a || !SystemUtils.a()) {
            return;
        }
        synchronized (this) {
            if (!this.f3678a && SystemUtils.a()) {
                b();
                this.f3678a = true;
            }
        }
    }

    public synchronized void g(boolean z) {
        String str;
        String str2;
        long jA = com.hihonor.hianalytics.util.r.a();
        if (z) {
            this.f = u.c();
            str = "updateReportExcludeData-appId spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",size=" + this.f.size() + ",nowValue=" + this.f;
            str2 = "LocalConfigManager";
        } else {
            this.i = u.e();
            str = "updateReportExcludeData-tag spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",size=" + this.i.size() + ",nowValue=" + this.i;
            str2 = "LocalConfigManager";
        }
        j2.a(str2, str);
    }

    public boolean h() {
        f();
        return this.d;
    }

    public boolean i() {
        Boolean boolL;
        f();
        return !SystemUtils.a() || (boolL = p2.b().l()) == null || boolL.booleanValue();
    }

    public synchronized void k() {
        long jA = com.hihonor.hianalytics.util.r.a();
        this.d = u.h();
        j2.a("LocalConfigManager", "updateDataReportState spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isEnable=" + this.d);
    }

    public synchronized void l() {
        long jA = com.hihonor.hianalytics.util.r.a();
        this.l = u.g();
        j2.a("LocalConfigManager", "updateOwnDataReportState spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",isEnable=" + this.l);
    }

    public synchronized void m() {
        long jA = com.hihonor.hianalytics.util.r.a();
        String strA = u.a("limitReportData", (String) null);
        this.n = b(strA);
        j2.a("LocalConfigManager", "updateReportLimitState spendTime=" + com.hihonor.hianalytics.util.r.e(jA) + ",size=" + this.n.size() + ",nowValue=" + strA);
    }
}

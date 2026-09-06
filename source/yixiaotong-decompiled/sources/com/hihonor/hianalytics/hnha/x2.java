package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class x2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3696a;
    private final boolean b;
    private final boolean c;
    private final u2[] d = new u2[4];

    public x2(String str, boolean z) {
        this.f3696a = str;
        this.b = z;
        this.c = "_default_config_tag".equals(str);
    }

    private int a(Map<String, Map<String, List<g1>>> map) {
        if (map == null) {
            return 0;
        }
        Iterator<Map<String, List<g1>>> it = map.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            Iterator<List<g1>> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                List<g1> next = it2.next();
                size += next == null ? 0 : next.size();
            }
        }
        return size;
    }

    private List<n0> a(Map<String, List<g1>> map, int i) throws IllegalAccessException, InvocationTargetException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        LinkedList linkedList = new LinkedList();
        if (map == null) {
            return linkedList;
        }
        int iC = i;
        for (Map.Entry<String, List<g1>> entry : map.entrySet()) {
            List<g1> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                String strA = com.hihonor.hianalytics.util.p.a("common_nc", entry.getKey(), "");
                JSONObject jSONObject3 = null;
                int i2 = 21;
                if (TextUtils.isEmpty(strA)) {
                    jSONObject2 = null;
                } else {
                    try {
                        JSONObject jSONObject4 = new JSONObject(strA);
                        jSONObject = jSONObject4.getJSONObject("headerEx");
                        try {
                            jSONObject3 = jSONObject4.getJSONObject("commonEx");
                            i2 = 22;
                        } catch (JSONException e) {
                            e = e;
                            j2.g("KVMigrationTask", "convertRecordToEvent illegalExHashValueFailE=" + SystemUtils.getDesensitizedException(e));
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        jSONObject = null;
                    }
                    jSONObject2 = jSONObject3;
                    jSONObject3 = jSONObject;
                }
                String strE = com.hihonor.hianalytics.util.r.e();
                for (g1 g1Var : value) {
                    if (g1Var != null) {
                        String strA2 = g1Var.a();
                        if (!TextUtils.isEmpty(strA2)) {
                            String strC = g1Var.c();
                            long jA = com.hihonor.hianalytics.util.b.a(g1Var.d(), 0L);
                            String strF = g1Var.f();
                            String strE2 = g1Var.e();
                            String strB = g1Var.b();
                            int i3 = TextUtils.isEmpty(strE2) ? 0 : com.hihonor.hianalytics.util.b.a(strE2, false) ? 1 : 2;
                            if (this.c) {
                                iC = com.hihonor.hianalytics.util.g.c(strB);
                            }
                            linkedList.add(new n0(this.f3696a, iC, strC, i2, jA, strE, strA2, strF, i3, jSONObject3, jSONObject2));
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    private void a(int i) throws IllegalAccessException, InvocationTargetException {
        Map<String, Map<String, List<g1>>> map;
        Map<String, Map<String, List<g1>>> map2;
        if (!this.c && !h.f(this.f3696a, i)) {
            j2.a("KVMigrationTask", "checkAndDoMigration tag=" + this.f3696a + ",type=" + i + " not have config");
            return;
        }
        this.d[i] = new u2(this.f3696a, i);
        String str = this.f3696a + (this.c ? "" : com.huawei.openalliance.ad.constant.x.A + com.hihonor.hianalytics.util.g.a(i));
        if (u.a(this.f3696a, i, true)) {
            j2.a("KVMigrationTask", "checkAndDoMigration tag=" + this.f3696a + ",type=" + i + " sp already done");
        } else {
            a(h1.a(SystemUtils.getContext(), str, false), e1.a(SystemUtils.getContext(), str, false), true, i, str);
        }
        if (u.a(this.f3696a, i, false)) {
            j2.a("KVMigrationTask", "checkAndDoMigration tag=" + this.f3696a + ",type=" + i + " mmkv already done");
            return;
        }
        try {
            map = h1.b(SystemUtils.getContext(), str, false);
        } catch (RuntimeException e) {
            j2.a("KVMigrationTask", "checkAndDoMigration type=" + i + ",userDataFail=" + SystemUtils.getDesensitizedException(e));
            map = new HashMap<>();
        }
        Map<String, Map<String, List<g1>>> map3 = map;
        try {
            map2 = e1.b(SystemUtils.getContext(), str, false);
        } catch (RuntimeException e2) {
            j2.a("KVMigrationTask", "checkAndDoMigration type=" + i + ",appActionDataFail=" + SystemUtils.getDesensitizedException(e2));
            map2 = new HashMap<>();
        }
        a(map3, map2, false, i, str);
    }

    private void a(Map<String, Map<String, List<g1>>> map, Map<String, Map<String, List<g1>>> map2, boolean z, int i, String str) throws IllegalAccessException, InvocationTargetException {
        if (map == null || map2 == null) {
            this.d[i].a(true);
            j2.a("KVMigrationTask", "doMigrate tag=" + this.f3696a + ",type=" + i + ",isSp=" + z + " not ready");
            return;
        }
        int iA = a(map);
        int iA2 = a(map2);
        if (iA == 0 && iA2 == 0) {
            u.a(this.f3696a, i, z, true);
            this.d[i].a(z, 0, 0, 0);
            j2.a("KVMigrationTask", "doMigrate tag=" + this.f3696a + ",type=" + i + ",isSp=" + z + " total zero");
            return;
        }
        y1.a(map, map2);
        List<n0> listA = a(map2.get(str), i);
        u.a(this.f3696a, i, z, true);
        if (z) {
            com.hihonor.hianalytics.util.p.a(str, false);
        } else {
            com.hihonor.hianalytics.util.m.a(str, false);
        }
        j2.a("KVMigrationTask", "doMigrate tag=" + this.f3696a + ",type=" + i + ",isSp=" + z + ",usersDataSize=" + iA + ",failDataSize=" + iA2 + ",totalSize=" + listA.size());
        this.d[i].a(z, iA, iA2, listA.size());
        p2.c().b(listA);
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, InvocationTargetException {
        long jA = com.hihonor.hianalytics.util.r.a();
        h.q(this.f3696a, u.a("statSelfDataId_" + this.f3696a, "", true, UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "")));
        com.hihonor.hianalytics.util.k.a(300L);
        if (!this.b) {
            com.hihonor.hianalytics.module.a.b(this.f3696a);
        }
        long jA2 = com.hihonor.hianalytics.util.r.a() - jA;
        if (this.c) {
            a(0);
        } else {
            for (int i = 0; i <= 3; i++) {
                a(i);
            }
        }
        j2.c("KVMigrationTask", "migrateEvent haSpendTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA2) + "),isFirstTag=" + this.b + ",isDefaultTag=" + this.c + ",tag=" + this.f3696a + ",operationDesc=" + this.d[0] + ",maintenanceDesc=" + this.d[1] + ",preInstallDesc=" + this.d[2] + ",diffDesc=" + this.d[3]);
    }
}

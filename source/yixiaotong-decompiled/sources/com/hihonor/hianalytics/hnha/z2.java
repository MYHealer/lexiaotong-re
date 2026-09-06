package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class z2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3700a;
    private final Map<p0, Integer> b;
    private final List<p0> c;
    private final boolean d;
    private final int e;
    private final long f;
    private List<Pair<String, Long>> g;
    private final long h;
    private final long i;
    private final long j;
    private final boolean k;
    private final int l;
    private int m;
    private long n;
    private long o;
    private long p;
    private long q;
    private boolean r;
    private final Map<Integer, List<n0>> s;
    private List<n0> t;
    private List<h3> u;
    private final List<n0> v;
    private final List<n0> w;
    private final List<n0> x;
    private final List<n0> y;
    private int z;

    protected z2(z2 z2Var) {
        this.g = null;
        this.m = 0;
        this.n = 0L;
        this.r = false;
        this.s = new HashMap();
        this.t = Collections.emptyList();
        this.v = new LinkedList();
        this.w = new LinkedList();
        this.x = new LinkedList();
        this.y = new LinkedList();
        this.z = 0;
        this.f3700a = z2Var.f3700a;
        this.b = z2Var.b;
        this.c = z2Var.c;
        this.d = z2Var.d;
        this.e = z2Var.e;
        this.l = z2Var.l + 1;
        this.k = z2Var.k;
        List<Pair<String, Long>> list = z2Var.g;
        this.g = list;
        boolean z = list == null || list.isEmpty();
        this.f = z ? z2Var.n : 0L;
        this.n = z ? z2Var.n : 0L;
        long j = z2Var.o;
        this.h = j;
        this.o = j;
        long j2 = z2Var.p;
        this.i = j2;
        this.p = j2;
        long j3 = z2Var.q;
        this.j = j3;
        this.q = j3;
        this.m = z2Var.m;
    }

    protected z2(z2 z2Var, long j, long j2, long j3) {
        this.g = null;
        this.m = 0;
        this.n = 0L;
        this.r = false;
        this.s = new HashMap();
        this.t = Collections.emptyList();
        this.v = new LinkedList();
        this.w = new LinkedList();
        this.x = new LinkedList();
        this.y = new LinkedList();
        this.z = 0;
        this.f3700a = z2Var.f3700a;
        this.b = z2Var.b;
        this.c = z2Var.c;
        this.d = z2Var.d;
        this.e = z2Var.e;
        this.l = 1;
        this.k = false;
        long j4 = z2Var.n;
        this.f = j4;
        this.n = j4;
        this.h = j;
        this.o = j;
        this.i = j2;
        this.p = j2;
        this.j = j3;
        this.q = j3;
        this.m = z2Var.m;
    }

    protected z2(String str, Map<p0, Integer> map, List<p0> list, boolean z, int i) {
        this.g = null;
        this.m = 0;
        this.n = 0L;
        this.r = false;
        this.s = new HashMap();
        this.t = Collections.emptyList();
        this.v = new LinkedList();
        this.w = new LinkedList();
        this.x = new LinkedList();
        this.y = new LinkedList();
        this.z = 0;
        this.f3700a = str;
        this.b = map;
        this.c = list;
        this.d = z;
        this.e = i;
        this.k = true;
        this.l = 1;
        this.f = 0L;
        this.n = 0L;
        this.h = 0L;
        this.o = 0L;
        this.i = 0L;
        this.p = 0L;
        this.j = 0L;
        this.q = 0L;
    }

    private Map<String, Map<String, List<h3>>> a(Map<String, List<h3>> map) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<h3>> entry : map.entrySet()) {
            String key = entry.getKey();
            for (h3 h3Var : entry.getValue()) {
                if ((h3Var instanceof i3) && h3Var.a() > this.o) {
                    this.o = h3Var.a();
                } else if ((h3Var instanceof k3) && h3Var.a() > this.p) {
                    this.p = h3Var.a();
                } else if ((h3Var instanceof j3) && h3Var.a() > this.q) {
                    this.q = h3Var.a();
                }
                String strD = h3Var.d();
                if (TextUtils.isEmpty(strD)) {
                    strD = "requestIdMapDefault";
                    h3Var.b("requestIdMapDefault");
                }
                Map map3 = (Map) map2.get(strD);
                if (map3 == null) {
                    map3 = new HashMap();
                    map2.put(strD, map3);
                }
                List linkedList = (List) map3.get(key);
                if (linkedList == null) {
                    linkedList = new LinkedList();
                    map3.put(key, linkedList);
                }
                linkedList.add(h3Var);
            }
        }
        return map2;
    }

    private void a(int i, n0 n0Var) {
        List<n0> linkedList = this.s.get(Integer.valueOf(i));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.s.put(Integer.valueOf(i), linkedList);
        }
        linkedList.add(n0Var);
    }

    private boolean a() {
        Iterator<Map.Entry<h0, List<n0>>> it;
        long jA = com.hihonor.hianalytics.util.r.a();
        int i = 0;
        int i2 = 1;
        l0 l0VarA = k.a().a(new k0(this.c, this.f, this.l == 1, this.g));
        this.r = l0VarA.f3655a;
        List<n0> list = l0VarA.b;
        this.t = list;
        this.g = l0VarA.c;
        boolean zIsEmpty = list.isEmpty();
        long jA2 = com.hihonor.hianalytics.util.r.a() - jA;
        if (zIsEmpty) {
            j2.c("NewEventPreSendTask", "preSend haNoEventTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "),otherDesc=" + d() + ",tagTypeDesc=" + e());
            if (this.r && l0VarA.a()) {
                t3.b(new z2(this));
            } else if (this.l > 1) {
                t3.b(new z2(this, 0L, 0L, 0L));
                return true;
            }
            return false;
        }
        Map<h0, List<n0>> mapF = f();
        n0 n0Var = null;
        if (!this.w.isEmpty() || !this.v.isEmpty() || !this.x.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.w);
            arrayList.addAll(this.v);
            arrayList.addAll(this.x);
            int iA = k.a().a(arrayList);
            this.z = iA;
            if (iA > 0) {
                p2.g().a(this.s, (Throwable) null);
            }
            com.hihonor.hianalytics.util.h.b(this.z);
        }
        if (!this.y.isEmpty()) {
            j2.a("NewEventPreSendTask", "disableEventList size=" + this.y.size());
            k.a().b(this.y, false);
        }
        boolean zIsEmpty2 = mapF.isEmpty();
        long jA3 = (com.hihonor.hianalytics.util.r.a() - jA) - jA2;
        int i3 = this.z;
        if (zIsEmpty2) {
            j2.a(i3 > 0, "NewEventPreSendTask", "preSend haNoEventTime2=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "),otherDesc=" + d() + ",eventDesc=" + c() + ",tagTypeDesc=" + e());
            if (this.r && (l0VarA.a() || this.n > this.f)) {
                t3.b(new z2(this));
                return true;
            }
            if (this.l <= 1) {
                return false;
            }
            t3.b(new z2(this, 0L, 0L, 0L));
            return true;
        }
        j2.a(i3 > 0, "NewEventPreSendTask", "preSend haNormalTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b(jA3) + "),otherDesc=" + d() + ",groupSize=" + mapF.size() + ",eventDesc=" + c() + ",tagTypeDesc=" + e());
        Iterator<Map.Entry<h0, List<n0>>> it2 = mapF.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<h0, List<n0>> next = it2.next();
            List<n0> value = next.getValue();
            int size = value.size();
            if (size != 0) {
                h0 key = next.getKey();
                n0 n0Var2 = value.get(i);
                n0 n0Var3 = size > i2 ? value.get(size - 1) : n0Var;
                if (n0Var2 == null) {
                    j2.g("NewEventPreSendTask", "preSend haAppId=" + key.a() + ",size=" + size + " firstItem null");
                    it = it2;
                } else {
                    it = it2;
                    if (n0Var2 == n0Var3 || n0Var3 == null) {
                        j2.a("NewEventPreSendTask", "preSend haAppId=" + key.a() + ",size=" + size + ",eventUId=" + n0Var2.a() + ",eventId=" + n0Var2.i() + ",tag=" + n0Var2.l() + ",type=" + n0Var2.o() + ",eventAppId=" + n0Var2.d() + ",time=" + com.hihonor.hianalytics.util.r.a(n0Var2.m()));
                    } else {
                        j2.a((Objects.equals(n0Var2.d(), key.a()) && Objects.equals(n0Var3.d(), key.a())) ? false : true, "NewEventPreSendTask", "preSend haAppId=" + key.a() + ",size=" + size + ",eventUId=" + n0Var2.a() + ",eventId=" + n0Var2.i() + ",tag=" + n0Var2.l() + ",type=" + n0Var2.o() + ",eventAppId=" + n0Var2.d() + ",time=" + com.hihonor.hianalytics.util.r.a(n0Var2.m()) + ",lastEventUId=" + n0Var3.a() + ",lastEventId=" + n0Var3.i() + ",lastTag=" + n0Var3.l() + ",lastType=" + n0Var3.o() + ",lastEventAppId=" + n0Var3.d() + ",lastTime=" + com.hihonor.hianalytics.util.r.a(n0Var3.m()));
                    }
                }
                if (this.d) {
                    if (this.m == 0) {
                        this.m = this.e;
                    }
                    t3.b(new c3(this.f3700a, value, this.e));
                } else {
                    Iterator<n0> it3 = value.iterator();
                    Integer num = null;
                    while (it3.hasNext()) {
                        num = this.b.get(it3.next().x());
                        if (num != null) {
                            break;
                        }
                    }
                    int iIntValue = num == null ? 0 : num.intValue();
                    if (this.m == 0) {
                        this.m = iIntValue;
                    }
                    t3.b(new c3(this.f3700a, value, iIntValue));
                }
                it2 = it;
                l0VarA = l0VarA;
                n0Var = null;
                i = 0;
                i2 = 1;
            }
        }
        l0 l0Var = l0VarA;
        if (!this.r || (!l0Var.a() && this.n <= this.f)) {
            t3.b(new z2(this, 0L, 0L, 0L));
            return true;
        }
        t3.b(new z2(this));
        return true;
    }

    private boolean b() {
        long jA = com.hihonor.hianalytics.util.r.a();
        if (this.l <= 1) {
            com.hihonor.hianalytics.util.k.a(500L);
        }
        j0 j0VarH = k.a().h();
        String str = "),otherDesc=";
        String str2 = "NewEventPreSendTask";
        if (j0VarH == null) {
            j2.g("NewEventPreSendTask", "preSend haStatNoAttrsTime=(" + com.hihonor.hianalytics.util.r.b(com.hihonor.hianalytics.util.r.a() - jA) + "),otherDesc=" + d() + ",tagTypeDesc=" + e());
            return false;
        }
        Pair<Boolean, Map<String, List<h3>>> pairA = k.a().a(this.h, this.i, this.j);
        this.r = ((Boolean) pairA.first).booleanValue();
        Map<String, Map<String, List<h3>>> mapA = a((Map) pairA.second);
        if (mapA.isEmpty()) {
            j2.a("NewEventPreSendTask", "preSend haStatNoInfoTime=(" + com.hihonor.hianalytics.util.r.b(com.hihonor.hianalytics.util.r.a() - jA) + "),otherDesc=" + d() + ",tagTypeDesc=" + e());
            return false;
        }
        this.u = new LinkedList();
        this.t = new LinkedList();
        long jA2 = com.hihonor.hianalytics.util.r.a(-10);
        long jA3 = com.hihonor.hianalytics.util.r.a(10);
        for (Map.Entry<String, Map<String, List<h3>>> entry : mapA.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ha_add_app_version", g.d());
            JSONObject jSONObjectA = com.hihonor.hianalytics.util.l.a(linkedHashMap);
            Iterator<Map.Entry<String, List<h3>>> it = entry.getValue().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<h3>> next = it.next();
                it = it;
                List<h3> value = next.getValue();
                if (value != null && !value.isEmpty()) {
                    String str3 = str;
                    JSONArray jSONArray = new JSONArray();
                    for (h3 h3Var : value) {
                        if (h3Var != null) {
                            try {
                                if (h3Var.a(jA2, jA3)) {
                                    jSONArray.put(h3Var.h());
                                }
                            } catch (JSONException e) {
                                long j = jA3;
                                j2.g(str2, "preSend haException=" + SystemUtils.getDesensitizedException(e));
                                jA3 = j;
                            }
                        }
                        j2.g(str2, "preSend null statInfo");
                    }
                    long j2 = jA3;
                    try {
                        jSONObjectA.put(next.getKey(), jSONArray);
                    } catch (JSONException e2) {
                        j2.g(str2, "preSend ha2Exception=" + SystemUtils.getDesensitizedException(e2));
                    }
                    this.u.addAll(value);
                    j2.a(str2, "preSend statInfoSize=" + value.size() + ",arraySize=" + jSONArray.length() + ",nowTotalSize=" + this.u.size() + ",nowTotalLen=" + jSONObjectA.length() + ",reqId=" + key);
                    str = str3;
                    jA3 = j2;
                }
            }
            n0 n0Var = new n0(j0VarH, "883501010001", 31, com.hihonor.hianalytics.util.r.b(), com.hihonor.hianalytics.util.r.e(), jSONObjectA.toString());
            n0Var.e(key);
            this.t.add(n0Var);
            str = str;
            j0VarH = j0VarH;
            jA3 = jA3;
            jA2 = jA2;
            str2 = str2;
        }
        j2.a(this.z > 0, str2, "preSend haStatNormalTime=(" + com.hihonor.hianalytics.util.r.b(com.hihonor.hianalytics.util.r.a() - jA) + str + d() + ",eventDesc=" + c() + ",tagTypeDesc=" + e());
        t3.b(new c3(this.f3700a, this.t, this.u, this.m));
        if (this.r) {
            t3.b(new z2(this));
        }
        return this.r;
    }

    private String c() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.t.size()).append(",").append(this.w.size()).append(",").append(this.v.size()).append(",").append(this.z);
        if (!this.t.isEmpty()) {
            sb.append(",eventRegion=").append(com.hihonor.hianalytics.util.g.a(this.t));
        }
        if (!this.w.isEmpty()) {
            sb.append(",decryptFailRegion=").append(com.hihonor.hianalytics.util.g.a(this.w));
        }
        if (!this.v.isEmpty()) {
            sb.append(",overTimeRegion=").append(com.hihonor.hianalytics.util.g.a(this.v));
        }
        if (!this.x.isEmpty()) {
            sb.append(",idsEmptyRegion=").append(com.hihonor.hianalytics.util.g.a(this.x));
        }
        if (!this.y.isEmpty()) {
            sb.append(",disableEventRegion=").append(com.hihonor.hianalytics.util.g.a(this.y));
        }
        return sb.append(")").toString();
    }

    private String d() {
        StringBuilder sbAppend;
        long j;
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.f3700a).append(",").append(this.d).append(com.huawei.openalliance.ad.constant.x.A).append(this.e).append(",").append(this.k).append(com.huawei.openalliance.ad.constant.x.A).append(this.l);
        if (this.k) {
            sbAppend = sb.append(",").append(this.r).append(com.huawei.openalliance.ad.constant.x.A).append(this.f).append(com.huawei.openalliance.ad.constant.x.A);
            j = this.n;
        } else {
            StringBuilder sbAppend2 = sb.append(",");
            List<h3> list = this.u;
            sbAppend = sbAppend2.append(list == null ? 0 : list.size()).append(",").append(this.r).append(com.huawei.openalliance.ad.constant.x.A).append(this.h).append(com.huawei.openalliance.ad.constant.x.A).append(this.o).append(",").append(this.i).append(com.huawei.openalliance.ad.constant.x.A).append(this.p).append(",").append(this.j).append(com.huawei.openalliance.ad.constant.x.A);
            j = this.q;
        }
        sbAppend.append(j);
        return sb.append(")").toString();
    }

    private String e() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.b.size()).append(",").append(this.c.size());
        if (!this.b.isEmpty()) {
            sb.append(",tagTypeValue=(");
            for (Map.Entry<p0, Integer> entry : this.b.entrySet()) {
                sb.append(entry.getKey().c()).append(com.huawei.openalliance.ad.constant.x.A).append(entry.getValue()).append(",");
            }
            sb.append(")");
        }
        return sb.append(")").toString();
    }

    private Map<h0, List<n0>> f() {
        int iJ;
        HashMap map = new HashMap();
        int size = this.t.size();
        int i = 0;
        while (i < size) {
            n0 n0Var = this.t.get(i);
            if (n0Var.a() > this.n) {
                this.n = n0Var.a();
            }
            if (TextUtils.isEmpty(n0Var.h())) {
                this.w.add(n0Var);
                this.t.remove(i);
                iJ = n0Var.g();
                if (iJ < 31000 || iJ > 31003) {
                    iJ = 30001;
                }
            } else {
                j0 j0VarJ = n0Var.j();
                if (TextUtils.isEmpty(j0VarJ.g())) {
                    this.x.add(n0Var);
                    this.t.remove(i);
                    iJ = j0VarJ.j();
                    if (iJ < 32000 || iJ > 32003) {
                        iJ = 30002;
                    }
                } else {
                    if (!p2.d().a(j0VarJ.c(), n0Var.l())) {
                        this.y.add(n0Var);
                        this.t.remove(i);
                        i--;
                        size--;
                    } else if (n0Var.b(((long) h.a(n0Var.l(), n0Var.o())) * 86400000)) {
                        this.v.add(n0Var);
                        this.t.remove(i);
                        iJ = ErrorCode.AD_SLOT_NONE;
                    } else {
                        List arrayList = (List) map.get(j0VarJ.c);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map.put(j0VarJ.c, arrayList);
                        }
                        arrayList.add(n0Var);
                    }
                    i++;
                }
            }
            a(iJ, n0Var);
            i--;
            size--;
            i++;
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int iA = p2.d().a((String) null);
            boolean z = true;
            boolean z2 = iA >= 4;
            if (iA > 6) {
                z = false;
            }
            if (z2 && z) {
                j2.c("NewEventPreSendTask", "preSend haForbidReportTaskId=" + this.f3700a + ",reportableState=" + iA);
                p2.c().a(this.f3700a);
            } else {
                if (this.k ? a() : b()) {
                }
            }
        } catch (Throwable th) {
            try {
                j2.c("NewEventPreSendTask", "preSend haRunFailE=" + SystemUtils.getDesensitizedException(th));
            } finally {
                p2.c().a(this.f3700a);
            }
        }
    }
}

package com.byazt.ix;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.nbs.da;
import com.byazt.nr.m;
import com.byazt.yf.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1677, 15})
public class uj extends com.byazt.yt.c {
    public static volatile uj c;
    public List<String> sl;
    public int t;
    public int u;
    public final Map<String, Integer> tt = new HashMap();
    public final Map<String, Long> ve = new HashMap();
    public final Map<String, com.byazt.ll.tt> uj = new HashMap();
    public final Map<String, ConcurrentHashMap<String, List<sp>>> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, com.byazt.pp.c>> f2355a = new HashMap();
    public final Map<String, Boolean> sp = new HashMap();
    public final Map<String, com.byazt.ix.tt> x = new HashMap();
    public boolean i = false;
    public int da = 20;

    public interface tt {
        void c(boolean z);
    }

    public interface ve {
        void c(String str, boolean z, int i, List<com.byazt.yl.ve> list);
    }

    public void c(int i) {
        this.da = i;
    }

    public List<String> tt() {
        return this.sl;
    }

    public int uj() {
        return this.u;
    }

    public int ve() {
        return this.t;
    }

    private uj() {
    }

    public static uj c() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    public void c(String str, int i) {
        this.tt.put(str, Integer.valueOf(i));
    }

    public int tt(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.tt.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean ve(String str, int i) {
        int iTt = tt(str, i);
        return iTt == 2 || iTt == 3 || iTt == 4;
    }

    public void c(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ve.put(str, Long.valueOf(j));
    }

    public Long c(String str) {
        return this.ve.get(str);
    }

    public void c(String str, com.byazt.ll.tt ttVar) {
        if (ttVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.uj.put(str, ttVar);
    }

    public com.byazt.ll.tt tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.uj.get(str);
    }

    public com.byazt.ix.tt ve(String str) {
        return this.x.get(str);
    }

    public void c(String str, sp spVar) {
        if (c(str) == null || c(str).longValue() == spVar.c()) {
            ConcurrentHashMap<String, List<sp>> concurrentHashMap = this.n.get(str);
            String adNetworkSlotId = spVar.c.getAdNetworkSlotId();
            if (TextUtils.isEmpty(adNetworkSlotId)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(spVar);
                ConcurrentHashMap<String, List<sp>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(adNetworkSlotId, copyOnWriteArrayList);
                this.n.put(str, concurrentHashMap2);
                return;
            }
            List<sp> list = concurrentHashMap.get(adNetworkSlotId);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(spVar);
                concurrentHashMap.put(adNetworkSlotId, copyOnWriteArrayList2);
                return;
            }
            list.add(spVar);
        }
    }

    public boolean c(String str, com.byazt.ll.tt ttVar, String str2) {
        boolean z;
        this.sp.put(str, Boolean.FALSE);
        com.byazt.ix.tt ttVar2 = this.x.get(str);
        if (ttVar2 == null) {
            return false;
        }
        List<da> listTt = ttVar2.tt();
        if (com.byazt.eu.tt.tt()) {
            for (da daVar : listTt) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "waterfall: " + daVar.z() + ", loadSort: " + daVar.yv() + ", showSort: " + daVar.p() + ", eCpm: " + daVar.gr());
            }
        }
        boolean[] zArr = {true};
        String strC = c(listTt, str, ttVar, ttVar2, zArr);
        tt(str, ttVar);
        ConcurrentHashMap<String, List<sp>> concurrentHashMap = this.n.get(str);
        if (concurrentHashMap == null) {
            z = false;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= listTt.size()) {
                z = false;
                break;
            }
            List<sp> list = concurrentHashMap.get(listTt.get(i).rh());
            if (list != null && list.size() > 0) {
                z = true;
                break;
            }
            i++;
        }
        if (strC != null) {
            if (z) {
                com.byazt.ng.a.c(this.uj.get(str), strC);
            } else {
                ttVar.tt(3);
                if (zArr[0]) {
                    ttVar.tt(1);
                }
                com.byazt.ng.a.c(ttVar, strC);
            }
        }
        return z;
    }

    private String c(List<da> list, String str, com.byazt.ll.tt ttVar, com.byazt.ix.tt ttVar2, boolean[] zArr) {
        List<sp> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<sp>> concurrentHashMap = this.n.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).rh())) != null && list2.size() > 0 && list2.get(0) != null) {
            sp spVar = list2.get(0);
            if (c(spVar, spVar.uj(), ttVar, "聚合预请求") == -1) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "--==-- 命中最优广告： " + spVar.c.getAdNetWorkName() + ", loadSort: " + spVar.c.getLoadSort() + ", showSort: " + spVar.c.getShowSort());
                return null;
            }
        }
        List<com.byazt.ix.c> listC = c(list, str, concurrentHashMap, ttVar, ttVar2, zArr);
        if (listC.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < listC.size(); i++) {
                sb.append(listC.get(i).c());
                if (i == listC.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String string = new JSONArray(sb.toString()).toString();
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "adCannotUseInfo: " + string);
                return string;
            } catch (JSONException e) {
                com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return null;
    }

    private void tt(String str, com.byazt.ll.tt ttVar) {
        ConcurrentHashMap<String, List<sp>> concurrentHashMap = this.n.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<sp> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    sp spVar = list.get(0);
                    if (c(spVar, spVar.uj(), ttVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    private List<com.byazt.ix.c> c(List<da> list, String str, Map<String, List<sp>> map, com.byazt.ll.tt ttVar, com.byazt.ix.tt ttVar2, boolean[] zArr) {
        List<sp> list2;
        ArrayList arrayList = new ArrayList();
        int iC = ttVar2.c();
        for (int i = 0; i < list.size() && i < iC; i++) {
            String strRh = list.get(i).rh();
            com.byazt.ix.c cVar = new com.byazt.ix.c();
            cVar.tt(strRh);
            cVar.n(list.get(i).p());
            cVar.uj(list.get(i).yv());
            sp spVar = (map == null || (list2 = map.get(strRh)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (spVar == null || spVar.c == null) {
                Map<String, com.byazt.pp.c> map2 = this.f2355a.get(str);
                com.byazt.pp.c cVar2 = map2 != null ? map2.get(strRh) : null;
                if (cVar2 != null) {
                    cVar.tt(3);
                    cVar.ve(cVar2.ve);
                    cVar.c(cVar2.uj);
                } else {
                    cVar.tt(4);
                }
                arrayList.add(cVar);
            } else {
                cVar.c(spVar.c.isHasShown() ? 1 : 0);
                zArr[0] = false;
                int iC2 = c(spVar, this.uj.get(str), ttVar, "预缓存");
                if (iC2 != -1) {
                    cVar.tt(iC2);
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    public List<sp> uj(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<sp>> concurrentHashMap = this.n.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<sp> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.byazt.pp.c> map = this.f2355a.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public void c(final Context context, final String str, final int i) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ix.uj.1
            @Override // java.lang.Runnable
            public void run() {
                uj.this.c(context, str, 2, i, (ve) null);
            }
        });
    }

    public void tt(final Context context, final String str, final int i) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ix.uj.2
            @Override // java.lang.Runnable
            public void run() {
                uj.this.c(context, str, 4, i, (ve) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, int i, int i2, ve veVar) {
        int iTt = tt(str, i2);
        if (!ve(str, i2)) {
            com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "--==-- 配置未开启预加载缓存，req_type: " + iTt);
            if (veVar != null) {
                veVar.c(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.sp.get(str);
        if (bool != null && bool.booleanValue()) {
            com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (veVar != null) {
                veVar.c(str, true, 0, null);
                return;
            }
            return;
        }
        com.byazt.ll.tt ttVar = this.uj.get(str);
        if (ttVar == null) {
            com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.byazt.ll.tt ttVar2 = new com.byazt.ll.tt(ttVar);
        com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.c(str) + "--==-- 预缓存开始请求, req_type: " + iTt);
        com.byazt.ix.tt ttVarC = n.c(context, str, ttVar2.my());
        this.x.put(str, ttVarC);
        this.sp.put(str, Boolean.TRUE);
        ttVar2.uj(str);
        ttVar2.tt(i);
        ttVar2.n(3);
        ttVarC.c(context, ttVar2, veVar);
        a(str);
    }

    private static void a(String str) {
        JSONObject jSONObject;
        com.byazt.it.n nVarTt = com.byazt.vif.uj.tt(com.byazt.bp.c.t().u(), "gm_tt_ad_mediation_sdk_sp");
        String string = nVarTt.getString("preload_rit_ts", "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            jSONObject.put(str, System.currentTimeMillis());
            nVarTt.put("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static long n(String str) {
        String string = com.byazt.vif.uj.tt(com.byazt.bp.c.t().u(), "gm_tt_ad_mediation_sdk_sp").getString("preload_rit_ts", "");
        try {
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string).optLong(str, -1L);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return -1L;
    }

    public void c(final Activity activity, final List<u> list, final int i, final int i2) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ix.uj.3
            @Override // java.lang.Runnable
            public void run() {
                if (uj.this.i) {
                    com.byazt.eu.tt.c("TTMediationSDK", "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    uj.this.i = true;
                    uj.this.t = i;
                    uj.this.u = i2;
                    uj.this.sl = new ArrayList();
                    for (u uVar : list) {
                        if (uVar != null && uVar.tt() != null) {
                            uj.this.sl.addAll(uVar.tt());
                        }
                    }
                    int i3 = i;
                    int i4 = (i3 <= 0 || i3 > 20) ? 2 : i3;
                    int i5 = i2;
                    int i6 = (i5 <= 0 || i5 > 10) ? 2 : i5;
                    List listC = uj.this.c((List<u>) list);
                    if (listC.isEmpty()) {
                        return;
                    }
                    uj.this.new c(activity, listC, i4, i6, new tt() { // from class: com.byazt.ix.uj.3.1
                        @Override // com.byazt.ix.uj.tt
                        public void c(boolean z) {
                            if (z) {
                                return;
                            }
                            com.byazt.psp.n.uj().c(uj.this.n);
                        }
                    }).c();
                    return;
                }
                com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的requestInfos不能是null或者size为0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<u> c(List<u> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.da;
        HashSet hashSet = new HashSet();
        for (u uVar : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (uVar != null && uVar.tt() != null) {
                for (String str : uVar.tt()) {
                    if (arrayList.size() >= i) {
                        break;
                    }
                    if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        hashSet.add(str);
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(str);
                        arrayList.add(new u(uVar.c(), arrayList2));
                    }
                }
            }
        }
        return arrayList;
    }

    @com.byazt.zqa.c(c = {0, 1, 1677, AppTypeIdUtil.NewDevice4GBathOTA})
    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tt f2356a;
        public final List<u> n;
        public int sp;
        public final Activity tt;
        public final int uj;
        public final int ve;
        public int x;

        public static /* synthetic */ int tt(c cVar) {
            int i = cVar.sp;
            cVar.sp = i - 1;
            return i;
        }

        public static /* synthetic */ int ve(c cVar) {
            int i = cVar.x;
            cVar.x = i - 1;
            return i;
        }

        public c(Activity activity, List<u> list, int i, int i2, tt ttVar) {
            this.tt = activity;
            this.n = list;
            this.ve = i;
            this.uj = i2;
            this.f2356a = ttVar;
            this.sp = list.size();
            this.x = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            u uVarRemove;
            for (int i = 0; i < this.ve; i++) {
                if (this.n.size() > 0 && (uVarRemove = this.n.remove(0)) != null) {
                    com.byazt.ll.tt ttVarC = uVarRemove.c();
                    String str = uVarRemove.tt().get(0);
                    if (ttVarC != null) {
                        if (ttVarC.my() == 1) {
                            com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (ttVarC.my() == 2) {
                            com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (ttVarC.my() == 9) {
                            com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else {
                            uj.this.c(str, ttVarC);
                            ttVarC.uj(str);
                            com.byazt.nbs.tt ttVarC2 = com.byazt.ck.uj.c().c(str, 0, 101);
                            if (ttVarC2 != null) {
                                ttVarC.sp(ttVarC2.pf());
                            } else if (ttVarC.my() == 8) {
                                ttVarC.sp(10);
                            }
                            uj.this.c(this.tt, str, 5, 0, new ve() { // from class: com.byazt.ix.uj.c.1
                                @Override // com.byazt.ix.uj.ve
                                public void c(String str2, boolean z, int i2, List<com.byazt.yl.ve> list) {
                                    c.tt(c.this);
                                    if (!z) {
                                        c.ve(c.this);
                                    }
                                    com.byazt.eu.tt.c("TTMediationSDK", "--==-- pendingLoadNum: " + c.this.sp);
                                    if (c.this.sp > 0 || c.this.f2356a == null) {
                                        return;
                                    }
                                    c.this.f2356a.c(c.this.x <= 0);
                                }
                            });
                        }
                    } else {
                        com.byazt.eu.tt.c("TTMediationSDK", "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    }
                }
            }
            if (this.n.size() > 0) {
                com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.ix.uj.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c();
                    }
                }, ((long) this.uj) * 1000);
            }
        }
    }

    public void c(Context context, String str, int i, com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, ve veVar2) {
        com.byazt.ix.ve veVarC = a.c(i, context, str, ttVar == null ? 0 : ttVar.my());
        if (veVarC != null) {
            com.byazt.eu.tt.c("TTMediationSDK", "--==-- 预缓存补充请求发起 reqType: " + i);
            veVarC.c(ttVar, veVar, veVar2);
        }
    }
}

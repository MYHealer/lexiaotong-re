package com.byazt.hr;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 71})
public class x {
    public static final String c = "TTMediationSDK_x";
    public Map<String, sp> tt;
    public com.byazt.jd.c<sp> ve;

    /* JADX INFO: renamed from: com.byazt.hr.x$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 29, 30})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 29, 62})
    private static class c {
        public static x c = new x(null);
    }

    public /* synthetic */ x(AnonymousClass1 anonymousClass1) {
        this();
    }

    private x() {
        this.ve = new com.byazt.jd.tt(com.byazt.bp.tt.getContext());
        this.tt = new ConcurrentHashMap();
    }

    public static x c() {
        return c.c;
    }

    public void c(String str) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.remove(str);
            }
            this.ve.delete(str);
        }
    }

    public void c(String str, String str2) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.ve.delete(str, str2);
        }
    }

    public void c(sp spVar) {
        sp spVarTt;
        n nVar;
        if (spVar.c()) {
            spVarTt = tt(spVar.tt(), spVar.ve());
        } else {
            spVarTt = tt(spVar.tt());
        }
        if (spVarTt == null) {
            if (this.ve != null) {
                Map<String, sp> map = this.tt;
                if (map != null) {
                    map.put(spVar.uj(), spVar);
                }
                this.ve.tt(spVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (n nVar2 : spVarTt.sl()) {
            map2.put(nVar2.ve(), nVar2);
        }
        for (n nVar3 : spVar.sl()) {
            if (map2.containsKey(nVar3.ve()) && (nVar = (n) map2.get(nVar3.ve())) != null) {
                nVar3.c(nVar);
            }
        }
        Map<String, sp> map3 = this.tt;
        if (map3 != null) {
            map3.put(spVar.uj(), spVar);
        }
        tt(spVar);
    }

    public sp tt(String str) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            sp spVar = map != null ? map.get(str) : null;
            if (spVar != null) {
                return spVar;
            }
            sp spVarQuery = this.ve.query(str);
            if (spVarQuery != null) {
                Map<String, sp> map2 = this.tt;
                if (map2 != null) {
                    map2.put(spVarQuery.uj(), spVarQuery);
                }
                return spVarQuery;
            }
        }
        return null;
    }

    public sp tt(String str, String str2) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            sp spVar = map != null ? map.get(str + "_" + str2) : null;
            if (spVar != null) {
                return spVar;
            }
            sp spVarQuery = this.ve.query(str, str2);
            if (spVarQuery != null) {
                Map<String, sp> map2 = this.tt;
                if (map2 != null) {
                    map2.put(spVarQuery.uj(), spVarQuery);
                }
                return spVarQuery;
            }
        }
        return null;
    }

    public void tt(sp spVar) {
        if (this.ve != null) {
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }

    public void c(sp spVar, String str, int i) {
        if (this.ve != null) {
            spVar.c(str, i);
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }

    public void c(sp spVar, String str, long j) {
        if (this.ve != null) {
            spVar.c(str, j);
            Map<String, sp> map = this.tt;
            if (map != null) {
                map.put(spVar.uj(), spVar);
            }
            this.ve.c(spVar);
        }
    }
}

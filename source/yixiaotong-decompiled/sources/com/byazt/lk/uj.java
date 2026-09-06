package com.byazt.lk;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.dna.gu;
import com.byazt.nr.m;
import com.byazt.ut.i;
import com.byazt.ut.sl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 715, 15})
public class uj {
    public volatile gu c;
    public i tt;

    public void c(i iVar) {
        this.tt = iVar;
    }

    private gu tt() {
        if (this.c == null) {
            this.c = (gu) com.byazt.ut.uj.getService("m_d_s");
        }
        return this.c;
    }

    public Map<String, Object> c() {
        gu guVarTt = tt();
        if (guVarTt != null) {
            synchronized (guVarTt) {
                Object data = guVarTt.getData(-1);
                if (data == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    guVarTt.setData(-1, concurrentHashMap);
                    return concurrentHashMap;
                }
                if (data instanceof Map) {
                    return (Map) data;
                }
                return null;
            }
        }
        m.uj(com.byazt.ut.uj.TAG, "provideMemoryService: memoryDataService is null");
        return null;
    }

    private Object c(sl slVar) {
        Map<String, Object> mapC = c();
        if (mapC == null) {
            return null;
        }
        String str = slVar.f2791a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mapC.get(str);
    }

    public Pair<Function, Object> c(sl slVar, com.byazt.dna.c cVar) {
        Map map;
        Object objC = c(slVar);
        if (objC == null) {
            return null;
        }
        if (!slVar.sp || cVar == null) {
            if (objC instanceof Pair) {
                return (Pair) objC;
            }
            m.uj(com.byazt.ut.uj.TAG, "provideMemoryService:noContextService serviceObj is not Pair, key: " + slVar.f2791a);
            return null;
        }
        if (!(objC instanceof Map) || (map = (Map) objC) == null || map.isEmpty() || TextUtils.isEmpty(cVar.getAppId())) {
            return null;
        }
        return (Pair) map.get(cVar.getAppId());
    }

    public void c(sl slVar, com.byazt.dna.c cVar, Object obj, Function function) {
        Map map;
        Map<String, Object> mapC = c();
        if (mapC == null) {
            return;
        }
        String str = slVar.f2791a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!slVar.c.isAssignableFrom(obj.getClass())) {
            if (this.tt != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("key", str);
                    jSONObject.putOpt("origin", obj.getClass().getName());
                    jSONObject.putOpt("apiClazz", slVar.c.getName());
                } catch (JSONException unused) {
                }
                this.tt.c(6, jSONObject.toString(), new RuntimeException("newService is not assignable to apiClazz"));
                return;
            }
            return;
        }
        Object obj2 = mapC.get(str);
        if (!slVar.sp || cVar == null) {
            if (obj2 instanceof Pair) {
                c(slVar, ((Pair) obj2).second, obj);
            }
            mapC.put(str, new Pair(function, obj));
            return;
        }
        String appId = cVar.getAppId();
        if (obj2 instanceof Map) {
            map = (Map) obj2;
            Pair pair = (Pair) map.get(appId);
            if (pair != null) {
                c(slVar, pair.second, obj);
            }
        } else {
            map = new HashMap();
            mapC.put(str, map);
        }
        map.put(appId, new Pair(function, obj));
    }

    public void c(sl slVar, com.byazt.ut.c cVar) {
        Map map;
        Pair<Function, Object> pairC;
        Map<String, Object> mapC = c();
        if (mapC == null) {
            return;
        }
        String str = slVar.f2791a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Object obj = mapC.get(str);
        if (!slVar.sp) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                int iC = com.byazt.rj.c.c((Function) pair.first, slVar.f2791a);
                if (iC >= slVar.ve || (pairC = cVar.ve().c(slVar, null, false)) == null) {
                    return;
                }
                c(slVar, pair.second, pairC.second);
                mapC.put(str, pairC);
                i iVar = this.tt;
                if (iVar != null) {
                    iVar.tt(str, pair.second, pairC.second, iC, slVar.ve);
                }
                cVar.uj().c(slVar, null, pairC.second, (Function) pairC.first, true);
                return;
            }
            return;
        }
        if (!(obj instanceof Map) || (map = (Map) obj) == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : new ArrayList(map.entrySet())) {
            Pair pair2 = (Pair) entry.getValue();
            int iC2 = com.byazt.rj.c.c((Function) pair2.first, slVar.f2791a);
            if (iC2 < slVar.ve) {
                c cVarVe = cVar.ve();
                com.byazt.dna.c cVarC = cVar.c((String) entry.getKey());
                Pair<Function, Object> pairC2 = cVarVe.c(slVar, cVarC, false);
                if (pairC2 != null) {
                    c(slVar, pair2.second, pairC2.second);
                    map.put(entry.getKey(), pairC2);
                    i iVar2 = this.tt;
                    if (iVar2 != null) {
                        iVar2.tt(slVar.f2791a, pair2.second, pairC2.second, iC2, slVar.ve);
                    }
                    cVar.uj().c(slVar, cVarC, pairC2.second, (Function) pairC2.first, true);
                }
            }
        }
    }

    private void c(sl slVar, Object obj, Object obj2) {
        Object objC;
        if (slVar.x == null || slVar.x.length <= 0 || (objC = c((Function) obj)) == null) {
            return;
        }
        c((Function) obj2, objC);
    }

    private void c(Function function, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -3);
        sparseArray.put(1, obj);
        function.apply(sparseArray);
    }

    private Object c(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -2);
        return function.apply(sparseArray);
    }
}

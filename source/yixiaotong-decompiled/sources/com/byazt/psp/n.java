package com.byazt.psp;

import android.text.TextUtils;
import com.alipay.sdk.tid.b;
import com.byazt.ix.sp;
import com.byazt.nr.m;
import com.byazt.vx.h;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 46})
public class n extends c {
    public static volatile n n;
    public final Map<String, double[]> uj;
    public final Map<String, String> ve;

    @Override // com.byazt.psp.c
    public Map<String, String> c() {
        return this.ve;
    }

    private n() {
        super("gm_label_v_v_s");
        this.ve = new ConcurrentHashMap();
        this.uj = new ConcurrentHashMap();
        tt();
    }

    public static n uj() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void c(int i, double d) {
        if (com.byazt.bp.tt.tt().kk()) {
            c(2, String.valueOf(i), 1, d);
        }
    }

    private void uj(int i) {
        if (i == 2) {
            this.uj.clear();
            return;
        }
        this.ve.clear();
        if (this.tt != null) {
            this.tt.clear();
        }
    }

    public Map<String, JSONObject> tt(int i) {
        if (!com.byazt.bp.tt.tt().kk()) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i == 2 ? this.uj : tt(this.ve)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> mapC = c(key, value);
                    JSONObject jSONObject3 = mapC.get("config_req_label_value");
                    JSONObject jSONObject4 = mapC.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        map.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            map.put("config_req_label_value_root", jSONObject2);
        }
        uj(i);
        return map;
    }

    private Map<String, double[]> tt(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] strArrSplit = value.split("_");
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.byazt.bp.tt.tt().c(System.currentTimeMillis() - Long.parseLong(strArrSplit[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    private Map<String, JSONObject> c(String str, double[] dArr) {
        JSONObject jSONObject;
        JSONException e;
        HashMap map = new HashMap();
        String strC = c(dArr);
        JSONObject jSONObject2 = null;
        try {
            if (!strC.equals("-1")) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("input", tt(strC));
                    jSONObject.putOpt(b.f, String.valueOf(System.currentTimeMillis()));
                } catch (JSONException e2) {
                    e = e2;
                    m.c(e);
                }
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.putOpt("ecpm", strC);
            jSONObject4.putOpt(b.f, String.valueOf(System.currentTimeMillis()));
            jSONObject3.putOpt("ecpm_info", jSONObject4);
        } catch (JSONException e4) {
            m.c(e4);
        }
        map.put("config_req_label_value", jSONObject2);
        map.put("event_label_value", jSONObject3);
        return map;
    }

    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.byazt.bp.tt.tt().kk() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void c(JSONObject jSONObject) {
        if (com.byazt.bp.tt.tt().kk()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.byazt.nbs.ve> entry : com.byazt.bp.tt.tt().kp().entrySet()) {
                String key = entry.getKey();
                com.byazt.nbs.ve value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, c(value));
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e2) {
                m.c(e2);
            }
        }
    }

    private void tt(JSONObject jSONObject) {
        Map<String, com.byazt.nbs.ve> mapKp = com.byazt.bp.tt.tt().kp();
        if (mapKp.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.byazt.nbs.ve> entry : mapKp.entrySet()) {
            String key = entry.getKey();
            com.byazt.nbs.ve value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), jSONObjectOptJSONObject);
                        jSONObjectOptJSONObject.put("ecpm_info", new JSONObject());
                    }
                    jSONObjectOptJSONObject.putOpt("label_info", c(value));
                    jSONObjectOptJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.bp.tt.tt().tx()));
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
    }

    @Override // com.byazt.psp.c
    public boolean tt(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.byazt.nbs.ve veVar = com.byazt.bp.tt.tt().kp().get(str);
        if (veVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", c(veVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.bp.tt.tt().tx()));
            return true;
        } catch (JSONException e) {
            m.c(e);
            return false;
        }
    }

    public void c(boolean z, com.byazt.ng.uj ujVar, JSONObject jSONObject, Map<String, Object> map) {
        ujVar.c("reason", Integer.valueOf(!z ? 1 : 0));
        if (map != null) {
            tt(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.byazt.psp.c
    public JSONObject c(com.byazt.nbs.ve veVar) {
        if (veVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", veVar.c());
            jSONObject.putOpt("label_id", Integer.valueOf(veVar.ve()));
            jSONObject.putOpt("label_version", veVar.uj());
            jSONObject.putOpt("upper_bound", Double.valueOf(veVar.n()));
            jSONObject.putOpt("lower_bound", Double.valueOf(veVar.a()));
            jSONObject.putOpt(b.f, veVar.tt());
            return jSONObject;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public static String n() {
        if (!com.byazt.bp.tt.tt().kk()) {
            return null;
        }
        Set<Map.Entry<String, com.byazt.nbs.ve>> setEntrySet = com.byazt.bp.tt.tt().kp().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.byazt.nbs.ve> entry : setEntrySet) {
            String key = entry.getKey();
            com.byazt.nbs.ve value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.c());
                jSONObject2.putOpt(b.f, value.tt());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.a()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.n()));
                jSONObject.putOpt(c(Integer.parseInt(key)), jSONObject2);
            } catch (Exception e) {
                m.c(e);
            }
        }
        return jSONObject.toString();
    }

    public static String ve(int i) {
        com.byazt.nbs.ve veVar;
        if (com.byazt.bp.tt.tt().kk() && (veVar = com.byazt.bp.tt.tt().kp().get(String.valueOf(i))) != null) {
            return veVar.c();
        }
        return null;
    }

    public void c(Map<String, ConcurrentHashMap<String, List<sp>>> map) {
        int adType;
        ConcurrentHashMap<String, List<sp>> value;
        if (!com.byazt.bp.tt.tt().kk() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<sp>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<sp>> value2 = entry.getValue();
            if (value2 == null) {
                adType = 0;
                break;
            }
            Iterator<Map.Entry<String, List<sp>>> it = value2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    adType = 0;
                    break;
                }
                List<sp> value3 = it.next().getValue();
                if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).c != null) {
                    adType = value3.get(0).c.getAdType();
                    break;
                }
            }
            com.byazt.nbs.tt ttVarC = com.byazt.ck.uj.c().c(key, adType, 101);
            if (ttVarC != null && ttVarC.i() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<sp>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<sp> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).c != null) {
                        h.c(value4);
                        sp spVar = value4.get(0);
                        tt(spVar.c.getAdType(), spVar.c.getCpm());
                    }
                }
            }
        }
        com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c(2, (JSONObject) null);
    }

    public void tt(int i, double d) {
        if (com.byazt.bp.tt.tt().kk()) {
            String strValueOf = String.valueOf(i);
            double[] dArr = this.uj.get(strValueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d;
            this.uj.put(strValueOf, dArr);
        }
    }

    @Override // com.byazt.psp.c
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.ve.put(str, str2);
    }

    @Override // com.byazt.psp.c
    public void c(String str, int i, String str2) {
        if (i == 2) {
            this.ve.put(str, str2);
        }
    }
}

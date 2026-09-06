package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O0O0 {
    public static final int OooO = 9;
    public static final int OooO00o = 1;
    public static final int OooO0O0 = 2;
    public static final int OooO0OO = 3;
    public static final int OooO0Oo = 4;
    public static final int OooO0o = 6;
    public static final int OooO0o0 = 5;
    public static final int OooO0oO = 7;
    public static final int OooO0oo = 8;
    public static final int OooOO0 = 10;
    public HashSet<Integer> OooOO0O = new HashSet<>();
    public HashMap<String, HashMap<String, String>> OooOO0o = new HashMap<>();

    private oO00Oo0 OooO00o(oo00o oo00oVar) {
        return o0O0o0.OooO00o(oo00oVar);
    }

    private void OooO00o(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (TextUtils.isEmpty(oo00oVar.getBaseAdConfig().OooOOo0)) {
                return;
            }
            String str = new String(oO0000O.OooO0O0(oo00oVar.getBaseAdConfig().OooOOo0));
            oo0oO0 oo0oo0 = o00o0.OooOOo0;
            oo0oo0.OooO = Math.min(oo0oo0.OooO, Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void OooO00o(HashMap<String, String> map, oO0O0OoO oo0o0ooo) {
        String string;
        if (TextUtils.isEmpty(oo0o0ooo.OooOOO0)) {
            string = "";
        } else {
            try {
                string = new JSONObject(oo0o0ooo.OooOOO0).getJSONObject("advCo").getString(oOO00O.OooO00o);
            } catch (JSONException unused) {
                string = "";
            }
        }
        HashMap<String, String> map2 = this.OooOO0o.get(oo0o0ooo.OooO0OO + oo0o0ooo.OooO0o0);
        if (map2 != null) {
            if (TextUtils.isEmpty(string)) {
                map2.put(o0OO000o.o000o00o, "0");
            } else {
                map2.put(o0OO000o.o000o00o, string);
            }
            map.putAll(map2);
        }
    }

    private void OooO00o(HashMap<String, String> map, oo00o oo00oVar, oO00Oo0 oo00oo0) {
        o0O0o000 o0o0o000;
        o0O0o0 o0o0o0 = oo00oVar.material;
        if (o0o0o0 == null || (o0o0o000 = o0o0o0.OooO00o) == null || TextUtils.isEmpty(o0o0o000.OooO0oO())) {
            return;
        }
        if (oo00oo0 == null) {
            oo00oo0 = new oO00Oo0();
        }
        oo00oo0.OooOO0O = oo00oVar.material.OooO00o.OooO0oO();
        HashMap map2 = new HashMap(map);
        map2.put(o0OO000o.o000o0oo, o0OO000o.o000Ooo0);
        o0OO000.OooO00o(o0OO000o.o000OoOO, map2, oo00oo0);
    }

    public HashMap<String, Object> OooO00o(o0O0o0 o0o0o0) {
        return new o0O00oO0.OooO00o().OooO00o(o0o0o0).OooO00o();
    }

    public HashMap<String, String> OooO00o(String str, String str2) {
        return new o0O00oO0.OooO0O0().OooO0O0(str).OooO00o(str2).OooO00o();
    }

    public abstract void OooO00o(o00O0 o00o0, ErrorInfo errorInfo);

    /* JADX WARN: Code duplicated, block: B:20:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    public void OooO00o(oo0oO0 oo0oo0, ErrorInfo errorInfo) {
        String str;
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, "");
            mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO00o) + "");
            if (oO00000o.o00O0O.OooO00o == 0) {
                if (o0OO000o.o0000OOo.equals(errorInfo.code)) {
                    mapOooO00o.put(o0OO000o.o000oo0o, o0OO000o.o0000Oo0);
                    mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o0000OOo);
                } else if (o0OO000o.o0000o0.equals(errorInfo.code)) {
                    mapOooO00o.put(o0OO000o.o000oo0o, o0OO000o.o0000o0O);
                    mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o0000o0);
                } else {
                    mapOooO00o.put(o0OO000o.o000oo0o, o0OO000o.o0000OoO);
                    str = o0OO000o.o0000Oo;
                }
                mapOooO00o.remove(o0OO000o.o000oo0);
                if (oo0oo0.OooOOOo != 2) {
                    o0OO000.OooO00o(o0OO000o.o0000OOO, mapOooO00o, new Object[0]);
                }
            }
            mapOooO00o.put(o0OO000o.o000oo0o, o0OO000o.o0000o);
            str = o0OO000o.o0000o0o;
            mapOooO00o.put(o0OO000o.o000o0oo, str);
            mapOooO00o.remove(o0OO000o.o000oo0);
            if (oo0oo0.OooOOOo != 2) {
                o0OO000.OooO00o(o0OO000o.o0000OOO, mapOooO00o, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar) {
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o0000O);
        OooO00o(mapOooO00o, oo0oo0, oo00oVar);
        o0OO000.OooO00o(mapOooO00o, oo00oVar);
        mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO00o) + "");
        if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
            mapOooO00o.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
        }
        oo0oo0.OooOo.OooO0Oo = SystemClock.elapsedRealtime();
        if (oo0oo0.OooOOOo != 2) {
            o0OO000.OooO00o(o0OO000o.o000OO, mapOooO00o, new Object[0]);
        }
    }

    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar, int i) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o000Oo0);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            if (!oo00oVar.dsInfo.OooO00o) {
                o0OO000.OooO00o(mapOooO00o, oo00oVar);
            }
            HashMap<String, Object> map = oo00oVar.extraInfo;
            if (map != null && map.get(o0OO000o.o00O00Oo) != null) {
                String str = o0OO000o.o00O00Oo;
                mapOooO00o.put(str, oo00oVar.extraInfo.get(str).toString());
            }
            mapOooO00o.put("duration", oo0oo0.OooOo.OooO0oO != 0 ? (System.currentTimeMillis() - oo0oo0.OooOo.OooO0oO) + "" : "0");
            if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
                mapOooO00o.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
            }
            if (i == 1) {
                mapOooO00o.put(o0OO000o.o00O00Oo, "2");
                mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o000O0Oo);
                o0OO000.OooO00o(o0OO000o.o000O0, mapOooO00o, new Object[0]);
            } else if (i == 2) {
                mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o000OOO);
                o0OO000.OooO00o(o0OO000o.o000OO0o, mapOooO00o, new Object[0]);
            } else if (i != 3) {
                o0OO000.OooO00o(o0OO000o.o000O0O, mapOooO00o, new Object[0]);
            } else {
                mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o000Oo);
                o0OO000.OooO00o(o0OO000o.o000Oo0o, mapOooO00o, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005e A[Catch: Exception -> 0x009a, TRY_ENTER, TryCatch #0 {Exception -> 0x009a, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x001c, B:9:0x0021, B:12:0x002b, B:14:0x0032, B:18:0x003e, B:22:0x0053, B:25:0x005e, B:26:0x0070, B:28:0x008c, B:30:0x0095, B:27:0x0079, B:19:0x0042), top: B:33:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x001c, B:9:0x0021, B:12:0x002b, B:14:0x0032, B:18:0x003e, B:22:0x0053, B:25:0x005e, B:26:0x0070, B:28:0x008c, B:30:0x0095, B:27:0x0079, B:19:0x0042), top: B:33:0x0002 }] */
    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar, ErrorInfo errorInfo) {
        String str;
        StringBuilder sbAppend;
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o000OoO);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            mapOooO00o.put(o0OO000o.o000oo0o, errorInfo.msg);
            if (!TextUtils.isEmpty(errorInfo.platFormCode)) {
                mapOooO00o.put(o0OO000o.o000oo, errorInfo.platFormCode);
            }
            if (!TextUtils.isEmpty(errorInfo.platFormMsg)) {
                mapOooO00o.put(o0OO000o.o000ooO0, errorInfo.platFormMsg);
            }
            if (!oOO00O0.ubix_splash_show_error.equals(errorInfo.code)) {
                if (oOO00O0.OooO00o.SHOW_ERROR.OooO00o().equals(errorInfo.code)) {
                    str = o0OO000o.o000Ooo;
                }
                if (oo00oVar.getBaseAdConfig().OooO0Oo == 2) {
                    sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooOO0);
                } else {
                    sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO00o);
                }
                mapOooO00o.put("duration", sbAppend.append("").toString());
                OooO00o(oo0oo0, mapOooO00o);
                o0OO000.OooO00o(o0OO000o.o000O000, mapOooO00o, new Object[0]);
            }
            str = o0OO000o.o000O0o;
            mapOooO00o.put(o0OO000o.o000o0oo, str);
            if (oo00oVar.getBaseAdConfig().OooO0Oo == 2) {
                sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooOO0);
            } else {
                sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO00o);
            }
            mapOooO00o.put("duration", sbAppend.append("").toString());
            OooO00o(oo0oo0, mapOooO00o);
            o0OO000.OooO00o(o0OO000o.o000O000, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar, HashMap<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put(o0OO000o.o000ooo, oo0oo0.OooO + "");
        map2.put(o0OO000o.o000oooo, oo0oo0.OooOOO + "");
        map2.put(o0OO000o.o000oooO, oo0oo0.OooOO0 + "");
        if (oo00oVar.dsInfo.OooO00o) {
            map2.put(o0OO000o.o00, oo00oVar.dsInfo.OooO0O0 + "");
        } else {
            map2.put(o0OO000o.o00, oo0oo0.OooOO0O + "");
            if (oo0oo0.OooOOOO == 2) {
                map2.put(o0OO000o.o00O0000, oo0oo0.OooOO0o + "");
            }
        }
        map2.put(o0OO000o.o000o00O, oo0oo0.OooO0oO.equals(oo00oVar.getBaseAdConfig().OooO0oO) ? "1" : "2");
        map.putAll(map2);
    }

    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar, boolean z) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o0000oo0);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isAdValid", z + "");
            mapOooO00o.put("extra", jSONObject.toString());
            o0OO000.OooO00o(o0OO000o.o0000oOo, mapOooO00o, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OooO00o(oo0oO0 oo0oo0, oo00o oo00oVar, boolean z, boolean z2) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o0000oo0);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isAdValid", z + "");
            jSONObject.put("isDestroyed", z2 + "");
            mapOooO00o.put("extra", jSONObject.toString());
            o0OO000.OooO00o(o0OO000o.o0000oOo, mapOooO00o, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OooO00o(oo0oO0 oo0oo0, HashMap<String, String> map) {
        try {
            if (TextUtils.isEmpty(oo0oo0.OooOo0o)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("splash_skip_time", oo0oo0.OooOo0o);
            map.put("extra", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public void OooO00o(HashMap<String, String> map, oo0oO0 oo0oo0, oo00o oo00oVar) {
        oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
        HashMap<String, String> map2 = this.OooOO0o.get(oo0o0ooo.OooO0OO + oo0o0ooo.OooO0o0);
        if (map2 != null) {
            map.putAll(map2);
        } else {
            map2 = new HashMap<>();
            this.OooOO0o.put(oo0o0ooo.OooO0OO + oo0o0ooo.OooO0o0, map2);
            OooO0O0(oo0oo0, oo00oVar, map2);
            OooO00o(oo0oo0, oo00oVar, map2);
        }
        map.putAll(map2);
    }

    public boolean OooO00o(int i) {
        return this.OooOO0O.contains(Integer.valueOf(i));
    }

    public boolean OooO00o(o00O0 o00o0) {
        try {
            return o00o0.OooO0OO.OooOOOO.OooO0oo > 0 && SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO00o > o00o0.OooO0OO.OooOOOO.OooO0oo;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void OooO0O0(int i) {
        this.OooOO0O.remove(Integer.valueOf(i));
    }

    public abstract void OooO0O0(o00O0 o00o0, oo00o oo00oVar);

    public void OooO0O0(oo0oO0 oo0oo0, oo00o oo00oVar) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o0000oOO);
            if (oo00oVar != null && oo00oVar.getBaseAdConfig() != null) {
                OooO00o(mapOooO00o, oo00oVar.getBaseAdConfig().OooO00o);
            }
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            mapOooO00o.put("duration", (oo00oVar.getBaseAdConfig().OooO0Oo == 2 ? new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooOO0o) : new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO0Oo)).append("").toString());
            OooO00o(oo0oo0, mapOooO00o);
            o0OO000.OooO00o(o0OO000o.o0000oO0, mapOooO00o, new Object[0]);
            oo0oo0.OooOo.OooO0o = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    public void OooO0O0(oo0oO0 oo0oo0, oo00o oo00oVar, int i) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o000);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            if (!oo00oVar.dsInfo.OooO00o) {
                o0OO000.OooO00o(mapOooO00o, oo00oVar);
            }
            mapOooO00o.put("duration", (oo00oVar.getBaseAdConfig().OooO0Oo == 2 ? new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooOO0) : new StringBuilder().append(SystemClock.elapsedRealtime() - oo0oo0.OooOo.OooO00o)).append("").toString());
            OooO00o(mapOooO00o, oo00oVar.getBaseAdConfig().OooO00o);
            if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
                mapOooO00o.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
            }
            if (oo0oo0.OooOOOo == 2) {
                String str = mapOooO00o.get(o0OO000o.o00O000);
                JSONObject jSONObject = !TextUtils.isEmpty(str) ? new JSONObject(str) : new JSONObject();
                jSONObject.put("settle_price_type", oo0oo0.OooOOO0 + "");
                mapOooO00o.put(o0OO000o.o00O000, jSONObject.toString());
            }
            OooO00o(oo0oo0, mapOooO00o);
            if (i == 1) {
                mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o000O00O);
                o0OO000.OooO00o(o0OO000o.o000O00, mapOooO00o, new Object[0]);
                return;
            }
            if (i == 0) {
                o0OO000.OooO00o(o0OO000o.o0000ooO, mapOooO00o, OooO00o(oo00oVar));
                oo0oo0.OooOo.OooO0oO = System.currentTimeMillis();
            } else {
                if (i != 2) {
                    return;
                }
                mapOooO00o.put(o0OO000o.o000o0oo, o0OO000o.o000Oo0O);
                o0OO000.OooO00o(o0OO000o.o000Oo00, mapOooO00o, OooO00o(oo00oVar));
            }
            OooO00o(mapOooO00o, oo00oVar, OooO00o(oo00oVar));
        } catch (Exception unused) {
        }
    }

    public void OooO0O0(oo0oO0 oo0oo0, oo00o oo00oVar, HashMap<String, String> map) {
        if (oo00oVar == null || oo00oVar.getBaseAdConfig() == null) {
            return;
        }
        oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
        map.put(o0OO000o.oooo00o, oo0o0ooo.OooO0OO + "");
        map.put(o0OO000o.o000o0O, oo0o0ooo.OooO0o0);
        map.put(o0OO000o.o000ooo0, oO0000O.OooO0O0(oo0o0ooo.OooO0OO));
        map.put(o0OO000o.o000o0o0, (oo0o0ooo.OooOO0O == 1 ? new StringBuilder().append(oo00oVar.getBiddingEcpm()) : new StringBuilder().append(oo0o0ooo.OooO)).append("").toString());
        map.put(o0OO000o.o000o0o, oo0o0ooo.OooOO0O + "");
        map.put(o0OO000o.o000o0OO, oo0o0ooo.OooOO0 + "");
        if (oo0o0ooo.OooOO0O == 0) {
            map.put(o0OO000o.o000o0Oo, oo0o0ooo.OooOOO + "");
        }
        if (TextUtils.isEmpty(oo0oo0.OooO0o0)) {
            return;
        }
        map.put(o0OO000o.o000oo0, oo0oo0.OooO0o0);
    }

    public void OooO0O0(oo0oO0 oo0oo0, oo00o oo00oVar, boolean z) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o000O0O0);
            OooO00o(mapOooO00o, oo0oo0, oo00oVar);
            o0OO000.OooO00o(mapOooO00o, oo00oVar);
            mapOooO00o.put("duration", (System.currentTimeMillis() - oo0oo0.OooOo.OooO0oO) + "");
            o0OO000.OooO00o(o0OO000o.o000OO0O, mapOooO00o, new Object[0]);
            oo0oo0.OooOo.OooO0oO = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    public boolean OooO0O0(oo00o oo00oVar) {
        try {
            return oo00oVar.isCf && !OooO00o(3);
        } catch (Exception unused) {
        }
    }

    public void OooO0OO(o00O0 o00o0, oo00o oo00oVar) {
        oo00o.OooO00o oooO00o;
        int biddingEcpm;
        OooO00o(o00o0, oo00oVar);
        oo0oO0 oo0oo0 = o00o0.OooOOo0;
        int i = oo0oo0.OooOO0;
        if (i == 2 && oo0oo0.OooOOO == 1) {
            int biddingEcpm2 = (int) ((((oo00oVar.getBaseAdConfig().OooO00o.OooOO0O == 1 ? oo00oVar.getBiddingEcpm() : oo00oVar.getBaseAdConfig().OooO00o.OooO) * 1.0d) * ((double) (10000 - o00o0.OooOOo0.OooO))) / 10000.0d);
            oo00oVar.dsInfo.OooO0O0 = biddingEcpm2 >= 1 ? biddingEcpm2 : 1;
            return;
        }
        if (i == 1 && oo0oo0.OooOOO == 1) {
            oooO00o = oo00oVar.dsInfo;
            biddingEcpm = oo0oo0.OooOO0O;
        } else {
            if (oo0oo0.OooOOO != 2) {
                return;
            }
            if (oo00oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                oooO00o = oo00oVar.dsInfo;
                biddingEcpm = oo00oVar.getBiddingEcpm();
            } else {
                oooO00o = oo00oVar.dsInfo;
                biddingEcpm = (int) oo00oVar.getBaseAdConfig().OooO00o.OooO;
            }
        }
        oooO00o.OooO0O0 = biddingEcpm;
    }

    public boolean OooO0OO(oo00o oo00oVar) {
        if (oo00oVar != null) {
            return oo00oVar.isRepeatClick;
        }
        return false;
    }

    public void OooO0Oo(o00O0 o00o0, oo00o oo00oVar) {
        oo0oO0 oo0oo0;
        int biddingEcpm;
        UMNEcpmInfo uMNEcpmInfo;
        StringBuilder sbAppend;
        try {
            if (oo00oVar.getBaseAdConfig().OooO00o.OooOOo0 == 2) {
                o00o0.OooOOo.setEcpm(oo00oVar.auctionPrice + "");
                return;
            }
            OooO00o(o00o0, oo00oVar);
            oo0oO0 oo0oo1 = o00o0.OooOOo0;
            if (oo0oo1.OooO > 10000) {
                oo0oo1.OooO = 10000;
            }
            int i = oo0oo1.OooOO0;
            int i2 = 1;
            if (i == 2 && oo0oo1.OooOOO == 1) {
                int biddingEcpm2 = (int) (((oo00oVar.getBaseAdConfig().OooO00o.OooOO0O == 1 ? ((double) oo00oVar.getBiddingEcpm()) * 1.0d : oo00oVar.getBaseAdConfig().OooO00o.OooO * 1.0d) * ((double) (10000 - o00o0.OooOOo0.OooO))) / 10000.0d);
                if (biddingEcpm2 >= 1) {
                    i2 = biddingEcpm2;
                }
                o00o0.OooOOo.setEcpm(i2 + "");
                o00o0.OooOOo0.OooOO0O = i2;
                return;
            }
            if (i == 1 && oo0oo1.OooOOO == 1) {
                uMNEcpmInfo = o00o0.OooOOo;
                sbAppend = new StringBuilder().append(o00o0.OooOOo0.OooOO0O).append("");
            } else {
                if (oo0oo1.OooOOO != 2) {
                    return;
                }
                if (oo00oVar.getBaseAdConfig().OooO00o.OooOO0O == 1) {
                    oo0oo0 = o00o0.OooOOo0;
                    biddingEcpm = oo00oVar.getBiddingEcpm();
                } else {
                    oo0oo0 = o00o0.OooOOo0;
                    biddingEcpm = (int) oo00oVar.getBaseAdConfig().OooO00o.OooO;
                }
                oo0oo0.OooOO0O = biddingEcpm;
                int i3 = o00o0.OooOOo0.OooOO0;
                if (i3 != 4 && i3 != 7) {
                    return;
                }
                uMNEcpmInfo = o00o0.OooOOo;
                sbAppend = new StringBuilder().append(o00o0.OooOOo0.OooOO0O).append("");
            }
            uMNEcpmInfo.setEcpm(sbAppend.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

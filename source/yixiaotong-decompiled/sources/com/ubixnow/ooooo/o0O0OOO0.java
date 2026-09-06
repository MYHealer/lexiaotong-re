package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0OOO0 {
    public static final String OooO00o = "no_support_cache_ads";
    public static String OooO0O0 = "101000001100001110100000110011001010000011001001101000001100001110100000110010111010000011111111101000001100011010100000110010011010000011001100101000001101010010100000110001011010000011010010";
    public static String OooO0OO = "d_k_aid";
    public static String OooO0Oo = "m_f_t";
    public String OooO;
    public long OooO0oo;
    public String OooO0o0 = "";
    public boolean OooO0o = false;
    public boolean OooO0oO = false;
    public OooO00o OooOO0 = new OooO00o();

    public static class OooO00o {
        public static String OooO00o = "d_s_e";
        public static String OooO0O0 = "d_s_r";
        public static String OooO0OO = "d_s_l";
        public static String OooO0Oo = "d_s_m";
        public boolean OooO0o0;
        public long OooO0o = 21600000;
        public long OooO0oO = 60000;
    }

    private static int OooO00o() {
        return new Random().nextInt(100);
    }

    public static o0O0OOO0 OooO00o(String str) {
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        try {
            if (!TextUtils.isEmpty(str)) {
                ooooO000.OooO0O0("----slot-json", str);
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("devCo");
                OooO0o(jSONObjectOptJSONObject, o0o0ooo0);
                OooO0o0(jSONObjectOptJSONObject, o0o0ooo0);
                OooO00o(jSONObjectOptJSONObject, o0o0ooo0);
                OooO0O0(jSONObjectOptJSONObject, o0o0ooo0);
                if (!h1.OooO0O0().OooO0OO() && oOO00O.OooOOOo) {
                    OooO0Oo(jSONObjectOptJSONObject, o0o0ooo0);
                    OooO0OO(jSONObjectOptJSONObject, o0o0ooo0);
                    ooooO000.OooO0Oo("----slot-DS con true");
                }
            }
        } catch (Exception unused) {
        }
        return o0o0ooo0;
    }

    public static void OooO00o(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString(OooO0OO))) {
                return;
            }
            o0o0ooo0.OooO = jSONObject.optString(OooO0OO);
        } catch (Exception unused) {
        }
    }

    private static void OooO0O0(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString(OooO0Oo))) {
                return;
            }
            o0o0ooo0.OooO0oo = Long.parseLong(jSONObject.optString(OooO0Oo));
        } catch (Exception unused) {
        }
    }

    private static void OooO0OO(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        try {
            String strOptString = jSONObject.optString(OooO00o.OooO00o);
            String strOptString2 = jSONObject.optString(OooO00o.OooO0O0);
            if (!"1".equals(strOptString) || TextUtils.isEmpty(strOptString2) || Integer.parseInt(strOptString2) <= 0) {
                return;
            }
            int iNextInt = new Random().nextInt(10000);
            ooooO000.OooO0Oo("----slot-DS con: result:" + iNextInt + "  rate:" + strOptString2);
            if (iNextInt <= Integer.parseInt(strOptString2)) {
                String strOptString3 = jSONObject.optString(OooO00o.OooO0OO);
                String strOptString4 = jSONObject.optString(OooO00o.OooO0Oo);
                if (!TextUtils.isEmpty(strOptString3)) {
                    try {
                        if (Long.parseLong(strOptString3) >= 0) {
                            o0o0ooo0.OooOO0.OooO0o = Long.parseLong(strOptString3) * 60000;
                        }
                    } catch (Exception e) {
                        ooooO000.OooO00o(e);
                    }
                }
                if (!TextUtils.isEmpty(strOptString4)) {
                    try {
                        if (Long.parseLong(strOptString4) > 0) {
                            o0o0ooo0.OooOO0.OooO0oO = Long.parseLong(strOptString4) * 1000;
                        }
                    } catch (Exception e2) {
                        ooooO000.OooO00o(e2);
                    }
                }
                o0o0ooo0.OooOO0.OooO0o0 = true;
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0Oo("----slot-DS con: MTime:" + o0o0ooo0.OooOO0.OooO0oO + "  LTime:" + o0o0ooo0.OooOO0.OooO0o);
                }
            }
        } catch (Exception e3) {
            ooooO000.OooO00o(e3);
        }
    }

    public static void OooO0Oo(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString(OooO0O0))) {
                return;
            }
            o0o0ooo0.OooO0oO = Integer.parseInt(jSONObject.optString(OooO0O0)) > OooO00o();
        } catch (Exception unused) {
        }
    }

    private static void OooO0o(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        if (jSONObject != null) {
            o0o0ooo0.OooO0o0 = jSONObject.optString(OooO00o);
        }
    }

    public static void OooO0o0(JSONObject jSONObject, o0O0OOO0 o0o0ooo0) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString("repeat_click"))) {
                return;
            }
            o0o0ooo0.OooO0o = Integer.parseInt(jSONObject.optString("repeat_click")) == 2;
        } catch (Exception unused) {
        }
    }
}

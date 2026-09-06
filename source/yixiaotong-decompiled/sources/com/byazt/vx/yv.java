package com.byazt.vx;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.ai;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, ai.y})
public class yv {
    private static com.byazt.it.ve ve() {
        try {
            if (com.byazt.bp.c.t() != null) {
                return com.byazt.vif.uj.c(null, "gm_evt_upload_info");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(String str, boolean z, long j, String str2) {
        JSONObject jSONObject;
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return;
            }
            String string = veVarVe.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            int i = 1;
            if (z) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                if (iOptInt != -1) {
                    i = 1 + iOptInt;
                }
                jSONObjectOptJSONObject.put("times", i);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    if (jOptInt != -1) {
                        j = ((jOptInt * ((long) (i - 1))) + j) / ((long) i);
                    }
                    jSONObjectOptJSONObject.put("avg_req_duration", j);
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject2);
                }
                int iOptInt2 = jSONObjectOptJSONObject2.optInt("times", -1);
                jSONObjectOptJSONObject2.put("times", iOptInt2 == -1 ? 1 : iOptInt2 + 1);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("error_code");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObjectOptJSONObject2.put("error_code", jSONObjectOptJSONObject3);
                }
                int iOptInt3 = jSONObjectOptJSONObject3.optInt(str2, -1);
                if (iOptInt3 != -1) {
                    i = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject3.put(str2, i);
            }
            veVarVe.put(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c(String str) {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return null;
            }
            String string = veVarVe.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                veVarVe.remove(str);
                return new JSONObject(string);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void c(String str, long j) {
        JSONObject jSONObject;
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return;
            }
            String string = veVarVe.getString(com.baidu.mobads.sdk.internal.d.f1799a, "");
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            jSONObject.put(str, j);
            veVarVe.put(com.baidu.mobads.sdk.internal.d.f1799a, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c() {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return null;
            }
            String string = veVarVe.getString(com.baidu.mobads.sdk.internal.d.f1799a, "");
            if (!TextUtils.isEmpty(string)) {
                veVarVe.remove(com.baidu.mobads.sdk.internal.d.f1799a);
                return new JSONObject(string);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void c(int i, int i2) {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return;
            }
            int i3 = veVarVe.getInt("low_m_cnt", 0);
            int i4 = veVarVe.getInt("clean_invalid_cnt", 0);
            int i5 = veVarVe.getInt("force_clean_cnt", 0) + i2;
            veVarVe.put("low_m_cnt", i3 + 1);
            veVarVe.put("clean_invalid_cnt", i4 + i);
            veVarVe.put("force_clean_cnt", i5);
        } catch (Throwable unused) {
        }
    }

    public static void c(Map<String, Object> map) {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return;
            }
            int i = veVarVe.getInt("low_m_cnt", 0);
            int i2 = veVarVe.getInt("clean_invalid_cnt", 0);
            int i3 = veVarVe.getInt("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", i);
            jSONObject.put("invalid_cnt", i2);
            jSONObject.put("force_cnt", i3);
            map.put("low_m_clean", jSONObject);
            veVarVe.put("low_m_cnt", 0);
            veVarVe.put("clean_invalid_cnt", 0);
            veVarVe.put("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }

    public static void tt(Map<String, Object> map) {
        try {
            Context context = com.byazt.bp.tt.getContext();
            SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt((Context) com.byazt.eu.c.c(context), "cb_test", 0);
            String string = sharedPreferencesTt.getString(MediationConstant.ADN_KS, "");
            String string2 = sharedPreferencesTt.getString(MediationConstant.ADN_GDT, "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                sharedPreferencesTt = com.byazt.nys.tt.tt(context, "cb_test", 0);
                string = sharedPreferencesTt.getString(MediationConstant.ADN_KS, "");
                string2 = sharedPreferencesTt.getString(MediationConstant.ADN_GDT, "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(MediationConstant.ADN_KS, string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put(MediationConstant.ADN_GDT, string2);
            }
            map.put("cb_stacktrace", jSONObject);
            sharedPreferencesTt.edit().clear().apply();
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public static void c(int i) {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return;
            }
            veVarVe.put("init_count", i);
        } catch (Throwable unused) {
        }
    }

    public static int tt() {
        try {
            com.byazt.it.ve veVarVe = ve();
            if (veVarVe == null) {
                return 0;
            }
            return veVarVe.get("init_count", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }
}

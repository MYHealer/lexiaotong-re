package com.byazt.xz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.byazt.mg.da;
import com.byazt.mg.i;
import com.byazt.mg.u;
import com.byazt.nr.m;
import com.byazt.uy.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.hihonor.adsdk.base.g.j.e.a;
import com.umeng.analytics.pro.am;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1730, 13})
public final class tt {
    public static final String[] c = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    public Context tt;
    public JSONObject ve = new JSONObject();

    public JSONObject c() {
        return this.ve;
    }

    public tt(Context context) {
        this.tt = context;
    }

    public static tt c(Context context) {
        tt ttVar = new tt(context);
        JSONObject jSONObjectC = ttVar.c();
        ttVar.c(jSONObjectC);
        ttVar.ve(jSONObjectC);
        ttVar.uj(jSONObjectC);
        ttVar.n(jSONObjectC);
        ttVar.a(jSONObjectC);
        ttVar.sp(jSONObjectC);
        ttVar.tt(jSONObjectC);
        return ttVar;
    }

    private void c(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.tt.getPackageManager().getPackageInfo(this.tt.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put(am.s, this.tt.getString(i));
            }
            jSONObject.put("sdk_version", 138);
            jSONObject.put(a.hnadsz, "0.0.1-alpha.18-cloud");
            jSONObject.put(am.x, "Android");
            jSONObject.put("os_version", ve());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(am.F, Build.BRAND);
            jSONObject.put(am.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", tt());
        } catch (Exception unused) {
        }
    }

    private String tt() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e) {
            da.tt(e);
            return "unknown";
        }
    }

    private void tt(JSONObject jSONObject) {
        Map<String, Object> mapTt;
        Object obj;
        com.byazt.rx.c cVarC = x.c();
        if (cVarC == null || jSONObject == null || (mapTt = cVarC.tt()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapTt.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapTt.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        } catch (Exception e) {
            da.tt(e);
        }
    }

    private String ve() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private void ve(JSONObject jSONObject) {
        String str;
        try {
            DisplayMetrics displayMetrics = this.tt.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            if (i == 120) {
                str = "ldpi";
            } else if (i != 240) {
                str = i != 320 ? "mdpi" : "xhdpi";
            } else {
                str = "hdpi";
            }
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void uj(JSONObject jSONObject) {
        try {
            String language = this.tt.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put(am.M, rawOffset);
        } catch (Exception unused) {
        }
    }

    private void n(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.byazt.mg.ve.ve()) {
                sb.append("MIUI-");
            } else if (com.byazt.mg.ve.uj()) {
                sb.append("FLYME-");
            } else {
                String strC = com.byazt.mg.ve.c();
                if (com.byazt.mg.ve.c(strC)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strC)) {
                    sb.append(strC).append(com.huawei.openalliance.ad.constant.x.A);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put(a.k, u.c());
        } catch (Throwable unused) {
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            jSONObject.put(am.Q, i.c(this.tt));
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private void sp(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.tt.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(am.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public JSONObject c(Map<String, Object> map) {
        try {
            if (map == null) {
                return this.ve;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.ve.has(entry.getKey())) {
                    this.ve.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : c) {
                if (map.containsKey(str)) {
                    try {
                        this.ve.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused) {
                        this.ve.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.ve.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                this.ve.put("udid", map.get("iid"));
                this.ve.remove("iid");
            }
            return this.ve;
        } catch (Throwable unused2) {
        }
    }

    public JSONObject c(String str) {
        try {
            this.ve.put("device_id", str);
        } catch (JSONException e) {
            m.c(e);
        }
        return this.ve;
    }

    public JSONObject tt(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.ve.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, str);
            }
        } catch (JSONException e) {
            m.c(e);
        }
        return this.ve;
    }
}

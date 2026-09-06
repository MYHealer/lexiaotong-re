package com.byazt.mp;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.lu.uj;
import com.byazt.vm.sp;
import com.byazt.yv.da;
import com.byazt.yv.n;
import com.byazt.yv.u;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2108, 13})
public class tt {
    public static final String[] c = {"ab_version", am.F, "language", "os_api", "resolution", "google_aid", "build_serial", am.P, "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    public static final String[] tt = {"ab_version", am.F, "language", "os_api", "resolution", "google_aid", "build_serial", am.P, "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, am.ai, Constant.MAP_KEY_UUID, "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String c(Context context, JSONObject jSONObject, String str, boolean z, com.byazt.gj.tt ttVar) {
        HashMap<String, String> mapC;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(c.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = c;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(tt[i], strOptString);
            }
            i++;
        }
        if (ttVar != null) {
            try {
                mapC = ttVar.c(context);
            } catch (Exception e) {
                da.tt(e);
            }
        } else {
            mapC = null;
        }
        if (u.ve(context) && mapC != null) {
            map.putAll(mapC);
        }
        try {
            HashMap<String, String> mapC2 = com.byazt.gj.c.ve() == null ? null : com.byazt.gj.c.ve().c();
            if (mapC2 != null) {
                map.putAll(mapC2);
            }
        } catch (Exception e2) {
            da.tt(e2);
        }
        if (com.byazt.gj.c.ve.size() > 0) {
            map.putAll(com.byazt.gj.c.ve);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strC = n.c(context);
        if (!TextUtils.isEmpty(strC)) {
            map.put(OapsKey.KEY_ACTIVE_CODE, strC);
        }
        String str2 = (String) com.byazt.gj.c.c("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) com.byazt.gj.c.c("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) com.byazt.gj.c.c("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) com.byazt.gj.c.c("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) com.byazt.gj.c.c("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strC2 = sp.c(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strC2)) {
            map.put("oaid", strC2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return u.c(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, "UTF-8");
    }

    public static String[] c(uj ujVar, Context context, JSONObject jSONObject) {
        String[] strArrTt = ujVar.sp().tt();
        String[] strArr = new String[strArrTt.length];
        String str = com.byazt.gj.c.x() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrTt.length; i++) {
            String strC = c(context, jSONObject, strArrTt[i] + str, true, com.byazt.gj.c.uj());
            strArr[i] = strC;
            strArr[i] = c.c(strC, c.tt);
        }
        return strArr;
    }
}

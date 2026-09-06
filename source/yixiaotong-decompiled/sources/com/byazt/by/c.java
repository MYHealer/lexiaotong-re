package com.byazt.by;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.gr;
import com.byazt.aas.gu;
import com.byazt.aas.i;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.yv;
import com.byazt.aas.zm;
import com.byazt.bwm.sp;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.umeng.analytics.pro.am;
import com.yfanads.android.utils.YFAdsConst;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 20})
public class c {
    public static long c = -1;
    public static boolean tt;
    public static volatile String uj;
    public static AtomicBoolean ve = new AtomicBoolean(false);

    public static void c() {
        if (c > -1) {
            return;
        }
        c = SystemClock.elapsedRealtime();
    }

    public static boolean tt() {
        if (tt) {
            return true;
        }
        if (c == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - c > 60000;
        tt = z;
        return z;
    }

    public static JSONObject c(Context context, int i) {
        return tt(context, i);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0386 A[Catch: all -> 0x03d9, TryCatch #1 {all -> 0x03d9, blocks: (B:3:0x0009, B:5:0x0026, B:10:0x0030, B:13:0x0041, B:15:0x004b, B:18:0x0052, B:25:0x006f, B:27:0x0079, B:30:0x0080, B:35:0x0091, B:38:0x009e, B:40:0x00a8, B:43:0x00af, B:48:0x00c4, B:51:0x00d0, B:55:0x00e7, B:57:0x00f1, B:60:0x00f8, B:65:0x0111, B:68:0x01b1, B:70:0x01bb, B:73:0x01c2, B:78:0x01db, B:80:0x029f, B:83:0x02ac, B:85:0x02b6, B:88:0x02bd, B:96:0x02d3, B:98:0x02dd, B:101:0x02e4, B:109:0x02fa, B:111:0x0304, B:114:0x030b, B:122:0x0321, B:124:0x032b, B:128:0x0333, B:136:0x0349, B:138:0x0353, B:143:0x0364, B:146:0x0374, B:148:0x0382, B:150:0x038d, B:152:0x03a0, B:153:0x03a5, B:155:0x03b4, B:156:0x03b9, B:160:0x03d5, B:159:0x03d2, B:149:0x0386, B:139:0x0357, B:142:0x0361, B:129:0x0337, B:133:0x0342, B:115:0x030f, B:119:0x031a, B:102:0x02e8, B:106:0x02f3, B:89:0x02c1, B:93:0x02cc, B:74:0x01c6, B:77:0x01d8, B:61:0x00fc, B:64:0x010e, B:52:0x00d8, B:44:0x00b3, B:47:0x00c1, B:31:0x0084, B:34:0x008e, B:19:0x0056, B:22:0x0068), top: B:167:0x0009, inners: #0 }] */
    public static JSONObject tt(Context context, int i) {
        Object objT;
        String strSl;
        String strDa;
        String strI;
        String strX;
        String strYp;
        String strSp;
        String strA;
        String strN;
        String strI2;
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            com.byazt.xgx.c cVar = new com.byazt.xgx.c();
            boolean z = (cVar.tt() && cVar.ve()) ? false : true;
            boolean z2 = !tt();
            uj.tt ttVar = new uj.tt();
            Object obj = null;
            if (z2 && (strI2 = uj.c().i(null)) != null) {
                if (TextUtils.isEmpty(strI2)) {
                    strI2 = null;
                }
                jSONObject.put("imei", strI2);
            } else {
                String strC = DeviceUtils.c(Boolean.valueOf(cVar.c()));
                jSONObject.put("imei", strC);
                if (strC == null) {
                    strC = "";
                }
                ttVar.c(strC);
            }
            if (z2 && (strN = uj.c().n()) != null) {
                if (TextUtils.isEmpty(strN)) {
                    strN = null;
                }
                jSONObject.put("android_id", strN);
            } else {
                String strTt = DeviceUtils.tt();
                jSONObject.put("android_id", strTt);
                if (strTt == null) {
                    strTt = "";
                }
                ttVar.tt(strTt);
            }
            jSONObject.put(Constant.MAP_KEY_UUID, ve());
            if (z2 && (strA = uj.c().a()) != null) {
                if (TextUtils.isEmpty(strA)) {
                    strA = null;
                }
                jSONObject.put("ssid", strA);
            } else {
                String ssid = uVar.getSSID(Boolean.valueOf(z));
                jSONObject.put("ssid", ssid);
                if (ssid == null) {
                    ssid = "";
                }
                ttVar.ve(ssid);
            }
            if (uj.c().sp(i)) {
                jSONObject.put("wifi_mac", uVar.getAsyncWifiMac());
            } else {
                jSONObject.put("wifi_mac", uVar.getWifiMac(Boolean.valueOf(z)));
            }
            if (z2 && (strSp = uj.c().sp()) != null) {
                if (TextUtils.isEmpty(strSp)) {
                    strSp = null;
                }
                jSONObject.put("imsi", strSp);
            } else {
                String imsi = uVar.getImsi(Boolean.valueOf(cVar.c()));
                jSONObject.put("imsi", imsi);
                if (imsi == null) {
                    imsi = "";
                }
                ttVar.uj(imsi);
            }
            jSONObject.put("boot", new StringBuilder().append(System.currentTimeMillis() - SystemClock.elapsedRealtime()).toString());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.k, uVar.getRomInfo());
            jSONObject.put("rom_new_version", zm.yp());
            jSONObject.put("sys_compiling_time", uVar.getCompilingTime());
            jSONObject.put("type", uVar.getDeviceType(z2));
            jSONObject.put(am.x, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", uVar.getDeviceModel());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", DeviceUtils.uj());
            if (z2 && (strYp = uj.c().yp()) != null) {
                if (TextUtils.isEmpty(strYp)) {
                    strYp = null;
                }
                jSONObject.put(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC, strYp);
            } else {
                String macAddress = uVar.getMacAddress(Boolean.valueOf(cVar.tt()));
                jSONObject.put(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC, macAddress);
                if (macAddress == null) {
                    macAddress = "";
                }
                ttVar.n(macAddress);
            }
            int[] iArrVe = pf.ve(context);
            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.e, iArrVe[0]);
            jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.f, iArrVe[1]);
            jSONObject.put("oaid", veVar.getOAID(z2));
            jSONObject.put("oaid_source", gu.c());
            jSONObject.put("free_space", i.c);
            jSONObject.put("locale_language", uVar.getLocalLanguage());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.n() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.c() ? 1 : 0);
            jSONObject.put("cpu_num", nb.yp());
            jSONObject.put("cpu_max_freq", nb.z());
            jSONObject.put("cpu_min_freq", nb.m());
            jSONObject.put("battery_remaining_pct", (int) DeviceUtils.c.tt(context));
            jSONObject.put("is_charging", DeviceUtils.c.c(context));
            jSONObject.put("total_mem", nb.t());
            jSONObject.put("total_space", String.valueOf(nb.nu()));
            jSONObject.put("free_space_in", String.valueOf(nb.my()));
            jSONObject.put("sdcard_size", String.valueOf(nb.gt()));
            jSONObject.put("rooted", nb.qy());
            if (!uj.c().sp(i)) {
                jSONObject.put("enable_assisted_clicking", DeviceUtils.a());
            }
            if (z2 && (strX = uj.c().x()) != null) {
                if (TextUtils.isEmpty(strX)) {
                    strX = null;
                }
                jSONObject.put("mnc", strX);
            } else {
                String mnc = uVar.getMnc();
                jSONObject.put("mnc", mnc);
                if (mnc == null) {
                    mnc = "";
                }
                ttVar.a(mnc);
            }
            if (z2 && (strI = uj.c().i()) != null) {
                if (TextUtils.isEmpty(strI)) {
                    strI = null;
                }
                jSONObject.put("mcc", strI);
            } else {
                String mcc = uVar.getMcc();
                jSONObject.put("mcc", mcc);
                if (mcc == null) {
                    mcc = "";
                }
                ttVar.sp(mcc);
            }
            if (z2 && (strDa = uj.c().da()) != null) {
                if (TextUtils.isEmpty(strDa)) {
                    strDa = null;
                }
                jSONObject.put("mnc_2", strDa);
            } else {
                String mnc2 = uVar.getMnc2();
                jSONObject.put("mnc_2", mnc2);
                if (mnc2 == null) {
                    mnc2 = "";
                }
                ttVar.x(mnc2);
            }
            if (z2 && (strSl = uj.c().sl()) != null) {
                if (!TextUtils.isEmpty(strSl)) {
                    obj = strSl;
                }
                jSONObject.put("mcc_2", obj);
            } else {
                String mcc2 = uVar.getMcc2();
                jSONObject.put("mcc_2", mcc2);
                if (mcc2 == null) {
                    mcc2 = "";
                }
                ttVar.i(mcc2);
            }
            if (z2 && (objT = uj.c().t()) != null) {
                jSONObject.put("download_channel", objT);
            } else {
                String strI3 = com.byazt.fh.c.i();
                jSONObject.put("download_channel", strI3);
                ttVar.da(strI3 != null ? strI3 : "");
            }
            ttVar.c();
            jSONObject.put("is_app_log_con", com.byazt.ml.c.c());
            if (z2) {
                String strU = uj.c().u();
                if (!TextUtils.isEmpty(strU)) {
                    jSONObject.put("applog_did", strU);
                } else {
                    jSONObject.put("applog_did", veVar.getDid());
                }
            } else {
                jSONObject.put("applog_did", veVar.getDid());
            }
            jSONObject.put("sec_did", com.byazt.lkt.c.tt());
            long jI = DeviceUtils.i();
            if (jI != -1) {
                jSONObject.put("client_global_did", jI);
            }
            jSONObject.put("sys_vol", DeviceUtils.da());
            Object objDa = gr.da();
            if (objDa != null) {
                jSONObject.put(YFAdsConst.REPORT_UD, objDa);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            DeviceUtils.c(jSONObject);
        } catch (Throwable th) {
            m.c(th);
            c(i, th);
        }
        return jSONObject;
    }

    private static void c(int i, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", Integer.valueOf(i));
            yp.c().c("b_ad_req", jSONObject, th);
        } catch (Throwable unused) {
        }
    }

    public static void c(JSONObject jSONObject, int i) throws JSONException {
        if (!ve.c().c(i)) {
            tt(jSONObject);
            return;
        }
        JSONArray jSONArrayZ = uj.c().z();
        if (jSONArrayZ != null) {
            if (jSONArrayZ.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayZ);
            }
            if (ve.get()) {
                return;
            }
            ve.set(true);
            com.byazt.bwm.n.tt(new sp("tt-scheme") { // from class: com.byazt.by.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.tt(null);
                    } catch (Exception unused) {
                    }
                    c.ve.set(false);
                }
            });
            return;
        }
        tt(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(JSONObject jSONObject) throws JSONException {
        Set<String> setO = gt.tt().o();
        if (setO == null || setO.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapC = yv.c(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapC.entrySet()) {
            String key = entry.getKey();
            if (setO.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            uj.c().c(jSONArray);
        } else {
            com.byazt.bwm.n.tt(new sp("tt-scheme-save") { // from class: com.byazt.by.c.2
                @Override // java.lang.Runnable
                public void run() {
                    uj.c().c(jSONArray);
                }
            });
        }
    }

    public static String[] c(int i) {
        try {
            return ((u) com.byazt.ut.uj.getService("device_info_new")).getNewIpAddrs(!tt());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String c(String str, int i) {
        return my.tt(str);
    }

    public static String ve() {
        if (!TextUtils.isEmpty(uj)) {
            return uj;
        }
        String strC = uj.c().c((String) null);
        uj = strC;
        return strC;
    }
}

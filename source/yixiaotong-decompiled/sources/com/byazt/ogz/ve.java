package com.byazt.ogz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.tid.b;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.aas.sv;
import com.byazt.aas.yv;
import com.byazt.aas.z;
import com.byazt.aas.zm;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.nr.md;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.openalliance.ad.constant.bf;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ubixnow.ooooo.o0OO000o;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 54})
public class ve extends com.byazt.bwm.sp {
    public static volatile ve tt;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f2552a;
    public String c;
    public AtomicBoolean n;
    public volatile AtomicBoolean sp;
    public final c uj;
    public final Context ve;
    public Comparator<JSONObject> x;

    public static ve tt() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    private ve() {
        super("ApplistHelper");
        this.n = new AtomicBoolean(false);
        this.f2552a = new AtomicBoolean(false);
        this.sp = new AtomicBoolean(true);
        this.x = new Comparator<JSONObject>() { // from class: com.byazt.ogz.ve.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = gt.getContext();
        this.ve = context;
        this.uj = new c(context);
    }

    public void c(String str) {
        if (nb.tt()) {
            this.f2552a.set(gt.tt().hc() && com.byazt.omf.x.m().nu().alist());
            if (x.n() && this.sp.get() && !this.n.get()) {
                this.n.set(true);
                try {
                    this.c = str;
                    com.byazt.bwm.n.c(this, 1);
                } catch (Throwable unused) {
                    this.n.set(false);
                }
            }
        }
    }

    private List<JSONObject> tt(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.f2552a.get() || (zm.nu() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(tt.c("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = md.c(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(md.c(jSONObject.optString(CountryCodeBean.SPECIAL_COUNTRYCODE_CN), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put("app_name", "unknown");
                        jSONObject2.put("app_type", c(packageInfo));
                        jSONObject2.put("apk_dir", packageInfo.applicationInfo != null ? packageInfo.applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public List<String> c(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.byazt.nr.c.ve(tt.c("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = md.c(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(md.c(jSONObject.optString(CountryCodeBean.SPECIAL_COUNTRYCODE_CN), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (c(packageInfo) != 1) {
                            arrayList.add("unknown" + com.huawei.openalliance.ad.constant.x.bQ + packageInfo.packageName);
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private int c(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith(Constant.DEFAULT_CVN2)) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!rh.c(this.ve)) {
            this.n.set(false);
            return;
        }
        try {
            String str = this.c;
            boolean zVe = this.uj.ve(str);
            this.sp.set(false);
            if (zVe) {
                tt(tt(this.ve), str);
            } else {
                this.n.set(false);
            }
        } catch (Throwable th) {
            this.n.set(false);
            m.tt("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    private boolean c(List<JSONObject> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.x);
        String strVe = com.byazt.nr.c.ve(this.uj.tt(str));
        if (TextUtils.isEmpty(strVe)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strVe);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.x);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = list.get(i2);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                String strOptString = jSONObject.optString("package_name");
                String strOptString2 = jSONObject.optString("last_update_time");
                if (strOptString == null || strOptString2 == null || !strOptString.equals(jSONObject2.optString("package_name")) || !strOptString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            m.ve("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void tt(final List<JSONObject> list, final String str) {
        boolean zC = c(list, str);
        JSONObject jSONObjectC = c(zC ? list : new ArrayList<>(), gt.tt().mf(), gt.tt().en());
        if (list != null) {
            list.size();
        }
        sv svVar = new sv(com.byazt.hy.n.c().tt().a());
        svVar.c(nb.sl("/api/ad/union/sdk/upload/app_info/"));
        svVar.ve(jSONObjectC, "applist");
        svVar.c(new com.byazt.mh.c() { // from class: com.byazt.ogz.ve.2
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar == null || !ttVar.i() || TextUtils.isEmpty(ttVar.n())) {
                    ve.this.sp.set(true);
                } else {
                    try {
                        if ("20000".equals(new JSONObject(ttVar.n()).optString("status"))) {
                            ve.this.uj.c(str);
                            ve.this.uj.c(com.byazt.nr.c.tt(new JSONArray((Collection) list).toString()), str);
                        }
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
                ve.this.n.set(false);
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                ve.this.n.set(false);
                ve.this.sp.set(true);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x015d A[Catch: Exception -> 0x01dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x01dd, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0060, B:28:0x0069, B:30:0x006f, B:31:0x007f, B:33:0x00f8, B:35:0x00fe, B:36:0x010c, B:38:0x0112, B:45:0x012c, B:46:0x0130, B:47:0x013a, B:49:0x014b, B:52:0x0153, B:53:0x0157, B:55:0x015d, B:60:0x017e, B:62:0x0184, B:64:0x018a, B:65:0x019c, B:67:0x01a2, B:69:0x01b4, B:70:0x01bc, B:71:0x01c4, B:72:0x01ce, B:74:0x01d8, B:40:0x011e, B:42:0x0124, B:43:0x0128), top: B:78:0x0005, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01a2 A[Catch: Exception -> 0x01dd, TryCatch #0 {Exception -> 0x01dd, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0060, B:28:0x0069, B:30:0x006f, B:31:0x007f, B:33:0x00f8, B:35:0x00fe, B:36:0x010c, B:38:0x0112, B:45:0x012c, B:46:0x0130, B:47:0x013a, B:49:0x014b, B:52:0x0153, B:53:0x0157, B:55:0x015d, B:60:0x017e, B:62:0x0184, B:64:0x018a, B:65:0x019c, B:67:0x01a2, B:69:0x01b4, B:70:0x01bc, B:71:0x01c4, B:72:0x01ce, B:74:0x01d8, B:40:0x011e, B:42:0x0124, B:43:0x0128), top: B:78:0x0005, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01d8 A[Catch: Exception -> 0x01dd, TRY_LEAVE, TryCatch #0 {Exception -> 0x01dd, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0060, B:28:0x0069, B:30:0x006f, B:31:0x007f, B:33:0x00f8, B:35:0x00fe, B:36:0x010c, B:38:0x0112, B:45:0x012c, B:46:0x0130, B:47:0x013a, B:49:0x014b, B:52:0x0153, B:53:0x0157, B:55:0x015d, B:60:0x017e, B:62:0x0184, B:64:0x018a, B:65:0x019c, B:67:0x01a2, B:69:0x01b4, B:70:0x01bc, B:71:0x01c4, B:72:0x01ce, B:74:0x01d8, B:40:0x011e, B:42:0x0124, B:43:0x0128), top: B:78:0x0005, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01bc A[SYNTHETIC] */
    private JSONObject c(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        Map<String, Boolean> mapC;
        List<String> listC;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            String strC = DeviceUtils.c((Boolean) null);
            Object obj2 = "";
            if (TextUtils.isEmpty(strC)) {
                strC = "";
            }
            if (TextUtils.isEmpty(strC)) {
                i = -1;
                obj = "";
            } else {
                obj = strC;
                i = 1;
            }
            String oaid = veVar.getOAID(false);
            if (TextUtils.isEmpty(oaid)) {
                oaid = "";
            }
            if (i < 0 && !TextUtils.isEmpty(oaid)) {
                i = 4;
                obj = oaid;
            }
            String strTt = DeviceUtils.tt();
            if (TextUtils.isEmpty(strTt)) {
                strTt = "";
            }
            String did = veVar.getDid();
            if (!TextUtils.isEmpty(did)) {
                obj2 = did;
            }
            if (i < 0) {
                i = 3;
                obj = strTt;
            }
            JSONArray jSONArray3 = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray3.put(it.next().optString("package_name"));
            }
            jSONObject.put(o0OO000o.o00OoO0, jSONArray3);
            jSONObject.put(bf.D, new JSONArray((Collection) list));
            jSONObject.put(b.f, System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", z.c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", uVar.getDeviceModel());
            jSONObject.put("app_id", com.byazt.omf.x.m().rl());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", p.n);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", strC);
            jSONObject.put("oaid", oaid);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", strTt);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (nb.tt(str)) {
                                jSONArray4.put(str);
                            } else {
                                jSONArray5.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray5.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray4);
                jSONObject.put("no_applist", jSONArray5);
                boolean zK = gt.tt().k();
                jSONObject.put("scheme_get_type", !zK ? 1 : 0);
                if (list3 != null) {
                    for (String str2 : list3) {
                        if (!TextUtils.isEmpty(str2)) {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            nb.c(intent, true);
                        }
                    }
                }
                mapC = yv.c(259200000L);
                if (mapC != null) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    for (Map.Entry<String, Boolean> entry : mapC.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listC = nb.c();
                if (listC.size() > 0) {
                    jSONObject.put("query_all_package", listC);
                }
            } else {
                boolean zK2 = gt.tt().k();
                jSONObject.put("scheme_get_type", !zK2 ? 1 : 0);
                if (list3 != null && !list3.isEmpty() && zK2) {
                    while (r1.hasNext()) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Uri uri2 = Uri.parse(str2);
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setData(uri2);
                                nb.c(intent2, true);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                mapC = yv.c(259200000L);
                if (mapC != null && mapC.size() > 0) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    while (r1.hasNext()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listC = nb.c();
                if (listC.size() > 0) {
                    jSONObject.put("query_all_package", listC);
                }
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    @com.byazt.zqa.c(c = {0, 1, 1190, 24})
    class c {
        public c(Context context) {
        }

        private com.byazt.it.ve uj(String str) {
            try {
                return com.byazt.vif.uj.c(str, "tt_sp_app_list");
            } catch (Exception e) {
                m.c(e);
                return null;
            }
        }

        public void c(String str, String str2) {
            com.byazt.it.ve veVarUj;
            if (TextUtils.isEmpty(str) || (veVarUj = uj(str2)) == null) {
                return;
            }
            veVarUj.put("old_app_list", str);
        }

        public void c(String str) {
            com.byazt.it.ve veVarUj = uj(str);
            if (veVarUj == null) {
                return;
            }
            veVarUj.put("day_update_time", System.currentTimeMillis());
        }

        public String tt(String str) {
            com.byazt.it.ve veVarUj = uj(str);
            return veVarUj == null ? "" : veVarUj.get("old_app_list", "");
        }

        public boolean ve(String str) {
            com.byazt.it.ve veVarUj = uj(str);
            return !nb.c(veVarUj != null ? veVarUj.get("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1190, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    private static class tt {
        public static String c(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}

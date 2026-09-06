package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.umeng.analytics.pro.am;
import com.unionpay.utils.UPUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UPPayAssistEx {
    private static String A = null;
    private static String B = null;
    private static String C = null;
    private static String D = null;
    private static String E = "";
    private static String F = "";
    private static String G = "";
    private static String H = "";
    private static boolean I = false;
    private static int J = 10;
    private static WeakReference K = null;
    private static String L = "";
    private static String M = null;
    private static String N = null;
    private static String O = "";
    private static String P = "";
    private static boolean Q = false;
    private static String R = "";
    private static int S = 0;
    public static final String SDK_TYPE = "02";
    private static boolean T = false;
    private static boolean U = false;
    private static com.unionpay.a.d V = null;
    public static final String VERSION = "3.5.9";
    private static Handler W = null;
    private static String X = "[{\"package_info\":[{\"schema\":\"com.unionpay\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101,\"version\":\".*\"},{\"schema\":\"com.unionpay.tsmservice\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102,\"version\":\"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[7-9].*|^01\\\\.00\\\\.6[5-9].*\"},{\"schema\":\"com.unionpay.tsmservice.mi\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103,\"version\":\"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[3-9].*|^01\\\\.00\\\\.2[8-9].*\"}],\"sort\":100,\"type\":\"app\"},{\"sort\":200,\"type\":\"wcd\",\"url\":\"https://appcashier.95516.com/app/api/redirectwapcashierdesk\"}]";
    private static String Y = "[{\"package_info\":[{\"schema\":\"com.unionpay\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101,\"version\":\".*\"},{\"schema\":\"com.unionpay.tsmservice\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102,\"version\":\"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[7-9].*|^01\\\\.00\\\\.6[5-9].*\"},{\"schema\":\"com.unionpay.tsmservice.mi\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103,\"version\":\"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[3-9].*|^01\\\\.00\\\\.2[8-9].*\"}],\"sort\":100,\"type\":\"app\"}]";
    private static String Z = "[{\"package_info\": [{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 102,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9302a = "SpId";
    private static String aa = "[{\"package_info\": [{\"schema\": \"com.huawei.wallet\",\"sign\": \"9095F915D6C143A41CE029209AFECB87AB481DDD\",\"sort\": 101,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.huawei.wallet\",\"sign\": \"059e2480adf8c1c5b3d9ec007645ccfc442a23c5\",\"sort\": 102,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 104,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";
    private static JSONArray ab = null;
    private static final Handler.Callback ac = new a();
    private static String b = "paydata";
    private static String c = "pay_tn";
    private static String d = "SysProvide";
    private static String e = "UseTestMode";
    private static String f = "SecurityChipType";
    private static String g = "uppayuri";
    private static String h = "resultIntentAction";
    private static String i = "reqOriginalId";
    private static String j = "wapurl";
    private static String k = "actionType";
    private static String l = "dlgstyle";
    private static String m = "com.unionpay.uppay";
    private static String n = "com.unionpay.uppay.PayActivity";
    private static String o = "com.huawei.wallet";
    private static String p = "com.huawei.wallet.action.onlinepay.startpay";
    private static String q = "ex_mode";
    private static String r = "server";
    private static String s = "source";
    private static String t = "samsung_out";
    private static String u = "se_type";
    private static String v = "se_title_logo";
    private static String w = "se_loading_logo";
    private static String x = "se_title_bg_color";
    private static String y = "se_cancel_bg_color";
    private static String z = "02";

    private static int a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        K = new WeakReference(context);
        L = str3;
        M = str;
        N = str2;
        O = str4;
        G = str6;
        F = str5;
        H = TextUtils.isEmpty(str6) ? "0" : "1";
        A = null;
        B = null;
        C = null;
        E = str6;
        p();
        return 0;
    }

    static String a(Context context) {
        return a(context, true, "0");
    }

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        int i2;
        int i3;
        Resources resources;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v", "1.5");
            jSONObject.put("sdkVerMode", "02");
            jSONObject.put("os_name", "android");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("tn", UPUtils.forWap(com.unionpay.utils.b.a(str), com.unionpay.utils.b.b(str2)));
            }
            jSONObject.put("appUuId", com.unionpay.utils.e.b(context));
            try {
                jSONObject.put("locale", Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US");
                jSONObject.put("terminal_version", VERSION);
                if (context == null || (resources = context.getResources()) == null) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i2 = displayMetrics.widthPixels;
                    i3 = displayMetrics.heightPixels;
                }
                jSONObject.put("terminal_resolution", (i2 + "*" + i3).trim());
                String strReplace = "";
                jSONObject.put("os_version", !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE.trim() : "");
                if (!TextUtils.isEmpty(Build.MODEL)) {
                    String strTrim = Build.MODEL.trim();
                    if (!TextUtils.isEmpty(strTrim)) {
                        strReplace = strTrim.replace(PPSLabelView.Code, "");
                    }
                }
                jSONObject.put("device_model", strReplace);
                jSONObject.put("root", new File("/system/bin/su").exists() ? "1" : "0");
                jSONObject.put(am.O, com.unionpay.utils.b.e(Locale.getDefault().getCountry()));
                jSONObject.put("package", com.unionpay.utils.b.e(com.unionpay.utils.e.a(context)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put("vendorCapacity", str4);
            if (!TextUtils.isEmpty(str7)) {
                jSONObject.put("randKey", UPUtils.forWap(com.unionpay.utils.b.a(str), com.unionpay.utils.b.b(str7)));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("has_sdk", str3);
            }
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put("merId", str8);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("isLimitSe", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("seType", com.unionpay.utils.b.c(str6));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String a(Context context, boolean z2, String str) {
        return a(context, O, z2 ? null : L, z2 ? "0" : null, str, H, E, null, null);
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strA = com.unionpay.utils.i.a(jSONObject, "sign");
            String strA2 = com.unionpay.utils.i.a(jSONObject, "configs");
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) {
                return null;
            }
            String str4 = new String(Base64.decode(strA2, 2));
            String strB = com.unionpay.utils.b.b(UPUtils.a(str4 + str3));
            String strForConfig = UPUtils.forConfig(com.unionpay.utils.b.a(str2), strA);
            if (TextUtils.isEmpty(strForConfig) || !strForConfig.equals(strB)) {
                return null;
            }
            return str4;
        } catch (Exception unused) {
            return null;
        }
    }

    static void a() {
    }

    private static void a(Context context, String str, String str2) {
        String strForScanUrl = UPUtils.forScanUrl(com.unionpay.utils.b.a(str));
        com.unionpay.utils.j.a("uppay", "url: " + strForScanUrl);
        String strA = com.unionpay.utils.b.a();
        com.unionpay.a.d dVar = new com.unionpay.a.d(strForScanUrl);
        dVar.a(a(context, str, null, null, null, null, null, strA, str2));
        Executors.newSingleThreadExecutor().execute(new d(dVar, context, str, strA));
    }

    static /* synthetic */ void a(Context context, JSONArray jSONArray, int i2) {
        while (jSONArray != null && i2 < jSONArray.length()) {
            Object objA = com.unionpay.utils.i.a(jSONArray, i2);
            if (objA == null) {
                return;
            }
            JSONObject jSONObject = (JSONObject) objA;
            String strA = com.unionpay.utils.i.a(jSONObject, "type");
            if ("app".equals(strA)) {
                JSONArray jSONArrayB = com.unionpay.utils.i.b(jSONObject, "package_info");
                String strA2 = com.unionpay.utils.i.a(jSONObject, "app_server");
                JSONArray jSONArrayB2 = b(jSONArrayB, com.hihonor.adsdk.base.g.j.e.a.N0);
                if (jSONArrayB2.length() > 0) {
                    int length = jSONArrayB2.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object objA2 = com.unionpay.utils.i.a(jSONArrayB2, i3);
                        if (objA2 != null) {
                            JSONObject jSONObject2 = (JSONObject) objA2;
                            String strA3 = com.unionpay.utils.i.a(jSONObject2, "schema");
                            String strA4 = com.unionpay.utils.i.a(jSONObject2, "sign");
                            String strA5 = com.unionpay.utils.i.a(jSONObject2, "version");
                            if (com.unionpay.utils.b.a(context, strA3) && strA4.equalsIgnoreCase(com.unionpay.utils.b.b(context, strA3)) && com.unionpay.utils.b.c(context, strA3).matches(strA5)) {
                                try {
                                    Bundle bundle = new Bundle();
                                    a(L, bundle, O);
                                    bundle.putString(f9302a, M);
                                    bundle.putString(d, N);
                                    bundle.putString(b, L);
                                    bundle.putString(s, F);
                                    bundle.putString(u, G);
                                    if (!TextUtils.isEmpty(G)) {
                                        bundle.putString(v, A);
                                        bundle.putString(w, B);
                                        bundle.putString(x, C);
                                        bundle.putString(y, D);
                                    }
                                    bundle.putBoolean(l, I);
                                    bundle.putString(r, strA2);
                                    bundle.putString(f, null);
                                    bundle.putInt(i, 0);
                                    Intent intent = new Intent();
                                    intent.putExtras(bundle);
                                    if (o.equals(strA3)) {
                                        intent.setAction(p);
                                        intent.setPackage(strA3);
                                    } else {
                                        intent.setClassName(strA3, n);
                                    }
                                    try {
                                        Context contextQ = q();
                                        if (contextQ != null) {
                                            if (contextQ instanceof Activity) {
                                                ((Activity) contextQ).startActivityForResult(intent, J);
                                                return;
                                            } else {
                                                intent.addFlags(268435456);
                                                contextQ.startActivity(intent);
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Exception unused) {
                                        return;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } else {
                String string = "";
                if ("wap".equals(strA)) {
                    if (!t.equals(F)) {
                        try {
                            string = (String) jSONObject.get("url");
                        } catch (Exception unused2) {
                        }
                        a(string, "wap");
                        return;
                    }
                } else if ("link".equals(strA)) {
                    try {
                        string = jSONObject.getString("url");
                    } catch (Exception unused3) {
                    }
                    a(string, "link");
                    return;
                } else {
                    if ("wcd".equals(strA)) {
                        try {
                            string = jSONObject.getString("url");
                        } catch (Exception unused4) {
                        }
                        a(string, "wcd");
                        return;
                    }
                    context = q();
                }
            }
            jSONArray = ab;
            i2 = S + 1;
            S = i2;
        }
    }

    private static void a(String str, Bundle bundle, String str2) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        if (str.trim().charAt(0) != '<') {
            bundle.putString(q, str2);
        } else if (str2 == null || !str2.trim().equalsIgnoreCase("00")) {
            bundle.putBoolean(e, true);
        } else {
            bundle.putBoolean(e, false);
        }
    }

    private static void a(String str, String str2) {
        int i2;
        Bundle bundle = new Bundle();
        if (!"link".equals(str2)) {
            a(L, bundle, O);
            bundle.putString(f9302a, M);
            bundle.putString(d, N);
            try {
                i2 = Integer.parseInt(O);
            } catch (Exception unused) {
                i2 = 0;
            }
            bundle.putString(b, UPUtils.forWap(i2, com.unionpay.utils.b.b(L)));
            bundle.putString(c, L);
        }
        bundle.putString("magic_data", "949A1CC");
        bundle.putString(j, str);
        bundle.putString(k, str2);
        try {
            Context contextQ = q();
            if (contextQ != null) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(contextQ, UPPayWapActivity.class);
                if (contextQ instanceof Activity) {
                    ((Activity) contextQ).startActivityForResult(intent, J);
                } else {
                    intent.addFlags(268435456);
                    contextQ.startActivity(intent);
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray b(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; jSONArray != null && i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optJSONObject(i2));
        }
        Collections.sort(arrayList, new e(str));
        JSONArray jSONArray2 = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jSONArray2.put((JSONObject) arrayList.get(i3));
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(O);
        } catch (Exception unused) {
            i2 = 0;
        }
        String strForUrl = UPUtils.forUrl(i2);
        com.unionpay.utils.j.a("uppay", "url: " + strForUrl);
        V = new com.unionpay.a.d(strForUrl);
        V.a(a(q(), false, str));
        if (W == null) {
            W = new Handler(ac);
        }
        Executors.newSingleThreadExecutor().execute(new b());
    }

    public static boolean checkWalletInstalled(Context context) {
        return checkWalletInstalled(context, "00", null);
    }

    public static boolean checkWalletInstalled(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "00";
        }
        System.loadLibrary("entryexpro");
        String strA = a(UPUtils.a(context, "scan_configs"), UPUtils.a(context, "scan_mode"), UPUtils.a(context, "scan_random"));
        if (TextUtils.isEmpty(strA)) {
            strA = Y;
        }
        if (!TextUtils.isEmpty(strA)) {
            try {
                JSONArray jSONArray = new JSONArray(strA);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object objA = com.unionpay.utils.i.a(jSONArray, i2);
                    if (objA instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) objA;
                        if ("app".equals(com.unionpay.utils.i.a(jSONObject, "type"))) {
                            JSONArray jSONArrayB = b(com.unionpay.utils.i.b(jSONObject, "package_info"), com.hihonor.adsdk.base.g.j.e.a.N0);
                            for (int i3 = 0; i3 < jSONArrayB.length(); i3++) {
                                Object objA2 = com.unionpay.utils.i.a(jSONArrayB, i3);
                                if (objA2 instanceof JSONObject) {
                                    JSONObject jSONObject2 = (JSONObject) objA2;
                                    if (context != null && jSONObject2 != null && com.unionpay.utils.b.a(context, com.unionpay.utils.i.a(jSONObject2, "schema"), com.unionpay.utils.i.a(jSONObject2, "sign"), com.unionpay.utils.i.a(jSONObject2, "version"))) {
                                        a(context, str, str2);
                                        return true;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        a(context, str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            A = jSONObject.getString("titleLogo");
            B = jSONObject.getString("loadingLogo");
            C = jSONObject.getString("backGroundColor");
            D = jSONObject.getString("textColor");
        } catch (Exception unused) {
        }
    }

    public static int getSEPayInfo(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        return com.unionpay.utils.b.d(context, "com.unionpay.tsmservice.mi") ? new com.unionpay.b.g(context, uPQuerySEPayInfoCallback).a() : new com.unionpay.b.b(context, uPQuerySEPayInfoCallback).a();
    }

    static /* synthetic */ boolean j() {
        T = true;
        return true;
    }

    static /* synthetic */ boolean m() {
        U = true;
        return true;
    }

    private static int p() {
        JSONArray jSONArray;
        int i2;
        WeakReference weakReference = K;
        if (weakReference == null || weakReference.get() == null) {
            return 1;
        }
        if (TextUtils.isEmpty(F) && TextUtils.isEmpty(G)) {
            I = false;
        } else {
            I = true;
            if (z.equalsIgnoreCase(G)) {
                F = t;
            }
        }
        S = 0;
        T = false;
        U = false;
        System.loadLibrary("entryexpro");
        String strA = UPUtils.a(q(), "configs" + G);
        String strA2 = UPUtils.a(q(), "mode" + G);
        String strA3 = UPUtils.a(q(), "or" + G);
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strA2) && !TextUtils.isEmpty(strA3)) {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                String strA4 = com.unionpay.utils.i.a(jSONObject, "sign");
                try {
                    i2 = Integer.parseInt(strA2);
                } catch (Exception unused) {
                    i2 = 0;
                }
                String str = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str2 = "";
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
                String strB = com.unionpay.utils.b.b(UPUtils.a(str + str2 + strA3));
                String strForConfig = UPUtils.forConfig(i2, strA4);
                if (!TextUtils.isEmpty(strForConfig) && strForConfig.equals(strB)) {
                    if (TextUtils.isEmpty(G)) {
                        X = str;
                    } else if ("04".equals(G)) {
                        aa = str;
                    } else {
                        Z = str;
                    }
                    if (!TextUtils.isEmpty(E)) {
                        String strA5 = UPUtils.a(q(), "se_configs" + E);
                        if (!TextUtils.isEmpty(strA5)) {
                            d(strA5);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            if (TextUtils.isEmpty(G)) {
                jSONArray = new JSONArray(X);
            } else {
                jSONArray = "04".equals(G) ? new JSONArray(aa) : new JSONArray(Z);
            }
            ab = b(jSONArray, com.hihonor.adsdk.base.g.j.e.a.N0);
        } catch (Exception unused3) {
        }
        W = new Handler(ac);
        if (TextUtils.isEmpty(G) || !com.unionpay.utils.b.b()) {
            c("0");
        } else {
            HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(q());
            W.sendEmptyMessageDelayed(1004, 1000L);
            hwOpenPayTask.supportCapacity("UNIONONLINEPAY", new c());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context q() {
        WeakReference weakReference = K;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public static void releaseMemory() {
        K = null;
    }

    public static int startPay(Context context, String str, String str2, String str3, String str4) {
        return a(context, str, str2, str3, str4, "", "");
    }

    public static void startPayByJAR(Context context, Class cls, String str, String str2, String str3, String str4) {
        startPay(context, str, str2, str3, str4);
    }

    public static int startSEPay(Context context, String str, String str2, String str3, String str4, String str5) {
        return a(context, str, str2, str3, str4, "", str5);
    }

    public static void startSamsungPay(Context context, Class cls, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4, t, z);
    }
}

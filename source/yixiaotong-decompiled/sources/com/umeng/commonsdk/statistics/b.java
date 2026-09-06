package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9250a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static Map<String, String> j;
    private static boolean l;
    private int k = 0;

    public static void a(boolean z) {
        l = z;
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put("header", "#h");
        j.put("sdk_type", "#sdt");
        j.put(am.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(am.g, "#umid");
        j.put(am.x, am.x);
        j.put("language", "#lang");
        j.put(am.ai, "#dt");
        j.put("resolution", "#rl");
        j.put(am.H, "#dmf");
        j.put(am.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put("os_version", "#ov");
        j.put(am.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(am.F, "#db");
        j.put("appkey", "#ak");
        j.put(am.Y, "#itr");
        j.put("id_type", "#it");
        j.put(Constant.MAP_KEY_UUID, "#ud");
        j.put("device_id", "#dd");
        j.put(am.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put("package_name", "#pkg");
        j.put(am.p, "#sig");
        j.put(am.q, "#sis1");
        j.put(am.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(am.v, "#imd");
        j.put(am.B, "#mnc");
        j.put(am.E, "#boa");
        j.put(am.G, "#mant");
        j.put(am.M, "#tz");
        j.put(am.O, "#ct");
        j.put(am.P, "#car");
        j.put(am.s, "#disn");
        j.put("network_type", "#nt");
        j.put(am.b, "#cv");
        j.put(am.d, "#mv");
        j.put(am.c, "#cot");
        j.put(am.e, "#mod");
        j.put(am.aj, "#al");
        j.put("session_id", "#sid");
        j.put(am.S, "#ip");
        j.put(am.U, "#sre");
        j.put(am.V, "#fre");
        j.put(am.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(am.aU, "#tsv");
        j.put(am.aV, "#rps");
        j.put(am.aY, "#mov");
        j.put(d.i, "#vt");
        j.put("secret", "#sec");
        j.put(d.ah, "#prv");
        j.put(d.l, "#$prv");
        j.put(d.m, "#uda");
        j.put(am.f9100a, "#tok");
        j.put(am.aM, "#iv");
        j.put(am.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(am.ap, "#mt");
        j.put(am.am, "#zsv");
        j.put(am.ao, "#oos");
    }

    public static String a(String str) {
        return j.containsKey(str) ? j.get(str) : str;
    }

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    /* JADX WARN: Code duplicated, block: B:123:0x023f A[Catch: Exception -> 0x023b, TryCatch #1 {Exception -> 0x023b, blocks: (B:119:0x0234, B:123:0x023f, B:124:0x0243, B:126:0x0249, B:128:0x024f, B:130:0x0253, B:132:0x0257), top: B:147:0x0234 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0249 A[Catch: Exception -> 0x023b, TryCatch #1 {Exception -> 0x023b, blocks: (B:119:0x0234, B:123:0x023f, B:124:0x0243, B:126:0x0249, B:128:0x024f, B:130:0x0253, B:132:0x0257), top: B:147:0x0234 }] */
    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        Iterator<String> itKeys;
        String next;
        String str4;
        String str5;
        Envelope envelope;
        String str6;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            JSONObject jSONObjectA = a(context, str2, jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.n));
            if (jSONObjectA != null && jSONObject != null) {
                jSONObjectA = a(jSONObjectA, jSONObject);
            }
            JSONObject jSONObject4 = jSONObjectA;
            if (jSONObject4 != null && jSONObject2 != null) {
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && (next2 instanceof String) && (str6 = next2) != null && jSONObject2.opt(str6) != null) {
                        try {
                            jSONObject4.put(a(str6), jSONObject2.opt(str6));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "u";
            }
            String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
            if (jSONObject4 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2).append("==").append(str7).append("&=");
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return a(101, jSONObject4);
                }
                if (string.endsWith("&=")) {
                    string = string.substring(0, string.length() - 2);
                }
                str5 = string;
            } else {
                str5 = null;
            }
            if (jSONObject4 != null) {
                try {
                    e eVarA = e.a(context);
                    if (eVarA != null) {
                        eVarA.b();
                        String strEncodeToString = Base64.encodeToString(new be().a(eVarA.c()), 0);
                        if (!TextUtils.isEmpty(strEncodeToString)) {
                            JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                            jSONObject5.put(a(am.Y), strEncodeToString);
                            jSONObject4.put(a("header"), jSONObject5);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject4);
            }
            if (jSONObject4 != null) {
                Envelope envelopeA = a(context, jSONObject4.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject4);
                }
                envelope = envelopeA;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject4);
            }
            int iA = a(context, envelope, str5, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (iA != 0) {
                return a(iA, jSONObject4);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
            }
            if (!str5.startsWith(am.aD) && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                new com.umeng.commonsdk.stateless.b(context);
                com.umeng.commonsdk.stateless.b.b();
            }
            return jSONObject4;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = jSONObject6;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject6;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject3 = null;
                }
            } else {
                jSONObject3 = null;
            }
            if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                        if (jSONObject2 != null) {
                            itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                next = itKeys.next();
                                if (next == null && (next instanceof String) && (str4 = next) != null && jSONObject2.opt(str4) != null) {
                                    try {
                                        jSONObject3.put(str4, jSONObject2.opt(str4));
                                    } catch (Exception unused4) {
                                    }
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                } else if (jSONObject2 != null) {
                    itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        next = itKeys.next();
                        if (next == null) {
                        }
                    }
                }
            }
            return a(110, jSONObject3);
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelope;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                Envelope envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
                envelope = envelopeA;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "z==1.2.0", jSONObject3 != null ? jSONObject3.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(com.umeng.commonsdk.internal.c.f9225a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0453 A[Catch: all -> 0x045c, TRY_LEAVE, TryCatch #15 {all -> 0x045c, blocks: (B:101:0x0449, B:103:0x0453), top: B:201:0x0449 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0474 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0487 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:112:0x049a A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:115:0x04ad A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:118:0x04c0 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:121:0x04d3 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:124:0x04e6 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:127:0x04f9 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:130:0x050c A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:133:0x051f A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0532 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0545 A[Catch: all -> 0x0559, TryCatch #12 {all -> 0x0559, blocks: (B:104:0x045c, B:106:0x0474, B:107:0x047f, B:109:0x0487, B:110:0x0492, B:112:0x049a, B:113:0x04a5, B:115:0x04ad, B:116:0x04b8, B:118:0x04c0, B:119:0x04cb, B:121:0x04d3, B:122:0x04de, B:124:0x04e6, B:125:0x04f1, B:127:0x04f9, B:128:0x0504, B:130:0x050c, B:131:0x0517, B:133:0x051f, B:134:0x052a, B:136:0x0532, B:137:0x053d, B:139:0x0545, B:140:0x0550), top: B:195:0x045c }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0563 A[Catch: all -> 0x056c, TRY_LEAVE, TryCatch #8 {all -> 0x056c, blocks: (B:141:0x0559, B:143:0x0563), top: B:187:0x0559 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0576 A[Catch: all -> 0x05a3, TRY_LEAVE, TryCatch #1 {all -> 0x05a3, blocks: (B:3:0x000d, B:6:0x001b, B:57:0x02cc, B:58:0x02d9, B:60:0x030c, B:61:0x0315, B:63:0x031d, B:64:0x0328, B:65:0x0342, B:67:0x034c, B:71:0x035a, B:73:0x0364, B:77:0x0370, B:86:0x03c4, B:88:0x03cc, B:144:0x056c, B:146:0x0576, B:148:0x0579, B:151:0x0588, B:153:0x058d, B:155:0x0593, B:76:0x036d, B:70:0x0357, B:9:0x0028, B:12:0x009d, B:14:0x00ae, B:16:0x00b6, B:18:0x00c0, B:19:0x00c9, B:21:0x00d3, B:22:0x00dc, B:24:0x00e6, B:25:0x00ef, B:27:0x0179, B:28:0x019d, B:31:0x01fb, B:36:0x021e, B:38:0x0226, B:39:0x0231, B:42:0x0239, B:44:0x024a, B:46:0x0280, B:47:0x028b, B:49:0x029e, B:54:0x02c3, B:43:0x0243, B:32:0x0205, B:34:0x020d, B:35:0x0215, B:13:0x00a7), top: B:173:0x000d, inners: #3, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x058b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x058d A[Catch: all -> 0x05a3, TryCatch #1 {all -> 0x05a3, blocks: (B:3:0x000d, B:6:0x001b, B:57:0x02cc, B:58:0x02d9, B:60:0x030c, B:61:0x0315, B:63:0x031d, B:64:0x0328, B:65:0x0342, B:67:0x034c, B:71:0x035a, B:73:0x0364, B:77:0x0370, B:86:0x03c4, B:88:0x03cc, B:144:0x056c, B:146:0x0576, B:148:0x0579, B:151:0x0588, B:153:0x058d, B:155:0x0593, B:76:0x036d, B:70:0x0357, B:9:0x0028, B:12:0x009d, B:14:0x00ae, B:16:0x00b6, B:18:0x00c0, B:19:0x00c9, B:21:0x00d3, B:22:0x00dc, B:24:0x00e6, B:25:0x00ef, B:27:0x0179, B:28:0x019d, B:31:0x01fb, B:36:0x021e, B:38:0x0226, B:39:0x0231, B:42:0x0239, B:44:0x024a, B:46:0x0280, B:47:0x028b, B:49:0x029e, B:54:0x02c3, B:43:0x0243, B:32:0x0205, B:34:0x020d, B:35:0x0215, B:13:0x00a7), top: B:173:0x000d, inners: #3, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x0370 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0364 A[Catch: Exception -> 0x036c, all -> 0x05a3, TRY_LEAVE, TryCatch #3 {Exception -> 0x036c, blocks: (B:71:0x035a, B:73:0x0364), top: B:177:0x035a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x039d A[Catch: all -> 0x03b0, TRY_ENTER, TryCatch #9 {all -> 0x03b0, blocks: (B:78:0x0386, B:81:0x039d, B:82:0x03a7), top: B:189:0x0386 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x03a7 A[Catch: all -> 0x03b0, TRY_LEAVE, TryCatch #9 {all -> 0x03b0, blocks: (B:78:0x0386, B:81:0x039d, B:82:0x03a7), top: B:189:0x0386 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x03b6 A[Catch: all -> 0x03c4, TRY_LEAVE, TryCatch #2 {all -> 0x03c4, blocks: (B:83:0x03b0, B:85:0x03b6), top: B:175:0x03b0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x03cc A[Catch: all -> 0x05a3, TRY_LEAVE, TryCatch #1 {all -> 0x05a3, blocks: (B:3:0x000d, B:6:0x001b, B:57:0x02cc, B:58:0x02d9, B:60:0x030c, B:61:0x0315, B:63:0x031d, B:64:0x0328, B:65:0x0342, B:67:0x034c, B:71:0x035a, B:73:0x0364, B:77:0x0370, B:86:0x03c4, B:88:0x03cc, B:144:0x056c, B:146:0x0576, B:148:0x0579, B:151:0x0588, B:153:0x058d, B:155:0x0593, B:76:0x036d, B:70:0x0357, B:9:0x0028, B:12:0x009d, B:14:0x00ae, B:16:0x00b6, B:18:0x00c0, B:19:0x00c9, B:21:0x00d3, B:22:0x00dc, B:24:0x00e6, B:25:0x00ef, B:27:0x0179, B:28:0x019d, B:31:0x01fb, B:36:0x021e, B:38:0x0226, B:39:0x0231, B:42:0x0239, B:44:0x024a, B:46:0x0280, B:47:0x028b, B:49:0x029e, B:54:0x02c3, B:43:0x0243, B:32:0x0205, B:34:0x020d, B:35:0x0215, B:13:0x00a7), top: B:173:0x000d, inners: #3, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x03d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:94:0x0411 A[Catch: all -> 0x0449, TryCatch #5 {all -> 0x0449, blocks: (B:92:0x040b, B:94:0x0411, B:96:0x0417, B:97:0x0424, B:99:0x042a, B:100:0x0440), top: B:181:0x040b }] */
    /* JADX WARN: Code duplicated, block: B:99:0x042a A[Catch: all -> 0x0449, LOOP:1: B:97:0x0424->B:99:0x042a, LOOP_END, TryCatch #5 {all -> 0x0449, blocks: (B:92:0x040b, B:94:0x0411, B:96:0x0417, B:97:0x0424, B:99:0x042a, B:100:0x0440), top: B:181:0x040b }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:163:0x03b0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static org.json.JSONObject a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 1448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(d.i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("&&").append(str2).append("_").append(System.currentTimeMillis()).append("_").append(strB).append(".log");
        byte[] binary = envelope.toBinary();
        if (str.startsWith(am.aD) || str.startsWith("i") || str.startsWith("a") || str.startsWith("t")) {
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
        return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
    }
}

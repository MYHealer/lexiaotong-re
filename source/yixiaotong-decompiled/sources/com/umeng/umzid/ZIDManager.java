package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import com.unionpay.tsmservice.mi.data.Constant;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ZIDManager {
    public static ZIDManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9296a = false;
    public boolean b = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9297a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f9297a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.f9297a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB, "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9298a;

        public b(Context context) {
            this.f9298a = context;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:19:0x004c  */
        /* JADX WARN: Code duplicated, block: B:28:0x0072  */
        /* JADX WARN: Code duplicated, block: B:35:0x0098  */
        /* JADX WARN: Code duplicated, block: B:44:0x00b0 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:48:0x00c3 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00d8 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:52:0x00eb A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:55:0x00f8 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:58:0x0105 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #0 {all -> 0x0108, blocks: (B:7:0x001a, B:9:0x0020, B:11:0x0027, B:14:0x0037, B:16:0x003d, B:18:0x0047, B:20:0x004d, B:23:0x005d, B:25:0x0063, B:27:0x006d, B:29:0x0073, B:32:0x008d, B:34:0x0093, B:36:0x0099, B:39:0x00a0, B:41:0x00a6, B:42:0x00aa, B:44:0x00b0, B:46:0x00b5, B:48:0x00c3, B:50:0x00d8, B:52:0x00eb, B:53:0x00ee, B:55:0x00f8, B:56:0x00fb, B:58:0x0105), top: B:62:0x001a }] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            String string;
            String id;
            String string2;
            String strC;
            String string3;
            String strB;
            String string4;
            String strA;
            JSONObject jSONObject;
            String strOptString;
            String string5;
            String string6;
            SharedPreferences sharedPreferencesA;
            SharedPreferences sharedPreferencesA2;
            SharedPreferences sharedPreferencesA3;
            SharedPreferences sharedPreferencesA4;
            ZIDManager zIDManager = ZIDManager.this;
            Context context = this.f9298a;
            if (zIDManager.b) {
                return;
            }
            zIDManager.b = true;
            JSONObject jSONObject2 = new JSONObject();
            String string7 = "";
            if (context != null) {
                try {
                    SharedPreferences sharedPreferencesA5 = com.umeng.umzid.a.a(context);
                    if (sharedPreferencesA5 != null) {
                        string = sharedPreferencesA5.getString("zdata", null);
                    } else {
                        string = "";
                    }
                    id = Spy.getID();
                    jSONObject2.put("zdata", id);
                    jSONObject2.put("old_zdata", string);
                    if (context != null || (sharedPreferencesA4 = com.umeng.umzid.a.a(context)) == null) {
                        string2 = "";
                    } else {
                        string2 = sharedPreferencesA4.getString("oaid", "");
                        if (com.umeng.umzid.c.c(string2)) {
                            string2 = com.umeng.umzid.c.a(string2);
                        }
                    }
                    strC = com.umeng.umzid.c.c(context);
                    jSONObject2.put("old_oaid", string2);
                    jSONObject2.put("oaid", strC);
                    if (context != null || (sharedPreferencesA3 = com.umeng.umzid.a.a(context)) == null) {
                        string3 = "";
                    } else {
                        string3 = sharedPreferencesA3.getString(Constant.KEY_MAC, "");
                        if (com.umeng.umzid.c.c(string3)) {
                            string3 = com.umeng.umzid.c.a(string3);
                        }
                    }
                    strB = com.umeng.umzid.c.b(context);
                    jSONObject2.put(Constant.KEY_MAC, strB);
                    jSONObject2.put("old_mac", string3);
                    zIDManager.a(context, jSONObject2);
                    jSONObject2.put("aaid", com.umeng.umzid.c.a(context));
                    if (context != null || (sharedPreferencesA2 = com.umeng.umzid.a.a(context)) == null) {
                        string4 = "";
                    } else {
                        string4 = sharedPreferencesA2.getString("uabc", "");
                    }
                    jSONObject2.put("uabc", string4);
                    if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
                        string7 = sharedPreferencesA.getString("resetToken", "");
                    }
                    if (!TextUtils.isEmpty(string7)) {
                        jSONObject2.put("resetToken", string7);
                    }
                    strA = com.umeng.umzid.a.a("https://aaid.umeng.com/api/updateZdata", jSONObject2.toString());
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject = new JSONObject(strA);
                        if (Boolean.valueOf(jSONObject.optBoolean("suc")).booleanValue()) {
                            com.umeng.umzid.c.f(context, id);
                            com.umeng.umzid.c.a(context, strB);
                            com.umeng.umzid.c.b(context, strC);
                            strOptString = jSONObject.optString("aaid");
                            if (!TextUtils.isEmpty(strOptString)) {
                                com.umeng.umzid.c.e(context, strOptString);
                            }
                            string5 = jSONObject.getString("uabc");
                            if (!TextUtils.isEmpty(string5)) {
                                com.umeng.umzid.c.d(context, string5);
                            }
                            string6 = jSONObject.getString("resetToken");
                            if (!TextUtils.isEmpty(string6)) {
                                com.umeng.umzid.c.c(context, string6);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            } else {
                string = "";
                id = Spy.getID();
                jSONObject2.put("zdata", id);
                jSONObject2.put("old_zdata", string);
                if (context != null) {
                    string2 = "";
                } else {
                    string2 = "";
                }
                strC = com.umeng.umzid.c.c(context);
                jSONObject2.put("old_oaid", string2);
                jSONObject2.put("oaid", strC);
                if (context != null) {
                    string3 = "";
                } else {
                    string3 = "";
                }
                strB = com.umeng.umzid.c.b(context);
                jSONObject2.put(Constant.KEY_MAC, strB);
                jSONObject2.put("old_mac", string3);
                zIDManager.a(context, jSONObject2);
                jSONObject2.put("aaid", com.umeng.umzid.c.a(context));
                if (context != null) {
                    string4 = "";
                } else {
                    string4 = "";
                }
                jSONObject2.put("uabc", string4);
                if (context != null) {
                    string7 = sharedPreferencesA.getString("resetToken", "");
                }
                if (!TextUtils.isEmpty(string7)) {
                    jSONObject2.put("resetToken", string7);
                }
                strA = com.umeng.umzid.a.a("https://aaid.umeng.com/api/updateZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    jSONObject = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, strB);
                        com.umeng.umzid.c.b(context, strC);
                        strOptString = jSONObject.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            com.umeng.umzid.c.e(context, strOptString);
                        }
                        string5 = jSONObject.getString("uabc");
                        if (!TextUtils.isEmpty(string5)) {
                            com.umeng.umzid.c.d(context, string5);
                        }
                        string6 = jSONObject.getString("resetToken");
                        if (!TextUtils.isEmpty(string6)) {
                            com.umeng.umzid.c.c(context, string6);
                        }
                    }
                }
            }
            zIDManager.b = false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f9299a;

        public c(Context context) {
            this.f9299a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f9299a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString = null;
        if (!zIDManager.f9296a) {
            zIDManager.f9296a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                String strB = com.umeng.umzid.c.b(context);
                jSONObject.put(Constant.KEY_MAC, strB);
                String strC = com.umeng.umzid.c.c(context);
                jSONObject.put("oaid", strC);
                zIDManager.a(context, jSONObject);
                String strA = com.umeng.umzid.a.a("https://aaid.umeng.com/api/postZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        com.umeng.umzid.c.f(context, id);
                        com.umeng.umzid.c.a(context, strB);
                        com.umeng.umzid.c.b(context, strC);
                        strOptString = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            com.umeng.umzid.c.e(context, strOptString);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            com.umeng.umzid.c.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            com.umeng.umzid.c.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f9296a = false;
        }
        return strOptString;
    }

    public static synchronized ZIDManager getInstance() {
        if (c == null) {
            c = new ZIDManager();
        }
        return c;
    }

    public static String getSDKVersion() {
        return "1.4.0";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String strA = com.umeng.umzid.c.a(origApplicationContext);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        com.umeng.umzid.b.a(new c(origApplicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        try {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(BiddingConst.BIDDING_LOSS.WITH_BIDDING_TIMEOUT, "传入参数appkey为空");
                }
                return;
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(origApplicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strA = com.umeng.umzid.c.a(origApplicationContext);
            if (strA == null || TextUtils.isEmpty(strA)) {
                com.umeng.umzid.b.a(new a(origApplicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.b.a(new b(origApplicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strA);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID, "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID, string).commit();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:32:0x0090 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #10 {all -> 0x009d, blocks: (B:29:0x0086, B:30:0x008a, B:32:0x0090), top: B:130:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d7  */
    public final JSONObject a(Context context, JSONObject jSONObject) throws JSONException {
        Object obj;
        Locale locale;
        Calendar calendar;
        int rawOffset;
        Object obj2;
        String string;
        Object obj3;
        Object string2;
        Object country;
        Method declaredMethod;
        SharedPreferences sharedPreferencesA;
        Method declaredMethod2;
        Method declaredMethod3;
        jSONObject.putOpt("zdata_ver", Spy.getVersion());
        Object obj4 = "";
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls == null || (declaredMethod3 = cls.getDeclaredMethod("getAndroidId", Context.class)) == null) {
                obj = "";
            } else {
                declaredMethod3.setAccessible(true);
                Object objInvoke = declaredMethod3.invoke(cls, context);
                if (objInvoke == null || !(objInvoke instanceof String)) {
                    obj = "";
                } else {
                    obj = (String) objInvoke;
                }
            }
        } catch (Throwable unused) {
        }
        jSONObject.putOpt("android_id", obj);
        String externalStorageState = Environment.getExternalStorageState();
        jSONObject.putOpt("storage", Long.valueOf(("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) ? Environment.getExternalStorageDirectory().getFreeSpace() : 0L));
        jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
        Object string3 = null;
        if (context == null) {
            rawOffset = 8;
        } else {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable unused2) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = Locale.getDefault();
                    calendar = Calendar.getInstance(locale);
                    if (calendar != null) {
                        rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                    } else {
                        rawOffset = 8;
                    }
                } catch (Throwable unused3) {
                }
            } else {
                calendar = Calendar.getInstance(locale);
                if (calendar != null) {
                    rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                } else {
                    rawOffset = 8;
                }
            }
        }
        jSONObject.putOpt(am.M, Integer.valueOf(rawOffset));
        jSONObject.putOpt("model", Build.MODEL);
        try {
            Class<?> cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls2 == null || (declaredMethod2 = cls2.getDeclaredMethod("getImeiNew", Context.class)) == null) {
                obj2 = "";
            } else {
                declaredMethod2.setAccessible(true);
                Object objInvoke2 = declaredMethod2.invoke(cls2, context);
                if (objInvoke2 == null || !(objInvoke2 instanceof String)) {
                    obj2 = "";
                } else {
                    obj2 = (String) objInvoke2;
                }
            }
        } catch (Throwable unused4) {
        }
        jSONObject.putOpt("imei", obj2);
        try {
            Method declaredMethod4 = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod4.setAccessible(true);
            string = declaredMethod4.invoke(null, "net.hostname").toString();
            if (string != null) {
                try {
                    if (!string.equalsIgnoreCase("")) {
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            messageDigest.update(string.getBytes());
                            byte[] bArrDigest = messageDigest.digest();
                            StringBuffer stringBuffer = new StringBuffer();
                            for (byte b2 : bArrDigest) {
                                stringBuffer.append(Integer.toHexString(b2 & 255));
                            }
                            string = stringBuffer.toString();
                        } catch (Throwable unused5) {
                            string = "";
                        }
                    }
                } catch (Exception unused6) {
                }
            }
        } catch (Exception unused7) {
            string = null;
        }
        jSONObject.putOpt("hostname", string);
        jSONObject.putOpt("sdk_version", "1.4.0");
        jSONObject.putOpt("package_name", context == null ? null : context.getPackageName());
        jSONObject.putOpt("sdk_type", "Android");
        SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID, sharedPreferencesA2 != null ? sharedPreferencesA2.getString(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID, "") : "");
        jSONObject.putOpt("source_id", BaseConstants.CATEGORY_UMENG);
        try {
            obj3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            obj3 = null;
        }
        jSONObject.putOpt("app_version", obj3);
        try {
            string2 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
            string2 = null;
        }
        jSONObject.putOpt("app_name", string2);
        try {
            country = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e3) {
            e3.printStackTrace();
            country = null;
        }
        jSONObject.putOpt(am.O, country);
        if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
            string3 = sharedPreferencesA.getString("appkey", null);
        }
        jSONObject.putOpt("appkey", string3);
        try {
            Class<?> cls3 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            if (cls3 != null && (declaredMethod = cls3.getDeclaredMethod("getIdfa", Context.class)) != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke3 = declaredMethod.invoke(cls3, context);
                if (objInvoke3 != null && (objInvoke3 instanceof String)) {
                    obj4 = (String) objInvoke3;
                }
            }
        } catch (Throwable unused8) {
        }
        jSONObject.putOpt(com.hihonor.adsdk.base.g.j.e.a.hnadsv, obj4);
        return jSONObject;
    }
}

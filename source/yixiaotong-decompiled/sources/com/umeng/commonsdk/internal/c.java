package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMInternalDataProtocol.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements UMLogDataProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9225a = "um_policy_grant";
    public static final String b = "preInitInvokedFlag";
    public static final String c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private static int f = 1;
    private static final String g = "info";
    private static final String h = "stat";
    private static Class<?> i;
    private static Method j;
    private static Method k;
    private static Method l;
    private static boolean m;
    private Context e;

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    static {
        c();
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                i = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    j = declaredMethod;
                }
                Method declaredMethod2 = i.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    k = declaredMethod2;
                }
                Method declaredMethod3 = i.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    l = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String a() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || k == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            return objInvoke != null ? (String) k.invoke(objInvoke, this.e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || l == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            return objInvoke != null ? (String) l.invoke(objInvoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public c(Context context) {
        if (context != null) {
            this.e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(am.x), "Android");
            JSONObject jSONObjectBuildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (jSONObjectBuildZeroEnvelopeWithExtHeader != null && jSONObjectBuildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        ao aoVarA = ao.a(this.e);
        ap apVarA = aoVarA.a(aq.c);
        if (apVarA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = apVarA.f9104a;
                String str2 = apVarA.b;
                JSONObject jSONObjectA = new com.umeng.commonsdk.statistics.b().a(StubApp.getOrigApplicationContext(this.e.getApplicationContext()), new JSONObject(apVarA.c), new JSONObject(apVarA.d), apVarA.e, str2, apVarA.f);
                if (jSONObjectA != null && jSONObjectA.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                aoVarA.a(aq.c, str);
                aoVarA.b();
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f9270a, 0);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strA = aa.a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                        editorEdit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                        editorEdit2.putString(h.b, strA);
                        editorEdit2.commit();
                    }
                    UMConfigureImpl.removeInterruptFlag();
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String strA = aa.a(origApplicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(strA);
                }
            }
        }).start();
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.f9270a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.b, str);
                        editorEdit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void e() {
        if (!m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
                m = true;
                a(this.e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                SharedPreferences sharedPreferences = c.this.e.getSharedPreferences(h.f9270a, 0);
                                if (sharedPreferences != null) {
                                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                    editorEdit.putString(h.b, str);
                                    editorEdit.commit();
                                }
                            } catch (Throwable unused) {
                            }
                            UMWorkDispatch.sendEvent(c.this.e, a.w, b.a(c.this.e).a(), null);
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                    }
                });
                return;
            }
            return;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return;
        }
        m = false;
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.e);
            f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.e != null) {
                        UMWorkDispatch.sendEvent(c.this.e, a.x, b.a(c.this.e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            b(this.e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x018d  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x01c1 A[Catch: all -> 0x0387, TRY_LEAVE, TryCatch #0 {all -> 0x0387, blocks: (B:5:0x001d, B:9:0x0050, B:15:0x0068, B:17:0x0086, B:19:0x008c, B:20:0x009c, B:22:0x00c8, B:25:0x00d2, B:27:0x00d6, B:29:0x00ec, B:41:0x0164, B:43:0x017b, B:45:0x0186, B:49:0x018e, B:51:0x0194, B:53:0x019f, B:57:0x01a8, B:59:0x01ae, B:60:0x01ba, B:61:0x01c1), top: B:106:0x0018 }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) throws JSONException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        ULog.i("walle", "[internal] workEvent");
        boolean z = true;
        try {
            switch (i2) {
                case a.f /* 32769 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        String strA = aa.a(this.e);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (!TextUtils.isEmpty(strA) && (sharedPreferences = this.e.getSharedPreferences(h.f9270a, 0)) != null) {
                            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                            editorEdit2.putString(h.b, strA);
                            editorEdit2.putString(h.c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                            editorEdit2.commit();
                        }
                        break;
                    } catch (Throwable unused) {
                    }
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    if (cls != null) {
                        cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.e);
                    }
                    break;
                case a.h /* 32771 */:
                    ULog.i("walle", "[internal] workEvent cache battery, event is " + obj.toString());
                    Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    if (cls2 != null) {
                        cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.e, (String) obj);
                    }
                    break;
                case a.k /* 32774 */:
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent");
                    if (cls3 != null) {
                        cls3.getMethod("wifiChange", Context.class).invoke(cls3, this.e);
                    }
                    break;
                case a.l /* 32775 */:
                    Class<?> cls4 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    if (cls4 != null) {
                        cls4.getMethod("saveUA", Context.class, String.class).invoke(cls4, this.e, (String) obj);
                    }
                    break;
                case a.m /* 32776 */:
                    SharedPreferences sharedPreferences2 = StubApp.getOrigApplicationContext(this.e.getApplicationContext()).getSharedPreferences("info", 0);
                    if (sharedPreferences2 != null) {
                        sharedPreferences2.edit().putString(h, (String) obj).commit();
                    }
                    break;
                case a.n /* 32777 */:
                    ULog.i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(am.aM, a.e);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(am.au, new JSONObject());
                    JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.e, jSONObject, jSONObject2);
                    if (jSONObjectBuildEnvelopeWithExtHeader != null && !jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                        ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                        break;
                    }
                    break;
                case a.o /* 32779 */:
                    Sender.handleEvent(this.e, (com.umeng.commonsdk.vchannel.b) obj);
                    break;
                case a.p /* 32781 */:
                    if (!UMFrUtils.hasEnvelopeFile(this.e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                        a(this.e);
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                    }
                    break;
                case a.s /* 32784 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    f();
                    f--;
                    g();
                    break;
                case a.t /* 32785 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (ao.a(this.e).c()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                    } else {
                        d();
                        if (!UMWorkDispatch.eventHasExist(a.t)) {
                            Context context = this.e;
                            UMWorkDispatch.sendEvent(context, a.t, b.a(context).a(), null);
                        }
                    }
                    break;
                case a.u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.e, obj);
                    break;
                case a.v /* 32787 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String strA2 = com.umeng.commonsdk.stateless.d.a(this.e, false);
                    String strA3 = com.umeng.commonsdk.stateless.d.a(this.e, true);
                    if (TextUtils.isEmpty(strA2)) {
                        z = false;
                    } else {
                        File file = new File(strA2);
                        if (!file.exists() || !file.isDirectory()) {
                            z = false;
                        }
                    }
                    if (TextUtils.isEmpty(strA3)) {
                        if (!z) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                        }
                        break;
                    } else {
                        File file2 = new File(strA3);
                        if (!file2.exists() || !file2.isDirectory()) {
                            if (!z) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                            }
                            break;
                        }
                    }
                    if (!com.umeng.commonsdk.stateless.b.a()) {
                        new com.umeng.commonsdk.stateless.b(this.e);
                        com.umeng.commonsdk.stateless.b.b();
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                    }
                    break;
                case a.w /* 32788 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    com.umeng.commonsdk.statistics.b.a();
                    e();
                    if (FieldManager.allow(com.umeng.commonsdk.utils.b.E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        Context context2 = this.e;
                        UMWorkDispatch.sendEventEx(context2, o.a.C, CoreProtocol.getInstance(context2), null, 5000L);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.b.F)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                        l.a(this.e).b(this.e);
                    }
                    break;
                case a.x /* 32790 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    f--;
                    g();
                    break;
                case a.y /* 32791 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    c(this.e);
                    com.umeng.commonsdk.a.a(this.e);
                    d(this.e);
                    break;
                case a.z /* 32792 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (obj instanceof Integer) {
                        int iIntValue = ((Integer) obj).intValue();
                        SharedPreferences sharedPreferences3 = StubApp.getOrigApplicationContext(this.e.getApplicationContext()).getSharedPreferences(f9225a, 0);
                        if (sharedPreferences3 != null) {
                            sharedPreferences3.edit().putInt("policyGrantResult", iIntValue).commit();
                        }
                    }
                    break;
                case a.A /* 32793 */:
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        if (jSONObject3.has(a.G)) {
                            int i3 = jSONObject3.getInt(a.G);
                            int i4 = jSONObject3.getInt(a.H);
                            int i5 = jSONObject3.getInt("policyGrantResult");
                            SharedPreferences sharedPreferences4 = StubApp.getOrigApplicationContext(this.e.getApplicationContext()).getSharedPreferences(f9225a, 0);
                            if (sharedPreferences4 != null && (editorEdit = sharedPreferences4.edit()) != null) {
                                editorEdit.putInt(b, i3);
                                editorEdit.putInt(c, i4);
                                editorEdit.putInt("policyGrantResult", i5);
                                editorEdit.commit();
                            }
                            File file3 = new File(this.e.getFilesDir().getAbsolutePath() + File.separator + aq.m);
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                        }
                    }
                    break;
                case a.B /* 32800 */:
                    File file4 = new File(this.e.getFilesDir().getAbsolutePath() + File.separator + aq.m);
                    if (file4.exists()) {
                        file4.delete();
                    }
                    break;
                case a.C /* 32801 */:
                    SelfChecker.doCheck(this.e);
                    break;
            }
        } catch (Throwable unused2) {
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void d(Context context) {
        Object objInvoke;
        Method declaredMethod;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> clsA = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = clsA.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (objInvoke = declaredMethod2.invoke(clsA, new Object[0])) == null || (declaredMethod = clsA.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(objInvoke, origApplicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            d(this.e);
        }
    }

    private static void e(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + aq.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.e)) {
            e(this.e);
            com.umeng.commonsdk.a.a(this.e);
            Context context = this.e;
            UMWorkDispatch.sendEvent(context, o.a.x, CoreProtocol.getInstance(context), null);
            Context context2 = this.e;
            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
        }
    }
}

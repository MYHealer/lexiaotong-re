package com.jd.ad.sdk.bl.initsdk;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.packet.e;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.fdt.logger.JADLogAdapter;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.jad_xk.jad_hu;
import com.jd.ad.sdk.jad_xk.jad_iv;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.multi.BuildConfig;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADYunSdk {
    public static final int REQUEST_CODE_MEDIA_DIALOG = 9991;
    private static boolean isEnableLog = false;
    private static boolean isInitSuccess = false;
    private static JADInitCallback mInitCallback = null;
    public static jad_er mInnerInitCallBack = null;
    private static boolean mSupportMultiProcess = false;
    private static String sAppId = "";
    public static volatile JADLogAdapter sLogAdapter;
    public static volatile JADPrivateController sPrivateController;

    public class jad_an implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_jw.jad_an.jad_an)) {
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                    com.jd.ad.sdk.jad_jw.jad_an.jad_an = jad_anVar.jad_an("refo");
                    Object objJad_an = jad_anVar.jad_an("refot", (Class<Object>) Long.TYPE);
                    if (System.currentTimeMillis() - ((objJad_an == null || !(objJad_an instanceof Long)) ? 0L : ((Long) objJad_an).longValue()) > 86400000) {
                        com.jd.ad.sdk.jad_jw.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    }
                }
            } catch (Exception e) {
                Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid error: ").append(Log.getStackTraceString(e)).toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()));
            }
        }
    }

    public class jad_bo extends JADLogAdapter {
        @Override // com.jd.ad.sdk.fdt.logger.JADLogAdapter, com.jd.ad.sdk.jad_kt.jad_bo
        public boolean isLoggable(int i, String str) {
            if (JADYunSdk.isEnableLog) {
                return super.isLoggable(i, str);
            }
            return false;
        }
    }

    public class jad_cp implements jad_er {
    }

    public class jad_dq implements Runnable {
        public final /* synthetic */ Context jad_an;
        public final /* synthetic */ JADYunSdkConfig jad_bo;

        public jad_dq(Context context, JADYunSdkConfig jADYunSdkConfig) {
            this.jad_an = context;
            this.jad_bo = jADYunSdkConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADYunSdk.init(this.jad_an, this.jad_bo);
        }
    }

    public interface jad_er {
    }

    private static void crashInit() {
        if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(10, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_xk.jad_bo jad_boVar = com.jd.ad.sdk.jad_xk.jad_bo.C0588jad_bo.jad_an;
        try {
            jad_boVar.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) ? "jadcrash" : "jadcrash_" + jad_jw.jad_cp(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()), 0);
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof com.jd.ad.sdk.jad_xk.jad_bo) && jad_boVar.jad_bo == null) {
                jad_boVar.jad_bo = Thread.getDefaultUncaughtExceptionHandler();
            }
            Thread.setDefaultUncaughtExceptionHandler(jad_boVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WorkExecutor.execute(new com.jd.ad.sdk.jad_xk.jad_an(com.jd.ad.sdk.jad_xk.jad_bo.C0588jad_bo.jad_an));
    }

    public static String getAppId() {
        return !TextUtils.isEmpty(sAppId) ? sAppId : com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an(e.f);
    }

    public static JADPrivateController getPrivateController() {
        return sPrivateController;
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void init(Context context, JADYunSdkConfig jADYunSdkConfig) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        initJADLog(jADYunSdkConfig);
        Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.jd.ad.sdk.jad_fq.jad_cp.jad_an = application;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new ActLifecycle());
        }
        sAppId = jADYunSdkConfig.getAppId();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_re.jad_bo(jADYunSdkConfig));
        mSupportMultiProcess = jADYunSdkConfig.isSupportMultiProcess();
        Context contextJad_an = context instanceof Application ? context : com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        initAntiSDK(contextJad_an);
        if (jADYunSdkConfig.getPrivateController() != null) {
            sPrivateController = jADYunSdkConfig.getPrivateController();
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            JADPrivateController jADPrivateController = sPrivateController;
            jad_fsVar.jad_jw = jADPrivateController;
            String oaid = jADPrivateController.getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                jad_fsVar.jad_an = oaid;
                com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_an("oidCustom", oaid);
            }
            jad_fsVar.jad_fs = jADPrivateController.isCanUseLocation();
            JADLocation location = jADPrivateController.getLocation();
            if (location != null && location.isValid()) {
                jad_fsVar.jad_dq = location;
            }
            jad_fsVar.jad_jt = jADPrivateController.isCanUseIP();
            String ip = jADPrivateController.getIP();
            if (!TextUtils.isEmpty(ip) && !"0.0.0.0".equals(ip)) {
                jad_fsVar.jad_cp = ip;
            }
            if (contextJad_an != null) {
                jad_fsVar.jad_hu.clear();
                Iterator<String> it = com.jd.ad.sdk.jad_qd.jad_dq.jad_bo.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_hu.add(com.jd.ad.sdk.jad_fq.jad_fs.jad_an(it.next()));
                }
            }
            try {
                jad_fsVar.jad_iv.clear();
                com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                if (jad_anVarJad_an != null) {
                    String str = jad_anVarJad_an.jad_qd;
                    if (!TextUtils.isEmpty(str)) {
                        jad_fsVar.jad_iv.addAll(Arrays.asList(str.split(",")));
                    }
                }
            } catch (Exception unused) {
            }
        }
        crashInit();
        jad_iv jad_ivVar = jad_iv.jad_cp.jad_an;
        jad_ivVar.getClass();
        WorkExecutor.execute(new jad_hu(jad_ivVar, context));
        initInternalInitCallBack();
        String appId = jADYunSdkConfig.getAppId();
        Handler handler = com.jd.ad.sdk.jad_ob.jad_er.jad_an;
        com.jd.ad.sdk.jad_ob.jad_bo.jad_bo = true;
        com.jd.ad.sdk.jad_ob.jad_er.jad_an(appId);
        ActLifecycle.jad_an(new com.jd.ad.sdk.jad_ob.jad_er.jad_bo());
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        String strJad_dq = jad_anVar.jad_dq("isRegisterNetworkReceiver");
        if (TextUtils.isEmpty(strJad_dq) || !strJad_dq.equals("1")) {
            if (com.jd.ad.sdk.jad_ob.jad_er.jad_bo == null) {
                com.jd.ad.sdk.jad_ob.jad_er.jad_bo = new com.jd.ad.sdk.jad_ob.jad_hu();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextJad_an.registerReceiver(com.jd.ad.sdk.jad_ob.jad_er.jad_bo, intentFilter, null, null);
            jad_anVar.jad_bo("isRegisterNetworkReceiver", "1");
        }
        initSOaid();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_hu.jad_dq(context));
        WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_dq(com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an, context));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        int i = com.jd.ad.sdk.jad_vi.jad_an.jad_an;
        if (i < 1) {
            com.jd.ad.sdk.jad_vi.jad_an.jad_an = i + 1;
            JSONObject jSONObject = new JSONObject();
            JsonUtils.put(jSONObject, OapsKey.KEY_TYPE, 6);
            JsonUtils.put(jSONObject, "iid", UUIDUtils.uuid());
            JsonUtils.put(jSONObject, "init", 1);
            JsonUtils.put(jSONObject, "idu", Long.valueOf(jCurrentTimeMillis2));
            jad_ivVar.jad_bo(jSONObject);
        }
        SplashRenderVideoHelper.init(context);
    }

    private static void initAntiSDK(Context context) {
        if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(11, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_il.jad_bo jad_boVar = new com.jd.ad.sdk.jad_il.jad_bo();
        jad_boVar.jad_an = context;
        jad_boVar.jad_bo = false;
        synchronized (com.jd.ad.sdk.jad_il.jad_an.class) {
            if (com.jd.ad.sdk.jad_il.jad_an.jad_bo) {
                Log.i("AntiSDK", "AntiSDK has initialized.");
            } else {
                Context context2 = jad_boVar.jad_an;
                if (context2 == null) {
                    Log.w("AntiSDK", "context is null");
                } else {
                    boolean z = jad_boVar.jad_bo;
                    com.jd.android.sdk.coreinfo.util.Logger.enableLogger(z);
                    Log.i("AntiSDK", "init AntiSDK :context=" + jad_boVar.jad_an + ", debugFlag=" + z);
                    com.jd.ad.sdk.jad_il.jad_an.jad_an = context2;
                    com.jd.ad.sdk.jad_il.jad_an.jad_bo = true;
                }
            }
        }
    }

    private static void initInternalInitCallBack() {
        mInnerInitCallBack = new jad_cp();
    }

    private static void initJADLog(JADYunSdkConfig jADYunSdkConfig) {
        isEnableLog = jADYunSdkConfig.isEnableLog();
        if (sLogAdapter == null) {
            sLogAdapter = new jad_bo();
            Logger.addLogAdapter(sLogAdapter);
        }
    }

    private static void initSOaid() {
        try {
            if (com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(12, (String) null)) {
                return;
            }
            if (JADMediator.getInstance().getInitService().getOpenReflectOaid() == 1) {
                WorkExecutor.execute(new jad_an());
            } else {
                com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
            }
        } catch (Exception unused) {
            com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
        }
    }

    public static boolean isEnableLog() {
        return isEnableLog;
    }

    public static boolean isInitSuccess() {
        return isInitSuccess;
    }

    public static boolean isSupportMultiProcess() {
        return mSupportMultiProcess;
    }

    public static void asyncInit(Context context, JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        WorkExecutor.execute(new jad_dq(context, jADYunSdkConfig));
    }

    public static void syncInit(Context context, JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        init(context, jADYunSdkConfig);
    }
}

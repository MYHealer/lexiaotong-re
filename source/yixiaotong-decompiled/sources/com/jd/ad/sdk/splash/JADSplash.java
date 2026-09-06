package com.jd.ad.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADSplash implements IJADBase, JADAdLoadListener, com.jd.ad.sdk.splash.jad_s_fs.jad_s_an, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private String mInstanceId;
    private com.jd.ad.sdk.splash.jad_s_an.jad_s_cp mInteractionListener;
    private JADSplashCountDownListener mJADCountDownListener;
    private JADSplashListener mJADListener;
    private final com.jd.ad.sdk.splash.jad_s_fs mJADSplashTolerateManager;
    private JADSplashVideoListener mJADSplashVideoListener;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private com.jd.ad.sdk.splash.jad_s_an mSplashAdRender;
    private int srtp;
    private int mSplashStylePlanType = 0;
    private int mSplashClickAreaValue = 100;
    private long mRemainTolerateTime = 0;

    public class jad_s_an implements Runnable {
        public jad_s_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCloseCallback();
        }
    }

    public class jad_s_bo implements Runnable {
        public final /* synthetic */ int jad_s_an;

        public jad_s_bo(int i) {
            this.jad_s_an = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCountDownCallback(this.jad_s_an);
        }
    }

    public class jad_s_cp implements ActLifecycle.OnLifecycleChangeListener {
        public jad_s_cp() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(Activity activity) {
            if (activity.hashCode() == JADSplash.this.mAttachActivityHashCode) {
                JADSplash.this.destroy();
            }
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityPaused(Activity activity) {
            if (activity.hashCode() != JADSplash.this.mAttachActivityHashCode || JADSplash.this.mSplashAdRender == null) {
                return;
            }
            JADSplash.this.mSplashAdRender.getClass();
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityResumed(Activity activity) {
            if (activity.hashCode() != JADSplash.this.mAttachActivityHashCode || JADSplash.this.mSplashAdRender == null) {
                return;
            }
            JADSplash.this.mSplashAdRender.getClass();
        }
    }

    public class jad_s_dq implements Runnable {
        public jad_s_dq() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.startRender();
        }
    }

    public class jad_s_er implements com.jd.ad.sdk.splash.jad_s_an.jad_s_cp {
        public jad_s_er() {
        }
    }

    public class jad_s_fs implements Runnable {
        public jad_s_fs() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadCallback();
        }
    }

    public class jad_s_hu implements Runnable {
        public final /* synthetic */ View jad_s_an;

        public jad_s_hu(View view) {
            this.jad_s_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderSucCallback(this.jad_s_an);
        }
    }

    public class jad_s_iv implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_iv(int i, String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jt implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_jt(int i, String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jw implements Runnable {
        public jad_s_jw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdClickCallback();
        }
    }

    public class jad_s_kx implements Runnable {
        public jad_s_kx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdShowedCallback();
        }
    }

    public JADSplash(Context context, JADSlot jADSlot) {
        this.dstp = 0;
        this.srtp = 0;
        this.mInstanceId = "";
        this.mAttachActivityHashCode = -1;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.mContextWf = new WeakReference<>(context);
            if (context instanceof Activity) {
                this.mAttachActivityHashCode = context.hashCode();
            }
        }
        this.mInstanceId = UUIDUtils.uuid();
        if (jADSlot == null) {
            Logger.w("JADSlot can not be null !!!", new Object[0]);
        } else {
            this.mSlot = jADSlot;
            JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
            this.dstp = JADMediator.getInstance().getInitService().getDs(this.mSlot.getSlotID());
            this.srtp = JADMediator.getInstance().getInitService().getR(this.mSlot.getSlotID());
        }
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        this.mJADSplashTolerateManager = getTolerateWidget(jADSlot.getTolerateTime());
        initActLifeListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_jw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_an());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCountDownOnUiThread(int i) {
        HandlerUtils.runOnUiThread(new jad_s_bo(i));
    }

    private void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_s_jt(i, str));
    }

    private void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_fs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_s_hu(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_s_iv(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_kx());
    }

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private int getAdType() {
        return 1;
    }

    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 4;
    }

    private String getTolerateTimeFinishErin(String str) {
        String slotID;
        float tolerateTime;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null) {
            slotID = jADSlot.getSlotID();
            tolerateTime = this.mSlot.getTolerateTime();
        } else {
            slotID = "";
            tolerateTime = 0.0f;
        }
        JsonUtils.put(jSONObject, "pid", slotID);
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "toti", Float.valueOf(tolerateTime));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    private com.jd.ad.sdk.splash.jad_s_fs getTolerateWidget(float f) {
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = new com.jd.ad.sdk.splash.jad_s_fs(f);
        jad_s_fsVar.jad_s_dq = this;
        return jad_s_fsVar;
    }

    private void initInteractionListener() {
        this.mInteractionListener = new jad_s_er();
    }

    private void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_s_dq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClickCallback() {
        Logger.d(a.a("seven_back=====onAdClickCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdCloseCallback() {
        Logger.d(a.a("seven_back=====onAdCloseCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClose();
        }
        this.mJADListener = null;
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdCountDownCallback(int i) {
        Logger.d(a.a("seven_back=====onAdCountDownCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jADSplashCountDownListener.onCountdown(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback() {
        Logger.d(a.a("seven_back=====onAdLoadCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an = true;
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(int i, String str) {
        Logger.d(a.a("seven_back=====onAdLoadFailedCallback====TYPE=").append(getAdType()).append(",code=").append(i).append(",error=").append(str).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdRenderFailedCallback(int i, String str) {
        Logger.d(a.a("seven_back=====onAdRenderFailedCallback====TYPE=").append(getAdType()).append(",code=").append(i).append(",error=").append(str).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            jad_s_fsVar.jad_s_an();
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onRenderFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdRenderSucCallback(View view) {
        Logger.d(a.a("seven_back=====onAdRenderCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("seven_back===thread error!!", new Object[0]);
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
            if (jad_s_fsVar != null) {
                jad_s_fsVar.jad_s_an();
            }
            JADSplashListener jADSplashListener = this.mJADListener;
            if (jADSplashListener != null) {
                jADSplashListener.onRenderSuccess(view);
                return;
            }
            return;
        }
        if (this.mSlot != null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String requestId = this.mSlot.getRequestId();
            JADError jADError = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            eventService.reportRenderFailedEvent(requestId, jADError.getCode(), jADError.getMessage(new String[0]), this.mSlot.getSen());
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar2 = this.mJADSplashTolerateManager;
        if (jad_s_fsVar2 != null) {
            jad_s_fsVar2.jad_s_an();
        }
        JADSplashListener jADSplashListener2 = this.mJADListener;
        if (jADSplashListener2 != null) {
            JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            jADSplashListener2.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdShowedCallback() {
        Logger.d(a.a("seven_back=====onAdShowedCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onExposure();
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRender() {
        JADSlot jADSlot;
        this.mSplashAdRender = new com.jd.ad.sdk.splash.jad_s_an(getAppContext(), this.mSlot, this.mInstanceId, getImageUrl());
        initInteractionListener();
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        jad_s_anVar.jad_s_hu = this.mInteractionListener;
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jad_s_anVar.jad_s_ly = jADSplashCountDownListener;
        }
        JADSplashVideoListener jADSplashVideoListener = this.mJADSplashVideoListener;
        if (jADSplashVideoListener != null) {
            jad_s_anVar.jad_s_mz = jADSplashVideoListener;
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null) {
            this.mRemainTolerateTime = (long) ((jad_s_fsVar.jad_s_bo * 1000.0f) - (System.currentTimeMillis() - jad_s_fsVar.jad_s_er));
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
        jad_s_anVar2.jad_s_qd = this.mRemainTolerateTime;
        if (jad_s_anVar2.jad_s_bo == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str = jad_s_anVar2.jad_s_er;
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jADError.getMessage(new String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_an() == null) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            String str2 = jad_s_anVar2.jad_s_er;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_bo.getMediaSpecSetType() != 10009) {
            Context contextJad_s_an = jad_s_anVar2.jad_s_an();
            JADError jADError3 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError3.getCode();
            String message = jADError3.getMessage(new String[0]);
            if (contextJad_s_an == null || (jADSlot = jad_s_anVar2.jad_s_bo) == null) {
                JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
                jad_s_anVar2.jad_s_an(code, message);
                return;
            }
            if (jADSlot.getDynamicRenderTemplateHelper() == null) {
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
            try {
                if (JADMediator.getInstance().getDynamicRenderService().createDynamicView(contextJad_s_an, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2) == null) {
                    JADError jADError4 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    jad_s_anVar2.onDynamicRenderFailed(jADError4.getCode(), jADError4.getMessage(new String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setDynamicRenderViewInitSuccessTime(System.currentTimeMillis());
                    jad_s_anVar2.jad_s_bo.setRem(3);
                }
                return;
            } catch (Throwable th) {
                try {
                    Exception exc = new Exception("dynamic render view init error", th);
                    JSONObject jSONObjectJad_s_an = jad_s_anVar2.jad_s_an(exc);
                    int iOptInt = jSONObjectJad_s_an.optInt("code");
                    JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, iOptInt, jSONObjectJad_s_an.optString("msg"), jad_s_anVar2.jad_s_fs);
                    Logger.d(iOptInt + ": " + Log.getStackTraceString(exc));
                } catch (Exception e) {
                    Logger.d(Log.getStackTraceString(e));
                }
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
        }
        jad_s_anVar2.jad_s_ob = true;
        Context contextJad_s_an2 = jad_s_anVar2.jad_s_an();
        JADError jADError5 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code2 = jADError5.getCode();
        String message2 = jADError5.getMessage(new String[0]);
        if (contextJad_s_an2 == null || jad_s_anVar2.jad_s_bo == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code2, message2, jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(code2, message2);
            return;
        }
        try {
            if (jad_s_anVar2.jad_s_uh == null) {
                jad_s_anVar2.jad_s_uh = new com.jd.ad.sdk.jad_s_an.jad_s_cp(jad_s_anVar2);
            }
            if (jad_s_anVar2.jad_s_vi == null) {
                jad_s_anVar2.jad_s_vi = new com.jd.ad.sdk.jad_s_an.jad_s_dq(jad_s_anVar2);
            }
            try {
                if (JADMediator.getInstance().getVideoRenderService().createVideoRendView(contextJad_s_an2, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2.jad_s_qd, jad_s_anVar2.jad_s_uh, jad_s_anVar2.jad_s_vi) == null) {
                    JADError jADError6 = JADError.RENDER_VIDEO_FAIL_ERROR;
                    jad_s_anVar2.jad_s_bo(jADError6.getCode(), jADError6.getMessage(new String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setRem(1);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    Exception exc2 = new Exception("video render view init error", th);
                    JSONObject jSONObjectJad_s_an2 = jad_s_anVar2.jad_s_an(exc2);
                    int iOptInt2 = jSONObjectJad_s_an2.optInt("code");
                    JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, iOptInt2, jSONObjectJad_s_an2.optString("msg"), jad_s_anVar2.jad_s_fs);
                    Logger.d(iOptInt2 + ": " + Log.getStackTraceString(exc2));
                } catch (Exception e2) {
                    Logger.d(Log.getStackTraceString(e2));
                }
                jad_s_anVar2.jad_s_bo(code2, message2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public String getErin(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final IJADExtra getJADExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    public JADMaterialData getJADMaterialData() {
        List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList == null || jADMaterialDataList.isEmpty() || jADMaterialDataList.get(0) == null) {
            return null;
        }
        return jADMaterialDataList.get(0);
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadFailure(int i, String str) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null || jADSlot.getAdDataRequestSourceType() != 1) {
            callbackAdLoadFailedOnUiThread(i, str);
        } else {
            doAfterPreloadFinished();
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadSuccess() {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null && jADSlot.getAdDataRequestSourceType() == 1) {
            doAfterPreloadFinished();
        } else {
            callbackAdLoadOnUiThread();
            notifyRender();
        }
    }

    @Override // com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback
    public void onUseCacheCounterFinish() {
        JADMediator.getInstance().getAdService().loadAdFromCache(this.mInstanceId, this.mSlot, this);
    }

    public void preloadAd() {
        String strUuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(strUuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            return;
        }
        jADSlot.setRequestId(strUuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public void setCountDownListener(JADSplashCountDownListener jADSplashCountDownListener) {
        this.mJADCountDownListener = jADSplashCountDownListener;
    }

    public void setSplashVideoListener(JADSplashVideoListener jADSplashVideoListener) {
        this.mJADSplashVideoListener = jADSplashVideoListener;
    }

    private String getImageUrl() {
        return (getJADMaterialData() == null || getJADMaterialData().getImageUrls() == null || getJADMaterialData().getImageUrls().isEmpty()) ? "" : getJADMaterialData().getImageUrls().get(0);
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_s_cp jad_s_cpVar = new jad_s_cp();
            this.mLifeChangeListener = jad_s_cpVar;
            ActLifecycle.addLifecycleListener(jad_s_cpVar);
        }
    }

    public boolean isMaterialMetaPreload() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_na;
        }
        return false;
    }

    public boolean isMaterialMetaVideo() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_ob;
        }
        return false;
    }

    public void destroy() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            try {
                JADMediator.getInstance().getTouchService().unregisterTouchView(jad_s_anVar.jad_s_dq);
                JADMediator.getInstance().getExposureService().unregisterExposureView(jad_s_anVar.jad_s_dq);
                if (jad_s_anVar.jad_s_cp() != null) {
                    jad_s_anVar.jad_s_cp().destroy();
                }
                View view = jad_s_anVar.jad_s_jt;
                if (((view == null || !(view instanceof VideoRenderView)) ? null : (VideoRenderView) view) != null) {
                    ((view == null || !(view instanceof VideoRenderView)) ? null : (VideoRenderView) view).destroy();
                }
                jad_s_anVar.jad_s_jt = null;
                jad_s_anVar.jad_s_iv = null;
                jad_s_anVar.jad_s_hu = null;
            } catch (Exception e) {
                Logger.w(a.a("Exception while destroy: ").append(e.getMessage()).toString(), new Object[0]);
            }
            this.mSplashAdRender = null;
        }
        this.mJADListener = null;
        if (this.mInteractionListener != null) {
            this.mInteractionListener = null;
        }
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
        ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener = this.mLifeChangeListener;
        if (onLifecycleChangeListener != null) {
            ActLifecycle.removeLifecycleListener(onLifecycleChangeListener);
            this.mLifeChangeListener = null;
        }
    }

    public final void loadAd(JADSplashListener jADSplashListener) {
        Handler handler;
        this.mJADListener = jADSplashListener;
        String strUuid = UUIDUtils.uuid();
        if (this.mSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(strUuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        com.jd.ad.sdk.splash.jad_s_fs jad_s_fsVar = this.mJADSplashTolerateManager;
        if (jad_s_fsVar != null && (handler = jad_s_fsVar.jad_s_cp) != null) {
            handler.sendEmptyMessageDelayed(1, (long) (jad_s_fsVar.jad_s_bo * 1000.0f));
            jad_s_fsVar.jad_s_er = System.currentTimeMillis();
        }
        startPreloadAdDataTimeCounter();
        this.mSlot.setRequestId(strUuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(0);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public final void removeSplashView() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.jad_s_dq(jad_s_anVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateClickArea() {
        View view;
        try {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot == null) {
                return;
            }
            if (jADSlot.getRem() == 3) {
                this.mSplashStylePlanType = 6;
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
                if (jad_s_anVar != null && jad_s_anVar.jad_s_cp() != null) {
                    this.mSplashClickAreaValue = this.mSplashAdRender.jad_s_cp().getAdClickAreaValue();
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
                return;
            }
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
            if (jad_s_anVar2 != null && jad_s_anVar2.jad_s_iv != null && (view = jad_s_anVar2.jad_s_jt) != null) {
                this.mSplashStylePlanType = jad_s_anVar2.jad_s_jw;
                int measuredWidth = (int) (view.getMeasuredWidth() * this.mSplashAdRender.jad_s_jt.getMeasuredHeight());
                int measuredWidth2 = this.mSplashAdRender.jad_s_iv.getMeasuredWidth() * this.mSplashAdRender.jad_s_iv.getMeasuredHeight();
                if (measuredWidth > 0) {
                    this.mSplashClickAreaValue = (measuredWidth2 * 100) / measuredWidth;
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
            }
        } catch (Exception e) {
            Logger.w(a.a("Exception while calculate area: ").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickEvent(int i, int i2, int i3, int i4) {
        JADSlot jADSlot;
        if (i == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCloseEvent(int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDelayExposureEvent(String str, int i, int i2) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportExposureEvent(String str, int i, int i2) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    private void reportRenderSuccessEvent() {
        long j;
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        long dynamicRenderViewInitSuccessTime = this.mSlot.getDynamicRenderViewInitSuccessTime();
        if (dynamicRenderViewInitSuccessTime > 0) {
            long loadTime = dynamicRenderViewInitSuccessTime - this.mSlot.getLoadTime();
            Logger.d("dynamic render view init time:" + loadTime);
            j = loadTime;
        } else {
            j = 0;
        }
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }

    @Override // com.jd.ad.sdk.splash.jad_s_fs.jad_s_an
    public void onCounterFinish() {
        String requestId;
        int sen;
        if (this.mJADSplashTolerateManager != null) {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot != null) {
                requestId = jADSlot.getRequestId();
                sen = this.mSlot.getSen();
            } else {
                requestId = "";
                sen = 0;
            }
            if (!this.mJADSplashTolerateManager.jad_s_an) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                JADError jADError = JADError.GW_RESPONSE_TOLERATE_TIME_ERROR;
                eventService.reportRequestErrorEvent(requestId, jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])));
                onAdLoadFailedCallback(jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])));
            } else {
                JADEventService eventService2 = JADMediator.getInstance().getEventService();
                JADError jADError2 = JADError.RENDER_TOLERATE_TIME_ERROR;
                eventService2.reportRenderFailedEvent(requestId, jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])), sen);
                onAdRenderFailedCallback(jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])));
            }
            this.mJADListener = null;
        }
    }
}

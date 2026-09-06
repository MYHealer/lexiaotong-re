package com.jd.ad.sdk.nativead;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.event.JADVideoReporter;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_n_an.jad_n_dq;
import com.jd.ad.sdk.jad_n_an.jad_n_er;
import com.jd.ad.sdk.jad_n_an.jad_n_fs;
import com.jd.ad.sdk.jad_n_an.jad_n_hu;
import com.jd.ad.sdk.jad_n_an.jad_n_iv;
import com.jd.ad.sdk.jad_n_an.jad_n_jt;
import com.jd.ad.sdk.jad_n_an.jad_n_jw;
import com.jd.ad.sdk.jad_n_an.jad_n_kx;
import com.jd.ad.sdk.jad_n_an.jad_n_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADNative implements IJADBase {
    private WeakReference<Activity> mActivityRef;
    private jad_n_er mAdViewController;
    private String mInstanceId;
    private IJADExtra mJADExtra;
    private JADNativeLoadListener mLoadListener;
    private List<JADMaterialData> mMaterialDataList;
    private final JADSlot mSlot;
    private JADVideoReporter mVideoReporter;

    public class jad_n_an implements JADAdLoadListener {
        public jad_n_an() {
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadFailure(int i, String str) {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadFailedOnUiThread(jADNative.mLoadListener, i, str);
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadSuccess() {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadOnUiThread(jADNative.mLoadListener);
        }
    }

    public class jad_n_bo implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;

        public jad_n_bo(JADNativeLoadListener jADNativeLoadListener) {
            this.jad_n_an = jADNativeLoadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadCallback(this.jad_n_an);
        }
    }

    public class jad_n_cp implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;
        public final /* synthetic */ int jad_n_bo;
        public final /* synthetic */ String jad_n_cp;

        public jad_n_cp(JADNativeLoadListener jADNativeLoadListener, int i, String str) {
            this.jad_n_an = jADNativeLoadListener;
            this.jad_n_bo = i;
            this.jad_n_cp = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadFailedCallback(this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
        }
    }

    public JADNative(JADSlot jADSlot) {
        this.mInstanceId = "";
        this.mInstanceId = UUIDUtils.uuid();
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
        this.mSlot = jADSlot;
        this.mAdViewController = new jad_n_er();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadFailedOnUiThread(JADNativeLoadListener jADNativeLoadListener, int i, String str) {
        HandlerUtils.runOnUiThread(new jad_n_cp(jADNativeLoadListener, i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdLoadOnUiThread(JADNativeLoadListener jADNativeLoadListener) {
        HandlerUtils.runOnUiThread(new jad_n_bo(jADNativeLoadListener));
    }

    private int getRenderMode() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback(JADNativeLoadListener jADNativeLoadListener) {
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(JADNativeLoadListener jADNativeLoadListener, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadFailure(i, str);
        }
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public List<JADMaterialData> getDataList() {
        List<JADMaterialData> list = this.mMaterialDataList;
        if (list == null || list.size() == 0) {
            this.mMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        }
        return this.mMaterialDataList;
    }

    public int getDisplayScene(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 64;
        }
        if (i != 4) {
            return i != 5 ? 0 : 1;
        }
        return 2;
    }

    public String getErin(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "pid", str);
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(i));
        JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public String getInstanceId() {
        return this.mInstanceId;
    }

    public int getMediaSpecSetType() {
        return this.mSlot.getMediaSpecSetType();
    }

    public JADSlot getSlot() {
        return this.mSlot;
    }

    public void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, JADNativeInteractionListener jADNativeInteractionListener) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        JADNative jADNative;
        float feedShakeSensitivityValue;
        float feedShakeAngleValue;
        float feedShakeTimeValue;
        boolean z;
        JADNative jADNative2;
        this.mActivityRef = new WeakReference<>(activity);
        if (this.mAdViewController == null) {
            this.mAdViewController = new jad_n_er();
        }
        jad_n_er jad_n_erVar = this.mAdViewController;
        jad_n_erVar.getClass();
        jad_n_erVar.jad_n_ly = JADMediator.getInstance().getFoundationService().getApplication();
        jad_n_erVar.jad_n_mz = getActivity() != null ? getActivity().hashCode() : -1;
        jad_n_erVar.jad_n_an = this;
        jad_n_erVar.jad_n_fs = viewGroup;
        jad_n_erVar.jad_n_jt = list;
        jad_n_erVar.jad_n_bo = jADNativeInteractionListener;
        if (jADNativeInteractionListener != null) {
            jad_n_erVar.jad_n_cp(viewGroup);
            if (viewGroup != null && (jADNative2 = jad_n_erVar.jad_n_an) != null && jADNative2.getSlot() != null) {
                JADMediator.getInstance().getExposureService().registerExposureView(jad_n_erVar.jad_n_an.getInstanceId());
                if (jad_n_erVar.jad_n_an.getSlot().getEventInteractionType() == 1) {
                    JADMediator.getInstance().getExposureService().registerNativeExposureFeedShakeView(jad_n_erVar.jad_n_an.getInstanceId(), viewGroup);
                }
                JADMediator.getInstance().getExposureService().setViewExposureCallback(jad_n_erVar.jad_n_an.getInstanceId(), jad_n_erVar.jad_n_an.getSlot().getAdType(), viewGroup, new jad_n_hu(jad_n_erVar, viewGroup));
            }
            JADNative jADNative3 = jad_n_erVar.jad_n_an;
            if (jADNative3 == null || jADNative3.getSlot() == null) {
                return;
            }
            boolean z2 = jad_n_erVar.jad_n_an.getSlot().getAdType() == 4;
            try {
                for (View view : list) {
                    if (view != null) {
                        view.setOnClickListener(new jad_n_iv(jad_n_erVar, view, z2));
                        jad_n_erVar.jad_n_cp(view);
                    }
                }
            } catch (Exception e) {
                Logger.w(a.a("Exception while click:").append(e.getMessage()).toString(), new Object[0]);
            }
            if (jad_n_erVar.jad_n_an.getSlot().getAdType() == 1) {
                JADNative jADNative4 = jad_n_erVar.jad_n_an;
                if (jADNative4 != null) {
                    com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = new com.jd.ad.sdk.jad_n_an.jad_n_an(jADNative4);
                    if (jad_n_erVar.jad_n_an.getSlot() != null) {
                        jad_n_anVar.jad_n_an = jad_n_erVar.jad_n_an.getSlot().getSkipTime();
                    }
                    JADNativeInteractionListener jADNativeInteractionListener2 = jad_n_erVar.jad_n_bo;
                    if (jADNativeInteractionListener2 != null && (jADNativeInteractionListener2 instanceof JADNativeSplashInteractionListener)) {
                        jad_n_anVar.jad_n_cp = new WeakReference<>((JADNativeSplashInteractionListener) jADNativeInteractionListener2);
                        jad_n_anVar.jad_n_bo = new jad_n_jw(jad_n_erVar);
                    }
                    if (list2 != null && !list2.isEmpty()) {
                        for (View view2 : list2) {
                            if (view2 != null) {
                                jad_n_erVar.jad_n_cp(view2);
                                jad_n_anVar.jad_n_hu = view2;
                                view2.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_bo(jad_n_anVar));
                                View view3 = jad_n_anVar.jad_n_hu;
                                if (view3 != null && ViewCompat.isAttachedToWindow(view3)) {
                                    Logger.d("Native ad setSkipView startCount");
                                    jad_n_anVar.jad_n_an();
                                }
                                view2.setOnClickListener(new jad_n_kx(jad_n_erVar, jad_n_anVar));
                            }
                        }
                    }
                }
            } else if (list2 != null && !list2.isEmpty()) {
                for (View view4 : list2) {
                    if (view4 != null) {
                        try {
                            view4.setOnClickListener(new jad_n_ly(jad_n_erVar));
                        } catch (Exception e2) {
                            Logger.w(a.a("Exception while click:").append(e2.getMessage()).toString(), new Object[0]);
                        }
                        jad_n_erVar.jad_n_cp(view4);
                    }
                }
            }
            if (getSlot().getEventInteractionType() == 1 && jad_n_erVar.jad_n_fs != null && (jADNative = jad_n_erVar.jad_n_an) != null && jADNative.getSlot() != null) {
                if (jad_n_erVar.jad_n_an.getSlot().getAdType() == 1) {
                    feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getShakeSensitivityValue();
                    z = true;
                    feedShakeAngleValue = JADMediator.getInstance().getInitService().getShakeAngleValue();
                    feedShakeTimeValue = JADMediator.getInstance().getInitService().getShakeTimeValue();
                } else {
                    feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getFeedShakeSensitivityValue();
                    feedShakeAngleValue = JADMediator.getInstance().getInitService().getFeedShakeAngleValue();
                    feedShakeTimeValue = JADMediator.getInstance().getInitService().getFeedShakeTimeValue();
                    z = false;
                }
                jad_n_erVar.jad_n_jt();
                if (feedShakeSensitivityValue == 0.0f && feedShakeAngleValue == 0.0f) {
                    feedShakeSensitivityValue = 15.0f;
                }
                float f = feedShakeSensitivityValue;
                jad_n_fs jad_n_fsVar = new jad_n_fs(jad_n_erVar, jad_n_erVar.jad_n_fs.getContext(), f, feedShakeAngleValue, feedShakeTimeValue, z, f, feedShakeAngleValue, feedShakeTimeValue);
                jad_n_erVar.jad_n_kx = jad_n_fsVar;
                jad_n_fsVar.register();
            }
            if (getSlot().getEventInteractionType() == 2 && jad_n_erVar.jad_n_fs != null) {
                float[] fArr = {0.0f, 0.0f};
                float[] fArr2 = {0.0f, 0.0f};
                float swipeLength = JADMediator.getInstance().getInitService().getSwipeLength();
                float swipeAngle = JADMediator.getInstance().getInitService().getSwipeAngle();
                if (swipeLength <= 0.0f) {
                    swipeLength = 1.0f;
                }
                jad_n_erVar.jad_n_fs.setOnTouchListener(new jad_n_jt(jad_n_erVar, fArr, fArr2, swipeLength, swipeAngle <= 0.0f ? 45.0f : swipeAngle));
            }
        }
        jad_n_erVar.jad_n_hu = JADMediator.getInstance().getInitService().getDs(jad_n_erVar.jad_n_fs());
        jad_n_erVar.jad_n_iv = JADMediator.getInstance().getInitService().getR(jad_n_erVar.jad_n_fs());
        Application application = jad_n_erVar.jad_n_ly;
        if (application == null || -1 == jad_n_erVar.jad_n_mz || (activityLifecycleCallbacks = jad_n_erVar.jad_n_ob) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        jad_n_erVar.jad_n_ly.registerActivityLifecycleCallbacks(jad_n_erVar.jad_n_ob);
    }

    public void destroy() {
        jad_n_er jad_n_erVar = this.mAdViewController;
        if (jad_n_erVar != null) {
            jad_n_erVar.jad_n_an();
            this.mAdViewController = null;
        }
        List<JADMaterialData> list = this.mMaterialDataList;
        if (list != null && list.size() > 0) {
            this.mMaterialDataList.clear();
            this.mMaterialDataList = null;
        }
        if (this.mVideoReporter != null) {
            this.mVideoReporter = null;
        }
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    public IJADExtra getJADExtra() {
        if (this.mJADExtra == null) {
            this.mJADExtra = JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
        }
        return this.mJADExtra;
    }

    public JADVideoReporter getJADVideoReporter() {
        if (this.mVideoReporter == null) {
            this.mVideoReporter = new jad_n_dq(this.mSlot);
        }
        return this.mVideoReporter;
    }

    public void loadAd(JADNativeLoadListener jADNativeLoadListener) {
        this.mLoadListener = jADNativeLoadListener;
        String strUuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(strUuid, jADError.getCode(), getErin("", 0, jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        jADSlot.setRequestId(strUuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        if (this.mSlot.getAdType() == 0) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            JADError jADError2 = JADError.GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR;
            eventService2.reportRequestErrorEvent(strUuid, jADError2.getCode(), getErin(this.mSlot.getSlotID(), 0, jADError2.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        JADSlot jADSlot2 = this.mSlot;
        jADSlot2.setDisplayScene(getDisplayScene(jADSlot2.getAdType()));
        this.mSlot.setFromNativeAd(true);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, new jad_n_an());
    }
}

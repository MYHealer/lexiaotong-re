package com.jd.ad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADFeed implements IJADBase, JADAdLoadListener, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private com.jd.ad.sdk.feed.jad_f_bo mFeedAdRender;
    private String mInstanceId;
    private com.jd.ad.sdk.feed.jad_f_bo.jad_f_an mInteractionListener;
    private JADFeedListener mJADAdListener;
    private JADMaterialData mJADMaterialData;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private int srtp;
    private final int mSplashStylePlanType = 0;
    private final int mSplashClickAreaValue = 100;

    public class jad_f_an implements Runnable {
        public jad_f_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdCloseCallback();
        }
    }

    public class jad_f_bo implements ActLifecycle.OnLifecycleChangeListener {
        public jad_f_bo() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(Activity activity) {
            if (activity.hashCode() == JADFeed.this.mAttachActivityHashCode) {
                JADFeed.this.destroy();
            }
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityPaused(Activity activity) {
            if (activity.hashCode() != JADFeed.this.mAttachActivityHashCode || JADFeed.this.mFeedAdRender == null) {
                return;
            }
            JADFeed.this.mFeedAdRender.getClass();
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityResumed(Activity activity) {
            if (activity.hashCode() != JADFeed.this.mAttachActivityHashCode || JADFeed.this.mFeedAdRender == null) {
                return;
            }
            JADFeed.this.mFeedAdRender.getClass();
        }
    }

    public class jad_f_cp implements Runnable {
        public jad_f_cp() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.startRender();
        }
    }

    public class jad_f_dq implements com.jd.ad.sdk.feed.jad_f_bo.jad_f_an {
        public jad_f_dq() {
        }
    }

    public class jad_f_er implements Runnable {
        public jad_f_er() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdLoadCallback();
        }
    }

    public class jad_f_fs implements Runnable {
        public final /* synthetic */ int jad_f_an;
        public final /* synthetic */ String jad_f_bo;

        public jad_f_fs(int i, String str) {
            this.jad_f_an = i;
            this.jad_f_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdLoadFailedCallback(this.jad_f_an, this.jad_f_bo);
        }
    }

    public class jad_f_hu implements Runnable {
        public final /* synthetic */ int jad_f_an;
        public final /* synthetic */ String jad_f_bo;

        public jad_f_hu(int i, String str) {
            this.jad_f_an = i;
            this.jad_f_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdRenderFailedCallback(this.jad_f_an, this.jad_f_bo);
        }
    }

    public class jad_f_iv implements Runnable {
        public jad_f_iv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdClickCallback();
        }
    }

    public class jad_f_jt implements Runnable {
        public final /* synthetic */ View jad_f_an;

        public jad_f_jt(View view) {
            this.jad_f_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdRenderSucCallback(this.jad_f_an);
        }
    }

    public class jad_f_jw implements Runnable {
        public jad_f_jw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdShowedCallback();
        }
    }

    public JADFeed(Context context, JADSlot jADSlot) {
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
        initActLifeListener();
    }

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private String getAdTitle() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        this.mJADMaterialData = jADMaterialData;
        return jADMaterialData == null ? "" : jADMaterialData.getTitle();
    }

    private int getAdType() {
        return 2;
    }

    private int getDisplayScene() {
        return 64;
    }

    private List<String> getImageUrls() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        if (jADMaterialData == null) {
            return null;
        }
        return jADMaterialData.getImageUrls();
    }

    private String getMediaStyle() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        this.mJADMaterialData = jADMaterialData;
        return jADMaterialData == null ? "" : jADMaterialData.getMediaStyle();
    }

    private int getRenderMode() {
        return 1;
    }

    private void initInteractionListener() {
        this.mInteractionListener = new jad_f_dq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onLoadFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdRenderSucCallback(View view) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            JADFeedListener jADFeedListener = this.mJADAdListener;
            if (jADFeedListener != null) {
                jADFeedListener.onRenderSuccess(view);
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
        JADFeedListener jADFeedListener2 = this.mJADAdListener;
        if (jADFeedListener2 != null) {
            JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            jADFeedListener2.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_iv());
    }

    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_an());
    }

    public void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_f_fs(i, str));
    }

    public void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_er());
    }

    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_f_jt(view));
    }

    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_f_hu(i, str));
    }

    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_jw());
    }

    public String getErin(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final IJADExtra getExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    public JADMaterialData getJADMaterialData() {
        List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList != null && !jADMaterialDataList.isEmpty() && jADMaterialDataList.get(0) != null) {
            this.mJADMaterialData = jADMaterialDataList.get(0);
        }
        return this.mJADMaterialData;
    }

    public void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_f_cp());
    }

    public void onAdClickCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onClick();
        }
    }

    public void onAdCloseCallback() {
        Logger.d(a.a("seven_back=====onAdCloseCallback====TYPE=").append(getAdType()).toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onClose();
        }
        this.mJADAdListener = null;
    }

    public void onAdRenderFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onRenderFailure(i, str);
        }
    }

    public void onAdShowedCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onExposure();
        }
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
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        jADSlot.setRequestId(strUuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        float width = this.mSlot.getWidth();
        if (this.mSlot.getHeight() <= 0.0f) {
            this.mSlot.setHeight((width * 720.0f) / 1280.0f);
        }
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v50, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v57, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v47, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    public void startRender() {
        JADSlot jADSlot;
        ?? r3;
        int i;
        ?? templateId;
        this.mFeedAdRender = new com.jd.ad.sdk.feed.jad_f_bo(getAppContext(), this.mSlot, this.mInstanceId, getImageUrls(), getMediaStyle(), getAdTitle());
        initInteractionListener();
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.mFeedAdRender;
        jad_f_boVar.jad_f_kx = this.mInteractionListener;
        if (jad_f_boVar.jad_f_bo() == null || (jADSlot = jad_f_boVar.jad_f_bo) == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str = jad_f_boVar.jad_f_er;
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jADError.getMessage(new String[0]), jad_f_boVar.jad_f_fs);
            jad_f_boVar.jad_f_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        int templateId2 = jADSlot.getTemplateId();
        CommonConstants.AdTmp adTmp = CommonConstants.AdTmp.TEMPLATE_TEXT_ABOVE_IMAGE;
        if (templateId2 != adTmp.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_TEXT_ABOVE_IMAGE_WITH_CREATIVITY.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_TEXT_ABOVE_IMAGE_WITH_FLOAT.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_IMAGE_WITH_FLOAT.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_TEXT_RIGHT_IMAGE.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_TEXT_LEFT_IMAGE.getTemplateId() && templateId2 != CommonConstants.AdTmp.TEMPLATE_GROUP_IMAGE.getTemplateId()) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            String str2 = jad_f_boVar.jad_f_er;
            JADError jADError2 = JADError.RENDER_FEED_RESPONSE_TEMPLATE_ID_ERROR;
            eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_f_boVar.jad_f_fs);
            jad_f_boVar.jad_f_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        Context contextJad_f_bo = jad_f_boVar.jad_f_bo();
        View viewFindViewById = null;
        if (contextJad_f_bo == null || jad_f_boVar.jad_f_bo == null) {
            r3 = 0;
        } else {
            int iDip2px = (int) ScreenUtils.dip2px(contextJad_f_bo, 8.0f);
            int iDip2px2 = (int) ScreenUtils.dip2px(contextJad_f_bo, jad_f_boVar.jad_f_bo.getWidth());
            int iDip2px3 = (int) ScreenUtils.dip2px(contextJad_f_bo, jad_f_boVar.jad_f_bo.getHeight());
            int templateId3 = jad_f_boVar.jad_f_bo.getTemplateId();
            try {
                templateId = adTmp.getTemplateId();
                try {
                    if (templateId3 == templateId) {
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 1.78f);
                        }
                        View viewInflate = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp0", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams.width = iDip2px2;
                        layoutParams.height = iDip2px3;
                        viewInflate.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
                        viewInflate.setLayoutParams(layoutParams);
                        templateId = viewInflate;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_TEXT_ABOVE_IMAGE_WITH_CREATIVITY.getTemplateId()) {
                        View viewInflate2 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp1", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        View viewFindViewById2 = viewInflate2.findViewById(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_download", "id"));
                        if ("2".equals(jad_f_boVar.jad_f_jt)) {
                            viewFindViewById2.setVisibility(0);
                        } else {
                            viewFindViewById2.setVisibility(8);
                        }
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 1.78f);
                        }
                        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams2.width = iDip2px2;
                        layoutParams2.height = iDip2px3;
                        viewInflate2.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
                        viewInflate2.setLayoutParams(layoutParams2);
                        templateId = viewInflate2;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_TEXT_ABOVE_IMAGE_WITH_FLOAT.getTemplateId()) {
                        View viewInflate3 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp2", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 1.78f);
                        }
                        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams3.width = iDip2px2;
                        layoutParams3.height = iDip2px3;
                        viewInflate3.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
                        viewInflate3.setLayoutParams(layoutParams3);
                        templateId = viewInflate3;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_IMAGE_WITH_FLOAT.getTemplateId()) {
                        View viewInflate4 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp3", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 1.78f);
                        }
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams4.width = iDip2px2;
                        layoutParams4.height = iDip2px3;
                        viewInflate4.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
                        viewInflate4.setLayoutParams(layoutParams4);
                        templateId = viewInflate4;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_TEXT_RIGHT_IMAGE.getTemplateId()) {
                        View viewInflate5 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp4", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        View viewFindViewById3 = viewInflate5.findViewById(ResourceUtils.getResourceId(contextJad_f_bo, "jad_rl_ad_image", "id"));
                        ViewGroup.LayoutParams layoutParams5 = viewFindViewById3.getLayoutParams();
                        float f = iDip2px2;
                        float f2 = f * 0.43f;
                        float f3 = iDip2px3 == 0 ? f2 / 1.5f : iDip2px3 - (iDip2px * 2);
                        layoutParams5.width = (int) f2;
                        int i2 = (int) f3;
                        layoutParams5.height = i2;
                        viewFindViewById3.setLayoutParams(layoutParams5);
                        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-2, -2);
                        float f4 = iDip2px3 == 0 ? (iDip2px * 2) + i2 : iDip2px3;
                        layoutParams6.width = (int) f;
                        layoutParams6.height = (int) f4;
                        viewInflate5.setLayoutParams(layoutParams6);
                        templateId = viewInflate5;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_TEXT_LEFT_IMAGE.getTemplateId()) {
                        View viewInflate6 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp5", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        View viewFindViewById4 = viewInflate6.findViewById(ResourceUtils.getResourceId(contextJad_f_bo, "jad_rl_ad_image", "id"));
                        ViewGroup.LayoutParams layoutParams7 = viewFindViewById4.getLayoutParams();
                        float f5 = iDip2px2;
                        float f6 = f5 * 0.43f;
                        float f7 = iDip2px3 == 0 ? f6 / 1.5f : iDip2px3 - (iDip2px * 2);
                        layoutParams7.width = (int) f6;
                        int i3 = (int) f7;
                        layoutParams7.height = i3;
                        viewFindViewById4.setLayoutParams(layoutParams7);
                        ViewGroup.LayoutParams layoutParams8 = new ViewGroup.LayoutParams(-2, -2);
                        float f8 = iDip2px3 == 0 ? (iDip2px * 2) + i3 : iDip2px3;
                        layoutParams8.width = (int) f5;
                        layoutParams8.height = (int) f8;
                        viewInflate6.setLayoutParams(layoutParams8);
                        templateId = viewInflate6;
                    } else if (templateId3 == CommonConstants.AdTmp.TEMPLATE_GROUP_IMAGE.getTemplateId()) {
                        View viewInflate7 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp6", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 2.49f);
                        }
                        ViewGroup.LayoutParams layoutParams9 = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams9.width = iDip2px2;
                        layoutParams9.height = iDip2px3;
                        int iDip2px4 = (int) ScreenUtils.dip2px(contextJad_f_bo, 12.0f);
                        int iDip2px5 = (int) ScreenUtils.dip2px(contextJad_f_bo, 16.0f);
                        viewInflate7.setPadding(iDip2px4, iDip2px5, iDip2px4, iDip2px5);
                        viewInflate7.setLayoutParams(layoutParams9);
                        templateId = viewInflate7;
                    } else {
                        View viewInflate8 = LayoutInflater.from(contextJad_f_bo).inflate(ResourceUtils.getResourceId(contextJad_f_bo, "jad_feed_layout_tmp0", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        if (iDip2px3 == 0) {
                            iDip2px3 = (int) (iDip2px2 / 1.78f);
                        }
                        ViewGroup.LayoutParams layoutParams10 = new ViewGroup.LayoutParams(-2, -2);
                        layoutParams10.width = iDip2px2;
                        layoutParams10.height = iDip2px3;
                        viewInflate8.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
                        viewInflate8.setLayoutParams(layoutParams10);
                        templateId = viewInflate8;
                    }
                    ?? frameLayout = new FrameLayout(contextJad_f_bo);
                    ?? r0 = (ViewGroup) templateId.getParent();
                    if (r0 != 0) {
                        r0.removeView(templateId);
                    }
                    frameLayout.addView(templateId);
                    r3 = frameLayout;
                    if (r0 != 0) {
                        r0.addView(frameLayout);
                        r3 = frameLayout;
                    }
                } catch (Exception e) {
                    e = e;
                    Logger.w("Exception while render: " + e, new Object[0]);
                    r3 = templateId;
                }
            } catch (Exception e2) {
                e = e2;
                templateId = 0;
            }
        }
        jad_f_boVar.jad_f_iv = r3;
        if (r3 == 0) {
            JADEventService eventService3 = JADMediator.getInstance().getEventService();
            String str3 = jad_f_boVar.jad_f_er;
            JADError jADError3 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService3.reportRenderFailedEvent(str3, jADError3.getCode(), jADError3.getMessage(new String[0]), jad_f_boVar.jad_f_fs);
            jad_f_boVar.jad_f_an(jADError3.getCode(), jADError3.getMessage(new String[0]));
            return;
        }
        try {
            ((TextView) r3.findViewById(ResourceUtils.getResourceId(jad_f_boVar.jad_f_bo(), "jad_feed_title", "id"))).setText(jad_f_boVar.jad_f_hu);
        } catch (Exception e3) {
            Logger.w("Exception while render: " + e3, new Object[0]);
        }
        View view = jad_f_boVar.jad_f_iv;
        if (view != null && jad_f_boVar.jad_f_bo != null) {
            try {
                viewFindViewById = view.findViewById(ResourceUtils.getResourceId(jad_f_boVar.jad_f_bo(), "jad_feed_close", "id"));
                i = 0;
            } catch (Exception e4) {
                i = 0;
                Logger.w("Exception while render: " + e4, new Object[0]);
            }
            if (viewFindViewById != null) {
                if (jad_f_boVar.jad_f_bo.isHideClose()) {
                    viewFindViewById.setVisibility(8);
                } else {
                    viewFindViewById.setVisibility(i);
                    viewFindViewById.setOnClickListener(new com.jd.ad.sdk.jad_f_an.jad_f_cp(jad_f_boVar));
                }
            }
        }
        if (jad_f_boVar.jad_f_iv != null) {
            JADMediator.getInstance().getExposureService().registerExposureView(jad_f_boVar.jad_f_dq);
            JADMediator.getInstance().getExposureService().setViewExposureCallback(jad_f_boVar.jad_f_dq, 2, jad_f_boVar.jad_f_iv, new com.jd.ad.sdk.jad_f_an.jad_f_dq(jad_f_boVar));
        }
        View view2 = jad_f_boVar.jad_f_iv;
        if (view2 != null) {
            JADMediator.getInstance().getTouchService().registerTouchView(jad_f_boVar.jad_f_dq);
            view2.setClickable(true);
            view2.setOnTouchListener(new com.jd.ad.sdk.jad_f_an.jad_f_er(jad_f_boVar, view2));
            view2.setOnClickListener(new com.jd.ad.sdk.jad_f_an.jad_f_fs(jad_f_boVar, view2));
        }
        if (jad_f_boVar.jad_f_dq()) {
            if (jad_f_boVar.jad_f_bo() != null) {
                List<String> list = jad_f_boVar.jad_f_cp;
                if (list == null || list.size() != 3) {
                    JADEventService eventService4 = JADMediator.getInstance().getEventService();
                    String str4 = jad_f_boVar.jad_f_er;
                    JADError jADError4 = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                    eventService4.reportRenderFailedEvent(str4, jADError4.getCode(), jad_f_boVar.jad_f_bo(jADError4.getMessage(new String[0])), jad_f_boVar.jad_f_fs);
                    jad_f_boVar.jad_f_an(jADError4.getCode(), jADError4.getMessage(new String[0]));
                } else {
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        JADMediator.getInstance().getFoundationService().loadImage(jad_f_boVar.jad_f_bo(), list.get(i4), new com.jd.ad.sdk.jad_f_an.jad_f_an(jad_f_boVar, jad_f_boVar.jad_f_an("jad_feed_image" + i4), atomicInteger, size));
                    }
                }
            }
        } else if (jad_f_boVar.jad_f_bo() != null) {
            String strJad_f_cp = jad_f_boVar.jad_f_cp();
            if (strJad_f_cp == null || strJad_f_cp.isEmpty()) {
                JADEventService eventService5 = JADMediator.getInstance().getEventService();
                String str5 = jad_f_boVar.jad_f_er;
                JADError jADError5 = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                eventService5.reportRenderFailedEvent(str5, jADError5.getCode(), jad_f_boVar.jad_f_bo(jADError5.getMessage(new String[0])), jad_f_boVar.jad_f_fs);
                jad_f_boVar.jad_f_an(jADError5.getCode(), jADError5.getMessage(new String[0]));
            } else {
                JADMediator.getInstance().getFoundationService().loadImage(jad_f_boVar.jad_f_bo(), strJad_f_cp, new com.jd.ad.sdk.jad_f_an.jad_f_jw(jad_f_boVar, jad_f_boVar.jad_f_an("jad_feed_image")));
            }
        }
        View view3 = jad_f_boVar.jad_f_iv;
        if (view3 == null || jad_f_boVar.jad_f_jw != null) {
            return;
        }
        com.jd.ad.sdk.jad_f_an.jad_f_jt jad_f_jtVar = new com.jd.ad.sdk.jad_f_an.jad_f_jt(jad_f_boVar);
        jad_f_boVar.jad_f_jw = jad_f_jtVar;
        view3.addOnAttachStateChangeListener(jad_f_jtVar);
    }

    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_f_bo jad_f_boVar = new jad_f_bo();
            this.mLifeChangeListener = jad_f_boVar;
            ActLifecycle.addLifecycleListener(jad_f_boVar);
        }
    }

    public void destroy() {
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.mFeedAdRender;
        if (jad_f_boVar != null) {
            jad_f_boVar.jad_f_an();
            this.mFeedAdRender = null;
        }
        this.mJADAdListener = null;
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

    public void loadAd(JADFeedListener jADFeedListener) {
        this.mJADAdListener = jADFeedListener;
        String strUuid = UUIDUtils.uuid();
        if (this.mSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(strUuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
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

    public void removeFeedView() {
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.mFeedAdRender;
        if (jad_f_boVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_f_an.jad_f_bo(jad_f_boVar));
        }
    }

    public void reportClickEvent(int i) {
        JADSlot jADSlot;
        if (i == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, clickTime, clickTime2, clickTime3, 0, 100, this.mSlot.getEventInteractionType(), 0, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, clickTime, clickTime2, clickTime3, 0, 100, this.mSlot.getEventInteractionType(), 0, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        }
    }

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
            JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), -1, clickTime, clickTime2, clickTime3, 0, 100, i, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), -1, clickTime, clickTime2, clickTime3, 0, 100, i, this.dstp, this.srtp);
        }
    }

    public void reportDelayExposureEvent(String str, int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(0);
        this.mSlot.setScav(100);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, delayShowTime, delayShowTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, delayShowTime, delayShowTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        }
    }

    public void reportExposureEvent(String str, int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(0);
        this.mSlot.setScav(100);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, showTime, showTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, showTime, showTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        }
    }

    public void reportRenderSuccessEvent() {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), renderSucTime, 0L, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), renderSucTime, 0L, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }
}

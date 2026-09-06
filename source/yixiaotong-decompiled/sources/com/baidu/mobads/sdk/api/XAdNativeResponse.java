package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.al;
import com.baidu.mobads.sdk.internal.at;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.mobads.sdk.internal.r;
import com.cdo.oaps.ad.OapsKey;
import com.qq.e.comm.pi.IReward;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdCloseListener mAdCloseListener;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private NativeResponse.AdEventListener mAdEventListener;
    private a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private NativeResponse.AdShakeViewListener mAdShakeViewListener;
    private NativeResponse.AdShakeViewListener mCouponFloatViewListener;
    private NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    private Context mCxt;
    private NativeResponse.AdShakeViewListener mECommerceViewListener;
    private dg mFeedsProd;
    private String mNoAdUniqueId;
    private cs mUriUtils;

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.api.XAdNativeResponse$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    public NativeResponse.AdCloseListener getAdCloseListener() {
        return this.mAdCloseListener;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    public void setAdActionType(int i) {
        this.mAdActionType = i;
    }

    public void setAdCloseListener(NativeResponse.AdCloseListener adCloseListener) {
        this.mAdCloseListener = adCloseListener;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdEventListener(NativeResponse.AdEventListener adEventListener) {
        this.mAdEventListener = adEventListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.isDownloadApp = z;
    }

    public void setNoAdUniqueId(String str) {
        this.mNoAdUniqueId = str;
    }

    public XAdNativeResponse(Context context, dg dgVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = dgVar;
        if (aVar != null && aVar.q() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cs.a();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.a() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        String strC = aVar.c();
        return TextUtils.isEmpty(strC) ? this.mAdInstanceInfo.d() : strC;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put(OapsKey.KEY_PAGEKEY, getAppPackage());
            jSONObjectY.put("msg", "pauseDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put(OapsKey.KEY_PAGEKEY, getAppPackage());
            jSONObjectY.put("msg", "cancelDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        if (!this.isDownloadApp || this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject jSONObjectY = aVar.Y();
        try {
            jSONObjectY.put("msg", "resumeDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        Context context;
        if (!this.isDownloadApp || (context = this.mCxt) == null) {
            return -1;
        }
        return at.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(StubApp.getOrigApplicationContext(this.mCxt.getApplicationContext()), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isReady(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.z() <= this.mAdInstanceInfo.K();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.z() <= this.mAdInstanceInfo.K();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null && aVar.k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null || aVar.l() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.L();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap map = new HashMap();
        dg dgVar = this.mFeedsProd;
        if (dgVar != null) {
            map.put("appsid", dgVar.q);
        }
        return map;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        dg dgVar = this.mFeedsProd;
        if (dgVar != null) {
            dgVar.o();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null || !(dislikeEvent instanceof DislikeInfo)) {
            return;
        }
        JSONObject jSONObjectY = aVar.Y();
        try {
            jSONObjectY.put("dislike_type", dislikeEvent.getDislikeType());
            jSONObjectY.put("msg", "dislike_click");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap map = new HashMap();
                JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
                jSONObjectY.put("msg", "dislike_mapping");
                this.mFeedsProd.a(jSONObjectY, map);
                Object obj = map.get("dislike_data");
                if (obj instanceof Map) {
                    Map map2 = (Map) obj;
                    for (String str : map2.keySet()) {
                        DislikeInfo dislikeInfo = new DislikeInfo(null);
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((Integer) map2.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private static class DislikeInfo implements DislikeEvent {
        private String dislikeName;
        private int dislikeType;

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }

        private DislikeInfo() {
        }

        /* synthetic */ DislikeInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String strJ = aVar.J();
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put("permissionUrl", strJ);
            jSONObjectY.put("msg", "permissionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String strH = aVar.H();
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put("privacy_link", strH);
            jSONObjectY.put("msg", "privacyClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String strI = aVar.I();
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put("function_link", strI);
            jSONObjectY.put("msg", "functionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        if (this.mFeedsProd == null || this.mUriUtils == null) {
            return;
        }
        JSONObject jSONObjectY = this.mAdInstanceInfo.Y();
        try {
            jSONObjectY.put("unionUrl", "https://union.baidu.com/");
            jSONObjectY.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        a aVar;
        dg dgVar = this.mFeedsProd;
        if (dgVar == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        dgVar.a(view, aVar.Y());
    }

    public void onAdClose(NativeResponse nativeResponse) {
        NativeResponse.AdCloseListener adCloseListener = this.mAdCloseListener;
        if (adCloseListener != null) {
            adCloseListener.onAdClose(nativeResponse);
        }
    }

    public void onDislikeShow() {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowShow();
        }
    }

    public void onDislikeClick(String str) {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeItemClick(str);
        }
    }

    public void onDislikeClose() {
        NativeResponse.AdDislikeListener adDislikeListener = this.mAdDislikeListener;
        if (adDislikeListener != null) {
            adDislikeListener.onDislikeWindowClose();
        }
    }

    void handleClick(View view) {
        handleClick(view, -1);
    }

    void handleClick(View view, int i) {
        handleClick(view, i, false);
    }

    void handleClick(View view, boolean z) {
        handleClick(view, -1, z);
    }

    void handleClick(View view, int i, boolean z) {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject jSONObjectY = aVar.Y();
        try {
            jSONObjectY.put("progress", i);
            jSONObjectY.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
            jSONObjectY.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.b(view, jSONObjectY);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.G() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.H() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.J() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.F() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.Q() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return "";
        }
        JSONObject jSONObjectY = aVar.Y();
        try {
            jSONObjectY.put("msg", "creative_call");
            jSONObjectY.put("creative_type", "cta_get");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
        return this.mAdInstanceInfo.R();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.x();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL;
        }
        if ("video".equals(aVar.y())) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if ("live".equals(this.mAdInstanceInfo.y())) {
            return NativeResponse.MaterialType.LIVE;
        }
        if (a.f.equals(this.mAdInstanceInfo.y())) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.p() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        dg dgVar = this.mFeedsProd;
        if (dgVar != null) {
            return (WebView) dgVar.w();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        if ("video".equals(aVar.y())) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if ("live".equals(this.mAdInstanceInfo.y())) {
            return NativeResponse.MaterialType.LIVE.getValue();
        }
        if (a.f.equals(this.mAdInstanceInfo.y())) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    private int getActionType() {
        return this.mAdInstanceInfo.q();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getRewardTime() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.C();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getRewardText() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPECPM() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAuthorName() {
        a aVar = this.mAdInstanceInfo;
        return (aVar == null || TextUtils.isEmpty(aVar.E())) ? "" : "@" + this.mAdInstanceInfo.E();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dg dgVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (dgVar = this.mFeedsProd) == null) {
            return;
        }
        dgVar.a(aVar.M(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        if (this.mFeedsProd != null) {
            String strM = this.mNoAdUniqueId;
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                strM = aVar.M();
            }
            this.mFeedsProd.a(strM, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        registerViewForInteraction(view, list, list2, null, adInteractionListener);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, Map<String, List<View>> map, NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap map2 = new HashMap();
                map2.put(IReward.AD_VIEW, view);
                map2.put("clickViews", list);
                map2.put("creativeViews", list2);
                map2.put("extraViews", map);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, map2);
            } catch (Throwable th) {
                bv.a().c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", "renderShakeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get("shake_view");
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderShakeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public ShakeViewContainer renderShakeViewContainer() {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msg", "renderShakeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, 80);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, 80);
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            jSONObject.put("isContainer", "1");
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get("shake_view");
            Object obj2 = map.get("shake_controller");
            if ((obj instanceof RelativeLayout) && (obj2 instanceof IOAdEventListener)) {
                return new al((RelativeLayout) obj, (IOAdEventListener) obj2);
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderShakeView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i, int i2, int i3, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mAdShakeViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
            jSONObject.put("repeat", i3);
            return renderNativeView("native_slide_view", jSONObject);
        } catch (Throwable th) {
            bv.a().c(TAG, "renderSlideView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderFlipPageView() {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            return renderNativeView("native_coupon_flip_page", new JSONObject());
        } catch (Throwable th) {
            bv.a().c(TAG, "renderFlipPageView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderCouponFloatView(NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mCouponFloatViewListener = adShakeViewListener;
            return renderNativeView("native_coupon_float_icon", new JSONObject());
        } catch (Throwable th) {
            bv.a().c(TAG, "renderCouponFloatView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderBulletView(int i, int i2) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
            return renderNativeView("native_bullet_view", jSONObject);
        } catch (Throwable th) {
            bv.a().c(TAG, "renderBulletView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderECommerceView(NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mECommerceViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", "native_e_commerce_view");
            jSONObject.put("msg", "renderECommerceView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get("native_e_commerce_view");
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderECommerceView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderECommerceView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            this.mECommerceViewListener = adShakeViewListener;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", "native_e_commerce_view");
            jSONObject.put("msg", "renderECommerceView");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get("native_e_commerce_view");
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderECommerceView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShopCouponMagneticStickerView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        if (this.mFeedsProd == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewId", "native_magnetic_patch");
            jSONObject.put("msg", "renderShopCouponMagneticStickerView");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, i2);
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get("native_magnetic_patch");
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderShopCouponMagneticStickerView failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShopCouponMagneticStickerView(int i, int i2) {
        return renderShopCouponMagneticStickerView(i, i2, null);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.g() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        a aVar;
        if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.X() == 1) {
            this.mCustomizeMediaPlayer = new r(this.mFeedsProd, this.mAdInstanceInfo);
        }
        return this.mCustomizeMediaPlayer;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(View view) {
        if (this.mFeedsProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                HashMap map = new HashMap();
                map.put("native_view", view);
                this.mFeedsProd.a(jSONObject, map);
            } catch (Throwable th) {
                bv.a().c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Object getAdDataForKey(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.mAdInstanceInfo.Z();
        }
        if ("dp_id".equals(str)) {
            return this.mAdInstanceInfo.aa();
        }
        if ("ecafd_bind".equals(str)) {
            return Integer.valueOf(this.mAdInstanceInfo.ab());
        }
        if ("ecafd_order".equals(str)) {
            return Integer.valueOf(this.mAdInstanceInfo.ac());
        }
        return this.mAdInstanceInfo.a(str);
    }

    public JSONObject getExtraParams() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.N();
        }
        return null;
    }

    public void preloadVideoMaterial() {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject jSONObjectY = aVar.Y();
        try {
            jSONObjectY.put("msg", "preloadVideoMaterial");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(jSONObjectY);
    }

    public String getUniqueId() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.M() : "";
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i);
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onADPermissionShow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onAdDownloadWindow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z) {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
        } else {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onShakeViewDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mAdShakeViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onCouponFloatDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mCouponFloatViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onECommerceDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener = this.mECommerceViewListener;
        if (adShakeViewListener != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void onAdEvent(int i, Map<String, Object> map) {
        if (i == 1) {
            NativeResponse.AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.onAdEvent(i, map);
                return;
            }
            return;
        }
        if (i != 2 || this.mAdInteractionListener == null || map == null) {
            return;
        }
        String str = map.get("reward_type") instanceof String ? (String) map.get("reward_type") : "";
        int iIntValue = map.get("reward_remaining_time_s") instanceof Integer ? ((Integer) map.get("reward_remaining_time_s")).intValue() : 0;
        if (TextUtils.equals("1", str)) {
            this.mAdInteractionListener.adActRewardSuccess();
        } else if (TextUtils.equals(str, "0")) {
            this.mAdInteractionListener.adActReward(iIntValue);
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public String getMarketingICONUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.O() : "";
    }

    public String getMarketingDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.P() : "";
    }

    public int getBtnStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.S();
        }
        return 0;
    }

    public List<String> getBtnStyleColors() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.T();
        }
        return null;
    }

    private IAdInterListener getAdInterListener() {
        dg dgVar = this.mFeedsProd;
        if (dgVar != null) {
            return dgVar.m;
        }
        return null;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObjectU = this.mAdInstanceInfo.U();
            if (jSONObjectU != null) {
                Iterator<String> itKeys = jSONObjectU.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.equals(str)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectU.optJSONArray(next);
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    View renderNativeView(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            HashMap map = new HashMap();
            this.mFeedsProd.a(jSONObject, map);
            Object obj = map.get(str);
            if (obj instanceof View) {
                return (View) obj;
            }
            return null;
        } catch (Throwable th) {
            bv.a().c(TAG, "renderNativeView failed: " + th.getMessage());
            return null;
        }
    }

    void renderNativeView(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            jSONObject.put("viewId", str);
            jSONObject.put("msg", "renderNativeView");
            jSONObject.put("uniqueId", getUniqueId());
            jSONObject.put("isDownloadApp", this.isDownloadApp);
            this.mFeedsProd.a(jSONObject, map);
        } catch (Throwable th) {
            bv.a().c(TAG, "renderNativeView failed: " + th.getMessage());
        }
    }

    public int isRegionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.V();
        }
        return 2;
    }

    public int isShowDialog() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.W();
        }
        return 2;
    }

    private String getProd() {
        dg dgVar = this.mFeedsProd;
        return dgVar != null ? dgVar.e() : "";
    }
}

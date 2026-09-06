package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.DislikeEvent;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.BaiduMobAds.R;
import com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduNativeAd extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XAdNativeResponse f3011a;
    private boolean b;
    private MediationAdSlotValueSet c;
    private WeakReference<Context> d;
    private BaiduNativeLoader e;
    private boolean f;
    private String g;
    private String h;

    /* JADX WARN: Code duplicated, block: B:24:0x015a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0164  */
    public BaiduNativeAd(Context context, XAdNativeResponse xAdNativeResponse, BaiduNativeLoader baiduNativeLoader, Function<SparseArray<Object>, Object> function, MediationAdSlotValueSet mediationAdSlotValueSet) {
        double dDoubleValue;
        int i;
        Object objValueOf;
        int i2;
        int iValueOf;
        super(baiduNativeLoader, function);
        this.b = false;
        this.f = false;
        this.g = "key_baidu_native_eCommerce_container";
        this.h = "key_baidu_native_magic_sticker_container";
        this.e = baiduNativeLoader;
        this.d = new WeakReference<>(context);
        this.f3011a = xAdNativeResponse;
        this.c = mediationAdSlotValueSet;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8045, xAdNativeResponse.getTitle());
        sparseArray.put(8046, xAdNativeResponse.getDesc());
        sparseArray.put(8047, Integer.valueOf((int) xAdNativeResponse.getAppSize()));
        sparseArray.put(8048, xAdNativeResponse.getIconUrl());
        sparseArray.put(8049, xAdNativeResponse.getBrandName());
        sparseArray.put(8050, xAdNativeResponse.getImageUrl());
        sparseArray.put(8051, Integer.valueOf(xAdNativeResponse.getMainPicHeight()));
        sparseArray.put(8052, Integer.valueOf(xAdNativeResponse.getMainPicWidth()));
        sparseArray.put(8053, xAdNativeResponse.getMultiPicUrls());
        sparseArray.put(8054, xAdNativeResponse.getAppPackage());
        sparseArray.put(8055, Boolean.valueOf(BaiduAdapterUtil.isDownloadAd(xAdNativeResponse)));
        sparseArray.put(8056, xAdNativeResponse.getBrandName());
        sparseArray.put(8057, xAdNativeResponse.getPublisher());
        sparseArray.put(8079, xAdNativeResponse.getAppPermissionLink());
        sparseArray.put(8080, xAdNativeResponse.getAppPrivacyLink());
        try {
            MediationApiLog.i("app_function_link : " + xAdNativeResponse.getAppFunctionLink());
            sparseArray.put(8551, xAdNativeResponse.getAppFunctionLink());
        } catch (Throwable unused) {
        }
        sparseArray.put(8078, Long.valueOf(xAdNativeResponse.getAppSize()));
        sparseArray.put(8061, a());
        List<DislikeEvent> dislikeList = xAdNativeResponse.getDislikeList();
        if (dislikeList != null && dislikeList.size() > 0) {
            sparseArray.put(8036, dislikeList);
        }
        if (!baiduNativeLoader.isClientBidding()) {
            if (baiduNativeLoader.isMultiBidding()) {
                i = 8058;
                objValueOf = xAdNativeResponse.getECPMLevel();
            }
            sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType())));
            sparseArray.put(8033, false);
            if (xAdNativeResponse.getMultiPicUrls() != null || xAdNativeResponse.getMultiPicUrls().size() != 3) {
                if (TextUtils.isEmpty(xAdNativeResponse.getVideoUrl()) || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.LIVE) {
                    i2 = 5;
                } else {
                    iValueOf = 3;
                }
                sparseArray.put(8060, iValueOf);
                notifyNativeValue(sparseArray);
            }
            i2 = 4;
            iValueOf = Integer.valueOf(i2);
            sparseArray.put(8060, iValueOf);
            notifyNativeValue(sparseArray);
        }
        try {
            dDoubleValue = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
        } catch (Exception unused2) {
            dDoubleValue = 0.0d;
        }
        i = 8016;
        objValueOf = Double.valueOf(dDoubleValue);
        sparseArray.put(i, objValueOf);
        sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType())));
        sparseArray.put(8033, false);
        if (xAdNativeResponse.getMultiPicUrls() != null) {
            if (TextUtils.isEmpty(xAdNativeResponse.getVideoUrl())) {
            }
            i2 = 5;
            iValueOf = Integer.valueOf(i2);
        } else {
            if (TextUtils.isEmpty(xAdNativeResponse.getVideoUrl())) {
            }
            i2 = 5;
            iValueOf = Integer.valueOf(i2);
        }
        sparseArray.put(8060, iValueOf);
        notifyNativeValue(sparseArray);
    }

    private XNativeView a(Context context) {
        if (context == null) {
            return null;
        }
        final XNativeView xNativeView = new XNativeView(context);
        xNativeView.setNativeItem(this.f3011a);
        xNativeView.setVideoMute(this.c.isMuted());
        xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.5
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
                BaiduNativeAd.this.notifyOnVideoComplete();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
                BaiduNativeAd.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "baidu setNativeVideoListener onError");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
                BaiduNativeAd.this.notifyOnVideoPause();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                BaiduNativeAd.this.notifyOnVideoStart();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                BaiduNativeAd.this.notifyOnVideoResume();
            }
        });
        xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.6
            @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
            public void onNativeViewClick(XNativeView xNativeView2) {
            }
        });
        if (xNativeView.getViewTreeObserver() != null) {
            xNativeView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.7
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (xNativeView.getVisibility() == 0) {
                        xNativeView.render();
                        if (xNativeView.getViewTreeObserver() != null) {
                            xNativeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                    }
                }
            });
        }
        return xNativeView;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
    private String a() {
        String str;
        XAdNativeResponse xAdNativeResponse = this.f3011a;
        String str2 = "";
        if (xAdNativeResponse == null) {
            return "";
        }
        int downloadStatus = xAdNativeResponse.getDownloadStatus();
        if (downloadStatus >= 0) {
            if (downloadStatus < 101) {
                if (this.f3011a.getAdActionType() == 2) {
                    str2 = "立即下载";
                } else {
                    str = "查看详情";
                }
            } else if (downloadStatus == 101) {
                if (this.f3011a.getAdActionType() == 2) {
                    str = "点击安装";
                } else {
                    str2 = "去看看";
                }
            }
            str2 = str;
        } else if (this.f3011a.getAdActionType() == 2) {
            str2 = "立即下载";
        } else {
            str2 = "去看看";
        }
        String actButtonString = this.f3011a.getActButtonString();
        return !TextUtils.isEmpty(actButtonString) ? actButtonString : str2;
    }

    private void a(Context context, ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        FrameLayout frameLayout;
        XNativeView xNativeViewA;
        int shakeViewHeight;
        ViewGroup viewGroup2;
        if (viewGroup == null || mediationViewBinder == null) {
            return;
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        a(viewGroup, mediationViewBinder);
        b(viewGroup, mediationViewBinder);
        c(viewGroup, mediationViewBinder);
        View viewFindViewById = viewGroup.findViewById(mediationViewBinder.logoLayoutId);
        if (viewFindViewById instanceof ViewGroup) {
            viewFindViewById.setVisibility(0);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 15.0f), BaiduAdapterUtil.dp2px(context, 15.0f)));
            linearLayout.addView(imageView);
            ImageView imageView2 = new ImageView(context);
            imageView2.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 25.0f), BaiduAdapterUtil.dp2px(context, 13.0f)));
            linearLayout.addView(imageView2);
            new DownloadImageTask(imageView).execute(this.f3011a.getBaiduLogoUrl());
            new DownloadImageTask(imageView2).execute(this.f3011a.getAdLogoUrl());
            ViewGroup viewGroup3 = (ViewGroup) viewFindViewById;
            viewGroup3.removeAllViews();
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = BaiduAdapterUtil.dp2px(context, 38.0f);
            layoutParams.height = BaiduAdapterUtil.dp2px(context, 13.0f);
            viewFindViewById.setLayoutParams(layoutParams);
            viewGroup3.addView(linearLayout, -1, -1);
        }
        try {
            MediationAdSlotValueSet mediationAdSlotValueSet = this.c;
            int shakeViewWidth = 80;
            if (mediationAdSlotValueSet != null) {
                shakeViewWidth = mediationAdSlotValueSet.getShakeViewWidth() > 0.0f ? (int) this.c.getShakeViewWidth() : 80;
                shakeViewHeight = this.c.getShakeViewHeight() > 0.0f ? (int) this.c.getShakeViewHeight() : 80;
            } else {
                shakeViewHeight = 80;
            }
            View viewRenderShakeView = this.f3011a.renderShakeView(shakeViewWidth, shakeViewHeight, new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.4
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                public void onDismiss() {
                    try {
                        BaiduNativeAd.this.shakeViewDismissed();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            if (viewRenderShakeView != null && (viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.shakeViewContainerId)) != null) {
                viewGroup2.removeView(viewRenderShakeView);
                removeSelfFromParent(viewRenderShakeView);
                viewGroup2.addView(viewRenderShakeView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if ((!isUseCustomVideo() || TextUtils.isEmpty(this.f3011a.getVideoUrl())) && (frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId)) != null && getImageMode() == 5 && (xNativeViewA = a(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(xNativeViewA, -1, -1);
            xNativeViewA.render();
        }
    }

    private void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
        if (this.f3011a == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        if (mediationViewBinder != null) {
            a(context, viewGroup, mediationViewBinder);
        }
        b(viewGroup, context);
        this.f3011a.registerViewForInteraction(viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.8
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BaiduNativeAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BaiduNativeAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private void a(final ViewGroup viewGroup) {
        WeakReference<Context> weakReference;
        try {
            if (this.f3011a != null && (viewGroup instanceof FrameLayout) && !this.f && BaiduAdapterUtil.currentSdkVerGreaterThanOrEqual(BaiduAdapterUtil.VERSION_9_42)) {
                ViewGroup.LayoutParams layoutParamsC = c();
                if (layoutParamsC == null) {
                    MediationApiLog.e("Tme", "eCommerceLayoutParams is null");
                    return;
                }
                MediationApiLog.i("Tme", "eCommerceLayoutParams:" + layoutParamsC);
                View viewRenderECommerceView = this.f3011a.renderECommerceView(new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.2
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                    public void onDismiss() {
                        MediationApiLog.i("Tme", "ECommerceFloatView onDismiss()");
                        BaiduNativeAd.this.f = true;
                        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewWithTag(BaiduNativeAd.this.g);
                        if (frameLayout != null) {
                            frameLayout.setVisibility(8);
                        }
                    }
                });
                if (viewRenderECommerceView == null || (weakReference = this.d) == null || weakReference.get() == null) {
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewWithTag(this.g);
                if (frameLayout == null) {
                    frameLayout = new FrameLayout(this.d.get());
                    frameLayout.setTag(this.g);
                    viewGroup.addView(frameLayout, layoutParamsC);
                } else {
                    frameLayout.removeAllViews();
                }
                frameLayout.setVisibility(0);
                removeSelfFromParent(viewRenderECommerceView);
                frameLayout.addView(viewRenderECommerceView);
                MediationApiLog.i("Tme", "showECommerceView addView");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(final ViewGroup viewGroup, Context context) {
        try {
            if (this.f3011a != null && (viewGroup instanceof FrameLayout) && BaiduAdapterUtil.currentSdkVerGreaterThanOrEqual(BaiduAdapterUtil.VERSION_9_43)) {
                ViewGroup.LayoutParams layoutParamsD = d();
                if (layoutParamsD == null) {
                    MediationApiLog.e("Tme", "stickerLayoutParams is null");
                    return;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 81;
                MediationApiLog.i("Tme", "eCommerceLayoutParams:" + layoutParamsD);
                View viewRenderShopCouponMagneticStickerView = this.f3011a.renderShopCouponMagneticStickerView(layoutParamsD.width, layoutParamsD.height, new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.3
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                    public void onDismiss() {
                        MediationApiLog.i("Tme", "stickerLayout onDismiss()");
                        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewWithTag(BaiduNativeAd.this.h);
                        if (frameLayout != null) {
                            frameLayout.setVisibility(8);
                        }
                    }
                });
                if (viewRenderShopCouponMagneticStickerView != null) {
                    if (context == null) {
                        context = viewGroup.getContext();
                    }
                    FrameLayout frameLayout = (FrameLayout) viewGroup.findViewWithTag(this.h);
                    if (frameLayout != null || context == null) {
                        frameLayout.removeAllViews();
                    } else {
                        frameLayout = new FrameLayout(context);
                        frameLayout.setTag(this.h);
                        viewGroup.addView(frameLayout, layoutParams);
                    }
                    frameLayout.setVisibility(0);
                    removeSelfFromParent(viewRenderShopCouponMagneticStickerView);
                    frameLayout.addView(viewRenderShopCouponMagneticStickerView);
                    MediationApiLog.i("Tme", "showMagicStickerView addView");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void a(ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        try {
            if (this.f3011a != null && mediationViewBinder != null) {
                if (!(viewGroup instanceof FrameLayout) || !BaiduAdapterUtil.currentSdkVerGreaterThanOrEqual(BaiduAdapterUtil.VERSION_9_35)) {
                    return;
                }
                if (mediationViewBinder.extras != null && mediationViewBinder.extras.get("key_baidu_native_coupon_container_id") != null) {
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.extras.get("key_baidu_native_coupon_container_id").intValue());
                    if (viewGroup2 == null) {
                        return;
                    }
                    viewGroup2.removeAllViews();
                    viewGroup2.setVisibility(0);
                    View viewRenderCouponFloatView = this.f3011a.renderCouponFloatView(new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.1
                        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                        public void onDismiss() {
                            MediationApiLog.i("Tme", "CouponFloatView onDismiss()");
                        }
                    });
                    if (viewRenderCouponFloatView != null) {
                        removeSelfFromParent(viewRenderCouponFloatView);
                        ViewGroup.LayoutParams layoutParamsB = b();
                        MediationApiLog.i("Tme", "couponLayoutParams:" + layoutParamsB);
                        MediationApiLog.i("Tme", "couponFloatContainer:" + viewGroup2);
                        if (layoutParamsB == null) {
                            viewGroup2.addView(viewRenderCouponFloatView);
                        } else {
                            viewGroup2.addView(viewRenderCouponFloatView, layoutParamsB);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private ViewGroup.LayoutParams b() {
        BaiduNativeLoader baiduNativeLoader = this.e;
        if (baiduNativeLoader == null) {
            return null;
        }
        Object nativeCouponParams = baiduNativeLoader.getNativeCouponParams();
        if (nativeCouponParams instanceof ViewGroup.LayoutParams) {
            return (ViewGroup.LayoutParams) nativeCouponParams;
        }
        return null;
    }

    private void b(ViewGroup viewGroup, Context context) {
        a(viewGroup);
        a(viewGroup, context);
    }

    private void b(ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        try {
            if (this.f3011a != null && mediationViewBinder != null) {
                if (!(viewGroup instanceof FrameLayout) || !BaiduAdapterUtil.currentSdkVerGreaterThanOrEqual(BaiduAdapterUtil.VERSION_9_35)) {
                    return;
                }
                if (mediationViewBinder.extras != null && mediationViewBinder.extras.get("key_baidu_native_flippage_container_id") != null) {
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.extras.get("key_baidu_native_flippage_container_id").intValue());
                    if (viewGroup2 == null) {
                        return;
                    }
                    viewGroup2.removeAllViews();
                    viewGroup2.setVisibility(0);
                    View viewRenderFlipPageView = this.f3011a.renderFlipPageView();
                    if (viewRenderFlipPageView != null) {
                        removeSelfFromParent(viewRenderFlipPageView);
                        ViewGroup.LayoutParams layoutParamsE = e();
                        MediationApiLog.i("Tme", "flipPageLayoutParams:" + layoutParamsE);
                        MediationApiLog.i("Tme", "flipPageContainer:" + viewGroup2);
                        if (layoutParamsE == null) {
                            viewGroup2.addView(viewRenderFlipPageView);
                        } else {
                            viewGroup2.addView(viewRenderFlipPageView, layoutParamsE);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private ViewGroup.LayoutParams c() {
        BaiduNativeLoader baiduNativeLoader = this.e;
        if (baiduNativeLoader == null) {
            return null;
        }
        Object nativeECommerceParams = baiduNativeLoader.getNativeECommerceParams();
        if (nativeECommerceParams instanceof ViewGroup.LayoutParams) {
            return (ViewGroup.LayoutParams) nativeECommerceParams;
        }
        return null;
    }

    private void c(ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        ViewGroup viewGroup2;
        try {
            if (this.f3011a == null || mediationViewBinder == null || !BaiduAdapterUtil.currentSdkVerGreaterThanOrEqual(BaiduAdapterUtil.VERSION_9_37) || mediationViewBinder.extras == null || mediationViewBinder.extras.get("key_baidu_native_bullet_container_id") == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.extras.get("key_baidu_native_bullet_container_id").intValue())) == null) {
                return;
            }
            viewGroup2.removeAllViews();
            viewGroup2.setVisibility(0);
            int iG = g();
            int iF = f();
            if (iG <= 0) {
                iG = -1;
            }
            if (iF <= 0) {
                iF = -2;
            }
            View viewRenderBulletView = this.f3011a.renderBulletView(iG, iF);
            if (viewRenderBulletView != null) {
                removeSelfFromParent(viewRenderBulletView);
                viewGroup2.addView(viewRenderBulletView);
            }
        } catch (Throwable unused) {
        }
    }

    private ViewGroup.LayoutParams d() {
        BaiduNativeLoader baiduNativeLoader = this.e;
        if (baiduNativeLoader == null) {
            return null;
        }
        Object magicStickerParams = baiduNativeLoader.getMagicStickerParams();
        if (magicStickerParams instanceof ViewGroup.LayoutParams) {
            return (ViewGroup.LayoutParams) magicStickerParams;
        }
        return null;
    }

    private ViewGroup.LayoutParams e() {
        BaiduNativeLoader baiduNativeLoader = this.e;
        if (baiduNativeLoader == null) {
            return null;
        }
        Object nativeFlipPageParams = baiduNativeLoader.getNativeFlipPageParams();
        if (nativeFlipPageParams instanceof ViewGroup.LayoutParams) {
            return (ViewGroup.LayoutParams) nativeFlipPageParams;
        }
        return null;
    }

    private int f() {
        Object slotExtraObject = this.e.getSlotExtraObject("key_baidu_native_bullet_height");
        if (slotExtraObject instanceof Integer) {
            return ((Integer) slotExtraObject).intValue();
        }
        return 0;
    }

    private int g() {
        Object slotExtraObject = this.e.getSlotExtraObject("key_baidu_native_bullet_width");
        if (slotExtraObject instanceof Integer) {
            return ((Integer) slotExtraObject).intValue();
        }
        return 0;
    }

    private String h() {
        try {
            XAdNativeResponse xAdNativeResponse = this.f3011a;
            if (xAdNativeResponse != null) {
                return (String) xAdNativeResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v23, types: [T, java.util.HashMap, java.util.Map] */
    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        XAdNativeResponse xAdNativeResponse;
        Context context;
        Context context2;
        if (i == 8121) {
            return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
        }
        if (i == 8163) {
            return (T) String.valueOf(getVideoUrl());
        }
        if (i == 8135) {
            return (T) Boolean.valueOf(hasDislike());
        }
        if (i == 6085) {
            XAdNativeResponse xAdNativeResponse2 = this.f3011a;
            if (xAdNativeResponse2 != null) {
                xAdNativeResponse2.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.9
                    public void onDislikeClick() {
                        BaiduNativeAd.this.notifyDislikeClick("百度智能优选dislike接口无关闭原因", null);
                        BaiduNativeAd.this.notifyDislikeSelect(0, "百度智能优选dislike接口无关闭原因");
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeItemClick(String str) {
                        BaiduNativeAd.this.notifyDislikeClick(str, null);
                        BaiduNativeAd.this.notifyDislikeSelect(0, str);
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeWindowClose() {
                        BaiduNativeAd.this.notifyDislikeOnCancel();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeWindowShow() {
                        BaiduNativeAd.this.notifyDislikeOnShow();
                    }
                });
            }
        } else if (i == 8109) {
            this.b = true;
        } else {
            if (i == 8120) {
                return (T) Boolean.valueOf(this.b);
            }
            if (i == 8194) {
                Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(8075), Map.class, null);
                if (map != null && (map.get(MediationConstant.BAIDU_DISLIKE_CLICK_ITEM) instanceof DislikeEvent)) {
                    DislikeEvent dislikeEvent = (DislikeEvent) map.get(MediationConstant.BAIDU_DISLIKE_CLICK_ITEM);
                    XAdNativeResponse xAdNativeResponse3 = this.f3011a;
                    if (xAdNativeResponse3 != null) {
                        xAdNativeResponse3.dislikeClick(dislikeEvent);
                    }
                }
            } else if (i == 8191) {
                XAdNativeResponse xAdNativeResponse4 = this.f3011a;
                if (xAdNativeResponse4 != null) {
                    xAdNativeResponse4.pauseAppDownload();
                }
            } else if (i == 8192) {
                XAdNativeResponse xAdNativeResponse5 = this.f3011a;
                if (xAdNativeResponse5 != null) {
                    xAdNativeResponse5.resumeAppDownload();
                }
            } else if (i == 8193) {
                return (T) Integer.valueOf(getDownloadStatus());
            }
        }
        if (i == 8159) {
            a((Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null), (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null), (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null), (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null), BaiduAdapterUtil.buildViewBinder(AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null))));
        } else {
            if (i == 8147) {
                return (T) h();
            }
            if (i == 8142) {
                if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.f3011a)) {
                    Map<? extends String, ? extends Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------baidu_bid_win --------- map = " + map2);
                    if (map2 != null) {
                        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.putAll(map2);
                        XAdNativeResponse xAdNativeResponse6 = this.f3011a;
                        if (xAdNativeResponse6 != null) {
                            xAdNativeResponse6.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.10
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                    MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                }
            } else if (i == 8144) {
                if (BaiduAdapterUtil.hasMethodBiddingFail(this.f3011a)) {
                    Map<? extends String, ? extends Object> map3 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------baidu_bid_lose --------- map = " + map3);
                    if (map3 != null) {
                        LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                        linkedHashMap2.putAll(map3);
                        XAdNativeResponse xAdNativeResponse7 = this.f3011a;
                        if (xAdNativeResponse7 != null) {
                            xAdNativeResponse7.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.11
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map4) {
                                    MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                }
            } else {
                if (i == 6164) {
                    WeakReference<Context> weakReference = this.d;
                    if (weakReference == null || (context2 = weakReference.get()) == null) {
                        return null;
                    }
                    return (T) a(context2);
                }
                if (i == 8268) {
                    XAdNativeResponse xAdNativeResponse8 = this.f3011a;
                    if (xAdNativeResponse8 != null) {
                        return (T) Double.valueOf(xAdNativeResponse8.getDuration());
                    }
                } else if (i != 8269) {
                    if (i == 8267) {
                        WeakReference<Context> weakReference2 = this.d;
                        if (weakReference2 != null && (context = weakReference2.get()) != null) {
                            return (T) BitmapFactory.decodeResource(context.getResources(), R.drawable.tt_baidu_logo);
                        }
                    } else if (i == 8239 && (xAdNativeResponse = this.f3011a) != null) {
                        try {
                            Object adDataForKey = xAdNativeResponse.getAdDataForKey("act_url");
                            Object adDataForKey2 = this.f3011a.getAdDataForKey(OapsKey.KEY_PAGEKEY);
                            ?? r2 = (T) new HashMap();
                            r2.put("act_url", adDataForKey);
                            r2.put(OapsKey.KEY_PAGEKEY, adDataForKey2);
                            return r2;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public int getDownloadStatus() {
        XAdNativeResponse xAdNativeResponse = this.f3011a;
        if (xAdNativeResponse == null) {
            return -1;
        }
        int downloadStatus = xAdNativeResponse.getDownloadStatus();
        if (downloadStatus >= 0 && downloadStatus <= 100) {
            return 2;
        }
        if (downloadStatus == 101) {
            return 9;
        }
        if (downloadStatus == 102) {
            return 12;
        }
        if (downloadStatus == 103) {
            return 10;
        }
        return downloadStatus == 104 ? 11 : 1;
    }

    public String getVideoUrl() {
        XAdNativeResponse xAdNativeResponse;
        return (!isUseCustomVideo() || (xAdNativeResponse = this.f3011a) == null) ? "" : xAdNativeResponse.getVideoUrl();
    }

    public boolean hasDislike() {
        return false;
    }

    public Integer isReadyStatus() {
        WeakReference<Context> weakReference = this.d;
        Context context = weakReference != null ? weakReference.get() : null;
        XAdNativeResponse xAdNativeResponse = this.f3011a;
        return Integer.valueOf((xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? 4 : 2);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        AdnAdapterValueSetBuilder adnAdapterValueSetBuilderCreate = AdnAdapterValueSetBuilder.create();
        adnAdapterValueSetBuilderCreate.add(8035, this);
        return adnAdapterValueSetBuilderCreate.build();
    }
}

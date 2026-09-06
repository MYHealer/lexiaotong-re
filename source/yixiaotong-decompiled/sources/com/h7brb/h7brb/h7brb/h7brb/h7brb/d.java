package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.msdk.adapter.ks.R;
import com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    KsNativeAd.AdInteractionListener f3313a;
    KsNativeAd.VideoPlayListener b;
    KsApkDownloadListener c;
    private KsNativeAd d;
    private MediationAdSlotValueSet e;
    private boolean f;
    private Context g;

    public d(Context context, KsNativeAd ksNativeAd, MediationAdSlotValueSet mediationAdSlotValueSet, Function function, KsNativeLoader ksNativeLoader, boolean z) {
        super(ksNativeLoader, function);
        this.f3313a = new KsNativeAd.AdInteractionListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.1
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            @JProtect
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                d.this.notifyOnClickAd();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            @JProtect
            public void onAdShow(KsNativeAd ksNativeAd2) {
                d.this.notifyOnShowAd();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        };
        this.b = new KsNativeAd.VideoPlayListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.2
            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayComplete() {
                d.this.notifyOnVideoComplete();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayError(int i, int i2) {
                d.this.notifyOnVideoError(i, "Android MediaPlay Error Code :" + i2);
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayStart() {
                d.this.notifyOnVideoStart();
            }
        };
        this.c = new KsApkDownloadListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.3
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                d.this.notifyOnDownloadFailed(-1L, -1L, null, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                d.this.notifyOnDownloadFinished(-1L, null, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                d.this.notifyOnDownloadStarted();
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                d.this.notifyOnIdel();
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                d.this.notifyOnInstalled(null, null);
            }

            @Override // com.kwad.sdk.api.KsApkDownloadListener
            public void onPaused(int i) {
                d.this.notifyOnDownloadPause(-1L, -1L, null, null);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                d.this.notifyOnProgressUpdate(-1L, -1L, i, 2);
            }
        };
        this.g = context;
        this.d = ksNativeAd;
        this.e = mediationAdSlotValueSet;
        this.f = z;
        j();
    }

    private View a(Context context) {
        if (context == null || this.d == null) {
            return null;
        }
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
        kSAdVideoPlayConfigImpl.setVideoSoundEnable(!this.e.isMuted());
        return this.d.getVideoView(context, kSAdVideoPlayConfigImpl);
    }

    private void a(Context context, ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        View viewA;
        KsNativeAd ksNativeAd;
        KsNativeAd ksNativeAd2 = this.d;
        if (ksNativeAd2 == null || ksNativeAd2.getAdSourceLogoUrl(1) == null) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(mediationViewBinder.logoLayoutId);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
            if (viewFindViewById instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                viewGroup2.removeAllViews();
                ImageView imageView = new ImageView(context);
                new a(imageView).execute(this.d.getAdSourceLogoUrl(1));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                viewGroup2.addView(imageView, -1, -1);
            } else if (viewFindViewById instanceof ImageView) {
                ImageView imageView2 = (ImageView) viewFindViewById;
                new a(imageView2).execute(this.d.getAdSourceLogoUrl(1));
                imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }
        if (!isUseCustomVideo() || (ksNativeAd = this.d) == null || TextUtils.isEmpty(ksNativeAd.getVideoUrl())) {
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId);
            if (this.d == null || frameLayout == null || (viewA = a(context)) == null) {
                return;
            }
            removeSelfFromParent(viewA);
            frameLayout.removeAllViews();
            frameLayout.addView(viewA, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        KsNativeAd ksNativeAd = this.d;
        if (ksNativeAd != null) {
            ksNativeAd.registerViewForInteraction(viewGroup, list, this.f3313a);
        }
        if (mediationViewBinder != null) {
            a(context, viewGroup, mediationViewBinder);
        }
    }

    private void j() {
        Object productName;
        KsImage videoCoverImage;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8061, this.d.getActionDescription());
        sparseArray.put(8046, this.d.getAdDescription());
        sparseArray.put(8048, this.d.getAppIconUrl());
        if (TextUtils.isEmpty(this.d.getAppName())) {
            productName = !TextUtils.isEmpty(this.d.getProductName()) ? this.d.getProductName() : "";
        } else {
            productName = this.d.getAppName();
        }
        sparseArray.put(8049, productName);
        sparseArray.put(8045, this.d.getAdSource());
        sparseArray.put(8055, Boolean.valueOf(this.d.getInteractionType() == 1));
        sparseArray.put(8033, false);
        sparseArray.put(8082, Double.valueOf(this.d.getAppScore()));
        sparseArray.put(8056, productName);
        sparseArray.put(8057, this.d.getCorporationName());
        sparseArray.put(8047, Integer.valueOf((int) this.d.getAppPackageSize()));
        sparseArray.put(8078, Long.valueOf(this.d.getAppPackageSize()));
        sparseArray.put(8081, this.d.getAppVersion());
        sparseArray.put(8079, this.d.getPermissionInfoUrl());
        sparseArray.put(8080, this.d.getAppPrivacyUrl());
        try {
            sparseArray.put(8551, this.d.getIntroductionInfoUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        sparseArray.put(8059, Integer.valueOf(p.a(this.d.getInteractionType())));
        if (isClientBidding()) {
            sparseArray.put(8016, Double.valueOf(Math.max(this.d.getECPM(), 0.0d)));
        }
        if (this.d.getMaterialType() == 2) {
            if (this.d.getImageList() != null && !this.d.getImageList().isEmpty() && this.d.getImageList().get(0) != null) {
                sparseArray.put(8060, 3);
                videoCoverImage = this.d.getImageList().get(0);
                sparseArray.put(8050, videoCoverImage.getImageUrl());
                sparseArray.put(8051, Integer.valueOf(videoCoverImage.getHeight()));
                sparseArray.put(8052, Integer.valueOf(videoCoverImage.getWidth()));
            }
        } else if (this.d.getMaterialType() == 3) {
            if (this.d.getImageList() != null && this.d.getImageList().size() > 0) {
                sparseArray.put(8060, 4);
                ArrayList arrayList = new ArrayList();
                Iterator<KsImage> it = this.d.getImageList().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImageUrl());
                }
                sparseArray.put(8053, arrayList);
            }
        } else if (this.d.getMaterialType() == 1 || this.d.getMaterialType() == 8) {
            sparseArray.put(8060, 5);
            videoCoverImage = this.d.getVideoCoverImage();
            if (videoCoverImage == null && this.d.getImageList() != null && !this.d.getImageList().isEmpty() && this.d.getImageList().get(0) != null) {
                videoCoverImage = this.d.getImageList().get(0);
            }
            if (videoCoverImage != null) {
                sparseArray.put(8050, videoCoverImage.getImageUrl());
                sparseArray.put(8051, Integer.valueOf(videoCoverImage.getHeight()));
                sparseArray.put(8052, Integer.valueOf(videoCoverImage.getWidth()));
            }
        } else {
            sparseArray.put(8060, -1);
        }
        notifyNativeValue(sparseArray);
        this.d.setVideoPlayListener(this.b);
        this.d.setDownloadListener(this.c);
    }

    private String k() {
        return this.f ? l() : m();
    }

    private String l() {
        try {
            return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return d.this.m();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        Object obj;
        try {
            KsNativeAd ksNativeAd = this.d;
            if (ksNativeAd == null || (obj = ksNativeAd.getMediaExtraInfo().get(KSUtil.REQUEST_ID)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public int a() {
        KsNativeAd ksNativeAd = this.d;
        if (ksNativeAd != null) {
            return ksNativeAd.getVideoWidth();
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r10v3, types: [T, java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v9, types: [T, java.util.HashMap, java.util.Map] */
    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        KsNativeAd ksNativeAd;
        Context context;
        KsImage videoCoverImage;
        View rotateView = null;
        if (i == 8159) {
            final Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
            final ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
            final List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
            final List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
            final Function<SparseArray<Object>, Object> functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null));
            if (this.f) {
                o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.8
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.a(activity, viewGroup, list, list2, p.a((Function<SparseArray<Object>, Object>) functionCovertToFunction));
                    }
                });
            } else {
                a(activity, viewGroup, list, list2, p.a(functionCovertToFunction));
            }
        } else {
            if (i == 8161) {
                return (T) Integer.valueOf(c());
            }
            if (i == 8162) {
                return (T) Integer.valueOf(f());
            }
            if (i == 8163) {
                return (T) String.valueOf(i());
            }
            if (i == 8320) {
                if (isUseCustomVideo() && this.d != null) {
                    return (T) new c(this.d);
                }
            } else if (i == 8109) {
                KsNativeAd ksNativeAd2 = this.d;
                if (ksNativeAd2 != null) {
                    ksNativeAd2.setVideoPlayListener(null);
                    this.d = null;
                }
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.d == null);
                }
                if (i == 8147) {
                    return (T) k();
                }
                if (i == 8142) {
                    if (p.a(this.d)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = p.a((Map<String, Object>) map);
                            long jB = p.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsNativeAd ksNativeAd3 = this.d;
                            if (ksNativeAd3 != null) {
                                ksNativeAd3.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144) {
                    if (p.b(this.d)) {
                        Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            int iC = p.c(map2);
                            int iD = p.d(map2);
                            int iE = p.e(map2);
                            String strF = p.f(map2);
                            MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                            if (this.d != null) {
                                AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                                adExposureFailedReason.setWinEcpm(iD);
                                adExposureFailedReason.setAdnType(iE);
                                adExposureFailedReason.setAdnName(strF);
                                this.d.reportAdExposureFailed(iC, adExposureFailedReason);
                            }
                        }
                    }
                } else {
                    if (i == 6164) {
                        Context context2 = this.g;
                        if (context2 != null) {
                            return (T) a(context2);
                        }
                        return null;
                    }
                    if (i == 8268) {
                        KsNativeAd ksNativeAd4 = this.d;
                        if (ksNativeAd4 != null) {
                            return (T) Double.valueOf(ksNativeAd4.getVideoDuration());
                        }
                    } else if (i == 8269) {
                        KsNativeAd ksNativeAd5 = this.d;
                        if (ksNativeAd5 != null && (videoCoverImage = ksNativeAd5.getVideoCoverImage()) != null) {
                            ?? r11 = (T) new HashMap();
                            r11.put(MediationConstant.VIDEO_COVER_IMG_URL, videoCoverImage.getImageUrl());
                            r11.put(MediationConstant.VIDEO_COVER_IMG_WIDTH, Integer.valueOf(videoCoverImage.getWidth()));
                            r11.put(MediationConstant.VIDEO_COVER_IMG_HEIGHT, Integer.valueOf(videoCoverImage.getHeight()));
                            r11.put(MediationConstant.VIDEO_COVER_IMG_VALID, Boolean.valueOf(videoCoverImage.isValid()));
                            return r11;
                        }
                    } else if (i == 8267) {
                        Context context3 = this.g;
                        if (context3 != null) {
                            return (T) BitmapFactory.decodeResource(context3.getResources(), R.drawable.tt_ks_logo);
                        }
                    } else if (i == 8239 && (ksNativeAd = this.d) != null && (context = this.g) != null) {
                        try {
                            rotateView = ksNativeAd.getRotateView(context);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (rotateView != null) {
                            ?? r10 = (T) new HashMap();
                            r10.put(MediationConstant.GM_EXTRA_KEY_KS_GET_ROTATE_VIEW, rotateView);
                            return r10;
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public int b() {
        try {
            Integer num = (Integer) o.a(new Callable<Integer>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(d.this.a());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int c() {
        return this.f ? b() : a();
    }

    @Override // com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public int d() {
        KsNativeAd ksNativeAd = this.d;
        if (ksNativeAd != null) {
            return ksNativeAd.getVideoHeight();
        }
        return 0;
    }

    public int e() {
        try {
            Integer num = (Integer) o.a(new Callable<Integer>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.5
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(d.this.d());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int f() {
        return this.f ? e() : d();
    }

    public String g() {
        KsNativeAd ksNativeAd;
        return (!isUseCustomVideo() || (ksNativeAd = this.d) == null) ? "" : ksNativeAd.getVideoUrl();
    }

    public String h() {
        try {
            return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.d.6
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return d.this.g();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String i() {
        return this.f ? h() : g();
    }

    @Override // com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

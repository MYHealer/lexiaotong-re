package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.R;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.gdt.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f3160a;
    private volatile boolean b;
    private FrameLayout.LayoutParams c;
    private VideoOption d;
    private boolean e;
    private Context f;
    private MediaView g;
    private NativeADMediaListener h;

    public d(Context context, MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function function, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, VideoOption videoOption, boolean z) {
        super(mediationAdLoaderBaseFunction, function);
        this.b = false;
        this.h = new NativeADMediaListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.9
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoClicked() {
                d.this.notifyOnClickAd();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
                d.this.notifyOnVideoComplete();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                if (adError != null) {
                    d.this.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    d.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
                d.this.notifyOnVideoPause();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
                d.this.notifyOnVideoResume();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                d.this.notifyOnVideoStart();
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
            }
        };
        this.f = context;
        this.f3160a = nativeUnifiedADData;
        this.c = layoutParams;
        this.d = videoOption;
        this.e = z;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        NativeAdContainer nativeAdContainer;
        Object tag;
        NativeUnifiedADData nativeUnifiedADData;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        if (isServerBidding() && (nativeUnifiedADData = this.f3160a) != null) {
            nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
        }
        if (this.f3160a != null) {
            if (context == null) {
                context = viewGroup.getContext();
            }
            Context context2 = context;
            int i = 0;
            if (viewGroup.getChildCount() == 0 || !(viewGroup.getChildAt(0) instanceof NativeAdContainer)) {
                nativeAdContainer = new NativeAdContainer(context2);
                nativeAdContainer.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    childAt.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup.removeViewInLayout(childAt);
                    if (childAt != null) {
                        nativeAdContainer.addView(childAt, childAt.getLayoutParams());
                    }
                }
                viewGroup.removeAllViews();
                viewGroup.addView(nativeAdContainer, -1, -1);
            } else {
                nativeAdContainer = (NativeAdContainer) viewGroup.getChildAt(0);
                while (i < nativeAdContainer.getChildCount()) {
                    View childAt2 = nativeAdContainer.getChildAt(i);
                    if (childAt2 == null || ((tag = childAt2.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                        i++;
                    } else {
                        nativeAdContainer.removeView(childAt2);
                    }
                }
            }
            NativeAdContainer nativeAdContainer2 = nativeAdContainer;
            if (mediationViewBinder != null) {
                a(viewGroup, mediationViewBinder);
            } else {
                a(list4);
            }
            this.f3160a.bindAdToView(context2, nativeAdContainer2, this.c, list, list4);
            MediaView mediaView = this.g;
            if (mediaView != null) {
                this.f3160a.bindMediaView(mediaView, h(), this.h);
            }
            this.f3160a.setNativeAdEventListener(new NativeADEventListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.8
                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADClicked() {
                    d.this.notifyOnClickAd();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADError(AdError adError) {
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADExposed() {
                    d.this.notifyOnShowAd();
                }

                @Override // com.qq.e.ads.nativ.NativeADEventListener
                public void onADStatusChanged() {
                }
            });
        }
    }

    private void a(ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        if (viewGroup == null || mediationViewBinder == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId);
        if (frameLayout != null && getImageMode() == 5) {
            MediaView mediaViewI = i();
            frameLayout.removeAllViews();
            frameLayout.addView(mediaViewI, -1, -1);
        }
        if (TextUtils.isEmpty(this.f3160a.getCTAText())) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(mediationViewBinder.callToActionId);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewFindViewById);
        this.f3160a.bindCTAViews(arrayList);
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.e) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f3160a.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.f3160a.sendLossNotification(0, iA, null);
        }
    }

    private void a(List<View> list) {
        NativeUnifiedADData nativeUnifiedADData;
        if (list == null || (nativeUnifiedADData = this.f3160a) == null || TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            return;
        }
        this.f3160a.bindCTAViews(list);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0121  */
    /* JADX WARN: Code duplicated, block: B:17:0x012a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0149  */
    /* JADX WARN: Code duplicated, block: B:28:0x0158  */
    /* JADX WARN: Code duplicated, block: B:29:0x015d  */
    private void b() {
        Object eCPMLevel;
        int i;
        int i2;
        int i3;
        SparseArray<Object> sparseArray = new SparseArray<>();
        NativeUnifiedADAppMiitInfo appMiitInfo = this.f3160a.getAppMiitInfo();
        if (appMiitInfo != null) {
            sparseArray.put(8056, appMiitInfo.getAppName());
            sparseArray.put(8057, appMiitInfo.getAuthorName());
            sparseArray.put(8078, Long.valueOf(appMiitInfo.getPackageSizeBytes()));
            sparseArray.put(8047, Integer.valueOf((int) appMiitInfo.getPackageSizeBytes()));
            sparseArray.put(8079, appMiitInfo.getPermissionsUrl());
            sparseArray.put(8080, appMiitInfo.getPrivacyAgreement());
            sparseArray.put(8081, appMiitInfo.getVersionName());
            try {
                sparseArray.put(8551, appMiitInfo.getDescriptionUrl());
            } catch (Throwable unused) {
            }
        }
        sparseArray.put(8045, this.f3160a.getTitle());
        sparseArray.put(8046, this.f3160a.getDesc());
        sparseArray.put(8061, this.f3160a.getCTAText());
        sparseArray.put(8048, this.f3160a.getIconUrl());
        sparseArray.put(8050, this.f3160a.getImgUrl());
        sparseArray.put(8052, Integer.valueOf(this.f3160a.getPictureWidth()));
        sparseArray.put(8051, Integer.valueOf(this.f3160a.getPictureHeight()));
        sparseArray.put(8053, this.f3160a.getImgList());
        sparseArray.put(8082, Double.valueOf(this.f3160a.getAppScore()));
        sparseArray.put(8049, this.f3160a.getTitle());
        sparseArray.put(8055, Boolean.valueOf(this.f3160a.isAppAd()));
        if (!isClientBidding()) {
            if (isMultiBidding()) {
                eCPMLevel = this.f3160a.getECPMLevel();
                i = 8058;
            }
            if (this.f3160a.getAdPatternType() != 2) {
                i2 = 5;
            } else {
                if (this.f3160a.getAdPatternType() == 4 && this.f3160a.getAdPatternType() != 1) {
                    if (this.f3160a.getAdPatternType() == 3) {
                        i2 = 4;
                    }
                    if (this.f3160a.isAppAd()) {
                        i3 = 4;
                    } else {
                        i3 = 3;
                    }
                    sparseArray.put(8059, i3);
                    sparseArray.put(8033, false);
                    notifyNativeValue(sparseArray);
                }
                i2 = 3;
            }
            sparseArray.put(8060, i2);
            if (this.f3160a.isAppAd()) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            sparseArray.put(8059, i3);
            sparseArray.put(8033, false);
            notifyNativeValue(sparseArray);
        }
        eCPMLevel = Double.valueOf(Math.max(this.f3160a.getECPM(), 0.0d));
        i = 8016;
        sparseArray.put(i, eCPMLevel);
        if (this.f3160a.getAdPatternType() != 2) {
            if (this.f3160a.getAdPatternType() == 4) {
                i2 = 3;
            } else {
                i2 = 3;
            }
            if (this.f3160a.isAppAd()) {
                i3 = 4;
            } else {
                i3 = 3;
            }
            sparseArray.put(8059, i3);
            sparseArray.put(8033, false);
            notifyNativeValue(sparseArray);
        }
        i2 = 5;
        sparseArray.put(8060, i2);
        if (this.f3160a.isAppAd()) {
            i3 = 4;
        } else {
            i3 = 3;
        }
        sparseArray.put(8059, i3);
        sparseArray.put(8033, false);
        notifyNativeValue(sparseArray);
    }

    private int c() {
        return this.e ? e() : d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        NativeUnifiedADData nativeUnifiedADData = this.f3160a;
        if (nativeUnifiedADData != null) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                return 0;
            }
            if (appStatus == 1) {
                return 6;
            }
            if (appStatus == 2) {
                return 8;
            }
            if (appStatus == 4) {
                return 2;
            }
            if (appStatus == 8) {
                return 5;
            }
            if (appStatus == 16) {
                return 4;
            }
            if (appStatus == 32) {
                return 3;
            }
            if (appStatus == 64) {
                return 7;
            }
        }
        return 1;
    }

    private int e() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(d.this.d());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer f() {
        NativeUnifiedADData nativeUnifiedADData = this.f3160a;
        return Integer.valueOf((nativeUnifiedADData == null || !nativeUnifiedADData.isValid()) ? 4 : 2);
    }

    private Integer g() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return d.this.f();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }

    private VideoOption h() {
        VideoOption videoOption = this.d;
        return videoOption == null ? new VideoOption.Builder().build() : videoOption;
    }

    private MediaView i() {
        if (this.f == null) {
            return null;
        }
        if (this.g == null) {
            MediaView mediaView = new MediaView(this.f);
            this.g = mediaView;
            mediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        MediaView mediaView2 = this.g;
        if (mediaView2 != null && mediaView2.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
        return this.g;
    }

    private String j() {
        return this.e ? k() : l();
    }

    private String k() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.10
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return d.this.l();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        Object obj;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.f3160a;
            if (nativeUnifiedADData == null || (obj = nativeUnifiedADData.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer a() {
        return this.e ? g() : f();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        Context context;
        Runnable runnable;
        if (i == 8148) {
            if (this.e) {
                runnable = new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.f3160a != null) {
                            d.this.f3160a.resume();
                        }
                    }
                };
                n.b(runnable);
            } else {
                NativeUnifiedADData nativeUnifiedADData = this.f3160a;
                if (nativeUnifiedADData != null) {
                    nativeUnifiedADData.resume();
                }
            }
        } else if (i == 8149) {
            if (this.e) {
                runnable = new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.f3160a != null) {
                            d.this.f3160a.pauseVideo();
                        }
                    }
                };
                n.b(runnable);
            } else {
                NativeUnifiedADData nativeUnifiedADData2 = this.f3160a;
                if (nativeUnifiedADData2 != null) {
                    nativeUnifiedADData2.pauseVideo();
                }
            }
        } else if (i == 8109) {
            this.b = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.13
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f3160a != null) {
                        d.this.f3160a.destroy();
                    }
                    if (d.this.g != null) {
                        d.this.g = null;
                    }
                }
            });
        } else {
            if (i == 8120) {
                return (T) Boolean.valueOf(this.b);
            }
            if (i == 8191) {
                if (this.e) {
                    runnable = new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.f3160a != null) {
                                d.this.f3160a.pauseAppDownload();
                            }
                        }
                    };
                    n.b(runnable);
                } else {
                    NativeUnifiedADData nativeUnifiedADData3 = this.f3160a;
                    if (nativeUnifiedADData3 != null) {
                        nativeUnifiedADData3.pauseAppDownload();
                    }
                }
            } else if (i == 8192) {
                if (this.e) {
                    runnable = new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.this.f3160a != null) {
                                d.this.f3160a.resumeAppDownload();
                            }
                        }
                    };
                    n.b(runnable);
                } else {
                    NativeUnifiedADData nativeUnifiedADData4 = this.f3160a;
                    if (nativeUnifiedADData4 != null) {
                        nativeUnifiedADData4.resumeAppDownload();
                    }
                }
            } else {
                if (i == 8193) {
                    return (T) Integer.valueOf(c());
                }
                if (i == 8121) {
                    return (T) isReadyStatusForProto2(a(), sparseArray, cls);
                }
                try {
                    if (i == 8142) {
                        NativeUnifiedADData nativeUnifiedADData5 = this.f3160a;
                        if (nativeUnifiedADData5 != null) {
                            if (this.e) {
                                n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.f3160a.sendWinNotification((int) d.this.getCpm());
                                    }
                                });
                            } else {
                                nativeUnifiedADData5.sendWinNotification((int) getCpm());
                            }
                        }
                    } else if (i == 8144) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        if (map != null && this.f3160a != null) {
                            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
                        }
                    } else if (i == 8194) {
                        if (this.e) {
                            runnable = new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (d.this.f3160a != null) {
                                        d.this.f3160a.negativeFeedback();
                                    }
                                }
                            };
                            n.b(runnable);
                        } else {
                            NativeUnifiedADData nativeUnifiedADData6 = this.f3160a;
                            if (nativeUnifiedADData6 != null) {
                                nativeUnifiedADData6.negativeFeedback();
                            }
                        }
                    } else if (i == 8159) {
                        final Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                        final ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
                        final List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
                        final List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
                        final List<View> list3 = (List) MediationValueUtil.objectValue(sparseArray.get(8070), List.class, null);
                        final Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null);
                        if (this.e) {
                            n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.a(activity, viewGroup, list, list2, list3, a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                                }
                            });
                        } else {
                            a(activity, viewGroup, list, list2, list3, a.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                        }
                    } else {
                        if (i == 8147) {
                            return (T) j();
                        }
                        if (i == 6164) {
                            if (this.f != null) {
                                return (T) i();
                            }
                            return null;
                        }
                        if (i == 8268) {
                            NativeUnifiedADData nativeUnifiedADData7 = this.f3160a;
                            if (nativeUnifiedADData7 != null) {
                                return (T) Double.valueOf(nativeUnifiedADData7.getVideoDuration());
                            }
                        } else if (i != 8269 && i == 8267 && (context = this.f) != null) {
                            return (T) BitmapFactory.decodeResource(context.getResources(), R.drawable.tt_gdt_logo);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }
}

package com.yfanads.android.adx.core.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.load.AdxLoader;
import com.yfanads.android.adx.core.load.DyInstallReceiver;
import com.yfanads.android.adx.core.model.AdxFeedBean;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.core.model.NativeSourceNew;
import com.yfanads.android.adx.download.DownloaderMgr;
import com.yfanads.android.adx.model.SerializableMap;
import com.yfanads.android.adx.newplayer.VideoPlayerImp;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.adx.player.yfplayer.IVideoPlayListener;
import com.yfanads.android.custom.view.CustomDialog;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.RouterMgr;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class NativeAdImpl extends AbstractNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, AdxNativeAd.VideoPlayWholeListener, IVideoPlayListener, Parcelable {
    public static final Parcelable.Creator<NativeAdImpl> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdxNativeAd.AdInteractionListener f9586a;
    public AdxNativeAd.VideoPlayListener b;
    public final NativeSourceNew c;
    public int d;
    public final String[] e;
    public boolean f;
    public boolean g;
    public VideoPlayerImp h;
    public com.yfanads.android.adx.service.a i;
    public b j;
    public com.yfanads.android.adx.components.model.a k;
    public com.yfanads.android.adx.components.base.d l;
    public boolean m;
    public com.yfanads.android.adx.download.dialog.b n;
    public boolean o;
    public boolean p;
    public final ConcurrentHashMap q;

    public class a implements Parcelable.Creator<NativeAdImpl> {
        @Override // android.os.Parcelable.Creator
        public final NativeAdImpl createFromParcel(Parcel parcel) {
            return new NativeAdImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final NativeAdImpl[] newArray(int i) {
            return new NativeAdImpl[i];
        }
    }

    public static class b extends AbsCallback<NativeAdImpl> implements LifecycleListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference<Activity> f9587a;

        public b(NativeAdImpl nativeAdImpl, Activity activity) {
            super(nativeAdImpl);
            this.f9587a = new SoftReference<>(activity);
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public final void onActivityPaused(Activity activity) {
            com.yfanads.android.adx.utils.a.a("onActivityPaused " + activity + "| " + this.f9587a.get());
            if (this.f9587a.get() == activity) {
                NativeAdImpl nativeAdImpl = get();
                nativeAdImpl.getClass();
                YFLog.high("onActivityPause ");
                com.yfanads.android.adx.components.base.a aVar = com.yfanads.android.adx.components.base.a.C1170a.f9566a;
                aVar.getClass();
                com.yfanads.android.adx.utils.a.c("ActionHelper updateStatueBackground");
                Iterator it = aVar.f9565a.values().iterator();
                while (it.hasNext()) {
                    com.yfanads.android.adx.components.base.b bVar = ((com.yfanads.android.adx.components.model.a) it.next()).h;
                    if (bVar != null) {
                        bVar.b(true);
                    }
                }
                com.yfanads.android.adx.components.base.a.C1170a.f9566a.getClass();
                com.yfanads.android.adx.components.base.a.b();
                AdxNativeAd.AdInteractionListener adInteractionListener = nativeAdImpl.f9586a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdHide();
                }
            }
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public final void onActivityResumed(Activity activity) {
            com.yfanads.android.adx.utils.a.a("onActivityResumed " + activity);
            if (this.f9587a.get() == activity) {
                NativeAdImpl nativeAdImpl = get();
                if (nativeAdImpl.m) {
                    com.yfanads.android.adx.utils.a.a("onActivityResumed isDownloadTipsShow true");
                    com.yfanads.android.adx.components.base.a.C1170a.f9566a.a(true);
                    return;
                }
                com.yfanads.android.adx.components.base.a aVar = com.yfanads.android.adx.components.base.a.C1170a.f9566a;
                aVar.getClass();
                com.yfanads.android.adx.utils.a.c("ActionHelper updateStatueForeground");
                Iterator it = aVar.f9565a.values().iterator();
                while (it.hasNext()) {
                    com.yfanads.android.adx.components.base.b bVar = ((com.yfanads.android.adx.components.model.a) it.next()).h;
                    if (bVar != null) {
                        bVar.b(false);
                    }
                }
                aVar.a("updateStatueForeground");
                AdxNativeAd.AdInteractionListener adInteractionListener = nativeAdImpl.f9586a;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
            }
        }

        @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
        public final void onBackToBackground() {
            com.yfanads.android.adx.utils.a.a("Native onBackToBackground and stop action.");
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.getClass();
            com.yfanads.android.adx.components.base.a.b();
        }

        @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
        public final void onBackToForeground() {
            com.yfanads.android.adx.utils.a.a("Native onBackToForeground ");
        }
    }

    public static class c extends AbsCallback<NativeAdImpl> implements com.yfanads.android.adx.router.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference<Activity> f9588a;
        public final boolean b;
        public final boolean c;

        public c(NativeAdImpl nativeAdImpl, Activity activity, boolean z, boolean z2) {
            super(nativeAdImpl);
            this.f9588a = new SoftReference<>(activity);
            this.b = z;
            this.c = z2;
        }
    }

    public NativeAdImpl(NativeSourceNew nativeSourceNew) {
        ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
        this.e = new String[12];
        this.f = false;
        this.g = false;
        this.o = false;
        this.p = false;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.q = concurrentHashMap;
        this.c = nativeSourceNew;
        concurrentHashMap.clear();
    }

    public final String[] a(int i, String[] strArr) {
        NativeSourceNew.SldItem sldItem;
        if (i == 1 || i == 24 || i == 22 || i == 23) {
            NativeSourceNew nativeSourceNew = this.c;
            boolean z = nativeSourceNew != null && nativeSourceNew.hasSld();
            if (i != 1) {
                switch (i) {
                    case 22:
                        sldItem = !z ? new NativeSourceNew.SldItem("2") : this.c.ad.sld.get("shake");
                        break;
                    case 23:
                        sldItem = !z ? new NativeSourceNew.SldItem("5") : this.c.ad.sld.get("rolling");
                        break;
                    case 24:
                        sldItem = !z ? new NativeSourceNew.SldItem("1") : this.c.ad.sld.get("move");
                        break;
                    default:
                        sldItem = new NativeSourceNew.SldItem("0");
                        break;
                }
            } else {
                sldItem = z ? this.c.ad.sld.get("click") : new NativeSourceNew.SldItem("0");
            }
            if (strArr != null && strArr.length > 2) {
                if (!TextUtils.isEmpty(getDeepLink())) {
                    strArr[strArr.length - 2] = "1";
                } else if (getInteractionType() == 2) {
                    strArr[strArr.length - 2] = "2";
                }
                if (sldItem != null) {
                    strArr[strArr.length - 1] = sldItem.value;
                }
            }
        }
        return strArr;
    }

    public final void b(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            com.yfanads.android.adx.utils.a.b(" group is null, return.");
            return;
        }
        com.yfanads.android.adx.utils.a.a(" startAdViewTracker.");
        com.yfanads.android.adx.components.base.d dVar = new com.yfanads.android.adx.components.base.d(new com.yfanads.android.adx.components.base.c() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda4
            @Override // com.yfanads.android.adx.components.base.c
            public final void collectExposureData(long j) {
                this.f$0.a(viewGroup, j);
            }
        });
        this.l = dVar;
        dVar.a(viewGroup);
    }

    public final void c(final ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                viewGroup.post(new Runnable() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(viewGroup);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void d() {
        DyInstallReceiver dyInstallReceiver = DyInstallReceiver.getInstance();
        dyInstallReceiver.setReportCallListener(new NativeAdImpl$$ExternalSyntheticLambda5(this));
        Context context = com.yfanads.android.adx.service.d.b;
        if (com.yfanads.android.adx.service.d.b() == null || !com.yfanads.android.adx.service.d.b().canCloseAppReceiver()) {
            dyInstallReceiver.registerToApp(context);
        } else {
            dyInstallReceiver.unregisterInstallReceiver(context);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void destroy(com.yfanads.android.adx.service.a aVar) {
        YFLog.debug("nativeAd destroy type:" + aVar);
        if (this.j != null) {
            LifecycleObserver.getInstance().unRegisterLifecycleListener(this.j);
        }
        com.yfanads.android.adx.service.d.a.f9620a.f9619a.remove(aVar);
        this.q.clear();
        com.yfanads.android.adx.download.dialog.b bVar = this.n;
        if (bVar != null) {
            CustomDialog customDialog = bVar.b;
            if (customDialog != null) {
                try {
                    customDialog.dismissAllowingStateLoss();
                } catch (Exception unused) {
                    com.yfanads.android.adx.utils.a.b("customDialog dismiss");
                }
            }
            this.n = null;
        }
        VideoPlayerImp videoPlayerImp = this.h;
        if (videoPlayerImp != null) {
            videoPlayerImp.release();
            this.h = null;
        }
        com.yfanads.android.adx.components.model.a aVar2 = this.k;
        if (aVar2 != null) {
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.a(aVar2);
        }
        com.yfanads.android.adx.components.base.d dVar = this.l;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getActionDescription() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasDownload()) ? "" : this.c.ad.download.actionText;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAdDescription() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasAsset()) ? "" : this.c.ad.asset.getAdDes();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAdMerchant() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasAd()) ? "" : this.c.ad.merchant;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAdSource() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getAdSourceLogoUrl(int i) {
        return R.mipmap.ad_log_adx;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAppIconUrl() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasDownload()) ? "" : this.c.ad.download.appIconUrl;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAppName() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.appName;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAppPackageName() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasDownload()) ? "" : this.c.ad.download.packageName;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final long getAppPackageSize() {
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew == null || !nativeSourceNew.hasDownload()) {
            return 0L;
        }
        return this.c.ad.download.fileSize;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAppPrivacyUrl() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.privacyUrl;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final float getAppScore() {
        return 0.0f;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getAppVersion() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.appVer;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getCorporationName() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.developerName;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getDeepLink() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasAd()) ? "" : this.c.ad.dplUrl;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getECPM() {
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew == null || !nativeSourceNew.hasAd()) {
            return 0;
        }
        return this.c.ad.price;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void getEndVideoBitmap(final AdxNativeAd.AdEndBitmap adEndBitmap, final int i, final int i2) {
        com.yfanads.android.adx.utils.b.f9622a.submit(new Runnable() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(adEndBitmap, i, i2);
            }
        });
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final AdxImage getEndVideoCoverImage() {
        if (getMaterialType() != 1) {
            return new com.yfanads.android.adx.core.impl.b(0, 0, "");
        }
        NativeSourceNew.Video video = this.c.ad.asset.video;
        return new com.yfanads.android.adx.core.impl.b(video.w, video.h, video.endImgUrl);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final List<AdxImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew != null && nativeSourceNew.isImgAsset()) {
            NativeSourceNew.Image image = this.c.ad.asset.image;
            for (String str : image.urls) {
                arrayList.add(new com.yfanads.android.adx.core.impl.b(image.w, image.h, str));
            }
        }
        return arrayList;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getInteractionType() {
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew == null || !nativeSourceNew.hasAd()) {
            return 0;
        }
        int i = this.c.ad.action;
        return (i != 1 && i == 2) ? 1 : 2;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getIntroductionInfo() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getIntroductionInfoUrl() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.appInfoUrl;
    }

    @Override // com.yfanads.android.adx.core.model.BaseAd
    public final Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    @Deprecated
    public final String getPermissionInfo() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getPermissionInfoUrl() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.isAppDownload()) ? "" : this.c.ad.download.permissionUrl;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getProductName() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasDownload()) ? "" : this.c.ad.download.iconTitle;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getTitle() {
        NativeSourceNew nativeSourceNew = this.c;
        return (nativeSourceNew == null || !nativeSourceNew.hasAsset()) ? "" : this.c.ad.asset.getTitle();
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final AdxImage getVideoCoverImage() {
        if (getMaterialType() != 1) {
            return new com.yfanads.android.adx.core.impl.b(0, 0, "");
        }
        NativeSourceNew.Video video = this.c.ad.asset.video;
        return new com.yfanads.android.adx.core.impl.b(video.w, video.h, video.imgUrl);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getVideoDuration() {
        if (getMaterialType() == 1) {
            return this.c.ad.asset.video.duration;
        }
        return 0;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getVideoHeight() {
        if (getMaterialType() == 1) {
            return this.c.ad.asset.video.h;
        }
        return 0;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getVideoKeepTime() {
        if (getMaterialType() == 1) {
            return this.c.ad.asset.video.videoKeepTime;
        }
        return 0;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getVideoUrl() {
        return getMaterialType() == 1 ? this.c.ad.asset.video.url : "";
    }

    @Override // com.yfanads.android.adx.core.impl.AbstractNativeAd, com.yfanads.android.adx.core.model.AdxNativeAd
    public final View getVideoView(Context context, AdVideoPlayConfig adVideoPlayConfig) {
        VideoPlayerImp videoPlayerImp;
        if (AdxSDKImpl.get().hasInitFinish()) {
            if (adVideoPlayConfig == null) {
                adVideoPlayConfig = (AdVideoPlayConfig) AdxLoader.get().newInstance(AdVideoPlayConfig.class);
            }
            com.yfanads.android.adx.utils.a.a("getPlayVideo CustomPlayer");
            videoPlayerImp = new VideoPlayerImp(context, getVideoUrl(), !adVideoPlayConfig.isVideoSoundEnable(), getRequestId(), this);
            this.h = videoPlayerImp;
        } else {
            videoPlayerImp = null;
        }
        return videoPlayerImp == null ? new View(context) : videoPlayerImp.getView();
    }

    @Override // com.yfanads.android.adx.core.impl.AbstractNativeAd
    public final IPlayVideo getVideoView2(Context context, AdVideoPlayConfig adVideoPlayConfig) {
        if (!AdxSDKImpl.get().hasInitFinish()) {
            return null;
        }
        if (adVideoPlayConfig == null) {
            adVideoPlayConfig = (AdVideoPlayConfig) AdxLoader.get().newInstance(AdVideoPlayConfig.class);
        }
        com.yfanads.android.adx.utils.a.a("getPlayVideo CustomPlayer");
        VideoPlayerImp videoPlayerImp = new VideoPlayerImp(context, getVideoUrl(), !adVideoPlayConfig.isVideoSoundEnable(), getRequestId(), this);
        this.h = videoPlayerImp;
        return videoPlayerImp;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getVideoWidth() {
        if (getMaterialType() == 1) {
            return this.c.ad.asset.video.w;
        }
        return 0;
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public final void onAdClicked(View view) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayComplete() {
        reportAdInfo(15, null);
        AdxNativeAd.VideoPlayListener videoPlayListener = this.b;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayComplete();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayStart() {
        reportAdInfo(11, null);
        AdxNativeAd.VideoPlayListener videoPlayListener = this.b;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayStart();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayWholeListener, com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public final void onVideoProgress(int i) {
        if (i == 25) {
            reportAdInfo(12, null);
        } else if (i == 50) {
            reportAdInfo(13, null);
        } else {
            if (i != 75) {
                return;
            }
            reportAdInfo(14, null);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void registerViewForInteraction(Activity activity, com.yfanads.android.adx.service.a aVar, ViewGroup viewGroup, Map<View, Integer> map, AdxNativeAd.InteractionConf interactionConf, AdxNativeAd.AdInteractionListener adInteractionListener) {
        this.p = interactionConf.isLpaa;
        this.f9586a = adInteractionListener;
        this.i = aVar;
        if (this.c == null) {
            com.yfanads.android.adx.utils.a.b(" nativeSource is null, return.");
        } else if (viewGroup == null) {
            com.yfanads.android.adx.utils.a.b(" group is null, return.");
        } else {
            this.g = false;
            c(viewGroup);
            YFLog.high("AdxNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
            if (map != null && !map.isEmpty()) {
                for (View view : map.keySet()) {
                    Integer num = map.get(view);
                    if (num != null) {
                        YFLog.debug("AdxNativeAds registerViewForInteraction view:" + view + "|" + num + "|sdd:" + interactionConf.showDownloadDialog);
                        switch (num.intValue()) {
                            case 1:
                            case 2:
                                a(activity, viewGroup, view, num, interactionConf, a(interactionConf.showDownloadDialog, 0));
                                break;
                            case 3:
                                a(activity, viewGroup, false, interactionConf.showDeepLinkDialog, view, num, interactionConf, a(interactionConf.showDownloadDialog, 0));
                                break;
                            case 4:
                                a(activity, view, interactionConf.showDeepLinkDialog, a(interactionConf.showDownloadDialog, 0), viewGroup, interactionConf.npd, interactionConf.npdw);
                                break;
                            case 5:
                                a(activity, view, interactionConf.showDeepLinkDialog, a(interactionConf.showDownloadDialog, 0, 1), viewGroup, interactionConf.npd, interactionConf.npdw);
                                break;
                            case 6:
                                a(activity, viewGroup, true, interactionConf.showDeepLinkDialog, view, num, interactionConf, a(interactionConf.showDownloadDialog, 0, 1));
                                break;
                        }
                    }
                }
                ScreenUtil.isFullScreen(activity);
            }
            b(viewGroup);
            a(activity, viewGroup, map, interactionConf);
        }
        this.j = new b(this, activity);
        LifecycleObserver.getInstance().registerLifecycleListener(this.j);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082 A[Catch: Exception -> 0x009b, TryCatch #0 {Exception -> 0x009b, blocks: (B:3:0x0002, B:5:0x001e, B:7:0x0030, B:9:0x0036, B:14:0x0074, B:21:0x0087, B:16:0x0079, B:17:0x007c, B:18:0x007f, B:19:0x0082, B:20:0x0085), top: B:26:0x0002 }] */
    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void reportAdInfo(int i, String[] strArr) {
        String[] strArr2;
        try {
            YFLog.high("reportAdInfo " + i);
            if (this.q.get(Integer.valueOf(i)) != null && Boolean.TRUE.equals(this.q.get(Integer.valueOf(i)))) {
                YFLog.debug("reportAdInfo hasReport, return");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strValueOf = String.valueOf(jCurrentTimeMillis);
            a(7, strValueOf);
            a(8, String.valueOf(jCurrentTimeMillis / 1000));
            a(9, strValueOf);
            a(10, strValueOf);
            a(11, com.yfanads.android.adx.service.c.a.f9618a.q);
            LoadManager loadManager = AdxSDK.getLoadManager();
            String[] strArrA = a(i);
            String[] strArr3 = com.yfanads.android.adx.utils.b.c;
            String[] strArr4 = this.e;
            if (i == 0) {
                strArr2 = com.yfanads.android.adx.utils.b.d;
            } else if (i == 1) {
                strArr2 = com.yfanads.android.adx.utils.b.e;
            } else if (i != 10) {
                switch (i) {
                    case 22:
                        strArr2 = com.yfanads.android.adx.utils.b.f;
                        break;
                    case 23:
                        strArr2 = com.yfanads.android.adx.utils.b.g;
                        break;
                    case 24:
                        strArr2 = com.yfanads.android.adx.utils.b.e;
                        break;
                    default:
                        strArr2 = null;
                        break;
                }
            } else {
                strArr2 = com.yfanads.android.adx.utils.b.h;
            }
            loadManager.reportAdInfo(strArrA, strArr3, strArr4, strArr2, a(i, strArr));
            this.q.put(Integer.valueOf(i), Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void setAdsListener(com.yfanads.android.adx.service.a aVar, AdxNativeAd.AdInteractionListener2 adInteractionListener2) {
        com.yfanads.android.adx.utils.a.a("setAdsListener ");
        com.yfanads.android.adx.service.d.a.f9620a.f9619a.put(aVar, adInteractionListener2);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void setBidEcpm(long j, long j2) {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void setVideoPlayListener(AdxNativeAd.VideoPlayListener videoPlayListener) {
        this.b = videoPlayListener;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void showFullScreenVideoAd(Activity activity, AdVideoPlayConfig adVideoPlayConfig, TemplateConf templateConf, FeedCom feedCom) {
        Intent intent = new Intent();
        intent.putExtra("templateConf", templateConf);
        intent.putExtra("nativeAds", this);
        intent.putExtra("feedCom", feedCom);
        if (activity == null) {
            com.yfanads.android.adx.utils.a.b("navigation activity is null, return.");
        } else if (TextUtils.isEmpty("com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity")) {
            com.yfanads.android.adx.utils.a.b("navigation intent or className is null, return.");
        } else {
            intent.setClassName(activity, "com.yfanads.android.adx.components.fullscreen.AdxFullScreenVideoActivity");
            activity.startActivity(intent);
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void showRewardVideoAd(Activity activity, AdVideoPlayConfig adVideoPlayConfig, TemplateConf templateConf, Map<String, Object> map, FeedCom feedCom) {
        Intent intent = new Intent();
        intent.putExtra("templateConf", templateConf);
        intent.putExtra("nativeAds", this);
        intent.putExtra("feedCom", feedCom);
        if (map != null) {
            intent.putExtra("data", new SerializableMap(map));
        }
        if (activity == null) {
            com.yfanads.android.adx.utils.a.b("navigation activity is null, return.");
        } else if (TextUtils.isEmpty("com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity")) {
            com.yfanads.android.adx.utils.a.b("navigation intent or className is null, return.");
        } else {
            intent.setClassName(activity, "com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity");
            activity.startActivity(intent);
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final int getMaterialType() {
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew == null) {
            return 0;
        }
        if (nativeSourceNew.isVideoAsset()) {
            return 1;
        }
        return this.c.isImgAsset() ? 2 : 0;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final String getRequestId() {
        NativeSourceNew nativeSourceNew = this.c;
        return nativeSourceNew != null ? nativeSourceNew.rid : "";
    }

    @Override // com.yfanads.android.adx.player.yfplayer.IVideoPlayListener
    public final void onAdShow() {
        AdxNativeAd.AdInteractionListener adInteractionListener = this.f9586a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayError(int i, int i2) {
        AdxNativeAd.VideoPlayListener videoPlayListener = this.b;
        if (videoPlayListener != null) {
            videoPlayListener.onVideoPlayError(i, i2);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void reStartInteraction() {
        this.g = false;
        if (this.i == com.yfanads.android.adx.service.a.REWARD) {
            this.m = false;
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.a(false);
        }
        com.yfanads.android.adx.utils.a.c("reStartTwistOrShake ".concat("reStartInteraction"));
        int i = this.d;
        if (i == 2 || i == 1) {
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.a();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void stopInteraction() {
        this.g = true;
        if (this.i == com.yfanads.android.adx.service.a.REWARD) {
            this.m = true;
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.a(true);
        }
        int i = this.d;
        if (i == 2 || i == 1) {
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.getClass();
            com.yfanads.android.adx.components.base.a.b();
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void traceData(TemplateConf templateConf, FeedCom feedCom, boolean z) {
        if (this.c != null) {
            new RouterMgr().routerWebView(com.yfanads.android.adx.service.d.b, new AdxFeedBean(this.c, templateConf, z), feedCom);
        }
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    public final void unRegisterViewAction() {
        int i = this.d;
        if (i == 2 || i == 1) {
            com.yfanads.android.adx.components.base.a.C1170a.f9566a.a(this.k);
        }
    }

    public final boolean b() {
        NativeSourceNew nativeSourceNew = this.c;
        return nativeSourceNew != null && nativeSourceNew.hasMonitor();
    }

    public final void c() {
        this.m = false;
        com.yfanads.android.adx.utils.a.a("onDownloadTipsDismiss  " + this.g);
        com.yfanads.android.adx.components.base.a aVar = com.yfanads.android.adx.components.base.a.C1170a.f9566a;
        aVar.a(false);
        if (!this.g) {
            com.yfanads.android.adx.utils.a.c("reStartTwistOrShake ".concat("onBackToForeground"));
            int i = this.d;
            if (i == 2 || i == 1) {
                aVar.a();
            }
        }
        AdxNativeAd.AdInteractionListener adInteractionListener = this.f9586a;
        if (adInteractionListener != null) {
            adInteractionListener.onDownloadTipsDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdxNativeAd.AdEndBitmap adEndBitmap, final int i, final int i2) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getVideoUrl(), new HashMap());
            final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((((long) getVideoDuration()) * 1000000) + 1, 3);
            mediaMetadataRetriever.release();
            if (frameAtTime != null && adEndBitmap != null) {
                com.yfanads.android.adx.utils.b.b.post(new Runnable() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeAdImpl.a(adEndBitmap, frameAtTime, i, i2);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NativeAdImpl(Parcel parcel) {
        ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
        this.e = new String[12];
        this.f = false;
        this.g = false;
        this.o = false;
        this.p = false;
        this.q = new ConcurrentHashMap();
        this.c = (NativeSourceNew) parcel.readParcelable(NativeSourceNew.class.getClassLoader());
        this.d = parcel.readInt();
    }

    public static void a(AdxNativeAd.AdEndBitmap adEndBitmap, Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateScaledBitmap;
        ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
        if (i != 0 && i2 != 0 && (bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true)) != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            bitmap = bitmapCreateScaledBitmap;
        }
        adEndBitmap.onGetData(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, long j) {
        com.yfanads.android.adx.utils.a.a(" callExposureData start.");
        if (viewGroup == null) {
            YFLog.error("callExposureData group is null, return.");
            return;
        }
        YFLog.high("callExposureData " + j);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        a(5, String.valueOf(iArr[0]));
        a(6, String.valueOf(iArr[1]));
        String[] strArrA = a(0);
        if (strArrA == null || strArrA.length == 0) {
            AdxNativeAd.AdInteractionListener adInteractionListener = this.f9586a;
            if (adInteractionListener != null) {
                adInteractionListener.onExposure(false);
            }
        } else {
            this.o = true;
            float fCurrentTimeMillis = System.currentTimeMillis();
            ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
            String[] strArr = new String[4];
            long jCurrentTimeMillis = System.currentTimeMillis();
            strArr[0] = String.valueOf(jCurrentTimeMillis);
            strArr[1] = String.valueOf(jCurrentTimeMillis / 1000);
            int iNextInt = (int) (jCurrentTimeMillis - fCurrentTimeMillis);
            if (iNextInt < 100) {
                iNextInt = new Random().nextInt(81) + 100;
            }
            strArr[2] = String.valueOf(iNextInt);
            strArr[3] = "100";
            reportAdInfo(0, strArr);
            AdxNativeAd.AdInteractionListener adInteractionListener2 = this.f9586a;
            if (adInteractionListener2 != null) {
                adInteractionListener2.onExposure(true);
            }
        }
        com.yfanads.android.adx.components.base.d dVar = this.l;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final void a(int i, String str) {
        String[] strArr = this.e;
        if (i < strArr.length) {
            strArr[i] = String.valueOf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup) {
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        a(0, String.valueOf(width));
        a(1, String.valueOf(height));
        a(2, String.valueOf(cVar.f));
        a(3, String.valueOf(ScreenUtil.px2dip(viewGroup.getContext(), width)));
        a(4, String.valueOf(ScreenUtil.px2dip(viewGroup.getContext(), height)));
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        a(5, String.valueOf(iArr[0]));
        a(6, String.valueOf(iArr[1]));
    }

    public static boolean a(int i, int... iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final void a(final Activity activity, final ViewGroup viewGroup, final Map<View, Integer> map, final AdxNativeAd.InteractionConf interactionConf) {
        if (interactionConf.auto) {
            final Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
            com.yfanads.android.adx.utils.b.b.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.a(origApplicationContext, viewGroup, map, activity, interactionConf);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:44:0x01db  */
    public void a(Context context, ViewGroup viewGroup, Map map, Activity activity, AdxNativeAd.InteractionConf interactionConf) throws Throwable {
        MotionEvent motionEvent;
        String[] strArrA;
        MotionEvent motionEvent2;
        if (!com.yfanads.android.adx.utils.b.b()) {
            com.yfanads.android.adx.utils.a.a("autoClick isAllowClick");
            return;
        }
        if (this.f) {
            com.yfanads.android.adx.utils.a.a("current user click, return.");
            return;
        }
        String[] strArr = new String[8];
        String[] strArr2 = new String[8];
        MotionEvent motionEventObtain = null;
        if (viewGroup == null) {
            com.yfanads.android.adx.utils.a.b("simulateClick itemView is null");
            strArrA = com.yfanads.android.adx.utils.b.a(strArr, strArr2, null);
        } else {
            try {
                float[] fArr = new float[1];
                float[] fArr2 = new float[1];
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                Random random = new Random();
                float fNextFloat = random.nextFloat() * width;
                float fNextFloat2 = random.nextFloat() * height;
                MotionEvent motionEventObtain2 = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis2, 0, fNextFloat, fNextFloat2, 0);
                try {
                    viewGroup.dispatchTouchEvent(motionEventObtain2);
                    fArr[0] = motionEventObtain2.getX();
                    fArr2[0] = motionEventObtain2.getY();
                    strArr[0] = String.valueOf(System.currentTimeMillis());
                    strArr[1] = String.valueOf(System.currentTimeMillis());
                    strArr[2] = String.valueOf((int) (fArr[0] + viewGroup.getTop()));
                    strArr[3] = String.valueOf((int) (fArr2[0] + viewGroup.getLeft()));
                    strArr[4] = String.valueOf((int) fArr[0]);
                    strArr[5] = String.valueOf((int) fArr2[0]);
                    strArr[6] = String.valueOf(ScreenUtil.px2dip(context, fArr[0]));
                    strArr[7] = String.valueOf(ScreenUtil.px2dip(context, fArr2[0]));
                    motionEvent2 = motionEventObtain2;
                    try {
                        motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis2 + 100, 1, fNextFloat, fNextFloat2, 0);
                        viewGroup.dispatchTouchEvent(motionEventObtain);
                        float x = motionEventObtain.getX();
                        float y = motionEventObtain.getY();
                        strArr2[0] = String.valueOf(System.currentTimeMillis());
                        strArr2[1] = String.valueOf(System.currentTimeMillis());
                        strArr2[2] = String.valueOf((int) (viewGroup.getTop() + x));
                        strArr2[3] = String.valueOf((int) (viewGroup.getLeft() + y));
                        strArr2[4] = String.valueOf((int) x);
                        strArr2[5] = String.valueOf((int) y);
                        strArr2[6] = String.valueOf(ScreenUtil.px2dip(context, x));
                        strArr2[7] = String.valueOf(ScreenUtil.px2dip(context, y));
                        motionEvent2.recycle();
                        motionEventObtain.recycle();
                    } catch (Exception e) {
                        e = e;
                        motionEvent = motionEventObtain;
                        motionEventObtain = motionEvent2;
                        try {
                            com.yfanads.android.adx.utils.a.b("simulateClick exception " + e.getMessage());
                            if (motionEventObtain != null) {
                                motionEventObtain.recycle();
                            }
                            if (motionEvent != null) {
                                motionEvent.recycle();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (motionEventObtain != null) {
                                motionEventObtain.recycle();
                            }
                            if (motionEvent != null) {
                                motionEvent.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        motionEvent = motionEventObtain;
                        motionEventObtain = motionEvent2;
                        if (motionEventObtain != null) {
                            motionEventObtain.recycle();
                        }
                        if (motionEvent != null) {
                            motionEvent.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    motionEvent2 = motionEventObtain2;
                } catch (Throwable th3) {
                    th = th3;
                    motionEvent2 = motionEventObtain2;
                }
            } catch (Exception e3) {
                e = e3;
                motionEvent = null;
            } catch (Throwable th4) {
                th = th4;
                motionEvent = null;
            }
            strArrA = com.yfanads.android.adx.utils.b.a(strArr, strArr2, viewGroup);
        }
        com.yfanads.android.adx.utils.a.a("onClick = " + Arrays.toString(strArrA) + " , " + Arrays.toString(this.e));
        reportAdInfo(1, strArrA);
        boolean zIsEmpty = map.isEmpty();
        viewGroup.getRootView();
        a(activity, true, interactionConf.showDeepLinkDialog, zIsEmpty, true, interactionConf.npd, interactionConf.npdw);
    }

    public final void a(final Activity activity, ViewGroup viewGroup, final View view, Integer num, final AdxNativeAd.InteractionConf interactionConf, final boolean z) {
        this.d = num.intValue();
        com.yfanads.android.adx.components.model.a aVar = new com.yfanads.android.adx.components.model.a(viewGroup, num.intValue(), this.i, interactionConf.isd, interactionConf.istvp, interactionConf.isActionOne, new com.yfanads.android.adx.interact.a.InterfaceC1172a() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda3
            @Override // com.yfanads.android.adx.interact.a.InterfaceC1172a
            public final void a(int i, String[] strArr) {
                this.f$0.a(activity, view, interactionConf, z, i, strArr);
            }
        });
        this.k = aVar;
        com.yfanads.android.adx.components.base.a aVar2 = com.yfanads.android.adx.components.base.a.C1170a.f9566a;
        com.yfanads.android.adx.service.a aVar3 = this.i;
        aVar2.getClass();
        com.yfanads.android.adx.components.base.b bVar = new com.yfanads.android.adx.components.base.b(aVar2, aVar3);
        bVar.a(aVar.f9576a);
        aVar.h = bVar;
        aVar2.f9565a.put(Integer.valueOf(aVar.f9576a.hashCode()), aVar);
        com.yfanads.android.adx.utils.a.c("ActionHelper registerViewAction ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, View view, AdxNativeAd.InteractionConf interactionConf, boolean z, int i, String[] strArr) {
        reportAdInfo(i == 1 ? 22 : 23, strArr);
        a(activity, false, interactionConf.showDeepLinkDialog, z, false, interactionConf.npd, interactionConf.npdw);
    }

    public final void a(final Activity activity, final ViewGroup viewGroup, boolean z, final boolean z2, final View view, Integer num, final AdxNativeAd.InteractionConf interactionConf, final boolean z3) {
        this.d = num.intValue();
        viewGroup.getTop();
        viewGroup.getLeft();
        final com.yfanads.android.adx.interact.c cVar = new com.yfanads.android.adx.interact.c();
        cVar.g = new com.yfanads.android.adx.interact.c.a() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.adx.interact.c.a
            public final void a(String[] strArr, String[] strArr2) {
                this.f$0.a(viewGroup, activity, view, interactionConf, z3, strArr, strArr2);
            }
        };
        view.setOnTouchListener(cVar);
        if (z) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.a(cVar, viewGroup, activity, view, z2, z3, interactionConf, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Activity activity, View view, AdxNativeAd.InteractionConf interactionConf, boolean z, String[] strArr, String[] strArr2) {
        if (com.yfanads.android.adx.utils.b.b()) {
            com.yfanads.android.adx.utils.a.a("NativeAdImpl onSlideAction = " + Arrays.toString(strArr) + " , " + Arrays.toString(strArr2) + " , " + Arrays.toString(this.e));
            reportAdInfo(24, com.yfanads.android.adx.utils.b.a(strArr, strArr2, viewGroup));
            a(activity, false, interactionConf.showDeepLinkDialog, z, true, interactionConf.npd, interactionConf.npdw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.yfanads.android.adx.interact.c cVar, ViewGroup viewGroup, Activity activity, View view, boolean z, boolean z2, AdxNativeAd.InteractionConf interactionConf, View view2) {
        if (com.yfanads.android.adx.utils.b.b()) {
            if (!this.o) {
                this.o = true;
                float fCurrentTimeMillis = System.currentTimeMillis();
                String[] strArr = new String[4];
                long jCurrentTimeMillis = System.currentTimeMillis();
                strArr[0] = String.valueOf(jCurrentTimeMillis);
                strArr[1] = String.valueOf(jCurrentTimeMillis / 1000);
                int iNextInt = (int) (jCurrentTimeMillis - fCurrentTimeMillis);
                if (iNextInt < 100) {
                    iNextInt = new Random().nextInt(81) + 100;
                }
                strArr[2] = String.valueOf(iNextInt);
                strArr[3] = "100";
                reportAdInfo(0, strArr);
            }
            String[][] strArr2 = {cVar.e, cVar.f};
            com.yfanads.android.adx.utils.a.a("NativeAdImpl onClick =  , " + Arrays.toString(strArr2));
            reportAdInfo(1, com.yfanads.android.adx.utils.b.a(strArr2[0], strArr2[1], viewGroup));
            a(activity, false, z, z2, true, interactionConf.npd, interactionConf.npdw);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0073  */
    /* JADX WARN: Code duplicated, block: B:86:0x0243  */
    public final void a(Activity activity, final boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        String str3;
        String str4;
        int i;
        boolean z5;
        com.yfanads.android.adx.router.b.a aVar;
        boolean zSendReq;
        YFOptional.ofNullable(this.f9586a).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda6
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                this.f$0.a(z, (AdxNativeAd.AdInteractionListener) obj);
            }
        });
        AdxSdkConfig adxSdkConfig = com.yfanads.android.adx.service.d.c;
        String str5 = "";
        if (adxSdkConfig != null) {
            str4 = adxSdkConfig.wxAppId;
            str3 = adxSdkConfig.appPageName;
        } else {
            str3 = "";
            str4 = str3;
        }
        com.yfanads.android.adx.router.b bVar = new com.yfanads.android.adx.router.b();
        bVar.n = this.p;
        bVar.f9613a = getDeepLink();
        bVar.e = z2;
        bVar.f = z3;
        bVar.g = getAppName();
        NativeSourceNew nativeSourceNew = this.c;
        bVar.j = (nativeSourceNew == null || !nativeSourceNew.hasAd()) ? "" : this.c.ad.intent;
        bVar.h = getAppPackageName();
        bVar.i = str3;
        bVar.b = a();
        NativeSourceNew nativeSourceNew2 = this.c;
        if (nativeSourceNew2 == null || !nativeSourceNew2.hasAd()) {
            i = 0;
        } else {
            int i2 = this.c.ad.action;
            if (i2 == 2) {
                i = 1;
            } else if (i2 != 3) {
                i = 0;
            } else {
                i = 2;
            }
        }
        bVar.c = i;
        NativeSourceNew nativeSourceNew3 = this.c;
        bVar.l = (nativeSourceNew3 == null || !nativeSourceNew3.hasAd()) ? "" : this.c.ad.wxProgramId;
        NativeSourceNew nativeSourceNew4 = this.c;
        if (nativeSourceNew4 != null && nativeSourceNew4.hasAd()) {
            str5 = this.c.ad.wxProgramPath;
        }
        bVar.m = str5;
        bVar.k = str4;
        bVar.o = str;
        bVar.p = str2;
        bVar.d = new c(this, activity, z, z4);
        com.yfanads.android.adx.service.a aVar2 = this.i;
        if (activity == null) {
            com.yfanads.android.adx.utils.a.b("navigation is null, return.");
            bVar.a(false, new boolean[0]);
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        YFLog.high("navigation " + bVar.c + " , " + aVar2);
        if (!TextUtils.isEmpty(bVar.j) && bVar.j.startsWith("hwpps://landingpage")) {
            YFLog.high("doHWPps intent=" + bVar.j);
            Intent intent = new Intent();
            intent.setData(Uri.parse(bVar.j));
            intent.addFlags(268435456);
            try {
                origApplicationContext.startActivity(intent);
                com.yfanads.android.adx.utils.a.c("navigation hw pps");
                bVar.a(true, new boolean[0]);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                com.yfanads.android.adx.utils.a.b("navigation hw pps error " + th.getMessage());
            }
        }
        if (bVar.a(activity, origApplicationContext, aVar2)) {
            return;
        }
        if (bVar.c == 2) {
            bVar.a(1, 1, new String[0]);
            Context origApplicationContext2 = StubApp.getOrigApplicationContext(activity.getApplicationContext());
            String str6 = bVar.k;
            String str7 = bVar.l;
            String str8 = bVar.m;
            try {
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7) && ReflectionUtils.hasMethod("com.tencent.mm.opensdk.openapi.IWXAPI")) {
                    IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(origApplicationContext2, str6);
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = str7;
                    req.path = str8;
                    req.miniprogramType = 0;
                    zSendReq = iwxapiCreateWXAPI.sendReq(req);
                } else {
                    YFLog.high("skipWxMiniApp ha no IWXAPI, return.");
                    zSendReq = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                YFLog.high("skipWxMiniApp exception " + e.getMessage());
            }
            YFLog.high("navigation isWxResult " + zSendReq);
            bVar.a(1, zSendReq ? 4 : 5, new String[0]);
            bVar.a(zSendReq, new boolean[0]);
            return;
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            YFLog.high("navigation open dUrl " + bVar.b + "- " + bVar.c);
            int i3 = bVar.c;
            if (i3 == 0) {
                boolean zA = bVar.a(activity);
                YFLog.high("navigation open url isOpenSuc " + zA);
                bVar.a(zA, new boolean[0]);
                return;
            } else {
                if (i3 == 1) {
                    boolean z6 = bVar.f;
                    if (TextUtils.isEmpty(bVar.b) || (aVar = bVar.d) == null) {
                        z5 = false;
                    } else {
                        c cVar = (c) aVar;
                        if (cVar.get() == null || !a(cVar.get(), z6, cVar.f9588a.get())) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                    }
                    YFLog.high("navigation download " + z5);
                    bVar.a(z5, true);
                    return;
                }
                bVar.a(false, new boolean[0]);
                return;
            }
        }
        bVar.a(false, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, AdxNativeAd.AdInteractionListener adInteractionListener) {
        this.f9586a.onHandleClick(z);
    }

    public static boolean a(NativeAdImpl nativeAdImpl, boolean z, Activity activity) {
        if (nativeAdImpl.c != null && activity != null) {
            return nativeAdImpl.a(z, activity);
        }
        com.yfanads.android.adx.utils.a.b("Download parameter is empty or activity is null, return.");
        return false;
    }

    public final boolean a(boolean z, Activity activity) {
        com.yfanads.android.adx.utils.a.a("startRealDownload " + a());
        if (z) {
            NativeSourceNew nativeSourceNew = this.c;
            if (nativeSourceNew != null && nativeSourceNew.isAppDownload()) {
                NativeSourceNew.Download download = this.c.ad.download;
                String str = download.Url;
                String str2 = download.appIconUrl;
                String str3 = download.appName;
                long j = download.fileSize;
                String strB = com.yfanads.android.adx.utils.b.b(str);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                d();
                if (com.yfanads.android.adx.utils.b.a(2, str)) {
                    com.yfanads.android.adx.utils.a.a("APK already exists");
                    reportAdInfo(5, null);
                    com.yfanads.android.adx.utils.b.c(strB);
                    AdxNativeAd.AdInteractionListener adInteractionListener = this.f9586a;
                    if (adInteractionListener != null) {
                        adInteractionListener.onDownloadTipsDismiss();
                    }
                } else {
                    com.yfanads.android.adx.utils.a.a("APK not downloaded or not completed");
                    reportAdInfo(3, null);
                    ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
                    DownloaderMgr.b.f9596a.a(str, str2, str3, j, new f(this, strB));
                }
                return true;
            }
            com.yfanads.android.adx.utils.a.b("startDownload error, it's not app download.");
            return false;
        }
        return a(activity);
    }

    public final void a(final Activity activity, final View view, final boolean z, final boolean z2, final ViewGroup viewGroup, final String str, final String str2) {
        final String[] strArr = new String[8];
        final String[] strArr2 = new String[8];
        final float[] fArr = new float[1];
        final float[] fArr2 = new float[1];
        final long[] jArr = new long[1];
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.a(fArr, fArr2, jArr, strArr, view, activity, strArr2, viewGroup, z, z2, str, str2, view2, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float[] fArr, float[] fArr2, long[] jArr, String[] strArr, View view, Activity activity, String[] strArr2, ViewGroup viewGroup, boolean z, boolean z2, String str, String str2, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            fArr[0] = motionEvent.getX();
            fArr2[0] = motionEvent.getY();
            jArr[0] = System.currentTimeMillis();
            strArr[0] = String.valueOf(System.currentTimeMillis());
            strArr[1] = String.valueOf(System.currentTimeMillis());
            strArr[2] = String.valueOf((int) (fArr[0] + view.getTop()));
            strArr[3] = String.valueOf((int) (fArr2[0] + view.getLeft()));
            strArr[4] = String.valueOf((int) fArr[0]);
            strArr[5] = String.valueOf((int) fArr2[0]);
            strArr[6] = String.valueOf(ScreenUtil.px2dip(activity, fArr[0]));
            strArr[7] = String.valueOf(ScreenUtil.px2dip(activity, fArr2[0]));
        } else if (action == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            strArr2[0] = String.valueOf(System.currentTimeMillis());
            strArr2[1] = String.valueOf(System.currentTimeMillis());
            strArr2[2] = String.valueOf((int) (view.getTop() + x));
            strArr2[3] = String.valueOf((int) (view.getLeft() + y));
            strArr2[4] = String.valueOf((int) x);
            strArr2[5] = String.valueOf((int) y);
            strArr2[6] = String.valueOf(ScreenUtil.px2dip(activity, x));
            strArr2[7] = String.valueOf(ScreenUtil.px2dip(activity, y));
            long jCurrentTimeMillis = System.currentTimeMillis();
            float fAbs = Math.abs(x - fArr[0]);
            float fAbs2 = Math.abs(y - fArr2[0]);
            long j = jCurrentTimeMillis - jArr[0];
            if (fAbs < 5.0f && fAbs2 < 5.0f && j < 200) {
                if (!com.yfanads.android.adx.utils.b.b()) {
                    YFLog.debug("is double click, return.");
                    return true;
                }
                com.yfanads.android.adx.utils.a.a("onClick = " + Arrays.toString(strArr) + " , " + Arrays.toString(strArr2) + " , " + Arrays.toString(this.e));
                if (!this.o) {
                    this.o = true;
                    float fCurrentTimeMillis = System.currentTimeMillis();
                    String[] strArr3 = new String[4];
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    strArr3[0] = String.valueOf(jCurrentTimeMillis2);
                    strArr3[1] = String.valueOf(jCurrentTimeMillis2 / 1000);
                    int iNextInt = (int) (jCurrentTimeMillis2 - fCurrentTimeMillis);
                    if (iNextInt < 100) {
                        iNextInt = new Random().nextInt(81) + 100;
                    }
                    strArr3[2] = String.valueOf(iNextInt);
                    strArr3[3] = "100";
                    reportAdInfo(0, strArr3);
                }
                reportAdInfo(1, com.yfanads.android.adx.utils.b.a(strArr, strArr2, viewGroup));
                a(activity, false, z, z2, true, str, str2);
            } else {
                com.yfanads.android.adx.utils.a.a("onSlide " + fAbs + "|" + fAbs2 + "|" + j + "|" + view);
            }
        }
        return true;
    }

    public final String a() {
        NativeSourceNew nativeSourceNew = this.c;
        if (nativeSourceNew != null && nativeSourceNew.hasAd()) {
            NativeSourceNew nativeSourceNew2 = this.c;
            if (nativeSourceNew2 != null && nativeSourceNew2.hasAd() && this.c.ad.action == 2) {
                if (this.c.isAppDownload()) {
                    return this.c.ad.download.Url;
                }
            } else {
                if (!TextUtils.isEmpty(this.c.ad.landingUrl)) {
                    return this.c.ad.landingUrl;
                }
                if (this.c.isAppDownload()) {
                    return this.c.ad.download.Url;
                }
            }
        }
        return "";
    }

    public final String[] a(int i) {
        String[] strArr = new String[0];
        switch (i) {
            case 0:
                return b() ? this.c.getMonitor().exposureUrls : strArr;
            case 1:
            case 22:
            case 23:
            case 24:
                return b() ? this.c.getMonitor().clickUrls : strArr;
            case 2:
            case 7:
            case 16:
            case 17:
            default:
                return strArr;
            case 3:
                return b() ? this.c.getMonitor().downloadStartUrls : strArr;
            case 4:
                return b() ? this.c.getMonitor().downloadSuccessUrls : strArr;
            case 5:
                return b() ? this.c.getMonitor().installStartUrls : strArr;
            case 6:
                return b() ? this.c.getMonitor().installSuccessUrls : strArr;
            case 8:
                return b() ? this.c.getMonitor().dplturls : strArr;
            case 9:
                return b() ? this.c.getMonitor().dplsurls : strArr;
            case 10:
                return b() ? this.c.getMonitor().dplFailedUrls : strArr;
            case 11:
                return b() ? this.c.getMonitor().playStartUrls : strArr;
            case 12:
                return b() ? this.c.getMonitor().playOneQuarterUrls : strArr;
            case 13:
                return b() ? this.c.getMonitor().playOneHalfUrls : strArr;
            case 14:
                return b() ? this.c.getMonitor().playThreeQuarterUrls : strArr;
            case 15:
                return b() ? this.c.getMonitor().playEndUrls : strArr;
            case 18:
                return b() ? this.c.getMonitor().playCloseUrls : strArr;
            case 19:
                return b() ? this.c.getMonitor().winUrls : strArr;
            case 20:
                return b() ? this.c.getMonitor().dplInstalledUrls : strArr;
            case 21:
                return b() ? this.c.getMonitor().dplUnInstalledUrls : strArr;
        }
    }

    public final boolean a(Activity activity) {
        if (YFUtil.isActivityDestroyed(activity)) {
            com.yfanads.android.adx.utils.a.b("startDownload dialog, but isActivityDestroyed, return.");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("nativeSource", this.c);
        com.yfanads.android.adx.download.dialog.b bVar = new com.yfanads.android.adx.download.dialog.b(new NativeAdImpl$$ExternalSyntheticLambda5(this));
        this.n = bVar;
        bVar.a(activity, bundle, new com.yfanads.android.adx.download.dialog.b.InterfaceC1171b() { // from class: com.yfanads.android.adx.core.impl.NativeAdImpl$$ExternalSyntheticLambda10
            @Override // com.yfanads.android.adx.download.dialog.b.InterfaceC1171b
            public final void onDismiss() {
                this.f$0.c();
            }
        });
        d();
        this.m = true;
        AdxNativeAd.AdInteractionListener adInteractionListener = this.f9586a;
        if (adInteractionListener != null) {
            adInteractionListener.onDownloadTipsShow();
        }
        return true;
    }

    public final void a(int[] iArr) {
        if (iArr == null) {
            return;
        }
        for (int i : iArr) {
            reportAdInfo(i, null);
        }
    }
}

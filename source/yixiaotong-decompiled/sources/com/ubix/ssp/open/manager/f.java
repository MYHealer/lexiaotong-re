package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.j;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.video.UBiXRewardInfo;
import com.ubix.ssp.open.video.UBiXRewardVideoAdListener;
import com.ubix.ssp.open.video.UBiXRewardVideoExtra;
import com.ubix.ssp.open.video.UBiXRewardVideoManager;
import java.util.HashMap;
import java.util.UUID;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements UBiXRewardVideoManager, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9067a = "f";
    private String b;
    private com.ubix.ssp.ad.k.b c;
    private Activity d;
    private int e = 0;

    class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXRewardVideoAdListener f9068a;

        /* JADX INFO: renamed from: com.ubix.ssp.open.manager.f$a$a, reason: collision with other inner class name */
        class C1127a implements UBiXRewardInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f9069a;
            final /* synthetic */ int b;
            final /* synthetic */ String c;
            final /* synthetic */ AdError d;

            C1127a(String str, int i, String str2, AdError adError) {
                this.f9069a = str;
                this.b = i;
                this.c = str2;
                this.d = adError;
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardInfo
            public AdError getError() {
                return this.d;
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardInfo
            public String getExtra() {
                return this.c;
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardInfo
            public int getRewardAmount() {
                return this.b;
            }

            @Override // com.ubix.ssp.open.video.UBiXRewardInfo
            public String getRewardName() {
                return this.f9069a;
            }
        }

        a(UBiXRewardVideoAdListener uBiXRewardVideoAdListener) {
            this.f9068a = uBiXRewardVideoAdListener;
        }

        @Override // com.ubix.ssp.ad.g.j
        public void a(boolean z, String str, int i, String str2, AdError adError) {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoRewardVerify in");
                this.f9068a.onVideoRewardVerify(z, new C1127a(str, i, str2, adError));
            }
            u.e(f.f9067a, "onVideoRewardVerify out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onAdClosed() {
            if (f.this.d != null) {
                f.this.d.finish();
            }
            if (this.f9068a != null) {
                u.e(f.f9067a, "onAdClosed in");
                this.f9068a.onAdClosed();
            }
            u.e(f.f9067a, "onAdClosed out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onAdExposed() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onAdExposed in");
                this.f9068a.onAdExposed();
            }
            u.e(f.f9067a, "onAdExposed out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onAdLoadSucceed() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onAdLoadSucceed in");
                this.f9068a.onAdLoadSucceed();
            }
            u.e(f.f9067a, "onAdLoadSucceed out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onError(AdError adError) {
            if (this.f9068a != null) {
                u.c(f.f9067a, "onError in");
                this.f9068a.onError(adError);
            }
            u.c(f.f9067a, "onError out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onVideoCached() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoCached in");
                this.f9068a.onVideoCached();
            }
            u.e(f.f9067a, "onVideoCached out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onVideoClicked() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoClicked in");
                this.f9068a.onVideoClicked();
            }
            u.e(f.f9067a, "onVideoClicked out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onVideoPlayCompleted() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoPlayCompleted in");
                this.f9068a.onVideoPlayCompleted();
            }
            u.e(f.f9067a, "onVideoPlayCompleted out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onVideoPlayStarted() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoPlayStarted in");
                this.f9068a.onVideoPlayStarted();
            }
            u.e(f.f9067a, "onVideoPlayStarted out");
        }

        @Override // com.ubix.ssp.ad.g.j
        public void onVideoRewarded() {
            if (this.f9068a != null) {
                u.e(f.f9067a, "onVideoRewarded in");
                this.f9068a.onVideoRewarded();
            }
            u.e(f.f9067a, "onVideoRewarded out");
        }
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void destroy() {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.h();
            u.e(f9067a, "destroy");
        }
        this.d = null;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar == null) {
            u.e(f9067a, "getBiddingToken:null");
            return null;
        }
        String strB = bVar.B();
        u.f("getBiddingToken:" + strB);
        return strB;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public ParamsReview getParamsReview() {
        if (this.c != null) {
            u.e(f9067a, "getParamsReview:" + this.c.C());
            return this.c.C();
        }
        u.e(f9067a, "getParamsReview: return null");
        return null;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public long getPrice() {
        if (this.c != null) {
            u.e(f9067a, "getPrice:" + this.c.D());
            return this.c.D();
        }
        u.e(f9067a, "getPrice: return 0");
        return 0L;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public String getTransId() {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            return bVar.F();
        }
        return null;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public boolean isValid() {
        if (this.c != null) {
            u.e(f9067a, "isValid:" + this.c.M());
            return this.c.M();
        }
        u.e(f9067a, "isValid: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public boolean isVideoAd() {
        if (this.c != null) {
            u.e(f9067a, "isVideoAd:" + this.c.N());
            return this.c.N();
        }
        u.e(f9067a, "isVideoAd: return false");
        return false;
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void loadAd() {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.O();
            u.e(f9067a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void loadBiddingAd(String str) {
        if (this.c != null) {
            u.e(f9067a, "loadBiddingAd adm:" + str);
            this.c.h(str);
        }
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void loadRewardVideoAd(Context context, String str, UBiXRewardVideoAdListener uBiXRewardVideoAdListener) {
        loadRewardVideoAd(context, str, null, uBiXRewardVideoAdListener);
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void loadRewardVideoAd(Context context, String str, UBiXRewardVideoExtra uBiXRewardVideoExtra, UBiXRewardVideoAdListener uBiXRewardVideoAdListener) {
        if (u.a()) {
            String str2 = f9067a;
            u.e(str2, "slot id:" + str + "   listener is null:" + (uBiXRewardVideoAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        com.ubix.ssp.ad.k.b bVar = new com.ubix.ssp.ad.k.b(context, str);
        this.c = bVar;
        bVar.a(uBiXRewardVideoExtra);
        this.c.a((j) new a(uBiXRewardVideoAdListener));
        this.b = UUID.randomUUID().toString();
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        if (uBiXAdLossInfo == null) {
            u.e(f9067a, "lossInfo is empty");
            return;
        }
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.b(uBiXAdLossInfo.getInfo());
            u.e(f9067a, "lossNotice");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getComponentName().getClassName().equals("com.ubix.ssp.open.comm.UBiXVideoActivity") && this.b.equals(activity.getIntent().getStringExtra("uniqueId"))) {
            this.d = activity;
            try {
                u.e("onActivityCreated " + activity);
                this.c.a(this.d);
                if (this.c.G().getParent() != null) {
                    ((ViewGroup) this.c.G().getParent()).removeView(this.c.G());
                }
                LinearLayout linearLayout = new LinearLayout(activity);
                activity.setContentView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
                int i = this.e;
                if (i == 0) {
                    this.d.setRequestedOrientation(1);
                } else if (i == 1) {
                    this.d.setRequestedOrientation(0);
                } else if (i == 2) {
                    this.d.setRequestedOrientation(9);
                } else if (i == 3) {
                    this.d.setRequestedOrientation(8);
                }
                linearLayout.addView(this.c.G());
                try {
                    Window window = activity.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.clearFlags(67108864);
                    window.setStatusBarColor(0);
                    window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Activity activity2 = this.d;
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            if (activity == this.d) {
                com.ubix.ssp.ad.k.b bVar = this.c;
                if (bVar != null) {
                    bVar.h();
                    u.e(f9067a, "onActivityDestroyed");
                }
                this.d.getApplication().unregisterActivityLifecycleCallbacks(this);
                this.d = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void setExtraInfo(HashMap<String, String> map) {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.a(map);
            u.e(f9067a, "setExtraInfo");
        }
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void showRewardVideo(Activity activity) {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.x();
            u.e(f9067a, "showRewardVideo:ShowStart");
        }
        if (activity == null) {
            AdError adErrorB = com.ubix.ssp.ad.e.a0.a0.a.b(4, "Activity/Context为空");
            this.c.e(adErrorB);
            u.c(f9067a, "showRewardVideo:ShowError:ErrorCode:" + adErrorB.getErrorCode() + "   ErrorMessage:" + adErrorB.getErrorMessage());
        } else {
            this.e = activity.getWindowManager().getDefaultDisplay().getRotation();
            activity.getApplication().registerActivityLifecycleCallbacks(this);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(activity.getPackageName(), "com.ubix.ssp.open.comm.UBiXVideoActivity"));
            intent.putExtra("uniqueId", this.b);
            activity.startActivity(intent);
        }
    }

    @Override // com.ubix.ssp.open.video.UBiXRewardVideoManager
    public void winNotice(long j) {
        com.ubix.ssp.ad.k.b bVar = this.c;
        if (bVar != null) {
            bVar.a(j);
            u.e(f9067a, "winNotice");
        }
    }
}

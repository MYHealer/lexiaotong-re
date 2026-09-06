package com.ubixnow.ooooo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00o00 implements Application.ActivityLifecycleCallbacks {
    private static final List<String> OooO00o;
    private static int OooO0O0;
    private List<Activity> OooO0OO = new ArrayList();
    private OooO00o OooO0Oo;
    private o0OO0O0.OooOO0 OooO0o;
    private WeakReference<OooO0O0> OooO0o0;

    public interface OooO00o {
        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);
    }

    public interface OooO0O0 {
        void OooO00o(Activity activity);
    }

    static {
        ArrayList arrayList = new ArrayList();
        OooO00o = arrayList;
        arrayList.add("MobRewardVideoActivity");
        arrayList.add("UBiXVideoActivity");
        arrayList.add("common.AdActivity");
        arrayList.add("mobad.activity.VideoActivity");
        arrayList.add("com.qq.e.ads.PortraitADActivity");
        arrayList.add("com.qq.e.ads.LandscapeADActivity");
        arrayList.add("KSRewardLandScapeVideoActivity");
        arrayList.add("InciteADActivity");
        arrayList.add("HRRewardVideoPlayerActivity");
        arrayList.add("HRNativeInterstitialActivity");
        arrayList.add("ATPortraitActivity");
        arrayList.add("ATLandscapeActivity");
        arrayList.add("ATPortraitTranslucentActivity");
        arrayList.add("ATLandscapeTranslucentActivity");
        arrayList.add("app.FeedDownloadActivity");
        arrayList.add("KsRewardVideoActivity");
        arrayList.add("PtgInteractionActivity");
        arrayList.add("PtgInteractionPortraitActivity");
        arrayList.add("PtgInteractionLandscapeActivity");
        arrayList.add("PtgRewardVideoPortraitActivity");
        arrayList.add("PtgRewardVideoLandscapeActivity");
        arrayList.add("com.shu.priory.templatead.ad.RewardPortraitADActivity");
        arrayList.add("com.shu.priory.templatead.ad.RewardLandscapeADActivity");
        arrayList.add("WMLandscapeActivity");
        arrayList.add("WMPortraitActivity");
        arrayList.add("UMNCustomRewardVideoActivity");
        arrayList.add("WfTranslucentNoTitleActivity");
        arrayList.add("WfNoTitleActivity");
        arrayList.add("Stub_Standard_Portrait_Activity");
        arrayList.add("Stub_Standard_Landscape_Activity");
        arrayList.add("TTFullScreenVideoActivity");
        arrayList.add("TTFullScreenVideoLandscapeActivity");
        arrayList.add("TTRewardVideoActivity");
        arrayList.add("TTRewardVideoLandscapeActivity");
    }

    public List<Activity> OooO00o() {
        return this.OooO0OO;
    }

    public void OooO00o(OooO00o oooO00o) {
        this.OooO0Oo = oooO00o;
    }

    public void OooO00o(OooO0O0 oooO0O0) {
        this.OooO0o0 = new WeakReference<>(oooO0O0);
    }

    public void OooO00o(o0OO0O0.OooOO0 oooOO0) {
        this.OooO0o = oooOO0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            ooooO000.OooO00o("-------ActLifecycle", "---onActivityCreated-name " + activity.getLocalClassName());
            Iterator<String> it = OooO00o.iterator();
            while (it.hasNext()) {
                if (activity.getLocalClassName().contains(it.next())) {
                    ooooO000.OooO00o("-------ActLifecycle", "---onActivityCreated-add list ");
                    this.OooO0OO.add(activity);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        OooO0O0 = activity.hashCode();
        this.OooO0OO.remove(activity);
        if (this.OooO0Oo != null) {
            this.OooO0Oo = null;
        }
        o0OO0O0.OooOO0 oooOO0 = this.OooO0o;
        if (oooOO0 != null) {
            oooOO0.OooO00o(activity);
            this.OooO0o = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ooooO000.OooO00o("-------ActLifecycle", "---onActivityPaused--name " + activity.getLocalClassName());
        OooO0O0 = 0;
        OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            oooO00o.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ooooO000.OooO00o("-------ActLifecycle", "---onActivityResumed--name " + activity.getLocalClassName());
        OooO00o oooO00o = this.OooO0Oo;
        if (oooO00o != null) {
            oooO00o.onActivityResumed(activity);
        }
        if (this.OooO0o0 == null || OooO0O0 != activity.hashCode() || this.OooO0o0.get() == null) {
            return;
        }
        this.OooO0o0.get().OooO00o(activity);
        this.OooO0o0 = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (OooO0O0 != activity.hashCode()) {
            OooO0O0 = 0;
        }
        ooooO000.OooO00o("-------ActLifecycle", "---onActivityStarted--name " + activity.getLocalClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ooooO000.OooO00o("-------ActLifecycle", "---onActivityStopped--name " + activity.getLocalClassName());
        OooO0O0 = activity.hashCode();
    }
}

package com.hihonor.adsdk.reward;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.api.reward.RewardItem;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.g.j.d.g;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.widget.base.e;
import com.hihonor.adsdk.common.f.h;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.hihonor.adsdk.reward.e.d;
import com.hihonor.adsdk.reward.e.o;
import com.hihonor.adsdk.reward.e.x;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RewardActivity extends com.hihonor.adsdk.base.widget.base.a implements x {
    private static final String l = "RewardActivity";
    private static final String m = "info";
    private static final String n = "reward";
    private static final String o = "KEY_REWARD_ALREADY";
    private static AdListener p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseAd f3553a;
    private Video b;
    private final e c = new e();
    private String d;
    private FrameLayout e;
    private int f;
    private AlertDialog g;
    private AlertDialog h;
    private o i;
    private com.hihonor.adsdk.reward.e.c j;
    private com.hihonor.adsdk.reward.e.a k;

    class a implements com.hihonor.adsdk.reward.e.e.a {
        a() {
        }

        @Override // com.hihonor.adsdk.reward.e.e.a
        public void a() {
            if (RewardActivity.this.k != null) {
                RewardActivity.this.k.c(RewardActivity.this.j);
            }
        }

        @Override // com.hihonor.adsdk.reward.e.e.a
        public void b() {
            RewardActivity.this.f();
        }
    }

    public static void a(AdListener adListener) {
        p = adListener;
    }

    private void d() {
        View viewA;
        FrameLayout frameLayout;
        com.hihonor.adsdk.reward.e.c cVarA = this.k.a(this);
        this.j = cVarA;
        if (cVarA == null || (viewA = cVarA.a()) == null || (frameLayout = this.e) == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.e.addView(viewA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (h.hnadsa(this)) {
            finish();
        }
    }

    private void g() {
        if (this.b.getOrientation() == 1) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
        c.a(getWindow());
        this.k = b.a(this.f3553a);
    }

    private void h() {
        this.k.a(this.j, p, this.i, this);
    }

    private void i() {
        com.hihonor.adsdk.common.b.b.hnadsc(l, "call init exposure id", new Object[0]);
        if (this.f3553a != null) {
            this.d = this.f3553a.getRequestId() + this.f3553a.getAdId();
            com.hihonor.adsdk.common.b.b.hnadsc(l, "init exposure id： " + this.d, new Object[0]);
        }
    }

    private void k() {
        if (!Objects.nonNull(this.f3553a) || j()) {
            return;
        }
        if (this.f3553a.getTrackUrl() != null) {
            t tVar = new t(ErrorCode.AD_SHOW_FAIL_REWARD, this.i.b());
            BaseAd baseAd = this.f3553a;
            tVar.hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
        }
        new s0(ErrorCode.AD_SHOW_FAIL_REWARD, this.i.b(), this.f3553a.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3553a)).hnadsa("code", String.valueOf(this.i.a())).hnadse();
    }

    private void l() {
        com.hihonor.adsdk.reward.e.e eVar = new com.hihonor.adsdk.reward.e.e(this, this.f3553a, this.i.d(), this.i.c(), new a());
        this.h = eVar;
        eVar.show();
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        com.hihonor.adsdk.common.b.b.hnadsc(l, "OnAdsCreate", new Object[0]);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.i = new o();
        if (a(safeIntent)) {
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.i1.a(this.f3553a.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3553a)).hnadsa("type", "2").hnadsa(com.hihonor.adsdk.base.g.j.e.a.R0, "1").hnadsa(com.hihonor.adsdk.base.g.j.e.a.Y0, this.i.e()).hnadse();
        requestWindowFeature(1);
        setContentView(R.layout.honor_ads_reward_contain);
        this.e = (FrameLayout) findViewById(R.id.container);
        int i = 1 ^ (u.hnadsc((Context) this) ? 1 : 0);
        boolean zIsInMultiWindowMode = isInMultiWindowMode();
        this.f = getResources().getConfiguration().screenLayout;
        g();
        d();
        com.hihonor.adsdk.common.b.b.hnadsc(l, "screenRotation:" + i + "; mVideo.getOrientation():" + this.b.getOrientation() + "; isInMultiWindowMode = " + zIsInMultiWindowMode, new Object[0]);
        if (i == this.b.getOrientation() || zIsInMultiWindowMode) {
            h();
        }
    }

    protected boolean j() {
        boolean zHnadsb = com.hihonor.adsdk.base.g.e.hnadsb(this.d);
        com.hihonor.adsdk.common.b.b.hnadsc(l, "Call isExposure. result: " + zHnadsb, new Object[0]);
        return zHnadsb;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onConfigurationChanged reward# video page orientation: " + configuration.orientation, new Object[0]);
        if (this.b == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onConfigurationChanged reward# video is null.", new Object[0]);
            return;
        }
        if (this.f != configuration.screenLayout) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onConfigurationChanged change layout", new Object[0]);
            this.j.a(false);
            d();
            this.f = configuration.screenLayout;
        }
        h();
        AlertDialog alertDialog = this.g;
        if (alertDialog != null && alertDialog.isShowing()) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onConfigurationChanged change finish dialog", new Object[0]);
            this.g.dismiss();
            c();
        }
        AlertDialog alertDialog2 = this.h;
        if (alertDialog2 == null || !alertDialog2.isShowing()) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onConfigurationChanged change retention dialog", new Object[0]);
        this.h.dismiss();
        l();
        com.hihonor.adsdk.reward.e.a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onDestroy", new Object[0]);
        if (Objects.nonNull(p)) {
            p.onAdClosed();
            p = null;
        }
        com.hihonor.adsdk.reward.e.a aVar = this.k;
        if (aVar != null) {
            aVar.b(this.j);
        }
        if (Objects.isNull(this.f3553a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onDestroy but ad is null.", new Object[0]);
            return;
        }
        k();
        if (!this.i.f()) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3553a);
            BaseAd baseAd = this.f3553a;
            new com.hihonor.adsdk.base.g.j.d.j1.e(baseAd, baseAd.getAdUnitId(), aVarHnadsa, this.i.d(), ErrorCode.AD_REWARD_NO_CALL_MEDIA).hnadsa(com.hihonor.adsdk.base.g.j.e.a.Y0, this.i.e()).hnadse();
        }
        this.f3553a.setAdListener(null);
        com.hihonor.adsdk.reward.a.a().hnadsb(this.f3553a.getAdId());
        this.f3553a = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        a();
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.c.hnadsa();
        com.hihonor.adsdk.common.b.b.hnadsc(l, "RewardActivity#onPause", new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.i.a(bundle.getBoolean(o, false));
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onRestoreInstanceState isRewarded: " + this.i.f(), new Object[0]);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.hihonor.adsdk.common.b.b.hnadsc(l, "RewardActivity#onResume", new Object[0]);
        this.c.hnadsb();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onSaveInstanceState isRewarded: " + this.i.f(), new Object[0]);
        bundle.putBoolean(o, this.i.f());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.hihonor.adsdk.common.b.b.hnadsc(l, "hasFocus: " + z, new Object[0]);
        if (z) {
            c.a(getWindow());
        }
        com.hihonor.adsdk.reward.e.a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j, z);
        }
    }

    public static void a(Activity activity, BaseAd baseAd, RewardItem rewardItem) {
        com.hihonor.adsdk.common.b.b.hnadsc(l, "startRewardActivity", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putParcelable("info", baseAd);
        bundle.putParcelable(n, rewardItem);
        f fVarHnadsa = com.hihonor.adsdk.base.j.h.hnadsa(activity, RewardActivity.class, bundle);
        com.hihonor.adsdk.common.b.b.hnadsc(l, "startRewardActivity,result:" + fVarHnadsa, new Object[0]);
        if (fVarHnadsa.hnadsa() != 0) {
            new com.hihonor.adsdk.base.g.j.d.x(baseAd != null ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.Y0, Objects.isNull(rewardItem) ? "1" : "0").hnadse();
        }
    }

    @Override // com.hihonor.adsdk.reward.e.x
    public void b() {
        AlertDialog alertDialog = this.h;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.h.dismiss();
    }

    @Override // com.hihonor.adsdk.reward.e.x
    public void c() {
        d dVar = new d(this, this.f3553a, p, this.c, new d.a() { // from class: com.hihonor.adsdk.reward.RewardActivity$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.reward.e.d.a
            public final void a() {
                this.f$0.e();
            }
        });
        this.g = dVar;
        dVar.show();
    }

    private boolean a(Intent intent) {
        this.f3553a = (BaseAd) intent.getParcelableExtra("info");
        this.i.a((RewardItem) intent.getParcelableExtra(n));
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onCreate,mRewardItem is null?: " + Objects.isNull(this.i.d()), new Object[0]);
        if (Objects.isNull(this.i.d())) {
            this.i.b("1");
        } else {
            this.i.b("0");
        }
        BaseAd baseAd = this.f3553a;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onCreate, but mBaseAd is null", new Object[0]);
            this.i.a(ErrorCode.EX_VIDEO_REWARD_AD_NULL);
            this.i.a(ErrorCode.STR_EX_VIDEO_REWARD_AD_NULL);
            a(ErrorCode.EX_VIDEO_REWARD_AD_NULL, ErrorCode.STR_EX_VIDEO_REWARD_AD_NULL);
            return true;
        }
        this.c.hnadsa(baseAd);
        i();
        AdListener adListener = p;
        if (adListener != null) {
            this.f3553a.setAdListener(adListener);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onCreate, but mAdListener is null", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.x(this.f3553a.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.EX_VIDEO_REWARD_AD_NULL, ErrorCode.STR_EX_VIDEO_REWARD_AD_LISTENER_NULL).hnadse();
        }
        if (this.f3553a.getSubType() != 13) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onCreate, but ad subType not support", new Object[0]);
            this.i.a(ErrorCode.AD_SUB_TYPE_DEFAULT);
            this.i.a(ErrorCode.REPORT_AD_SUB_TYPE_DEFAULT);
            a(ErrorCode.AD_SUB_TYPE_DEFAULT, ErrorCode.REPORT_AD_SUB_TYPE_DEFAULT);
            return true;
        }
        Video video = this.f3553a.getVideo();
        this.b = video;
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(l, "onCreate, but mVideo is null", new Object[0]);
            this.i.a(ErrorCode.EX_VIDEO_REWARD_AD_NULL);
            this.i.a(ErrorCode.STR_EX_VIDEO_REWARD_AD_VIDEO_NULL);
            a(ErrorCode.EX_VIDEO_REWARD_AD_NULL, ErrorCode.STR_EX_VIDEO_REWARD_AD_VIDEO_NULL);
            return true;
        }
        if (Objects.isNull(this.i.d())) {
            this.i.a(new RewardItem(this.b.getRewardingNum(), this.b.getRewardingName()));
        }
        this.i.a(Math.min(this.b.getVideoDuration(), this.b.getRewardingDuration()));
        return false;
    }

    private void a(int i, String str) {
        String adUnitId = Objects.isNull(this.f3553a) ? "" : this.f3553a.getAdUnitId();
        com.hihonor.adsdk.common.b.b.hnadsc(l, "fail on adUnit %s,code is %d and msg is %s", adUnitId, Integer.valueOf(i), str);
        new com.hihonor.adsdk.base.g.j.d.i1.a(adUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3553a)).hnadsa("type", "2").hnadsa(com.hihonor.adsdk.base.g.j.e.a.R0, "2").hnadsa("error_code", String.valueOf(i)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadst, str).hnadsa(com.hihonor.adsdk.base.g.j.e.a.Y0, this.i.e()).hnadse();
        AdListener adListener = p;
        if (adListener != null) {
            adListener.onAdImpressionFailed(i, str);
            p = null;
        }
        finish();
    }

    @Override // com.hihonor.adsdk.reward.e.x
    public void a() {
        if (this.b == null) {
            com.hihonor.adsdk.common.b.b.hnadse(l, "onCloseClick,mVideo is null,finish", new Object[0]);
            finish();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(l, "onCloseClick,isRewarded: " + this.i.f(), new Object[0]);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3553a);
        if (this.i.f()) {
            new g(this.f3553a.getAdUnitId(), aVarHnadsa, "onCloseClick,isRewarded").hnadse();
            finish();
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.g1.c(String.valueOf(2), this.f3553a.getAdUnitId(), aVarHnadsa).hnadse();
        com.hihonor.adsdk.reward.e.a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j);
        }
        l();
    }
}

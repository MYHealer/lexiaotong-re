package com.byazt.md;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.apd.tt;
import com.byazt.ete.ic;
import com.byazt.ete.sv;
import com.byazt.fh.ve;
import com.byazt.nr.da;
import com.byazt.omf.d;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 2384})
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    public static boolean da;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2471a;
    public SaasAuthEnvelope c;
    public int i;
    public ScaleAnimation n;
    public ic sp;
    public BaseSaasEnvelope tt;
    public RotateAnimation uj;
    public ImageView ve;
    public String x;

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.f2471a = false;
        c(context);
    }

    public void c(ic icVar, String str, int i) {
        if (icVar == null || tt.c().ve() != 2) {
            setVisibility(8);
            return;
        }
        sv svVarSl = icVar.sl();
        if (svVarSl == null || ((svVarSl.sl() == null && svVarSl.da() == null) || !svVarSl.i())) {
            setVisibility(8);
            return;
        }
        this.sp = icVar;
        this.x = str;
        this.i = i;
        setBackgroundColor(Color.parseColor("#aa000000"));
        da.tt().postDelayed(this, 5000L);
        c(getContext());
        ve();
    }

    private void c(Context context) {
        this.ve = new ImageView(context);
        try {
            com.byazt.xky.tt.c(ve.c("saas_light_shine.webp")).to(this.ve);
            this.ve.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int iUj = pf.uj(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iUj, iUj);
        layoutParams.addRule(13);
        addView(this.ve, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.c = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.c, layoutParams2);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.md.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.tt();
                da.tt().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.c.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.md.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.c();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() == 0) {
            if (!this.f2471a) {
                da.tt().postDelayed(this, 5000L);
                tt();
                return;
            } else {
                setVisibility(8);
                return;
            }
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.n = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.n.setFillAfter(true);
        this.n.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.md.SaasAuthRewardDialog.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SaasAuthRewardDialog.this.uj = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                SaasAuthRewardDialog.this.uj.setDuration(5000L);
                SaasAuthRewardDialog.this.uj.setRepeatCount(-1);
                SaasAuthRewardDialog.this.uj.setFillAfter(true);
                SaasAuthRewardDialog.this.uj.setInterpolator(new LinearInterpolator());
                SaasAuthRewardDialog.this.ve.startAnimation(SaasAuthRewardDialog.this.uj);
            }
        });
        this.ve.startAnimation(this.n);
        d.tt(true);
        setVisibility(0);
        this.c.c();
        da.tt().postDelayed(this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        this.f2471a = true;
        sv svVarSl = this.sp.sl();
        if (svVarSl.da() != null) {
            this.tt = new SaasAuthCouponEnvelope(getContext(), svVarSl.da());
        } else if (svVarSl.sl() != null) {
            this.tt = new SaasAuthProductEnvelope(getContext(), svVarSl.sl());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.tt;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.tt.c();
            com.byazt.hkv.c cVar = new com.byazt.hkv.c(getContext(), this.sp, this.x, this.i);
            setTag(67108864, 2917);
            com.byazt.rv.c.c().c(this.sp.hashCode() + this.sp.qy()).put("live_saas_interaction_type", 101);
            setOnClickListener(cVar);
            this.tt.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.md.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.c();
                }
            });
            this.tt.setOnButtonClickListener(cVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.c;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.tt();
        }
        removeView(this.c);
    }

    public void c() {
        SaasAuthEnvelope saasAuthEnvelope = this.c;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.tt();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.tt;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.tt();
        }
        RotateAnimation rotateAnimation = this.uj;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.uj = null;
        }
        ScaleAnimation scaleAnimation = this.n;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.n = null;
        }
        da.tt().removeCallbacks(this);
        setVisibility(8);
        d.tt(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.tt(false);
    }

    private void ve() {
        try {
            if (da) {
                return;
            }
            c cVar = new c();
            com.byazt.xky.tt.c(ve.c("saas_light_shine.webp")).to(cVar);
            com.byazt.xky.tt.c(ve.c("saas_red_envelope.webp")).to(cVar);
            com.byazt.xky.tt.c(ve.c("saas_reward_goods_bg.webp")).to(cVar);
            com.byazt.xky.tt.c(ve.c("saas_reward_coupon_bg.webp")).to(cVar);
            com.byazt.xky.tt.c(ve.c("saas_reward_title.webp")).to(cVar);
            da = true;
        } catch (Throwable unused) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 1319})
    private static class c implements gr {
        @Override // com.byazt.yj.gr
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(m mVar) {
        }

        private c() {
        }
    }
}

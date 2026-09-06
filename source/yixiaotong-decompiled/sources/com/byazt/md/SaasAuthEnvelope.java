package com.byazt.md;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.fh.ve;
import com.byazt.nr.z;
import com.byazt.xky.tt;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500})
public class SaasAuthEnvelope extends RelativeLayout {
    public AnimationSet c;
    public ImageView tt;
    public ImageView ve;

    public SaasAuthEnvelope(Context context) {
        super(context);
        c(context);
        setVisibility(8);
    }

    private void c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.ve = new ImageView(context);
        try {
            tt.c(ve.c("saas_red_envelope.webp")).to(this.ve);
        } catch (Error unused) {
        }
        linearLayout.addView(this.ve, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.tt = imageView;
        try {
            z.c(context, "tt_saas_close", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = pf.ve(context, 25.0f);
        linearLayout.addView(this.tt, layoutParams2);
    }

    public void c() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.c = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.c.addAnimation(scaleAnimation);
        startAnimation(this.c);
    }

    public void tt() {
        AnimationSet animationSet = this.c;
        if (animationSet != null) {
            animationSet.cancel();
            this.c = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.tt;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}

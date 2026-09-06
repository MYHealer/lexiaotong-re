package com.byazt.oq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 691})
public class ClickInteractView extends FrameLayout {
    public ImageView c;
    public AnimatorSet tt;

    public ClickInteractView(Context context) {
        super(context);
        ve();
        uj();
    }

    private void ve() {
        this.c = new ImageView(getContext());
        z.c(getContext(), "tt_white_hand", this.c, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        int iC = (int) x.c(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iC, iC);
        layoutParams.gravity = 17;
        addView(this.c, layoutParams);
    }

    private void uj() {
        this.tt = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tt.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void c() {
        AnimatorSet animatorSet = this.tt;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void tt() {
        AnimatorSet animatorSet = this.tt;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}

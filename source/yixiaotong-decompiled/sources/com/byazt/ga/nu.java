package com.byazt.ga;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public final class nu {
    public static Interpolator c(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }
}

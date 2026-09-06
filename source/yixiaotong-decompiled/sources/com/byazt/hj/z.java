package com.byazt.hj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {
    public static Function<SparseArray<Object>, Object> c(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.byazt.rl.ve.ve;
    }

    public static Integer[] c(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}

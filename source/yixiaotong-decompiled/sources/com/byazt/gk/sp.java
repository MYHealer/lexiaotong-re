package com.byazt.gk;

import android.os.Looper;
import android.util.SparseArray;
import com.byazt.nc.u;
import com.byazt.omf.h;
import com.byazt.omf.rh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 148, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends com.byazt.nh.n implements tt {
    public long c;

    @Override // com.byazt.gk.tt
    public long tt() {
        return this.c;
    }

    public sp(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.c = System.currentTimeMillis();
    }

    @Override // com.byazt.nh.n
    public void c(final int i, final String str) {
        if (str == null) {
            str = h.UNKNOWN_ERR_MSG;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(i, str);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    sp.super.c(i, str);
                }
            });
        }
    }

    @Override // com.byazt.nh.n
    public void c(final List<u> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.c(list);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.gk.sp.2
                @Override // java.lang.Runnable
                public void run() {
                    sp.super.c(list);
                }
            });
        }
    }
}

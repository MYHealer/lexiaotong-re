package com.byazt.us;

import android.os.Build;
import com.byazt.gq.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 42})
public class i {
    public static boolean c(com.byazt.dd.c cVar) {
        return com.byazt.i.n.n() && Build.VERSION.SDK_INT < 29 && t.t() != null && t.t().c() && com.byazt.hu.n.c(cVar).tt("invoke_app_form_background_switch") == 1 && cVar.nu();
    }
}

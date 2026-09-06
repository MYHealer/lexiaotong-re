package com.byazt.zo;

import android.content.Context;
import android.view.View;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 20})
public abstract class c {
    public ic c;
    public Context tt;
    public View uj;
    public da ve;

    public abstract int c(Map<String, Object> map, ve veVar);

    public void c(View view) {
        this.uj = view;
    }

    public void c(da daVar) {
        this.ve = daVar;
    }
}

package com.byazt.vm;

import android.content.Context;
import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public final class gt {
    public final SharedPreferences c;

    public gt(Context context) {
        this.c = com.byazt.nys.tt.tt(context, "device_register_oaid_refine", 0);
    }

    public void c(my myVar) {
        if (myVar == null) {
            return;
        }
        this.c.edit().putString("oaid", myVar.tt().toString()).apply();
    }

    public my c() {
        return my.c(this.c.getString("oaid", ""));
    }
}

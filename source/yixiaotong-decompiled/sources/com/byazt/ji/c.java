package com.byazt.ji;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR, 20})
public class c extends tt implements com.byazt.rb.tt {
    public String sl;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Object obj;
        com.byazt.xj.ve veVarA;
        com.byazt.rb.c cVarDa;
        if (this.n == null || this.n.size() <= 0 || (obj = this.n.get("name")) == null) {
            return false;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return false;
        }
        Object obj2 = this.n.get("state");
        if (obj2 != null) {
            this.sl = String.valueOf(obj2);
        }
        com.byazt.xj.ve veVarTt = this.tt.tt(this.tt);
        if (veVarTt != null && (veVarA = veVarTt.a(strValueOf)) != null && (cVarDa = veVarA.da(strValueOf)) != null) {
            cVarDa.c(this);
        }
        return false;
    }

    @Override // com.byazt.rb.tt
    public void c() {
        if ((TextUtils.equals(this.sl, "start") || TextUtils.isEmpty(this.sl)) && this.c != null) {
            this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
        }
    }

    @Override // com.byazt.rb.tt
    public void tt() {
        if ((TextUtils.equals(this.sl, "complete") || TextUtils.isEmpty(this.sl)) && this.c != null) {
            this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
        }
    }
}

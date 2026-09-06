package com.byazt.qi;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 527, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public Context c;
    public x n;
    public String tt;
    public boolean uj;
    public String ve;

    public Context c() {
        return this.c;
    }

    public String tt() {
        return this.tt;
    }

    public x uj() {
        return this.n;
    }

    public boolean ve() {
        return this.uj;
    }

    @com.byazt.zqa.c(c = {0, 1, 527, 180})
    public static class c {
        public final Context c;
        public final String tt;
        public final String ve;
        public boolean uj = false;
        public x n = null;

        public c c(boolean z) {
            this.uj = z;
            return this;
        }

        public void c(x xVar) {
            this.n = xVar;
        }

        public c(Context context, String str, String str2) {
            this.c = context;
            this.ve = str2;
            this.tt = str;
        }

        public sp c() {
            sp spVar = new sp();
            spVar.c = this.c;
            spVar.tt = this.tt;
            spVar.ve = this.ve;
            spVar.n = this.n;
            spVar.uj = this.uj;
            return spVar;
        }
    }
}

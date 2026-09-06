package com.byazt.em;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.vn.RoundImageView;
import com.byazt.vn.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE, 20})
public abstract class c extends tt {
    public int vi;

    public abstract String sl(String str);

    @Override // com.byazt.vn.tt
    public String sp() {
        return "drawable";
    }

    public c(Context context) {
        super(context);
        this.vi = -16777216;
    }

    @Override // com.byazt.vn.tt, com.byazt.xj.ve
    public void tt() {
        this.c = u(this.c);
        super.tt();
        ((RoundImageView) this.n).setColorFilter(this.vi);
        ((RoundImageView) this.n).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String u(String str) {
        String strSl = sl(str);
        return TextUtils.isEmpty(strSl) ? "" : "local://".concat(String.valueOf(strSl));
    }

    @Override // com.byazt.vn.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.vi = com.byazt.cd.c.c(str2);
        }
    }
}

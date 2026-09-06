package com.byazt.oqk;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.nr.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 802, 20})
public class c extends com.byazt.em.c {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.em.c
    public String sl(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }

    @Override // com.byazt.vn.tt
    public void c(final ImageView imageView, String str) {
        z.c(this.tt, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oqk.c.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                imageView.setImageDrawable(com.byazt.vn.c.c(bitmap));
            }
        }, 160);
    }
}

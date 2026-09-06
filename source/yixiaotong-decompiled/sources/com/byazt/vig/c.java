package com.byazt.vig;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.vn.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1490, 20})
public class c extends tt {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.vn.tt
    public void c(final ImageView imageView, String str) {
        z.c(this.tt, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.vig.c.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                imageView.setImageDrawable(com.byazt.vn.c.c(bitmap));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}

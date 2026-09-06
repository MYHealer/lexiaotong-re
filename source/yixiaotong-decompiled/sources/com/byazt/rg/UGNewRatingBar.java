package com.byazt.rg;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.fe.UGRatingBar;
import com.byazt.nr.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, 2206})
public class UGNewRatingBar extends UGRatingBar {
    public UGNewRatingBar(Context context) {
        super(context);
    }

    @Override // com.byazt.fe.UGRatingBar
    public void c(ImageView imageView, String str) {
        z.c(getContext(), str, imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}

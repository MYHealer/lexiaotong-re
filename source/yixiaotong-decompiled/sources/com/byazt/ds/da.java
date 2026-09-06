package com.byazt.ds;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 72})
public class da extends ve {
    public final Context n;

    public da(Context context) {
        super(true, false);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        String str;
        int iSp = com.byazt.yv.c.sp();
        switch (iSp) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case 260:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN /* 280 */:
            case 300:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                str = "xhdpi";
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO /* 340 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL /* 360 */:
            case 400:
            case 420:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK /* 640 */:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", iSp);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", com.byazt.yv.c.x() + "x" + com.byazt.yv.c.i());
        return true;
    }
}

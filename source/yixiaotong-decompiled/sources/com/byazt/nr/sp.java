package com.byazt.nr;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public final class sp {
    public static File c(Context context, boolean z, String str) {
        File fileC;
        if (context == null || (fileC = com.byazt.nys.tt.c(context)) == null) {
            return null;
        }
        return (!z || TextUtils.isEmpty(str)) ? fileC : new File(fileC.getParent(), fileC.getName() + "_" + str);
    }

    public static File tt(Context context, boolean z, String str) {
        File fileTt;
        if (context == null || (fileTt = com.byazt.nys.tt.tt(context)) == null) {
            return null;
        }
        return (!z || TextUtils.isEmpty(str)) ? fileTt : new File(fileTt.getParent(), fileTt.getName() + "_" + str);
    }

    public static File ve(Context context, boolean z, String str) {
        return c(context, null, z, str);
    }

    public static File c(Context context, String str, boolean z, String str2) {
        File fileC;
        if (context == null || (fileC = com.byazt.nys.tt.c(context, str)) == null) {
            return null;
        }
        return (!z || TextUtils.isEmpty(str2)) ? fileC : new File(fileC.getParent(), fileC.getName() + "_" + str2);
    }

    public static File uj(Context context, boolean z, String str) {
        File fileVe;
        if (context == null || (fileVe = com.byazt.nys.tt.ve(context)) == null) {
            return null;
        }
        return (!z || TextUtils.isEmpty(str)) ? fileVe : new File(fileVe.getParent(), fileVe.getName() + "_" + str);
    }
}

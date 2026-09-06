package com.meishu.sdk.meishu_ad.view.player;

import android.media.MediaPlayer;
import com.meishu.sdk.core.utils.LogUtil;
import java.io.File;

/* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: compiled from: CacheMediaPlayerHelper.java */
    public interface a {
    }

    public static boolean a(boolean z, MediaPlayer mediaPlayer, int i, int i2) {
        if (z) {
            if (i2 > 0) {
                int duration = mediaPlayer.getDuration();
                int i3 = (duration * i) / 100;
                LogUtil.d("CacheMediaPlayerHelper", "videoPrepareProgress:" + duration + " percent:" + i + " curCacheDur:" + i3 + " minCacheDuration:" + i2);
                if (i3 >= i2 || i == 100) {
                }
            }
            return true;
        }
        return false;
    }

    public static long a(File file) {
        if (file == null) {
            return 0L;
        }
        try {
            if (file.exists()) {
                return file.length();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }
}

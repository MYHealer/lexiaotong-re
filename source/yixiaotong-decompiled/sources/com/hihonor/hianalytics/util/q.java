package com.hihonor.hianalytics.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class q {
    public static int a(int i) {
        switch (i) {
            case 257:
                return 10004;
            case 258:
                return 10005;
            case 259:
                return 10006;
            default:
                return 10000;
        }
    }

    public static int b(int i) {
        switch (i) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT /* 515 */:
                return 10102;
            case 516:
                return 10103;
            case MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE /* 517 */:
                return 10104;
            case MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS /* 518 */:
                return 10105;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX /* 519 */:
                return 10106;
            default:
                return 10000;
        }
    }

    public static int c(int i) {
        if (i == 17) {
            return 10100;
        }
        if (i != 18) {
            return 10000;
        }
        return MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED;
    }

    public static int d(int i) {
        if (i != 17) {
            return i != 18 ? 10000 : 10003;
        }
        return 10002;
    }

    public static int e(int i) {
        switch (i) {
            case 4097:
                return 20001;
            case 4098:
                return 22000;
            case 4099:
                return 22001;
            case 4100:
                return 22002;
            default:
                return 20000;
        }
    }
}

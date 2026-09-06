package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT), Color.rgb(148, 212, 212), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 180, 187), Color.rgb(118, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(JfifUtil.MARKER_EOI, 80, 138), Color.rgb(MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, Opcodes.FCMPL, 7), Color.rgb(MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 120), Color.rgb(106, 167, 134), Color.rgb(53, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 209)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(Opcodes.FCMPL, 165, AppTypeIdUtil.NewDevice4GDrinkOTA_1), Color.rgb(JfifUtil.MARKER_EOI, 184, 162), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 134, 134), Color.rgb(179, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(255, 208, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID), Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 234, 255), Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 157)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 & 255) << 24);
    }

    public static int rgb(String str) {
        int i = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}

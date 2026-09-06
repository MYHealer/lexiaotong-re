package com.miui.zeus.mimo.sdk.server.clientinfo;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AppSignUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5603a;

    static {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND)});
    }

    public static String a(Context context) {
        return (String) NCall.IL(new Object[]{399, context});
    }
}

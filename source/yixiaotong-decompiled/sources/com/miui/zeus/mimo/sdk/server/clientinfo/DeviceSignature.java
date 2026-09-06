package com.miui.zeus.mimo.sdk.server.clientinfo;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.MimoLocation;
import com.miui.zeus.mimo.sdk.g4;
import ijiami_1011.NCall;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DeviceSignature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5605a = null;
    public static boolean b = true;
    public static String c;
    public static MimoLocation d;
    public static long e;

    public class a implements g4.d {
        public void a(MimoLocation mimoLocation) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND), this, mimoLocation});
        }
    }

    public static MimoLocation a() {
        return (MimoLocation) NCall.IL(new Object[]{402});
    }

    public static String a(Context context) {
        return (String) NCall.IL(new Object[]{403, context});
    }

    public static String b(Context context) {
        return (String) NCall.IL(new Object[]{404, context});
    }

    public static String c(Context context) {
        return (String) NCall.IL(new Object[]{405, context});
    }

    public static String d(Context context) {
        return (String) NCall.IL(new Object[]{406, context});
    }

    public static JSONObject e(Context context) {
        return (JSONObject) NCall.IL(new Object[]{407, context});
    }

    public static String f(Context context) {
        return (String) NCall.IL(new Object[]{408, context});
    }
}

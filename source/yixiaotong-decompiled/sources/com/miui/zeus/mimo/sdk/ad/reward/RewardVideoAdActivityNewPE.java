package com.miui.zeus.mimo.sdk.ad.reward;

import android.app.Activity;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.a2;
import com.miui.zeus.mimo.sdk.b2;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.z1;
import com.stub.StubApp;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoAdActivityNewPE extends Activity implements a2 {
    public static final String f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z1 f5305a;
    public String b;
    public MimoAdInfo c;
    public ViewMeasureHelper d;
    public b2 e;

    static {
        StubApp.interface11(46516);
        NCall.IV(new Object[]{245});
    }

    public z1 a(MimoAdInfo mimoAdInfo) {
        return (z1) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT), this, mimoAdInfo});
    }

    public void a() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT), this});
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT), this});
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        NCall.IV(new Object[]{250, this});
    }

    @Override // android.app.Activity
    public void onPause() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR), this});
    }

    @Override // android.app.Activity
    public void onResume() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF), this});
    }
}

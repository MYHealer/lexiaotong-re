package com.byazt.ia;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 15})
public class uj {
    public int c;

    /* JADX INFO: renamed from: com.byazt.ia.uj$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, z.k})
    static /* synthetic */ class AnonymousClass1 {
    }

    public int c() {
        return this.c;
    }

    public uj(Context context) {
        try {
            c(context);
        } catch (Throwable unused) {
        }
    }

    private void c(Context context) {
        context.registerReceiver(new c(this, null), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, AppTypeIdUtil.NewDevice4GBathOTA})
    private class c extends BroadcastReceiver {
        private c() {
        }

        public /* synthetic */ c(uj ujVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    uj.this.c = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }
}

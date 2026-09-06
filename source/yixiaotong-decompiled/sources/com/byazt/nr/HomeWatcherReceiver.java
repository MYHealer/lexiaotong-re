package com.byazt.nr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 2211})
public class HomeWatcherReceiver extends BroadcastReceiver {
    public c c;

    public interface c {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            m.c("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                m.c("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    m.c("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    m.c("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    m.c("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            m.uj("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}

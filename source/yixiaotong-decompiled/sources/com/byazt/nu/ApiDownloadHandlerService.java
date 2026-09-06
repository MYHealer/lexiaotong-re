package com.byazt.nu;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 2475})
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ve veVar = ve.getInstance();
        if (veVar != null) {
            HashMap map = new HashMap();
            map.put("s", this);
            veVar.c(map, 157);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        ve veVar = ve.getInstance();
        if (veVar != null) {
            HashMap map = new HashMap();
            map.put("i", intent);
            map.put("c", this);
            veVar.c(map, 158);
        }
        stopSelf();
        return 2;
    }
}

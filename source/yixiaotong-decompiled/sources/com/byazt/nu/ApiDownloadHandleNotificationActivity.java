package com.byazt.nu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 729})
public class ApiDownloadHandleNotificationActivity extends Activity {
    public static final String[] c;
    public ApiDownloadHandlerService tt = new ApiDownloadHandlerService();

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static {
        StubApp.interface11(18342);
        c = new String[]{x.cK};
    }

    /* JADX INFO: renamed from: com.byazt.nu.ApiDownloadHandleNotificationActivity$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, Opcodes.FCMPL})
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Intent c;

        public AnonymousClass1(Intent intent) {
            this.c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(this.c.getAction())) {
                ApiDownloadHandleNotificationActivity.this.c();
            } else {
                ApiDownloadHandleNotificationActivity.this.tt.onStartCommand(this.c, 0, 0);
            }
            ApiDownloadHandleNotificationActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ActivityCompat.requestPermissions(this, c, 1000);
        } catch (Throwable th) {
            a.tt("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }
}

package com.adprof.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.ImageView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class oo extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ko f1351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ po f541a;

    public oo(po poVar, ko koVar) {
        this.f541a = poVar;
        this.f1351a = koVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int streamVolume;
        ImageView imageView;
        int i;
        if (!com.huawei.openalliance.ad.constant.x.co.equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || this.f1351a == null || (streamVolume = ((AudioManager) StubApp.getOrigApplicationContext(this.f541a.getApplicationContext()).getSystemService("audio")).getStreamVolume(3)) < 0) {
            return;
        }
        ko koVar = this.f1351a;
        if (streamVolume == 0) {
            koVar.f1272a.f600a.setImageResource(R.drawable.adprof_video_mute);
            return;
        }
        po poVar = koVar.f1272a;
        if (poVar.f619c) {
            imageView = poVar.f600a;
            i = R.drawable.adprof_video_mute;
        } else {
            imageView = poVar.f600a;
            i = R.drawable.adprof_video_unmute;
        }
        imageView.setImageResource(i);
    }
}

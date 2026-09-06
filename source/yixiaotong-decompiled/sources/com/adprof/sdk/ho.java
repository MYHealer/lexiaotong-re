package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ho extends s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IntentFilter f1217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pc f370a;

    public ho(d dVar, pc pcVar, String str) {
        super(str);
        this.f369a = dVar;
        this.f370a = pcVar;
        a();
    }

    @Override // com.adprof.sdk.s5
    public IntentFilter a() {
        if (f1217a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f1217a = intentFilter;
            intentFilter.addAction("action.reward.video.show");
            f1217a.addAction("action.reward.video.play");
            f1217a.addAction("action.reward.video.play.fail");
            f1217a.addAction("action.reward.video.close");
            f1217a.addAction("action.reward.video.click");
            f1217a.addAction("action.reward.video.skip");
            f1217a.addAction("action.reward.video.complete");
            f1217a.addAction("action.reward.video.get");
            f1217a.addAction("action.land.page.show");
            f1217a.addAction("action.land.page.dismiss");
        }
        return f1217a;
    }

    @Override // com.adprof.sdk.s5
    public void b() {
        super.b();
        this.f370a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        qh.a(context);
        qh.a(intent);
        if (this.f370a != null && a(intent)) {
            String action = intent.getAction();
            pk.d("VideoAdBroadcastReceiver onReceive action =  " + action);
            if (TextUtils.isEmpty(action)) {
                return;
            }
            action.getClass();
            action.hashCode();
            switch (action) {
                case "action.reward.video.click":
                    this.f370a.b();
                    break;
                case "action.reward.video.close":
                    this.f370a.e();
                    break;
                case "action.reward.video.play.fail":
                    this.f370a.a(intent.getStringExtra("error"));
                    break;
                case "action.reward.video.get":
                    pc pcVar = this.f370a;
                    if (pcVar.m703b()) {
                        pcVar.f571a.onRewardVerify();
                        break;
                    }
                    break;
                case "action.reward.video.complete":
                    pc pcVar2 = this.f370a;
                    if (pcVar2.m702a()) {
                        pcVar2.f1363a.onInterstitialAdPlayEnd();
                    }
                    if (pcVar2.m703b()) {
                        pcVar2.f571a.onRewardAdPlayEnd();
                        break;
                    }
                    break;
                case "action.land.page.dismiss":
                    this.f370a.c();
                    break;
                case "action.reward.video.play":
                    pc pcVar3 = this.f370a;
                    ((p5) pcVar3).f548a = i2.AdStatusPlaying;
                    if (pcVar3.m703b()) {
                        pcVar3.f571a.onRewardAdPlayStart();
                        break;
                    }
                    break;
                case "action.reward.video.show":
                    this.f370a.a(this.f369a);
                    break;
                case "action.reward.video.skip":
                    pc pcVar4 = this.f370a;
                    if (pcVar4.m703b()) {
                        fn.a(new oc(pcVar4));
                        break;
                    }
                    break;
                case "action.land.page.show":
                    this.f370a.d();
                    break;
            }
        }
    }
}

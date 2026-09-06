package com.adprof.sdk;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qc implements k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vc f1383a;

    public qc(vc vcVar) {
        this.f1383a = vcVar;
    }

    @Override // com.adprof.sdk.k8
    public void a() {
        pk.a("InterstitialBaseView----------onFinish----------");
        vc vcVar = this.f1383a;
        if (vcVar.f773a) {
            return;
        }
        if (vcVar.f782d != null) {
            vcVar.a(true);
            this.f1383a.f773a = true;
        }
        uc ucVar = this.f1383a.f771a;
        if (ucVar != null) {
            id idVar = (id) ucVar;
            d dVar = idVar.f1228a.f1246a;
            if (dVar != null && dVar.m606g()) {
                String str = ((q5) idVar.f1228a).f663a;
                if (str != null) {
                    s5.a(str, "action.reward.video.get");
                } else {
                    pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
                }
                if (idVar.f1228a.a() != null) {
                    idVar.f1228a.a().a(idVar.f1228a.f1246a, "reward_get_succ");
                }
            }
        }
        this.f1383a.f769a.getClass();
    }

    @Override // com.adprof.sdk.k8
    public void a(long j) {
        vc vcVar = this.f1383a;
        if (vcVar.f773a) {
            return;
        }
        vcVar.b = (int) ((j / 1000) + 1);
        String str = "跳过｜" + this.f1383a.b;
        try {
            int iIndexOf = str.indexOf("｜");
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#80FFFFFF")), iIndexOf, iIndexOf + 1, 33);
            this.f1383a.f782d.setText(spannableString);
        } catch (Exception unused) {
            this.f1383a.f782d.setText(str);
        }
        this.f1383a.f780c.setClickable(true);
    }
}

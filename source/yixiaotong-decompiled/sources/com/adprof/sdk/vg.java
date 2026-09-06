package com.adprof.sdk;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vg extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wg f1481a;

    public vg(wg wgVar) {
        this.f1481a = wgVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        try {
            if (this.f1481a.f802a.f852a.getParent() == null) {
                pk.d("OpenAdManager Custom layout removed, stopping countdown");
                yg.a(this.f1481a.f802a);
                return;
            }
            wg wgVar = this.f1481a;
            if (wgVar.f1502a > 0) {
                TextView textView = wgVar.f802a.f853a;
                if (textView != null) {
                    textView.setText(this.f1481a.f1502a + " 秒后打开广告");
                }
                pk.d("OpenAdManager Countdown: " + this.f1481a.f1502a + " seconds remaining");
                return;
            }
            pk.d("OpenAdManager open countdown finished, removing view");
            xg xgVar = this.f1481a.f802a.f855a;
            TextView textViewA = xgVar != null ? xgVar.a() : null;
            if (textViewA != null) {
                w6.a(textViewA, this.f1481a.f802a.f854a, new ug(this));
            }
            hp.m656a((View) this.f1481a.f802a.f852a);
            yg.a(this.f1481a.f802a);
        } catch (Exception e) {
            pk.b("OpenAdManager", "Error updating countdown UI: " + e.getMessage());
            yg.a(this.f1481a.f802a);
        }
    }
}

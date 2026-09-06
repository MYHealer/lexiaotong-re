package com.byazt.apd;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.at.n;
import com.byazt.bzd.x;
import com.byazt.ddx.a;
import com.byazt.ddx.uj;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.nr.m;
import com.byazt.omf.d;
import com.byazt.omf.rl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1580, 2401})
public class EcMallWebView extends SSWebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic f1974a;
    public d n;
    public n sp;

    public EcMallWebView(final Context context, ic icVar, final int i) {
        super(context);
        this.f1974a = icVar;
        x.c(new Runnable() { // from class: com.byazt.apd.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.c(context, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, int i) {
        this.n = new d(context);
        final String strC = nb.c(i);
        this.sp = new n() { // from class: com.byazt.apd.EcMallWebView.2
            @Override // com.byazt.at.n
            public void c() {
            }

            @Override // com.byazt.at.n
            public void tt() {
            }

            @Override // com.byazt.at.n
            public void c(int i2) {
                if (EcMallWebView.this.f1974a != null) {
                    com.byazt.ocd.tt ttVar = (com.byazt.ocd.tt) rl.c(EcMallWebView.this.f1974a.rl(), com.byazt.ocd.tt.class);
                    if (ttVar != null) {
                        ttVar.c(2, null);
                    }
                } else {
                    m.c("EcMallWebView", "onSendReward failed meta null");
                }
                uj.c(strC, EcMallWebView.this.f1974a);
            }
        };
        this.n.tt(this).c(this.f1974a).tt(this.f1974a.uj()).uj(this.f1974a.w_()).ve(i).n(nb.my(this.f1974a)).c((SSWebView) this).c(strC).c(this.sp).c(true);
        setWebViewClient(new com.byazt.jwd.uj(context, this.n, this.f1974a.uj(), new a(this.f1974a, this).tt(true)));
        setWebChromeClient(new com.byazt.jwd.ve(this.n));
        String strX = my.x(this.f1974a);
        if (TextUtils.isEmpty(strX)) {
            strX = this.f1974a.x();
        }
        if (TextUtils.isEmpty(strX)) {
            return;
        }
        loadUrl(strX);
    }

    @Override // com.byazt.qg.BizWebView, android.view.View, com.byazt.nl.uj
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        d dVar = this.n;
        if (dVar != null) {
            dVar.sl(z);
        }
    }
}

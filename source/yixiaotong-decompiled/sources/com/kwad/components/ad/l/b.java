package com.kwad.components.ad.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.webview.c;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.wrapper.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    private bf Dl;
    protected View NQ;
    private String NS;
    private a NT;
    private InterfaceC0616b NU;
    protected KsAdWebView ff;
    protected com.kwad.sdk.core.webview.b fi;
    protected az fk;
    private com.kwad.sdk.core.webview.d.a.a fl;
    private FrameLayout fu;
    private AdBaseFrameLayout gN;
    private com.kwad.components.core.webview.b jp;
    protected AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    private List<AdTemplate> NO = new ArrayList();
    private List<d> NP = new ArrayList();
    private int fj = -1;
    protected boolean NR = false;
    private c jq = new c() { // from class: com.kwad.components.ad.l.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b.this.fi = bVar;
            b.this.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.l.b.1.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (b.this.NT != null) {
                        b.this.NT.jX();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            b.this.fj = aVar.status;
            com.kwad.sdk.core.d.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.NS);
            if (!aVar.isSuccess() || b.this.NU == null) {
                return;
            }
            b.this.NU.jg();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            b.this.fk = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.fl != null) {
                b.this.fl.a(aVar);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onReceivedHttpError(int i, String str, String str2) {
            b.this.NR = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b.this.NR = true;
            b.this.gJ();
        }
    };
    private ak.b fn = new ak.b() { // from class: com.kwad.components.ad.l.b.2
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            b.this.os();
        }
    };

    public interface a {
        void jX();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0616b {
        void jg();
    }

    public final void a(a aVar) {
        this.NT = aVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.fl = aVar;
    }

    protected boolean cN() {
        return this.fj == 1;
    }

    protected boolean gF() {
        return true;
    }

    protected void gH() {
    }

    protected void gI() {
    }

    protected void gJ() {
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    public final void release() {
        this.NU = null;
    }

    public b() {
    }

    public b(JSONObject jSONObject, String str) {
        this.mReportExtData = jSONObject;
        this.NS = str;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, d dVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, dVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, d dVar, int i) {
        this.NP.add(dVar);
        this.gN = adBaseFrameLayout;
        this.fu = frameLayout;
        this.mAdTemplate = adTemplate;
        gE();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<d> list2) {
        this.NP = list2;
        this.gN = adBaseFrameLayout;
        this.fu = frameLayout;
        if (list != null && list.size() > 0) {
            this.NO = list;
            this.mAdTemplate = list.get(0);
        }
        gE();
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    protected void gE() {
        this.fu.removeAllViews();
        this.fu.setVisibility(4);
        this.NQ = m.inflate(this.fu.getContext(), getLayoutId(), this.fu);
        KsAdWebView ksAdWebView = (KsAdWebView) this.fu.findViewById(R.id.ksad_web_card_webView);
        this.ff = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z = false;
            ksAdWebView.setBackgroundColor(0);
            this.ff.getBackground().setAlpha(0);
            this.jp = new com.kwad.components.core.webview.b();
            com.kwad.components.core.webview.b.a aVarF = new com.kwad.components.core.webview.b.a().bi(this.mAdTemplate).bu(O(this.mAdTemplate)).f(this.ff).f(this.mReportExtData).m(this.gN).f(this.NP.get(0));
            if (this.NP.size() > 1 && this.NO.size() > 1) {
                z = true;
            }
            this.jp.a(aVarF.bj(z).a(this.jq));
            this.ff.loadUrl(O(this.mAdTemplate));
            gH();
        }
    }

    public final void aj(boolean z) {
        this.Dl.aj(true);
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(InterfaceC0616b interfaceC0616b) {
        this.NU = interfaceC0616b;
        this.fu.setVisibility(4);
        this.fj = -1;
        String strO = O(this.mAdTemplate);
        com.kwad.sdk.core.d.c.d("PlayEndWebCard", "startPreloadWebView url : " + strO);
        if (TextUtils.isEmpty(strO) || this.ff == null) {
            return;
        }
        gI();
        this.ff.loadUrl(strO);
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String O(AdTemplate adTemplate) {
        String str = this.NS;
        return str == null ? com.kwad.sdk.core.response.helper.b.dj(this.mAdTemplate) : str;
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.NP.size() > 1 && this.NO.size() > 1) {
            aVar.a(new ac(this.fi, this.NP.get(0), this.fl, (byte) 0));
            aVar.a(new z(this.fi, this.NP, this.fl));
            aVar.a(new ao(this.NO, this.NP));
        }
        bf bfVar = new bf();
        this.Dl = bfVar;
        aVar.a(bfVar);
        aVar.a(new ak(this.fn));
    }

    public final boolean bc() {
        if (cN()) {
            az azVar = this.fk;
            if (azVar != null) {
                azVar.yx();
            }
            FrameLayout frameLayout = this.fu;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.fk == null || !gF()) {
                return true;
            }
            this.fk.yy();
            return true;
        }
        FrameLayout frameLayout2 = this.fu;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        bs();
        return false;
    }

    public final void os() {
        if (cb.a(this.ff, 50, false)) {
            az azVar = this.fk;
            if (azVar != null) {
                azVar.yz();
            }
            this.fu.setVisibility(4);
            az azVar2 = this.fk;
            if (azVar2 != null) {
                azVar2.yA();
            }
        }
    }

    private void bs() {
        String str;
        int i = this.fj;
        if (i == -1) {
            str = "timeout";
        } else {
            str = i != 1 ? "h5error" : "others";
        }
        com.kwad.sdk.core.d.c.w("PlayEndWebCard", "show webCard fail, reason: ".concat(str));
    }

    public final void oe() {
        com.kwad.components.core.webview.b bVar = this.jp;
        if (bVar != null) {
            bVar.kV();
        }
    }
}

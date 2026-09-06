package com.opos.mobad.ui.b;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.biz.web.b.a.a f8300a;
    private Context b;
    private e.b c;

    public b(Context context, e.b bVar) {
        this.b = com.opos.mobad.service.a.a(context);
        this.c = bVar;
        this.f8300a = new com.opos.cmn.biz.web.b.a.a(this.b, new com.opos.cmn.biz.web.b.a.b.a().a((com.opos.cmn.biz.web.b.a.a.b) null).a((Map<String, Object>) null).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.ui.b.b.1
            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
                com.opos.cmn.an.f.a.b("privacyTool", "onReceivedSslError");
                try {
                    com.opos.cmn.module.ui.b.c.c cVar = new com.opos.cmn.module.ui.b.c.c(b.this.b, 0.1f);
                    final View viewB = cVar.b();
                    cVar.a((CharSequence) "SSL证书验证错误，是否继续？");
                    cVar.b("取消");
                    cVar.a("继续");
                    cVar.a(new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.ui.b.b.1.1
                        @Override // com.opos.cmn.module.ui.b.d.a
                        public void a(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.cancel();
                            View viewB2 = b.this.f8300a.b();
                            if (viewB2 != null && (viewGroup = (ViewGroup) viewB2.getParent()) != null && viewGroup.indexOfChild(viewB) > 0) {
                                viewGroup.removeView(viewB);
                            }
                            if (b.this.c != null) {
                                b.this.c.a();
                            }
                        }

                        @Override // com.opos.cmn.module.ui.b.d.a
                        public void b(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.proceed();
                            View viewB2 = b.this.f8300a.b();
                            if (viewB2 == null || (viewGroup = (ViewGroup) viewB2.getParent()) == null || viewGroup.indexOfChild(viewB) <= 0) {
                                return;
                            }
                            viewGroup.removeView(viewB);
                        }
                    });
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    ((ViewGroup) b.this.f8300a.b().getParent()).addView(viewB, layoutParams);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("ComplianceWebView", "", e);
                }
            }
        }).a());
    }

    @Override // com.opos.mobad.ui.b.d
    public int a() {
        return 0;
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8300a.a(str);
    }

    @Override // com.opos.mobad.ui.b.d
    public void a(Map<String, String> map) {
    }

    @Override // com.opos.mobad.ui.b.d
    public View b() {
        return this.f8300a.b();
    }

    @Override // com.opos.mobad.ui.b.d
    public void c() {
        this.f8300a.a();
    }
}

package com.byazt.ouz;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.omf.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.feature.dynamic.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends com.byazt.jwd.uj {
    public ArrayList<Integer> c;
    public ic da;
    public final com.byazt.zb.x i;
    public boolean sl;
    public com.byazt.xl.u t;

    public sp(Context context, d dVar, ic icVar, com.byazt.ddx.a aVar, boolean z, com.byazt.zb.x xVar, com.byazt.xl.u uVar) {
        super(context, dVar, icVar.uj(), aVar);
        this.c = new ArrayList<>();
        this.da = icVar;
        this.sl = z;
        this.i = xVar;
        this.t = uVar;
    }

    @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.byazt.nr.m.ve("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int c() {
        for (Integer num : this.c) {
            if (num.intValue() == 3 || num.intValue() == 2 || num.intValue() == -1) {
                return num.intValue();
            }
        }
        return TextUtils.isEmpty(uj()) ? -1 : 1;
    }

    @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.byazt.zb.x xVar = this.i;
            if (xVar != null) {
                xVar.x(str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.six.c cVarC = com.byazt.jlk.c.c(webView, this.da, str, new com.byazt.jlk.c.InterfaceC0190c() { // from class: com.byazt.ouz.sp.1
                @Override // com.byazt.jlk.c.InterfaceC0190c
                public boolean c() {
                    return true;
                }

                @Override // com.byazt.jlk.c.InterfaceC0190c
                public com.byazt.six.c c(String str2, com.byazt.or.da.c cVar, String str3) {
                    return com.byazt.six.tt.c(str2, cVar, str3, sp.this.uj());
                }
            });
            c(jCurrentTimeMillis, System.currentTimeMillis(), str, (cVarC == null || cVarC.c() == null) ? 2 : 1);
            if (cVarC != null && cVarC.getType() != 5) {
                this.c.add(Integer.valueOf(cVarC.getType()));
            }
            if (cVarC != null && cVarC.c() != null) {
                com.byazt.zb.x xVar2 = this.i;
                if (xVar2 != null) {
                    xVar2.i(str);
                }
                return cVarC.c();
            }
        } catch (Throwable th) {
            com.byazt.nr.m.ve("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uj() {
        if (pu.a(this.da) != null) {
            return pu.a(this.da).sl();
        }
        if (pu.sp(this.da) != null) {
            return b.u;
        }
        return null;
    }

    @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f2386a = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.sp = false;
        super.onPageStarted(webView, str, bitmap);
        com.byazt.xl.u uVar = this.t;
        if (uVar == null || !uVar.zm()) {
            return;
        }
        com.byazt.nr.yp.c(webView, "javascript:window.SDK_INJECT_DATA=" + this.t.n());
    }

    private void c(long j, long j2, String str, int i) {
        if (this.n == null || this.n.ve() == null) {
            return;
        }
        com.byazt.or.da.c cVarC = com.byazt.or.da.c(str);
        if (cVarC == com.byazt.or.da.c.HTML) {
            this.n.ve().c(str, j, j2, i);
        } else if (cVarC == com.byazt.or.da.c.JS) {
            this.n.ve().tt(str, j, j2, i);
        }
    }
}

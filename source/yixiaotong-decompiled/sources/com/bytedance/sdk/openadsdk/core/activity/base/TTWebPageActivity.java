package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.byazt.aas.cu;
import com.byazt.aas.pf;
import com.byazt.cty.BaseLandingPageActivity;
import com.byazt.dna.qp;
import com.byazt.el.SSWebView;
import com.byazt.ete.kp;
import com.byazt.ff.TTProgressBar;
import com.byazt.fh.a;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.d;
import com.byazt.omf.x;
import com.byazt.ows.c;
import com.byazt.ows.tt;
import com.byazt.ows.uj;
import com.byazt.ows.ve;
import com.byazt.vfu.n;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements qp.c {
    private static final String nb = "TTWebPageActivity";
    private int aw;
    private boolean bx;
    private final d hd = new d(Looper.getMainLooper(), this);
    private int ic;
    private ImageView pf;
    private boolean sv;

    static {
        StubApp.interface11(23299);
    }

    private boolean z() {
        return this.bx || this.sv;
    }

    protected int sl() {
        return -1;
    }

    protected LinearLayout t() {
        return new LinearLayout(this.n);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public View sp() {
        if (this.n == null) {
            return null;
        }
        Resources resources = this.n.getResources();
        LinearLayout linearLayoutT = t();
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayoutT.setOrientation(1);
        linearLayoutT.setLayoutParams(layoutParams);
        this.f2061a = new TTViewStub(this.n, new tt());
        this.f2061a.setId(2114387770);
        linearLayoutT.addView(this.f2061a, new LinearLayout.LayoutParams(-1, -2));
        this.sp = new TTViewStub(this.n, new ve());
        this.sp.setId(2114387792);
        linearLayoutT.addView(this.sp, new LinearLayout.LayoutParams(-1, -2));
        this.x = new TTViewStub(this.n, new uj());
        this.x.setId(2114387933);
        linearLayoutT.addView(this.x, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.n);
        linearLayoutT.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.qy = new SSWebView(this.n);
        this.qy.setMaterialMeta(cu.c(this.qp));
        this.qy.setId(2114387733);
        this.qy.setLayoutParams(new FrameLayout.LayoutParams(-1, sl()));
        frameLayout.addView(this.qy);
        try {
            this.qy.setBackgroundColor(0);
            this.qy.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        this.i = new TTViewStub(this.n, new c());
        this.i.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.i, layoutParams2);
        this.gr = new TTProgressBar(this.n, null, R.style.Widget.ProgressBar.Horizontal);
        this.gr.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.gr.setLayoutParams(layoutParams3);
        this.gr.setProgress(1);
        this.gr.setProgressDrawable(n.c());
        frameLayout.addView(this.gr);
        return linearLayoutT;
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void n() {
        u();
        boolean z = z();
        c(new com.byazt.dyf.tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.byazt.dyf.tt.c
            public void c() {
                TTWebPageActivity.this.m();
            }

            @Override // com.byazt.dyf.tt.c
            public void c(int i, String str, boolean z2) {
                TTWebPageActivity.this.nu();
            }

            @Override // com.byazt.dyf.tt.c
            public void tt() {
                TTWebPageActivity.this.nu();
            }
        }, !z);
        if (z) {
            yp();
        }
        tt();
        c(false);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity
    public void a() {
        super.a();
        com.byazt.ab.tt.c().c(this.qp);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        nu();
        tt(true);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m();
        tt(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.byazt.ab.tt.c().tt(this.qp);
    }

    private void tt(boolean z) {
        if (this.qp == null || !this.qp.bz() || this.yv == null) {
            return;
        }
        this.yv.sl(z);
    }

    private void u() {
        this.sv = kp.my(this.qp);
        this.bx = kp.rh(this.qp) && !a.ve;
        if (this.sv) {
            if (!a.uj) {
                this.bx = false;
            } else if (this.bx) {
                this.sv = false;
            }
        }
        if (this.bx || this.sv) {
            if (this.x != null) {
                this.x.setVisibility(0);
            }
            this.pf = (ImageView) findViewById(2114387843);
            return;
        }
        if (this.qp != null && this.qp.pf()) {
            if (this.f2061a != null) {
                this.f2061a.setVisibility(8);
            }
            if (this.sp != null) {
                this.sp.setVisibility(8);
                return;
            }
            return;
        }
        int iMd = x.m().md();
        if (iMd == 0) {
            if (this.f2061a != null) {
                this.f2061a.setVisibility(0);
            }
        } else if (iMd == 1 && this.sp != null) {
            this.sp.setVisibility(0);
        }
    }

    private void yp() {
        this.aw = 0;
        if (this.bx) {
            this.aw = a.c;
        } else if (this.sv && !a.uj) {
            this.aw = kp.yp(this.qp);
        }
        tt(this.aw);
        if (this.aw > 0 && !this.hd.hasMessages(10)) {
            if (this.bx) {
                this.hd.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.sv) {
                this.hd.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 10 && z()) {
            int i = this.ic + 1;
            this.ic = i;
            if (this.bx) {
                a.tt = i;
            }
            int iMax = Math.max(0, this.aw - this.ic);
            tt(iMax);
            if (iMax <= 0 && this.sv) {
                a.uj = true;
            }
            this.hd.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (z()) {
            this.hd.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        if (!z() || this.hd.hasMessages(10)) {
            return;
        }
        this.hd.sendEmptyMessageDelayed(10, 1000L);
    }

    private void tt(int i) {
        if (i <= 0) {
            if (this.bx) {
                pf.c(this.m, "领取成功");
                return;
            } else {
                if (this.sv) {
                    pf.c((View) this.pf, 8);
                    pf.c(this.m, "恭喜你！福利已领取");
                    return;
                }
                return;
            }
        }
        if (this.bx) {
            pf.c(this.m, i + "s后可领取奖励");
        } else if (this.sv) {
            SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
            pf.c(this.m, spannableString);
        }
    }
}

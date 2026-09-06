package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.base.view.gif.GifImageView2;
import com.adprof.sdk.xb.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Timer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xg f855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f856a;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f857a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f858b = false;
    public int b = 0;

    public yg(Context context, d dVar, xg xgVar) {
        this.f851a = context;
        this.f854a = dVar;
        this.f855a = xgVar;
        this.c = dVar.m602c() ? R.id.adprof_interstitial_post : R.id.adprof_reward_ll;
    }

    public static void a(yg ygVar) {
        Timer timer = ygVar.f856a;
        if (timer != null) {
            timer.cancel();
            ygVar.f856a = null;
            pk.d("OpenAdManager open timer cancelled");
        }
    }

    public final void a(int i) {
        if (this.f852a == null || this.f853a == null || i <= 0) {
            return;
        }
        Timer timer = this.f856a;
        if (timer != null) {
            timer.cancel();
            this.f856a = null;
        }
        this.f856a = new Timer();
        this.f856a.schedule(new wg(this, i), 1000L, 1000L);
        pk.d("OpenAdManager open countdown started: " + i + " seconds");
    }

    public void b() {
        Timer timer = this.f856a;
        if (timer != null) {
            timer.cancel();
            this.f856a = null;
            pk.d("OpenAdManager open timer cancelled");
        }
        hp.m656a((View) this.f852a);
        this.f858b = false;
        this.b = 0;
        this.f855a = null;
    }

    public void c() {
        if (this.f856a == null || this.f858b) {
            return;
        }
        this.f858b = true;
        pk.d("OpenAdManager timer paused, remaining seconds: " + this.b);
    }

    public void d() {
        int i;
        if (!this.f858b || (i = this.b) <= 0) {
            return;
        }
        this.f858b = false;
        a(i);
        pk.d("OpenAdManager timer resumed, remaining seconds: " + this.b);
    }

    public void a() {
        int i;
        try {
            z1.a().getClass();
            if (this.f854a.m597a()) {
                pk.d("OpenAdManager downloadType return .......");
                return;
            }
            ul ulVarA = vl.a(this.f854a);
            if (ulVarA != null) {
                try {
                    if (Integer.parseInt(ulVarA.n) > 0) {
                        if (this.f857a) {
                            pk.d("OpenAdManager mEverClicked return .......");
                            return;
                        }
                        if (this.f855a == null) {
                            pk.b("OpenAdManager", "Callback is null return ......");
                            return;
                        }
                        RelativeLayout relativeLayout = (RelativeLayout) this.f855a.a(this.f854a.m602c() ? R.id.adprof_interstitial : R.id.adprof_reward_rl);
                        View viewA = this.f855a.a(this.c);
                        if (relativeLayout != null && viewA != null) {
                            LinearLayout linearLayout = (LinearLayout) this.f855a.a(this.f851a, R.layout.adprof_open_ad, null);
                            this.f852a = linearLayout;
                            if (linearLayout == null) {
                                pk.b("OpenAdManager", "Failed to inflate auto open ad layout");
                                return;
                            }
                            GifImageView2 gifImageView2 = (GifImageView2) linearLayout.findViewById(R.id.adprof_open_ad_image);
                            this.f853a = (TextView) this.f852a.findViewById(R.id.adprof_open_ad_text);
                            Button button = (Button) this.f852a.findViewById(R.id.adprof_open_ad_button);
                            ul ulVarA2 = vl.a(this.f854a);
                            if (ulVarA2 != null) {
                                try {
                                    i = Integer.parseInt(ulVarA2.n);
                                } catch (Throwable unused) {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                            }
                            this.f1538a = i;
                            TextView textView = this.f853a;
                            if (textView != null) {
                                textView.setText(this.f1538a + " 秒后打开广告");
                            }
                            String str = this.f854a.f204f;
                            if (TextUtils.isEmpty(str)) {
                                gifImageView2.setVisibility(8);
                            } else {
                                gifImageView2.setBorderRadius(h8.a(8.0f));
                                xb xbVarA = xb.a(this.f851a);
                                xbVarA.getClass();
                                xbVarA.new a(str).a(gifImageView2);
                            }
                            a(this.f1538a);
                            if (button != null) {
                                button.setVisibility(0);
                                button.setOnClickListener(new tg(this));
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                            if (this.f854a.m602c()) {
                                layoutParams.addRule(12);
                                int dimension = ((int) AdprofSdk.getInstance().getContext().getResources().getDimension(R.dimen.adprof_inter_margin_left)) + h8.a(5.0f);
                                layoutParams.setMargins(dimension, 0, dimension, h8.a(25.0f));
                                pk.a("OpenAdManager", "mOpenAdLinear positioned at parent bottom with 15dp margin");
                            } else {
                                layoutParams.addRule(18, this.c);
                                layoutParams.addRule(19, this.c);
                                layoutParams.addRule(2, this.c);
                                int iA = h8.a(30.0f);
                                layoutParams.setMargins(iA, h8.a(20.0f), iA, 0);
                            }
                            this.f852a.setId(-346148519);
                            relativeLayout.addView(this.f852a, layoutParams);
                            pk.a("OpenAdManager", "mOpenAdLinear added to parent layout - width: " + layoutParams.width + ", height: " + layoutParams.height + ", topMargin: " + layoutParams.topMargin + ", bottomMargin: " + layoutParams.bottomMargin + ", leftMargin: " + layoutParams.leftMargin + ", rightMargin: " + layoutParams.rightMargin);
                            pk.d("OpenAdManager  open ad view added successfully with countdown: " + this.f1538a);
                            return;
                        }
                        pk.b("OpenAdManager", "Parent layout or post view not found - parentLayout: " + (relativeLayout != null) + ", postView: " + (viewA != null) + ", adType: " + (this.f854a.m602c() ? MediationConstant.RIT_TYPE_INTERSTITIAL : "reward"));
                        return;
                    }
                } catch (Throwable unused2) {
                }
            }
            pk.d("OpenAdManager no open return .......");
        } catch (Exception e) {
            pk.b("OpenAdManager", "Error adding  open ad view: " + e.getMessage());
        }
    }
}

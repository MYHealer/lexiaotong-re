package com.jd.ad.sdk.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.logger.Logger;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADSplashSkipView extends FrameLayout {
    public int jad_s_an;
    public jad_s_bo jad_s_bo;
    public TextView jad_s_cp;
    public boolean jad_s_dq;
    public final Runnable jad_s_er;

    public class jad_s_an implements Runnable {
        public jad_s_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplashSkipView jADSplashSkipView = JADSplashSkipView.this;
            TextView textView = jADSplashSkipView.jad_s_cp;
            if (textView == null) {
                return;
            }
            if (jADSplashSkipView.jad_s_an > 5) {
                textView.setText("跳过");
            } else {
                textView.setText(String.format(Locale.getDefault(), "跳过 %d", Integer.valueOf(JADSplashSkipView.this.jad_s_an)));
            }
            JADSplashSkipView jADSplashSkipView2 = JADSplashSkipView.this;
            if (jADSplashSkipView2.jad_s_dq) {
                jad_s_bo jad_s_boVar = jADSplashSkipView2.jad_s_bo;
                if (jad_s_boVar != null) {
                    com.jd.ad.sdk.splash.jad_s_an.jad_s_an(((jad_s_cp) jad_s_boVar).jad_s_an, jADSplashSkipView2.jad_s_an);
                }
                JADSplashSkipView.this.jad_s_an--;
            }
            JADSplashSkipView jADSplashSkipView3 = JADSplashSkipView.this;
            if (jADSplashSkipView3.jad_s_an >= 0) {
                jADSplashSkipView3.postDelayed(jADSplashSkipView3.jad_s_er, 1000L);
                return;
            }
            jad_s_bo jad_s_boVar2 = jADSplashSkipView3.jad_s_bo;
            if (jad_s_boVar2 != null) {
                jad_s_cp jad_s_cpVar = (jad_s_cp) jad_s_boVar2;
                com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_cpVar.jad_s_an);
                JADSplashSkipView jADSplashSkipView4 = jad_s_cpVar.jad_s_an.jad_s_kx;
                if (jADSplashSkipView4 != null) {
                    jADSplashSkipView4.removeCallbacks(null);
                }
            }
        }
    }

    public interface jad_s_bo {
    }

    public JADSplashSkipView(Context context) {
        super(context);
        this.jad_s_dq = true;
        this.jad_s_er = new jad_s_an();
        jad_s_an(context);
    }

    public final void jad_s_an(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(ResourceUtils.getResourceId(context, "jad_skip_btn", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            this.jad_s_cp = (TextView) viewInflate.findViewById(ResourceUtils.getResourceId(context, "tv_count", "id"));
            addView(viewInflate);
        } catch (Exception e) {
            Logger.w("Exception while splash skip init: " + e, new Object[0]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_s_dq = z;
    }

    public void setTotalCount(jad_s_bo jad_s_boVar) {
        this.jad_s_an = 5;
        this.jad_s_bo = jad_s_boVar;
        setOnClickListener(new jad_s_er(this));
    }

    public JADSplashSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_s_dq = true;
        this.jad_s_er = new jad_s_an();
        jad_s_an(context);
    }

    public JADSplashSkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_s_dq = true;
        this.jad_s_er = new jad_s_an();
        jad_s_an(context);
    }

    public JADSplashSkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jad_s_dq = true;
        this.jad_s_er = new jad_s_an();
        jad_s_an(context);
    }
}

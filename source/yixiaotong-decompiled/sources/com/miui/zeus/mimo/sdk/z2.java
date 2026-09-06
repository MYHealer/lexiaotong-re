package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.reward.view.RewardMiniGamePBottomView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z2 extends j2 {
    public CloseICP I;
    public RelativeLayout J;
    public ImageView K;
    public TextView L;
    public LinearLayout M;
    public DownloadButtonICP N;
    public RewardMiniGamePBottomView O;
    public MimoMediaView P;
    public RelativeLayout Q;
    public ImageView R;
    public ImageView S;
    public boolean T;
    public float U;
    public float V;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z2.this.onClick(view, ClickAreaType.TYPE_OTHER);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z2 z2Var = z2.this;
            MimoAdInfo mimoAdInfo = z2Var.f;
            z2Var.b((!mimoAdInfo.t() || w6.a(y8.f5752a, mimoAdInfo)) ? mimoAdInfo.w1 : mimoAdInfo.t1);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z2 z2Var = z2.this;
            z2Var.b(z2Var.f.k());
        }
    }

    public z2(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public z2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.T = false;
        this.U = 0.0f;
        this.V = 1.0f;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(int i) {
        b(ijiami_1011.s.s.s.d(new byte[]{-128, -28, -103, -128, -16, -6, -123, -39, -58, 104, -44, -46, -44, -115, -70, -46, -125, -40, -10, -127, -61, -12, -44, -17, -41}, "fe4eff"));
        this.N.setGetReward(true);
        this.N.setText(this.f.i());
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void a(View view) {
        super.a(view);
        this.I = (CloseICP) view.findViewById(a0.i2);
        this.L = (TextView) view.findViewById(a0.s0);
        this.N = (DownloadButtonICP) view.findViewById(a0.T0);
        this.O = (RewardMiniGamePBottomView) view.findViewById(a0.o2);
        this.P = (MimoMediaView) view.findViewById(a0.L3);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a0.B4);
        this.Q = relativeLayout;
        relativeLayout.setOnClickListener(new a());
        this.K = (ImageView) view.findViewById(a0.F0);
        this.J = (RelativeLayout) view.findViewById(a0.x2);
        this.M = (LinearLayout) view.findViewById(a0.Q2);
        this.R = (ImageView) view.findViewById(a0.Y4);
        this.S = (ImageView) view.findViewById(a0.X4);
        this.U = this.L.getLineSpacingExtra();
        this.V = this.L.getLineSpacingMultiplier();
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public boolean a(int i, long j) {
        if (this.y) {
            return true;
        }
        if (i == 4 && j < ((long) this.f.C0) * 1000) {
            return true;
        }
        if (!this.f.A()) {
            return false;
        }
        if (this.f.f1.contains(ijiami_1011.s.s.s.d(new byte[]{85, 11, 9, Ascii.SYN, 92, 83, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 95, 11, 10}, "6ddf06"))) {
            return (i == 4 || i == 3) ? false : true;
        }
        return i != 5;
    }

    public final boolean a(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void b(int i) {
        MimoAdInfo mimoAdInfo = this.f;
        b((!mimoAdInfo.t() || w6.a(y8.f5752a, mimoAdInfo)) ? mimoAdInfo.w1 : mimoAdInfo.t1);
        this.N.setGetReward(false);
        if (this.f.f1.contains(ijiami_1011.s.s.s.d(new byte[]{90, 10, 14, 68, 10, 82, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 80, 10, 13}, "9ec4f7"))) {
            this.N.setText(this.f.m());
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        DownloadButtonICP downloadButtonICP = this.N;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getCloseView() {
        return this.I;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View[] getDownloadViews() {
        return new View[]{this.N};
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public View getGuideTargetView() {
        return this.N;
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public int getLayoutId() {
        MimoAdInfo mimoAdInfo = this.f;
        if (mimoAdInfo != null) {
            if (mimoAdInfo.p0.trim().contains(ijiami_1011.s.s.s.d(new byte[]{13, 94, 1, 6, 10, Ascii.DC2, 8, Ascii.DC2, 3, 38, 67, 4, 19, 85, 16}, "d0bcdf"))) {
                return a0.R1;
            }
            if (this.f.p0.trim().contains(ijiami_1011.s.s.s.d(new byte[]{94, 90, 90, 80, 12, 65, 8, Ascii.DC2, 3, 36, 68, 9, 91, 103, 90, 71, 7, 80, 15}, "7495b5"))) {
                return a0.g2;
            }
        }
        return a0.M1;
    }

    public final boolean m() {
        return this.f.t() && !w6.a(y8.f5752a, this.f);
    }

    public final boolean n() {
        return com.miui.zeus.mimo.sdk.b.h(this.f.f()) || com.miui.zeus.mimo.sdk.b.h(this.f.B);
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        if (!this.y && ClickAreaType.TYPE_CLOSE == clickAreaType && this.z != null && this.f.o() == 2 && this.z.b() && ijiami_1011.s.s.s.d(new byte[]{7, 90, 85, Ascii.DC4, 8, 0, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 13, 90, 86}, "d58dde").equals(this.f.f1)) {
            k();
        } else {
            super.onClick(view, clickAreaType);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.n
    public void onDownloadPaused(String str) {
        if (this.y || !this.f.f1.contains(ijiami_1011.s.s.s.d(new byte[]{91, 14, 89, Ascii.NAK, 13, 0, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 81, 14, 90}, "8a4eae"))) {
            return;
        }
        this.T = true;
        x8.e(new b());
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.n
    public void onDownloadProgressUpdated(String str, int i) {
        if (!this.y && this.T && this.f.f1.contains(ijiami_1011.s.s.s.d(new byte[]{7, 10, 95, Ascii.NAK, 10, 0, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 13, 10, 92}, "de2efe"))) {
            this.T = false;
            x8.e(new c());
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j2, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        ViewGroup.LayoutParams layoutParams;
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams2;
        Context context2;
        float f2;
        this.A = false;
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        if (mimoAdInfo == null) {
            return;
        }
        this.I.setClickAreaListener(this);
        this.N.a(mimoAdInfo, false, true, this, true);
        this.O.a(mimoAdInfo, w3Var, this);
        AdMarkICP adMarkICP = this.O.e;
        MimoAdInfo mimoAdInfo2 = this.f;
        adMarkICP.f5687a.setText(mimoAdInfo2.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo2, this));
        MimoAdInfo mimoAdInfo3 = this.f;
        if (mimoAdInfo3 != null) {
            String strTrim = mimoAdInfo3.p0.trim();
            if (strTrim.contains(ijiami_1011.s.s.s.d(new byte[]{93, 94, 83, 80, 90, 70, 8, Ascii.DC2, 3, 48, 84, 1, 100, 81, 83, 94, 81, 70}, "400542"))) {
                if (a(activity)) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
                    layoutParams3.removeRule(3);
                    layoutParams3.removeRule(14);
                    layoutParams3.addRule(17, this.J.getId());
                    layoutParams3.addRule(6, this.J.getId());
                    layoutParams3.topMargin = f9.a(getContext(), 0.0f);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
                if (this.f.z() || m() || !n()) {
                    ImageView imageView = this.K;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    layoutParams5.topMargin = f9.a(getContext(), 49.5f);
                    this.P.setVisibility(8);
                    this.f5482a.setVisibility(8);
                    this.O.a();
                    layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                    context2 = getContext();
                    f2 = 14.5f;
                } else {
                    ImageView imageView2 = this.K;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                    layoutParams5.topMargin = f9.a(getContext(), 15.0f);
                    this.P.setVisibility(0);
                    findViewById(a0.J4).getLayoutParams().height = f9.a(getContext(), 140.0f);
                    layoutParams4.removeRule(3);
                    layoutParams4.addRule(3, this.P.getId());
                    this.Q.getLayoutParams().height = f9.a(getContext(), 355.0f);
                    layoutParams4.topMargin = f9.a(getContext(), 0.0f);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                    if (this.c.getVisibility() != 0) {
                        context2 = getContext();
                        f2 = 28.0f;
                    } else {
                        context2 = getContext();
                        f2 = 24.0f;
                    }
                }
                layoutParams2.bottomMargin = f9.a(context2, f2);
                this.O.a();
                this.P.setOutlineProvider(new t6(f9.a(getContext(), 11.0f)));
                this.P.setClipToOutline(true);
            } else if (strTrim.contains(ijiami_1011.s.s.s.d(new byte[]{15, 11, 83, 6, 10, SignedBytes.MAX_POWER_OF_TWO, 8, Ascii.DC2, 3, 38, 67, 4, 17, 0, 66}, "fe0cd4"))) {
                if (a(activity)) {
                    this.Q.getLayoutParams().height = f9.a(getContext(), 269.8f);
                    this.Q.getLayoutParams().width = f9.a(getContext(), 533.45f);
                }
                if (this.f.z() || m() || !n()) {
                    this.P.setVisibility(8);
                    this.f5482a.setVisibility(8);
                    this.O.a();
                } else {
                    this.P.setVisibility(0);
                    findViewById(a0.U2).setVisibility(0);
                    if (a(activity)) {
                        this.Q.getLayoutParams().height = f9.a(getContext(), 318.5f);
                        this.P.getLayoutParams().height = f9.a(getContext(), 136.86f);
                        this.P.getLayoutParams().width = f9.a(getContext(), 243.27f);
                    } else {
                        this.Q.getLayoutParams().height = f9.a(getContext(), 429.8f);
                    }
                    LinearLayout linearLayout = (LinearLayout) findViewById(a0.S0);
                    if (linearLayout != null) {
                        ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = f9.a(getContext(), 73.7f);
                        if (a(activity)) {
                            linearLayout.setOrientation(0);
                            linearLayout.setGravity(16);
                            ((LinearLayout.LayoutParams) this.O.getLayoutParams()).setMarginStart(f9.a(getContext(), 14.45f));
                            this.O.b();
                        }
                    }
                }
                SixElementsView sixElementsView = this.c;
                if (sixElementsView != null) {
                    sixElementsView.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 82, 0, 83, 5, 81, 81, 84, 86}, "6d6c5a")));
                }
                this.P.setOutlineProvider(new t6(f9.a(getContext(), 20.0f)));
                this.P.setClipToOutline(true);
            } else if (strTrim.contains(ijiami_1011.s.s.s.d(new byte[]{93, 90, 87, 4, 11, 71, 8, Ascii.DC2, 3, 36, 68, 9, 88, 103, 87, 19, 0, 86, 15}, "444ae3"))) {
                if (a(activity)) {
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
                    layoutParams6.removeRule(2);
                    layoutParams6.addRule(6, this.Q.getId());
                    layoutParams6.addRule(19, this.Q.getId());
                    layoutParams6.removeRule(21);
                    layoutParams6.setMarginEnd(f9.a(getContext(), -40.0f));
                }
                if (this.f.z() || m() || !n()) {
                    this.P.setVisibility(8);
                    this.f5482a.setVisibility(8);
                    this.O.setIconSize(1);
                } else {
                    this.P.setVisibility(0);
                    findViewById(a0.U2).setVisibility(0);
                    LinearLayout linearLayout2 = (LinearLayout) findViewById(a0.S0);
                    if (linearLayout2 != null) {
                        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams();
                        layoutParams7.topMargin = f9.a(getContext(), 24.72f);
                        if (f9.c(getContext()) < 1940) {
                            layoutParams = this.Q.getLayoutParams();
                            context = getContext();
                            f = 480.45f;
                        } else {
                            layoutParams = this.Q.getLayoutParams();
                            context = getContext();
                            f = 545.45f;
                        }
                        layoutParams.width = f9.a(context, f);
                        if (a(activity)) {
                            this.L.setMaxLines(1);
                            layoutParams7.topMargin = f9.a(getContext(), 20.0f);
                            ((RelativeLayout.LayoutParams) ((LinearLayout) findViewById(a0.r5)).getLayoutParams()).topMargin = f9.a(getContext(), 7.27f);
                            linearLayout2.setOrientation(0);
                            ((RelativeLayout.LayoutParams) this.N.getLayoutParams()).topMargin = f9.a(getContext(), 0.0f);
                            this.P.getLayoutParams().height = f9.a(getContext(), 128.27f);
                            this.P.getLayoutParams().width = f9.a(getContext(), 228.0f);
                            linearLayout2.setGravity(16);
                            ((LinearLayout.LayoutParams) this.O.getLayoutParams()).setMarginStart(f9.a(getContext(), 14.45f));
                            this.L.setMaxLines(1);
                            this.O.b();
                        }
                    }
                    this.P.setOutlineProvider(new t6(f9.a(getContext(), 11.0f)));
                    this.P.setClipToOutline(true);
                }
                this.O.a();
                this.P.setOutlineProvider(new t6(f9.a(getContext(), 11.0f)));
                this.P.setClipToOutline(true);
            }
        }
        b(mimoAdInfo.k());
        this.L.setTypeface(Typeface.DEFAULT_BOLD);
        setCLickAreaListener(null);
        this.P.setViewClickAreaType(ClickAreaType.TYPE_VIDEO);
        this.P.setPicStartCountDown(false);
        this.P.setLooping(true);
        SixElementsView sixElementsView2 = this.c;
        MimoAdInfo mimoAdInfo4 = this.f;
        String str = mimoAdInfo4.i;
        String str2 = mimoAdInfo4.k;
        String strE = mimoAdInfo4.e();
        MimoAdInfo mimoAdInfo5 = this.f;
        sixElementsView2.a(str, str2, strE, mimoAdInfo5.m, mimoAdInfo5.l, mimoAdInfo5.n, true);
        this.c.setGravity(17);
    }

    @Override // com.miui.zeus.mimo.sdk.j2
    public void b(String str) {
        TextView textView;
        Context context;
        float f;
        if (str == null) {
            str = ijiami_1011.s.s.s.d(new byte[]{-124, -72, -52, -122, -92, -2, -123, -39, -58, -118, -65, -46, -121, -121, -10, -121, -118, -30, -121, -56, -57, 89, -40, -57, -28, -36, -18, -11, -41, -57, -9, -126, -6, -40, -43, -39, -8}, "b9ac2b");
        }
        String strReplace = str.replace(ijiami_1011.s.s.s.d(new byte[]{15}, "4a1b47"), IOUtils.LINE_SEPARATOR_UNIX);
        Matcher matcher = Pattern.compile(ijiami_1011.s.s.s.d(new byte[]{100, 87, 73}, "83b61e")).matcher(strReplace);
        SpannableString spannableString = new SpannableString(strReplace);
        String strD = ijiami_1011.s.s.s.d(new byte[]{26, 15, 4, 0, 36, 1, 83}, "9931f0");
        String strD2 = ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 35, 34, 80, 1, 2, 88}, "6ede87");
        if (this.f.p0.trim().contains(ijiami_1011.s.s.s.d(new byte[]{89, 12, 90, 82, 8, Ascii.DC2, 8, Ascii.DC2, 3, 36, 68, 9, 92, 49, 90, 69, 3, 3, 15}, "0b97ff"))) {
            strD = ijiami_1011.s.s.s.d(new byte[]{66, 36, 35, 32, 115, 37, 34}, "abef6c");
            strD2 = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 34, 114, 115, 112, 118, 34}, "4d4550");
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(strD)), 0, strReplace.length(), 33);
        boolean z = false;
        int iStart = 0;
        while (matcher.find()) {
            iStart = matcher.start();
            int iEnd = matcher.end();
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(strD2)), iStart, iEnd, 33);
            } catch (IllegalArgumentException unused) {
            }
            spannableString.setSpan(new RelativeSizeSpan(1.3f), iStart, iEnd, 33);
            z = true;
        }
        this.L.setLineSpacing((!z || iStart <= 9) ? this.U : this.U - 10.0f, this.V);
        if (spannableString.length() > 15) {
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            textView = this.L;
            context = getContext();
            f = 249.0f;
        } else {
            this.R.setVisibility(0);
            this.S.setVisibility(0);
            textView = this.L;
            context = getContext();
            f = 149.0f;
        }
        textView.setMaxWidth(f9.a(context, f));
        this.L.setText(spannableString);
    }
}

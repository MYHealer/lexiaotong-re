package com.miui.zeus.mimo.sdk.ad.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h7;
import com.miui.zeus.mimo.sdk.j2;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardPSkipCountDownView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f5321a;
    public final ViewGroup b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public boolean h;
    public c i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = RewardPSkipCountDownView.this.i;
            if (cVar != null) {
                ClickAreaType clickAreaType = ClickAreaType.TYPE_COUNTDOWN;
                j2 j2Var = j2.this;
                j2Var.onClick(j2Var.i, clickAreaType);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = RewardPSkipCountDownView.this.i;
            if (cVar != null) {
                j2.j jVar = (j2.j) cVar;
                if (j2.b(j2.this)) {
                    j2 j2Var = j2.this;
                    j2Var.C = true;
                    int iO = j2Var.f.o();
                    if (iO == 0 || (iO == 2 && j2Var.y)) {
                        j2Var.a(AdEvent.CLOSE, k6.a(s.d(new byte[]{54}, "f10efd"), j2Var.getClickViewInfo(view), null));
                        j2Var.a();
                        return;
                    }
                    if (iO == 2) {
                        AdEvent adEvent = AdEvent.SKIP;
                        long j = j2Var.j;
                        k6 k6Var = new k6();
                        k6Var.g = String.valueOf(j);
                        j2Var.a(adEvent, k6Var);
                        j2Var.k();
                        return;
                    }
                    if (!j2Var.y && ((!j2Var.l && j2Var.k == 1) || (!j2Var.m && j2Var.k == 2))) {
                        AdEvent adEvent2 = AdEvent.SKIP;
                        long j2 = j2Var.j;
                        k6 k6Var2 = new k6();
                        k6Var2.g = String.valueOf(j2);
                        j2Var.a(adEvent2, k6Var2);
                        w3 w3Var = j2Var.g;
                        if (w3Var != null) {
                            w3Var.onVideoSkip();
                        }
                    }
                    j2Var.b();
                    h7 h7Var = j2Var.n;
                    if (h7Var != null && h7Var.isShowing()) {
                        j2Var.n.dismiss();
                    }
                    MimoVideoTipsView mimoVideoTipsView = j2Var.d;
                    if (mimoVideoTipsView == null || mimoVideoTipsView.getVisibility() != 0) {
                        return;
                    }
                    j2Var.d.a();
                }
            }
        }
    }

    public interface c {
    }

    public RewardPSkipCountDownView(Context context) {
        this(context, null);
    }

    public RewardPSkipCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardPSkipCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View viewInflate = LayoutInflater.from(context).inflate(a0.t3, (ViewGroup) this, true);
        this.f5321a = (ViewGroup) viewInflate.findViewById(a0.M0);
        this.e = (TextView) viewInflate.findViewById(a0.c2);
        this.f = (TextView) viewInflate.findViewById(a0.I5);
        this.b = (ViewGroup) viewInflate.findViewById(a0.Z4);
        this.c = (TextView) viewInflate.findViewById(a0.B3);
        TextView textView = (TextView) viewInflate.findViewById(a0.J5);
        this.d = textView;
        this.g = viewInflate.findViewById(a0.Y1);
        ((ViewGroup) viewInflate.findViewById(a0.u2)).setOnClickListener(new a());
        textView.setOnClickListener(new b());
    }

    public void a() {
        if (this.h) {
            return;
        }
        this.f5321a.setVisibility(0);
        this.b.setVisibility(8);
    }

    public void a(String str) {
        if (this.h) {
            return;
        }
        this.f5321a.setVisibility(8);
        this.b.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.c.setText(String.valueOf(0));
        } else {
            this.c.setText(str);
        }
    }

    public View getSkipView() {
        return this.d;
    }

    public void setOnItemClickListener(c cVar) {
        this.i = cVar;
    }
}

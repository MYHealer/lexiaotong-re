package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.m7;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoVideoTipsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdMarkICP f5675a;
    public BrandICP b;
    public IconICP c;
    public TextView d;
    public SixElementsView e;
    public TextView f;
    public TextView g;
    public ViewGroup h;
    public MimoAdInfo i;
    public d j;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5676a;

        public a(i8 i8Var) {
            this.f5676a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoVideoTipsView.this.a();
            i8 i8Var = this.f5676a;
            if (i8Var != null) {
                i8Var.onClick(view, ClickAreaType.TYPE_TIPS_OTHER);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MimoAdInfo f5677a;

        public b(MimoAdInfo mimoAdInfo) {
            this.f5677a = mimoAdInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoVideoTipsView.this.a();
            com.miui.zeus.mimo.sdk.b.a(AdEvent.CONFIRM_POPUP_WINDOW_QUIT, this.f5677a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f5678a;

        public c(d dVar) {
            this.f5678a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = this.f5678a;
            if (dVar != null) {
                dVar.a(view, ClickAreaType.TYPE_TIPS_BUTTON);
            }
            MimoVideoTipsView.this.a();
        }
    }

    public interface d {
        void a();

        void a(View view, ClickAreaType clickAreaType);
    }

    public MimoVideoTipsView(Context context) {
        this(context, null);
    }

    public MimoVideoTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoVideoTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void a() {
        setVisibility(8);
        d dVar = this.j;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void a(MimoAdInfo mimoAdInfo, SixElementsView.e eVar, i8 i8Var, w3 w3Var, d dVar) {
        if (mimoAdInfo == null) {
            return;
        }
        this.i = mimoAdInfo;
        this.j = dVar;
        this.c.a(com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.b(w3Var)) ? mimoAdInfo.b(w3Var) : mimoAdInfo.A, new m7(this, i8Var));
        AdMarkICP adMarkICP = this.f5675a;
        m7 m7Var = new m7(this, i8Var);
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, m7Var));
        this.b.a(mimoAdInfo.i, new m7(this, i8Var));
        this.e.setVisibility(mimoAdInfo.D() ? 0 : 8);
        this.e.a(null, null, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, true);
        this.d.setText(mimoAdInfo.k);
        this.g.setText(mimoAdInfo.g());
        this.e.setOnItemClickListener(eVar);
        this.h.setOnClickListener(new a(i8Var));
        this.f.setOnClickListener(new b(mimoAdInfo));
        this.g.setOnClickListener(new c(dVar));
    }

    public final void b() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(a0.y4, (ViewGroup) this, true);
        this.f5675a = (AdMarkICP) viewInflate.findViewById(a0.H4);
        this.c = (IconICP) viewInflate.findViewById(a0.b);
        this.b = (BrandICP) viewInflate.findViewById(a0.p);
        this.d = (TextView) viewInflate.findViewById(a0.p1);
        this.e = (SixElementsView) viewInflate.findViewById(a0.E5);
        this.g = (TextView) viewInflate.findViewById(a0.i3);
        this.f = (TextView) viewInflate.findViewById(a0.N4);
        this.h = (ViewGroup) viewInflate.findViewById(a0.t0);
        this.e.setTextColor(Color.parseColor(s.d(new byte[]{66, 84, 15, 8, 1, 83, 81, 84, 86}, "ab981c")));
        setFocusable(true);
        setClickable(true);
    }

    public void c() {
        setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 350.0f), -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.leftMargin = f9.a(getContext(), 21.8f);
        layoutParams.rightMargin = f9.a(getContext(), 21.8f);
        layoutParams.bottomMargin = f9.a(getContext(), 60.0f);
        this.h.setLayoutParams(layoutParams);
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CONFIRM_POPUP_WINDOW_VIEW, this.i);
    }
}

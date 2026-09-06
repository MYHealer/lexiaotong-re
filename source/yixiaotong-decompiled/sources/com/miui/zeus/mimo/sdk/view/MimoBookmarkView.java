package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoBookmarkView extends RelativeLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f5664a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public int e;
    public int f;
    public float g;
    public float h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MimoBookmarkView.this.f5664a.getHeight();
            MimoBookmarkView.this.f5664a.getWidth();
            MimoBookmarkView mimoBookmarkView = MimoBookmarkView.this;
            mimoBookmarkView.c.setX((mimoBookmarkView.f5664a.getX() - f9.a(MimoBookmarkView.this.getContext(), 3.6f)) + MimoBookmarkView.this.e);
            MimoBookmarkView mimoBookmarkView2 = MimoBookmarkView.this;
            mimoBookmarkView2.c.setY((mimoBookmarkView2.f5664a.getY() - f9.a(MimoBookmarkView.this.getContext(), 194.0f)) + f9.a(MimoBookmarkView.this.getContext(), 11.2f) + MimoBookmarkView.this.f);
            MimoBookmarkView mimoBookmarkView3 = MimoBookmarkView.this;
            mimoBookmarkView3.addView(mimoBookmarkView3.c, mimoBookmarkView3.b());
        }
    }

    public MimoBookmarkView(Context context) {
        this(context, null);
    }

    public MimoBookmarkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoBookmarkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.f = 0;
        this.g = 0.0f;
        this.h = 0.0f;
        c();
    }

    public final RelativeLayout.LayoutParams a() {
        RelativeLayout.LayoutParams layoutParams;
        int iD = f9.d(getContext());
        if (f9.c(getContext()) < iD) {
            f9.d(getContext());
            iD = f9.c(getContext());
        }
        if (getResources().getConfiguration().orientation == 2) {
            int iA = (int) (((double) (iD - f9.a(getContext(), 112.7f))) * 0.854d);
            int iA2 = f9.a(getContext(), 42.7f);
            layoutParams = new RelativeLayout.LayoutParams((int) (((double) iA) * 1.78d), iA);
            layoutParams.setMargins(0, 0, 0, iA2);
        } else {
            int iA3 = f9.a(getContext(), 9.0f);
            int iD2 = f9.d(getContext()) - (f9.a(getContext(), 35.0f) * 2);
            layoutParams = new RelativeLayout.LayoutParams(iD2, (int) (iD2 * 1.78f));
            layoutParams.setMargins(0, 0, 0, iA3);
        }
        layoutParams.addRule(13);
        return layoutParams;
    }

    public void a(View view) {
        RelativeLayout relativeLayout = this.f5664a;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.removeAllViews();
        this.f5664a.addView(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    public final RelativeLayout.LayoutParams b() {
        Context context;
        float f;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 123.0f), f9.a(getContext(), 192.0f));
        if (getResources().getConfiguration().orientation == 2) {
            this.e = f9.a(getContext(), 8.3f);
            context = getContext();
            f = 29.0f;
        } else {
            this.e = f9.a(getContext(), 18.3f);
            context = getContext();
            f = 32.0f;
        }
        this.f = f9.a(context, f);
        this.g = this.e + f9.a(getContext(), 12.7f);
        this.h = this.f - f9.a(getContext(), 18.0f);
        return layoutParams;
    }

    public final void c() {
        int iA;
        int iA2;
        setClipChildren(false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f5664a = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.f5664a.post(new a());
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        this.b = relativeLayout2;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(s.d(new byte[]{Ascii.ESC, 114, 113, 32, 36, 112, 88}, "847ea4")));
        gradientDrawable.setCornerRadius(f9.a(getContext(), 14.5f));
        relativeLayout2.setBackground(gradientDrawable);
        ImageView imageView = new ImageView(getContext());
        this.c = imageView;
        imageView.setImageResource(a0.V4);
        this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.c.setLayoutParams(b());
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setId(View.generateViewId());
        this.d.setEms(1);
        this.d.setGravity(17);
        this.d.setText(s.d(new byte[]{-45, -126, -78, -128, -11, -61, -121, -22, -50, -118, -68, -11}, "798fbf"));
        this.d.setTextColor(Color.parseColor(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 2, 0, 10, 119, 0, 32}, "c59920")));
        this.d.setTypeface(Typeface.defaultFromStyle(1));
        this.d.setLineSpacing(0.0f, 0.9f);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(a0.j5);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 13.0f), f9.a(getContext(), 13.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(21);
        if (getResources().getConfiguration().orientation == 2) {
            iA = f9.a(getContext(), 10.0f);
            iA2 = f9.a(getContext(), 11.0f);
        } else {
            iA = f9.a(getContext(), 20.0f);
            iA2 = f9.a(getContext(), 20.0f);
        }
        layoutParams.setMargins(0, 0, iA, iA2);
        imageView2.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(21);
        layoutParams2.addRule(2, imageView2.getId());
        if (getResources().getConfiguration().orientation == 2) {
            layoutParams2.setMargins(0, 0, f9.a(getContext(), 10.0f), f9.a(getContext(), 2.0f));
            this.d.setTextSize(1, 11.0f);
        } else {
            layoutParams2.setMargins(0, 0, f9.a(getContext(), 20.0f), f9.a(getContext(), 2.0f));
            this.d.setTextSize(1, 13.0f);
        }
        this.d.setLayoutParams(layoutParams2);
        this.b.addView(this.d);
        this.b.addView(imageView2);
        addView(this.b, a());
        addView(this.f5664a, a());
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_OTHER;
    }

    public void setRecommendText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }
}

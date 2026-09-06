package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import java.math.BigDecimal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoScoreView extends LinearLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f5670a;
    public TextView b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public LinearLayout h;
    public i8 i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoScoreView mimoScoreView = MimoScoreView.this;
            i8 i8Var = mimoScoreView.i;
            if (i8Var != null) {
                i8Var.onClick(mimoScoreView, mimoScoreView.getClickAreaType());
            }
        }
    }

    public MimoScoreView(Context context) {
        this(context, null);
    }

    public MimoScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MimoScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = true;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(a0.H0, (ViewGroup) null, false);
        this.h = linearLayout;
        addView(linearLayout);
        a(this.h);
    }

    public final int a(double d, double d2) {
        return new BigDecimal(d).compareTo(new BigDecimal(d2));
    }

    public final ImageView a(int i, int i2) {
        int i3;
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.e, this.f);
        layoutParams.leftMargin = i2 == 0 ? 0 : this.g;
        imageView.setLayoutParams(layoutParams);
        if (i == 0) {
            i3 = a0.w;
        } else {
            i3 = i == 1 ? a0.G3 : a0.a1;
        }
        imageView.setImageResource(i3);
        return imageView;
    }

    public void a(double d, String str, i8 i8Var) {
        int i;
        ImageView imageViewA;
        this.i = i8Var;
        if (!this.c) {
            this.h.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.topMargin = this.d;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.b.setLayoutParams(layoutParams);
        }
        this.f5670a.removeAllViews();
        double dFloor = Math.floor(d);
        double d2 = 0.5d + dFloor;
        if (a(d, dFloor) != 0) {
            d = (a(d, dFloor) <= 0 || a(d, d2) > 0) ? Math.ceil(d) : d2;
        }
        double dFloor2 = Math.floor(d);
        int i2 = -1;
        if (a(d, dFloor2) == 0) {
            i = ((int) dFloor2) - 1;
        } else {
            int i3 = (int) dFloor2;
            int i4 = i3 - 1;
            i2 = i4 < 4 ? i3 : -1;
            i = i4;
        }
        int i5 = 0;
        while (i5 < 5) {
            LinearLayout linearLayout = this.f5670a;
            if (i5 <= i) {
                imageViewA = a(2, i5);
            } else {
                imageViewA = i5 <= i2 ? a(1, i5) : a(0, i5);
            }
            linearLayout.addView(imageViewA);
            i5++;
        }
        if (TextUtils.isEmpty(str)) {
            this.b.setText("");
        } else {
            this.b.setText(str);
        }
        setOnClickListener(new a());
    }

    public final void a(View view) {
        this.f5670a = (LinearLayout) view.findViewById(a0.a2);
        this.b = (TextView) view.findViewById(a0.t);
        this.e = f9.a(getContext(), 9.4f);
        this.f = f9.a(getContext(), 9.21f);
        this.g = f9.a(getContext(), 3.69f);
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_SCORE_TAG;
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTextSize(float f) {
        this.b.setTextSize(1, f);
    }
}

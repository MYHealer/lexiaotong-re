package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.l8;
import com.miui.zeus.mimo.sdk.m8;
import com.miui.zeus.mimo.sdk.n8;
import com.miui.zeus.mimo.sdk.o8;
import com.miui.zeus.mimo.sdk.p8;
import ijiami_1011.s.s.s;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SixElementsView extends LinearLayout implements h8 {
    public static final /* synthetic */ int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5707a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public e i;
    public int j;
    public int k;
    public int l;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = SixElementsView.this.getWidth();
            int height = SixElementsView.this.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            SixElementsView.a(SixElementsView.this);
            SixElementsView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SixElementsView sixElementsView = SixElementsView.this;
            e eVar = sixElementsView.i;
            if (eVar != null) {
                eVar.a(sixElementsView.d);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SixElementsView sixElementsView = SixElementsView.this;
            e eVar = sixElementsView.i;
            if (eVar != null) {
                eVar.a(sixElementsView.e);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SixElementsView sixElementsView = SixElementsView.this;
            e eVar = sixElementsView.i;
            if (eVar != null) {
                eVar.a(sixElementsView.f);
            }
        }
    }

    public interface e {
        void a(String str);
    }

    public SixElementsView(Context context) {
        this(context, null);
    }

    public SixElementsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SixElementsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 16;
        this.j = Color.parseColor(s.d(new byte[]{Ascii.ETB, 6, 112, 114, 36, 118, 39, 34, 32}, "4244b0"));
        this.k = Color.parseColor(s.d(new byte[]{26, 0, 4, 118, 119, 113, 39, 34, 32}, "937017"));
        a(context, attributeSet);
    }

    public static void a(SixElementsView sixElementsView) {
        int childCount = sixElementsView.getChildCount();
        if (childCount <= 0) {
            ViewGroup.LayoutParams layoutParams = sixElementsView.getLayoutParams();
            layoutParams.width = 0;
            sixElementsView.setLayoutParams(layoutParams);
            return;
        }
        float fA = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = sixElementsView.getChildAt(i);
            if (childAt != null) {
                fA += childAt instanceof TextView ? sixElementsView.a((TextView) childAt) : childAt.getWidth();
            }
        }
        if (fA <= sixElementsView.getWidth()) {
            sixElementsView.l = 1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = sixElementsView.getChildAt(i2);
                if (childAt2 != null) {
                    childAt2.setVisibility(0);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = sixElementsView.getLayoutParams();
            layoutParams2.width = (int) fA;
            sixElementsView.setLayoutParams(layoutParams2);
            return;
        }
        if (sixElementsView.g) {
            sixElementsView.l = 1;
            sixElementsView.removeAllViews();
            sixElementsView.setOrientation(0);
            sixElementsView.setGravity(sixElementsView.h);
            sixElementsView.a();
            sixElementsView.getViewTreeObserver().addOnGlobalLayoutListener(new l8(sixElementsView));
            return;
        }
        sixElementsView.l = 2;
        sixElementsView.removeAllViews();
        sixElementsView.setOrientation(1);
        TextView textViewA = sixElementsView.a(sixElementsView.f5707a, 0);
        TextView textViewA2 = sixElementsView.a(sixElementsView.b, 1);
        TextView textViewA3 = sixElementsView.a(sixElementsView.c, 2);
        TextView textViewA4 = sixElementsView.a(sixElementsView.d, 3);
        TextView textViewA5 = sixElementsView.a(sixElementsView.e, 4);
        TextView textViewA6 = sixElementsView.a(sixElementsView.f, 5);
        LinearLayout linearLayout = new LinearLayout(sixElementsView.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(sixElementsView.h);
        LinearLayout sixElementDiverView = sixElementsView.getSixElementDiverView();
        if (textViewA != null) {
            linearLayout.addView(textViewA);
            if (textViewA2 != null) {
                linearLayout.addView(sixElementDiverView);
            }
            textViewA.setVisibility(4);
            sixElementDiverView.setVisibility(4);
        }
        if (textViewA2 != null) {
            linearLayout.addView(textViewA2);
            textViewA2.setVisibility(4);
        }
        sixElementsView.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(sixElementsView.getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(sixElementsView.h);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = f9.a(sixElementsView.getContext(), 2.0f);
        linearLayout2.setLayoutParams(layoutParams3);
        LinearLayout sixElementDiverView2 = sixElementsView.getSixElementDiverView();
        if (textViewA3 != null) {
            linearLayout2.addView(textViewA3);
            if (textViewA4 != null || textViewA5 != null || textViewA6 != null) {
                linearLayout2.addView(sixElementDiverView2);
            }
            textViewA3.setVisibility(4);
            sixElementDiverView2.setVisibility(4);
        }
        LinearLayout sixElementDiverView3 = sixElementsView.getSixElementDiverView();
        if (textViewA4 != null) {
            textViewA4.setOnClickListener(new m8(sixElementsView));
            linearLayout2.addView(textViewA4);
            if (textViewA5 != null || textViewA6 != null) {
                linearLayout2.addView(sixElementDiverView3);
            }
            textViewA4.setVisibility(4);
            sixElementDiverView3.setVisibility(4);
        }
        LinearLayout sixElementDiverView4 = sixElementsView.getSixElementDiverView();
        if (textViewA5 != null) {
            textViewA5.setOnClickListener(new n8(sixElementsView));
            linearLayout2.addView(textViewA5);
            if (textViewA6 != null) {
                linearLayout2.addView(sixElementDiverView4);
            }
            textViewA5.setVisibility(4);
            sixElementDiverView4.setVisibility(4);
        }
        if (textViewA6 != null) {
            textViewA6.setOnClickListener(new o8(sixElementsView));
            linearLayout2.addView(textViewA6);
            textViewA6.setVisibility(4);
        }
        sixElementsView.addView(linearLayout2);
        sixElementsView.getViewTreeObserver().addOnGlobalLayoutListener(new p8(sixElementsView, linearLayout, textViewA, textViewA2, linearLayout2, textViewA3));
    }

    private LinearLayout getSixElementDiverView() {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f9.a(getContext(), 0.73f), f9.a(getContext(), 8.73f));
        layoutParams.leftMargin = f9.a(getContext(), 3.64f);
        layoutParams.rightMargin = f9.a(getContext(), 3.64f);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(this.k);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(view);
        return linearLayout;
    }

    public final float a(TextView textView) {
        TextPaint paint;
        if (textView == null) {
            return 0.0f;
        }
        String string = textView.getText().toString();
        if (TextUtils.isEmpty(string) || (paint = textView.getPaint()) == null) {
            return 0.0f;
        }
        return paint.measureText(string);
    }

    public final int a(List<TextView> list) {
        int i = -1;
        if (list.isEmpty()) {
            return -1;
        }
        float f = 2.14748365E9f;
        for (int i2 = 0; i2 < list.size(); i2++) {
            float fA = a(list.get(i2));
            if (fA < f) {
                i = i2;
                f = fA;
            }
        }
        return i;
    }

    public final TextView a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 9.45f);
        if (i == 3) {
            str = s.d(new byte[]{-34, -93, -90, -46, -107, -29}, "79652b");
        } else if (i == 4) {
            str = s.d(new byte[]{-41, -2, -27, -40, -95, -92}, "1cf184");
        } else if (i == 5) {
            str = s.d(new byte[]{-46, -33, -67, -41, -116, -68}, "6d6071");
        }
        textView.setText(str);
        textView.setTag(a0.s, Integer.valueOf(i));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(this.j);
        return textView;
    }

    public final void a() {
        TextView textViewA = a(this.f5707a, 0);
        TextView textViewA2 = a(this.b, 1);
        TextView textViewA3 = a(this.c, 2);
        TextView textViewA4 = a(this.d, 3);
        TextView textViewA5 = a(this.e, 4);
        TextView textViewA6 = a(this.f, 5);
        LinearLayout sixElementDiverView = getSixElementDiverView();
        if (textViewA != null) {
            addView(textViewA);
            if (textViewA2 != null || textViewA3 != null || textViewA4 != null || textViewA5 != null || textViewA6 != null) {
                addView(sixElementDiverView);
            }
            textViewA.setVisibility(4);
            sixElementDiverView.setVisibility(4);
        }
        LinearLayout sixElementDiverView2 = getSixElementDiverView();
        if (textViewA2 != null) {
            addView(textViewA2);
            if (textViewA3 != null || textViewA4 != null || textViewA5 != null || textViewA6 != null) {
                addView(sixElementDiverView2);
            }
            textViewA2.setVisibility(4);
            sixElementDiverView2.setVisibility(4);
        }
        LinearLayout sixElementDiverView3 = getSixElementDiverView();
        if (textViewA3 != null) {
            addView(textViewA3);
            if (textViewA4 != null || textViewA5 != null || textViewA6 != null) {
                addView(sixElementDiverView3);
            }
            textViewA3.setVisibility(4);
            sixElementDiverView3.setVisibility(4);
        }
        LinearLayout sixElementDiverView4 = getSixElementDiverView();
        if (textViewA4 != null) {
            addView(textViewA4);
            if (textViewA5 != null || textViewA6 != null) {
                addView(sixElementDiverView4);
            }
            textViewA4.setOnClickListener(new b());
            textViewA4.setVisibility(4);
            sixElementDiverView4.setVisibility(4);
        }
        LinearLayout sixElementDiverView5 = getSixElementDiverView();
        if (textViewA5 != null) {
            addView(textViewA5);
            if (textViewA6 != null) {
                addView(sixElementDiverView5);
            }
            textViewA5.setOnClickListener(new c());
            textViewA5.setVisibility(4);
            sixElementDiverView5.setVisibility(4);
        }
        if (textViewA6 != null) {
            textViewA6.setOnClickListener(new d());
            addView(textViewA6);
            textViewA6.setVisibility(4);
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.i);
            this.j = typedArrayObtainStyledAttributes.getColor(a0.U4, this.j);
            this.k = typedArrayObtainStyledAttributes.getColor(a0.j4, this.k);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this.f5707a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = z;
        removeAllViews();
        setOrientation(0);
        setGravity(this.h);
        a();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public ClickAreaType getClickAreaType() {
        return null;
    }

    public int getLines() {
        return this.l;
    }

    public int getTextColor() {
        return this.j;
    }

    public void setOnItemClickListener(e eVar) {
        this.i = eVar;
    }

    public void setShowGravity(int i) {
        this.h = i;
        requestLayout();
    }

    public void setTextColor(int i) {
        this.j = i;
        this.k = i;
        invalidate();
    }
}

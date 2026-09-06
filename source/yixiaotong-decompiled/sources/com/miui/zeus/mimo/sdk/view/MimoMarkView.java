package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoMarkView extends LinearLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5667a;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5668a;

        public a(i8 i8Var) {
            this.f5668a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5668a;
            if (i8Var != null) {
                i8Var.onClick(view, MimoMarkView.this.getClickAreaType());
            }
        }
    }

    public MimoMarkView(Context context) {
        super(context);
    }

    public MimoMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MimoMarkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private GradientDrawable getGradientDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f9.a(getContext(), 2.18f));
        gradientDrawable.setColor(Color.parseColor(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 80, 112, 1, 125, 8, 85, 34, 32}, "ca1190")));
        return gradientDrawable;
    }

    public void a(List<String> list, i8 i8Var) {
        this.f5667a = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        removeAllViews();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (!TextUtils.isEmpty(str)) {
                TextView textView = new TextView(getContext());
                textView.setTextSize(2, 10.18f);
                textView.setPadding(f9.a(getContext(), 5.45f), f9.a(getContext(), 1.45f), f9.a(getContext(), 5.45f), f9.a(getContext(), 1.45f));
                textView.setBackground(getGradientDrawable());
                textView.setText(str);
                textView.setTextColor(Color.parseColor(s.d(new byte[]{Ascii.SYN, 83, 39, 15, 80, 117, 39}, "5cc7d3")));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i == 0) {
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = f9.a(getContext(), 5.45f);
                }
                textView.setLayoutParams(layoutParams);
                addView(textView);
                i++;
            }
        }
        setOnClickListener(new a(i8Var));
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_SCORE_TAG;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size;
        int childCount;
        super.onMeasure(i, i2);
        if (this.f5667a && (size = View.MeasureSpec.getSize(i)) > 0 && (childCount = getChildCount()) > 0) {
            int i3 = 0;
            int measuredWidth = 0;
            while (true) {
                if (i3 >= childCount) {
                    i3 = -1;
                    break;
                }
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    measuredWidth += childAt.getMeasuredWidth();
                    if (i3 != 0) {
                        measuredWidth += f9.a(getContext(), 5.45f);
                    }
                    if (measuredWidth >= size) {
                        break;
                    }
                }
                i3++;
            }
            if (i3 == -1) {
                return;
            }
            while (i3 < childCount) {
                View childAt2 = getChildAt(i3);
                if (childAt2 != null) {
                    childAt2.setVisibility(8);
                }
                i3++;
            }
            this.f5667a = false;
        }
    }
}

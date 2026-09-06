package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SkipCountDownView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f5682a;
    public final TextView b;
    public final View c;
    public c d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = SkipCountDownView.this.d;
            if (cVar != null) {
                cVar.clickCountDownView(ClickAreaType.TYPE_COUNTDOWN);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = SkipCountDownView.this.d;
            if (cVar != null) {
                cVar.clickSkipView(view);
            }
        }
    }

    public interface c {
        void clickCountDownView(ClickAreaType clickAreaType);

        void clickSkipView(View view);
    }

    public SkipCountDownView(Context context) {
        this(context, null);
    }

    public SkipCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View viewInflate = LayoutInflater.from(context).inflate(a0.m3, (ViewGroup) this, true);
        TextView textView = (TextView) viewInflate.findViewById(a0.D);
        this.f5682a = textView;
        TextView textView2 = (TextView) viewInflate.findViewById(a0.A2);
        this.b = textView2;
        this.c = viewInflate.findViewById(a0.h0);
        textView.setOnClickListener(new a());
        textView2.setOnClickListener(new b());
    }

    public TextView getCloseView() {
        return this.b;
    }

    public TextView getSkipView() {
        return this.b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setCloseText(String str) {
        this.b.setText(str);
    }

    public void setCountDown(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f5682a.setText(String.valueOf(0));
        } else {
            this.f5682a.setText(str);
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.d = cVar;
    }
}

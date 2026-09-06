package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BrandICP extends TextView implements h8 {

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5690a;

        public a(i8 i8Var) {
            this.f5690a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5690a.onClick(view, BrandICP.this.getClickAreaType());
        }
    }

    public BrandICP(Context context) {
        this(context, null);
    }

    public BrandICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BrandICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a() {
        setTypeface(null, 1);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(String str, i8 i8Var) {
        if (b.g(str)) {
            setVisibility(8);
            return;
        }
        setText(str);
        if (i8Var == null) {
            return;
        }
        setOnClickListener(new a(i8Var));
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_BRAND;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        setTextColor(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        setTextSize(1, f);
    }
}

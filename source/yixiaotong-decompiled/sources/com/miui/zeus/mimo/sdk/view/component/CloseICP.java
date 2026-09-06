package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.i8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CloseICP extends ImageView {

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5699a;

        public a(CloseICP closeICP, i8 i8Var) {
            this.f5699a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5699a;
            if (i8Var != null) {
                i8Var.onClick(view, ClickAreaType.TYPE_CLOSE);
            }
        }
    }

    public CloseICP(Context context) {
        this(context, null);
    }

    public CloseICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void setClickAreaListener(i8 i8Var) {
        setOnClickListener(new a(this, i8Var));
    }
}

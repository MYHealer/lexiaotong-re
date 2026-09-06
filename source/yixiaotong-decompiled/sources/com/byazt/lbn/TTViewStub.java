package com.byazt.lbn;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.ad.constant.ai;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, ai.v, ai.ai})
public final class TTViewStub extends View {
    public WeakReference<View> c;
    public com.byazt.lbn.c tt;
    public c uj;
    public Context ve;

    public interface c {
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public void setOnInflateListener(c cVar) {
        this.uj = cVar;
    }

    public TTViewStub(Context context, com.byazt.lbn.c cVar) {
        super(context);
        this.ve = context;
        this.tt = cVar;
        setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            c();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public View c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        com.byazt.lbn.c cVar = this.tt;
        if (cVar != null) {
            View viewInflate = cVar.inflate(this.ve);
            c(viewInflate, (ViewGroup) parent);
            this.c = new WeakReference<>(viewInflate);
            return viewInflate;
        }
        throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }

    private void c(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }
}

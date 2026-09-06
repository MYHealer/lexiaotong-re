package com.byazt.nz;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.byazt.nw.tt;
import com.byazt.zqa.c;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 817, 980})
public abstract class BaseIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2545a;
    public Context c;
    public float da;
    public int i;
    public int n;
    public float sl;
    public int sp;
    public String t;
    public int tt;
    public List<View> uj;
    public int ve;
    public boolean x;

    public void setIndicatorHeight(int i) {
        this.ve = i;
    }

    public void setIndicatorWidth(int i) {
        this.tt = i;
    }

    public void setIndicatorX(float f) {
        this.da = f;
    }

    public void setIndicatorY(float f) {
        this.sl = f;
    }

    public void setLoop(boolean z) {
        this.x = z;
    }

    public void setSelectedColor(int i) {
        this.n = i;
    }

    public void setUnSelectedColor(int i) {
        this.f2545a = i;
    }

    public abstract Drawable tt(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.n = SupportMenu.CATEGORY_MASK;
        this.f2545a = -16776961;
        this.sp = 5;
        this.tt = 40;
        this.ve = 20;
        this.t = Constant.KEY_ROW;
        this.c = context;
        this.uj = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorDirection(String str) {
        this.t = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void c(int i, int i2) {
        Iterator<View> it = this.uj.iterator();
        while (it.hasNext()) {
            it.next().setBackground(tt(this.f2545a));
        }
        if (i < 0 || i >= this.uj.size()) {
            i = 0;
        }
        if (this.uj.size() > 0) {
            this.uj.get(i).setBackground(tt(this.n));
            this.i = i2;
        }
    }

    public int getSize() {
        return this.uj.size();
    }

    public void c() {
        post(new Runnable() { // from class: com.byazt.nz.BaseIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseIndicator.this.ve();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        float height2 = getHeight();
        float f = this.sl;
        layoutParams.topMargin = (int) (((int) ((height * f) / 100.0f)) - ((height2 * f) / 100.0f));
        float f2 = this.da;
        layoutParams.leftMargin = (int) (((int) ((width * f2) / 100.0f)) - ((width2 * f2) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void c(int i) {
        if (this instanceof DotIndicator) {
            this.ve = this.tt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.sp;
            layoutParams.bottomMargin = this.sp;
        } else {
            layoutParams.leftMargin = this.sp;
            layoutParams.rightMargin = this.sp;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.sp;
            layoutParams2.bottomMargin = this.sp;
        } else {
            layoutParams2.leftMargin = this.sp;
            layoutParams2.rightMargin = this.sp;
        }
        int iC = tt.c(this.x, this.i, this.uj.size());
        int iC2 = tt.c(this.x, i, this.uj.size());
        if (this.uj.size() == 0) {
            iC2 = 0;
        }
        if (!this.uj.isEmpty() && tt.c(iC, this.uj) && tt.c(iC2, this.uj)) {
            this.uj.get(iC).setBackground(tt(this.f2545a));
            this.uj.get(iC).setLayoutParams(layoutParams2);
            this.uj.get(iC2).setBackground(tt(this.n));
            this.uj.get(iC2).setLayoutParams(layoutParams);
            this.i = i;
        }
    }

    public void tt() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.ve = this.tt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.tt, this.ve);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.sp;
            layoutParams.bottomMargin = this.sp;
        } else {
            layoutParams.leftMargin = this.sp;
            layoutParams.rightMargin = this.sp;
        }
        addView(view, layoutParams);
        view.setBackground(tt(this.f2545a));
        this.uj.add(view);
    }
}

package com.ubix.ssp.ad.c;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.ubix.ssp.ad.c.c.c;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.b0.g;
import com.ubix.ssp.ad.e.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b {
    private int l;
    private int m;
    private int n;
    private double o;
    private boolean p;
    private boolean q;
    private com.ubix.ssp.ad.g.k.a r;
    protected AnimatorSet s;
    private c t;

    public a(Context context) {
        super(context);
        this.l = 4;
        this.o = 3.0d;
        this.p = true;
        this.q = false;
        this.s = new AnimatorSet();
    }

    private synchronized void s() {
        if (isShown() && this.p && this.q) {
            this.p = false;
            com.ubix.ssp.ad.g.k.a aVar = this.r;
            if (aVar != null) {
                aVar.a(this.b, this);
            }
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        int i = bundle.getInt("AD_WIDTH");
        int i2 = bundle.getInt("AD_HEIGHT");
        bundle.getBoolean("IS_DOWNLOAD", false);
        bundle.putSerializable("CLICK_MAP", this.f8574a);
        double dA = r.a().a(context);
        this.o = dA;
        this.m = (int) (((double) i) * dA);
        this.n = (int) (((double) i2) * dA);
        this.l = (int) (((double) this.l) * dA);
        c cVarA = c.a(context, bundle);
        this.t = cVarA;
        addView(cVarA);
        if (bundle.getInt("TEMPLATE_ID") != 99001) {
            setBackgroundColor(-1);
        }
        this.q = false;
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        boolean z;
        String strA;
        super.a(str, str2, str3, str4, str5, str6, j);
        TextView textView = (TextView) findViewById(920101);
        if (textView == null) {
            return;
        }
        if (j > 0) {
            strA = k.a(j);
            z = true;
        } else {
            z = false;
            strA = "";
        }
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = TextUtils.isEmpty(str5) ? "" : "丨备案号:" + str5;
        objArr[4] = TextUtils.isEmpty(str6) ? "" : "丨适用年龄:" + str6;
        objArr[5] = z ? "丨应用大小:" + strA : "";
        textView.setText(new f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.r));
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        this.p = true;
        this.q = this.t.a(bundle);
        return true;
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            View viewFindViewById = findViewById(500104);
            if (viewFindViewById != null) {
                viewFindViewById.animate().cancel();
                AnimatorSet animatorSet = this.s;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                }
            }
            View viewFindViewById2 = findViewById(ErrorCode.d.hnadsj);
            if (viewFindViewById2 != null) {
                ((g) viewFindViewById2).p();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        s();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.m <= 0) {
            this.m = (int) (this.o * 320.0d);
        }
        if (this.n <= 0) {
            this.n = (int) (((double) this.m) / 6.4d);
        }
        setMeasuredDimension(this.m, this.n);
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            s();
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        com.ubix.ssp.ad.g.k.a aVar = (com.ubix.ssp.ad.g.k.a) bVar;
        this.r = aVar;
        this.t.setInnerListener(aVar);
    }
}

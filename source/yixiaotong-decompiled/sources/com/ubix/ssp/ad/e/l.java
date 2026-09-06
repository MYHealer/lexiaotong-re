package com.ubix.ssp.ad.e;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.ai;
import com.ubix.ssp.ad.e.a0.u;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8832a;
    private int b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private boolean g;
    private c h;
    private final String i;
    private final String j;
    com.ubix.ssp.ad.e.a0.g k;
    private AtomicBoolean l;
    HashMap<String, String> m;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 38.0f);
        }
    }

    class b implements com.ubix.ssp.ad.e.a0.g.b {
        b() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            if (l.this.l.getAndSet(true)) {
                return;
            }
            Rect rect = new Rect();
            l.this.getGlobalVisibleRect(rect);
            double dRandom = Math.random();
            int iWidth = (int) (((double) rect.width()) * dRandom);
            int iHeight = (int) (((double) rect.height()) * dRandom);
            int i = rect.left + iWidth;
            int i2 = rect.top + iHeight;
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, iWidth + "");
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, iHeight + "");
            l.this.m.put("__RAW_DOWN_X__", i + "");
            l.this.m.put("__RAW_DOWN_Y__", i2 + "");
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, iWidth + "");
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, iHeight + "");
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, l.this.getWidth() + "");
            l.this.m.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, l.this.getHeight() + "");
            l.this.m.put("__RAW_UP_X__", i + "");
            l.this.m.put("__RAW_UP_Y__", i2 + "");
            l.this.m.put("__CLICK_XY__", iWidth + "_" + iHeight);
            if (l.this.h != null) {
                l.this.h.a(l.this.m);
                l.this.h.onClose();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            u.e("onTick=" + j);
            int i = (int) (j / 1000);
            if (l.this.d != null) {
                l.this.d.setText(String.format("%ss后打开应用或第三方详情", "" + (i + 1)));
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    public interface c {
        void a(HashMap<String, String> map);

        void onClose();
    }

    public l(Context context) {
        double d;
        super(context);
        this.f8832a = 0;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.i = "%ss后打开应用或第三方详情";
        this.j = "可查看更多精彩";
        this.k = null;
        this.l = new AtomicBoolean(false);
        this.m = new HashMap<>();
        int iH = com.ubix.ssp.ad.e.a0.r.a().h(context);
        int iC = com.ubix.ssp.ad.e.a0.r.a().c(context);
        double dA = com.ubix.ssp.ad.e.a0.r.a().a(context);
        if (iH > iC) {
            this.g = true;
            this.f8832a = (int) (iH * 0.6f);
            d = 54.0d;
        } else {
            this.f8832a = (int) (iH * 0.74f);
            d = 64.0d;
        }
        this.b = (int) (d * dA);
        this.f8832a = Math.min(ai.af, this.f8832a);
        this.c = new ImageView(context);
        this.d = new TextView(context);
        this.e = new TextView(context);
        this.f = new TextView(context);
        this.c.setId(89101);
        this.d.setId(89102);
        this.e.setId(89103);
        this.f.setId(89104);
        this.c.setClipToOutline(true);
        this.c.setOutlineProvider(new a());
        setBackground(com.ubix.ssp.ad.e.a0.c.a(context, -1644167168, (int) (16.0d * dA), -1, 2));
        this.f.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), 0, (int) (dA * 7.0d), -1));
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.c);
        TextView textView = this.d;
        double d2 = this.b;
        addView(textView, new RelativeLayout.LayoutParams((int) (d2 * 0.8d), (int) (d2 * 0.35d)));
        TextView textView2 = this.e;
        double d3 = this.b;
        addView(textView2, new RelativeLayout.LayoutParams((int) (0.8d * d3), (int) (d3 * 0.35d)));
        addView(this.f);
        setZ(20.0f);
        this.d.setSingleLine();
        this.e.setSingleLine();
        this.d.setTextColor(-1);
        this.e.setTextColor(-1);
        this.f.setTextColor(-1);
        this.f.setGravity(17);
        this.d.setTextSize(11.0f);
        this.e.setTextSize(10.0f);
        this.f.setTextSize(10.0f);
        this.f.setOnClickListener(this);
        setOnClickListener(this);
    }

    private void b() {
        if (this.k != null) {
            return;
        }
        com.ubix.ssp.ad.e.a0.g gVar = new com.ubix.ssp.ad.e.a0.g(5000L);
        this.k = gVar;
        gVar.a(new b());
        this.k.e();
    }

    public void a() {
        com.ubix.ssp.ad.e.a0.g gVar = this.k;
        if (gVar != null) {
            gVar.a();
        }
        c cVar = this.h;
        if (cVar != null) {
            cVar.onClose();
        }
    }

    public void a(Bundle bundle) {
        this.d.setText(String.format("%ss后打开应用或第三方详情", "5"));
        this.e.setText("可查看更多精彩");
        String string = bundle.getString("ICON_URL", "");
        this.f.setText("不用了");
        if (!TextUtils.isEmpty(string)) {
            com.ubix.ssp.ad.e.v.e.b().a(string, this.c, 0, null);
        }
        b();
    }

    public void a(View view, long j) {
        if (view == null) {
            return;
        }
        try {
            view.setTranslationY(view.getHeight());
            view.setAlpha(0.0f);
            view.setVisibility(0);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -((l) view).getTargetWidth());
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getTargetHeight() {
        return this.b;
    }

    public int getTargetWidth() {
        return this.f8832a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 89104) {
            a();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            switch (childAt.getId()) {
                case 89101:
                    double d = ((double) this.f8832a) * 0.04d;
                    double d2 = this.b;
                    double d3 = 0.2d * d2;
                    double d4 = d2 * 0.6d;
                    childAt.layout((int) d, (int) d3, (int) (d + d4), (int) (d3 + d4));
                    break;
                case 89102:
                    int right = (int) (((double) findViewById(89101).getRight()) + (((double) this.f8832a) * 0.04d));
                    int i6 = (int) (((double) this.b) * 0.2d);
                    int right2 = findViewById(89101).getRight();
                    int i7 = this.f8832a;
                    double d5 = this.b;
                    childAt.layout(right, i6, (int) ((((double) (right2 + i7)) - (0.8d * d5)) - (((double) i7) * 0.06d)), (int) ((0.2d * d5) + (d5 * 0.35d)));
                    break;
                case 89103:
                    int right3 = (int) (((double) findViewById(89101).getRight()) + (((double) this.f8832a) * 0.04d));
                    int bottom = findViewById(89102).getBottom();
                    int right4 = findViewById(89101).getRight();
                    int i8 = this.f8832a;
                    childAt.layout(right3, bottom, (int) ((((double) (right4 + i8)) - (((double) this.b) * 0.8d)) - (((double) i8) * 0.06d)), (int) (((double) findViewById(89102).getBottom()) + (((double) this.b) * 0.35d)));
                    break;
                case 89104:
                    double d6 = ((double) this.f8832a) * 0.95d;
                    double d7 = this.b;
                    int i9 = (int) (d6 - ((0.4d * d7) * 1.8d));
                    int i10 = (int) (d7 * 0.3d);
                    childAt.layout(i9, i10, (int) d6, childAt.getMeasuredHeight() + i10);
                    break;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f8832a, this.b);
        this.f.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) this.b) * 0.4d * 1.8d), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((double) this.b) * 0.4d), 1073741824));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            com.ubix.ssp.ad.e.a0.g gVar = this.k;
            if (gVar == null || !gVar.b()) {
                return;
            }
            this.k.d();
            return;
        }
        com.ubix.ssp.ad.e.a0.g gVar2 = this.k;
        if (gVar2 == null || gVar2.b()) {
            return;
        }
        this.k.c();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            com.ubix.ssp.ad.e.a0.g gVar = this.k;
            if (gVar == null || !gVar.b()) {
                return;
            }
            this.k.d();
            return;
        }
        com.ubix.ssp.ad.e.a0.g gVar2 = this.k;
        if (gVar2 == null || gVar2.b()) {
            return;
        }
        this.k.c();
    }

    public void setClickListener(c cVar) {
        this.h = cVar;
    }
}

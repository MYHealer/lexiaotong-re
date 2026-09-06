package com.ubix.ssp.ad.e.z;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends h implements View.OnClickListener {
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private a n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;

    class a extends TextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Paint f8943a;
        private Paint b;
        private RectF c;
        private String d;

        public a(Context context) {
            super(context);
            this.f8943a = new Paint(1);
            this.b = new Paint(1);
            this.c = new RectF();
            this.d = "";
            setWillNotDraw(false);
            this.f8943a.setColor(Color.parseColor("#C3D8FF"));
            this.b.setColor(Color.parseColor("#2E5BFF"));
            this.b.setTextSize(r.d(14.0f));
            this.b.setTextAlign(Paint.Align.CENTER);
        }

        public void a(String str) {
            this.d = str;
            invalidate();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRoundRect(this.c, 8.0f, 8.0f, this.f8943a);
            Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
            canvas.drawText(this.d, getWidth() / 2.0f, ((getHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.b);
        }
    }

    public b(Context context) {
        super(context);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.q = r.a().h(context);
        int iC = r.a().c(context);
        this.r = iC;
        this.o = (int) (((double) Math.min(this.q, iC)) * 0.8d);
        this.m = new ImageView(getContext());
        this.l = new ImageView(getContext());
        this.h = new TextView(getContext());
        this.i = new TextView(getContext());
        this.j = new TextView(getContext());
        this.n = new a(getContext());
        this.k = new TextView(getContext());
        this.l.setId(10001);
        this.h.setId(10002);
        this.i.setId(10003);
        this.j.setId(10004);
        this.n.setId(10006);
        this.m.setId(876547);
        this.k.setId(10008);
        setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -1, 14));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.m.setOnClickListener(this);
        setOnClickListener(this);
        d();
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) this.o) * 0.814d), -2);
        double d = ((double) this.o) * 0.814d;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) d, (int) (d * 0.164d));
        double d2 = ((double) this.o) * 0.814d;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) d2, (int) (d2 * 0.135d));
        addView(this.m);
        addView(this.l, layoutParams);
        addView(this.h, layoutParams);
        addView(this.i);
        addView(this.j, layoutParams);
        addView(b(), layoutParams3);
        addView(this.n, layoutParams2);
        addView(this.k, layoutParams);
        this.m.setImageDrawable(q.a("ubix/ic_close.webp"));
        this.i.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -1, 48, Color.parseColor("#e0e0e0"), 1));
        this.n.setOnClickListener(this);
        this.m.setOnClickListener(this);
    }

    private void e() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) this.o) * 0.814d), -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) this.o) * 0.814d), -2);
            double d = ((double) this.o) * 0.814d;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) d, (int) (d * 0.164d));
            double d2 = ((double) this.o) * 0.814d;
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) d2, (int) (d2 * 0.135d));
            ImageView imageView = this.l;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            TextView textView = this.h;
            if (textView != null) {
                textView.setLayoutParams(layoutParams2);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setLayoutParams(layoutParams2);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                textView3.setLayoutParams(layoutParams2);
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.setLayoutParams(layoutParams3);
            }
            if (findViewById(920101) != null) {
                findViewById(920101).setLayoutParams(layoutParams4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public int getContentHeight() {
        return this.p;
    }

    public int getContentWidth() {
        return this.o;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 10006) {
            l lVar = this.c;
            if (lVar != null && lVar.b()) {
                this.c.a();
            }
            Dialog dialog = this.d;
            if (dialog != null && dialog.isShowing()) {
                this.d.dismiss();
            }
            h.c cVar = this.e;
            if (cVar != null) {
                cVar.a(this, null);
                return;
            }
            return;
        }
        if (id != 876547) {
            return;
        }
        l lVar2 = this.c;
        if (lVar2 != null && lVar2.b()) {
            this.c.a();
        }
        Dialog dialog2 = this.d;
        if (dialog2 != null && dialog2.isShowing()) {
            this.d.dismiss();
        }
        h.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.a(this);
        }
        h.c cVar3 = this.e;
        if (cVar3 != null) {
            cVar3.b(this);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int bottom;
        int measuredWidth2;
        int top;
        this.g = false;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            if (id != 10006) {
                if (id == 10008) {
                    double d = this.o;
                    int measuredWidth3 = ((int) (d * 0.093d)) + (((int) ((d * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                    int bottom2 = findViewById(10006).getBottom() + r.a(6.0f);
                    double d2 = this.o;
                    childAt.layout(measuredWidth3, bottom2, ((int) (0.093d * d2)) + (((int) ((d2 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), findViewById(10006).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight());
                } else if (id == 876547) {
                    double d3 = ((double) this.o) * 0.96d;
                    double d4 = this.b * 24.0d;
                    double d5 = ((double) this.p) * 0.04d;
                    childAt.layout((int) (d3 - d4), (int) d5, (int) d3, (int) (d5 + d4));
                } else if (id != 920101) {
                    switch (id) {
                        case 10001:
                            int i6 = this.o;
                            int bottom3 = (int) (((double) findViewById(876547).getBottom()) - (this.b * 4.0d));
                            int i7 = this.o;
                            childAt.layout((i6 - (i6 / 5)) / 2, bottom3, (i7 + (i7 / 5)) / 2, (int) ((((double) findViewById(876547).getBottom()) - (this.b * 4.0d)) + ((double) (this.o / 5))));
                            continue;
                        case 10002:
                            View viewFindViewById = findViewById(10001);
                            int bottom4 = viewFindViewById == null ? findViewById(876547).getBottom() - r.a(15.0f) : viewFindViewById.getBottom();
                            double d6 = this.o;
                            int measuredWidth4 = ((int) (d6 * 0.093d)) + (((int) ((d6 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                            int iA = r.a(14.0f) + bottom4;
                            double d7 = this.o;
                            childAt.layout(measuredWidth4, iA, ((int) (0.093d * d7)) + (((int) ((d7 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), bottom4 + r.a(14.0f) + childAt.getMeasuredHeight());
                            continue;
                        case 10003:
                            measuredWidth = (this.o - childAt.getMeasuredWidth()) / 2;
                            bottom = findViewById(10002).getBottom() + r.a(6.0f);
                            measuredWidth2 = (this.o + childAt.getMeasuredWidth()) / 2;
                            top = findViewById(10002).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight();
                            break;
                        case 10004:
                            double d8 = this.o;
                            int measuredWidth5 = ((int) (d8 * 0.093d)) + (((int) ((d8 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                            int bottom5 = findViewById(10003).getBottom() + r.a(6.0f);
                            double d9 = this.o;
                            childAt.layout(measuredWidth5, bottom5, ((int) (0.093d * d9)) + (((int) ((d9 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), findViewById(10003).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight());
                            continue;
                        default:
                            continue;
                    }
                } else {
                    double d10 = this.o;
                    int measuredWidth6 = ((int) (d10 * 0.093d)) + (((int) ((d10 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                    int measuredHeight = (this.p - childAt.getMeasuredHeight()) - r.a(2.0f);
                    double d11 = this.o;
                    childAt.layout(measuredWidth6, measuredHeight, ((int) (0.093d * d11)) + (((int) ((d11 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), this.p - r.a(2.0f));
                }
            } else {
                measuredWidth = (int) (((double) this.o) * 0.093d);
                double top2 = findViewById(920101).getTop();
                double d12 = this.o;
                bottom = (int) (top2 - ((0.814d * d12) * 0.164d));
                measuredWidth2 = (int) (d12 * 0.907d);
                top = findViewById(920101).getTop();
            }
            childAt.layout(measuredWidth, bottom, measuredWidth2, top);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = (int) (((double) Math.min(this.q, this.r)) * 0.8d);
        if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
            iMin = Math.min(iMin, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME);
        }
        if (iMin != this.o) {
            this.p = 0;
        }
        this.o = iMin;
        int i3 = this.p;
        if (i3 == 0) {
            i3 = (int) (((double) iMin) * 1.0d);
            this.p = i3;
        }
        setMeasuredDimension(iMin, i3);
        e();
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        String string = bundle.getString("ICON_URL");
        if (TextUtils.isEmpty(string)) {
            int iMin = (int) (((double) Math.min(this.q, this.r)) * 0.8d);
            if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                iMin = Math.min(iMin, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME);
            }
            this.o = iMin;
            this.p = Math.max(iMin - (iMin / 4), MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE);
            requestLayout();
            removeView(this.l);
        }
        if (!TextUtils.isEmpty(string)) {
            com.ubix.ssp.ad.e.v.e.b().a(string, this.l, -1, null);
        }
        this.h.setText(bundle.getString("TITLE", "提示"));
        this.h.getPaint().setFakeBoldText(true);
        this.h.setMaxLines(1);
        this.h.setTextColor(-13421773);
        this.h.setGravity(17);
        this.h.setTextSize(TypedValue.applyDimension(0, 20.0f, getContext().getResources().getDisplayMetrics()));
        this.j.setText(bundle.getString("SUB_TITLE", "是否要下载此应用？"));
        this.j.setMaxLines(2);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.j.setTextColor(-13421773);
        this.j.setGravity(1);
        this.j.setTextSize(TypedValue.applyDimension(0, 18.0f, getContext().getResources().getDisplayMetrics()));
        this.n.a(bundle.getString("BUTTON_TEXT", "立即下载"));
        this.n.setTextColor(Color.parseColor("#2E5BFF"));
        this.n.setGravity(17);
        this.n.setTextSize(16.0f);
        this.n.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#E8F1FF"), 8));
    }

    public void setText(String str) {
        try {
            a aVar = this.n;
            if (aVar != null) {
                aVar.a(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

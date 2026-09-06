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
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends h implements View.OnClickListener {
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
        private float f8949a;
        private Paint b;
        private Paint c;
        private RectF d;
        private String e;

        public a(Context context) {
            super(context);
            this.b = new Paint(1);
            this.c = new Paint(1);
            this.d = new RectF();
            this.e = "";
            setWillNotDraw(false);
            this.b.setColor(Color.parseColor("#C3D8FF"));
            this.c.setColor(Color.parseColor("#2E5BFF"));
            this.c.setTextSize(r.d(14.0f));
            this.c.setTextAlign(Paint.Align.CENTER);
        }

        public void a(float f) {
            this.f8949a = f;
            this.d.set(0.0f, 0.0f, (int) (getWidth() * f), getHeight());
            this.e = "下载中" + ((int) (this.f8949a * 100.0f)) + "%";
            invalidate();
        }

        public void a(String str) {
            this.e = str;
            invalidate();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRoundRect(this.d, 8.0f, 8.0f, this.b);
            Paint.FontMetrics fontMetrics = this.c.getFontMetrics();
            canvas.drawText(this.e, getWidth() / 2.0f, ((getHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.c);
        }
    }

    public e(Context context) {
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

    public void a(int i) {
        try {
            a aVar = this.n;
            if (aVar != null) {
                aVar.a(i / 100.0f);
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
        return 2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 10006) {
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
        l lVar = this.c;
        if (lVar != null && lVar.b()) {
            this.c.a();
        }
        Dialog dialog = this.d;
        if (dialog != null && dialog.isShowing()) {
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
        this.g = false;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            if (id == 10006) {
                int i6 = (int) (((double) this.o) * 0.093d);
                double top = findViewById(920101).getTop() - r.a(14.0f);
                double d = this.o;
                childAt.layout(i6, (int) (top - ((0.814d * d) * 0.164d)), (int) (d * 0.907d), findViewById(920101).getTop() - r.a(14.0f));
            } else if (id == 10008) {
                double d2 = this.o;
                int measuredWidth = ((int) (d2 * 0.093d)) + (((int) ((d2 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                int bottom = findViewById(10006).getBottom() + r.a(6.0f);
                double d3 = this.o;
                childAt.layout(measuredWidth, bottom, ((int) (0.093d * d3)) + (((int) ((d3 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), findViewById(10006).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight());
            } else if (id == 876547) {
                double d4 = ((double) this.o) * 0.96d;
                double d5 = this.b * 24.0d;
                double d6 = ((double) this.p) * 0.04d;
                childAt.layout((int) (d4 - d5), (int) d6, (int) d4, (int) (d6 + d5));
            } else if (id != 920101) {
                switch (id) {
                    case 10001:
                        int i7 = this.o;
                        int bottom2 = (int) (((double) findViewById(876547).getBottom()) - (this.b * 4.0d));
                        int i8 = this.o;
                        childAt.layout((i7 - (i7 / 5)) / 2, bottom2, (i8 + (i8 / 5)) / 2, (int) ((((double) findViewById(876547).getBottom()) - (this.b * 4.0d)) + ((double) (this.o / 5))));
                        break;
                    case 10002:
                        View viewFindViewById = findViewById(10001);
                        int bottom3 = viewFindViewById == null ? findViewById(876547).getBottom() - r.a(15.0f) : viewFindViewById.getBottom();
                        double d7 = this.o;
                        int measuredWidth2 = ((int) (d7 * 0.093d)) + (((int) ((d7 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                        int iA = r.a(14.0f) + bottom3;
                        double d8 = this.o;
                        childAt.layout(measuredWidth2, iA, ((int) (0.093d * d8)) + (((int) ((d8 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), bottom3 + r.a(14.0f) + childAt.getMeasuredHeight());
                        break;
                    case 10003:
                        childAt.layout((this.o - childAt.getMeasuredWidth()) / 2, findViewById(10002).getBottom() + r.a(6.0f), (this.o + childAt.getMeasuredWidth()) / 2, findViewById(10002).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight());
                        break;
                    case 10004:
                        double d9 = this.o;
                        int measuredWidth3 = ((int) (d9 * 0.093d)) + (((int) ((d9 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                        int bottom4 = findViewById(10003).getBottom() + r.a(6.0f);
                        double d10 = this.o;
                        childAt.layout(measuredWidth3, bottom4, ((int) (0.093d * d10)) + (((int) ((d10 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), findViewById(10003).getBottom() + r.a(6.0f) + childAt.getMeasuredHeight());
                        break;
                }
            } else {
                double d11 = this.o;
                int measuredWidth4 = ((int) (d11 * 0.093d)) + (((int) ((d11 * 0.814d) - ((double) childAt.getMeasuredWidth()))) / 2);
                int measuredHeight = (this.p - childAt.getMeasuredHeight()) - r.a(2.0f);
                double d12 = this.o;
                childAt.layout(measuredWidth4, measuredHeight, ((int) (0.093d * d12)) + (((int) ((d12 * 0.814d) + ((double) childAt.getMeasuredWidth()))) / 2), this.p - r.a(2.0f));
            }
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
            i3 = (int) (((double) iMin) * 0.94d);
            this.p = i3;
        }
        setMeasuredDimension(iMin, i3);
        e();
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        if (bundle.getBoolean("IS_DOWNLOAD", false)) {
            String string = bundle.getString("ICON_URL");
            String string2 = bundle.getString("DOWNLOAD_APP_NAME");
            String string3 = bundle.getString("DOWNLOAD_APP_VERSION");
            String string4 = bundle.getString("DOWNLOAD_APP_PUBLISHER");
            String string5 = bundle.getString("DOWNLOAD_APP_ICP_NUMBER");
            String string6 = bundle.getString("DOWNLOAD_APP_SUITABLE_AGE");
            long j = bundle.getLong("DOWNLOAD_APP_SIZE");
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
            com.ubix.ssp.ad.e.v.e.b().a(string, this.l, -1, null);
            this.h.setText(string2);
            this.i.setText(string3);
            this.j.setText(string4);
            Object[] objArr = new Object[3];
            objArr[0] = TextUtils.isEmpty(string5) ? "" : "备案号:" + string5;
            objArr[1] = TextUtils.isEmpty(string5) ? "" : "丨";
            objArr[2] = TextUtils.isEmpty(string6) ? "" : "适用年龄:" + string6;
            this.k.setText(new com.ubix.ssp.ad.e.f(String.format("%s%s%s", objArr)).a());
            this.n.a("立即下载");
            try {
                TextView textView = (TextView) findViewById(920101);
                if (textView == null) {
                    return;
                }
                if (j > 0) {
                    k.a(j);
                }
                textView.setText(new com.ubix.ssp.ad.e.f("权限丨隐私丨功能介绍").a(this.f));
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(-8158333);
                textView.setGravity(17);
                textView.setTextSize(TypedValue.applyDimension(0, 10.0f, getContext().getResources().getDisplayMetrics()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.h.getPaint().setFakeBoldText(true);
            this.h.setMaxLines(1);
            this.h.setTextColor(-13421773);
            this.h.setGravity(17);
            this.h.setTextSize(TypedValue.applyDimension(0, 16.0f, getContext().getResources().getDisplayMetrics()));
            this.i.setTextSize(12.0f);
            this.i.setMaxLines(1);
            this.i.setTextColor(-8158333);
            this.i.setGravity(17);
            this.i.setTextSize(TypedValue.applyDimension(0, 12.0f, getContext().getResources().getDisplayMetrics()));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.width = (int) (((double) ((int) this.i.getPaint().measureText(string3))) + (this.b * 19.0d));
            this.i.setLayoutParams(layoutParams);
            this.j.setMaxLines(2);
            this.j.setEllipsize(TextUtils.TruncateAt.END);
            this.j.setTextColor(-8158333);
            this.j.setGravity(1);
            this.j.setTextSize(12.0f);
            this.k.setMaxLines(1);
            this.k.setEllipsize(TextUtils.TruncateAt.END);
            this.k.setTextColor(-8158333);
            this.k.setGravity(17);
            this.k.setTextSize(TypedValue.applyDimension(0, 10.0f, getContext().getResources().getDisplayMetrics()));
            this.n.setTextColor(Color.parseColor("#2E5BFF"));
            this.n.setGravity(17);
            this.n.setTextSize(14.0f);
            this.n.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#E8F1FF"), 8));
        }
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

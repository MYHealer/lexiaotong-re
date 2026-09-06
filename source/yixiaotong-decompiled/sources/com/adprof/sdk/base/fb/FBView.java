package com.adprof.sdk.base.fb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.adprof.sdk.a9;
import com.adprof.sdk.d;
import com.adprof.sdk.h8;
import com.adprof.sdk.oh;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import com.adprof.sdk.y8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FBView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RectF f108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f110a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f111b;
    public final int c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iDecrementAndGet;
            try {
                Activity activityA = q1.a();
                if (activityA != null) {
                    y8 y8Var = new y8(this);
                    synchronized (a9.f14a) {
                        iDecrementAndGet = a9.f15a.decrementAndGet();
                        a9.f1028a.put(iDecrementAndGet, y8Var);
                    }
                    Intent intent = new Intent(activityA, (Class<?>) FBActivity.class);
                    intent.putExtra("info", FBView.this.f109a);
                    intent.putExtra("key_feedback_callback", iDecrementAndGet);
                    activityA.startActivity(intent);
                }
            } catch (Throwable th) {
                pk.a("------Feedback onClick e " + th.getMessage());
                oh.b(th);
            }
        }
    }

    public FBView(Context context) {
        super(context);
        this.f110a = "反馈";
        this.f1078a = h8.a(12.0f);
        this.f106a = 33;
        this.b = h8.a(28.0f);
        this.c = h8.a(48.0f);
        a();
    }

    public FBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f110a = "反馈";
        this.f1078a = h8.a(12.0f);
        this.f106a = 33;
        this.b = h8.a(28.0f);
        this.c = h8.a(48.0f);
        a();
    }

    public FBView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f110a = "反馈";
        this.f1078a = h8.a(12.0f);
        this.f106a = 33;
        this.b = h8.a(28.0f);
        this.c = h8.a(48.0f);
        a();
    }

    public final void a() {
        this.f108a = new RectF();
        Paint paint = new Paint(1);
        this.f107a = paint;
        paint.setColor(1712986650);
        this.f107a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f111b = paint2;
        paint2.setColor(-1);
        this.f111b.setTextSize(this.f106a);
        this.f111b.setTextAlign(Paint.Align.CENTER);
        this.f111b.setFakeBoldText(true);
        setOnClickListener(new a());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f108a;
        float f = this.f1078a;
        canvas.drawRoundRect(rectF, f, f, this.f107a);
        Paint.FontMetrics fontMetrics = this.f111b.getFontMetrics();
        canvas.drawText(this.f110a, this.f108a.centerX(), this.f108a.centerY() - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.f111b);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f108a.set(0.0f, 0.0f, i - 0.0f, i2 - 0.0f);
    }

    public void setAdUnit(d dVar) {
        this.f109a = dVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f107a.setColor(i);
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.f1078a = f;
        invalidate();
    }

    public void setLayoutParams(d dVar) {
        pk.a("------setLayoutParams:  " + getLayoutParams());
        if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.gravity = 8388629;
            layoutParams.width = this.c;
            layoutParams.height = this.b;
            layoutParams.rightMargin = dVar.f190a.f1499a == 4 ? h8.a(50.0f) : h8.a(10.0f);
            return;
        }
        if (getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams2.addRule(15);
            layoutParams2.width = this.c;
            layoutParams2.height = this.b;
            layoutParams2.leftMargin = h8.a(10.0f);
        }
    }

    public void setText(String str) {
        this.f110a = str;
        invalidate();
    }

    public void setTextSize(int i) {
        this.f106a = i;
        this.f111b.setTextSize(i);
        invalidate();
    }
}

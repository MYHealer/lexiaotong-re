package com.byazt.oq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 1873})
public class BookPageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f2576a;
    public Paint c;
    public Point n;
    public Point sp;
    public Paint tt;
    public Point uj;
    public Point ve;

    public BookPageView(Context context) {
        super(context);
        this.c = new Paint();
        this.tt = new Paint();
        this.ve = new Point();
        this.uj = new Point();
        this.n = new Point();
        this.f2576a = new Point();
        this.sp = new Point();
        this.c.setColor(-16711936);
        this.c.setTextSize(25.0f);
        post(new Runnable() { // from class: com.byazt.oq.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.ve.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.ve.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.tt.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.tt.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.tt.setStrokeWidth(6.0f);
                BookPageView.this.tt.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void c(Point point) {
        this.ve.x = point.x;
        this.ve.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c();
        Path path = new Path();
        path.moveTo(this.f2576a.x, this.f2576a.y);
        path.lineTo(this.ve.x, this.ve.y);
        path.lineTo(this.sp.x, this.sp.y);
        path.close();
        canvas.drawPath(path, this.tt);
    }

    private void c() {
        this.uj.x = getWidth();
        this.uj.y = getHeight();
        this.n.x = (this.ve.x + this.uj.x) / 2;
        this.n.y = (this.ve.y + this.uj.y) / 2;
        this.f2576a.x = this.n.x - (((this.uj.y - this.n.y) * (this.uj.y - this.n.y)) / (this.uj.x - this.n.x));
        this.f2576a.y = this.uj.y;
        this.sp.x = this.uj.x;
        this.sp.y = this.n.y - (((this.uj.x - this.n.x) * (this.uj.x - this.n.x)) / (this.uj.y - this.n.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.uj.x, this.uj.y);
        path.lineTo(this.f2576a.x, this.f2576a.y);
        path.lineTo(this.sp.x, this.sp.y);
        path.close();
        return path;
    }
}

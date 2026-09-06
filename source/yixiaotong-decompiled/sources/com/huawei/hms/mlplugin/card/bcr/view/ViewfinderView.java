package com.huawei.hms.mlplugin.card.bcr.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCapture;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;
import com.huawei.hms.mlplugin.card.bcr.R;
import com.huawei.hms.mlplugin.card.bcr.t;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ViewfinderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f4178a;
    private final c b;
    private final b c;
    private final Rect d;
    private final int e;
    private final int f;
    private final a g;
    private Rect h;
    private Rect i;
    private Context j;
    private CameraManager k;
    private Drawable l;
    private int m;
    private Rect n;
    private Rect o;
    private String p;
    private int q;
    private boolean r;
    private int s;
    private Map<Integer, Rect> t;

    public ViewfinderView(Context context, CameraManager cameraManager) {
        super(context);
        this.m = 0;
        this.s = 65536;
        this.t = new HashMap();
        this.j = context;
        this.k = cameraManager;
        this.r = t.g(context);
        String strA = MLBcrCapture.c().a().a();
        if (TextUtils.isEmpty(strA)) {
            this.p = context.getResources().getString(R.string.mlkit_bcr_card_front_tips);
        } else {
            this.p = strA;
        }
        this.q = getResources().getColor(R.color.mlkit_bcr_tips_color);
        this.e = getResources().getColor(R.color.mlkit_bcr_viewfinder_mask);
        this.f = getResources().getColor(R.color.mlkit_bcr_frame_color);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_ele_side_length);
        float f = dimensionPixelSize * (this.r ? 1.0f : 0.75f);
        this.b = new c(context, cameraManager, Math.round(f), Math.round(f));
        this.c = new b(context, dimensionPixelSize, dimensionPixelSize);
        this.g = new a(context, dimensionPixelSize, dimensionPixelSize);
        this.d = new Rect();
        this.l = context.getResources().getDrawable(R.drawable.mlkit_bcr_scan_line_portrait);
        this.f4178a = new Paint(1);
    }

    private void c(Canvas canvas, Rect rect) {
        int dimensionPixelSize = this.j.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_line_draw_width);
        if (!this.r) {
            dimensionPixelSize >>= 1;
        }
        int i = (rect.right - rect.left) / 12;
        this.f4178a.setColor(this.f);
        canvas.save();
        int i2 = rect.left;
        int i3 = rect.top;
        canvas.drawRect(i2, i3, i2 + i + 1, i3 + dimensionPixelSize + 1, this.f4178a);
        int i4 = rect.left;
        int i5 = rect.top;
        canvas.drawRect(i4, i5, i4 + dimensionPixelSize + 1, i5 + i + 1, this.f4178a);
        int i6 = rect.right;
        int i7 = rect.top;
        canvas.drawRect(i6 - i, i7, i6 + 1, i7 + dimensionPixelSize + 1, this.f4178a);
        int i8 = rect.right;
        int i9 = rect.top;
        canvas.drawRect(i8 - dimensionPixelSize, i9, i8 + 1, i9 + i + 1, this.f4178a);
        int i10 = rect.left;
        int i11 = rect.bottom;
        canvas.drawRect(i10, i11 - dimensionPixelSize, i10 + i + 1, i11 + 1, this.f4178a);
        int i12 = rect.left;
        int i13 = rect.bottom;
        canvas.drawRect(i12, i13 - i, i12 + dimensionPixelSize + 1, i13 + 1, this.f4178a);
        int i14 = rect.right;
        int i15 = rect.bottom;
        canvas.drawRect(i14 - i, i15 - dimensionPixelSize, i14 + 1, i15 + 1, this.f4178a);
        int i16 = rect.right;
        int i17 = rect.bottom;
        canvas.drawRect(i16 - dimensionPixelSize, i17 - i, i16 + 1, i17 + 1, this.f4178a);
        canvas.restore();
    }

    private void d(Canvas canvas, Rect rect) {
        h(canvas, rect);
        b(canvas, rect);
        a(canvas, rect);
        i(canvas, rect);
        e(canvas, rect);
    }

    private void e(Canvas canvas, Rect rect) {
        MLBcrCaptureConfig.IBlankBlockDrawer blankBlockDrawer = MLBcrCapture.c().a().getBlankBlockDrawer();
        if (this.r || blankBlockDrawer == null) {
            return;
        }
        canvas.save();
        Map<Integer, Rect> mapDraw = blankBlockDrawer.draw(this.j, canvas, j(canvas, rect));
        canvas.restore();
        if (mapDraw != null) {
            this.t.putAll(mapDraw);
        }
    }

    private void f(Canvas canvas, Rect rect) {
        int dimensionPixelSize = this.j.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_line_width);
        int dimensionPixelSize2 = this.j.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_line_speed);
        int i = this.m;
        if (i > ((rect.right - rect.left) - dimensionPixelSize) - dimensionPixelSize2) {
            this.m = 0;
            return;
        }
        this.m = i + dimensionPixelSize2;
        canvas.save();
        Rect rect2 = this.d;
        int i2 = rect.left;
        int i3 = this.m;
        rect2.set(i2 + i3, rect.top, i2 + dimensionPixelSize + i3, rect.bottom);
        this.l.setBounds(this.d);
        this.l.draw(canvas);
        canvas.restore();
    }

    private void g(Canvas canvas, Rect rect) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f4178a.setColor(this.e);
        canvas.save();
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.f4178a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f4178a);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.f4178a);
        canvas.drawRect(0.0f, rect.bottom + 1, f, height, this.f4178a);
        canvas.restore();
    }

    private void h(Canvas canvas, Rect rect) {
        int iRound;
        if (TextUtils.isEmpty(this.p)) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.q);
        textPaint.setTextSize(this.j.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_tips_font_size));
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
        Rect rect2 = new Rect();
        String str = this.p;
        textPaint.getTextBounds(str, 0, str.length(), rect2);
        int iWidth = rect.width() - (this.j.getResources().getDimensionPixelSize(this.r ? R.dimen.mlkit_bcr_tips_padding_lan : R.dimen.mlkit_bcr_tips_padding_por) << 1);
        if (this.r) {
            iRound = rect.top + (rect.height() >> 2);
        } else {
            int iCeil = (int) Math.ceil(rect2.width() / iWidth);
            float f = rect.top;
            iRound = Math.round((f - (0.15f * f)) - (iCeil * rect2.height()));
        }
        String str2 = this.p;
        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(str2, 0, str2.length(), textPaint, iWidth).setTextDirection(TextDirectionHeuristics.LTR).setLineSpacing(0.0f, 1.05f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(true).build();
        canvas.save();
        canvas.translate(rect.left + (rect.width() >> 1), iRound);
        getLayoutDirection();
        staticLayoutBuild.draw(canvas);
        canvas.restore();
    }

    private Rect j(Canvas canvas, Rect rect) {
        Point pointE = t.e(this.j);
        return new Rect(0, this.o.bottom, pointE.x, pointE.y);
    }

    public void a(Point point) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        setLayoutParams(layoutParams);
        postInvalidate();
        this.i = t.a(point, 0.63084f, t.g(this.j));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(this.t)) {
            return true;
        }
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        if (motionEvent.getAction() == 0) {
            for (Map.Entry<Integer, Rect> entry : this.t.entrySet()) {
                if (a(this.j, entry.getValue(), point, 10)) {
                    this.s = entry.getKey().intValue();
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getAction() == 2) {
            for (Map.Entry<Integer, Rect> entry2 : this.t.entrySet()) {
                if (!a(this.j, entry2.getValue(), point, 10) && this.s == entry2.getKey().intValue()) {
                    this.s = 65536;
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        MLBcrCaptureConfig.IBlankBlockDrawer blankBlockDrawer = MLBcrCapture.c().a().getBlankBlockDrawer();
        for (Map.Entry<Integer, Rect> entry3 : this.t.entrySet()) {
            if (a(this.j, entry3.getValue(), point, 10) && this.s == entry3.getKey().intValue()) {
                int i = this.s;
                if (i == 65538) {
                    CameraManager cameraManager = this.k;
                    if (cameraManager != null) {
                        if (cameraManager.getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON)) {
                            this.k.setTorchStatus("off");
                        } else {
                            this.k.setTorchStatus(CameraConfig.CAMERA_TORCH_ON);
                        }
                    }
                    postInvalidate();
                } else if (i == 65537 || blankBlockDrawer.onClick(this.j, entry3.getKey().intValue())) {
                    a();
                }
                return true;
            }
        }
        this.s = 65536;
        return false;
    }

    private void b(Canvas canvas, Rect rect) {
        if (this.c == null) {
            return;
        }
        int i = t.e(this.j).y;
        int iB = this.c.b();
        int iA = this.c.a();
        Point point = new Point();
        point.x = this.r ? rect.left >> 1 : rect.left + (iB >> 1);
        boolean z = this.r;
        int i2 = rect.top;
        point.y = z ? i - (i2 + (iA >> 1)) : Math.round(i2 * 0.4f);
        this.n = t.a(point, iB, iA);
        canvas.save();
        canvas.translate(this.n.centerX(), this.n.centerY());
        this.c.a(canvas, this.j);
        canvas.restore();
        this.t.put(65537, this.n);
    }

    private void i(Canvas canvas, Rect rect) {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        int iB = cVar.b();
        int iA = this.b.a();
        int dimensionPixelSize = this.j.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_torch_margin_top);
        Point point = new Point();
        point.x = this.r ? rect.left >> 1 : rect.left + (rect.width() >> 1);
        point.y = (this.r ? rect.top : rect.bottom + dimensionPixelSize) + (iA >> 1);
        this.o = t.a(point, iB, iA);
        canvas.save();
        canvas.translate(this.o.centerX(), this.o.centerY());
        this.b.a(canvas, this.j, this.r, null);
        this.o.bottom += this.b.c();
        canvas.restore();
        this.t.put(65538, this.o);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.i == null) {
            this.i = t.a(t.b(this.j), 0.63084f, t.g(this.j));
        }
        f(canvas, this.i);
        g(canvas, this.i);
        c(canvas, this.i);
        d(canvas, this.i);
        Rect rect = this.i;
        postInvalidateDelayed(10L, rect.left, rect.top, rect.right, rect.bottom);
    }

    private void a() {
        if (this.j instanceof Activity) {
            MLBcrCapture.c().a(-2);
            MLBcrCapture.c().b();
            ((Activity) this.j).finish();
        }
    }

    private static boolean a(Context context, Rect rect, Point point, int i) {
        int iA = t.a(context, i);
        int i2 = rect.left - iA;
        int i3 = rect.top - iA;
        int i4 = rect.right + iA;
        int i5 = rect.bottom + iA;
        int i6 = point.x;
        int i7 = point.y;
        return i6 >= i2 && i6 <= i4 && i7 >= i3 && i7 <= i5;
    }

    private static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    private void a(Canvas canvas, Rect rect) {
        MLBcrCaptureConfig mLBcrCaptureConfigA = MLBcrCapture.c().a();
        if (this.g == null || mLBcrCaptureConfigA.getImageLoader() == null) {
            return;
        }
        int i = t.e(this.j).y;
        int iB = this.g.b();
        int iA = this.g.a();
        Point point = new Point();
        point.x = this.r ? rect.left >> 1 : rect.left + (rect.width() >> 1);
        point.y = this.r ? i >> 1 : Math.round(rect.top * 0.4f);
        this.h = t.a(point, iB, iA);
        canvas.save();
        canvas.translate(this.h.centerX(), this.h.centerY());
        this.g.a(canvas, this.j);
        canvas.restore();
        this.t.put(65539, this.h);
    }
}

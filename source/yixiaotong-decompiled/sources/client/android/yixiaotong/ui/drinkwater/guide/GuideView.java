package client.android.yixiaotong.ui.drinkwater.guide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GuideView extends RelativeLayout {
    private int mBgColor;
    private Bitmap mBitmap;
    private RectF mBitmapRect;
    private Canvas mCanvas;
    private List<HoleBean> mHoleList;
    private Paint mPaint;
    private float mStrokeWidth;
    private PorterDuffXfermode pdf;

    public GuideView(Context context) {
        super(context);
        this.mBgColor = -1308622848;
        init();
    }

    public GuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBgColor = -1308622848;
        init();
    }

    public GuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgColor = -1308622848;
        init();
    }

    private void init() {
        this.pdf = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(this.mBgColor);
        this.mPaint.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.INNER));
        this.mBitmapRect = new RectF();
        setClickable(true);
        setWillNotDraw(false);
    }

    public void setDate(List<HoleBean> list) {
        this.mHoleList = list;
        if (list != null && !list.isEmpty()) {
            Iterator<HoleBean> it = this.mHoleList.iterator();
            while (it.hasNext()) {
                this.mBitmapRect.union(it.next().getRectF());
            }
        }
        this.mStrokeWidth = Math.max(Math.max(this.mBitmapRect.left, this.mBitmapRect.top), Math.max(ScreenUtils.getScreenWidth(getContext()) - this.mBitmapRect.right, ScreenUtils.getScreenHeight(getContext()) - this.mBitmapRect.bottom));
        if (this.mBitmapRect.width() > 0.0f && this.mBitmapRect.height() > 0.0f) {
            this.mBitmap = Bitmap.createBitmap((int) this.mBitmapRect.width(), (int) this.mBitmapRect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mBitmap);
            this.mCanvas = canvas;
            canvas.drawColor(this.mBgColor);
            return;
        }
        this.mBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        throw new UnsupportedOperationException("需要高亮的view尚未加载完，请调整适当的时机或者延迟");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<HoleBean> list = this.mHoleList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mPaint.setXfermode(this.pdf);
        this.mPaint.setStyle(Paint.Style.FILL);
        for (HoleBean holeBean : this.mHoleList) {
            RectF rectF = holeBean.getRectF();
            rectF.offset(-this.mBitmapRect.left, -this.mBitmapRect.top);
            int type = holeBean.getType();
            if (type == 0) {
                this.mCanvas.drawCircle(rectF.centerX(), rectF.centerY(), holeBean.getRadius(), this.mPaint);
            } else if (type == 1) {
                this.mCanvas.drawRect(rectF, this.mPaint);
            } else if (type == 2) {
                this.mCanvas.drawOval(rectF, this.mPaint);
            }
        }
        canvas.drawBitmap(this.mBitmap, this.mBitmapRect.left, this.mBitmapRect.top, (Paint) null);
        this.mPaint.setXfermode(null);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth + 0.1f);
        canvas.drawRect(fillRect(this.mBitmapRect), this.mPaint);
    }

    private RectF fillRect(RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left - (this.mStrokeWidth / 2.0f);
        rectF2.top = rectF.top - (this.mStrokeWidth / 2.0f);
        rectF2.right = rectF.right + (this.mStrokeWidth / 2.0f);
        rectF2.bottom = rectF.bottom + (this.mStrokeWidth / 2.0f);
        return rectF2;
    }

    public void recycler() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
    }
}

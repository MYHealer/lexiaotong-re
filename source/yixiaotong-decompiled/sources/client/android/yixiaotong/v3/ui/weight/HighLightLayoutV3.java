package client.android.yixiaotong.v3.ui.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import client.android.yixiaotong.controller.bean.region.CircleRegion;
import client.android.yixiaotong.controller.bean.region.OvalRegion;
import client.android.yixiaotong.controller.bean.region.RectRegion;
import client.android.yixiaotong.controller.bean.region.RoundRectRegion;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HighLightLayoutV3 extends FrameLayout {
    private Paint mPaint;
    private Path mPath;
    private List<RectRegion> mRegions;

    public HighLightLayoutV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-2013265920);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPath.reset();
        this.mPath.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CCW);
        for (RectRegion rectRegion : this.mRegions) {
            RectF rectF = rectRegion.rectF;
            if (rectRegion instanceof RoundRectRegion) {
                RoundRectRegion roundRectRegion = (RoundRectRegion) rectRegion;
                this.mPath.addRoundRect(rectF, roundRectRegion.rx, roundRectRegion.ry, Path.Direction.CW);
            } else if (rectRegion instanceof CircleRegion) {
                this.mPath.addCircle((rectF.right + rectF.left) / 2.0f, (rectF.bottom + rectF.top) / 2.0f, ((CircleRegion) rectRegion).radius, Path.Direction.CW);
            } else if (rectRegion instanceof OvalRegion) {
                this.mPath.addOval(rectF, Path.Direction.CW);
            } else {
                this.mPath.addRect(rectF, Path.Direction.CW);
            }
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void setRegion(RectRegion rectRegion) {
        List<RectRegion> list = this.mRegions;
        if (list == null) {
            this.mRegions = new ArrayList();
        } else {
            list.clear();
        }
        this.mRegions.add(rectRegion);
        invalidate();
    }

    public void setRegions(List<RectRegion> list) {
        this.mRegions = list;
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.e("test", "backgroundcolor；" + i);
        this.mPaint.setColor(i);
    }
}

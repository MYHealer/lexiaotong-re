package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WaterWaveView extends View {
    private static final int FPS = 25;
    private Interpolator interpolator;
    private boolean mFillAllView;
    private float mFillWaveSourceShapeRadius;
    private boolean mIsStart;
    private Wave mLastRmoveWave;
    private float mMaxWaveAreaRadius;
    private float mStirStep;
    private float mViewCenterX;
    private float mViewCenterY;
    private final Paint mWaveCenterShapePaint;
    private int mWaveColor;
    private float mWaveEndWidth;
    private float mWaveIntervalSize;
    private final Paint mWavePaint;
    private float mWaveStartWidth;
    private final List<Wave> mWaves;
    public float mWeight;

    public void setFillWaveSourceShapeRadius(float f) {
        this.mFillWaveSourceShapeRadius = f;
    }

    public void setWeightView(float f) {
        this.mWeight = f;
    }

    public void startWave(boolean z) {
        this.mIsStart = z;
    }

    public WaterWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interpolator = new CycleInterpolator(0.5f);
        this.mIsStart = false;
        Paint paint = new Paint();
        this.mWavePaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mWaveCenterShapePaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        this.mFillAllView = false;
        this.mWaves = new ArrayList();
        init();
    }

    public WaterWaveView(Context context) {
        super(context);
        this.interpolator = new CycleInterpolator(0.5f);
        this.mIsStart = false;
        Paint paint = new Paint();
        this.mWavePaint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mWaveCenterShapePaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        this.mFillAllView = false;
        this.mWaves = new ArrayList();
        init();
    }

    private void init() {
        if (this.mIsStart) {
            float f = this.mWeight;
            if (f > 1.0f) {
                setWaveInfo(f / 7.0f, 4.0f, 1.5f, 0.08f, -1);
                return;
            }
        }
        setWaveInfo(100.0f, 4.0f, 1.5f, 0.08f, -1);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float fMin;
        super.onLayout(z, i, i2, i3, i4);
        this.mViewCenterX = getWidth() / 2;
        float height = getHeight() / 2;
        this.mViewCenterY = height;
        if (this.mFillAllView) {
            float f = this.mViewCenterX;
            fMin = (float) Math.sqrt((f * f) + (height * height));
        } else {
            fMin = Math.min(this.mViewCenterX, height);
        }
        if (this.mMaxWaveAreaRadius != fMin) {
            this.mMaxWaveAreaRadius = fMin;
            resetWave();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        stir();
        for (Wave wave : this.mWaves) {
            this.mWavePaint.setColor(wave.color);
            this.mWavePaint.setStrokeWidth(wave.width);
            if (wave.radius > this.mWeight / 4.0f && this.mIsStart) {
                canvas.drawCircle(this.mViewCenterX, this.mViewCenterY, wave.radius, this.mWavePaint);
            }
        }
        postInvalidateDelayed(25L);
    }

    class Wave {
        public int color;
        public float radius;
        public float width;

        public Wave() {
            reset();
        }

        public void reset() {
            this.radius = 0.0f;
            this.width = WaterWaveView.this.mWaveStartWidth;
            this.color = WaterWaveView.this.mWaveColor;
        }

        public String toString() {
            return "Wave [radius=" + this.radius + ", width=" + this.width + ", color=" + this.color + "]";
        }
    }

    private void stir() {
        Wave wave = this.mWaves.isEmpty() ? null : this.mWaves.get(0);
        if (wave == null || wave.radius >= this.mWaveIntervalSize) {
            Wave wave2 = this.mLastRmoveWave;
            if (wave2 != null) {
                this.mLastRmoveWave = null;
                wave2.reset();
            } else {
                wave2 = new Wave();
            }
            this.mWaves.add(0, wave2);
        }
        float f = this.mWaveEndWidth - this.mWaveStartWidth;
        int size = this.mWaves.size();
        for (int i = 0; i < size; i++) {
            Wave wave3 = this.mWaves.get(i);
            float f2 = wave3.radius / this.mMaxWaveAreaRadius;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            wave3.width = this.mWaveStartWidth + (f2 * f);
            wave3.radius += this.mStirStep;
            wave3.color = (((int) (this.interpolator.getInterpolation(f2) * 255.0f)) << 24) | (this.mWaveColor & ViewCompat.MEASURED_SIZE_MASK);
        }
        int i2 = size - 1;
        Wave wave4 = this.mWaves.get(i2);
        if (wave4.radius > this.mMaxWaveAreaRadius + (wave4.width / 2.0f)) {
            this.mWaves.remove(i2);
        }
    }

    public void setFillAllView(boolean z) {
        this.mFillAllView = z;
        resetWave();
    }

    public void resetWave() {
        this.mWaves.clear();
        postInvalidate();
    }

    public void setWaveInfo(float f, float f2, float f3, float f4, int i) {
        this.mWaveIntervalSize = f;
        this.mStirStep = f2;
        this.mWaveStartWidth = f3;
        this.mWaveEndWidth = f4;
        setWaveColor(i);
        resetWave();
    }

    public void setWaveColor(int i) {
        this.mWaveColor = i;
        this.mWaveCenterShapePaint.setColor(i);
    }
}

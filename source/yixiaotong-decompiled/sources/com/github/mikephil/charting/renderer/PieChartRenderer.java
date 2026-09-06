package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != chartWidth || bitmapCreateBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float fCos = mPPointF.x + (((float) Math.cos(d)) * f);
        float fSin = mPPointF.y + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow(fCos - f3, 2.0d) + Math.pow(fSin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f2)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((mPPointF.x + (((float) Math.cos(d2)) * f)) - ((fCos + f3) / 2.0f), 2.0d) + Math.pow((mPPointF.y + (((float) Math.sin(d2)) * f)) - ((fSin + f4) / 2.0f), 2.0d)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f;
        RectF rectF;
        float f2;
        boolean z;
        float fMax;
        MPPointF mPPointF;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z2 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z2 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z3 = z2 && this.mChart.isDrawRoundedSlicesEnabled();
        int i = 0;
        for (int i2 = 0; i2 < entryCount; i2++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i2).getY()) > Utils.FLOAT_EPSILON) {
                i++;
            }
        }
        float sliceSpace = i <= 1 ? 0.0f : getSliceSpace(iPieDataSet2);
        int i3 = 0;
        float f3 = 0.0f;
        while (i3 < entryCount) {
            float f4 = drawAngles[i3];
            if (Math.abs(iPieDataSet2.getEntryForIndex(i3).getY()) > Utils.FLOAT_EPSILON && (!this.mChart.needsHighlight(i3) || z3)) {
                boolean z4 = sliceSpace > 0.0f && f4 <= 180.0f;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i3));
                float f5 = i == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f6 = rotationAngle + ((f3 + (f5 / 2.0f)) * phaseY);
                float f7 = (f4 - f5) * phaseY;
                float f8 = f7 < 0.0f ? 0.0f : f7;
                this.mPathBuffer.reset();
                if (z3) {
                    float f9 = radius - holeRadius2;
                    double d = f6 * 0.017453292f;
                    float fCos = centerCircleBox.x + (((float) Math.cos(d)) * f9);
                    float fSin = centerCircleBox.y + (f9 * ((float) Math.sin(d)));
                    rectF2.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                }
                double d2 = f6 * 0.017453292f;
                f = holeRadius;
                float fCos2 = centerCircleBox.x + (((float) Math.cos(d2)) * radius);
                float fSin2 = centerCircleBox.y + (((float) Math.sin(d2)) * radius);
                if (f8 >= 360.0f && f8 % 360.0f <= Utils.FLOAT_EPSILON) {
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                } else {
                    if (z3) {
                        this.mPathBuffer.arcTo(rectF2, f6 + 180.0f, -180.0f);
                    }
                    this.mPathBuffer.arcTo(circleBox, f6, f8);
                }
                rectF = rectF2;
                this.mInnerRectBuffer.set(centerCircleBox.x - f, centerCircleBox.y - f, centerCircleBox.x + f, centerCircleBox.y + f);
                if (z2) {
                    if (f > 0.0f || z4) {
                        if (z4) {
                            f = f;
                            z = true;
                            float fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f4 * phaseY, fCos2, fSin2, f6, f8);
                            if (fCalculateMinimumRadiusForSpacedSlice < 0.0f) {
                                fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                            }
                            fMax = Math.max(f, fCalculateMinimumRadiusForSpacedSlice);
                        } else {
                            f = f;
                            z = true;
                            fMax = f;
                        }
                        float f10 = (i == z || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                        float f11 = rotationAngle + ((f3 + (f10 / 2.0f)) * phaseY);
                        float f12 = (f4 - f10) * phaseY;
                        if (f12 < 0.0f) {
                            f12 = 0.0f;
                        }
                        float f13 = f11 + f12;
                        if (f8 >= 360.0f && f8 % 360.0f <= Utils.FLOAT_EPSILON) {
                            this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, fMax, Path.Direction.CCW);
                            mPPointF = centerCircleBox;
                            rectF = rectF;
                        } else {
                            if (z3) {
                                float f14 = radius - holeRadius2;
                                double d3 = 0.017453292f * f13;
                                mPPointF = centerCircleBox;
                                float fCos3 = centerCircleBox.x + (((float) Math.cos(d3)) * f14);
                                float fSin3 = mPPointF.y + (f14 * ((float) Math.sin(d3)));
                                rectF = rectF;
                                rectF.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                                this.mPathBuffer.arcTo(rectF, f13, 180.0f);
                            } else {
                                mPPointF = centerCircleBox;
                                rectF = rectF;
                                double d4 = f13 * 0.017453292f;
                                this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d4)) * fMax), mPPointF.y + (fMax * ((float) Math.sin(d4))));
                            }
                            this.mPathBuffer.arcTo(this.mInnerRectBuffer, f13, -f12);
                        }
                        centerCircleBox = mPPointF;
                    } else {
                        f2 = 360.0f;
                    }
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f3 += f4 * phaseX;
                } else {
                    f2 = 360.0f;
                }
                if (f8 % f2 > Utils.FLOAT_EPSILON) {
                    if (z4) {
                        float fCalculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f4 * phaseY, fCos2, fSin2, f6, f8);
                        double d5 = 0.017453292f * (f6 + (f8 / 2.0f));
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d5)) * fCalculateMinimumRadiusForSpacedSlice2), centerCircleBox.y + (fCalculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d5))));
                    } else {
                        this.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                f3 += f4 * phaseX;
            } else {
                f3 += f4 * phaseX;
                i3 = i3;
                radius = radius;
                rotationAngle = rotationAngle;
                phaseX = phaseX;
                circleBox = circleBox;
                drawAngles = drawAngles;
                i = i;
                rectF = rectF2;
                f = holeRadius;
                centerCircleBox = centerCircleBox;
            }
            i3++;
            iPieDataSet2 = iPieDataSet;
            holeRadius = f;
            rectF2 = rectF;
            centerCircleBox = centerCircleBox;
            i = i;
            radius = radius;
            entryCount = entryCount;
            circleBox = circleBox;
            rotationAngle = rotationAngle;
            phaseX = phaseX;
            drawAngles = drawAngles;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x03ce  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f;
        float[] fArr;
        float[] fArr2;
        float f2;
        float f3;
        float f4;
        float f5;
        MPPointF mPPointF;
        Canvas canvas2;
        PieDataSet.ValuePosition valuePosition;
        float f6;
        MPPointF mPPointF2;
        float f7;
        float f8;
        boolean z;
        float f9;
        float f10;
        float f11;
        IPieDataSet iPieDataSet;
        Canvas canvas3;
        String str;
        MPPointF mPPointF3;
        MPPointF mPPointF4;
        Canvas canvas4 = canvas;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = this.mChart.getHoleRadius() / 100.0f;
        float f12 = (radius / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled()) {
            f12 = (radius - (radius * holeRadius2)) / 2.0f;
            if (!this.mChart.isDrawSlicesUnderHoleEnabled() && this.mChart.isDrawRoundedSlicesEnabled()) {
                rotationAngle = (float) (((double) rotationAngle) + (((double) (holeRadius * 360.0f)) / (((double) radius) * 6.283185307179586d)));
            }
        }
        float f13 = rotationAngle;
        float f14 = radius - f12;
        PieData pieData = (PieData) this.mChart.getData();
        List<IPieDataSet> dataSets = pieData.getDataSets();
        float yValueSum = pieData.getYValueSum();
        boolean zIsDrawEntryLabelsEnabled = this.mChart.isDrawEntryLabelsEnabled();
        canvas.save();
        float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i = 0;
        int i2 = 0;
        while (i2 < dataSets.size()) {
            IPieDataSet iPieDataSet2 = dataSets.get(i2);
            boolean zIsDrawValuesEnabled = iPieDataSet2.isDrawValuesEnabled();
            if (zIsDrawValuesEnabled || zIsDrawEntryLabelsEnabled) {
                PieDataSet.ValuePosition xValuePosition = iPieDataSet2.getXValuePosition();
                PieDataSet.ValuePosition yValuePosition = iPieDataSet2.getYValuePosition();
                applyValueTextStyle(iPieDataSet2);
                int i3 = i;
                float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, "Q") + Utils.convertDpToPixel(4.0f);
                ValueFormatter valueFormatter = iPieDataSet2.getValueFormatter();
                int entryCount = iPieDataSet2.getEntryCount();
                this.mValueLinePaint.setColor(iPieDataSet2.getValueLineColor());
                this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(iPieDataSet2.getValueLineWidth()));
                float sliceSpace = getSliceSpace(iPieDataSet2);
                MPPointF mPPointF5 = MPPointF.getInstance(iPieDataSet2.getIconsOffset());
                MPPointF mPPointF6 = centerCircleBox;
                mPPointF5.x = Utils.convertDpToPixel(mPPointF5.x);
                mPPointF5.y = Utils.convertDpToPixel(mPPointF5.y);
                int i4 = 0;
                while (i4 < entryCount) {
                    MPPointF mPPointF7 = mPPointF5;
                    PieEntry entryForIndex = iPieDataSet2.getEntryForIndex(i4);
                    int i5 = entryCount;
                    float f15 = f13 + (((i3 == 0 ? 0.0f : absoluteAngles[i3 - 1] * phaseX) + ((drawAngles[i3] - ((sliceSpace / (f14 * 0.017453292f)) / 2.0f)) / 2.0f)) * phaseY);
                    float f16 = sliceSpace;
                    String pieLabel = valueFormatter.getPieLabel(this.mChart.isUsePercentValuesEnabled() ? (entryForIndex.getY() / yValueSum) * 100.0f : entryForIndex.getY(), entryForIndex);
                    float[] fArr3 = drawAngles;
                    String label = entryForIndex.getLabel();
                    ValueFormatter valueFormatter2 = valueFormatter;
                    PieEntry pieEntry = entryForIndex;
                    double d = f15 * 0.017453292f;
                    float[] fArr4 = absoluteAngles;
                    float f17 = phaseX;
                    float fCos = (float) Math.cos(d);
                    float f18 = phaseY;
                    float fSin = (float) Math.sin(d);
                    boolean z2 = zIsDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    float f19 = f13;
                    boolean z3 = zIsDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z4 = zIsDrawEntryLabelsEnabled && xValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    PieDataSet.ValuePosition valuePosition2 = xValuePosition;
                    boolean z5 = zIsDrawValuesEnabled && yValuePosition == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z2 || z3) {
                        float valueLinePart1Length = iPieDataSet2.getValueLinePart1Length();
                        float valueLinePart2Length = iPieDataSet2.getValueLinePart2Length();
                        float valueLinePart1OffsetPercentage = iPieDataSet2.getValueLinePart1OffsetPercentage() / 100.0f;
                        valuePosition = yValuePosition;
                        if (this.mChart.isDrawHoleEnabled()) {
                            float f20 = radius * holeRadius2;
                            f6 = ((radius - f20) * valueLinePart1OffsetPercentage) + f20;
                        } else {
                            f6 = radius * valueLinePart1OffsetPercentage;
                        }
                        float fAbs = iPieDataSet2.isValueLineVariableLength() ? valueLinePart2Length * f14 * ((float) Math.abs(Math.sin(d))) : valueLinePart2Length * f14;
                        mPPointF2 = mPPointF6;
                        float f21 = (f6 * fCos) + mPPointF2.x;
                        float f22 = (f6 * fSin) + mPPointF2.y;
                        float f23 = (valueLinePart1Length + 1.0f) * f14;
                        f7 = radius;
                        float f24 = (f23 * fCos) + mPPointF2.x;
                        f8 = fSin;
                        float f25 = mPPointF2.y + (f23 * fSin);
                        z = z4;
                        f9 = fCos;
                        double d2 = ((double) f15) % 360.0d;
                        if (d2 >= 90.0d && d2 <= 270.0d) {
                            float f26 = f24 - fAbs;
                            this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
                            if (z2) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
                            }
                            f10 = f26;
                            f11 = f26 - fConvertDpToPixel;
                        } else {
                            f10 = f24 + fAbs;
                            this.mValuePaint.setTextAlign(Paint.Align.LEFT);
                            if (z2) {
                                this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
                            }
                            f11 = f10 + fConvertDpToPixel;
                        }
                        if (iPieDataSet2.getValueLineColor() != 1122867) {
                            if (iPieDataSet2.isUsingSliceColorAsValueLineColor()) {
                                this.mValueLinePaint.setColor(iPieDataSet2.getColor(i4));
                            }
                            iPieDataSet = iPieDataSet2;
                            canvas.drawLine(f21, f22, f24, f25, this.mValueLinePaint);
                            canvas.drawLine(f24, f25, f10, f25, this.mValueLinePaint);
                        } else {
                            iPieDataSet = iPieDataSet2;
                        }
                        if (z2 && z3) {
                            drawValue(canvas, pieLabel, f11, f25, iPieDataSet.getValueTextColor(i4));
                            if (i4 >= pieData.getEntryCount() || label == null) {
                                canvas3 = canvas;
                                str = label;
                            } else {
                                canvas3 = canvas;
                                str = label;
                                drawEntryLabel(canvas3, str, f11, f25 + fCalcTextHeight);
                            }
                        } else {
                            canvas3 = canvas;
                            str = label;
                            if (z2) {
                                if (i4 < pieData.getEntryCount() && str != null) {
                                    drawEntryLabel(canvas3, str, f11, f25 + (fCalcTextHeight / 2.0f));
                                }
                            } else if (z3) {
                                drawValue(canvas, pieLabel, f11, f25 + (fCalcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i4));
                            }
                        }
                    } else {
                        valuePosition = yValuePosition;
                        f7 = radius;
                        z = z4;
                        f9 = fCos;
                        mPPointF2 = mPPointF6;
                        mPPointF7 = mPPointF7;
                        pieEntry = pieEntry;
                        valueFormatter2 = valueFormatter2;
                        str = label;
                        canvas3 = canvas;
                        f8 = fSin;
                        f14 = f14;
                        iPieDataSet = iPieDataSet2;
                    }
                    if (z || z5) {
                        mPPointF3 = mPPointF2;
                        float f27 = (f14 * f9) + mPPointF3.x;
                        float f28 = (f14 * f8) + mPPointF3.y;
                        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
                        if (z && z5) {
                            drawValue(canvas, pieLabel, f27, f28, iPieDataSet.getValueTextColor(i4));
                            if (i4 < pieData.getEntryCount() && str != null) {
                                drawEntryLabel(canvas3, str, f27, f28 + fCalcTextHeight);
                            }
                        } else {
                            if (z) {
                                if (i4 < pieData.getEntryCount() && str != null) {
                                    drawEntryLabel(canvas3, str, f27, f28 + (fCalcTextHeight / 2.0f));
                                }
                            } else if (z5) {
                                drawValue(canvas, pieLabel, f27, f28 + (fCalcTextHeight / 2.0f), iPieDataSet.getValueTextColor(i4));
                            }
                            if (pieEntry.getIcon() == null && iPieDataSet.isDrawIconsEnabled()) {
                                Drawable icon = pieEntry.getIcon();
                                mPPointF4 = mPPointF7;
                                Utils.drawImage(canvas, icon, (int) (((f14 + mPPointF4.y) * f9) + mPPointF3.x), (int) (((f14 + mPPointF4.y) * f8) + mPPointF3.y + mPPointF4.x), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            } else {
                                mPPointF4 = mPPointF7;
                            }
                            i3++;
                            i4++;
                            mPPointF5 = mPPointF4;
                            mPPointF6 = mPPointF3;
                            iPieDataSet2 = iPieDataSet;
                            sliceSpace = f16;
                            entryCount = i5;
                            drawAngles = fArr3;
                            f14 = f14;
                            absoluteAngles = fArr4;
                            phaseX = f17;
                            phaseY = f18;
                            f13 = f19;
                            xValuePosition = valuePosition2;
                            radius = f7;
                            yValuePosition = valuePosition;
                            valueFormatter = valueFormatter2;
                        }
                    } else {
                        mPPointF3 = mPPointF2;
                    }
                    if (pieEntry.getIcon() == null) {
                        mPPointF4 = mPPointF7;
                    } else {
                        mPPointF4 = mPPointF7;
                    }
                    i3++;
                    i4++;
                    mPPointF5 = mPPointF4;
                    mPPointF6 = mPPointF3;
                    iPieDataSet2 = iPieDataSet;
                    sliceSpace = f16;
                    entryCount = i5;
                    drawAngles = fArr3;
                    f14 = f14;
                    absoluteAngles = fArr4;
                    phaseX = f17;
                    phaseY = f18;
                    f13 = f19;
                    xValuePosition = valuePosition2;
                    radius = f7;
                    yValuePosition = valuePosition;
                    valueFormatter = valueFormatter2;
                }
                f = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f2 = phaseX;
                f3 = phaseY;
                f4 = f13;
                f5 = f14;
                mPPointF = mPPointF6;
                canvas2 = canvas;
                MPPointF.recycleInstance(mPPointF5);
                i = i3;
            } else {
                f = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f2 = phaseX;
                f3 = phaseY;
                f4 = f13;
                f5 = f14;
                canvas2 = canvas4;
                mPPointF = centerCircleBox;
            }
            i2++;
            canvas4 = canvas2;
            centerCircleBox = mPPointF;
            dataSets = dataSets;
            drawAngles = fArr;
            f14 = f5;
            absoluteAngles = fArr2;
            phaseX = f2;
            phaseY = f3;
            f13 = f4;
            radius = f;
        }
        MPPointF.recycleInstance(centerCircleBox);
        canvas.restore();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawCenterText(Canvas canvas) {
        float radius;
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f = centerCircleBox.x + centerTextOffset.x;
        float f2 = centerCircleBox.y + centerTextOffset.y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF rectF = this.mRectBuffer[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = this.mRectBuffer[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        Path path = this.mDrawCenterTextPathBuffer;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(centerTextOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f;
        float f2;
        MPPointF mPPointF;
        IPieDataSet dataSetByIndex;
        float f3;
        int i;
        float fCalculateMinimumRadiusForSpacedSlice;
        float fMax;
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF = this.mDrawHighlightedRectF;
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (i2 < highlightArr.length) {
            int x = (int) highlightArr[i2].getX();
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr[i2].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i3 = 0;
                for (int i4 = 0; i4 < entryCount; i4++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i4).getY()) > Utils.FLOAT_EPSILON) {
                        i3++;
                    }
                }
                if (x == 0) {
                    i = 1;
                    f3 = 0.0f;
                } else {
                    f3 = absoluteAngles[x - 1] * phaseX;
                    i = 1;
                }
                float sliceSpace = i3 <= i ? 0.0f : dataSetByIndex.getSliceSpace();
                float f4 = drawAngles[x];
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f5 = radius + selectionShift;
                rectF.set(this.mChart.getCircleBox());
                float f6 = -selectionShift;
                rectF.inset(f6, f6);
                boolean z2 = sliceSpace > 0.0f && f4 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f7 = i3 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f8 = i3 == 1 ? 0.0f : sliceSpace / (f5 * 0.017453292f);
                float f9 = rotationAngle + (((f7 / 2.0f) + f3) * phaseY);
                float f10 = (f4 - f7) * phaseY;
                float f11 = f10 < 0.0f ? 0.0f : f10;
                float f12 = (((f8 / 2.0f) + f3) * phaseY) + rotationAngle;
                float f13 = (f4 - f8) * phaseY;
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (f11 >= 360.0f && f11 % 360.0f <= Utils.FLOAT_EPSILON) {
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f5, Path.Direction.CW);
                } else {
                    double d = f12 * 0.017453292f;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d)) * f5), centerCircleBox.y + (f5 * ((float) Math.sin(d))));
                    this.mPathBuffer.arcTo(rectF, f12, f13);
                }
                if (z2) {
                    double d2 = f9 * 0.017453292f;
                    mPPointF = centerCircleBox;
                    fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f4 * phaseY, (((float) Math.cos(d2)) * radius) + centerCircleBox.x, centerCircleBox.y + (((float) Math.sin(d2)) * radius), f9, f11);
                } else {
                    mPPointF = centerCircleBox;
                    fCalculateMinimumRadiusForSpacedSlice = 0.0f;
                }
                this.mInnerRectBuffer.set(mPPointF.x - r22, mPPointF.y - r22, mPPointF.x + r22, mPPointF.y + r22);
                if (z == 0 || (r22 <= 0.0f && !z2)) {
                    f = phaseX;
                    f2 = phaseY;
                    if (f11 % 360.0f > Utils.FLOAT_EPSILON) {
                        if (z2) {
                            double d3 = (f9 + (f11 / 2.0f)) * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d3)) * fCalculateMinimumRadiusForSpacedSlice), mPPointF.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d3))));
                        } else {
                            this.mPathBuffer.lineTo(mPPointF.x, mPPointF.y);
                        }
                    }
                } else {
                    if (z2) {
                        if (fCalculateMinimumRadiusForSpacedSlice < 0.0f) {
                            fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                        }
                        fMax = Math.max(r22, fCalculateMinimumRadiusForSpacedSlice);
                    } else {
                        fMax = r22;
                    }
                    float f14 = (i3 == 1 || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                    float f15 = ((f3 + (f14 / 2.0f)) * phaseY) + rotationAngle;
                    float f16 = (f4 - f14) * phaseY;
                    if (f16 < 0.0f) {
                        f16 = 0.0f;
                    }
                    float f17 = f15 + f16;
                    if (f11 >= 360.0f && f11 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(mPPointF.x, mPPointF.y, fMax, Path.Direction.CCW);
                        f = phaseX;
                        f2 = phaseY;
                    } else {
                        double d4 = f17 * 0.017453292f;
                        f = phaseX;
                        f2 = phaseY;
                        this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d4)) * fMax), mPPointF.y + (fMax * ((float) Math.sin(d4))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f17, -f16);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                rectF = rectF;
                drawAngles = drawAngles;
                z = z;
                f = phaseX;
                f2 = phaseY;
                mPPointF = centerCircleBox;
            }
            i2++;
            phaseX = f;
            rectF = rectF;
            holeRadius = holeRadius;
            centerCircleBox = mPPointF;
            phaseY = f2;
            drawAngles = drawAngles;
            z = z;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d = radius - holeRadius;
                        double d2 = (rotationAngle + f) * phaseY;
                        float fCos = (float) (((double) centerCircleBox.x) + (Math.cos(Math.toRadians(d2)) * d));
                        float fSin = (float) ((d * Math.sin(Math.toRadians(d2))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(fCos, fSin, holeRadius, this.mRenderPaint);
                    }
                    rotationAngle += f * phaseX;
                    i++;
                    phaseY = phaseY;
                    drawAngles = drawAngles;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}

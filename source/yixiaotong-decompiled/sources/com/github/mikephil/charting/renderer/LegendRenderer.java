package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0096  */
    /* JADX WARN: Code duplicated, block: B:23:0x009a  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:33:0x0102  */
    /* JADX WARN: Code duplicated, block: B:35:0x010e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0153  */
    /* JADX WARN: Code duplicated, block: B:39:0x015a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:42:0x0164  */
    /* JADX WARN: Code duplicated, block: B:45:0x016d  */
    public void computeLegend(ChartData<?> chartData) {
        int i;
        String label;
        ICandleDataSet iCandleDataSet;
        ChartData<?> chartData2;
        IPieDataSet iPieDataSet;
        int i2;
        ChartData<?> chartData3 = chartData;
        if (!this.mLegend.isLegendCustom()) {
            this.computedEntries.clear();
            int i3 = 0;
            while (i3 < chartData.getDataSetCount()) {
                IDataSet dataSetByIndex = chartData3.getDataSetByIndex(i3);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        for (int i4 = 0; i4 < colors.size() && i4 < iBarDataSet.getStackSize(); i4++) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i4 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i4).intValue()));
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                        chartData2 = chartData3;
                    } else {
                        if (dataSetByIndex instanceof IPieDataSet) {
                            iPieDataSet = (IPieDataSet) dataSetByIndex;
                            for (i2 = 0; i2 < colors.size() && i2 < entryCount; i2++) {
                                this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i2).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i2).intValue()));
                            }
                            if (iPieDataSet.getLabel() != null) {
                                this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                            }
                        } else if (dataSetByIndex instanceof ICandleDataSet) {
                            iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                            if (iCandleDataSet.getDecreasingColor() != 1122867) {
                                int decreasingColor = iCandleDataSet.getDecreasingColor();
                                int increasingColor = iCandleDataSet.getIncreasingColor();
                                this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor));
                                this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor));
                            } else {
                                for (i = 0; i < colors.size() && i < entryCount; i++) {
                                    if (i < colors.size() - 1 || i >= entryCount - 1) {
                                        label = chartData.getDataSetByIndex(i3).getLabel();
                                    } else {
                                        label = null;
                                    }
                                    this.computedEntries.add(new LegendEntry(label, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i).intValue()));
                                }
                            }
                        } else {
                            while (i < colors.size()) {
                                if (i < colors.size() - 1) {
                                    label = chartData.getDataSetByIndex(i3).getLabel();
                                } else {
                                    label = chartData.getDataSetByIndex(i3).getLabel();
                                }
                                this.computedEntries.add(new LegendEntry(label, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i).intValue()));
                            }
                        }
                        chartData2 = chartData;
                    }
                } else {
                    if (dataSetByIndex instanceof IPieDataSet) {
                        iPieDataSet = (IPieDataSet) dataSetByIndex;
                        while (i2 < colors.size()) {
                            this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i2).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i2).intValue()));
                        }
                        if (iPieDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                    } else if (dataSetByIndex instanceof ICandleDataSet) {
                        iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                        if (iCandleDataSet.getDecreasingColor() != 1122867) {
                            int decreasingColor2 = iCandleDataSet.getDecreasingColor();
                            int increasingColor2 = iCandleDataSet.getIncreasingColor();
                            this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor2));
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor2));
                        } else {
                            while (i < colors.size()) {
                                if (i < colors.size() - 1) {
                                    label = chartData.getDataSetByIndex(i3).getLabel();
                                } else {
                                    label = chartData.getDataSetByIndex(i3).getLabel();
                                }
                                this.computedEntries.add(new LegendEntry(label, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i).intValue()));
                            }
                        }
                    } else {
                        while (i < colors.size()) {
                            if (i < colors.size() - 1) {
                                label = chartData.getDataSetByIndex(i3).getLabel();
                            } else {
                                label = chartData.getDataSetByIndex(i3).getLabel();
                            }
                            this.computedEntries.add(new LegendEntry(label, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i).intValue()));
                        }
                    }
                    chartData2 = chartData;
                }
                i3++;
                chartData3 = chartData2;
            }
            if (this.mLegend.getExtraEntries() != null) {
                Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
            }
            this.mLegend.setEntries(this.computedEntries);
        }
        Typeface typeface = this.mLegend.getTypeface();
        if (typeface != null) {
            this.mLegendLabelPaint.setTypeface(typeface);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    public void renderLegend(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        List<Boolean> list;
        float f6;
        List<FSize> list2;
        Canvas canvas2;
        int i;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float fContentTop;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float fCalcTextWidth;
        float fContentBottom;
        float fContentRight;
        float fContentLeft;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float fCalcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float fConvertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float fConvertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float fConvertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            float f13 = fConvertDpToPixel4;
            float f14 = fConvertDpToPixel2;
            if (i2 != 1) {
                if (i2 == 2) {
                    lineHeight = lineHeight;
                    f = lineSpacing;
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        fContentRight = this.mViewPortHandler.getChartWidth();
                    } else {
                        fContentRight = this.mViewPortHandler.contentRight();
                    }
                    f3 = fContentRight - xOffset;
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f3 -= this.mLegend.mNeededWidth;
                    }
                } else if (i2 != 3) {
                    lineHeight = lineHeight;
                    f = lineSpacing;
                    f2 = 0.0f;
                } else {
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        fContentLeft = this.mViewPortHandler.getChartWidth() / 2.0f;
                    } else {
                        fContentLeft = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                    }
                    f3 = fContentLeft + (direction == Legend.LegendDirection.LEFT_TO_RIGHT ? xOffset : -xOffset);
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        f = lineSpacing;
                        f3 = (float) (((double) f3) + (direction == Legend.LegendDirection.LEFT_TO_RIGHT ? (((double) (-this.mLegend.mNeededWidth)) / 2.0d) + ((double) xOffset) : (((double) this.mLegend.mNeededWidth) / 2.0d) - ((double) xOffset)));
                    } else {
                        lineHeight = lineHeight;
                        f = lineSpacing;
                    }
                }
                f2 = f3;
            } else {
                lineHeight = lineHeight;
                f = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f3 = this.mLegend.mNeededWidth + xOffset;
                    f2 = f3;
                } else {
                    f2 = xOffset;
                }
            }
            int i3 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i4 == 1) {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i4 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        fContentBottom = this.mViewPortHandler.getChartHeight();
                    } else {
                        fContentBottom = this.mViewPortHandler.contentBottom();
                    }
                    fContentTop = fContentBottom - (this.mLegend.mNeededHeight + yOffset);
                } else {
                    fContentTop = i4 != 3 ? 0.0f : ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                }
                float f15 = fContentTop;
                float f16 = 0.0f;
                boolean z = false;
                int i5 = 0;
                while (i5 < entries.length) {
                    LegendEntry legendEntry2 = entries[i5];
                    boolean z2 = legendEntry2.form != Legend.LegendForm.NONE;
                    float fConvertDpToPixel5 = Float.isNaN(legendEntry2.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                    if (z2) {
                        fCalcTextWidth = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f2 + f16 : f2 - (fConvertDpToPixel5 - f16);
                        legendDirection = direction;
                        drawForm(canvas, fCalcTextWidth, f15 + fCalcTextHeight, legendEntry2, this.mLegend);
                        if (legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            fCalcTextWidth += fConvertDpToPixel5;
                        }
                        legendEntry = legendEntry2;
                    } else {
                        legendDirection = direction;
                        legendEntry = legendEntry2;
                        fCalcTextWidth = f2;
                    }
                    if (legendEntry.label != null) {
                        if (z2 && !z) {
                            fCalcTextWidth += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? fConvertDpToPixel : -fConvertDpToPixel;
                        } else if (z) {
                            fCalcTextWidth = f2;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fCalcTextWidth -= Utils.calcTextWidth(this.mLegendLabelPaint, legendEntry.label);
                        }
                        float f17 = fCalcTextWidth;
                        if (!z) {
                            drawLabel(canvas, f17, f15 + lineHeight, legendEntry.label);
                        } else {
                            f15 += lineHeight + f;
                            drawLabel(canvas, f17, f15 + lineHeight, legendEntry.label);
                        }
                        f15 += lineHeight + f;
                        f16 = 0.0f;
                    } else {
                        f16 += fConvertDpToPixel5 + f13;
                        z = true;
                    }
                    i5++;
                    f13 = f13;
                    direction = legendDirection;
                    fCalcTextHeight = fCalcTextHeight;
                }
                return;
            }
            float f18 = f13;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                } else {
                    yOffset = i6 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f);
                }
            }
            int length = entries.length;
            float f19 = f2;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                float f20 = f18;
                LegendEntry legendEntry3 = entries[i7];
                int i9 = length;
                boolean z3 = legendEntry3.form != Legend.LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry3.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry3.formSize);
                if (i7 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i7).booleanValue()) {
                    f4 = f19;
                    f5 = yOffset;
                } else {
                    f5 = yOffset + lineHeight + f;
                    f4 = f2;
                }
                if (f4 == f2 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i8 < calculatedLineSizes.size()) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f12 = calculatedLineSizes.get(i8).width;
                    } else {
                        f12 = -calculatedLineSizes.get(i8).width;
                    }
                    f4 += f12 / 2.0f;
                    i8++;
                }
                int i10 = i8;
                boolean z4 = legendEntry3.label == null;
                if (z3) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f4 -= fConvertDpToPixel6;
                    }
                    float f21 = f4;
                    f6 = f2;
                    i = i7;
                    list = calculatedLabelBreakPoints;
                    list2 = calculatedLineSizes;
                    canvas2 = canvas;
                    drawForm(canvas, f21, f5 + fCalcTextHeight, legendEntry3, this.mLegend);
                    f4 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f21 + fConvertDpToPixel6 : f21;
                } else {
                    list = calculatedLabelBreakPoints;
                    f6 = f2;
                    list2 = calculatedLineSizes;
                    canvas2 = canvas;
                    i = i7;
                }
                if (!z4) {
                    if (z3) {
                        f4 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel : fConvertDpToPixel;
                    }
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f4 -= calculatedLabelSizes.get(i).width;
                    }
                    drawLabel(canvas2, f4, f5 + lineHeight, legendEntry3.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f4 += calculatedLabelSizes.get(i).width;
                    }
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f7 = f14;
                        f11 = -f7;
                    } else {
                        f7 = f14;
                        f11 = f7;
                    }
                    f10 = f4 + f11;
                    f8 = f20;
                } else {
                    f7 = f14;
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f8 = f20;
                        f9 = -f8;
                    } else {
                        f8 = f20;
                        f9 = f8;
                    }
                    f10 = f4 + f9;
                }
                f14 = f7;
                f18 = f8;
                i7 = i + 1;
                yOffset = f5;
                i8 = i10;
                f2 = f6;
                calculatedLabelBreakPoints = list;
                calculatedLineSizes = list2;
                f19 = f10;
                length = i9;
            }
        }
    }

    protected void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        if (legendEntry.formColor == 1122868 || legendEntry.formColor == 1122867 || legendEntry.formColor == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm form = legendEntry.form;
        if (form == Legend.LegendForm.DEFAULT) {
            form = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float fConvertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f3 = fConvertDpToPixel / 2.0f;
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[form.ordinal()];
        if (i == 3 || i == 4) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
        } else if (i == 5) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f3, f + fConvertDpToPixel, f2 + f3, this.mLegendFormPaint);
        } else if (i == 6) {
            float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
            DashPathEffect formLineDashEffect = legendEntry.formLineDashEffect == null ? legend.getFormLineDashEffect() : legendEntry.formLineDashEffect;
            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
            this.mLegendFormPaint.setStrokeWidth(fConvertDpToPixel2);
            this.mLegendFormPaint.setPathEffect(formLineDashEffect);
            this.mLineFormPath.reset();
            this.mLineFormPath.moveTo(f, f2);
            this.mLineFormPath.lineTo(f + fConvertDpToPixel, f2);
            canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
        }
        canvas.restoreToCount(iSave);
    }

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    protected void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }
}

package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {
    YAxis getAxis(YAxis.AxisDependency axisDependency);

    LineData getLineData();
}

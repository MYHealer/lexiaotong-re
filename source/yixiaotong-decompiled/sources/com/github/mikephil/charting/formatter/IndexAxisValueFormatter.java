package com.github.mikephil.charting.formatter;

import java.util.Collection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class IndexAxisValueFormatter extends ValueFormatter {
    private int mValueCount;
    private String[] mValues;

    public String[] getValues() {
        return this.mValues;
    }

    public IndexAxisValueFormatter() {
        this.mValues = new String[0];
        this.mValueCount = 0;
    }

    public IndexAxisValueFormatter(String[] strArr) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        this.mValues = new String[0];
        this.mValueCount = 0;
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        int iRound = Math.round(f);
        return (iRound < 0 || iRound >= this.mValueCount || iRound != ((int) f)) ? "" : this.mValues[iRound];
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.mValues = strArr;
        this.mValueCount = strArr.length;
    }
}

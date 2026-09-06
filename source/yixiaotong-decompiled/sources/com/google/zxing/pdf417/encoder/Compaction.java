package com.google.zxing.pdf417.encoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum Compaction {
    AUTO,
    TEXT,
    BYTE,
    NUMERIC;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static Compaction[] valuesCustom() {
        Compaction[] compactionArrValuesCustom = values();
        int length = compactionArrValuesCustom.length;
        Compaction[] compactionArr = new Compaction[length];
        System.arraycopy(compactionArrValuesCustom, 0, compactionArr, 0, length);
        return compactionArr;
    }
}

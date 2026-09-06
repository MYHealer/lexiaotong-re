package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ErrorCorrectionLevel[] valuesCustom() {
        ErrorCorrectionLevel[] errorCorrectionLevelArrValuesCustom = values();
        int length = errorCorrectionLevelArrValuesCustom.length;
        ErrorCorrectionLevel[] errorCorrectionLevelArr = new ErrorCorrectionLevel[length];
        System.arraycopy(errorCorrectionLevelArrValuesCustom, 0, errorCorrectionLevelArr, 0, length);
        return errorCorrectionLevelArr;
    }

    public int getBits() {
        return this.bits;
    }

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}

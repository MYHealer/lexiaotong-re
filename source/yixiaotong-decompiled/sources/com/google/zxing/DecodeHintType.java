package com.google.zxing;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum DecodeHintType {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(ResultPointCallback.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> valueType;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static DecodeHintType[] valuesCustom() {
        DecodeHintType[] decodeHintTypeArrValuesCustom = values();
        int length = decodeHintTypeArrValuesCustom.length;
        DecodeHintType[] decodeHintTypeArr = new DecodeHintType[length];
        System.arraycopy(decodeHintTypeArrValuesCustom, 0, decodeHintTypeArr, 0, length);
        return decodeHintTypeArr;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }

    DecodeHintType(Class cls) {
        this.valueType = cls;
    }
}

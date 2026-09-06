package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure;

    private final int mask = 1 << ordinal();

    public final int getMask() {
        return this.mask;
    }

    SerializerFeature() {
    }

    public static boolean isEnabled(int i, SerializerFeature serializerFeature) {
        return (i & serializerFeature.getMask()) != 0;
    }

    public static boolean isEnabled(int i, int i2, SerializerFeature serializerFeature) {
        int mask = serializerFeature.getMask();
        return ((i & mask) == 0 && (i2 & mask) == 0) ? false : true;
    }

    public static int config(int i, SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i | serializerFeature.getMask();
        }
        return i & (~serializerFeature.getMask());
    }

    public static int of(SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int mask = 0;
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            mask |= serializerFeature.getMask();
        }
        return mask;
    }
}

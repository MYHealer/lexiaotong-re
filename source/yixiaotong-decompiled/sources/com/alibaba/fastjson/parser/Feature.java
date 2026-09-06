package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect;

    private final int mask = 1 << ordinal();

    public final int getMask() {
        return this.mask;
    }

    Feature() {
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (i & feature.getMask()) != 0;
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return i | feature.getMask();
        }
        return i & (~feature.getMask());
    }

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int mask = 0;
        for (Feature feature : featureArr) {
            mask |= feature.getMask();
        }
        return mask;
    }
}

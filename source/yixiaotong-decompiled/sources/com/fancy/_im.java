package com.fancy;

import com.fancy.adsdk.lib.constants.AdConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final /* synthetic */ class _im {
    public static /* synthetic */ String _a(int i) {
        if (i == 1) {
            return AdConstant.NATIVE_TYPE.TOP_TEXT;
        }
        if (i == 2) {
            return AdConstant.NATIVE_TYPE.TOP_IMAGE;
        }
        if (i == 3) {
            return AdConstant.NATIVE_TYPE.TEXT_FLOAT;
        }
        if (i == 4) {
            return AdConstant.NATIVE_TYPE.LEFT_IMAGE;
        }
        if (i == 5) {
            return AdConstant.NATIVE_TYPE.LEFT_TEXT;
        }
        if (i == 6) {
            return AdConstant.NATIVE_TYPE.THREE_IMAGES;
        }
        throw null;
    }

    public static /* synthetic */ boolean _b(int i) {
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            return true;
        }
        throw null;
    }

    public static /* synthetic */ boolean _c(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4 || i == 5 || i == 6) {
            return false;
        }
        throw null;
    }
}

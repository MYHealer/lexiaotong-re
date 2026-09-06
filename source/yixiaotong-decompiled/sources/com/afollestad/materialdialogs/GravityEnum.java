package com.afollestad.materialdialogs;

import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum GravityEnum {
    START,
    CENTER,
    END;

    private static final boolean HAS_RTL = true;

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.GravityEnum$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$GravityEnum;

        static {
            int[] iArr = new int[GravityEnum.values().length];
            $SwitchMap$com$afollestad$materialdialogs$GravityEnum = iArr;
            try {
                iArr[GravityEnum.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$afollestad$materialdialogs$GravityEnum[GravityEnum.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$afollestad$materialdialogs$GravityEnum[GravityEnum.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int getGravityInt() {
        int i = AnonymousClass1.$SwitchMap$com$afollestad$materialdialogs$GravityEnum[ordinal()];
        if (i == 1) {
            if (HAS_RTL) {
                return GravityCompat.START;
            }
            return 3;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            throw new IllegalStateException("Invalid gravity constant");
        }
        if (HAS_RTL) {
            return GravityCompat.END;
        }
        return 5;
    }

    public int getTextAlignment() {
        int i = AnonymousClass1.$SwitchMap$com$afollestad$materialdialogs$GravityEnum[ordinal()];
        if (i != 2) {
            return i != 3 ? 5 : 6;
        }
        return 4;
    }
}

package com.google.common.collect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    BoundType(boolean z) {
        this.inclusive = z;
    }
}

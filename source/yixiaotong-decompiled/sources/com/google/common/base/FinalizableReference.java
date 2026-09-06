package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@ElementTypesAreNonnullByDefault
public interface FinalizableReference {
    void finalizeReferent();
}

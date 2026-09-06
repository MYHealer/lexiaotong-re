package com.yfanads.android.libs.thirdpart.gson.internal;

/* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class C$Gson$Preconditions {
    private C$Gson$Preconditions() {
        throw new UnsupportedOperationException();
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }
}

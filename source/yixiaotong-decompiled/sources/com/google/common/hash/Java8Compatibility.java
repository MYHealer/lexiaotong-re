package com.google.common.hash;

import java.nio.Buffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
@ElementTypesAreNonnullByDefault
final class Java8Compatibility {
    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void limit(Buffer buffer, int i) {
        buffer.limit(i);
    }

    static void position(Buffer buffer, int i) {
        buffer.position(i);
    }

    private Java8Compatibility() {
    }
}

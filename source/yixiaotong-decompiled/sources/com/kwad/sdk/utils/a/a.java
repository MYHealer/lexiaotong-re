package com.kwad.sdk.utils.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class a {

    static abstract class b {
        int offset;

        abstract byte Xi();

        b() {
        }
    }

    static class c extends b {
        boolean value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 1;
        }

        c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }
    }

    static class f extends b {
        int value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 2;
        }

        f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }
    }

    static class e extends b {
        float value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 3;
        }

        e(int i, float f) {
            this.offset = i;
            this.value = f;
        }
    }

    static class g extends b {
        long value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 4;
        }

        g(int i, long j) {
            this.offset = i;
            this.value = j;
        }
    }

    static class d extends b {
        double value;

        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 5;
        }

        d(int i, double d) {
            this.offset = i;
            this.value = d;
        }
    }

    static abstract class j extends b {
        int brJ;
        boolean brK;
        int start;
        Object value;

        j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.brJ = i3;
            this.brK = z;
        }
    }

    static class i extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 6;
        }

        i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.a.a$a, reason: collision with other inner class name */
    static class C0767a extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 7;
        }

        C0767a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }

    static class h extends j {
        @Override // com.kwad.sdk.utils.a.a.b
        final byte Xi() {
            return (byte) 8;
        }

        h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }
    }
}

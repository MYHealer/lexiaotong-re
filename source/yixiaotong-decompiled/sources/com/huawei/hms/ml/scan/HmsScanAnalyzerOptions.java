package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.p.y6;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class HmsScanAnalyzerOptions {
    public final int mode;
    public final boolean photoMode;
    public final int viewType;

    /* JADX INFO: renamed from: com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Creator {
        private int type = 0;
        private boolean photoMode = false;
        private int viewType = 0;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode, this.viewType, null);
        }

        public Creator setHmsScanTypes(int i, int... iArr) {
            int iA = y6.a(i);
            this.type = iA;
            if (iArr != null && iArr.length > 0) {
                this.type = y6.b(iA);
                for (int i2 : iArr) {
                    this.type = y6.b(i2) | this.type;
                }
            }
            return this;
        }

        public Creator setPhotoMode(boolean z) {
            this.photoMode = z;
            return this;
        }

        public Creator setViewType(int i) {
            this.viewType = i;
            return this;
        }
    }

    /* synthetic */ HmsScanAnalyzerOptions(int i, boolean z, int i2, AnonymousClass1 anonymousClass1) {
        this(i, z, i2);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private HmsScanAnalyzerOptions(int i, boolean z, int i2) {
        this.mode = i;
        this.photoMode = z;
        this.viewType = i2;
    }
}

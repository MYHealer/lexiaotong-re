package com.huawei.hms.ads.jsb;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JsbConfig {
    private boolean Code;
    private String I;
    private String V;
    private boolean Z;

    /* JADX INFO: renamed from: com.huawei.hms.ads.jsb.JsbConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private boolean Code = true;
        private String I;
        private String V;
        private boolean Z;

        public final JsbConfig build() {
            return new JsbConfig(this, null);
        }

        public final Builder enableLog(boolean z) {
            this.Z = z;
            return this;
        }

        public final Builder enableUserInfo(boolean z) {
            this.Code = z;
            return this;
        }

        public final Builder initGrs(String str) {
            this.V = str;
            return this;
        }

        public final Builder initGrs(String str, String str2) {
            this.V = str;
            this.I = str2;
            return this;
        }
    }

    private JsbConfig(Builder builder) {
        this.Code = true;
        this.Code = builder.Code;
        this.V = builder.V;
        this.I = builder.I;
        this.Z = builder.Z;
    }

    /* synthetic */ JsbConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public String V() {
        return this.V;
    }

    public boolean Z() {
        return this.Z;
    }
}

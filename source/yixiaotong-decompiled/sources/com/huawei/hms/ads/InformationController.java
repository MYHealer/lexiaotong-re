package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InformationController {
    private Boolean isUseAndroidId;
    private Boolean isUseBluetooth;
    private Boolean isUseWifi;

    /* JADX INFO: renamed from: com.huawei.hms.ads.InformationController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private Boolean Code = null;
        private Boolean V = null;
        private Boolean I = null;

        public InformationController build() {
            return new InformationController(this, null);
        }

        public Builder setUseAndroidId(Boolean bool) {
            this.I = bool;
            return this;
        }

        public Builder setUseBluetooth(Boolean bool) {
            this.V = bool;
            return this;
        }

        public Builder setUseWifi(Boolean bool) {
            this.Code = bool;
            return this;
        }
    }

    private InformationController(Builder builder) {
        this.isUseWifi = builder.Code;
        this.isUseBluetooth = builder.V;
        this.isUseAndroidId = builder.I;
    }

    /* synthetic */ InformationController(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public Boolean Code() {
        return this.isUseWifi;
    }

    public Boolean I() {
        return this.isUseAndroidId;
    }

    public Boolean V() {
        return this.isUseBluetooth;
    }
}

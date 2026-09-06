package com.opos.cmn.biz.ststrategy;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UpdateParams {
    public final String pkgName;

    /* JADX INFO: renamed from: com.opos.cmn.biz.ststrategy.UpdateParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6021a;

        public UpdateParams build() {
            if (TextUtils.isEmpty(this.f6021a)) {
                throw new NullPointerException("update params can not be null!");
            }
            return new UpdateParams(this, null);
        }

        public Builder setPkgName(String str) {
            this.f6021a = str;
            return this;
        }
    }

    private UpdateParams(Builder builder) {
        this.pkgName = builder.f6021a;
    }

    /* synthetic */ UpdateParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "UpdateParams{pkgName='" + this.pkgName + "'}";
    }
}

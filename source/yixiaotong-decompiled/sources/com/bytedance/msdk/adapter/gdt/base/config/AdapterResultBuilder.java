package com.bytedance.msdk.adapter.gdt.base.config;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AdapterResultBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3065a = false;
    private int b = -1;
    private String c = null;
    private ValueSet d = null;

    /* JADX INFO: renamed from: com.bytedance.msdk.adapter.gdt.base.config.AdapterResultBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ResultImpl implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3066a;
        private final int b;
        private final String c;
        private final ValueSet d;

        private ResultImpl(boolean z, int i, String str, ValueSet valueSet) {
            this.f3066a = z;
            this.b = i;
            this.c = str;
            this.d = valueSet;
        }

        /* synthetic */ ResultImpl(boolean z, int i, String str, ValueSet valueSet, AnonymousClass1 anonymousClass1) {
            this(z, i, str, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f3066a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.d;
        }
    }

    private AdapterResultBuilder() {
    }

    public static final AdapterResultBuilder create() {
        return new AdapterResultBuilder();
    }

    public Result build() {
        boolean z = this.f3065a;
        int i = this.b;
        String str = this.c;
        ValueSet valueSet = this.d;
        if (valueSet == null) {
            valueSet = AdnAdapterValueSetBuilder.EMPTY;
        }
        return new ResultImpl(z, i, str, valueSet, null);
    }

    public AdapterResultBuilder setCode(int i) {
        this.b = i;
        return this;
    }

    public AdapterResultBuilder setMessage(String str) {
        this.c = str;
        return this;
    }

    public AdapterResultBuilder setSuccess(boolean z) {
        this.f3065a = z;
        return this;
    }

    public AdapterResultBuilder setValues(ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }
}

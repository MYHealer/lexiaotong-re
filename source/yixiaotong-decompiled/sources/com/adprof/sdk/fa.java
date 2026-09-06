package com.adprof.sdk;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f290a;
    public final String b;

    public fa(long j, String str, byte[] bArr, String str2) {
        this.f1168a = j;
        this.f289a = str;
        this.f290a = bArr;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fa)) {
            return false;
        }
        fa faVar = (fa) obj;
        return this.f1168a == faVar.f1168a && Intrinsics.areEqual(this.f289a, faVar.f289a) && Intrinsics.areEqual(this.f290a, faVar.f290a) && Intrinsics.areEqual(this.b, faVar.b);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.f1168a) * 31) + this.f289a.hashCode()) * 31;
        byte[] bArr = this.f290a;
        return ((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PreparedAdPayload(ts=" + this.f1168a + ", key=" + this.f289a + ", body=" + Arrays.toString(this.f290a) + ", sdkTokenFull=" + this.b + ')';
    }
}

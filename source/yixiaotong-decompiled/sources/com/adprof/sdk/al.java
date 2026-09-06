package com.adprof.sdk;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zk f1035a = new zk();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f19a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Throwable f21a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f22a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f23a;
    public final String b;

    public al(int i, String str, byte[] bArr, Throwable th, String str2, boolean z) {
        this.f19a = i;
        this.f20a = str;
        this.f23a = bArr;
        this.f21a = th;
        this.b = str2;
        this.f22a = z;
    }

    public /* synthetic */ al(int i, String str, byte[] bArr, Throwable th, String str2, boolean z, int i2) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : bArr, (i2 & 8) != 0 ? null : th, null, (i2 & 32) != 0 ? false : z);
    }

    public final boolean a() {
        int i = this.f19a;
        return 200 <= i && i < 300;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al)) {
            return false;
        }
        al alVar = (al) obj;
        return this.f19a == alVar.f19a && Intrinsics.areEqual(this.f20a, alVar.f20a) && Intrinsics.areEqual(this.f23a, alVar.f23a) && Intrinsics.areEqual(this.f21a, alVar.f21a) && Intrinsics.areEqual(this.b, alVar.b) && this.f22a == alVar.f22a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f19a) * 31;
        String str = this.f20a;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        byte[] bArr = this.f23a;
        int iHashCode3 = (iHashCode2 + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
        Throwable th = this.f21a;
        int iHashCode4 = (iHashCode3 + (th == null ? 0 : th.hashCode())) * 31;
        String str2 = this.b;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.f22a;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public String toString() {
        return "SYHttpResponse(responseCode=" + this.f19a + ", data=" + this.f20a + ", bytes=" + Arrays.toString(this.f23a) + ", exception=" + this.f21a + ", message=" + this.b + ", encrypted=" + this.f22a + ')';
    }
}

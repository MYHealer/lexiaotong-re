package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3642a;
    private String b;

    public String a() {
        return this.f3642a;
    }

    public void a(String str) {
        this.f3642a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Objects.equals(this.f3642a, h0Var.f3642a) && Objects.equals(this.b, h0Var.b);
    }

    public int hashCode() {
        String str = this.f3642a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AppIdUrlInfo#" + hashCode() + "{appId=" + this.f3642a + ",urlEmpty=" + TextUtils.isEmpty(this.b) + '}';
    }
}

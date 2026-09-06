package com.oplus.instant.router.d;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import com.ubixnow.ooooo.o0OO000o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends Instant.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f5773a = new HashMap();
    Map<String, String> b = new HashMap();
    Map<String, String> c = null;
    Map<String, String> d = null;
    Callback e;
    String f;

    public b(String str, String str2) {
        b(str);
        a(str2);
    }

    private Instant.Builder a(String str) {
        this.b.put("secret", str);
        return this;
    }

    private Instant.Builder b(String str) {
        this.b.put("origin", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Req build() {
        return (TextUtils.isEmpty(this.f) || this.f.startsWith("oaps://instant/app")) ? new d(this) : new e(this);
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putExtra(String str, String str2) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putParams(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder putStat(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setCallback(Callback callback) {
        this.e = callback;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setExtra(String str) {
        this.f5773a.put(o0OO000o.o00O0O0O, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setFrom(String str) {
        this.f5773a.put("f", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPackage(String str) {
        this.f5773a.put(OapsKey.KEY_PKG, str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPage(String str) {
        this.f5773a.put("page", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    @Deprecated
    public Instant.Builder setPath(String str) {
        this.f5773a.put("path", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder setRequestUrl(String str) {
        this.f = str;
        return this;
    }

    @Override // com.oplus.instant.router.Instant.Builder
    public Instant.Builder signAsPlatform() {
        this.b.put(OapsKey.KEY_SIGN_TYPE, "1");
        return this;
    }
}

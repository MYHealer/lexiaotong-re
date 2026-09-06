package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1644a;
    private final String b;

    public String a() {
        return this.f1644a;
    }

    public String b() {
        return this.b;
    }

    public b(String str, String str2) {
        this.f1644a = str;
        this.b = str2;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new JSONObject(this.b);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f1644a, this.b);
    }
}

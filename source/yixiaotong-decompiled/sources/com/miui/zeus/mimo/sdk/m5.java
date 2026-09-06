package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5529a;
    public int b;
    public String c;

    public m5(String str) {
        this.f5529a = -1;
        this.b = 0;
        JSONObject jSONObject = new JSONObject(str);
        this.f5529a = jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{17, 68, 81, SignedBytes.MAX_POWER_OF_TWO, 16, Ascii.DC2}, "b004ea"), -1);
        this.c = jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{89, 92, 69, 65, 88, 3, 4}, "49629d"), "");
        this.b = jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{5, 86, 82, 92}, "f9690b"), 0);
        a(jSONObject);
    }

    public abstract void a(JSONObject jSONObject);

    public abstract boolean a();
}

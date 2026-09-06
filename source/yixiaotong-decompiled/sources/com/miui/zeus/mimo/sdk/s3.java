package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5593a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;

    public s3(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7) {
        this.f5593a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 69, 44, 81}, "55e51a"), this.f5593a);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 95}, "e12afa"), this.b);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{82, 65, 87}, "3792a1"), this.c);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{89, 79, 90}, "8990d7"), this.d);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{86, 93, 87, 10, 95, 86, 13}, "556d13"), this.e);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{82, 8, 16, 90, SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, 49, 5, 5, 9, 80, 2, 82, 40, 5, 94, 81}, "7fd34e"), this.f);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{3, 73, 71, 123, 84, 85, 4}, "b97558"), this.g);
            jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{88, Ascii.NAK, 71, 112, 80, 9, 15}, "9e793f"), this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

package com.miui.zeus.mimo.sdk.bean;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.miui.zeus.jni.NativeUtils;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.b6;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.s3;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.w6;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoAdInfo {
    public static final String G1 = s.d(new byte[]{47, 8, 15, 12, 112, 6, 40, 10, 0, 13}, "babc1b");
    public String A;
    public String A0;
    public String A1;
    public String B;
    public String B0;
    public Boolean B1;
    public String C;
    public int C0;
    public String C1;
    public String D;
    public String D0;
    public String D1;
    public int E;
    public int E0;
    public String F;
    public boolean F0;
    public int G;
    public boolean G0;
    public int H;
    public int H0;
    public int I0;
    public List<String> J;
    public int J0;
    public List<String> K;
    public String K0;
    public List<String> L;
    public List<String> L0;
    public List<String> M;
    public int M0;
    public List<String> N;
    public int N0;
    public String O;
    public boolean O0;
    public String P;
    public boolean P0;
    public String Q;
    public boolean Q0;
    public long R0;
    public boolean S;
    public boolean S0;
    public boolean T;
    public boolean T0;
    public String U;
    public float U0;
    public boolean V0;
    public String W;
    public boolean W0;
    public int X0;
    public String Y;
    public int Y0;
    public String Z;
    public int Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5381a;
    public String a0;
    public boolean a1;
    public int b;
    public String b0;
    public String b1;
    public String c;
    public String c0;
    public List<Asset> d0;
    public String e;
    public s3 e0;
    public String f;
    public String f1;
    public String g;
    public JSONObject g0;
    public String g1;
    public String h;
    public String h0;
    public String h1;
    public String i;
    public String i0;
    public String i1;
    public String j;
    public String k;
    public String k0;
    public long k1;
    public String l;
    public String l0;
    public long l1;
    public String m;
    public String m1;
    public String n;
    public JSONArray n0;
    public String n1;
    public float o;
    public String o0;
    public int o1;
    public String p;
    public String p0;
    public String p1;
    public List<String> q;
    public String q0;
    public List<String> r;
    public String r0;
    public String r1;
    public int s;
    public String s0;
    public String s1;
    public int t;
    public String t1;
    public String u;
    public String u1;
    public String v;
    public String v0;
    public String v1;
    public String w;
    public int w0;
    public String w1;
    public String x;
    public String x0;
    public String x1;
    public String y;
    public String y0;
    public String y1;
    public String z;
    public int z0;
    public String z1;
    public long d = 0;
    public String I = s.d(new byte[]{Ascii.NAK, 86, 71, 17, 13, 86, 0, 8}, "c35ed5");
    public final List<String> R = new ArrayList();
    public boolean V = false;
    public String X = s.d(new byte[]{85, 85, 94, 75, 0}, "3428e7");
    public int f0 = -1;
    public final Map<String, Object> j0 = new HashMap();
    public long m0 = 0;
    public long t0 = 0;
    public int u0 = 0;
    public float c1 = 0.12f;
    public int d1 = 5;
    public boolean e1 = true;
    public int j1 = 200;
    public int q1 = 30;
    public boolean E1 = true;
    public String F1 = "";

    public static class Asset implements Serializable {
        public String mDigest;
        public int mMaterialType;
        public String mUrl;
    }

    public boolean A() {
        if (this.p0.trim() == null) {
            return false;
        }
        return this.p0.trim().startsWith(s.d(new byte[]{91, 90, 87, 93, 86, Ascii.SYN, 8, Ascii.DC2, 3, 48, 84, 1, 98, 85, 87, 83, 93, Ascii.SYN}, "24488b")) || this.p0.trim().startsWith(s.d(new byte[]{90, 95, 0, 1, 87, Ascii.NAK, 8, Ascii.DC2, 3, 38, 67, 4, 68, 84, 17}, "31cd9a")) || this.p0.trim().startsWith(s.d(new byte[]{95, 95, 7, 85, 94, Ascii.SYN, 8, Ascii.DC2, 3, 36, 68, 9, 90, 98, 7, 66, 85, 7, 15}, "61d00b"));
    }

    public boolean B() {
        return this.w0 == 1;
    }

    public boolean C() {
        if (!s.d(new byte[]{66, 88, 10, 73, 126, 7, 12, 1}, "61d09f").equals(this.i1)) {
            if (!s.d(new byte[]{72, 95, 89, 73, 121, 81}, "838085").equals(this.i1)) {
                return false;
            }
        }
        return true;
    }

    public boolean E() {
        return this.E == 3;
    }

    public String G() {
        try {
            s3 s3Var = this.e0;
            if (s3Var != null) {
                this.g0.put(s.d(new byte[]{5, 0, 37, 92, 87, 4, 8, 3}, "ddf39b"), s3Var.a());
            }
            this.g0.put(s.d(new byte[]{16, 75, 92, 117, 7, 66, Ascii.NAK, 41, 9, 6, 84, 51, 12, 92, 92, 92}, "e893f1"), this.X);
            this.g0.put(s.d(new byte[]{2, 0, 39, 13, 93, 77, 0, 13, 8, 7, 67, 50, 10, 0, 16, 10}, "cddb39"), this.h0);
            this.g0.put(s.d(new byte[]{88, 93, 122, 87, 92, 65, 0, 13, 8, 7, 67, 45, 92, 80, 94, 80, 70}, "999825"), this.i0);
            this.g0.put(s.d(new byte[]{95, 67, 126, 77, 89, 94, 50, 7, Ascii.DC4, 7, 84, 11}, "608852"), this.E1);
            this.g0.put(s.d(new byte[]{17, 68, 89, 42, 3, 14, 4}, "c42dbc"), this.r1);
            this.g0.put(s.d(new byte[]{67, Ascii.NAK, 15, 45, 87, 11, 15}, "1edd4d"), this.s1);
        } catch (Exception unused) {
        }
        return this.g0.toString();
    }

    public List<String> a(w3 w3Var) {
        if (this.R.isEmpty()) {
            Iterator<String> it = c().iterator();
            while (it.hasNext()) {
                String cachedResource = w3Var.getCachedResource(it.next(), false);
                if (b.h(cachedResource)) {
                    this.R.add(cachedResource);
                }
            }
        }
        return new ArrayList(this.R);
    }

    public List<String> a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!TextUtils.isEmpty(key)) {
                arrayList.add(key);
            }
        }
        return arrayList;
    }

    public final List<String> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }

    public void a(JSONObject jSONObject) {
        int i;
        s3 s3Var;
        long j;
        float f;
        float f2;
        this.g0 = jSONObject;
        this.j0.put(s.d(new byte[]{73, SignedBytes.MAX_POWER_OF_TWO, 88, 1, 85}, "921b00"), Long.valueOf(jSONObject.optLong(s.d(new byte[]{Ascii.NAK, Ascii.SYN, 93, 6, 93}, "ed4e8a"), 0L)));
        this.c = jSONObject.optString(s.d(new byte[]{4, 65}, "a9db8b"));
        this.d = jSONObject.optLong(s.d(new byte[]{15, 0}, "fd7130"));
        this.e = jSONObject.optString(s.d(new byte[]{69, 90, 70, 10, 92}, "132f9f"));
        this.f = jSONObject.optString(s.d(new byte[]{68, 66, 94, 92, 85, 16, Ascii.CAN}, "77314b"));
        this.g = jSONObject.optString(s.d(new byte[]{83, 67, 86, 93, 82}, "117368"));
        this.h = jSONObject.optString(s.d(new byte[]{4, 81, 127, 2, 65, 83}, "e52c38"));
        this.i = jSONObject.optString(s.d(new byte[]{81, Ascii.DC4, 73, 45, 88, 84, 4}, "0d9c99"));
        this.j = jSONObject.optString(s.d(new byte[]{86, Ascii.NAK, 65, 52, 83, 70, Ascii.DC2, 13, 9, 12}, "7e1b64"));
        this.k = jSONObject.optString(s.d(new byte[]{84, Ascii.DC4, 67, 116, 81, 71, 4, 8, 9, Ascii.DC2, 84, Ascii.ETB}, "5d3041"));
        this.l = jSONObject.optString(s.d(new byte[]{81, 68, Ascii.DC4, 103, 86, 75, 12, 13, Ascii.NAK, 17, 88, 10, 94}, "04d739"));
        this.m = jSONObject.optString(s.d(new byte[]{81, Ascii.SYN, Ascii.DC2, 97, 16, 93, Ascii.ETB, 5, 5, Ascii.ESC}, "0fb1b4"));
        this.n = jSONObject.optString(s.d(new byte[]{80, 68, 72, 125, 12, Ascii.NAK, 19, 11, 2, Ascii.ETB, 82, 17, 88, 91, 86}, "1484ba"));
        this.o = jSONObject.optLong(s.d(new byte[]{89, Ascii.DC4, 68, 106, 87, 71, 8, 10, 1, 49, 82, 10, 74, 1}, "8d4863"));
        this.p = jSONObject.optString(s.d(new byte[]{88, 71, 66, 123, 93, 11, 12, 1, 8, Ascii.SYN, 127, 16, 84}, "97282f"));
        this.q = a(jSONObject.optJSONArray(s.d(new byte[]{3, Ascii.DC4, 17, 100, 87, 94, Ascii.DC2}, "bda069")));
        this.r = a(jSONObject.optJSONArray(s.d(new byte[]{0, 73, Ascii.NAK, 100, 87, 19, 4, 1, 8, 17, 89, 10, Ascii.NAK, 108, Ascii.ETB, 91, 71}, "a9e74a")));
        this.s = jSONObject.optInt(s.d(new byte[]{0, 85, 55, 77, 26, 90, 4}, "a1d9c6"));
        this.t = jSONObject.optInt(s.d(new byte[]{Ascii.SYN, 84, 67, 95, 7, Ascii.DC2, 53, Ascii.GS, Ascii.SYN, 7}, "b518bf"));
        this.u = jSONObject.optString(s.d(new byte[]{70, 72, 40, 1}, "38ae57"));
        this.v = jSONObject.optString(s.d(new byte[]{6, 80, 93, 19, 88, 13, 15, 15}, "b58c4d"));
        this.w = jSONObject.optString(s.d(new byte[]{90, 81, 13, 1, 15, 93, 6, 52, 7, 5, 84, 48, 68, 92}, "60cef3"));
        this.x = jSONObject.optString(s.d(new byte[]{85, 66, 71, 65, 86, 8, 55, 85, 51, 16, 93}, "77359f"));
        this.y = jSONObject.optString(s.d(new byte[]{85, 71, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 9, 86, 55, 86, 51, 16, 93}, "724bf8"));
        this.z = jSONObject.optString(s.d(new byte[]{85, 17, 66, 66, 89, 92, 55, 86, 51, 16, 93, 54, 94, 3, 88}, "7d6662"));
        this.A = jSONObject.optString(s.d(new byte[]{91, 81, 13, 87, 98, 66, 13}, "22b970"));
        this.B = jSONObject.optString(s.d(new byte[]{68, 90, 0, 86, 95, 55, 19, 8}, "23d30b"));
        this.C = jSONObject.optString(s.d(new byte[]{17, 85, 1, 88, 88, 83, 4, 42, 7, 15, 84}, "a4b394"));
        this.D = jSONObject.optString(s.d(new byte[]{88, 67, 8, 72, 101, 5, 19, 3, 3, Ascii.SYN, 101, Ascii.FS, 66, 83}, "26e81d"));
        this.E = jSONObject.optInt(s.d(new byte[]{92, 84, 69, 81, 65, 13, 0, 8, 50, Ascii.ESC, 65, 0}, "15143d"));
        this.F = jSONObject.optString(s.d(new byte[]{83, 94, 11, 83, 70, 34, 0, Ascii.SYN, 2, 38, 80, 17, 84}, "52d22a"));
        this.G = jSONObject.optInt(s.d(new byte[]{19, 15, 7, 65, 14}, "dfc5fd"));
        this.H = jSONObject.optInt(s.d(new byte[]{93, 85, 81, 1, 10, 65}, "508fb5"));
        this.I = jSONObject.optString(s.d(new byte[]{81, 67, 71, 84, 66, 45, 19, 13, 3, 12, 69, 4, 68, 89, 91, 95}, "00416b"), s.d(new byte[]{65, 93, Ascii.ETB, Ascii.DC2, 81, 87, 0, 8}, "78ef84"));
        this.J = a(jSONObject.optJSONArray(s.d(new byte[]{67, 80, 3, Ascii.DC4, 116, 95, 15, 13, Ascii.DC2, 13, 67, 48, 71, 85, Ascii.NAK}, "59fc90")));
        this.K = a(jSONObject.optJSONArray(s.d(new byte[]{1, 94, 95, 0, 94, 116, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, 55, SignedBytes.MAX_POWER_OF_TWO, 90, 16}, "b26c59")));
        this.L = a(jSONObject.optJSONArray(s.d(new byte[]{73, 91, 83, Ascii.ESC, 127, 13, 15, 13, Ascii.DC2, 13, 67, 48, 75, 91, 65}, "972b2b")));
        this.M = a(jSONObject.optJSONArray(s.d(new byte[]{71, 17, 93, 72, 123, 94, 15, 13, Ascii.DC2, 13, 67, 48, 70, 9, 65}, "4e2861")));
        this.N = a(jSONObject.optJSONArray(s.d(new byte[]{85, 92, 93, 11, Ascii.NAK, 93, 44, 11, 8, 11, 69, 10, 65, 96, 65, 14, Ascii.NAK}, "353bf5")));
        this.Y = jSONObject.optString(s.d(new byte[]{87, 93, 92, 91, 89, 37, 19, 1, 7}, "41582d"));
        this.Z = jSONObject.optString(s.d(new byte[]{91, 14, 10, 120, 67, 76, 14, 32, 9, Ascii.NAK, 95, 9, 90, 0, 0, 120, 68, 93, 0}, "5ad968"));
        this.a0 = jSONObject.optString(s.d(new byte[]{7, 68, Ascii.ETB, 94, 55, 68, 19}, "f1c1d0"));
        this.b0 = jSONObject.optString(s.d(new byte[]{13, 9, 88, 115, 66, 67, 14, 55, Ascii.DC2, 16}, "cf6277"));
        this.c0 = jSONObject.optString(s.d(new byte[]{69, 13, 88, 84, 100, 95, 17, 38, 9, 26, 112, Ascii.ETB, 84, 3}, "1b7806"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(s.d(new byte[]{85, 66, 68, 82, 69, SignedBytes.MAX_POWER_OF_TWO}, "417713"));
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    Asset asset = new Asset();
                    if (jSONObject2.has(s.d(new byte[]{Ascii.SYN, Ascii.SYN, 93}, "cd137c"))) {
                        asset.mUrl = jSONObject2.optString(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 16, 88}, "5b4783"));
                    }
                    if (jSONObject2.has(s.d(new byte[]{95, 83, SignedBytes.MAX_POWER_OF_TWO, 82, SignedBytes.MAX_POWER_OF_TWO, 81, 0, 8, 50, Ascii.ESC, 65, 0}, "224728"))) {
                        asset.mMaterialType = jSONObject2.optInt(s.d(new byte[]{88, 86, 71, 87, 69, 91, 0, 8, 50, Ascii.ESC, 65, 0}, "573272"));
                    }
                    if (jSONObject2.has(s.d(new byte[]{1, 8, 86, 3, Ascii.NAK, 70}, "ea1ff2"))) {
                        asset.mDigest = jSONObject2.optString(s.d(new byte[]{92, 93, 85, 93, 68, Ascii.NAK}, "84287a"));
                    }
                    arrayList.add(asset);
                } catch (JSONException e) {
                    m.b(G1, e.getMessage());
                }
            }
        }
        this.d0 = arrayList;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(s.d(new byte[]{17, 1, 91, 36, 5, 125, 4, 16, 7, 11, 93}, "be0ea9"));
        if (jSONObjectOptJSONObject != null) {
            this.k0 = jSONObjectOptJSONObject.optString(s.d(new byte[]{16, 86, 8, 88, 80, 5, Ascii.NAK, 13, 9, 12, 120, 11, 0, 88}, "f7d14d"));
            this.l0 = jSONObjectOptJSONObject.optString(s.d(new byte[]{90, 1, 55, 81, 85, Ascii.DC4, 13, 5, Ascii.DC2, 7}, "24c48d"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(s.d(new byte[]{83, 85, 115, 11, 10, Ascii.NAK, 19, 11, 10}, "210dda"));
        if (jSONObjectOptJSONObject2 != null) {
            this.m0 = jSONObjectOptJSONObject2.optLong(s.d(new byte[]{5, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 5, 77, 8, 14, 10}, "aa2d9a"));
            this.n0 = jSONObjectOptJSONObject2.optJSONArray(s.d(new byte[]{1, 70, 72, 100, 4, 95, 6, 12, Ascii.DC2}, "e583a6"));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(s.d(new byte[]{72, 89, 69, 84, 90, 3, Ascii.NAK, 1, Ascii.DC4, 17}, "88757f"));
        if (jSONObjectOptJSONObject3 != null) {
            this.o0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{86, 71, 93, 86, 8, 16, 0, 16, 15, 13, 95}, "9543fd"));
            this.p0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{16, 83, 94, 73, 13, 86, Ascii.NAK, 1, 50, Ascii.ESC, 65, 0}, "d639a7"));
            this.q0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{70, 94, 92, 87, 69, 70, 0, 8, 10}, "305962"), s.d(new byte[]{-48, -128, -23, -119, -40, -118, -124, -54, -17, -118, -110, -32}, "48bae7"));
            this.r0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{80, 11, 75, Ascii.DC2, 87, 92, 13}, "9e8f60"), s.d(new byte[]{-43, -66, -91, -42, -115, -71, -124, -34, -14, -123, -91, -51}, "376319"));
            this.s0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{0, 0, Ascii.SYN, 0, 11, 14}, "debabb"), s.d(new byte[]{-123, -4, -109, -124, -88, -70, -119, -53, -64, -124, -78, -32}, "cc6c41"));
            String strOptString = jSONObjectOptJSONObject3.optString(s.d(new byte[]{Ascii.DC2, 93, 80, 17, 35, 16, Ascii.NAK, 16, 9, 12, 101, 12, 12, 83}, "a69aae"));
            if (TextUtils.isEmpty(strOptString)) {
                j = 0;
            } else {
                try {
                    j = Long.parseLong(strOptString);
                } catch (Exception unused) {
                    j = 0;
                }
            }
            this.t0 = j;
            this.u0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{65, 82, 11, 17, 33, Ascii.ETB, Ascii.NAK, 16, 9, 12, 124, 10, 86, 92}, "29bacb")), 0);
            this.v0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{68, 12, 70, 123, 0, 74, 5, 38, 19, Ascii.SYN, 69, 10, 94, 45, 87, 85, 4}, "0c68a8"), s.d(new byte[]{-48, -6, -109, -125, -86, -65, -119, -53, -64, -124, -78, -32}, "6e6d64"));
            this.w0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{77, 90, Ascii.NAK, 33, 88, 16, 5, 48, Ascii.US, Ascii.DC2, 84}, "95eb9b")), 0);
            this.x0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{Ascii.NAK, 88, SignedBytes.MAX_POWER_OF_TWO, 37, 5, SignedBytes.MAX_POWER_OF_TWO, 5, 45, 8, 17, 69, 4, 13, 91}, "a70fd2"), s.d(new byte[]{-121, -17, -94, -48, -115, -71, -124, -34, -14, -123, -91, -51}, "af1519"));
            this.y0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 92, Ascii.NAK, 119, 85, SignedBytes.MAX_POWER_OF_TWO, 5, 49, 8, 11, 95, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, 82, 9, 88}, "43e442"), s.d(new byte[]{-122, -37, -67, -38, -117, -123, -124, -54, -17, -118, -110, -32}, "bc6268"));
            this.z0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{94, 93, 16, 66, 87, 89, 13, 35, 19, 11, 85, 0, 99, 92, 2, 69, 66, 97, Ascii.CAN, Ascii.DC4, 3}, "73c665")), 0);
            this.A0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, 15, 75, 66, 80, 89, 13, 35, 19, 11, 85, 0, 103, 14, 89, 69, 69, 97, 4, Ascii.FS, Ascii.DC2}, "3a8615"));
            this.D0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{81, 83, 69, 93, 70, 0, 38, 17, 15, 6, 84, 49, 95, 81, 66, SignedBytes.MAX_POWER_OF_TWO, 100, 0, Ascii.EM, 16}, "00140e"));
            this.B0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{89, 12, 38, 66, 94, 6, 4, 48, 9, 3, 66, 17, 101, 92, Ascii.EM, 67}, "19a77b"));
            this.C0 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{88, 81, Ascii.ETB, 93, 19, 87, 40, 10, 5, 7, 95, 17, 80, 68, 6, 112, 16, SignedBytes.MAX_POWER_OF_TWO, 0, 16, 15, 13, 95}, "92c4e2"));
            this.E0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{11, 12, 87, 84, 93, 71, 8, Ascii.DC2, 3, 38, 84, 17, 3, 11, 90, 98, 71, 74, 13, 1}, "bb4133")), 0);
            this.F0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{13, 16, 54, 16, 6, 40, Ascii.DC2, 5, 34, 11, 66, 14, 40, 17, Ascii.SYN, 32, 2, 6, 9, 1}, "dcccce")), true);
            this.G0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, Ascii.DC2, 41, 88, 86, 83, 13, 1, 34, 7, 84, Ascii.NAK, 95, 8, 15, 82, 110, 94, 0, 41, Ascii.NAK, 3}, "3aa987")), true);
            this.H0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{16, 90, 86, 89, 96, 93, 17, 38, 9, 26, 101, Ascii.FS, Ascii.DC4, 80}, "d59544")), 0);
            this.I0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{Ascii.DC2, 75, 13, 84, 9, 70, 8, 11, 8, 49, 69, 4, 16, 77, 54, 80, 11, 87}, "b9b9f2")), 0);
            this.J0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{68, 67, 92, 94, 95, 70, 8, 11, 8, 38, 68, Ascii.ETB, 85, 69, 90, 92, 94}, "413302")), 0);
            this.K0 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{69, 67, 89, 90, 92, 77, 8, 11, 8, 46, 94, 6, 84, 69, 95, 88, 93}, "516739"));
            this.L0 = a(jSONObjectOptJSONObject3.optJSONArray(s.d(new byte[]{19, Ascii.SYN, 87, 12, 87, 67, 8, 11, 8, 43, 92, 2, 16}, "cd8a87")));
            this.M0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, 2, 65, 81, Ascii.DC2, 82, 51, 1, 0, 16, 84, Ascii.SYN, 92, 55, 92, 85, 1}, "4c58d7")), 0);
            this.N0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{15, 83, 65, 89, SignedBytes.MAX_POWER_OF_TWO, 86, 51, 1, 0, 16, 84, Ascii.SYN, 9, 124, SignedBytes.MAX_POWER_OF_TWO, 93}, "a25063")), 0);
            this.O0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{67, 11, 86, 1, 14, 123, 15, 8, 15, 12, 84, 41, 90, 3, 86, 13, 15, 83}, "5b2da4")), false);
            this.P0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{89, 69, 106, 11, 87, SignedBytes.MAX_POWER_OF_TWO, 50, 0, 13, 50, 94, Ascii.NAK, 69, 70}, "069c87")), false);
            this.S0 = jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{91, 80, 4, 87, 115, 11, Ascii.SYN, 10, 10, 13, 80, 1, 102, 69, 4, 86, 83}, "55a37d"));
            this.R0 = jSONObjectOptJSONObject3.optLong(s.d(new byte[]{Ascii.ETB, 10, 13, 67, 117, 90, 12, 13, Ascii.DC2, 43, 95, 17, 1, 16, Ascii.DC4, 85, 85}, "dbb493"), 1000L);
            this.Q0 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{8, 69, 99, 70, 1, 59, 8, 5, 9, 15, 88, 51, 8, 82, 83, 90, 52, 15, 0, Ascii.GS, 3, 16}, "a665dc")), true);
            this.T0 = jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{81, SignedBytes.MAX_POWER_OF_TWO, 124, 6, 119, 69, Ascii.NAK, 11, 34, 7, 84, Ascii.NAK, 84, 90, 90, 88}, "834360"));
            this.V0 = jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{11, Ascii.ETB, 123, 91, 85, 66, 13, 13, 7, 12, 82, 0, 52, 1, 74, 93, 94, 75}, "bd8482"));
            try {
                f = Float.parseFloat(jSONObjectOptJSONObject3.optString(s.d(new byte[]{86, 6, 109, 16, 81, 94, Ascii.DC2, Ascii.DC4, 7, 16, 84, 11, 84, Ascii.ESC}, "7b9b00")));
            } catch (Exception unused2) {
                f = 0.1f;
            }
            this.U0 = f;
            this.W0 = jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{16, 68, 93, 112, 10, 95, 5, 1, Ascii.DC4, 52, 88, 0, Ascii.DC2}, "e782c1"));
            for (String str : jSONObjectOptJSONObject3.optString(s.d(new byte[]{16, Ascii.DC4, 5, 10, 65, 113, 4, Ascii.DC2, 54, 3, 67, 4, 9}, "dfdd25")).split(s.d(new byte[]{Ascii.GS}, "1dbf64"))) {
                this.j0.put(str, this.g0.optString(str));
            }
            this.X0 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{3, 92, 81, 94, 1, 100, 9, Ascii.SYN, 3, 17, 89, 10, 14, 86}, "b262d0"));
            this.Y0 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{3, 90, 87, 81, 95, 86, 19, 5, Ascii.DC2, 11, 94, 11, 54, 81, 70, 81, SignedBytes.MAX_POWER_OF_TWO, 91, 14, 8, 2}, "b94433"));
            this.Z0 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{67, 88, 12, 3, 103, 90, 19, 1, Ascii.NAK, 10, 94, 9, 83}, "71af32"));
            this.a1 = b.a(jSONObjectOptJSONObject3.optString(s.d(new byte[]{88, SignedBytes.MAX_POWER_OF_TWO, 125, 6, 92, 5, 50, 12, 7, 9, 84}, "133c9a")), false);
            this.b1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{3, 71, 65, 71, 10, 92, 50, 16, Ascii.US, 14, 84}, "a253e2"));
            try {
                f2 = Float.parseFloat(jSONObjectOptJSONObject3.optString(s.d(new byte[]{69, 14, 10, 69, 112, 93, Ascii.DC2, 16, 7, 12, 82, 0}, "6bc544")));
            } catch (Exception unused3) {
                f2 = 0.12f;
            }
            this.c1 = f2;
            this.d1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 69, 91, 83, 17, 90, 37, 17, Ascii.DC4, 3, 69, 12, 92, 91}, "3572b2"), 5);
            this.e1 = jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{84, 89, 13, 80, 94, 88, 6, 52, 7, 5, 84, 53, 74, 93, 15, 91, 86, 82}, "88c476"));
            this.g1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{12, 15, 85, 6, 89, 77, 8, Ascii.DC2, 3, 47, 84, Ascii.SYN, Ascii.SYN, 0, 81, 6}, "ea6c79"));
            this.f1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{10, 87, 90, 3, 94, 76, 8, Ascii.DC2, 3, 54, 72, Ascii.NAK, 6}, "c99f08"), s.d(new byte[]{84, 91, 11, Ascii.NAK, 89, 3, Ascii.NAK, 1, 43, 11, 66, Ascii.SYN, 94, 91, 8}, "74fe5f"));
            this.h1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{89, 88, 7, 4, 88, 68, 8, Ascii.DC2, 3, 35, 82, 17, 89, SignedBytes.MAX_POWER_OF_TWO, 1, 44, 83, 67, Ascii.DC2, 5, 1, 7}, "06da60"));
            this.i1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{80, 2, 96, Ascii.SYN, 94, 83, Ascii.DC4, 7, Ascii.DC2, 54, 72, Ascii.NAK, 84}, "1f0d17"), s.d(new byte[]{82, 65, 8}, "31c494"));
            this.j1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{83, 14, 6, 80, 83, 55, 17, 15, 55, Ascii.ETB, 88, 6, 91, 47, 13, SignedBytes.MAX_POWER_OF_TWO, 76, 4, 13, 8, 50, 11, 92, 0, 95, 19, Ascii.ETB}, "0fc38e"), 200);
            this.k1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{17, 100, 55, 16, 89, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 48, 15, 15, 84}, "d7dd82"));
            this.l1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{Ascii.SYN, 106, 38, 77, Ascii.ETB, 84, Ascii.NAK, 13, 9, 12}, "c9b8e5"));
            this.m1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{81, 69, 75, 1, 76, 108, 19, 8}, "068d89"));
            this.n1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{67, 94, 87, 91, 84, 97, 19, 8}, "066014"));
            this.o1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{69, 95, 2, 94, 86, 54, 9, Ascii.SYN, 3, 17, 89, 10, 90, 83}, "67c53b"), 3);
            this.q1 = jSONObjectOptJSONObject3.optInt(s.d(new byte[]{71, 15, 4, 73, 36, 6, 34, 0, 50, 11, 92, 0}, "7ce0eb"), 30);
            this.t1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{12, 88, 126, 83, 92, 9, 44, Ascii.ETB, 1}, "e6825e"));
            this.u1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{94, 8, 37, 3, 94, 14, 35, 16, 8}, "7fcb7b"));
            this.v1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{76, 92, 13, 88, 17, Ascii.DC2, 0, 8, 10}, "92d6bf"));
            this.w1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, 95, 32, 90, Ascii.DC2, 81, Ascii.ETB, 1, 32, 3, 88, 9, 126, 66, 6}, "31a9f8"));
            this.x1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, 8, 119, 6, Ascii.SYN, 80, Ascii.ETB, 1, 32, 3, 88, 9, 113, Ascii.DC2, 88}, "3f6eb9"));
            this.y1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{93, 8, 39, 80, 17, 12, Ascii.ETB, 1, 53, Ascii.ETB, 82, 6, 81, Ascii.NAK, Ascii.NAK, 113, 17, 11}, "4ff3ee"));
            this.B1 = Boolean.valueOf(jSONObjectOptJSONObject3.optBoolean(s.d(new byte[]{90, 14, 1, 83, 92, 123, Ascii.NAK, 10, 48, 3, 93, 12, 93}, "9fd079"), false));
            this.z1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, 90, 93, 69, 92, 5, 13, 37, 5, Ascii.SYN, 88, 19, 86, 118, 65, 69, 65, 11, 15}, "34415d"));
            this.A1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{89, 93, 89, 77, 8, 7, 13, 38, 19, Ascii.SYN, 69, 10, 94}, "0309af"));
            this.C1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{88, 88, 1, 4, 95, 77, 8, Ascii.DC2, 3, 50, 94, Ascii.NAK, 119, 81}, "16ba19"));
            this.D1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{88, 93, 1, 83, 8, 76, 8, Ascii.DC2, 3, 50, 94, Ascii.NAK, 115, 84}, "13b6f8"));
            i = 8;
            this.F1 = jSONObjectOptJSONObject3.optString(s.d(new byte[]{1, 69, 87, 33, 2, 97, 8, 7}, "c19ce1"), "");
            jSONObjectOptJSONObject3.optString(s.d(new byte[]{90, Ascii.ETB, 88, 35, 80, 51, 8, 7}, "8c6e7c"), "");
        } else {
            i = 8;
        }
        byte[] bArr = new byte[i];
        // fill-array-data instruction
        bArr[0] = 7;
        bArr[1] = 82;
        bArr[2] = 122;
        bArr[3] = 89;
        bArr[4] = 93;
        bArr[5] = 94;
        bArr[6] = 8;
        bArr[7] = 3;
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(s.d(bArr, "f69638"));
        if (jSONObjectOptJSONObject4 != null) {
            try {
                s3Var = new s3(jSONObjectOptJSONObject4.optString(s.d(new byte[]{76, 73, 124, 93}, "9959eb")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{72, 86}, "883fc9")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{84, 65, 91}, "5751ed")), jSONObjectOptJSONObject4.optInt(s.d(new byte[]{0, 70, 84}, "a07add")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{83, 91, 7, 88, 87, 83, 13}, "03f696")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{92, 8, 68, 88, 77, 79, 49, 5, 5, 9, 80, 2, 92, 40, 81, 92, 92}, "9f0196")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{82, 71, 17, 126, 88, 95, 4}, "37a092")), jSONObjectOptJSONObject4.optString(s.d(new byte[]{2, Ascii.DC2, 73, 43, 5, 12, 15}, "cb9bfc")));
            } catch (Exception e2) {
                e2.printStackTrace();
                s3Var = null;
            }
        } else {
            s3Var = null;
        }
        this.e0 = s3Var;
        this.X = jSONObject.optString(s.d(new byte[]{Ascii.SYN, 69, 6, 115, 81, 16, Ascii.NAK, 41, 9, 6, 84, 51, 10, 82, 6, 90}, "c6c50c"));
        this.f0 = jSONObject.optInt(s.d(new byte[]{90, 82, 19, 92, 0, 77, 50, 7, Ascii.DC4, 7, 84, 11, 68, 91, 14, 67, 49, SignedBytes.MAX_POWER_OF_TWO, 17, 1}, "73a7e9"), 0);
        this.h0 = jSONObject.optString(s.d(new byte[]{87, 84, 119, 95, 8, 16, 0, 13, 8, 7, 67, 50, 95, 84, SignedBytes.MAX_POWER_OF_TWO, 88}, "6040fd"));
        this.i0 = jSONObject.optString(s.d(new byte[]{85, 0, 37, 95, 12, 69, 0, 13, 8, 7, 67, 45, 81, 13, 1, 88, Ascii.SYN}, "4df0b1"));
        this.E1 = jSONObject.optBoolean(s.d(new byte[]{93, Ascii.DC2, 118, 69, 89, 13, 50, 7, Ascii.DC4, 7, 84, 11}, "4a005a"), true);
        this.p1 = jSONObject.optString(s.d(new byte[]{Ascii.DC4, 89, 3, SignedBytes.MAX_POWER_OF_TWO, 37, 6, 49, 5, 1, 7, 100, Ascii.ETB, 8}, "d5b9db"));
        if (this.j0.containsKey(s.d(new byte[]{0, 68, 66, Ascii.SYN, 90, 88, 47, 5, 11, 7}, "b16b56"))) {
            this.j0.put(s.d(new byte[]{90, 69, 68, Ascii.NAK, 90, 95, 47, 5, 11, 7}, "800a51"), g());
        }
        this.r1 = jSONObject.optString(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 71, 88, 40, 80, 14, 4}, "273f1c"));
        this.s1 = jSONObject.optString(s.d(new byte[]{67, 65, 14, 42, 82, 90, 15}, "11ec15"));
    }

    public boolean a(long j, long j2) {
        if (j >= 30000) {
            return true;
        }
        long j3 = this.t0;
        if (j3 == -1) {
            return false;
        }
        if (j3 == 0 || j3 <= 0) {
            return true;
        }
        long j4 = j3 * 1000;
        return j4 <= j2 && j >= j4;
    }

    public final boolean a(String str, String str2) {
        String strA = NativeUtils.a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strReplaceAll = strA.replaceAll(PPSLabelView.Code, "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            return false;
        }
        for (String str3 : strReplaceAll.split(s.d(new byte[]{Ascii.FS}, "05dc4f"))) {
            if (TextUtils.equals(str2, str3)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        if (TextUtils.isEmpty(this.p)) {
            return s.d(new byte[]{83, -47, -85, -61, -115, -103, -27, -127, -18, -28}, "c76be6");
        }
        return this.p.endsWith(s.d(new byte[]{-33, -5, -111, -38, -54, -31, -124, -20, -32}, "9f02ee")) ? this.p : this.p + s.d(new byte[]{-41, -82, -111, -47, -100, -73, -124, -20, -32}, "130933");
    }

    public String c(w3 w3Var) {
        if (b.g(this.O) && w3Var != null) {
            this.O = w3Var.getCachedResource(f(), false);
        }
        return this.O;
    }

    public List<String> c() {
        List<String> list = this.r;
        return list == null ? new ArrayList() : list;
    }

    public File d(w3 w3Var) {
        if (b.g(this.Q)) {
            this.Q = w3Var.getCachedResource(this.B, false);
        }
        String cachedResource = this.Q;
        if (TextUtils.isEmpty(cachedResource)) {
            cachedResource = w3Var.getCachedResource(this.B, false);
        }
        if (TextUtils.isEmpty(cachedResource) || !new File(cachedResource).exists()) {
            return null;
        }
        return new File(cachedResource);
    }

    public List<String> d() {
        List<String> list = this.q;
        return list == null ? new ArrayList() : list;
    }

    public String e() {
        if (TextUtils.isEmpty(this.j)) {
            return null;
        }
        String strD = s.d(new byte[]{-42, -65, -23, -42, -7, -98, 65}, "16a0e2");
        return this.j.contains(strD) ? this.j : strD + this.j;
    }

    public String f() {
        List<Asset> list = this.d0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Asset asset : this.d0) {
            int i = asset.mMaterialType;
            if (i == 1 || i == 2) {
                return asset.mUrl;
            }
        }
        return null;
    }

    public String g() {
        if (t()) {
            return w6.a(y8.f5752a, this) ? this.r0 : this.q0;
        }
        return this.s0;
    }

    public String h() {
        List<Asset> list = this.d0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.d0.get(0).mUrl;
    }

    public String i() {
        return (!t() || w6.a(y8.f5752a, this)) ? this.y1 : this.v1;
    }

    public List<String> j() {
        ArrayList arrayList = new ArrayList();
        List<Asset> list = this.d0;
        if (list != null && !list.isEmpty()) {
            for (Asset asset : this.d0) {
                int i = asset.mMaterialType;
                if (i == 1 || i == 2) {
                    arrayList.add(asset.mUrl);
                }
            }
        }
        return arrayList;
    }

    public String k() {
        return (!t() || w6.a(y8.f5752a, this)) ? this.h1 : this.g1;
    }

    public String l() {
        if (!t() || w6.a(y8.f5752a, this)) {
            return TextUtils.isEmpty(this.z1) ? this.r0 : this.z1;
        }
        return TextUtils.isEmpty(this.A1) ? this.q0 : this.A1;
    }

    public String m() {
        return (!t() || w6.a(y8.f5752a, this)) ? this.x1 : this.u1;
    }

    public int n() {
        return this.I0 * 1000;
    }

    public int o() {
        long j = this.t0;
        if (j >= 0 || j == -1) {
            return this.u0;
        }
        return 0;
    }

    public String p() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        if (TextUtils.isEmpty(this.f)) {
            return !TextUtils.isEmpty(this.i) ? this.i : "";
        }
        return this.f;
    }

    public String q() {
        if (t()) {
            return w6.a(y8.f5752a, this) ? this.x0 : this.y0;
        }
        return this.v0;
    }

    public String r() {
        return !TextUtils.isEmpty(this.i) ? this.i : this.g;
    }

    public String[] s() {
        String strD;
        if (!t()) {
            strD = b.h(this.B0) ? this.B0 : s.d(new byte[]{-45, -72, -14, -41, -40, -77, -124, -35, -39, -121, -96, -17, 14, -39, -58, -80, -125, -81, -22}, "51a2d3") + this.C0 + s.d(new byte[]{-126, -105, -10, -37, -111, -78, -124, -21, -16, -121, -108, -13, -128, -70, -43, 19}, "e0d234");
        } else if (w6.a(y8.f5752a, this)) {
            strD = b.h(this.D0) ? this.D0 : s.d(new byte[]{-41, -70, -10, -36, -113, -31, -124, -34, -14, -123, -91, -51, 10, -37, -62, -69, -44, -3, -22}, "13e93a") + this.C0 + s.d(new byte[]{-48, -62, -89, -33, -112, -25, -124, -21, -16, -121, -108, -13, -46, -17, -124, Ascii.ETB}, "7e562a");
        } else {
            strD = b.h(this.A0) ? this.A0 : s.d(new byte[]{-44, -54, -80, -116, -64, -29, -124, -54, -22, -124, -71, -11, 10, -126, -74, -12, -122, -17, -20, -116, -63, -63, -40, -15, -80, -127, -100, -14, -122, -20, -48, 69}, "1d9dcf");
        }
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        String[] strArrSplit = strD.split(s.d(new byte[]{10}, "14f829"));
        if (strArrSplit.length == 0) {
            return null;
        }
        String str = strArrSplit[0];
        String str2 = strArrSplit.length > 1 ? strArrSplit[1] : null;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        strArr[0] = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        strArr[1] = str2;
        return strArr;
    }

    public boolean t() {
        return this.t == 2;
    }

    public boolean u() {
        return s.d(new byte[]{6, 70, 83, 6, 13, 0}, "d31dae").equals(this.b1);
    }

    public boolean v() {
        return b.a(this.X, false);
    }

    public boolean w() {
        return this.P0 || this.G0;
    }

    public boolean x() {
        return this.p0.trim().startsWith(s.d(new byte[]{12, 15, 5, 85, 95, 17, 8, Ascii.DC2, 3, 43, 92, 2, 51, 4, Ascii.DC4, 111, 97, 84}, "eaf01e")) || this.p0.trim().startsWith(s.d(new byte[]{80, 8, 82, 7, 90, 69, 8, Ascii.DC2, 3, 43, 92, 2, 113, 9, 67, Base64.padSymbol, 100, 0}, "9f1b41"));
    }

    public boolean y() {
        return this.p0.startsWith(s.d(new byte[]{81, 13, 84, 92, 11, 76, 8, Ascii.DC2, 3, 50, 93, 4, 65, 2, 85, 85, 0, 104, 0, 3, 3}, "8c79e8"));
    }

    public boolean z() {
        if (!s.d(new byte[]{94, 35, 73, 73}, "6b99e9").equals(this.i1)) {
            if (!s.d(new byte[]{65, 11, 87, SignedBytes.MAX_POWER_OF_TWO, 34, 83, 12, 1}, "5b99e2").equals(this.i1)) {
                if (!s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 8, 4, Ascii.ESC, 39, 92}, "0debf8").equals(this.i1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean D() {
        if (TextUtils.isEmpty(this.i) && TextUtils.isEmpty(e()) && TextUtils.isEmpty(this.k) && TextUtils.isEmpty(this.l) && TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.n)) {
            return false;
        }
        return t();
    }

    public boolean F() {
        return this.O0 && E() && b.h(this.B);
    }

    public String b(w3 w3Var) {
        if (b.g(this.P) && w3Var != null) {
            this.P = w3Var.getCachedResource(this.A, false);
        }
        return this.P;
    }

    public SpannableStringBuilder a() {
        String strD = this.h;
        if (TextUtils.isEmpty(strD)) {
            strD = s.d(new byte[]{-83, -59, -44, -119, -120, -42, -16, -18}, "cf1073");
        }
        String strReplaceAll = strD.replaceAll(PPSLabelView.Code, "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            strReplaceAll = s.d(new byte[]{-83, -102, -128, -36, -38, -45, -16, -18}, "c9eee6");
        }
        if (!strReplaceAll.endsWith(s.d(new byte[]{-43, -127, -122, -121, -88, -70}, "089b90"))) {
            return new SpannableStringBuilder(strD);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strReplaceAll);
        try {
            int iIndexOf = strReplaceAll.indexOf(s.d(new byte[]{-45, -114, -121, -128, -88, -17}, "678e9e"));
            for (int i = 0; i < strReplaceAll.length(); i++) {
                if (i < iIndexOf) {
                    spannableStringBuilder.setSpan(new b6(f9.a(y8.f5752a, 9.45f)), i, i + 1, 33);
                } else {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(f9.a(y8.f5752a, 8.73f)), i, i + 1, 33);
                }
            }
        } catch (Exception unused) {
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    public void a(ClickEventType clickEventType) {
        HashMap map;
        if (clickEventType == null) {
            return;
        }
        HashMap map2 = null;
        if (clickEventType == ClickEventType.CLICK_AUTO_DOWNLOAD) {
            String strA = NativeUtils.a(this.a0);
            if (TextUtils.isEmpty(strA)) {
                map = null;
            } else {
                String strReplaceAll = strA.replaceAll(PPSLabelView.Code, "");
                if (TextUtils.isEmpty(strReplaceAll)) {
                    map = null;
                } else {
                    String[] strArrSplit = strReplaceAll.split(s.d(new byte[]{19}, "5dada0"));
                    if (strArrSplit.length <= 0) {
                        map = null;
                    } else {
                        map = new HashMap();
                        for (String str : strArrSplit) {
                            if (!TextUtils.isEmpty(str)) {
                                String[] strArrSplit2 = str.split(s.d(new byte[]{91}, "fd9f3d"));
                                if (strArrSplit2.length == 2) {
                                    try {
                                        map.put(strArrSplit2[0], strArrSplit2[1]);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (map == null) {
                return;
            }
            String str2 = this.w;
            if (b.a(str2, a(map))) {
                this.w = b.a(str2, map);
            }
            String str3 = this.F;
            if (b.a(str3, a(map))) {
                this.F = b.a(str3, map);
            }
        }
        if (clickEventType == ClickEventType.CLICK_NO_AUTO_DOWNLOAD) {
            String strA2 = NativeUtils.a(this.b0);
            if (!TextUtils.isEmpty(strA2)) {
                String strReplaceAll2 = strA2.replaceAll(PPSLabelView.Code, "");
                if (!TextUtils.isEmpty(strReplaceAll2)) {
                    String[] strArrSplit3 = strReplaceAll2.split(s.d(new byte[]{Ascii.DC2}, "43c6c6"));
                    if (strArrSplit3.length != 0) {
                        map2 = new HashMap();
                        for (String str4 : strArrSplit3) {
                            if (!TextUtils.isEmpty(str4)) {
                                String[] strArrSplit4 = str4.split(s.d(new byte[]{92}, "a5c666"));
                                if (strArrSplit4.length == 2) {
                                    try {
                                        map2.put(strArrSplit4[0], strArrSplit4[1]);
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (map2 == null) {
                return;
            }
            String str5 = this.w;
            if (b.a(str5, a(map2))) {
                this.w = b.a(str5, map2);
            }
            String str6 = this.F;
            if (b.a(str6, a(map2))) {
                this.F = b.a(str6, map2);
            }
        }
    }

    public ClickEventType a(ClickAreaType clickAreaType) {
        ArrayList arrayList;
        if (clickAreaType != null && !TextUtils.isEmpty(NativeUtils.a(this.Y))) {
            if (!t()) {
                return !a(this.Y, clickAreaType.getTag()) ? ClickEventType.CLICK_DISABLE : ClickEventType.DEFAULT;
            }
            String strA = NativeUtils.a(this.Z);
            String strA2 = NativeUtils.a(this.a0);
            String strA3 = NativeUtils.a(this.b0);
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2) || TextUtils.isEmpty(strA3)) {
                return ClickEventType.CLICK_DISABLE;
            }
            if (!a(this.Y, clickAreaType.getTag())) {
                return ClickEventType.CLICK_DISABLE;
            }
            String tag = clickAreaType.getTag();
            String strA4 = NativeUtils.a(this.Z);
            if (TextUtils.isEmpty(strA4)) {
                arrayList = new ArrayList();
            } else {
                String strReplaceAll = strA4.replaceAll(PPSLabelView.Code, "");
                if (TextUtils.isEmpty(strReplaceAll)) {
                    arrayList = new ArrayList();
                } else {
                    String[] strArrSplit = strReplaceAll.split(s.d(new byte[]{77}, "a29f9a"));
                    if (strArrSplit.length == 0) {
                        arrayList = new ArrayList();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : strArrSplit) {
                            if (!TextUtils.isEmpty(str)) {
                                arrayList2.add(str);
                            }
                        }
                        arrayList = arrayList2;
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(tag, (String) it.next())) {
                    return ClickEventType.CLICK_NO_AUTO_DOWNLOAD;
                }
            }
            return ClickEventType.CLICK_AUTO_DOWNLOAD;
        }
        return ClickEventType.CLICK_DISABLE;
    }
}

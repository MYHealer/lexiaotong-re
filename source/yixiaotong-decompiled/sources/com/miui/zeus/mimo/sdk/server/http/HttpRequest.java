package com.miui.zeus.mimo.sdk.server.http;

import android.net.Uri;
import android.util.Pair;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.i5;
import com.miui.zeus.mimo.sdk.k5;
import com.miui.zeus.mimo.sdk.l5;
import ijiami_1011.s.s.s;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HttpRequest {
    public String b;
    public String c;
    public String d;
    public boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f5606a = Method.GET;
    public List<k5> f = new ArrayList();
    public List<k5> g = new ArrayList();

    public enum Method {
        POST,
        GET
    }

    public HttpRequest(String str, String str2, boolean z) {
        Uri uri = Uri.parse(str);
        this.d = uri.getHost();
        this.c = uri.getPath();
        this.b = str;
        this.e = z;
    }

    public static l5<HttpRequest> a(String str, String str2, boolean z) {
        try {
            return new l5<>(new HttpRequest(str, str2, z));
        } catch (Exception e) {
            return l5.a(Error.EXCEPTION, new i5(z ? DiagnosisStep.KEY_EXCEPTION_WHEN_BUILD_DOWNLOAD_HTTP_REQUEST : DiagnosisStep.KEY_EXCEPTION_WHEN_BUILD_AD_HTTP_REQUEST, s.d(new byte[]{4, 68, 89, 85, 86, 16, 9, 16, Ascii.DC2, Ascii.DC2, 99, 0, Ascii.ETB, 68, 85, 74, 70, 16, 4, Ascii.FS, 5, 7, 65, 17, 15, 94, 94, Ascii.EM, 8, 16}, "f10920"), e));
        }
    }

    public String toString() {
        try {
            Uri.Builder builderBuildUpon = Uri.parse(this.b).buildUpon();
            for (k5 k5Var : this.f) {
                if (((String) ((Pair) k5Var).second) != null) {
                    builderBuildUpon.appendQueryParameter(URLEncoder.encode((String) ((Pair) k5Var).first, s.d(new byte[]{102, 97, 116, 79, 93}, "352be5")), URLEncoder.encode((String) ((Pair) k5Var).second, s.d(new byte[]{55, 100, 32, 79, 15}, "b0fb75")));
                }
            }
            return builderBuildUpon.build().toString();
        } catch (Exception unused) {
            return this.b;
        }
    }

    public String a() {
        if (this.f5606a != Method.GET) {
            return this.b;
        }
        Uri.Builder builderBuildUpon = Uri.parse(this.b).buildUpon();
        for (k5 k5Var : this.f) {
            if (((String) ((Pair) k5Var).second) != null) {
                try {
                    builderBuildUpon.appendQueryParameter(URLEncoder.encode((String) ((Pair) k5Var).first, s.d(new byte[]{55, 98, 112, Ascii.GS, 0}, "b6608e")), URLEncoder.encode((String) ((Pair) k5Var).second, s.d(new byte[]{52, 53, 39, 78, 14}, "aaac6b")));
                } catch (Exception unused) {
                }
            }
        }
        return builderBuildUpon.build().toString();
    }
}

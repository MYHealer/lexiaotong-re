package com.adprof.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.loopj.android.http.AsyncHttpClient;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd f336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f337a = "";
    public String b = "";

    public ha(wd wdVar) {
        this.f336a = wdVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final x7 m642a() {
        String str;
        String strG;
        String strValueOf;
        String str2;
        String str3;
        String str4;
        String strValueOf2;
        int i;
        q6 q6Var = q6.f1379a;
        try {
            strValueOf = String.valueOf(Build.TIME);
            try {
                if (TextUtils.isEmpty(this.b)) {
                    try {
                        mk mkVarA = nk.a();
                        if (mkVarA != null) {
                            String str5 = mkVarA.c;
                            if (TextUtils.isEmpty(str5)) {
                                strValueOf2 = "";
                            } else {
                                try {
                                    PackageInfo packageInfo = AdprofSdk.getInstance().getContext().getPackageManager().getPackageInfo(str5, 0);
                                    i = packageInfo == null ? -1 : packageInfo.versionCode;
                                } catch (PackageManager.NameNotFoundException unused) {
                                }
                                if (i != -1) {
                                    strValueOf2 = String.valueOf(i);
                                    this.b = strValueOf2;
                                } else {
                                    strValueOf2 = "";
                                }
                            }
                        } else {
                            strValueOf2 = "";
                        }
                    } catch (Throwable unused2) {
                    }
                } else {
                    strValueOf2 = this.b;
                }
                str = strValueOf2;
                try {
                    strG = he.m644a().g();
                    try {
                        str3 = strG;
                        try {
                            str4 = "" + he.m644a().f349a;
                            str2 = str;
                        } catch (Exception e) {
                            e = e;
                            strG = str3;
                            pk.b(e.getMessage());
                            str2 = str;
                            str3 = strG;
                            str4 = null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    strG = null;
                    pk.b(e.getMessage());
                    str2 = str;
                    str3 = strG;
                    str4 = null;
                    return new x7(null, null, null, null, null, null, null, null, null, null, null, strValueOf, str2, str3, str4, null, null, null, q6Var);
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
            }
        } catch (Exception e5) {
            e = e5;
            str = null;
            strG = null;
            strValueOf = null;
        }
        return new x7(null, null, null, null, null, null, null, null, null, null, null, strValueOf, str2, str3, str4, null, null, null, q6Var);
    }

    public final String a(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            sb.append(str2);
        }
        return sb.toString();
    }

    public final String a(String str, int i) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "respondBean.code =", false, 2, (Object) null) ? str : str + ("  respondBean.code = " + i);
    }

    public final t7 a() {
        String str;
        String strD;
        String strE;
        String strA;
        Integer num;
        String str2;
        Integer numValueOf;
        Integer numValueOf2;
        String strF;
        Integer numValueOf3;
        Integer numValueOf4;
        Integer numValueOf5;
        Integer numValueOf6;
        String str3;
        String str4;
        String strM719a;
        String str5;
        String str6;
        String str7;
        String strB;
        String strValueOf;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        String str16;
        Integer num6;
        Integer num7;
        String str17;
        Integer num8;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        Integer num9;
        Integer num10;
        String str25;
        x7 x7VarM642a;
        String str26;
        String str27;
        Integer num11;
        String str28;
        String str29;
        String str30;
        Integer num12;
        Integer num13;
        String str31;
        String str32;
        String str33;
        Integer num14;
        Integer num15;
        String str34;
        String str35;
        String str36;
        String str37;
        float f;
        int i;
        String strA2;
        String str38;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        try {
            u7 u7VarM721a = v7.a().m721a();
            strD = he.d();
            try {
                strE = kd.a() ? he.e() : null;
                try {
                    strA = ig.a();
                    try {
                        num = 2;
                        try {
                            str2 = Build.VERSION.RELEASE;
                            try {
                                numValueOf = Integer.valueOf(he.c());
                                try {
                                    numValueOf2 = Integer.valueOf(h8.b());
                                    try {
                                        numValueOf3 = Integer.valueOf(h8.m641a());
                                        try {
                                            Context context = he.m644a().f350a;
                                            String str39 = g8.f312a;
                                            try {
                                                f = g8.m635a(context).densityDpi;
                                            } catch (Throwable th) {
                                                pk.b("getDensityDpi error: ", th);
                                                f = 0.0f;
                                            }
                                            numValueOf4 = Integer.valueOf((int) f);
                                            try {
                                                he.m644a().getClass();
                                                try {
                                                    i = g8.f311a.f288a;
                                                } catch (Throwable th2) {
                                                    pk.b("getActiveNetworkType error: ", th2);
                                                    i = 0;
                                                }
                                                numValueOf5 = Integer.valueOf(i);
                                                try {
                                                    numValueOf6 = Integer.valueOf(he.b());
                                                    try {
                                                        String str40 = g8.f312a;
                                                        str3 = Build.BRAND;
                                                        try {
                                                            String strReplaceAll = Build.MODEL;
                                                            str = "";
                                                            if (strReplaceAll != null) {
                                                                try {
                                                                    str4 = strReplaceAll;
                                                                    try {
                                                                        strReplaceAll = strReplaceAll.trim().replaceAll("\\s*", "");
                                                                    } catch (Exception unused) {
                                                                    }
                                                                } catch (Exception unused2) {
                                                                }
                                                                str4 = strReplaceAll;
                                                            } else {
                                                                str4 = strReplaceAll;
                                                            }
                                                            try {
                                                                strF = (v7.a(u7VarM721a.f1455a) == null || !v7.a(u7VarM721a.f1455a).canUseImei()) ? "" : he.m644a().f();
                                                                try {
                                                                    strM719a = u7VarM721a.m719a();
                                                                    try {
                                                                        try {
                                                                            String lowerCase = g1.a(u7VarM721a.m719a()).toLowerCase();
                                                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                                                            try {
                                                                                strB = u7VarM721a.b();
                                                                                try {
                                                                                    strA2 = be.a(u7VarM721a.b());
                                                                                    try {
                                                                                        String strH = he.h();
                                                                                        try {
                                                                                            str8 = strH;
                                                                                            try {
                                                                                                String lowerCase2 = g1.a(strH).toLowerCase();
                                                                                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                                                                                                str6 = lowerCase2;
                                                                                            } catch (Throwable unused3) {
                                                                                                str38 = str8;
                                                                                                str8 = str38;
                                                                                                str6 = null;
                                                                                            }
                                                                                        } catch (Throwable unused4) {
                                                                                            str8 = strH;
                                                                                        }
                                                                                    } catch (Throwable unused5) {
                                                                                        str38 = null;
                                                                                    }
                                                                                    try {
                                                                                        strValueOf = String.valueOf(SystemClock.elapsedRealtime());
                                                                                        try {
                                                                                            x7VarM642a = m642a();
                                                                                            str26 = str6;
                                                                                            str23 = strE;
                                                                                            num14 = num;
                                                                                            num12 = numValueOf;
                                                                                            num9 = numValueOf3;
                                                                                            num11 = numValueOf5;
                                                                                            str31 = str3;
                                                                                            str25 = "";
                                                                                            str22 = str25;
                                                                                            str37 = str22;
                                                                                            str36 = str37;
                                                                                            str13 = str36;
                                                                                            str34 = strValueOf;
                                                                                            str27 = strF;
                                                                                            str35 = str13;
                                                                                            str29 = strA2;
                                                                                            str33 = strD;
                                                                                            str30 = strA;
                                                                                            str24 = str2;
                                                                                            num15 = numValueOf2;
                                                                                            num13 = numValueOf4;
                                                                                            num10 = numValueOf6;
                                                                                            str28 = str4;
                                                                                            str32 = lowerCase;
                                                                                        } catch (Exception e) {
                                                                                            e = e;
                                                                                            str9 = "";
                                                                                            str10 = str9;
                                                                                            str11 = str10;
                                                                                            str12 = str11;
                                                                                            str13 = str12;
                                                                                            String str41 = strA2;
                                                                                            str7 = lowerCase;
                                                                                            str = "";
                                                                                            str5 = strM719a;
                                                                                            str14 = str4;
                                                                                            str15 = str3;
                                                                                            num2 = numValueOf6;
                                                                                            num3 = numValueOf5;
                                                                                            num4 = numValueOf4;
                                                                                            num5 = numValueOf3;
                                                                                            str16 = strF;
                                                                                            num6 = numValueOf2;
                                                                                            num7 = numValueOf;
                                                                                            str17 = str2;
                                                                                            num8 = num;
                                                                                            str18 = strA;
                                                                                            str19 = strE;
                                                                                            str20 = strD;
                                                                                            str21 = str41;
                                                                                            pk.b(e.getMessage());
                                                                                            str22 = str;
                                                                                            str23 = str19;
                                                                                            str24 = str17;
                                                                                            num9 = num5;
                                                                                            num10 = num2;
                                                                                            str25 = str9;
                                                                                            x7VarM642a = null;
                                                                                            str26 = str6;
                                                                                            str27 = str16;
                                                                                            num11 = num3;
                                                                                            str28 = str14;
                                                                                            strM719a = str5;
                                                                                            str29 = str21;
                                                                                            str30 = str18;
                                                                                            num12 = num7;
                                                                                            num13 = num4;
                                                                                            str31 = str15;
                                                                                            str32 = str7;
                                                                                            str33 = str20;
                                                                                            num14 = num8;
                                                                                            num15 = num6;
                                                                                            String str42 = str12;
                                                                                            str34 = strValueOf;
                                                                                            str35 = str42;
                                                                                            String str43 = str11;
                                                                                            str36 = str10;
                                                                                            str37 = str43;
                                                                                        }
                                                                                    } catch (Exception e2) {
                                                                                        e = e2;
                                                                                        str10 = "";
                                                                                        str11 = str10;
                                                                                        str12 = str11;
                                                                                        str13 = str12;
                                                                                        strValueOf = null;
                                                                                        str9 = null;
                                                                                    }
                                                                                } catch (Exception e3) {
                                                                                    e = e3;
                                                                                    str6 = null;
                                                                                    strA2 = null;
                                                                                    strValueOf = null;
                                                                                    str8 = null;
                                                                                    str9 = null;
                                                                                    str10 = null;
                                                                                    str11 = null;
                                                                                    str12 = null;
                                                                                    str13 = null;
                                                                                    String str44 = strA2;
                                                                                    str7 = lowerCase;
                                                                                    str = "";
                                                                                    str5 = strM719a;
                                                                                    str14 = str4;
                                                                                    str15 = str3;
                                                                                    num2 = numValueOf6;
                                                                                    num3 = numValueOf5;
                                                                                    num4 = numValueOf4;
                                                                                    num5 = numValueOf3;
                                                                                    str16 = strF;
                                                                                    num6 = numValueOf2;
                                                                                    num7 = numValueOf;
                                                                                    str17 = str2;
                                                                                    num8 = num;
                                                                                    str18 = strA;
                                                                                    str19 = strE;
                                                                                    str20 = strD;
                                                                                    str21 = str44;
                                                                                    pk.b(e.getMessage());
                                                                                    str22 = str;
                                                                                    str23 = str19;
                                                                                    str24 = str17;
                                                                                    num9 = num5;
                                                                                    num10 = num2;
                                                                                    str25 = str9;
                                                                                    x7VarM642a = null;
                                                                                    str26 = str6;
                                                                                    str27 = str16;
                                                                                    num11 = num3;
                                                                                    str28 = str14;
                                                                                    strM719a = str5;
                                                                                    str29 = str21;
                                                                                    str30 = str18;
                                                                                    num12 = num7;
                                                                                    num13 = num4;
                                                                                    str31 = str15;
                                                                                    str32 = str7;
                                                                                    str33 = str20;
                                                                                    num14 = num8;
                                                                                    num15 = num6;
                                                                                    String str45 = str12;
                                                                                    str34 = strValueOf;
                                                                                    str35 = str45;
                                                                                    String str46 = str11;
                                                                                    str36 = str10;
                                                                                    str37 = str46;
                                                                                    return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                                                }
                                                                            } catch (Exception e4) {
                                                                                e = e4;
                                                                                str6 = null;
                                                                                strA2 = null;
                                                                                strB = null;
                                                                            }
                                                                        } catch (Exception e5) {
                                                                            e = e5;
                                                                            str = "";
                                                                            str5 = strM719a;
                                                                            str6 = null;
                                                                            str7 = null;
                                                                            strB = null;
                                                                            strValueOf = null;
                                                                            str8 = null;
                                                                            str9 = null;
                                                                            str10 = null;
                                                                            str11 = null;
                                                                            str12 = null;
                                                                            str13 = null;
                                                                            str14 = str4;
                                                                            str15 = str3;
                                                                            num2 = numValueOf6;
                                                                            num3 = numValueOf5;
                                                                            num4 = numValueOf4;
                                                                            num5 = numValueOf3;
                                                                            str16 = strF;
                                                                            num6 = numValueOf2;
                                                                            num7 = numValueOf;
                                                                            str17 = str2;
                                                                            num8 = num;
                                                                            str18 = strA;
                                                                            str19 = strE;
                                                                            str20 = strD;
                                                                            str21 = null;
                                                                            pk.b(e.getMessage());
                                                                            str22 = str;
                                                                            str23 = str19;
                                                                            str24 = str17;
                                                                            num9 = num5;
                                                                            num10 = num2;
                                                                            str25 = str9;
                                                                            x7VarM642a = null;
                                                                            str26 = str6;
                                                                            str27 = str16;
                                                                            num11 = num3;
                                                                            str28 = str14;
                                                                            strM719a = str5;
                                                                            str29 = str21;
                                                                            str30 = str18;
                                                                            num12 = num7;
                                                                            num13 = num4;
                                                                            str31 = str15;
                                                                            str32 = str7;
                                                                            str33 = str20;
                                                                            num14 = num8;
                                                                            num15 = num6;
                                                                            String str47 = str12;
                                                                            str34 = strValueOf;
                                                                            str35 = str47;
                                                                            String str48 = str11;
                                                                            str36 = str10;
                                                                            str37 = str48;
                                                                            return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                                        }
                                                                    } catch (Exception e6) {
                                                                        e = e6;
                                                                    }
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    strM719a = null;
                                                                    str5 = strM719a;
                                                                    str6 = null;
                                                                    str7 = null;
                                                                    strB = null;
                                                                    strValueOf = null;
                                                                    str8 = null;
                                                                    str9 = null;
                                                                    str10 = null;
                                                                    str11 = null;
                                                                    str12 = null;
                                                                    str13 = null;
                                                                    str14 = str4;
                                                                    str15 = str3;
                                                                    num2 = numValueOf6;
                                                                    num3 = numValueOf5;
                                                                    num4 = numValueOf4;
                                                                    num5 = numValueOf3;
                                                                    str16 = strF;
                                                                    num6 = numValueOf2;
                                                                    num7 = numValueOf;
                                                                    str17 = str2;
                                                                    num8 = num;
                                                                    str18 = strA;
                                                                    str19 = strE;
                                                                    str20 = strD;
                                                                    str21 = null;
                                                                    pk.b(e.getMessage());
                                                                    str22 = str;
                                                                    str23 = str19;
                                                                    str24 = str17;
                                                                    num9 = num5;
                                                                    num10 = num2;
                                                                    str25 = str9;
                                                                    x7VarM642a = null;
                                                                    str26 = str6;
                                                                    str27 = str16;
                                                                    num11 = num3;
                                                                    str28 = str14;
                                                                    strM719a = str5;
                                                                    str29 = str21;
                                                                    str30 = str18;
                                                                    num12 = num7;
                                                                    num13 = num4;
                                                                    str31 = str15;
                                                                    str32 = str7;
                                                                    str33 = str20;
                                                                    num14 = num8;
                                                                    num15 = num6;
                                                                    String str49 = str12;
                                                                    str34 = strValueOf;
                                                                    str35 = str49;
                                                                    String str410 = str11;
                                                                    str36 = str10;
                                                                    str37 = str410;
                                                                    return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                                }
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                str = null;
                                                                strF = null;
                                                            }
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            str = null;
                                                            strF = null;
                                                            str4 = null;
                                                            strM719a = null;
                                                            str5 = strM719a;
                                                            str6 = null;
                                                            str7 = null;
                                                            strB = null;
                                                            strValueOf = null;
                                                            str8 = null;
                                                            str9 = null;
                                                            str10 = null;
                                                            str11 = null;
                                                            str12 = null;
                                                            str13 = null;
                                                            str14 = str4;
                                                            str15 = str3;
                                                            num2 = numValueOf6;
                                                            num3 = numValueOf5;
                                                            num4 = numValueOf4;
                                                            num5 = numValueOf3;
                                                            str16 = strF;
                                                            num6 = numValueOf2;
                                                            num7 = numValueOf;
                                                            str17 = str2;
                                                            num8 = num;
                                                            str18 = strA;
                                                            str19 = strE;
                                                            str20 = strD;
                                                            str21 = null;
                                                            pk.b(e.getMessage());
                                                            str22 = str;
                                                            str23 = str19;
                                                            str24 = str17;
                                                            num9 = num5;
                                                            num10 = num2;
                                                            str25 = str9;
                                                            x7VarM642a = null;
                                                            str26 = str6;
                                                            str27 = str16;
                                                            num11 = num3;
                                                            str28 = str14;
                                                            strM719a = str5;
                                                            str29 = str21;
                                                            str30 = str18;
                                                            num12 = num7;
                                                            num13 = num4;
                                                            str31 = str15;
                                                            str32 = str7;
                                                            str33 = str20;
                                                            num14 = num8;
                                                            num15 = num6;
                                                            String str411 = str12;
                                                            str34 = strValueOf;
                                                            str35 = str411;
                                                            String str412 = str11;
                                                            str36 = str10;
                                                            str37 = str412;
                                                            return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                        }
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        str = null;
                                                        strF = null;
                                                        str3 = null;
                                                        str4 = null;
                                                        strM719a = null;
                                                        str5 = strM719a;
                                                        str6 = null;
                                                        str7 = null;
                                                        strB = null;
                                                        strValueOf = null;
                                                        str8 = null;
                                                        str9 = null;
                                                        str10 = null;
                                                        str11 = null;
                                                        str12 = null;
                                                        str13 = null;
                                                        str14 = str4;
                                                        str15 = str3;
                                                        num2 = numValueOf6;
                                                        num3 = numValueOf5;
                                                        num4 = numValueOf4;
                                                        num5 = numValueOf3;
                                                        str16 = strF;
                                                        num6 = numValueOf2;
                                                        num7 = numValueOf;
                                                        str17 = str2;
                                                        num8 = num;
                                                        str18 = strA;
                                                        str19 = strE;
                                                        str20 = strD;
                                                        str21 = null;
                                                        pk.b(e.getMessage());
                                                        str22 = str;
                                                        str23 = str19;
                                                        str24 = str17;
                                                        num9 = num5;
                                                        num10 = num2;
                                                        str25 = str9;
                                                        x7VarM642a = null;
                                                        str26 = str6;
                                                        str27 = str16;
                                                        num11 = num3;
                                                        str28 = str14;
                                                        strM719a = str5;
                                                        str29 = str21;
                                                        str30 = str18;
                                                        num12 = num7;
                                                        num13 = num4;
                                                        str31 = str15;
                                                        str32 = str7;
                                                        str33 = str20;
                                                        num14 = num8;
                                                        num15 = num6;
                                                        String str413 = str12;
                                                        str34 = strValueOf;
                                                        str35 = str413;
                                                        String str414 = str11;
                                                        str36 = str10;
                                                        str37 = str414;
                                                        return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    str = null;
                                                    strF = null;
                                                    numValueOf6 = null;
                                                    str3 = null;
                                                    str4 = null;
                                                    strM719a = null;
                                                    str5 = strM719a;
                                                    str6 = null;
                                                    str7 = null;
                                                    strB = null;
                                                    strValueOf = null;
                                                    str8 = null;
                                                    str9 = null;
                                                    str10 = null;
                                                    str11 = null;
                                                    str12 = null;
                                                    str13 = null;
                                                    str14 = str4;
                                                    str15 = str3;
                                                    num2 = numValueOf6;
                                                    num3 = numValueOf5;
                                                    num4 = numValueOf4;
                                                    num5 = numValueOf3;
                                                    str16 = strF;
                                                    num6 = numValueOf2;
                                                    num7 = numValueOf;
                                                    str17 = str2;
                                                    num8 = num;
                                                    str18 = strA;
                                                    str19 = strE;
                                                    str20 = strD;
                                                    str21 = null;
                                                    pk.b(e.getMessage());
                                                    str22 = str;
                                                    str23 = str19;
                                                    str24 = str17;
                                                    num9 = num5;
                                                    num10 = num2;
                                                    str25 = str9;
                                                    x7VarM642a = null;
                                                    str26 = str6;
                                                    str27 = str16;
                                                    num11 = num3;
                                                    str28 = str14;
                                                    strM719a = str5;
                                                    str29 = str21;
                                                    str30 = str18;
                                                    num12 = num7;
                                                    num13 = num4;
                                                    str31 = str15;
                                                    str32 = str7;
                                                    str33 = str20;
                                                    num14 = num8;
                                                    num15 = num6;
                                                    String str415 = str12;
                                                    str34 = strValueOf;
                                                    str35 = str415;
                                                    String str416 = str11;
                                                    str36 = str10;
                                                    str37 = str416;
                                                    return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                str = null;
                                                strF = null;
                                                numValueOf5 = null;
                                                numValueOf6 = null;
                                                str3 = null;
                                                str4 = null;
                                                strM719a = null;
                                                str5 = strM719a;
                                                str6 = null;
                                                str7 = null;
                                                strB = null;
                                                strValueOf = null;
                                                str8 = null;
                                                str9 = null;
                                                str10 = null;
                                                str11 = null;
                                                str12 = null;
                                                str13 = null;
                                                str14 = str4;
                                                str15 = str3;
                                                num2 = numValueOf6;
                                                num3 = numValueOf5;
                                                num4 = numValueOf4;
                                                num5 = numValueOf3;
                                                str16 = strF;
                                                num6 = numValueOf2;
                                                num7 = numValueOf;
                                                str17 = str2;
                                                num8 = num;
                                                str18 = strA;
                                                str19 = strE;
                                                str20 = strD;
                                                str21 = null;
                                                pk.b(e.getMessage());
                                                str22 = str;
                                                str23 = str19;
                                                str24 = str17;
                                                num9 = num5;
                                                num10 = num2;
                                                str25 = str9;
                                                x7VarM642a = null;
                                                str26 = str6;
                                                str27 = str16;
                                                num11 = num3;
                                                str28 = str14;
                                                strM719a = str5;
                                                str29 = str21;
                                                str30 = str18;
                                                num12 = num7;
                                                num13 = num4;
                                                str31 = str15;
                                                str32 = str7;
                                                str33 = str20;
                                                num14 = num8;
                                                num15 = num6;
                                                String str417 = str12;
                                                str34 = strValueOf;
                                                str35 = str417;
                                                String str418 = str11;
                                                str36 = str10;
                                                str37 = str418;
                                                return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                            }
                                        } catch (Exception e13) {
                                            e = e13;
                                            str = null;
                                            strF = null;
                                            numValueOf4 = null;
                                            numValueOf5 = null;
                                            numValueOf6 = null;
                                            str3 = null;
                                            str4 = null;
                                            strM719a = null;
                                            str5 = strM719a;
                                            str6 = null;
                                            str7 = null;
                                            strB = null;
                                            strValueOf = null;
                                            str8 = null;
                                            str9 = null;
                                            str10 = null;
                                            str11 = null;
                                            str12 = null;
                                            str13 = null;
                                            str14 = str4;
                                            str15 = str3;
                                            num2 = numValueOf6;
                                            num3 = numValueOf5;
                                            num4 = numValueOf4;
                                            num5 = numValueOf3;
                                            str16 = strF;
                                            num6 = numValueOf2;
                                            num7 = numValueOf;
                                            str17 = str2;
                                            num8 = num;
                                            str18 = strA;
                                            str19 = strE;
                                            str20 = strD;
                                            str21 = null;
                                            pk.b(e.getMessage());
                                            str22 = str;
                                            str23 = str19;
                                            str24 = str17;
                                            num9 = num5;
                                            num10 = num2;
                                            str25 = str9;
                                            x7VarM642a = null;
                                            str26 = str6;
                                            str27 = str16;
                                            num11 = num3;
                                            str28 = str14;
                                            strM719a = str5;
                                            str29 = str21;
                                            str30 = str18;
                                            num12 = num7;
                                            num13 = num4;
                                            str31 = str15;
                                            str32 = str7;
                                            str33 = str20;
                                            num14 = num8;
                                            num15 = num6;
                                            String str419 = str12;
                                            str34 = strValueOf;
                                            str35 = str419;
                                            String str4110 = str11;
                                            str36 = str10;
                                            str37 = str4110;
                                            return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                        }
                                    } catch (Exception e14) {
                                        e = e14;
                                        str = null;
                                        strF = null;
                                        numValueOf3 = null;
                                        numValueOf4 = null;
                                        numValueOf5 = null;
                                        numValueOf6 = null;
                                        str3 = null;
                                        str4 = null;
                                        strM719a = null;
                                        str5 = strM719a;
                                        str6 = null;
                                        str7 = null;
                                        strB = null;
                                        strValueOf = null;
                                        str8 = null;
                                        str9 = null;
                                        str10 = null;
                                        str11 = null;
                                        str12 = null;
                                        str13 = null;
                                        str14 = str4;
                                        str15 = str3;
                                        num2 = numValueOf6;
                                        num3 = numValueOf5;
                                        num4 = numValueOf4;
                                        num5 = numValueOf3;
                                        str16 = strF;
                                        num6 = numValueOf2;
                                        num7 = numValueOf;
                                        str17 = str2;
                                        num8 = num;
                                        str18 = strA;
                                        str19 = strE;
                                        str20 = strD;
                                        str21 = null;
                                        pk.b(e.getMessage());
                                        str22 = str;
                                        str23 = str19;
                                        str24 = str17;
                                        num9 = num5;
                                        num10 = num2;
                                        str25 = str9;
                                        x7VarM642a = null;
                                        str26 = str6;
                                        str27 = str16;
                                        num11 = num3;
                                        str28 = str14;
                                        strM719a = str5;
                                        str29 = str21;
                                        str30 = str18;
                                        num12 = num7;
                                        num13 = num4;
                                        str31 = str15;
                                        str32 = str7;
                                        str33 = str20;
                                        num14 = num8;
                                        num15 = num6;
                                        String str4111 = str12;
                                        str34 = strValueOf;
                                        str35 = str4111;
                                        String str4112 = str11;
                                        str36 = str10;
                                        str37 = str4112;
                                        return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    str = null;
                                    numValueOf2 = null;
                                    strF = null;
                                    numValueOf3 = null;
                                    numValueOf4 = null;
                                    numValueOf5 = null;
                                    numValueOf6 = null;
                                    str3 = null;
                                    str4 = null;
                                    strM719a = null;
                                    str5 = strM719a;
                                    str6 = null;
                                    str7 = null;
                                    strB = null;
                                    strValueOf = null;
                                    str8 = null;
                                    str9 = null;
                                    str10 = null;
                                    str11 = null;
                                    str12 = null;
                                    str13 = null;
                                    str14 = str4;
                                    str15 = str3;
                                    num2 = numValueOf6;
                                    num3 = numValueOf5;
                                    num4 = numValueOf4;
                                    num5 = numValueOf3;
                                    str16 = strF;
                                    num6 = numValueOf2;
                                    num7 = numValueOf;
                                    str17 = str2;
                                    num8 = num;
                                    str18 = strA;
                                    str19 = strE;
                                    str20 = strD;
                                    str21 = null;
                                    pk.b(e.getMessage());
                                    str22 = str;
                                    str23 = str19;
                                    str24 = str17;
                                    num9 = num5;
                                    num10 = num2;
                                    str25 = str9;
                                    x7VarM642a = null;
                                    str26 = str6;
                                    str27 = str16;
                                    num11 = num3;
                                    str28 = str14;
                                    strM719a = str5;
                                    str29 = str21;
                                    str30 = str18;
                                    num12 = num7;
                                    num13 = num4;
                                    str31 = str15;
                                    str32 = str7;
                                    str33 = str20;
                                    num14 = num8;
                                    num15 = num6;
                                    String str4113 = str12;
                                    str34 = strValueOf;
                                    str35 = str4113;
                                    String str4114 = str11;
                                    str36 = str10;
                                    str37 = str4114;
                                    return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                                }
                            } catch (Exception e16) {
                                e = e16;
                                str = null;
                                numValueOf = null;
                                numValueOf2 = null;
                                strF = null;
                                numValueOf3 = null;
                                numValueOf4 = null;
                                numValueOf5 = null;
                                numValueOf6 = null;
                                str3 = null;
                                str4 = null;
                                strM719a = null;
                                str5 = strM719a;
                                str6 = null;
                                str7 = null;
                                strB = null;
                                strValueOf = null;
                                str8 = null;
                                str9 = null;
                                str10 = null;
                                str11 = null;
                                str12 = null;
                                str13 = null;
                                str14 = str4;
                                str15 = str3;
                                num2 = numValueOf6;
                                num3 = numValueOf5;
                                num4 = numValueOf4;
                                num5 = numValueOf3;
                                str16 = strF;
                                num6 = numValueOf2;
                                num7 = numValueOf;
                                str17 = str2;
                                num8 = num;
                                str18 = strA;
                                str19 = strE;
                                str20 = strD;
                                str21 = null;
                                pk.b(e.getMessage());
                                str22 = str;
                                str23 = str19;
                                str24 = str17;
                                num9 = num5;
                                num10 = num2;
                                str25 = str9;
                                x7VarM642a = null;
                                str26 = str6;
                                str27 = str16;
                                num11 = num3;
                                str28 = str14;
                                strM719a = str5;
                                str29 = str21;
                                str30 = str18;
                                num12 = num7;
                                num13 = num4;
                                str31 = str15;
                                str32 = str7;
                                str33 = str20;
                                num14 = num8;
                                num15 = num6;
                                String str4115 = str12;
                                str34 = strValueOf;
                                str35 = str4115;
                                String str4116 = str11;
                                str36 = str10;
                                str37 = str4116;
                                return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str = null;
                            str2 = null;
                            numValueOf = null;
                            numValueOf2 = null;
                            strF = null;
                            numValueOf3 = null;
                            numValueOf4 = null;
                            numValueOf5 = null;
                            numValueOf6 = null;
                            str3 = null;
                            str4 = null;
                            strM719a = null;
                            str5 = strM719a;
                            str6 = null;
                            str7 = null;
                            strB = null;
                            strValueOf = null;
                            str8 = null;
                            str9 = null;
                            str10 = null;
                            str11 = null;
                            str12 = null;
                            str13 = null;
                            str14 = str4;
                            str15 = str3;
                            num2 = numValueOf6;
                            num3 = numValueOf5;
                            num4 = numValueOf4;
                            num5 = numValueOf3;
                            str16 = strF;
                            num6 = numValueOf2;
                            num7 = numValueOf;
                            str17 = str2;
                            num8 = num;
                            str18 = strA;
                            str19 = strE;
                            str20 = strD;
                            str21 = null;
                            pk.b(e.getMessage());
                            str22 = str;
                            str23 = str19;
                            str24 = str17;
                            num9 = num5;
                            num10 = num2;
                            str25 = str9;
                            x7VarM642a = null;
                            str26 = str6;
                            str27 = str16;
                            num11 = num3;
                            str28 = str14;
                            strM719a = str5;
                            str29 = str21;
                            str30 = str18;
                            num12 = num7;
                            num13 = num4;
                            str31 = str15;
                            str32 = str7;
                            str33 = str20;
                            num14 = num8;
                            num15 = num6;
                            String str4117 = str12;
                            str34 = strValueOf;
                            str35 = str4117;
                            String str4118 = str11;
                            str36 = str10;
                            str37 = str4118;
                            return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str = null;
                        num = null;
                        str2 = null;
                        numValueOf = null;
                        numValueOf2 = null;
                        strF = null;
                        numValueOf3 = null;
                        numValueOf4 = null;
                        numValueOf5 = null;
                        numValueOf6 = null;
                        str3 = null;
                        str4 = null;
                        strM719a = null;
                        str5 = strM719a;
                        str6 = null;
                        str7 = null;
                        strB = null;
                        strValueOf = null;
                        str8 = null;
                        str9 = null;
                        str10 = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        str14 = str4;
                        str15 = str3;
                        num2 = numValueOf6;
                        num3 = numValueOf5;
                        num4 = numValueOf4;
                        num5 = numValueOf3;
                        str16 = strF;
                        num6 = numValueOf2;
                        num7 = numValueOf;
                        str17 = str2;
                        num8 = num;
                        str18 = strA;
                        str19 = strE;
                        str20 = strD;
                        str21 = null;
                        pk.b(e.getMessage());
                        str22 = str;
                        str23 = str19;
                        str24 = str17;
                        num9 = num5;
                        num10 = num2;
                        str25 = str9;
                        x7VarM642a = null;
                        str26 = str6;
                        str27 = str16;
                        num11 = num3;
                        str28 = str14;
                        strM719a = str5;
                        str29 = str21;
                        str30 = str18;
                        num12 = num7;
                        num13 = num4;
                        str31 = str15;
                        str32 = str7;
                        str33 = str20;
                        num14 = num8;
                        num15 = num6;
                        String str4119 = str12;
                        str34 = strValueOf;
                        str35 = str4119;
                        String str41110 = str11;
                        str36 = str10;
                        str37 = str41110;
                        return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                    }
                } catch (Exception e19) {
                    e = e19;
                    str = null;
                    strA = null;
                    num = null;
                    str2 = null;
                    numValueOf = null;
                    numValueOf2 = null;
                    strF = null;
                    numValueOf3 = null;
                    numValueOf4 = null;
                    numValueOf5 = null;
                    numValueOf6 = null;
                    str3 = null;
                    str4 = null;
                    strM719a = null;
                    str5 = strM719a;
                    str6 = null;
                    str7 = null;
                    strB = null;
                    strValueOf = null;
                    str8 = null;
                    str9 = null;
                    str10 = null;
                    str11 = null;
                    str12 = null;
                    str13 = null;
                    str14 = str4;
                    str15 = str3;
                    num2 = numValueOf6;
                    num3 = numValueOf5;
                    num4 = numValueOf4;
                    num5 = numValueOf3;
                    str16 = strF;
                    num6 = numValueOf2;
                    num7 = numValueOf;
                    str17 = str2;
                    num8 = num;
                    str18 = strA;
                    str19 = strE;
                    str20 = strD;
                    str21 = null;
                    pk.b(e.getMessage());
                    str22 = str;
                    str23 = str19;
                    str24 = str17;
                    num9 = num5;
                    num10 = num2;
                    str25 = str9;
                    x7VarM642a = null;
                    str26 = str6;
                    str27 = str16;
                    num11 = num3;
                    str28 = str14;
                    strM719a = str5;
                    str29 = str21;
                    str30 = str18;
                    num12 = num7;
                    num13 = num4;
                    str31 = str15;
                    str32 = str7;
                    str33 = str20;
                    num14 = num8;
                    num15 = num6;
                    String str41111 = str12;
                    str34 = strValueOf;
                    str35 = str41111;
                    String str41112 = str11;
                    str36 = str10;
                    str37 = str41112;
                    return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
                }
            } catch (Exception e20) {
                e = e20;
                str = null;
                strE = null;
                strA = null;
                num = null;
                str2 = null;
                numValueOf = null;
                numValueOf2 = null;
                strF = null;
                numValueOf3 = null;
                numValueOf4 = null;
                numValueOf5 = null;
                numValueOf6 = null;
                str3 = null;
                str4 = null;
                strM719a = null;
                str5 = strM719a;
                str6 = null;
                str7 = null;
                strB = null;
                strValueOf = null;
                str8 = null;
                str9 = null;
                str10 = null;
                str11 = null;
                str12 = null;
                str13 = null;
                str14 = str4;
                str15 = str3;
                num2 = numValueOf6;
                num3 = numValueOf5;
                num4 = numValueOf4;
                num5 = numValueOf3;
                str16 = strF;
                num6 = numValueOf2;
                num7 = numValueOf;
                str17 = str2;
                num8 = num;
                str18 = strA;
                str19 = strE;
                str20 = strD;
                str21 = null;
                pk.b(e.getMessage());
                str22 = str;
                str23 = str19;
                str24 = str17;
                num9 = num5;
                num10 = num2;
                str25 = str9;
                x7VarM642a = null;
                str26 = str6;
                str27 = str16;
                num11 = num3;
                str28 = str14;
                strM719a = str5;
                str29 = str21;
                str30 = str18;
                num12 = num7;
                num13 = num4;
                str31 = str15;
                str32 = str7;
                str33 = str20;
                num14 = num8;
                num15 = num6;
                String str41113 = str12;
                str34 = strValueOf;
                str35 = str41113;
                String str41114 = str11;
                str36 = str10;
                str37 = str41114;
                return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
            }
        } catch (Exception e21) {
            e = e21;
            str = null;
            strD = null;
        }
        return new t7(str33, str30, num14, str24, num12, num15, num9, num13, null, num11, num10, str31, str28, str27, str22, strM719a, str32, strB, str29, str13, str35, str8, str26, str37, str36, str34, str25, x7VarM642a, listA, null, null, str23, q6Var);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final List m643a() {
        ArrayList arrayList = new ArrayList();
        try {
            q6 q6Var = q6.f1379a;
            wd wdVar = this.f336a;
            String str = wdVar.f797b;
            Integer numValueOf = Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) wdVar.f795a).toString()));
            s0 s0Var = t0.f1431a;
            ((t0) t0.f728a.getValue()).getClass();
            Boolean bool = Boolean.FALSE;
            int i = this.f336a.b;
            arrayList.add(new cc(str, numValueOf, i > 0 ? Integer.valueOf(i) : null, null, null, null, bool, q6Var));
        } catch (Exception e) {
            pk.b(e.getMessage());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:107:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:109:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:112:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:115:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:119:0x032c  */
    /* JADX WARN: Code duplicated, block: B:139:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x010d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0156  */
    /* JADX WARN: Code duplicated, block: B:51:0x0159 A[Catch: all -> 0x0169, TryCatch #7 {all -> 0x0169, blocks: (B:48:0x0148, B:52:0x015e, B:54:0x0164, B:51:0x0159), top: B:137:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0164 A[Catch: all -> 0x0169, TRY_LEAVE, TryCatch #7 {all -> 0x0169, blocks: (B:48:0x0148, B:52:0x015e, B:54:0x0164, B:51:0x0159), top: B:137:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0173  */
    /* JADX WARN: Code duplicated, block: B:60:0x018d A[Catch: Exception -> 0x01d5, TRY_LEAVE, TryCatch #8 {Exception -> 0x01d5, blocks: (B:58:0x017e, B:60:0x018d), top: B:139:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x028e  */
    /* JADX WARN: Code duplicated, block: B:94:0x02b1  */
    /* JADX WARN: Multi-variable type inference failed */
    public final fa a(long j) throws JSONException {
        Integer numValueOf;
        List list;
        t7 t7VarA;
        String strM650b;
        String str;
        String strM651c;
        List list2;
        Location locationM645a;
        JSONObject jSONObject;
        String strA;
        Double dValueOf;
        Double dValueOf2;
        Object objValueOf;
        Double d;
        Double d2;
        Long l;
        Integer numValueOf2;
        String strA2;
        int i;
        int i2;
        Integer numValueOf3;
        Integer numValueOf4;
        mi miVar;
        int i3;
        int i4;
        byte[] bArrM609a;
        byte[] bytes;
        String str2;
        String strReplace;
        int i5;
        String strEncodeToString;
        byte[] bArrM630a;
        String strEncodeToString2;
        String str3 = this.f336a.f797b;
        if (str3 == null) {
            str3 = "";
        }
        this.f337a = str3;
        long j2 = 1000;
        long j3 = j / j2;
        q6 q6Var = q6.f1379a;
        List listA = kc.a();
        try {
            numValueOf = Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) AdprofSdk.getInstance().getAppId()).toString()));
        } catch (Exception e) {
            pk.b("parse appid error: " + e.getMessage());
            numValueOf = null;
        }
        try {
            List listM643a = m643a();
            kc.a(listM643a);
            list = listM643a;
        } catch (Throwable unused) {
            list = listA;
        }
        try {
            t7VarA = a();
        } catch (Throwable unused2) {
            t7VarA = null;
        }
        q6 q6Var2 = q6.f1379a;
        List listA2 = kc.a();
        List listA3 = kc.a();
        try {
            strM650b = he.m644a().m650b();
            try {
                Context context = he.m644a().f350a;
                if (context == null) {
                    str = null;
                } else {
                    if (TextUtils.isEmpty(r3.c)) {
                        try {
                            if (context.getApplicationInfo() != null) {
                                r3.c = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                            }
                        } catch (Throwable th) {
                            pk.b("getAppName error: ", th);
                        }
                    }
                    str = r3.c;
                }
                try {
                    strM651c = he.m644a().m651c();
                    try {
                        List listM648a = he.m644a().m648a();
                        kc.a(listM648a);
                        list2 = listM648a;
                    } catch (Exception e2) {
                        e = e2;
                        pk.b(e.getMessage());
                        list2 = listA2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    strM651c = null;
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
                strM651c = str;
                pk.b(e.getMessage());
                list2 = listA2;
                m3 m3Var = new m3(strM650b, str, strM651c, list2, listA3, q6Var2);
                q6 q6Var3 = q6.f1379a;
                locationM645a = he.m644a().m645a();
                jSONObject = new JSONObject();
                t7 t7Var = t7VarA;
                if (locationM645a != null) {
                    Double dValueOf3 = Double.valueOf(locationM645a.getLatitude());
                    Double dValueOf4 = Double.valueOf(locationM645a.getLongitude());
                    Long lValueOf = Long.valueOf(locationM645a.getTime() / j2);
                    jSONObject.put(com.umeng.analytics.pro.d.C, locationM645a.getLatitude());
                    jSONObject.put("lon", locationM645a.getLongitude());
                    jSONObject.put(CrashHianalyticsData.TIME, locationM645a.getTime() / j2);
                    jSONObject.put("type", 4);
                    try {
                        bArrM630a = g1.m630a(jSONObject.toString(), a("qwertyuiopasdfgh"));
                        if (bArrM630a == null) {
                            strEncodeToString2 = "";
                        } else {
                            strEncodeToString2 = Base64.encodeToString(bArrM630a, 0);
                        }
                        if (!TextUtils.isEmpty(strEncodeToString2)) {
                            sl.a("geo_cache", strEncodeToString2);
                        }
                    } catch (Throwable unused3) {
                    }
                    d = dValueOf3;
                    d2 = dValueOf4;
                    l = lValueOf;
                    numValueOf2 = 4;
                } else {
                    strA = sl.a("geo_cache");
                    if (TextUtils.isEmpty(strA)) {
                        d = null;
                        d2 = null;
                        l = 0;
                        numValueOf2 = null;
                    } else {
                        try {
                            strA2 = g1.a(strA, a("qwertyuiopasdfgh"), true);
                            if (TextUtils.isEmpty(strA2)) {
                                d = null;
                                d2 = null;
                                l = 0;
                                numValueOf2 = null;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(strA2);
                                dValueOf = Double.valueOf(Double.parseDouble(jSONObject2.optString(com.umeng.analytics.pro.d.C)));
                                try {
                                    dValueOf2 = Double.valueOf(Double.parseDouble(jSONObject2.optString("lon")));
                                    try {
                                        objValueOf = Long.valueOf(Long.parseLong(jSONObject2.optString(CrashHianalyticsData.TIME)));
                                        try {
                                            numValueOf2 = Integer.valueOf(Integer.parseInt(jSONObject2.optString("type")));
                                            d = dValueOf;
                                            d2 = dValueOf2;
                                            l = objValueOf;
                                        } catch (Exception e5) {
                                            e = e5;
                                            pk.b("getGeo from cache error: " + e.getMessage());
                                            d = dValueOf;
                                            d2 = dValueOf2;
                                            l = objValueOf;
                                            numValueOf2 = null;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        objValueOf = null;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    dValueOf2 = null;
                                    objValueOf = dValueOf2;
                                    pk.b("getGeo from cache error: " + e.getMessage());
                                    d = dValueOf;
                                    d2 = dValueOf2;
                                    l = objValueOf;
                                    numValueOf2 = null;
                                    o9 o9Var = new o9(d, d2, l, numValueOf2, q6Var3);
                                    q6 q6Var4 = q6.f1379a;
                                    numValueOf3 = Integer.valueOf(RangesKt.random(new IntRange(18, 50), Random.INSTANCE));
                                    i = 0;
                                    i2 = 1;
                                    numValueOf4 = Integer.valueOf(RangesKt.random(new IntRange(0, 1), Random.INSTANCE));
                                    i3 = i;
                                    i4 = i2;
                                    miVar = new mi(this.f337a, numValueOf, list, t7Var, m3Var, o9Var, new Cdo(numValueOf3, numValueOf4, q6Var4), AdprofSdk.getVersionName(), Long.valueOf(j3), null, null, null, null, q6Var);
                                    bArrM609a = mi.ADAPTER.m609a((Object) miVar);
                                    String lowerCase = g1.a(j3 + AdprofSdk.getInstance().getAppSecret()).toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                                    if (pk.f594a) {
                                        pk.a(" \n 广告请求参数(Protobuf)：" + miVar + "  \n");
                                    }
                                    String appSecret = AdprofSdk.getInstance().getAppSecret();
                                    if (bArrM609a.length != 0) {
                                        bytes = null;
                                    } else {
                                        bytes = null;
                                    }
                                    if (bytes != null) {
                                        pk.b(" \n  ===== body   null ====== \n");
                                    } else {
                                        pk.b(" \n  ===== body   null ====== \n");
                                    }
                                    if (bytes == null) {
                                        str2 = "";
                                    } else {
                                        if (bytes.length == 0) {
                                            i5 = i4;
                                        } else {
                                            i5 = i3;
                                        }
                                        if ((i5 ^ 1) != 0) {
                                            str2 = new String(bytes, Charsets.UTF_8);
                                        } else {
                                            str2 = "";
                                        }
                                    }
                                    strReplace = new Regex("[\r\n]").replace(StringsKt.trim((CharSequence) AdprofSdk.getInstance().getAppId()).toString() + "_2_" + str2, "");
                                    if (pk.f594a) {
                                        pk.d("sdkTokenFull = " + strReplace);
                                    }
                                    return new fa(j3, lowerCase, bytes, strReplace);
                                }
                            }
                        } catch (Exception e8) {
                            e = e8;
                            dValueOf = null;
                            dValueOf2 = null;
                        }
                    }
                }
                o9 o9Var2 = new o9(d, d2, l, numValueOf2, q6Var3);
                q6 q6Var5 = q6.f1379a;
                numValueOf3 = Integer.valueOf(RangesKt.random(new IntRange(18, 50), Random.INSTANCE));
                i = 0;
                i2 = 1;
                try {
                    numValueOf4 = Integer.valueOf(RangesKt.random(new IntRange(0, 1), Random.INSTANCE));
                } catch (Exception e9) {
                    e = e9;
                    pk.b(e.getMessage());
                    numValueOf4 = null;
                }
                i3 = i;
                i4 = i2;
                miVar = new mi(this.f337a, numValueOf, list, t7Var, m3Var, o9Var2, new Cdo(numValueOf3, numValueOf4, q6Var5), AdprofSdk.getVersionName(), Long.valueOf(j3), null, null, null, null, q6Var);
                bArrM609a = mi.ADAPTER.m609a((Object) miVar);
                String lowerCase2 = g1.a(j3 + AdprofSdk.getInstance().getAppSecret()).toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (pk.f594a) {
                    pk.a(" \n 广告请求参数(Protobuf)：" + miVar + "  \n");
                }
                String appSecret2 = AdprofSdk.getInstance().getAppSecret();
                if (bArrM609a.length != 0) {
                    bytes = null;
                } else {
                    bytes = null;
                }
                if (bytes != null) {
                    pk.b(" \n  ===== body   null ====== \n");
                } else {
                    pk.b(" \n  ===== body   null ====== \n");
                }
                if (bytes == null) {
                    str2 = "";
                } else {
                    if (bytes.length == 0) {
                        i5 = i4;
                    } else {
                        i5 = i3;
                    }
                    if ((i5 ^ 1) != 0) {
                        str2 = new String(bytes, Charsets.UTF_8);
                    } else {
                        str2 = "";
                    }
                }
                strReplace = new Regex("[\r\n]").replace(StringsKt.trim((CharSequence) AdprofSdk.getInstance().getAppId()).toString() + "_2_" + str2, "");
                if (pk.f594a) {
                    pk.d("sdkTokenFull = " + strReplace);
                }
                return new fa(j3, lowerCase2, bytes, strReplace);
            }
        } catch (Exception e10) {
            e = e10;
            strM650b = null;
            str = null;
        }
        m3 m3Var2 = new m3(strM650b, str, strM651c, list2, listA3, q6Var2);
        q6 q6Var6 = q6.f1379a;
        locationM645a = he.m644a().m645a();
        jSONObject = new JSONObject();
        t7 t7Var2 = t7VarA;
        if (locationM645a != null) {
            Double dValueOf5 = Double.valueOf(locationM645a.getLatitude());
            Double dValueOf6 = Double.valueOf(locationM645a.getLongitude());
            Long lValueOf2 = Long.valueOf(locationM645a.getTime() / j2);
            jSONObject.put(com.umeng.analytics.pro.d.C, locationM645a.getLatitude());
            jSONObject.put("lon", locationM645a.getLongitude());
            jSONObject.put(CrashHianalyticsData.TIME, locationM645a.getTime() / j2);
            jSONObject.put("type", 4);
            bArrM630a = g1.m630a(jSONObject.toString(), a("qwertyuiopasdfgh"));
            if (bArrM630a == null) {
                strEncodeToString2 = "";
            } else {
                strEncodeToString2 = Base64.encodeToString(bArrM630a, 0);
            }
            if (!TextUtils.isEmpty(strEncodeToString2)) {
                sl.a("geo_cache", strEncodeToString2);
            }
            d = dValueOf5;
            d2 = dValueOf6;
            l = lValueOf2;
            numValueOf2 = 4;
        } else {
            strA = sl.a("geo_cache");
            if (TextUtils.isEmpty(strA)) {
                strA2 = g1.a(strA, a("qwertyuiopasdfgh"), true);
                if (TextUtils.isEmpty(strA2)) {
                    JSONObject jSONObject3 = new JSONObject(strA2);
                    dValueOf = Double.valueOf(Double.parseDouble(jSONObject3.optString(com.umeng.analytics.pro.d.C)));
                    dValueOf2 = Double.valueOf(Double.parseDouble(jSONObject3.optString("lon")));
                    objValueOf = Long.valueOf(Long.parseLong(jSONObject3.optString(CrashHianalyticsData.TIME)));
                    numValueOf2 = Integer.valueOf(Integer.parseInt(jSONObject3.optString("type")));
                    d = dValueOf;
                    d2 = dValueOf2;
                    l = objValueOf;
                } else {
                    d = null;
                    d2 = null;
                    l = 0;
                    numValueOf2 = null;
                }
            } else {
                d = null;
                d2 = null;
                l = 0;
                numValueOf2 = null;
            }
        }
        o9 o9Var3 = new o9(d, d2, l, numValueOf2, q6Var6);
        q6 q6Var7 = q6.f1379a;
        try {
            numValueOf3 = Integer.valueOf(RangesKt.random(new IntRange(18, 50), Random.INSTANCE));
            try {
                i = 0;
                i2 = 1;
                numValueOf4 = Integer.valueOf(RangesKt.random(new IntRange(0, 1), Random.INSTANCE));
            } catch (Exception e11) {
                e = e11;
                i = 0;
                i2 = 1;
            }
        } catch (Exception e12) {
            e = e12;
            i = 0;
            i2 = 1;
            numValueOf3 = null;
        }
        i3 = i;
        i4 = i2;
        miVar = new mi(this.f337a, numValueOf, list, t7Var2, m3Var2, o9Var3, new Cdo(numValueOf3, numValueOf4, q6Var7), AdprofSdk.getVersionName(), Long.valueOf(j3), null, null, null, null, q6Var);
        bArrM609a = mi.ADAPTER.m609a((Object) miVar);
        String lowerCase3 = g1.a(j3 + AdprofSdk.getInstance().getAppSecret()).toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
        if (pk.f594a) {
            pk.a(" \n 广告请求参数(Protobuf)：" + miVar + "  \n");
        }
        String appSecret3 = AdprofSdk.getInstance().getAppSecret();
        if (bArrM609a.length != 0 || TextUtils.isEmpty(appSecret3)) {
            bytes = null;
        } else {
            try {
                strEncodeToString = Base64.encodeToString(g1.b(bArrM609a, appSecret3), i3);
            } catch (Exception e13) {
                pk.b(e13.getMessage());
                strEncodeToString = "";
            }
            bytes = strEncodeToString.getBytes();
        }
        if (bytes != null || bytes.length == 0) {
            pk.b(" \n  ===== body   null ====== \n");
        }
        if (bytes == null) {
            str2 = "";
        } else {
            if (bytes.length == 0) {
                i5 = i4;
            } else {
                i5 = i3;
            }
            if ((i5 ^ 1) != 0) {
                str2 = new String(bytes, Charsets.UTF_8);
            } else {
                str2 = "";
            }
        }
        strReplace = new Regex("[\r\n]").replace(StringsKt.trim((CharSequence) AdprofSdk.getInstance().getAppId()).toString() + "_2_" + str2, "");
        if (pk.f594a) {
            pk.d("sdkTokenFull = " + strReplace);
        }
        return new fa(j3, lowerCase3, bytes, strReplace);
    }

    public final void a(al alVar, p5 p5Var) {
        byte[] bArrA;
        try {
            if (alVar.a() && (bArrA = alVar.f23a) != null) {
                if (!(bArrA.length == 0)) {
                    if (alVar.f22a) {
                        String str = alVar.f20a;
                        Intrinsics.checkNotNull(str);
                        String appSecret = AdprofSdk.getInstance().getAppSecret();
                        Charset charset = g1.f1181a;
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                bArrA = g1.a(Base64.decode(str, 0), appSecret);
                            }
                        } catch (Exception e) {
                            pk.b(e.getMessage());
                        }
                        bArrA = null;
                    } else {
                        Intrinsics.checkNotNull(bArrA);
                    }
                    if (bArrA == null) {
                        int errorCode = AdError.ERROR_SERVER_DATA_EMPTY.getErrorCode();
                        wd wdVar = this.f336a;
                        p5Var.a(errorCode, "Decrypt failed or data empty", wdVar.f797b, wdVar);
                        return;
                    }
                    try {
                        si siVar = (si) si.ADAPTER.a(bArrA);
                        if (pk.f594a) {
                            try {
                                pk.a("server返回数据  " + siVar + "  \n");
                                sl.a(StringsKt.trim((CharSequence) this.f336a.f795a).toString(), siVar.toString());
                            } catch (Throwable th) {
                                pk.b(Log.getStackTraceString(th));
                            }
                        }
                        x1 x1Var = new x1(siVar);
                        int i = x1Var.f1512a;
                        if (i != 0) {
                            if (i != 4017 && i != 4018) {
                                if (i == 1010) {
                                    AdError adError = AdError.ERROR_NO_AD;
                                    int errorCode2 = adError.getErrorCode();
                                    String strA = a(adError.getMessage(), x1Var.f1512a);
                                    wd wdVar2 = this.f336a;
                                    p5Var.a(errorCode2, strA, wdVar2.f797b, wdVar2);
                                    return;
                                }
                                AdError adError2 = AdError.ERROR_RESPONSE_CODE_NOT_0;
                                int errorCode3 = adError2.getErrorCode();
                                String strA2 = a(adError2.getMessage(), x1Var.f1512a);
                                wd wdVar3 = this.f336a;
                                p5Var.a(errorCode3, strA2, wdVar3.f797b, wdVar3);
                                return;
                            }
                            AdError adError3 = AdError.ERROR_RESPONSE_PRICE_REASON;
                            int errorCode4 = adError3.getErrorCode();
                            String strA3 = a(adError3.getMessage(), x1Var.f1512a);
                            wd wdVar4 = this.f336a;
                            p5Var.a(errorCode4, strA3, wdVar4.f797b, wdVar4);
                            return;
                        }
                        List list = x1Var.f823a;
                        if (list != null && !list.isEmpty()) {
                            List<q0> list2 = x1Var.f823a;
                            if (list2 != null) {
                                for (q0 q0Var : list2) {
                                    q0Var.getClass();
                                    long j = x1Var.f822a;
                                    q0Var.f636a = j <= 0 ? -1L : (j * ((long) 1000)) + System.currentTimeMillis();
                                }
                            }
                            p5Var.a(v2.a(x1Var, this.f336a), this.f336a);
                            return;
                        }
                        AdError adError4 = AdError.ERROR_NO_AD;
                        int errorCode5 = adError4.getErrorCode();
                        String message = adError4.getMessage();
                        wd wdVar5 = this.f336a;
                        p5Var.a(errorCode5, message, wdVar5.f797b, wdVar5);
                        return;
                    } catch (Exception e2) {
                        pk.a(e2);
                        oh.b(e2);
                        AdError adError5 = AdError.ERROR_REQUEST_EXCEPTION;
                        int errorCode6 = adError5.getErrorCode();
                        String str2 = adError5.getMessage() + ": Protobuf decode exception - " + e2.getMessage();
                        wd wdVar6 = this.f336a;
                        p5Var.a(errorCode6, str2, wdVar6.f797b, wdVar6);
                        return;
                    }
                }
            }
            byte[] bArr = alVar.f23a;
            if (bArr != null && bArr.length != 0) {
                AdError adError6 = AdError.ERROR_REQUEST_UNKNOWN;
                int errorCode7 = adError6.getErrorCode();
                StringBuilder sbAppend = new StringBuilder().append(adError6.getMessage()).append("   code = ");
                int i2 = alVar.f19a;
                if (i2 == 0) {
                    Throwable th2 = alVar.f21a;
                    if (th2 instanceof UnknownHostException) {
                        i2 = 410001;
                    } else if (th2 instanceof ConnectException) {
                        i2 = 410002;
                    } else if (th2 instanceof SocketTimeoutException) {
                        i2 = 410003;
                    } else if (th2 instanceof SSLException) {
                        i2 = 410004;
                    } else if (th2 instanceof MalformedURLException) {
                        i2 = 410005;
                    } else if (th2 instanceof NoRouteToHostException) {
                        i2 = 410006;
                    } else if (th2 instanceof ProtocolException) {
                        i2 = 410007;
                    } else if (th2 instanceof HttpRetryException) {
                        i2 = 410008;
                    } else {
                        i2 = th2 instanceof SocketException ? 410009 : 410000;
                    }
                }
                String string = sbAppend.append(i2).append("  message = ").append(alVar.b).append("  data = ").append(alVar.f20a).toString();
                wd wdVar7 = this.f336a;
                p5Var.a(errorCode7, string, wdVar7.f797b, wdVar7);
                return;
            }
            AdError adError7 = AdError.ERROR_SERVER_DATA_EMPTY;
            int errorCode8 = adError7.getErrorCode();
            String message2 = adError7.getMessage();
            wd wdVar8 = this.f336a;
            p5Var.a(errorCode8, message2, wdVar8.f797b, wdVar8);
        } catch (Throwable th3) {
            pk.b(th3.getMessage());
            AdError adError8 = AdError.ERROR_REQUEST_EXCEPTION;
            int errorCode9 = adError8.getErrorCode();
            String str3 = adError8.getMessage() + Log.getStackTraceString(th3);
            wd wdVar9 = this.f336a;
            p5Var.a(errorCode9, str3, wdVar9.f797b, wdVar9);
        }
    }

    public final void a(p5 p5Var) {
        try {
            AdRequest adRequest = this.f336a.f794a;
            String s2sBidResponse = adRequest != null ? adRequest.getS2sBidResponse() : null;
            if (!TextUtils.isEmpty(s2sBidResponse)) {
                this.f337a = this.f336a.f797b;
                a(new al(200, s2sBidResponse, new byte[]{0}, null, null, true, 24), p5Var);
                return;
            }
            this.f337a = this.f336a.f797b;
            this.f1208a = System.currentTimeMillis();
            if (!bg.a()) {
                p5Var.a(AdError.ERROR_AD_NETWORK.getErrorCode(), "no network", this.f337a, this.f336a);
                return;
            }
            fa faVarA = a(this.f1208a);
            long j = faVarA.f1168a;
            String str = faVarA.f289a;
            byte[] bArr = faVarA.f290a;
            String str2 = faVarA.b;
            this.f336a.f798c = str2;
            if (pk.f594a) {
                pk.d("sdkToken = " + new Regex("[\r\n]").replace(str2, ""));
            }
            String strM734a = z1.a().m734a();
            pk.d(" ad_request_url = " + strM734a);
            yk ykVar = new yk(strM734a);
            ykVar.f882b.put("Content-Type", "application/x-protobuf");
            ykVar.f882b.put("X-ADS-TIME", String.valueOf(j));
            ykVar.f882b.put("X-ADS-KEY", str);
            ykVar.f882b.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            if (bArr == null) {
                bArr = new byte[0];
            }
            ykVar.f881a = bArr;
            ykVar.f883b = true;
            ykVar.f882b.put("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            ga gaVar = new ga(this, p5Var);
            ykVar.b = "POST";
            ykVar.a(gaVar);
        } catch (Exception e) {
            pk.b(Log.getStackTraceString(e));
            oh.b(e);
            AdError adError = AdError.ERROR_AD_REQUEST;
            p5Var.a(adError.getErrorCode(), adError.getMessage(), this.f337a, this.f336a);
        }
    }
}

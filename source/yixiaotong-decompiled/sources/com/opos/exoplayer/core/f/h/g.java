package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.x;
import com.opos.exoplayer.core.i.p;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6460a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final p b = new p();
    private final StringBuilder c = new StringBuilder();

    private static char a(p pVar, int i) {
        return (char) pVar.f6510a[i];
    }

    static String a(p pVar, StringBuilder sb) {
        a(pVar);
        if (pVar.b() == 0) {
            return null;
        }
        String strD = d(pVar, sb);
        return !"".equals(strD) ? strD : "" + ((char) pVar.g());
    }

    private void a(b bVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f6460a.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                bVar.c(matcher.group(1));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            bVar.b(str2.substring(0, iIndexOf2));
            bVar.a(str2.substring(iIndexOf2 + 1));
        } else {
            bVar.b(str2);
        }
        if (strArrSplit.length > 1) {
            bVar.a((String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length));
        }
    }

    static void a(p pVar) {
        while (true) {
            for (boolean z = true; pVar.b() > 0 && z; z = false) {
                if (!e(pVar) && !f(pVar)) {
                }
            }
            return;
        }
    }

    private static void a(p pVar, b bVar, StringBuilder sb) {
        a(pVar);
        String strD = d(pVar, sb);
        if (!"".equals(strD) && x.bQ.equals(a(pVar, sb))) {
            a(pVar);
            String strC = c(pVar, sb);
            if (strC == null || "".equals(strC)) {
                return;
            }
            int iD = pVar.d();
            String strA = a(pVar, sb);
            if (!";".equals(strA)) {
                if (!com.alipay.sdk.util.i.d.equals(strA)) {
                    return;
                } else {
                    pVar.c(iD);
                }
            }
            if ("color".equals(strD)) {
                bVar.a(com.opos.exoplayer.core.i.g.b(strC));
                return;
            }
            if ("background-color".equals(strD)) {
                bVar.b(com.opos.exoplayer.core.i.g.b(strC));
                return;
            }
            if ("text-decoration".equals(strD)) {
                if (TtmlNode.UNDERLINE.equals(strC)) {
                    bVar.a(true);
                }
            } else {
                if ("font-family".equals(strD)) {
                    bVar.d(strC);
                    return;
                }
                if ("font-weight".equals(strD)) {
                    if (TtmlNode.BOLD.equals(strC)) {
                        bVar.b(true);
                    }
                } else if ("font-style".equals(strD) && TtmlNode.ITALIC.equals(strC)) {
                    bVar.c(true);
                }
            }
        }
    }

    private static String b(p pVar, StringBuilder sb) {
        a(pVar);
        if (pVar.b() < 5 || !"::cue".equals(pVar.e(5))) {
            return null;
        }
        int iD = pVar.d();
        String strA = a(pVar, sb);
        if (strA == null) {
            return null;
        }
        if ("{".equals(strA)) {
            pVar.c(iD);
            return "";
        }
        String strD = "(".equals(strA) ? d(pVar) : null;
        String strA2 = a(pVar, sb);
        if (!")".equals(strA2) || strA2 == null) {
            return null;
        }
        return strD;
    }

    static void b(p pVar) {
        while (!TextUtils.isEmpty(pVar.z())) {
        }
    }

    private static String c(p pVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iD = pVar.d();
            String strA = a(pVar, sb);
            if (strA == null) {
                return null;
            }
            if (com.alipay.sdk.util.i.d.equals(strA) || ";".equals(strA)) {
                pVar.c(iD);
                z = true;
            } else {
                sb2.append(strA);
            }
        }
        return sb2.toString();
    }

    private static String d(p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        boolean z = false;
        while (iD < iC && !z) {
            int i = iD + 1;
            z = ((char) pVar.f6510a[iD]) == ')';
            iD = i;
        }
        return pVar.e((iD - 1) - pVar.d()).trim();
    }

    private static String d(p pVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iD = pVar.d();
        int iC = pVar.c();
        while (iD < iC && !z) {
            char c = (char) pVar.f6510a[iD];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                iD++;
                sb.append(c);
            }
        }
        pVar.d(iD - pVar.d());
        return sb.toString();
    }

    private static boolean e(p pVar) {
        char cA = a(pVar, pVar.d());
        if (cA != '\t' && cA != '\n' && cA != '\f' && cA != '\r' && cA != ' ') {
            return false;
        }
        pVar.d(1);
        return true;
    }

    private static boolean f(p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f6510a;
        if (iD + 2 > iC) {
            return false;
        }
        int i = iD + 1;
        if (bArr[iD] != 47) {
            return false;
        }
        int i2 = iD + 2;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iC) {
                pVar.d(iC - pVar.d());
                return true;
            }
            if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                i2 += 2;
                iC = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public b c(p pVar) {
        this.c.setLength(0);
        int iD = pVar.d();
        b(pVar);
        this.b.a(pVar.f6510a, pVar.d());
        this.b.c(iD);
        String strB = b(this.b, this.c);
        if (strB == null || !"{".equals(a(this.b, this.c))) {
            return null;
        }
        b bVar = new b();
        a(bVar, strB);
        String strA = null;
        boolean z = false;
        while (!z) {
            int iD2 = this.b.d();
            strA = a(this.b, this.c);
            boolean z2 = strA == null || com.alipay.sdk.util.i.d.equals(strA);
            if (!z2) {
                this.b.c(iD2);
                a(this.b, bVar, this.c);
            }
            z = z2;
        }
        if (com.alipay.sdk.util.i.d.equals(strA)) {
            return bVar;
        }
        return null;
    }
}

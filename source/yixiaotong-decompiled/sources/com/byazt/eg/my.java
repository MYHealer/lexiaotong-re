package com.byazt.eg;

import com.yfanads.android.libs.net.UrlConst;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 145})
public final class my {
    public static final char[] uj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2136a;
    public final String c;
    public final String da;
    public final String i;
    public final String n;
    public final List<String> sp;
    public final String tt;
    public final int ve;
    public final List<String> x;

    public String sp() {
        return this.tt;
    }

    public String toString() {
        return this.da;
    }

    public String ve() {
        return this.c;
    }

    public int x() {
        return this.ve;
    }

    public my(c cVar) {
        this.c = cVar.c;
        this.n = c(cVar.tt, false);
        this.f2136a = c(cVar.ve, false);
        this.tt = cVar.uj;
        this.ve = cVar.c();
        this.sp = c(cVar.f2137a, false);
        this.x = cVar.sp != null ? c(cVar.sp, true) : null;
        this.i = cVar.x != null ? c(cVar.x, false) : null;
        this.da = cVar.toString();
    }

    public URL c() {
        try {
            return new URL(this.da);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI tt() {
        String string = yp().tt().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean uj() {
        return "https".equals(this.c);
    }

    public String n() {
        if (this.n.isEmpty()) {
            return "";
        }
        int length = this.c.length() + 3;
        String str = this.da;
        return this.da.substring(length, com.byazt.kh.ve.c(str, length, str.length(), ":@"));
    }

    public String a() {
        if (this.f2136a.isEmpty()) {
            return "";
        }
        return this.da.substring(this.da.indexOf(58, this.c.length() + 3) + 1, this.da.indexOf(64));
    }

    public static int c(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    public String i() {
        int iIndexOf = this.da.indexOf(47, this.c.length() + 3);
        String str = this.da;
        return this.da.substring(iIndexOf, com.byazt.kh.ve.c(str, iIndexOf, str.length(), "?#"));
    }

    public static void c(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i));
        }
    }

    public List<String> da() {
        int iIndexOf = this.da.indexOf(47, this.c.length() + 3);
        String str = this.da;
        int iC = com.byazt.kh.ve.c(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iC) {
            int i = iIndexOf + 1;
            int iC2 = com.byazt.kh.ve.c(this.da, i, iC, IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.da.substring(i, iC2));
            iIndexOf = iC2;
        }
        return arrayList;
    }

    public String sl() {
        if (this.x == null) {
            return null;
        }
        int iIndexOf = this.da.indexOf(63) + 1;
        String str = this.da;
        return this.da.substring(iIndexOf, com.byazt.kh.ve.c(str, iIndexOf, str.length(), '#'));
    }

    public static void tt(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static List<String> tt(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.x == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        tt(sb, this.x);
        return sb.toString();
    }

    public String t() {
        if (this.i == null) {
            return null;
        }
        return this.da.substring(this.da.indexOf(35) + 1);
    }

    public String u() {
        return uj("/...").tt("").ve("").ve().toString();
    }

    public my ve(String str) {
        c cVarUj = uj(str);
        if (cVarUj != null) {
            return cVarUj.ve();
        }
        return null;
    }

    public c yp() {
        c cVar = new c();
        cVar.c = this.c;
        cVar.tt = n();
        cVar.ve = a();
        cVar.uj = this.tt;
        cVar.n = this.ve != c(this.c) ? this.ve : -1;
        cVar.f2137a.clear();
        cVar.f2137a.addAll(da());
        cVar.n(sl());
        cVar.x = t();
        return cVar;
    }

    public c uj(String str) {
        c cVar = new c();
        if (cVar.c(this, str) == c.EnumC0142c.SUCCESS) {
            return cVar;
        }
        return null;
    }

    public static my n(String str) {
        c cVar = new c();
        if (cVar.c(null, str) == c.EnumC0142c.SUCCESS) {
            return cVar.ve();
        }
        return null;
    }

    public static my c(URL url) {
        return n(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof my) && ((my) obj).da.equals(this.da);
    }

    public int hashCode() {
        return this.da.hashCode();
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 932})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f2137a;
        public String c;
        public List<String> sp;
        public String uj;
        public String x;
        public String tt = "";
        public String ve = "";
        public int n = -1;

        /* JADX INFO: renamed from: com.byazt.eg.my$c$c, reason: collision with other inner class name */
        enum EnumC0142c {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public c() {
            ArrayList arrayList = new ArrayList();
            this.f2137a = arrayList;
            arrayList.add("");
        }

        public c c(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if ("http".equalsIgnoreCase(str)) {
                this.c = "http";
            } else {
                if (!"https".equalsIgnoreCase(str)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.c = "https";
            }
            return this;
        }

        public c tt(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.tt = my.c(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public c ve(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.ve = my.c(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public c uj(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strN = n(str, 0, str.length());
            if (strN == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.uj = strN;
            return this;
        }

        public c c(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.n = i;
            return this;
        }

        public int c() {
            int i = this.n;
            return i != -1 ? i : my.c(this.c);
        }

        public c query(String str) {
            this.sp = str != null ? my.tt(my.c(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true)) : null;
            return this;
        }

        public c n(String str) {
            this.sp = str != null ? my.tt(my.c(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        public c tt() {
            int size = this.f2137a.size();
            for (int i = 0; i < size; i++) {
                this.f2137a.set(i, my.c(this.f2137a.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            List<String> list = this.sp;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.sp.get(i2);
                    if (str != null) {
                        this.sp.set(i2, my.c(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            String str2 = this.x;
            if (str2 != null) {
                this.x = my.c(str2, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public my ve() {
            if (this.c == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.uj == null) {
                throw new IllegalStateException("host == null");
            }
            return new my(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append("://");
            if (!this.tt.isEmpty() || !this.ve.isEmpty()) {
                sb.append(this.tt);
                if (!this.ve.isEmpty()) {
                    sb.append(':');
                    sb.append(this.ve);
                }
                sb.append('@');
            }
            if (this.uj.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.uj);
                sb.append(']');
            } else {
                sb.append(this.uj);
            }
            int iC = c();
            if (iC != my.c(this.c)) {
                sb.append(':');
                sb.append(iC);
            }
            my.c(sb, this.f2137a);
            if (this.sp != null) {
                sb.append('?');
                my.tt(sb, this.sp);
            }
            if (this.x != null) {
                sb.append('#');
                sb.append(this.x);
            }
            return sb.toString();
        }

        public EnumC0142c c(my myVar, String str) {
            int iC;
            int i;
            int iC2 = com.byazt.kh.ve.c(str, 0, str.length());
            int iTt = com.byazt.kh.ve.tt(str, iC2, str.length());
            if (tt(str, iC2, iTt) != -1) {
                if (str.regionMatches(true, iC2, UrlConst.HTTPS, 0, 6)) {
                    this.c = "https";
                    iC2 += 6;
                } else {
                    if (!str.regionMatches(true, iC2, UrlConst.HTTP, 0, 5)) {
                        return EnumC0142c.UNSUPPORTED_SCHEME;
                    }
                    this.c = "http";
                    iC2 += 5;
                }
            } else if (myVar != null) {
                this.c = myVar.c;
            } else {
                return EnumC0142c.MISSING_SCHEME;
            }
            int iVe = ve(str, iC2, iTt);
            char c = '?';
            char c2 = '#';
            if (iVe >= 2 || myVar == null || !myVar.c.equals(this.c)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iC2 + iVe;
                while (true) {
                    iC = com.byazt.kh.ve.c(str, i2, iTt, "@/\\?#");
                    byte bCharAt = iC != iTt ? str.charAt(iC) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iC3 = com.byazt.kh.ve.c(str, i2, iC, ':');
                            i = iC;
                            String strC = my.c(str, i2, iC3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strC = this.tt + "%40" + strC;
                            }
                            this.tt = strC;
                            if (iC3 != i) {
                                this.ve = my.c(str, iC3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iC;
                            this.ve += "%40" + my.c(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iUj = uj(str, i2, iC);
                int i3 = iUj + 1;
                if (i3 < iC) {
                    this.uj = n(str, i2, iUj);
                    int iA = a(str, i3, iC);
                    this.n = iA;
                    if (iA == -1) {
                        return EnumC0142c.INVALID_PORT;
                    }
                } else {
                    this.uj = n(str, i2, iUj);
                    this.n = my.c(this.c);
                }
                if (this.uj == null) {
                    return EnumC0142c.INVALID_HOST;
                }
                iC2 = iC;
            } else {
                this.tt = myVar.n();
                this.ve = myVar.a();
                this.uj = myVar.tt;
                this.n = myVar.ve;
                this.f2137a.clear();
                this.f2137a.addAll(myVar.da());
                if (iC2 == iTt || str.charAt(iC2) == '#') {
                    n(myVar.sl());
                }
            }
            int iC4 = com.byazt.kh.ve.c(str, iC2, iTt, "?#");
            c(str, iC2, iC4);
            if (iC4 < iTt && str.charAt(iC4) == '?') {
                int iC5 = com.byazt.kh.ve.c(str, iC4, iTt, '#');
                this.sp = my.tt(my.c(str, iC4 + 1, iC5, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                iC4 = iC5;
            }
            if (iC4 < iTt && str.charAt(iC4) == '#') {
                this.x = my.c(str, 1 + iC4, iTt, "", true, false, false, false, null);
            }
            return EnumC0142c.SUCCESS;
        }

        private void c(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f2137a.clear();
                this.f2137a.add("");
                i++;
            } else {
                List<String> list = this.f2137a;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.byazt.kh.ve.c(str, i3, i2, "/\\");
                boolean z = i < i2;
                c(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void c(String str, int i, int i2, boolean z, boolean z2) {
            String strC = my.c(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (a(strC)) {
                return;
            }
            if (sp(strC)) {
                uj();
                return;
            }
            List<String> list = this.f2137a;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f2137a;
                list2.set(list2.size() - 1, strC);
            } else {
                this.f2137a.add(strC);
            }
            if (z) {
                this.f2137a.add("");
            }
        }

        private boolean a(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private boolean sp(String str) {
            return "..".equals(str) || "%2e. ".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private void uj() {
            List<String> list = this.f2137a;
            if (list.remove(list.size() - 1).isEmpty() && !this.f2137a.isEmpty()) {
                List<String> list2 = this.f2137a;
                list2.set(list2.size() - 1, "");
            } else {
                this.f2137a.add("");
            }
        }

        private static int tt(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int ve(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int uj(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String n(String str, int i, int i2) {
            return com.byazt.kh.ve.c(my.c(str, i, i2, false));
        }

        private static int a(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(my.c(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static String c(String str, boolean z) {
        return c(str, 0, str.length(), z);
    }

    private List<String> c(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? c(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String c(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.byazt.mk.ve veVar = new com.byazt.mk.ve();
                veVar.c(str, i, i3);
                c(veVar, str, i3, i2, z);
                return veVar.z();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void c(com.byazt.mk.ve veVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iC = com.byazt.kh.ve.c(str.charAt(i + 1));
                int iC2 = com.byazt.kh.ve.c(str.charAt(i3));
                if (iC != -1 && iC2 != -1) {
                    veVar.i((iC << 4) + iC2);
                    i = i3;
                } else {
                    veVar.c(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                veVar.i(32);
            } else {
                veVar.c(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static boolean c(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.byazt.kh.ve.c(str.charAt(i + 1)) != -1 && com.byazt.kh.ve.c(str.charAt(i3)) != -1;
    }

    public static String c(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || c(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.byazt.mk.ve veVar = new com.byazt.mk.ve();
            veVar.c(str, i, iCharCount);
            c(veVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return veVar.z();
        }
        return str.substring(i, i2);
    }

    public static void c(com.byazt.mk.ve veVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.byazt.mk.ve veVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    veVar.tt(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !c(str, i, i2)))))) {
                    if (veVar2 == null) {
                        veVar2 = new com.byazt.mk.ve();
                    }
                    if (charset == null || charset.equals(com.byazt.kh.ve.n)) {
                        veVar2.c(iCodePointAt);
                    } else {
                        veVar2.c(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!veVar2.n()) {
                        byte bX = veVar2.x();
                        veVar.i(37);
                        char[] cArr = uj;
                        veVar.i((int) cArr[((bX & 255) >> 4) & 15]);
                        veVar.i((int) cArr[bX & 15]);
                    }
                } else {
                    veVar.c(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return c(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

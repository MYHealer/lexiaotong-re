package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.opos.exoplayer.core.i.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f6455a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern b = Pattern.compile("(\\S+?):(\\S+)");
    private final StringBuilder c = new StringBuilder();

    private static final class a {
        private static final String[] e = new String[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6456a;
        public final int b;
        public final String c;
        public final String[] d;

        private a(String str, int i, String str2, String[] strArr) {
            this.b = i;
            this.f6456a = str;
            this.c = str2;
            this.d = strArr;
        }

        public static a a() {
            return new a("", 0, "", new String[0]);
        }

        public static a a(String str, int i) {
            String str2;
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return null;
            }
            int iIndexOf = strTrim.indexOf(PPSLabelView.Code);
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrSplit = strTrim.split("\\.");
            return new a(strArrSplit[0], i, str2, strArrSplit.length > 1 ? (String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length) : e);
        }
    }

    private static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6457a;
        public final com.opos.exoplayer.core.f.h.b b;

        public b(int i, com.opos.exoplayer.core.f.h.b bVar) {
            this.f6457a = i;
            this.b = bVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return this.f6457a - bVar.f6457a;
        }
    }

    private static int a(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int a(String str, int i) {
        int iIndexOf = str.indexOf(62, i);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, com.opos.exoplayer.core.f.h.b bVar, int i, int i2) {
        Object absoluteSizeSpan;
        if (bVar == null) {
            return;
        }
        if (bVar.b() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.b()), i, i2, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (bVar.d()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (bVar.g()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.f()), i, i2, 33);
        }
        if (bVar.i()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.h()), i, i2, 33);
        }
        if (bVar.e() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.e()), i, i2, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i, i2, 33);
        }
        int iK = bVar.k();
        if (iK == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (iK == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (iK != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, i2, 33);
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        char c;
        str.hashCode();
        switch (str) {
            case "gt":
                c = Typography.greater;
                break;
            case "lt":
                c = Typography.less;
                break;
            case "amp":
                c = Typography.amp;
                break;
            case "nbsp":
                c = ' ';
                break;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
        spannableStringBuilder.append(c);
    }

    static void a(String str, c.a aVar) {
        Matcher matcher = b.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            try {
                if ("line".equals(strGroup)) {
                    b(strGroup2, aVar);
                } else if ("align".equals(strGroup)) {
                    aVar.a(b(strGroup2));
                } else if ("position".equals(strGroup)) {
                    c(strGroup2, aVar);
                } else if (OapsKey.KEY_SIZE.equals(strGroup)) {
                    aVar.c(f.b(strGroup2));
                } else {
                    com.opos.cmn.an.f.a.c("WebvttCueParser", "Unknown cue setting " + strGroup + x.bQ + strGroup2);
                }
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0089 A[LOOP:0: B:41:0x0087->B:42:0x0089, LOOP_END] */
    private static void a(String str, a aVar, SpannableStringBuilder spannableStringBuilder, List<com.opos.exoplayer.core.f.h.b> list, List<b> list2) {
        int size;
        Object styleSpan;
        int i = aVar.b;
        int length = spannableStringBuilder.length();
        String str2 = aVar.f6456a;
        str2.hashCode();
        switch (str2) {
            case "":
            case "c":
            case "v":
            case "lang":
                list2.clear();
                a(list, str, aVar, list2);
                size = list2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(spannableStringBuilder, list2.get(i2).b, i, length);
                }
            case "b":
                styleSpan = new StyleSpan(1);
                break;
            case "i":
                styleSpan = new StyleSpan(2);
                break;
            case "u":
                styleSpan = new UnderlineSpan();
                break;
            default:
                return;
        }
        spannableStringBuilder.setSpan(styleSpan, i, length, 33);
        list2.clear();
        a(list, str, aVar, list2);
        size = list2.size();
        while (i2 < size) {
            a(spannableStringBuilder, list2.get(i2).b, i, length);
        }
    }

    static void a(String str, String str2, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char cCharAt = str2.charAt(i);
            if (cCharAt == '&') {
                i++;
                int iIndexOf = str2.indexOf(59, i);
                int iIndexOf2 = str2.indexOf(32, i);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    a(str2.substring(i, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append(PPSLabelView.Code);
                    }
                    i = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i++;
            } else {
                int iA = i + 1;
                if (iA < str2.length()) {
                    boolean z = str2.charAt(iA) == '/';
                    iA = a(str2, iA);
                    int i2 = iA - 2;
                    boolean z2 = str2.charAt(i2) == '/';
                    int i3 = i + (z ? 2 : 1);
                    if (!z2) {
                        i2 = iA - 1;
                    }
                    String strSubstring = str2.substring(i3, i2);
                    String strD = d(strSubstring);
                    if (strD != null && c(strD)) {
                        if (z) {
                            while (!stack.isEmpty()) {
                                a aVar2 = (a) stack.pop();
                                a(str, aVar2, spannableStringBuilder, list, arrayList);
                                if (aVar2.f6456a.equals(strD)) {
                                    break;
                                }
                            }
                        } else if (!z2) {
                            stack.push(a.a(strSubstring, spannableStringBuilder.length()));
                        }
                    }
                }
                i = iA;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.a(), spannableStringBuilder, list, arrayList);
        aVar.a(spannableStringBuilder);
    }

    private static void a(List<com.opos.exoplayer.core.f.h.b> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.opos.exoplayer.core.f.h.b bVar = list.get(i);
            int iA = bVar.a(str, aVar.f6456a, aVar.d, aVar.c);
            if (iA > 0) {
                list2.add(new b(iA, bVar));
            }
        }
        Collections.sort(list2);
    }

    private static boolean a(String str, Matcher matcher, p pVar, c.a aVar, StringBuilder sb, List<com.opos.exoplayer.core.f.h.b> list) {
        try {
            aVar.a(f.a(matcher.group(1))).b(f.a(matcher.group(2)));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String strZ = pVar.z();
                if (TextUtils.isEmpty(strZ)) {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
                if (sb.length() > 0) {
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                sb.append(strZ.trim());
            }
        } catch (NumberFormatException unused) {
            com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static Layout.Alignment b(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static void b(String str, c.a aVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            aVar.b(a(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            aVar.b(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            aVar.a(f.b(str)).a(0);
            return;
        }
        int i = Integer.parseInt(str);
        if (i < 0) {
            i--;
        }
        aVar.a(i).a(1);
    }

    private static void c(String str, c.a aVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            aVar.c(a(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            aVar.c(Integer.MIN_VALUE);
        }
        aVar.b(f.b(str));
    }

    private static boolean c(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "lang":
                return true;
            default:
                return false;
        }
    }

    private static String d(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return strTrim.split("[ \\.]")[0];
    }

    public boolean a(p pVar, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        String strZ = pVar.z();
        if (strZ == null) {
            return false;
        }
        Pattern pattern = f6455a;
        Matcher matcher = pattern.matcher(strZ);
        if (matcher.matches()) {
            return a(null, matcher, pVar, aVar, this.c, list);
        }
        String strZ2 = pVar.z();
        if (strZ2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(strZ2);
        if (matcher2.matches()) {
            return a(strZ.trim(), matcher2, pVar, aVar, this.c, list);
        }
        return false;
    }
}

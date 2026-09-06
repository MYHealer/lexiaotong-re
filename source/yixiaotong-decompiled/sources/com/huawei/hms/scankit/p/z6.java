package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: VCardResultParser.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class z6 extends x5 {
    private static final Pattern g = Pattern.compile("\r?\n[ \t]");
    private static final Pattern h = Pattern.compile("=");
    private static final Pattern i = Pattern.compile(";");
    private static final Pattern j = Pattern.compile("(?<!\\\\);+");

    private static String a(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i2 < length - 2 && (cCharAt = charSequence.charAt(i2 + 1)) != '\r' && cCharAt != '\n') {
                    i2 += 2;
                    char cCharAt3 = charSequence.charAt(i2);
                    int iA = x5.a(cCharAt);
                    int iA2 = x5.a(cCharAt3);
                    if (iA >= 0 && iA2 >= 0) {
                        byteArrayOutputStream.write((iA << 4) + iA2);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            int i3 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i3, strArr2[i2]);
            String str = strArr[i2];
            if (str != null) {
                if (str.equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i2].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i2].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i3;
                }
            }
            telPhoneNumberArr[i2] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.x5
    public HmsScan b(w5 w5Var) {
        String str;
        String strA;
        String strA2 = x5.a(w5Var);
        if (!strA2.startsWith("BEGIN:VCARD") || (strA = a((CharSequence) "N", (str = strA2 + IOUtils.LINE_SEPARATOR_UNIX), true, false)) == null || strA.isEmpty() || strA.split(";").length == 0) {
            return null;
        }
        String strA3 = a((CharSequence) "FN", str, true, false);
        if (strA3 == null || strA3.isEmpty()) {
            strA3 = c(strA);
        }
        String str2 = strA3;
        List<List<String>> listB = b((CharSequence) "TEL", str, true, false);
        List<List<String>> listB2 = b((CharSequence) "EMAIL", str, true, false);
        List<List<String>> listB3 = b((CharSequence) "ADR", str, true, true);
        return new HmsScan(w5Var.k(), x5.a(w5Var.c()), str2, HmsScan.CONTACT_DETAIL_FORM, w5Var.i(), x5.a(w5Var.j()), null, new c6(new HmsScan.ContactDetail(a(strA, str2), a((CharSequence) "TITLE", str, true, false), a((CharSequence) "ORG", str, true, true), c(b(listB), a(listB)), b(b(listB2), a(listB2)), a(b(listB3), a(listB3)), a(b((CharSequence) "URL", str, true, false)), null)));
    }

    private static String c(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4 && (iIndexOf = str.indexOf(59, i3)) >= 0) {
            strArr[i2] = str.substring(i3, iIndexOf);
            i2++;
            i3 = iIndexOf + 1;
        }
        strArr[i2] = str.substring(i3);
        StringBuilder sb = new StringBuilder(100);
        a(strArr, 3, sb);
        a(strArr, 1, sb);
        a(strArr, 2, sb);
        a(strArr, 0, sb);
        a(strArr, 4, sb);
        return sb.toString().trim();
    }

    static List<List<String>> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        int i2;
        String str2;
        int iIndexOf;
        int i3;
        String strReplaceAll;
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList2 = null;
        while (i5 < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:\n(?![ |\t])]*))?:").matcher(str);
            if (i5 > 0) {
                i5--;
            }
            if (!matcher.find(i5)) {
                break;
            }
            int iEnd = matcher.end(i4);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = i.split(strGroup);
                int length2 = strArrSplit.length;
                int i6 = i4;
                i2 = i6;
                arrayList = null;
                str2 = null;
                while (i6 < length2) {
                    String str3 = strArrSplit[i6];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str3);
                    String[] strArrSplit2 = h.split(str3, 2);
                    if (strArrSplit2.length > 1) {
                        String str4 = strArrSplit2[i4];
                        String str5 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                            i2 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str2 = str5;
                        } else {
                            "VALUE".equalsIgnoreCase(str4);
                        }
                    }
                    i6++;
                    i4 = 0;
                }
            } else {
                arrayList = null;
                i2 = 0;
                str2 = null;
            }
            int i7 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i7);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i8 = iIndexOf + 1;
                    if (str.charAt(i8) == ' ' || str.charAt(i8) == '\t') {
                        i7 = iIndexOf + 2;
                    }
                }
                if (i2 == 0 || !(a(iIndexOf, 1, str) || a(iIndexOf, 2, str))) {
                    break;
                }
                i7 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i5 = length;
                i4 = 0;
            } else {
                if (iIndexOf <= iEnd) {
                    i3 = 0;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                        iIndexOf--;
                    }
                    String strSubstring = str.substring(iEnd, iIndexOf);
                    if (z) {
                        strSubstring = strSubstring.trim();
                    }
                    if (i2 != 0) {
                        strReplaceAll = a((CharSequence) strSubstring, str2);
                        if (z2) {
                            strReplaceAll = j.matcher(strReplaceAll).replaceAll(PPSLabelView.Code).trim();
                        }
                    } else {
                        if (z2) {
                            strSubstring = j.matcher(strSubstring).replaceAll(PPSLabelView.Code).trim();
                        }
                        strReplaceAll = g.matcher(strSubstring).replaceAll("");
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(strReplaceAll);
                        arrayList2.add(arrayList3);
                        i3 = 0;
                    } else {
                        i3 = 0;
                        arrayList.add(0, strReplaceAll);
                        arrayList2.add(arrayList);
                    }
                }
                i4 = i3;
                i5 = iIndexOf + 1;
            }
        }
        return arrayList2;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> listB = b(charSequence, str, z, z2);
        String str2 = "";
        if (listB != null && !listB.isEmpty()) {
            for (List<String> list : listB) {
                if (list.get(0) != null && !list.get(0).isEmpty()) {
                    str2 = list.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(x5.f);
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length > 0) {
                peopleName.familyName = strArrSplit[0];
            }
            if (strArrSplit.length > 1) {
                peopleName.givenName = strArrSplit[1];
            }
            if (strArrSplit.length > 2) {
                peopleName.middleName = strArrSplit[2];
            }
            if (strArrSplit.length > 3) {
                peopleName.namePrefix = strArrSplit[3];
            }
            if (strArrSplit.length > 4) {
                peopleName.nameSuffix = strArrSplit[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i2]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            String str = strArr[i2];
            if (str != null) {
                if (str.equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i2] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        String str = strArr[i2];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }

    private static boolean a(int i2, int i3, String str) {
        return i2 >= i3 && str.charAt(i2 - i3) == '=';
    }

    private static String[] b(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    strSubstring = list.get(i2);
                    int iIndexOf = strSubstring.indexOf(61);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if ("TYPE".equals(strSubstring.substring(0, iIndexOf))) {
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                        break;
                    }
                    i2++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(x5.f);
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i2], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            String str = strArr[i2];
            if (str != null) {
                if (str.equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i2] = emailContent;
        }
        return emailContentArr;
    }
}

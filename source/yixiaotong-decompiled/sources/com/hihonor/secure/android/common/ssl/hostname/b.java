package com.hihonor.secure.android.common.ssl.hostname;

import com.cdo.oaps.ad.OapsKey;
import com.hihonor.secure.android.common.ssl.util.g;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final Pattern X = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final String[] Y;

    static {
        String[] strArr = {OapsKey.KEY_ACTIVE_CODE, "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        Y = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] cNs = getCNs(x509Certificate);
        String[] dNSSubjectAlts = getDNSSubjectAlts(x509Certificate);
        g.b("", "cn is : " + Arrays.toString(cNs));
        g.b("", "san is : " + Arrays.toString(dNSSubjectAlts));
        verify(str, cNs, dNSSubjectAlts, z);
    }

    public static final void verify(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuffer stringBuffer = new StringBuffer();
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        Iterator it = linkedList.iterator();
        boolean zEquals = false;
        while (it.hasNext()) {
            String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
            stringBuffer.append(" <");
            stringBuffer.append(lowerCase2);
            stringBuffer.append(Typography.greater);
            if (it.hasNext()) {
                stringBuffer.append(" OR");
            }
            if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && acceptableCountryWildcard(lowerCase2) && !isIPv4Address(str)) {
                boolean zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
                if (zEndsWith && z) {
                    zEquals = countDots(lowerCase) == countDots(lowerCase2);
                } else {
                    zEquals = zEndsWith;
                }
            } else {
                zEquals = lowerCase.equals(lowerCase2);
            }
            if (zEquals) {
                break;
            }
        }
        if (!zEquals) {
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
        }
    }

    public static boolean acceptableCountryWildcard(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) == '.') {
            return Arrays.binarySearch(Y, str.substring(2, i)) < 0;
        }
        return true;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        List<String> listA = new a(x509Certificate.getSubjectX500Principal()).a(CountryCodeBean.SPECIAL_COUNTRYCODE_CN);
        if (listA.isEmpty()) {
            return null;
        }
        String[] strArr = new String[listA.size()];
        listA.toArray(strArr);
        return strArr;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        Collection<List<?>> subjectAlternativeNames;
        LinkedList linkedList = new LinkedList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            g.a("", "Error parsing certificate.", e);
            subjectAlternativeNames = null;
        }
        if (subjectAlternativeNames != null) {
            for (List<?> list : subjectAlternativeNames) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static int countDots(String str) {
        byte b = 0;
        for (byte b2 = 0; b2 < str.length(); b2 = (byte) (b2 + 1)) {
            if (str.charAt(b2) == '.') {
                b = (byte) (b + 1);
            }
        }
        return b;
    }

    private static boolean isIPv4Address(String str) {
        return X.matcher(str).matches();
    }
}

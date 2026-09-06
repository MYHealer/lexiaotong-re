package com.huawei.secure.android.common.ssl.hostname;

import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.secure.android.common.ssl.util.g;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f4550a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final String[] b;

    static {
        String[] strArr = {OapsKey.KEY_ACTIVE_CODE, "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] strArrA = a(x509Certificate);
        String[] strArrB = b(x509Certificate);
        g.a("", "cn is : " + Arrays.toString(strArrA));
        g.a("", "san is : " + Arrays.toString(strArrB));
        a(str, strArrA, strArrB, z);
    }

    public static String[] b(X509Certificate x509Certificate) {
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

    private static boolean c(String str) {
        return f4550a.matcher(str).matches();
    }

    public static final void a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
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
        if (!linkedList.isEmpty()) {
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
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && a(lowerCase2) && !c(str)) {
                    boolean zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (zEndsWith && z) {
                        zEquals = b(lowerCase) == b(lowerCase2);
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
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    public static int b(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    public static boolean a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) == '.') {
            return Arrays.binarySearch(b, str.substring(2, i)) < 0;
        }
        return true;
    }

    public static String[] a(X509Certificate x509Certificate) {
        List<String> listB = new a(x509Certificate.getSubjectX500Principal()).b(CountryCodeBean.SPECIAL_COUNTRYCODE_CN);
        if (listB.isEmpty()) {
            return null;
        }
        String[] strArr = new String[listB.size()];
        listB.toArray(strArr);
        return strArr;
    }
}

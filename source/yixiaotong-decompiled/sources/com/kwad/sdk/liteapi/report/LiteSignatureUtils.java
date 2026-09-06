package com.kwad.sdk.liteapi.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.FileUtils;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.kwad.sdk.liteapi.utils.LiteMd5Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LiteSignatureUtils {
    private static final int BUFFER_SIZE = 4096;
    private static String TAG = "LiteSignatureUtils";
    public static Signature[] currentSignatures = new Signature[0];

    public static Signature[] getSignatures(Context context) {
        Signature[] signatureArr = currentSignatures;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context, context.getPackageName(), 64);
        if (packageInfo != null) {
            currentSignatures = packageInfo.signatures;
        }
        return currentSignatures;
    }

    public static Signature[] getSignatures(Context context, String str) throws Throwable {
        Signature[] archiveSignatures = getArchiveSignatures(context, str);
        if (archiveSignatures != null) {
            return archiveSignatures;
        }
        Signature[] archiveSignatures2 = getArchiveSignatures(str, false);
        return archiveSignatures2 == null ? getArchiveSignatures(str, true) : archiveSignatures2;
    }

    private static Signature[] getArchiveSignatures(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            return null;
        }
        return packageArchiveInfo.signatures;
    }

    /* JADX WARN: Code duplicated, block: B:92:0x023e  */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x023b: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:90:0x023b */
    static Signature[] getArchiveSignatures(String str, boolean z) throws Throwable {
        AutoCloseable autoCloseable;
        JarFile jarFile;
        AutoCloseable autoCloseable2;
        Certificate[] certificateArrLoadCertificates;
        try {
            try {
                byte[] bArr = new byte[4096];
                jarFile = new JarFile(str);
                try {
                    if (!z) {
                        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                        Certificate[] certificateArr = null;
                        while (true) {
                            if (enumerationEntries.hasMoreElements()) {
                                JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                                if (jarEntryNextElement.isDirectory() || jarEntryNextElement.getName().startsWith("META-INF/")) {
                                    bArr = bArr;
                                } else {
                                    Certificate[] certificateArrLoadCertificates2 = loadCertificates(jarFile, jarEntryNextElement, bArr);
                                    LiteApiLogger.d(TAG, "File " + str + " entry " + jarEntryNextElement.getName() + ": certs=" + Arrays.toString(certificateArr) + " (" + (certificateArr != null ? certificateArr.length : 0) + ")");
                                    if (certificateArrLoadCertificates2 == null) {
                                        LiteApiLogger.w(TAG, "Package  has no certificates at entry " + jarEntryNextElement.getName() + "; ignoring!");
                                        LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                                    } else if (certificateArr == null) {
                                        certificateArr = certificateArrLoadCertificates2;
                                    } else {
                                        int length = certificateArr.length;
                                        int i = 0;
                                        while (true) {
                                            if (i < length) {
                                                Certificate certificate = certificateArr[i];
                                                byte[] bArr2 = bArr;
                                                int length2 = certificateArrLoadCertificates2.length;
                                                int i2 = length;
                                                int i3 = 0;
                                                while (true) {
                                                    if (i3 < length2) {
                                                        int i4 = length2;
                                                        Certificate certificate2 = certificateArrLoadCertificates2[i3];
                                                        if (certificate == null || !certificate.equals(certificate2)) {
                                                            i3++;
                                                            length2 = i4;
                                                        } else if (certificateArr.length == certificateArrLoadCertificates2.length) {
                                                            i++;
                                                            length = i2;
                                                            bArr = bArr2;
                                                        }
                                                    }
                                                    LiteApiLogger.w(TAG, "Package  has mismatched certificates at entry " + jarEntryNextElement.getName() + "; ignoring!");
                                                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES");
                                                }
                                            } else {
                                                bArr = bArr;
                                            }
                                        }
                                    }
                                }
                            } else {
                                certificateArrLoadCertificates = certificateArr;
                            }
                            FileUtils.closeQuietly(jarFile);
                            return null;
                        }
                    }
                    JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
                    certificateArrLoadCertificates = loadCertificates(jarFile, jarEntry, bArr);
                    if (certificateArrLoadCertificates == null) {
                        LiteApiLogger.w(TAG, "Package  has no certificates at entry " + jarEntry.getName() + "; ignoring!");
                        LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                        FileUtils.closeQuietly(jarFile);
                        return null;
                    }
                    LiteApiLogger.i(TAG, "File " + str + ": entry=" + jarEntry + " certs=" + certificateArrLoadCertificates.length);
                    for (Certificate certificate3 : certificateArrLoadCertificates) {
                        LiteApiLogger.d(TAG, "  Public key: " + Arrays.toString(certificate3.getPublicKey().getEncoded()) + PPSLabelView.Code + certificate3.getPublicKey());
                    }
                    if (certificateArrLoadCertificates == null || certificateArrLoadCertificates.length <= 0) {
                        LiteApiLogger.w(TAG, "Package  has no certificates; ignoring!");
                        LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_NO_CERTIFICATES");
                        FileUtils.closeQuietly(jarFile);
                        return null;
                    }
                    int length3 = certificateArrLoadCertificates.length;
                    Signature[] signatureArr = new Signature[certificateArrLoadCertificates.length];
                    for (int i5 = 0; i5 < length3; i5++) {
                        signatureArr[i5] = new Signature(certificateArrLoadCertificates[i5].getEncoded());
                    }
                    FileUtils.closeQuietly(jarFile);
                    return signatureArr;
                } catch (IOException e) {
                    e = e;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                } catch (RuntimeException e2) {
                    e = e2;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                } catch (CertificateEncodingException e3) {
                    e = e3;
                    LiteApiLogger.w(TAG, "Exception reading " + str);
                    LiteApiLogger.w(TAG, "INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING");
                    LiteApiLogger.w(TAG, e);
                    if (jarFile == null) {
                        return null;
                    }
                    FileUtils.closeQuietly(jarFile);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                autoCloseable = autoCloseable2;
                if (autoCloseable != null) {
                    FileUtils.closeQuietly(autoCloseable);
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            jarFile = null;
        } catch (RuntimeException e5) {
            e = e5;
            jarFile = null;
        } catch (CertificateEncodingException e6) {
            e = e6;
            jarFile = null;
        } catch (Throwable th2) {
            th = th2;
            autoCloseable = null;
            if (autoCloseable != null) {
                FileUtils.closeQuietly(autoCloseable);
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0057 */
    private static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Throwable {
        BufferedInputStream bufferedInputStream;
        AutoCloseable autoCloseable;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    } catch (RuntimeException e2) {
                        e = e2;
                        LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
                        LiteApiLogger.w(TAG, e);
                        FileUtils.closeQuietly(bufferedInputStream);
                        return null;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
                FileUtils.closeQuietly(bufferedInputStream);
                return certificates;
            } catch (Throwable th) {
                th = th;
                autoCloseable2 = autoCloseable;
                FileUtils.closeQuietly(autoCloseable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
            LiteApiLogger.w(TAG, e);
            FileUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (RuntimeException e4) {
            e = e4;
            bufferedInputStream = null;
            LiteApiLogger.w(TAG, "Exception reading " + jarEntry.getName() + " in " + jarFile.getName());
            LiteApiLogger.w(TAG, e);
            FileUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeQuietly(autoCloseable2);
            throw th;
        }
    }

    public static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, signatureArr);
        HashSet hashSet2 = new HashSet();
        Collections.addAll(hashSet2, signatureArr2);
        return hashSet.equals(hashSet2);
    }

    public static boolean isSignaturesSame(String str, Signature[] signatureArr) {
        if (TextUtils.isEmpty(str) || signatureArr == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (signature.toCharsString().toLowerCase().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String getSignMd5Str(Context context) {
        try {
            Signature[] signatures = getSignatures(context);
            if (signatures != null && signatures.length > 0) {
                return LiteMd5Util.md5ForByte(signatures[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            LiteApiLogger.w(TAG, e);
            return "";
        }
    }
}

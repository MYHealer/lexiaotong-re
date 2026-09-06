package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4427a = "ReadApkFileUtil";
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;

    public static byte[] a(ZipFile zipFile) {
        return a(zipFile, "META-INF/MANIFEST.MF");
    }

    public static void b(byte[] bArr) throws Throwable {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (bArr == null) {
            HMSLog.e(f4427a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        b = null;
        c = null;
        d = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    String strA = a(bufferedReader);
                    while (strA != null) {
                        if (strA.length() != 0) {
                            if (strA.startsWith("ApkHash:")) {
                                e = a(strA.substring(strA.indexOf(x.bQ) + 1));
                            }
                            if (strA.startsWith(KEY_SIGNATURE)) {
                                b = a(strA.substring(strA.indexOf(x.bQ) + 1));
                                strA = a(bufferedReader);
                            } else if (strA.startsWith(KEY_SIGNATURE2)) {
                                c = a(strA.substring(strA.indexOf(x.bQ) + 1));
                                strA = a(bufferedReader);
                            } else if (strA.startsWith(KEY_SIGNATURE3)) {
                                d = a(strA.substring(strA.indexOf(x.bQ) + 1));
                                strA = a(bufferedReader);
                            } else {
                                stringBuffer.append(strA);
                                stringBuffer.append(org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS);
                            }
                        }
                        strA = a(bufferedReader);
                    }
                    f = stringBuffer.toString();
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    try {
                        HMSLog.e(f4427a, "loadApkCert Exception!");
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                        IOUtils.closeQuietly((Reader) bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    IOUtils.closeQuietly((InputStream) byteArrayInputStream);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception unused3) {
            byteArrayInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
        }
        IOUtils.closeQuietly((InputStream) byteArrayInputStream);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static boolean c() {
        try {
            if (a(Base64.decode(EMUI11_PK, 0), a(f, MessageDigestAlgorithms.SHA_384), b(d), "SHA384withRSA")) {
                HMSLog.i(f4427a, "verifyMDMSignatureV3 verify successful!");
                return true;
            }
            HMSLog.i(f4427a, "verifyMDMSignatureV3 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.i(f4427a, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
        }
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e(f4427a, "HMS is not found!");
            return null;
        }
    }

    public static boolean isCertFound(String str) throws Throwable {
        boolean z = false;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    boolean z2 = zipFile2.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z2) {
                        b(a(zipFile2, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException e2) {
                        HMSLog.e(f4427a, "zipFile.close Exception!" + e2.getMessage());
                    }
                    z = z2;
                } catch (Exception e3) {
                    e = e3;
                    zipFile = zipFile2;
                    HMSLog.e(f4427a, "isCertFound Exception!" + e.getMessage());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                            HMSLog.e(f4427a, "zipFile.close Exception!" + e4.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            HMSLog.e(f4427a, "zipFile.close Exception!" + e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static boolean verifyApkHash(String str) throws Throwable {
        ?? sb = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    byte[] bArrA = a(zipFile2);
                    ArrayList<String> arrayListA = a(bArrA);
                    if (arrayListA != null) {
                        bArrA = a(arrayListA);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(bArrA);
                    String strBytesToString = bytesToString(messageDigest.digest());
                    String str2 = e;
                    if (str2 == null || !str2.equals(strBytesToString)) {
                        try {
                            zipFile2.close();
                            return false;
                        } catch (Exception e2) {
                            HMSLog.i(f4427a, "close stream Exception!" + e2.getMessage());
                            return false;
                        }
                    }
                    try {
                        zipFile2.close();
                        return true;
                    } catch (Exception e3) {
                        HMSLog.i(f4427a, "close stream Exception!" + e3.getMessage());
                        return true;
                    }
                } catch (Exception e4) {
                    e = e4;
                    zipFile = zipFile2;
                    HMSLog.i(f4427a, "verifyApkHash Exception!" + e.getMessage());
                    if (zipFile == null) {
                        return false;
                    }
                    try {
                        zipFile.close();
                        return false;
                    } catch (Exception e5) {
                        String str3 = f4427a;
                        sb = new StringBuilder("close stream Exception!");
                        HMSLog.i(str3, sb.append(e5.getMessage()).toString());
                        return false;
                    }
                    if (sb != 0) {
                        try {
                            sb.close();
                        } catch (Exception e6) {
                            HMSLog.i(f4427a, "close stream Exception!" + e6.getMessage());
                        }
                    }
                    throw th;
                } catch (Throwable th) {
                    th = th;
                    sb = zipFile2;
                    if (sb != 0) {
                        sb.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x009b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:45:0x009a */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStream] */
    public static byte[] a(ZipFile zipFile, String str) throws Throwable {
        Throwable th;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        Exception e2;
        ?? r7;
        ?? bufferedOutputStream;
        ?? entry = zipFile.getEntry(str);
        OutputStream outputStream2 = null;
        try {
            if (entry == 0) {
                return null;
            }
            try {
                zipFile = zipFile.getInputStream(entry);
                if (zipFile == 0) {
                    IOUtils.closeQuietly((InputStream) zipFile);
                    IOUtils.closeQuietly((InputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    IOUtils.closeQuietly((OutputStream) null);
                    return null;
                }
                try {
                    entry = new BufferedInputStream(zipFile);
                    try {
                        byte[] bArr = new byte[4096];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
                            try {
                                for (int i = entry.read(bArr, 0, 4096); i > 0; i = entry.read(bArr, 0, 4096)) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                }
                                bufferedOutputStream.flush();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                IOUtils.closeQuietly((InputStream) zipFile);
                                IOUtils.closeQuietly((InputStream) entry);
                                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                                IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                                return byteArray;
                            } catch (Exception e3) {
                                e2 = e3;
                                HMSLog.i(f4427a, "getManifestBytes Exception!" + e2.getMessage());
                                IOUtils.closeQuietly((InputStream) zipFile);
                                IOUtils.closeQuietly((InputStream) entry);
                                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                                IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                                return null;
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            bufferedOutputStream = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            IOUtils.closeQuietly((InputStream) zipFile);
                            IOUtils.closeQuietly((InputStream) entry);
                            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                            IOUtils.closeQuietly(outputStream2);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        byteArrayOutputStream = null;
                        zipFile = zipFile;
                        entry = entry;
                        bufferedOutputStream = byteArrayOutputStream;
                        HMSLog.i(f4427a, "getManifestBytes Exception!" + e2.getMessage());
                        IOUtils.closeQuietly((InputStream) zipFile);
                        IOUtils.closeQuietly((InputStream) entry);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    r7 = zipFile;
                    entry = 0;
                    byteArrayOutputStream = null;
                    zipFile = r7;
                    bufferedOutputStream = byteArrayOutputStream;
                    HMSLog.i(f4427a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly((InputStream) zipFile);
                    IOUtils.closeQuietly((InputStream) entry);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) bufferedOutputStream);
                    return null;
                } catch (Throwable th5) {
                    th2 = th5;
                    th = th2;
                    entry = 0;
                    byteArrayOutputStream = null;
                    IOUtils.closeQuietly((InputStream) zipFile);
                    IOUtils.closeQuietly((InputStream) entry);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream2);
                    throw th;
                }
            } catch (Exception e7) {
                e2 = e7;
                r7 = 0;
            } catch (Throwable th6) {
                th2 = th6;
                zipFile = 0;
            }
        } catch (Throwable th7) {
            th = th7;
            outputStream2 = outputStream;
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b2 & 255) >>> 4];
            cArr2[i2 + 1] = cArr[b2 & 15];
        }
        return String.valueOf(cArr2);
    }

    public static boolean checkSignature() {
        if (d != null) {
            return c();
        }
        if (c != null) {
            return b();
        }
        if (b != null) {
            return a();
        }
        return false;
    }

    public static boolean b() {
        try {
            if (a(Base64.decode(EMUI10_PK, 0), a(f, "SHA-256"), b(c), "SHA256withRSA")) {
                HMSLog.i(f4427a, "verifyMDMSignatureV2 verify successful!");
                return true;
            }
            HMSLog.i(f4427a, "verifyMDMSignatureV2 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.i(f4427a, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
        }
    }

    public static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f4427a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (IOException unused) {
            HMSLog.e(f4427a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    public static byte[] b(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i = length / 2;
        } else {
            i = (length / 2) + 1;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < length; i2 += 2) {
            int i3 = i2 + 1;
            if (i3 < length) {
                bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i3), 16));
            } else {
                bArr[i2 / 2] = (byte) (Character.digit(str.charAt(i2), 16) << 4);
            }
        }
        return bArr;
    }

    public static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = arrayList.get(i);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write(org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS, 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                HMSLog.i(f4427a, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        }
    }

    public static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String strA = a(bufferedReader);
        boolean z = false;
        while (strA != null) {
            if (strA.equals("Name: META-INF/HUAWEI.CER")) {
                String strA2 = a(bufferedReader);
                while (strA2 != null) {
                    if (strA2.startsWith("Name:")) {
                        strA = strA2;
                        break;
                    }
                    strA2 = a(bufferedReader);
                }
                z = true;
            }
            if (strA.length() != 0) {
                arrayList.add(strA);
            }
            strA = a(bufferedReader);
        }
        return z;
    }

    public static String a(BufferedReader bufferedReader) throws IOException {
        int i;
        if (bufferedReader == null || (i = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder(10);
        while (i != -1) {
            char c2 = (char) i;
            if (c2 == '\n') {
                break;
            }
            if (sb.length() < 4096) {
                sb.append(c2);
                i = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String string = sb.toString();
        return (string.isEmpty() || !string.endsWith("\r")) ? string : string.substring(0, string.length() - 1);
    }

    public static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f, "SHA-256"), b(b), "SHA256withRSA")) {
                HMSLog.i(f4427a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f4427a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.i(f4427a, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    public static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    public static String a(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }
}

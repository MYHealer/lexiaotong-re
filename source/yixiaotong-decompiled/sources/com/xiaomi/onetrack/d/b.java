package com.xiaomi.onetrack.d;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {
    private static final String b = s.d(new byte[]{36, 15, 6, 67, 14, 89, 5, 47, 3, Ascii.ESC, 98, 17, 10, 19, 7}, "eab1a0");
    private static final String c = s.d(new byte[]{32, 94, 83, Ascii.SYN, 11, 91, 5, 47, 3, Ascii.ESC, 98, 17, 14, 66, 82}, "a07dd2");
    private static final String d = s.d(new byte[]{97, 48, 118, Ascii.CAN, 118, 117, 35, 75, 54, 41, 114, 54, 2, 51, 86, 83, 87, 95, 15, 3}, "3c7736");
    private static final String e = s.d(new byte[]{103, 53, 35, 62, 46, 115, 56}, "5fbae6");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9483a = b();

    public static synchronized String a(Context context, String str) {
        Cipher cipher = Cipher.getInstance(d);
        KeyStore keyStore = KeyStore.getInstance(b);
        keyStore.load(null);
        a(context, keyStore);
        Certificate certificate = keyStore.getCertificate(e);
        if (certificate == null) {
            return null;
        }
        cipher.init(1, certificate.getPublicKey());
        return Base64.encodeToString(cipher.doFinal(str.getBytes(s.d(new byte[]{54, 101, 112, Ascii.FS, 15}, "c1617f"))), 0);
    }

    private static void a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName(s.d(new byte[]{3, 87, 0, 75, 92, 11, 5, 74, Ascii.NAK, 7, 82, 16, 16, 80, 16, SignedBytes.MAX_POWER_OF_TWO, Ascii.GS, 9, 4, Ascii.GS, Ascii.NAK, Ascii.SYN, 94, Ascii.ETB, 7, Ascii.ETB, 47, 92, 74, 37, 4, 10, 54, 3, 67, 4, 15, 92, 16, 92, 65, 49, 17, 1, 5, 70, 115, 16, 11, 85, 0, 92, 65}, "b9d93b"));
        Constructor<?> constructor = cls.getConstructor(String.class, Integer.TYPE);
        Class<?> cls2 = Class.forName(s.d(new byte[]{82, 88, 81, 19, 95, 8, 5, 74, Ascii.NAK, 7, 82, 16, 65, 95, 65, Ascii.CAN, Ascii.RS, 10, 4, Ascii.GS, Ascii.NAK, Ascii.SYN, 94, Ascii.ETB, 86, Ascii.CAN, 126, 4, 73, 49, 19, 11, Ascii.SYN, 7, 67, 17, 90, 83, 70}, "365a0a"));
        Object objNewInstance = constructor.newInstance(e, Integer.valueOf(cls2.getDeclaredField(s.d(new byte[]{102, 100, 106, 50, 123, 101, 36, 59, 34, 39, 114, 55, 111, 97, 108}, "618b46")).getInt(null) | cls2.getDeclaredField(s.d(new byte[]{54, 55, 99, 103, 118, 102, 36, 59, 35, 44, 114, 55, Utf8.REPLACEMENT_BYTE, 50, 101}, "fb1795")).getInt(null)));
        cls.getMethod(s.d(new byte[]{70, 83, Ascii.NAK, 33, 10, 80, 4, Ascii.ETB, Ascii.DC2, 17}, "56aec7"), String[].class).invoke(objNewInstance, new String[]{(String) cls2.getDeclaredField(s.d(new byte[]{115, 125, 36, 119, 49, 108, 62, 55, 46, 35, 3, 80, 1}, "74c2b8")).get(null), (String) cls2.getDeclaredField(s.d(new byte[]{113, 122, 37, 35, 102, 97, 62, 55, 46, 35, 4, 84, 7}, "53bf55")).get(null)});
        cls.getMethod(s.d(new byte[]{Ascii.ETB, 0, Ascii.DC2, 125, 91, 1, 19, Ascii.GS, Ascii.SYN, Ascii.SYN, 88, 10, 10, 53, 7, 92, 81, 11, 15, 3, Ascii.NAK}, "def85b"), String[].class).invoke(objNewInstance, new String[]{(String) cls2.getDeclaredField(s.d(new byte[]{113, 44, 33, 107, 56, 98, 53, 45, 41, 44, 110, 53, 117, 38, 38, 112, 47, 117, 62, 54, 53, 35, 110, 53, 127, 33, 49, 8}, "4bb9a2")).get(null)});
        Object objInvoke = cls.getMethod(s.d(new byte[]{84, Ascii.ETB, 93, 13, 5}, "6b4aa4"), new Class[0]).invoke(objNewInstance, new Object[0]);
        Class<?> cls3 = Class.forName(s.d(new byte[]{94, 87, 68, 3, 76, 68, 4, 7, 19, 16, 88, 17, 77, Ascii.CAN, 121, 7, Ascii.ESC, 103, 0, 13, Ascii.DC4, 37, 84, 11, 81, 68, 83, Ascii.SYN, 13, 69}, "462bb7"));
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) cls3.getMethod(s.d(new byte[]{2, 92, 68, 40, 88, 68, Ascii.NAK, 5, 8, 1, 84}, "e90a67"), String.class, String.class).invoke(null, s.d(new byte[]{106, 99, 118}, "807477"), b);
        cls3.getMethod(s.d(new byte[]{80, 90, 80, Ascii.SYN, 88, 7, 13, 13, Ascii.FS, 7}, "949b1f"), AlgorithmParameterSpec.class).invoke(keyPairGenerator, objInvoke);
        keyPairGenerator.generateKeyPair();
    }

    private static void a(Context context) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 1);
        KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias(e).setSubject(new X500Principal(s.d(new byte[]{37, 124, 8, 102, 102, 112, 62, 47, 35, 59}, "f25451"))).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(s.d(new byte[]{106, 99, 37}, "80dd65"), b);
        keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
        keyPairGenerator.generateKeyPair();
    }

    private static void a(Context context, KeyStore keyStore) {
        try {
            if (keyStore.containsAlias(e)) {
                return;
            }
            a();
        } catch (Throwable th) {
            p.b(b, s.d(new byte[]{90, 70, 83, 83, 67, 83, 42, 1, Ascii.US, 66, 84}, "946276"), th);
        }
    }

    private static String b() {
        try {
            return new String(new byte[]{104, 42, 89, 51, 49, 93, 99, 33, SignedBytes.MAX_POWER_OF_TWO, 53, 78, 115, 95, 106, 80, 115, 118, 101, 106, 33, SignedBytes.MAX_POWER_OF_TWO, 51, 91, 40, 42, 119, 40, 33, 108}, s.d(new byte[]{108, 49, 127, 79, 92}, "9e9bdf"));
        } catch (Exception e2) {
            p.b(b, e2.getMessage());
            return "";
        }
    }

    public static synchronized String b(Context context, String str) {
        Cipher cipher;
        cipher = Cipher.getInstance(d);
        KeyStore keyStore = KeyStore.getInstance(b);
        keyStore.load(null);
        a(context, keyStore);
        cipher.init(2, (PrivateKey) keyStore.getKey(e, null));
        return new String(cipher.doFinal(Base64.decode(str, 0)), s.d(new byte[]{97, 102, 112, Ascii.DC4, 94}, "4269f7"));
    }
}

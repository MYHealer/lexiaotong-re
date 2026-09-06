package cz.msebera.android.httpclient.client.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class Punycode {
    private static final Idn impl;

    static {
        Idn rfc3492Idn;
        try {
            rfc3492Idn = new JdkIdn();
        } catch (Exception unused) {
            rfc3492Idn = new Rfc3492Idn();
        }
        impl = rfc3492Idn;
    }

    public static String toUnicode(String str) {
        return impl.toUnicode(str);
    }
}

package com.kwad.sdk.api.loader;

import com.yfanads.android.libs.utils.Util;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class o {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private static byte[] transform(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(Util.ALGORITHM7);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return transform(bArr, bArr2, 2);
    }
}

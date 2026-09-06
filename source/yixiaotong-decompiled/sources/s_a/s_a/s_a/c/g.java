package s_a.s_a.s_a.c;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class g {
    public static SecretKey a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(str, null);
            SecretKey secretKey = entry != null ? ((KeyStore.SecretKeyEntry) entry).getSecretKey() : null;
            return secretKey == null ? b(str) : secretKey;
        } catch (Exception e) {
            h.a("1016", e);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        try {
            byte[] bArrDecode = Base64.decode(str2, 2);
            byte[] bArrDecode2 = Base64.decode(str3, 2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArrDecode2);
            SecretKey secretKeyA = a(str);
            if (secretKeyA == null) {
                return null;
            }
            cipher.init(2, secretKeyA, gCMParameterSpec);
            return cipher.doFinal(bArrDecode);
        } catch (Exception e) {
            h.a("1015", e);
            return null;
        } catch (InstantiationError unused) {
            Log.e("IDHelper", "1093");
            return null;
        }
    }

    public static SecretKey b(String str) {
        try {
            Log.e("IDHelper", "generateSecretKey, alias:" + str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
            return keyGenerator.generateKey();
        } catch (Exception e) {
            h.a("1017", e);
            return null;
        }
    }
}

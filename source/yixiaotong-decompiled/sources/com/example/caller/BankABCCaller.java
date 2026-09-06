package com.example.caller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.IBinder;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BankABCCaller {
    public static boolean isBankABCAvaiable(Activity activity) {
        try {
            return StubApp.getOrigApplicationContext(activity.getApplicationContext()).getPackageManager().getPackageInfo("com.android.bankabc", 1).versionCode >= 15;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void startBankABC(Activity activity, String str, String str2, String str3, String str4) {
        closeSoftKeyboard(activity);
        navigateToBankABC(activity, "{\"appID\":\"" + str + "\",\"param\":\"" + encrypt("CallbackID=" + str2 + "&Method=" + str3 + "&TokenID=" + str4 + "&TimeStamp=" + System.currentTimeMillis()) + "\"}");
    }

    private static void closeSoftKeyboard(Activity activity) {
        View currentFocus;
        IBinder applicationWindowToken;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || (currentFocus = activity.getCurrentFocus()) == null || (applicationWindowToken = currentFocus.getApplicationWindowToken()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 2);
    }

    private static void navigateToBankABC(Activity activity, String str) {
        try {
            PackageManager packageManager = activity.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo("com.android.bankabc", 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                String str2 = next.activityInfo.packageName;
                String str3 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.putExtra("to_bankabc_param", str);
                intent2.setComponent(new ComponentName(str2, str3));
                activity.startActivity(intent2);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String str) {
        byte[] bytes;
        byte[] bArrDoFinal;
        String strEncodeToString = "";
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bytes = null;
        }
        byte[] bArrDecode = Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA59D5YKIxd6oTGOQAnwpeeJGDWMJDFN6kjLmX32fLjETFaPIszuqoiKgs7YaZdvL8LtvSMhdcVca3qm6h6JZO9AP7pweo+rQgFar5ZuA/0pf3tKnGD2WJbs/XbnXrWDqUH6N3TTjjYY7BBPGrJHSfK1JaIbi2kp00VKsB5EWM2owblXBcQ/AOhiRfV6aqVLLvrm5jryLmO9GxJg3wsoxjGQ19BVhK1jg/HnqsdomKBdQlka+SE82I3tq3JEv8umZzGhxOV/YXIlUnNJzAkzLOWU96r5Bn/nQzjtqzhU1svHnPGt6XEWVAMI/9vUNERA8QUhEHcxgnospP9yllntKLyQIDAQAB", 0);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArrDecode);
        int length = bArrDecode.length - 11;
        int length2 = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length2 - i;
                if (i3 > 0) {
                    if (i3 > length) {
                        bArrDoFinal = cipher.doFinal(bytes, i, length);
                    } else {
                        bArrDoFinal = cipher.doFinal(bytes, i, i3);
                    }
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i2++;
                    i = i2 * length;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    strEncodeToString = Base64.encodeToString(byteArray, 2);
                    return strEncodeToString;
                }
            }
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return strEncodeToString;
        }
    }
}

package lxt.com.a;

import android.content.Context;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9700a = "77,68,53";
    private String e = "51,98,51,51,53,98,99";
    private String w = "99,98,98,102,56,57,51,101";
    private String y = "100,49,100,57,98,98,50,52,101,54";
    private String t = "48,100,51,99,51,50,56";
    private String s = "98,101,52,52,51,101";
    private String d = "102,52,54,99,57,55,52,98";
    private String b = "48,52,99,56,56,54,98,102";
    private String h = "55,100,100,56,50,52,49,50,100,54";

    public String d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : str.split(",")) {
            stringBuffer.append((char) Integer.parseInt(str2));
        }
        return stringBuffer.toString();
    }

    public String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(d(this.f9700a));
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public String a(Context context) {
        try {
            return c(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean q(Context context) {
        return new StringBuilder().append(d(this.w)).append(d(this.e)).append(d(this.t)).append(d(this.y)).toString().equals(a(context)) || new StringBuilder().append(d(this.s)).append(d(this.d)).append(d(this.b)).append(d(this.h)).toString().equals(a(context));
    }
}

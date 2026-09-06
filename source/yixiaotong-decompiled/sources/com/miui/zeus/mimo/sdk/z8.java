package com.miui.zeus.mimo.sdk;

import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z8 {
    public static String a(String str) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ijiami_1011.s.s.s.d(new byte[]{123, 33, 2}, "6e7165"));
            messageDigest.update(bytes);
            str2 = String.format(ijiami_1011.s.s.s.d(new byte[]{70, 84, 17, 5, 5, 87, 57}, "ce556e"), new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
        }
        return str2.toLowerCase();
    }
}

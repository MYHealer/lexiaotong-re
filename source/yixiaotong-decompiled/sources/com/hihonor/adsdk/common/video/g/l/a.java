package com.hihonor.adsdk.common.video.g.l;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.hihonor.adsdk.common.video.g.d;
import com.hihonor.adsdk.common.video.g.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static final String hnadsa = "ProxyCacheUtils";
    public static final int hnadsb = 8192;
    public static final int hnadsc = 16;

    public static void hnadsa(byte[] bArr, long j, int i) throws f {
        if (j < 0) {
            throw new f(d.hnadsd, "Data offset must be positive!");
        }
        if (i < 0 || i > bArr.length) {
            throw new f(d.hnadsd, "Length must be in range [0..buffer.length]");
        }
    }

    public static String hnadsb(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "decode, UnsupportedEncodingException: " + e.getMessage(), new Object[0]);
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String hnadsc(String str) {
        try {
            return URLEncoder.encode(c.hnadsa + str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "encode, UnsupportedEncodingException: " + e.getMessage(), new Object[0]);
            throw new RuntimeException("Error encoding url", e);
        }
    }

    public static String hnadsd(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String hnadsa(byte[] bArr, int i) {
        int iMin = Math.min(16, Math.max(i, 0));
        String string = Arrays.toString(Arrays.copyOfRange(bArr, 0, iMin));
        return iMin < i ? string.substring(0, string.length() - 1) + ", ...]" : string;
    }

    public static void hnadsa(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Error closing resource", e);
            }
        }
    }

    public static String hnadsa(String str) {
        try {
            return hnadsa(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "compute Message-Digest Algorithm, NoSuchAlgorithmException: " + e.getMessage(), new Object[0]);
            throw new IllegalStateException(e);
        }
    }

    private static String hnadsa(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }
}

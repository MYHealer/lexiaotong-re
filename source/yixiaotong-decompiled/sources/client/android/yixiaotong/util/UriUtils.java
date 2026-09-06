package client.android.yixiaotong.util;

import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UriUtils {
    public static Uri parseUri(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }
}

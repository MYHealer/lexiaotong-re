package org.videolan.libvlc.util;

import android.net.Uri;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AndroidUtil {
    public static final boolean isOOrLater = true;
    public static final boolean isNougatOrLater = true;
    public static final boolean isMarshMallowOrLater = true;
    public static final boolean isLolliPopOrLater = true;
    public static final boolean isKitKatOrLater = true;
    public static final boolean isJellyBeanMR2OrLater = true;
    public static final boolean isJellyBeanMR1OrLater = true;
    public static final boolean isJellyBeanOrLater = true;

    public static Uri FileToUri(File file) {
        return Uri.fromFile(file);
    }

    public static Uri LocationToUri(String str) {
        Uri uri = Uri.parse(str);
        if (uri.getScheme() != null) {
            return uri;
        }
        throw new IllegalArgumentException(s.d(new byte[]{95, 9, 87, 86, 77, 12, 14, 10, 70, 10, 80, Ascii.SYN, 19, 8, 91, Ascii.ETB, 74, 6, 9, 1, 11, 7}, "3f479e"));
    }

    public static Uri PathToUri(String str) {
        return Uri.fromFile(new File(str));
    }

    public static File UriToFile(Uri uri) {
        return new File(uri.getPath().replaceFirst(s.d(new byte[]{5, 91, 8, 87, 11, 75, 78}, "c2d21d"), ""));
    }
}

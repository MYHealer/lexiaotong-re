package cz.msebera.android.httpclient.cookie;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CookiePathComparator implements Serializable, Comparator<Cookie> {
    private static final long serialVersionUID = 7523645369616405818L;

    private String normalizePath(Cookie cookie) {
        String path = cookie.getPath();
        if (path == null) {
            path = "/";
        }
        return !path.endsWith("/") ? path + IOUtils.DIR_SEPARATOR_UNIX : path;
    }

    @Override // java.util.Comparator
    public int compare(Cookie cookie, Cookie cookie2) {
        String strNormalizePath = normalizePath(cookie);
        String strNormalizePath2 = normalizePath(cookie2);
        if (strNormalizePath.equals(strNormalizePath2)) {
            return 0;
        }
        if (strNormalizePath.startsWith(strNormalizePath2)) {
            return -1;
        }
        return strNormalizePath2.startsWith(strNormalizePath) ? 1 : 0;
    }
}

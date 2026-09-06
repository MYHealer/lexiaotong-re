package client.android.yixiaotong.util.http;

import client.android.yixiaotong.exception.HttpException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HttpExceptionFilter {
    public static final int NO_PERMISSION = 100;
    private static Map<Integer, HttpException> sMaps;

    private HttpExceptionFilter() {
    }

    static {
        HashMap map = new HashMap();
        sMaps = map;
        map.put(100, new HttpException(100, "无权限"));
    }

    public static HttpException getDefaultHttpException() {
        return new HttpException(0, "您的网络不给力,请检查网络");
    }
}

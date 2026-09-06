package client.android.yixiaotong.util;

import android.graphics.RectF;
import android.view.View;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LocationUtils {
    public static RectF getViewLocation(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        RectF rectF = new RectF();
        rectF.left = iArr[0];
        rectF.top = iArr[1];
        rectF.right = rectF.left + view.getWidth();
        rectF.bottom = rectF.top + view.getHeight();
        LogUtil.e("LocationUtils", rectF.left + "  " + rectF.top + "  " + rectF.right + "  " + rectF.bottom);
        return rectF;
    }

    public static void expandRectF(RectF rectF, int i) {
        float f = i;
        rectF.left -= f;
        rectF.top -= f;
        rectF.right += f;
        rectF.bottom += f;
    }
}

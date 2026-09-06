package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class l1 {
    public static int c;
    public static int tt;

    public static String c(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            c = point.x;
            tt = point.y;
        } catch (Throwable unused) {
        }
        return c + "*" + tt;
    }
}

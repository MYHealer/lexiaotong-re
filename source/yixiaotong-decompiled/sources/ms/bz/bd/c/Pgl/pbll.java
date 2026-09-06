package ms.bz.bd.c.Pgl;

import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pbll implements DisplayManager.DisplayListener {
    private DisplayManager c;

    public pbll(DisplayManager displayManager) {
        this.c = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        try {
            Display[] displays = this.c.getDisplays();
            int length = displays.length;
            if (length > 0) {
                q1 q1VarC = q1.c();
                q1VarC.getClass();
                String strC = q1.c(displays);
                String strTt = q1.tt(displays);
                q1VarC.c(length);
                if (!TextUtils.isEmpty(strC)) {
                    q1VarC.c(strC);
                }
                if (!TextUtils.isEmpty(strTt)) {
                    q1VarC.tt(strTt);
                }
                q1VarC.c(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        try {
            Display[] displays = this.c.getDisplays();
            int length = displays.length;
            if (length > 0) {
                q1 q1VarC = q1.c();
                q1VarC.getClass();
                String strC = q1.c(displays);
                String strTt = q1.tt(displays);
                q1VarC.c(length);
                if (!TextUtils.isEmpty(strC)) {
                    q1VarC.c(strC);
                }
                if (!TextUtils.isEmpty(strTt)) {
                    q1VarC.tt(strTt);
                }
                q1VarC.tt(System.currentTimeMillis() / 1000);
            }
        } catch (Exception unused) {
        }
    }
}

package client.android.yixiaotong.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterDialog extends Dialog {
    private static int default_height = 120;
    private static int default_width = 160;
    private boolean noBackPressed;

    public void setBackPressed(boolean z) {
        this.noBackPressed = z;
    }

    public DrinkWaterDialog(Context context, View view, int i) {
        this(context, default_width, default_height, view, i);
    }

    public DrinkWaterDialog(Context context, int i, int i2, View view, int i3) {
        super(context, i3);
        this.noBackPressed = false;
        setContentView(view);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        attributes.width = (int) (((double) i4) * 0.8d);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.noBackPressed) {
            return;
        }
        super.onBackPressed();
    }
}

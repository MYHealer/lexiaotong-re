package client.android.yixiaotong.ui.hamam;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SFPopupWindow extends PopupWindow {
    public SFPopupWindow(Context context) {
        super(context, (AttributeSet) null);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        setHeight(view.getResources().getDisplayMetrics().heightPixels - rect.bottom);
        super.showAsDropDown(view);
    }
}

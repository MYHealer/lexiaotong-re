package com.baidu.passbqt.utils;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class CommonViewUtility implements NoProguard {
    public static void a(View view, final float f) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.passbqt.utils.CommonViewUtility.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view2.setAlpha(f);
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                view2.setAlpha(1.0f);
                return false;
            }
        });
    }
}

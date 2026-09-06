package com.yfanads.android.custom.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CenterImageView extends AppCompatImageView {
    public CenterImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            try {
                int width = getWidth();
                int height = getHeight();
                int intrinsicWidth = getDrawable().getIntrinsicWidth();
                int intrinsicHeight = getDrawable().getIntrinsicHeight();
                int i = width / 2;
                int i2 = height / 2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Rect rect = new Rect(i - (intrinsicWidth / 2), i2 - (intrinsicHeight / 2), i + (intrinsicWidth / 2), i2 + (intrinsicHeight / 2));
                YFLog.info("wh" + intrinsicWidth + " -" + intrinsicHeight + "|" + rect + "|t" + x + x.A + y);
                if (!rect.contains(x, y)) {
                    return true;
                }
                YFLog.info("contains");
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public CenterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

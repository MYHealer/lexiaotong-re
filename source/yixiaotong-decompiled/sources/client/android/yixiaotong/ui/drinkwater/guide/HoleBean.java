package client.android.yixiaotong.ui.drinkwater.guide;

import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HoleBean {
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_OVAL = 2;
    public static final int TYPE_RECTANGLE = 1;
    private View mHole;
    private int mType;

    public int getType() {
        return this.mType;
    }

    public HoleBean(View view, int i) {
        this.mHole = view;
        this.mType = i;
    }

    public int getRadius() {
        View view = this.mHole;
        if (view != null) {
            return Math.min(view.getWidth(), this.mHole.getHeight()) / 2;
        }
        return 0;
    }

    public RectF getRectF() {
        RectF rectF = new RectF();
        View view = this.mHole;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rectF.left = iArr[0];
            rectF.top = iArr[1];
            rectF.right = iArr[0] + this.mHole.getWidth();
            rectF.bottom = iArr[1] + this.mHole.getHeight();
        }
        return rectF;
    }
}

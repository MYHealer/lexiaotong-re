package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class EndImageView extends ImageICP {
    public EndImageView(Context context) {
        super(context);
    }

    public EndImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EndImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.ImageICP
    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_END_PICTURE;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float f = (intrinsicWidth * 1.0f) / size;
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fMax = Math.max(f, (1.0f * intrinsicHeight) / size2);
        setMeasuredDimension((int) (intrinsicWidth / fMax), (int) (intrinsicHeight / fMax));
    }
}

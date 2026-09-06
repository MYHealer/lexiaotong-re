package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.joanzapata.android.iconify.Iconify;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class IconButton extends Button {
    public IconButton(Context context) {
        super(context);
        init();
    }

    public IconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            setText(getText());
        } else {
            Iconify.addIcons(this);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(Iconify.compute(charSequence), bufferType);
    }
}

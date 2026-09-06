package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LimitEditText extends AppCompatEditText {
    public LimitEditText(Context context) {
        super(context);
    }

    public LimitEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LimitEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new mInputConnecttion(super.onCreateInputConnection(editorInfo), false);
    }
}

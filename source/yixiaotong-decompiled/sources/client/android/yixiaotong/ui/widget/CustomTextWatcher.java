package client.android.yixiaotong.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CustomTextWatcher implements TextWatcher {
    private EditText mEditText;
    private boolean mFormat = false;
    private boolean mInvalid = false;
    private String mLastText = "";
    private int mSelection;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CustomTextWatcher(EditText editText) {
        this.mEditText = editText;
        editText.setInputType(128);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        try {
            String string = charSequence.toString();
            if (this.mLastText.equals(string)) {
                if (this.mInvalid) {
                    this.mSelection--;
                } else if (this.mSelection >= 1) {
                    int length = string.length();
                    int i4 = this.mSelection;
                    if (length > i4 - 1 && string.charAt(i4 - 1) == ' ') {
                        this.mSelection++;
                    }
                }
                int length2 = this.mLastText.length();
                int i5 = this.mSelection;
                if (i5 > length2) {
                    this.mEditText.setSelection(length2);
                } else {
                    this.mEditText.setSelection(i5);
                }
                this.mFormat = false;
                this.mInvalid = false;
                return;
            }
            this.mFormat = true;
            this.mSelection = i;
            if (i3 == 0) {
                if (i >= 1) {
                    int length3 = string.length();
                    int i6 = this.mSelection;
                    if (length3 <= i6 - 1 || string.charAt(i6 - 1) != ' ') {
                        return;
                    }
                    this.mSelection--;
                    return;
                }
                return;
            }
            this.mSelection = i + i3;
            int i7 = i3 + i;
            char c = string.substring(i, i7).toCharArray()[0];
            if (c < '0' || c > '9') {
                if (c < 'A' || c > 'F') {
                    if (c < 'a' || c > 'f') {
                        this.mInvalid = true;
                        this.mEditText.setText(string.substring(0, i) + string.substring(i7, string.length()));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        try {
            if (this.mFormat) {
                StringBuilder sb = new StringBuilder();
                sb.append(editable.toString().replace(PPSLabelView.Code, ""));
                int length = sb.length();
                int i = 2;
                int i2 = length % 2 == 0 ? (length / 2) - 1 : length / 2;
                for (int i3 = 0; i3 < i2; i3++) {
                    sb.insert(i, PPSLabelView.Code);
                    i += 3;
                }
                this.mLastText = sb.toString();
                this.mEditText.setText(sb);
            }
        } catch (Exception unused) {
        }
    }
}

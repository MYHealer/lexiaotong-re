package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TelEdittext extends EditText {
    private String addString;
    private boolean isRun;
    public boolean isTel;

    public TelEdittext(Context context) {
        this(context, null);
    }

    public TelEdittext(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isTel = true;
        this.addString = PPSLabelView.Code;
        this.isRun = false;
        init();
    }

    public String getString() {
        return getText().toString().replace(PPSLabelView.Code, "");
    }

    private void init() {
        addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.widget.TelEdittext.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 0;
                if (TelEdittext.this.isRun) {
                    TelEdittext.this.isRun = false;
                    return;
                }
                TelEdittext.this.isRun = true;
                if (TelEdittext.this.isTel) {
                    String str = "";
                    String strReplace = charSequence.toString().replace(PPSLabelView.Code, "");
                    if (3 < strReplace.length()) {
                        str = "" + strReplace.substring(0, 3) + TelEdittext.this.addString;
                        i4 = 3;
                    }
                    while (true) {
                        int i5 = i4 + 4;
                        if (i5 >= strReplace.length()) {
                            break;
                        }
                        str = str + strReplace.substring(i4, i5) + TelEdittext.this.addString;
                        i4 = i5;
                    }
                    TelEdittext.this.setText(str + strReplace.substring(i4, strReplace.length()));
                    if (i3 > 0) {
                        if (i == 3 || i == 8) {
                            TelEdittext.this.setSelection(i + 2);
                            return;
                        } else {
                            TelEdittext.this.setSelection(i + 1);
                            return;
                        }
                    }
                    if (i == 4 || i == 9) {
                        TelEdittext.this.setSelection(i - 1);
                    } else {
                        TelEdittext.this.setSelection(i);
                    }
                }
            }
        });
    }
}

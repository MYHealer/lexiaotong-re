package client.android.yixiaotong.ui.doorlock;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EmojiExcludeFilter implements InputFilter {
    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            int type = Character.getType(charSequence.charAt(i));
            if (type == 19 || type == 28) {
                return "";
            }
            i++;
        }
        return null;
    }
}

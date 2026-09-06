package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.wrapper.m;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class KsAppTagsView extends LinearLayout {
    private int Oj;

    public void setMaxCount(int i) {
        this.Oj = i;
    }

    public KsAppTagsView(Context context) {
        super(context);
        this.Oj = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oj = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Oj = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Oj = 3;
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public final void a(List<String> list, int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.Oj) {
                return;
            } else {
                a(this, str, i);
            }
        }
    }

    private static void a(LinearLayout linearLayout, String str, int i) {
        TextView textView = (TextView) m.a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }
}

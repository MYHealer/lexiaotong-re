package com.hihonor.adsdk.base.widget.base.open;

import android.view.View;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.widget.base.g;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum ViewTagType {
    DEFAULT(0),
    TITLE(2),
    VIDEO(5),
    BUTTON(1);

    private final int clickType;

    ViewTagType(int i) {
        this.clickType = i;
    }

    public void setViewTag(View... viewArr) {
        if (viewArr == null) {
            b.hnadse("ViewTagType", "setViewTag view cannot be null.", new Object[0]);
            return;
        }
        for (View view : viewArr) {
            if (!g.hnadsa(view)) {
                view.setTag(R.id.ad_common_click_type_tag, Integer.valueOf(this.clickType));
            }
        }
    }
}

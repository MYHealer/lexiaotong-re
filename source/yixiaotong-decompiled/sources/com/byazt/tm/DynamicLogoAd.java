package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.byazt.aq.x;
import com.byazt.du.sl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1373})
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.z = new TextView(context);
        this.z.setTag(Integer.valueOf(getClickArea()));
        addView(this.z, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        this.z.setTextAlignment(this.t.x());
        ((TextView) this.z).setTextColor(this.t.sp());
        ((TextView) this.z).setTextSize(this.t.n());
        if (com.byazt.sr.uj.c()) {
            ((TextView) this.z).setIncludeFontPadding(false);
            ((TextView) this.z).setTextSize(Math.min(((com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), this.x) - this.t.tt()) - this.t.c()) - 0.5f, this.t.n()));
            ((TextView) this.z).setText("AD");
            return true;
        }
        if (i()) {
            if (sl.tt()) {
                ((TextView) this.z).setText(sl.c());
                return true;
            }
            ((TextView) this.z).setText(sl.c(this.t.tt));
            return true;
        }
        ((TextView) this.z).setText("广告");
        return true;
    }

    private boolean i() {
        if (com.byazt.sr.uj.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.t.tt) && this.t.tt.contains("adx:")) || sl.tt();
    }
}

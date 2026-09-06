package com.hihonor.adsdk.base.widget.a;

import android.content.Context;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.a.c.a;
import com.hihonor.adsdk.base.widget.base.AdFlagCloseView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c<VH extends a> {
    protected final BaseAd hnadsa;
    private final com.hihonor.adsdk.base.widget.a.a hnadsb = new com.hihonor.adsdk.base.widget.a.a();

    public c(BaseAd baseAd) {
        this.hnadsa = baseAd;
    }

    public abstract VH hnadsa(Context context);

    public void hnadsa() {
        this.hnadsb.hnadsa();
    }

    public abstract void hnadsa(VH vh);

    public void hnadsb(b bVar) {
        if (this.hnadsb.hnadsa(bVar)) {
            this.hnadsb.unregisterObserver(bVar);
        }
    }

    public void hnadsa(b bVar) {
        if (this.hnadsb.hnadsa(bVar)) {
            return;
        }
        this.hnadsb.registerObserver(bVar);
    }

    public static abstract class a {
        protected final View hnadsa;
        protected AdFlagCloseView hnadsb;
        protected View.OnClickListener hnadsc;

        public a(View view) {
            this.hnadsa = view;
        }

        public AdFlagCloseView hnadsa() {
            return this.hnadsb;
        }

        public void hnadsa(View.OnClickListener onClickListener) {
            this.hnadsc = onClickListener;
        }

        public View hnadsb() {
            return this.hnadsa;
        }

        public void hnadsc() {
        }

        public void hnadsd() {
        }

        protected <T extends View> T hnadsa(int i) {
            View view = this.hnadsa;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i);
        }

        protected void hnadsa(View view) {
            View.OnClickListener onClickListener = this.hnadsc;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}

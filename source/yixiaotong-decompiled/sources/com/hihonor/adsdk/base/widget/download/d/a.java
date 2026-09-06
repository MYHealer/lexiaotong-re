package com.hihonor.adsdk.base.widget.download.d;

import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a {
    private static final String hnadsf = "BaseDownloadButtonHandler";
    protected final HnDownloadButton hnadsa;
    protected com.hihonor.adsdk.base.widget.base.e hnadsb;
    protected int hnadsc;
    protected BaseAd hnadsd;
    protected com.hihonor.adsdk.base.widget.download.a hnadse;

    public a(HnDownloadButton hnDownloadButton) {
        this.hnadsa = hnDownloadButton;
    }

    private void hnadsf() {
        hnadsd(hnadsa(this.hnadsa, R.string.ads_click_view_cn));
        hnadsa((CharSequence) hnadsa(this.hnadsa, R.string.ads_download_button_recover_cn));
        hnadsc(hnadsa(this.hnadsa, R.string.ads_try_again_cn));
        hnadse(hnadsa(this.hnadsa, R.string.ads_wait_cn));
        HnDownloadButton hnDownloadButton = this.hnadsa;
        hnDownloadButton.setIdleText(hnadsa(hnDownloadButton, R.string.ads_download_botton_install_cn));
        HnDownloadButton hnDownloadButton2 = this.hnadsa;
        hnDownloadButton2.setPauseText(hnadsa(hnDownloadButton2, R.string.ads_download_button_resume_cn));
        HnDownloadButton hnDownloadButton3 = this.hnadsa;
        hnDownloadButton3.setInstallText(hnadsa(hnDownloadButton3, R.string.ads_download_button_installing_cn));
        HnDownloadButton hnDownloadButton4 = this.hnadsa;
        hnDownloadButton4.setDoneText(hnadsa(hnDownloadButton4, R.string.ads_download_button_open_cn));
        HnDownloadButton hnDownloadButton5 = this.hnadsa;
        hnDownloadButton5.setReserveText(hnadsa(hnDownloadButton5, R.string.ads_reserved));
    }

    private void hnadsh() {
        String buttonText = this.hnadsd.getButtonText();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "Use server configuration current text:" + buttonText, new Object[0]);
        if (TextUtils.isEmpty(buttonText)) {
            return;
        }
        hnadsf();
        hnadsa(buttonText);
    }

    public int hnadsa() {
        return 0;
    }

    public void hnadsa(int i) {
    }

    public void hnadsa(CharSequence charSequence) {
    }

    protected abstract void hnadsa(String str);

    public void hnadsb() {
    }

    public void hnadsb(CharSequence charSequence) {
    }

    public void hnadsc() {
    }

    public void hnadsc(CharSequence charSequence) {
    }

    public abstract void hnadsd();

    public void hnadsd(CharSequence charSequence) {
    }

    public void hnadse() {
    }

    public void hnadse(CharSequence charSequence) {
    }

    public void hnadsg() {
        this.hnadsa.reset();
    }

    public void hnadsb(int i) {
        com.hihonor.adsdk.base.widget.base.e eVar = this.hnadsb;
        if (eVar != null) {
            eVar.hnadsa(i);
        }
    }

    public void hnadsa(com.hihonor.adsdk.base.widget.download.a aVar) {
        this.hnadse = aVar;
        if (aVar != null) {
            aVar.hnadsa(this.hnadsa);
        }
    }

    public void hnadsa(BaseAd baseAd, int i) {
        this.hnadsd = baseAd;
        this.hnadsc = i;
        if (this.hnadsb == null) {
            this.hnadsb = new com.hihonor.adsdk.base.widget.base.e();
        }
        this.hnadsb.hnadsa(baseAd);
        hnadsh();
    }

    public void hnadsa(Point point, Point point2, float f) {
        AdListener adListener;
        if (this.hnadsb != null) {
            int i = 1;
            if (this.hnadsc == 1) {
                if (com.hihonor.adsdk.base.j.c.hnadsc(this.hnadsd)) {
                    i = 10;
                }
            } else {
                i = com.hihonor.adsdk.base.j.c.hnadsc(this.hnadsd) ? 11 : 6;
            }
            this.hnadsb.hnadsa(point, point2, i, f, 0);
        }
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null || (adListener = baseAd.getAdListener()) == null) {
            return;
        }
        adListener.onAdClicked();
    }

    public String hnadsa(View view, int i) {
        try {
            return view.getResources().getString(i);
        } catch (Resources.NotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "string res marker " + i + " not found exception", new Object[0]);
            return null;
        }
    }
}

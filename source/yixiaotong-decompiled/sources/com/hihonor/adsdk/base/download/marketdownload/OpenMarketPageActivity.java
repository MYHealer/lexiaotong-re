package com.hihonor.adsdk.base.download.marketdownload;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.hihonor.dlinstall.DownloadInstallClient;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class OpenMarketPageActivity extends com.hihonor.adsdk.base.widget.base.a {
    private static final String hnadsf = "OpenMarketPageActivityTAG";
    private final int hnadse = -1;

    private void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketPage", new Object[0]);
        int intExtra = new SafeIntent(getIntent()).getIntExtra(a.hnadsb, -1);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketPage marketPageType = %d", Integer.valueOf(intExtra));
        if (intExtra == 1) {
            hnadsb();
        }
        if (intExtra == 2) {
            hnadsd();
        }
    }

    private void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketTrafficPopPage", new Object[0]);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        int intExtra = safeIntent.getIntExtra("channel", -1);
        String stringExtra = safeIntent.getStringExtra(a.hnadse);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketPage channel = %d, pkgName = %s", Integer.valueOf(intExtra), stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        boolean zOpenTrafficDownloadPage = DownloadInstallClient.openTrafficDownloadPage(this, intExtra, stringExtra);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onTrafficDownload isOpenTrafficDownloadPage = %b", Boolean.valueOf(zOpenTrafficDownloadPage));
        c.hnadsa().hnadsa(zOpenTrafficDownloadPage, stringExtra);
    }

    private void hnadse() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        hnadse();
        hnadsc();
        finish();
    }

    private void hnadsb() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketDetailPage", new Object[0]);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        Parcelable parcelableExtra = safeIntent.getParcelableExtra(a.hnadsa);
        int intExtra = safeIntent.getIntExtra(a.hnadsc, 0);
        if (parcelableExtra instanceof BaseAd) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketDetailPage parcelable instanceof BaseAd isJumpMarketDetailSuccess= " + c.hnadsa().hnadsa((BaseAd) parcelableExtra, this, intExtra), new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "openMarketDetailPage parcelable not instanceof BaseAd", new Object[0]);
            b0.hnadsb(HnAds.get().getContext().getString(R.string.ads_page_unsupport));
        }
    }
}

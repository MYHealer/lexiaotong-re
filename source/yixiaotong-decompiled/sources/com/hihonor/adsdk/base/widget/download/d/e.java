package com.hihonor.adsdk.base.widget.download.d;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.l;
import com.hihonor.adsdk.base.g.j.d.m;
import com.hihonor.adsdk.base.g.k.c.q;
import com.hihonor.adsdk.base.h.h;
import com.hihonor.adsdk.base.net.i;
import com.hihonor.adsdk.base.net.resp.GameReserveResult;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.common.f.f;
import java.util.Collection;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends com.hihonor.adsdk.base.widget.download.d.a {
    private static final String hnadsl = "ReserveHandler";
    private CharSequence hnadsg;
    private final List<String> hnadsh;
    private com.hihonor.adsdk.base.widget.b.a hnadsi;
    private boolean hnadsj;
    private CharSequence hnadsk;

    class a implements Callback<GameReserveResult> {
        final /* synthetic */ String hnadsa;

        a(String str) {
            this.hnadsa = str;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<GameReserveResult> call, Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsl, "onFailure Throwable.", new Object[0]);
            e.this.hnadsa(ErrorCode.RESPONSE_FAIL, th.getMessage(), this.hnadsa);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<GameReserveResult> call, Response<GameReserveResult> response) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsl, "onResult: " + response.isSuccessful(), new Object[0]);
            if (!response.isSuccessful()) {
                e.this.hnadsa(response.code(), "response: " + response.message(), this.hnadsa);
                return;
            }
            GameReserveResult gameReserveResultBody = response.body();
            if (gameReserveResultBody == null) {
                e.this.hnadsa(ErrorCode.GAME_RESERVE_RESULT_ERR_CODE, ErrorCode.GAME_RESERVE_RESULT_ERR_MSG, this.hnadsa);
            } else if (gameReserveResultBody.hnadsa()) {
                e.this.hnadsb(this.hnadsa);
            } else {
                e.this.hnadsa(gameReserveResultBody.errorCode, "gameReserveResult: " + gameReserveResultBody.errorMessage, this.hnadsa);
            }
        }
    }

    public e(HnDownloadButton hnDownloadButton, List<String> list) {
        super(hnDownloadButton);
        this.hnadsj = false;
        this.hnadsh = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsb(String str) {
        if (this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleSuccess#baseAd is null.", new Object[0]);
            return;
        }
        hnadsc(str);
        String strHnadsa = com.hihonor.adsdk.base.j.c.hnadsa(this.hnadsd);
        com.hihonor.adsdk.base.widget.b.b.hnadsa().hnadsa(strHnadsa, Boolean.TRUE);
        List<com.hihonor.adsdk.base.widget.b.c> listHnadsb = com.hihonor.adsdk.base.widget.b.b.hnadsa().hnadsb();
        if (!f.hnadsa((Collection<?>) listHnadsb)) {
            for (com.hihonor.adsdk.base.widget.b.c cVar : listHnadsb) {
                if (cVar != null) {
                    cVar.hnadsa(5, this.hnadsd.getAppPackage());
                }
            }
        }
        com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(strHnadsa, 6);
    }

    private void hnadsf(CharSequence charSequence) {
        this.hnadsa.reset();
        this.hnadsa.setIndicatingText(charSequence);
    }

    private void hnadsi() {
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null || !com.hihonor.adsdk.base.widget.download.c.hnadsc(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "prepareDownloadState Not APP_RESERVE_DOWNLOAD", new Object[0]);
        } else {
            com.hihonor.adsdk.base.widget.b.b.hnadsa().hnadsa(this.hnadsi);
            this.hnadsj = true;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsc(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "setTryAgainText, tryAgainText is null", new Object[0]);
        } else {
            this.hnadsk = charSequence;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "onClick", new Object[0]);
        if (hnadsa(this.hnadsh)) {
            hnadsa(this.hnadsd);
            String str = this.hnadsh.get(0);
            h.hnadsa().hnadsa(str, new a(str));
        } else {
            HnDownloadButton hnDownloadButton = this.hnadsa;
            if (hnDownloadButton != null) {
                hnDownloadButton.onReserveFail();
            }
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadse() {
        super.hnadse();
        if (this.hnadsj) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "onDetachedFromWindow remove button hashCode:%d", Integer.valueOf(hashCode()));
            com.hihonor.adsdk.base.widget.b.b.hnadsa().hnadsb(this.hnadsi);
            this.hnadsj = false;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsg() {
        hnadsf(this.hnadsk);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(BaseAd baseAd, int i) {
        super.hnadsa(baseAd, i);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "setBaseAd---> reserve ad.", new Object[0]);
        if (com.hihonor.adsdk.base.widget.b.b.hnadsa().hnadsb(com.hihonor.adsdk.base.j.c.hnadsa(baseAd)).booleanValue()) {
            this.hnadsa.onReserveSuccess();
        } else {
            this.hnadsa.reset(this.hnadsg);
        }
        if (this.hnadsi == null) {
            this.hnadsi = new com.hihonor.adsdk.base.widget.b.a(this.hnadsa);
        }
        if (this.hnadsa.isAttachedToWindow()) {
            hnadsi();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsc() {
        super.hnadsc();
        hnadsi();
    }

    private void hnadsc(String str) {
        hnadsa(this.hnadsd, 0, "0", "success", str);
        hnadsb(this.hnadsd, 0, "success", "0", "success");
    }

    private void hnadsb(BaseAd baseAd, int i, String str, String str2, String str3) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportTrack---> baseAd is null. ", new Object[0]);
        } else {
            new q(i, str, str2, str3).hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(int i, String str, String str2) {
        hnadsa(this.hnadsd, 2, String.valueOf(i), str, str2);
        hnadsb(this.hnadsd, 1022, ErrorCode.AD_APP_RESERVE_FAIL_MSG, String.valueOf(i), str);
        HnDownloadButton hnDownloadButton = this.hnadsa;
        if (hnDownloadButton != null) {
            hnDownloadButton.onReserveFail();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsb(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "setReserveText, reserveText is null", new Object[0]);
        } else {
            this.hnadsg = charSequence;
        }
    }

    private void hnadsa(BaseAd baseAd, int i, String str, String str2, String str3) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportRequestResultEvent---> baseAd is null. ", new Object[0]);
        } else {
            new l(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), 0, i, str, str2, str3).hnadse();
        }
    }

    private void hnadsa(BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportRequestEvent---> baseAd is null. ", new Object[0]);
        } else {
            new m(baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), 0).hnadse();
        }
    }

    private boolean hnadsa(List<String> list) {
        String str;
        try {
            if (f.hnadsa((Collection<?>) list)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "isValidity---> reservations is null or empty.", new Object[0]);
                hnadsa(this.hnadsd, 1, "30137", ErrorCode.RESERVATIONS_ERR_CODE_MSG, "");
                hnadsb(this.hnadsd, 1022, ErrorCode.AD_APP_RESERVE_FAIL_MSG, "30137", ErrorCode.RESERVATIONS_ERR_CODE_MSG);
                return false;
            }
            String str2 = list.get(0);
            try {
                if (TextUtils.isEmpty(str2)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "isValidity---> reservation is null or empty.", new Object[0]);
                    hnadsa(this.hnadsd, 1, "30138", ErrorCode.RESERVATION_ERR_CODE_MSG, str2);
                    hnadsb(this.hnadsd, 1022, ErrorCode.AD_APP_RESERVE_FAIL_MSG, "30138", ErrorCode.RESERVATION_ERR_CODE_MSG);
                    return false;
                }
                if (i.hnadsc()) {
                    return true;
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "isValidity---> NetWork Unavailable.", new Object[0]);
                hnadsa(this.hnadsd, 1, "30139", ErrorCode.NETWORK_UNAVAILABLE_ERR_CODE_MSG, str2);
                hnadsb(this.hnadsd, 1022, ErrorCode.AD_APP_RESERVE_FAIL_MSG, "30139", ErrorCode.NETWORK_UNAVAILABLE_ERR_CODE_MSG);
                return false;
            } catch (Exception unused) {
                str = str2;
                hnadsa(this.hnadsd, 1, "30140", ErrorCode.EXCEPTION_ERR_CODE_MSG, str);
                hnadsb(this.hnadsd, 1022, ErrorCode.AD_APP_RESERVE_FAIL_MSG, "30140", ErrorCode.EXCEPTION_ERR_CODE_MSG);
                return false;
            }
        } catch (Exception unused2) {
            str = null;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    protected void hnadsa(String str) {
        hnadsb((CharSequence) str);
    }
}

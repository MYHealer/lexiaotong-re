package com.hihonor.adsdk.base.e;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.m;
import com.hihonor.adsdk.common.f.t;
import com.hihonor.id.router.Router;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends com.hihonor.adsdk.base.e.a {
    private static final String hnadsa = "SecInfoProvider";
    private static final String hnadsb = "content://com.hihonor.mms.datacollector.riskdatacollect/risk_data";
    private static final String hnadsc = "risk_data";
    private static final int hnadsd = 5;

    private static final class a {
        private static final d hnadsa = new d();

        private a() {
        }
    }

    public static d hnadsb() {
        return a.hnadsa;
    }

    private void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "query sec info.", new Object[0]);
        try {
            try {
                Cursor cursorQuery = Router.query(HnAds.get().getContext(), Uri.parse(hnadsb), new String[]{hnadsc}, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        com.hihonor.adsdk.base.e.e.a.hnadsa(string);
                        if (TextUtils.isEmpty(string)) {
                            hnadsa(ErrorCode.AD_MMS_SEC_INFO_FAIL, ErrorCode.AD_MMS_SEC_INFO_FAIL_MSG);
                        } else {
                            hnadsa(0, "success");
                        }
                        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("Router query success: " + string));
                    }
                } else {
                    hnadsa(ErrorCode.AD_MMS_CURSOR_FAIL, ErrorCode.AD_MMS_CURSOR_FAIL_MSG);
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Router cursor is null.", new Object[0]);
                }
                m.hnadsa(cursorQuery);
            } catch (Exception e) {
                hnadsa(ErrorCode.AD_MMS_QUERY_FAIL, ErrorCode.AD_MMS_QUERY_FAIL_MSG);
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Router query exception " + e.getMessage(), new Object[0]);
                m.hnadsa(null);
            }
        } catch (Throwable th) {
            m.hnadsa(null);
            throw th;
        }
    }

    @Override // com.hihonor.adsdk.base.e.a
    public int hnadsa() {
        return 0;
    }

    public String hnadsc() {
        String strHnadsa = com.hihonor.adsdk.base.e.e.a.hnadsa();
        a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.e.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadse();
            }
        });
        return strHnadsa;
    }

    public synchronized void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "sec info refresh start.", new Object[0]);
        if (TimeUnit.MINUTES.toMillis(5L) < System.currentTimeMillis() - t.hnadse().hnadsa(com.hihonor.adsdk.base.c.x1.hnadse, 0L)) {
            hnadsb().hnadsd();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "sec info refresh end.", new Object[0]);
    }
}

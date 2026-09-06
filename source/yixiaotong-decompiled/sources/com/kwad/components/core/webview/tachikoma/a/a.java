package com.kwad.components.core.webview.tachikoma.a;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a implements m {
    private DialogInterface.OnDismissListener Cs;
    protected final com.kwad.sdk.core.webview.b apJ;
    private int apU;
    private boolean apV;
    private final boolean apW;
    private boolean apX;
    private List<com.kwad.components.core.e.d.d> apY;
    private boolean apZ;
    private com.kwad.sdk.core.webview.d.a.a fl;

    static /* synthetic */ boolean a(a aVar, com.kwad.sdk.core.webview.d.b.a aVar2) {
        return b(aVar2);
    }

    private a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.apV = false;
        this.apY = new ArrayList();
        this.apV = false;
        this.apJ = bVar;
        this.apU = 0;
        if (dVar != null) {
            dVar.aS(1);
            this.apY.add(dVar);
        }
        this.fl = aVar;
        this.apW = false;
        this.apZ = false;
    }

    public a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, dVar, aVar, false, 0, false, false);
        this.apX = true;
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        aVar.parseJson(new JSONObject((String) obj));
                    }
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (this.apJ.Pv() && aVar.adTemplate == null) {
            return null;
        }
        if (this.apJ.bbX && !aVar.bdi) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    AdTemplate adTemplate;
                    String strB;
                    if (a.this.apJ.bbY) {
                        if (aVar.adTemplate != null) {
                            adTemplate = aVar.adTemplate;
                            a.this.apY.add(new com.kwad.components.core.e.d.d(adTemplate));
                        } else if (aVar.creativeId >= 0) {
                            adTemplate = com.kwad.sdk.core.response.helper.e.a(a.this.apJ.Pu(), aVar.creativeId, aVar.adStyle);
                        } else {
                            adTemplate = a.this.apJ.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.helper.e.eY(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.helper.e.eJ(adTemplate);
                        }
                        com.kwad.components.core.e.d.d dVarW = a.this.W(aVar.creativeId);
                        if (a.this.Cs != null && dVarW != null) {
                            dVarW.setOnDismissListener(a.this.Cs);
                        }
                        if (!TextUtils.isEmpty(aVar.Rk)) {
                            try {
                                strB = com.kwad.components.core.e.b.a.B(Long.parseLong(aVar.Rk));
                            } catch (Exception unused) {
                                strB = aVar.Rk;
                            }
                        } else {
                            strB = (adTemplate == null || adTemplate.tkLiveShopItemInfo == null) ? null : adTemplate.tkLiveShopItemInfo.itemId;
                        }
                        com.kwad.components.core.e.d.a.a(a.this.a(new com.kwad.components.core.e.d.a.C0661a(a.this.apJ.adW.getContext()).aJ(adTemplate).b(dVarW).ap(strB).as(a.a(a.this, aVar)).at(a.this.apV).d(a.this.apJ.mReportExtData).aN(aVar.ara).aL(aVar.bdh).aM(aVar.nm).au(a.this.apW || aVar.needReport).aR(a.this.apU).ap(a.this.apZ).aw(a.this.apX).aA(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (a.this.fl == null || aVar.bdj) {
                                    return;
                                }
                                a.this.fl.a(aVar);
                            }
                        }), aVar, adTemplate));
                    }
                }
            });
        } else if (this.fl != null) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.fl == null || aVar.bdj) {
                        return;
                    }
                    a.this.fl.a(aVar);
                }
            });
        }
        return null;
    }

    protected final com.kwad.components.core.e.d.d W(long j) {
        List<com.kwad.components.core.e.d.d> list = this.apY;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.apY.get(0);
        }
        for (com.kwad.components.core.e.d.d dVar : this.apY) {
            if (com.kwad.sdk.core.response.helper.e.eY(dVar.qt()) == j) {
                return dVar;
            }
        }
        return null;
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.ara == 1;
    }

    protected final com.kwad.components.core.e.d.a.C0661a a(com.kwad.components.core.e.d.a.C0661a c0661a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        if (aVar.arb != null && !TextUtils.isEmpty(aVar.arb.QY)) {
            c0661a.aq(aVar.arb.QY);
        }
        if (aVar.arb != null && aVar.arb.convertType != 0) {
            c0661a.aP(aVar.arb.convertType);
        }
        if (com.kwad.sdk.core.response.helper.e.fh(adTemplate) && aVar.arb != null && aVar.arb.bdk != null) {
            al.a aVar2 = new al.a();
            aVar2.k((float) aVar.arb.bdk.x, (float) aVar.arb.bdk.y);
            aVar2.j((float) aVar.arb.bdk.x, (float) aVar.arb.bdk.y);
            aVar2.H(aVar.arb.bdk.width, aVar.arb.bdk.height);
            c0661a.d(aVar2);
        } else {
            com.kwad.sdk.widget.g gVar = this.apJ.bbV;
            if (gVar != null) {
                c0661a.d(gVar.getTouchCoords());
            }
        }
        c0661a.a(null, null, null);
        return c0661a;
    }
}

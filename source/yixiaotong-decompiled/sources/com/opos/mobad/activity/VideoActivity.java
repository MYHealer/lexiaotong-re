package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.opos.mobad.c.f;
import com.opos.mobad.g;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.video.player.BaseShowActivity;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class VideoActivity extends BaseShowActivity {
    public static final String EXTRA_KEY_ACTION_TYPE = "actionType";
    public static final String EXTRA_KEY_AD_HELP_DATA = "adHelpData";
    public static final String EXTRA_KEY_BID_PRICE = "bidPrice";
    public static final String EXTRA_KEY_SCREEN_MODE = "screenMode";
    public static final String EXTRA_KEY_SHOW_CALLBACK = "adShowCallback";
    public static final String EXTRA_KEY_WEB_CALLBACK = "webShowCallback";
    private static final String TAG = "VideoActivity";

    private void doFinishWithCode(com.opos.mobad.o.a aVar, int i) {
        com.opos.cmn.an.f.a.b(TAG, "handleAction code=", Integer.valueOf(i), ", msg=", com.opos.mobad.ad.a.a(i));
        if (aVar != null) {
            try {
                aVar.a(i, com.opos.mobad.ad.a.a(i));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        doFinish();
    }

    private com.opos.mobad.o.a getAdShowCallback(Intent intent) {
        IBinder binder;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || (binder = intent.getExtras().getBinder(EXTRA_KEY_SHOW_CALLBACK)) == null) {
                return null;
            }
            return com.opos.mobad.o.a.AbstractBinderC0977a.a(binder);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "getAdShowCallback", e);
            return null;
        }
    }

    public static Intent getIntent(AdHelper.AdHelperData adHelperData, boolean z, int i, com.opos.mobad.o.a aVar, com.opos.mobad.t.a aVar2, int i2) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(EXTRA_KEY_BID_PRICE, i);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (aVar2 != null) {
            bundle.putBinder(EXTRA_KEY_WEB_CALLBACK, aVar2.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static Intent getInterstitialIntent(Activity activity, AdHelper.AdHelperData adHelperData, int i, int i2, com.opos.mobad.o.a aVar) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_KEY_AD_HELP_DATA, adHelperData);
        intent.putExtra(EXTRA_KEY_ACTION_TYPE, i2);
        intent.putExtra(EXTRA_KEY_BID_PRICE, i);
        intent.putExtra(EXTRA_KEY_SCREEN_MODE, com.opos.cmn.an.h.f.a.a(activity) || (activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 4);
        Bundle bundle = new Bundle();
        if (aVar != null) {
            bundle.putBinder(EXTRA_KEY_SHOW_CALLBACK, aVar.asBinder());
        }
        if (!bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    private com.opos.mobad.t.a getWebShowCallback(Intent intent) {
        IBinder binder;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || (binder = intent.getExtras().getBinder(EXTRA_KEY_WEB_CALLBACK)) == null) {
                return null;
            }
            return com.opos.mobad.t.a.AbstractBinderC0999a.a(binder);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "getWebShowCallback", e);
            return null;
        }
    }

    @Override // com.opos.mobad.video.player.BaseShowActivity
    protected com.opos.mobad.cmn.func.a createInteractor() {
        return new g();
    }

    @Override // com.opos.mobad.video.player.BaseShowActivity
    protected void handleAction(Intent intent) {
        if (intent != null) {
            try {
                com.opos.mobad.o.a adShowCallback = getAdShowCallback(intent);
                com.opos.mobad.t.a webShowCallback = getWebShowCallback(intent);
                f fVarK = com.opos.mobad.c.b.k();
                if (fVarK != null && fVarK.a()) {
                    boolean booleanExtra = intent.getBooleanExtra(EXTRA_KEY_SCREEN_MODE, false);
                    int intExtra = intent.getIntExtra(EXTRA_KEY_ACTION_TYPE, -1);
                    int intExtra2 = intent.getIntExtra(EXTRA_KEY_BID_PRICE, 0);
                    AdHelper.AdHelperData adHelperData = (AdHelper.AdHelperData) intent.getParcelableExtra(EXTRA_KEY_AD_HELP_DATA);
                    if (adHelperData == null) {
                        doFinishWithCode(adShowCallback, 10601);
                        return;
                    } else {
                        getAndShow(new com.opos.mobad.c(this, fVarK.b(), fVarK.c(), fVarK.d(), fVarK.e(), fVarK.g(), new com.opos.mobad.e.b(StubApp.getOrigApplicationContext(getApplicationContext()))), adHelperData, intExtra, intExtra2, booleanExtra, new com.opos.mobad.video.player.a.a(adShowCallback, new com.opos.mobad.o.b.a() { // from class: com.opos.mobad.activity.VideoActivity.1
                            @Override // com.opos.mobad.o.b
                            public void a() throws RemoteException {
                                VideoActivity.this.doFinish();
                            }
                        }), webShowCallback);
                        return;
                    }
                }
                doFinishWithCode(adShowCallback, 10414);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c(TAG, "handleAction", e);
                doFinish();
            }
        }
    }
}

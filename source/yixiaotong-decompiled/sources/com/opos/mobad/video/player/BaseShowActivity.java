package com.opos.mobad.video.player;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.opos.cmn.i.g;
import com.opos.mobad.cmn.func.adhandler.UnlockHandler;
import com.opos.mobad.model.utils.AdHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class BaseShowActivity extends Activity {
    private static final String TAG = "BaseShowActivity";
    private com.opos.mobad.video.player.e.c mAdShower;

    protected abstract com.opos.mobad.cmn.func.a createInteractor();

    /* JADX INFO: Access modifiers changed from: protected */
    public void doFinish() {
        try {
            com.opos.cmn.an.f.a.b(TAG, "doFinish");
            if (!isDestroyed() && !isFinishing()) {
                finish();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "doFinish", e);
        }
    }

    protected void getAndShow(com.opos.mobad.b bVar, AdHelper.a aVar, int i, int i2, boolean z, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.t.a aVar2) {
        com.opos.mobad.video.player.e.c cVar = new com.opos.mobad.video.player.e.c(bVar);
        this.mAdShower = cVar;
        if (cVar.a(this, aVar, i, i2, z, dVar, createInteractor(), new c() { // from class: com.opos.mobad.video.player.BaseShowActivity.1
            @Override // com.opos.mobad.video.player.c
            public void a() {
                BaseShowActivity.this.doFinish();
            }
        }, aVar2, new UnlockHandler(this))) {
            return;
        }
        doFinish();
    }

    protected abstract void handleAction(Intent intent);

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b(TAG, "onConfigurationChanged newConfig=", configuration);
        com.opos.mobad.video.player.e.c cVar = this.mAdShower;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        g.b(this);
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b(TAG, "onCreate");
        handleAction(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b(TAG, "onDestroy");
        try {
            com.opos.mobad.video.player.e.c cVar = this.mAdShower;
            if (cVar != null) {
                cVar.c();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(TAG, "onDestroy", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.opos.mobad.video.player.e.c cVar = this.mAdShower;
        if (cVar == null || !cVar.a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        com.opos.cmn.an.f.a.b(TAG, "onPause");
        super.onPause();
        com.opos.mobad.video.player.e.c cVar = this.mAdShower;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b(TAG, "onResume");
        com.opos.mobad.video.player.e.c cVar = this.mAdShower;
        if (cVar != null) {
            cVar.a();
        }
    }
}

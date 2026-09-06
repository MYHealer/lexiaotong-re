package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.fancy._9;
import com.fancy._ad;
import com.fancy._cp;
import com.fancy._f;
import com.fancy._m8;
import com.fancy._mc;
import com.fancy._md;
import com.fancy.adsdk.lib.R;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgRewardVideoPortraitActivity extends PtgBaseVideoActivity {
    public static final /* synthetic */ int _M = 0;
    public _md _I;
    public _ad _J;
    public final _a _H = new _a();
    public AtomicBoolean _K = new AtomicBoolean(false);
    public final AtomicBoolean _L = new AtomicBoolean();

    public class _a implements _mc {
        public _a() {
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ Intent _a;

        public _b(Intent intent) {
            this._a = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String stringExtra = this._a.getStringExtra("VIDEO_ADVERT_ID");
            if (com.fancy.adsdk.lib.utils._a._a((_f) _m8._a()._a.get(stringExtra), PtgRewardVideoPortraitActivity.this._K)) {
                _m8._a()._a(stringExtra);
            }
        }
    }

    public class _c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    static {
        StubApp.interface11(25508);
    }

    @Override // com.fancy.mpsdk.activity.PtgBaseVideoActivity
    public final void _a() {
        _cp _cpVar = _9._a;
        if (_cpVar != null) {
            try {
                if (_cpVar.isShowing()) {
                    Context context = _9._a.getContext();
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        _9._a.dismiss();
                    }
                }
            } catch (Exception unused) {
            } finally {
                _9._a = null;
            }
        }
        _md _mdVar = this._I;
        if (_mdVar != null) {
            _mdVar._b();
            this._I._d();
            this._I = null;
            if (isFinishing()) {
                return;
            }
        } else if (isFinishing()) {
            return;
        }
        finish();
    }

    public void _a(boolean z) {
        setRequestedOrientation(1);
        setContentView(z ? R.layout.fancy_activity_reward_video_web : R.layout.fancy_activity_reward_video_portrait);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // com.fancy.mpsdk.activity.PtgBaseVideoActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        _ad _adVar = this._J;
        if (_adVar != null) {
            _adVar._b();
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        _md _mdVar = this._I;
        if (_mdVar != null) {
            _mdVar._c();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        _md _mdVar = this._I;
        if (_mdVar != null) {
            _mdVar._a();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        _md _mdVar = this._I;
        if (_mdVar != null) {
            _mdVar.onWindowFocusChanged(z);
        }
    }
}

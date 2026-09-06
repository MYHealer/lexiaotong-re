package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.bp.tt;
import com.byazt.ka.n;
import com.byazt.ka.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class TTDelegateActivity extends Activity {
    private Intent c;

    @com.byazt.zqa.c(c = {0, 80, 2350, 2351, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, 1501})
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        StubApp.interface11(23085);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (tt.getContext() == null) {
            tt.c(this);
        }
        try {
            setIntent(intent);
            this.c = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            tt();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void tt() {
        try {
            int intExtra = this.c.getIntExtra("type", 0);
            if (intExtra == 1) {
                c(intExtra, this.c.getIntArrayExtra("permissions"));
                return;
            }
            if (intExtra == 2) {
                c(this.c.getStringExtra("permission_id_key"), this.c.getStringArrayExtra("permission_content_key"));
            } else if (intExtra == 3) {
                c(intExtra, (int[]) null);
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void c(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            uj.c().c(this, strArr, new n() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                @Override // com.byazt.ka.n
                public void c() {
                    com.byazt.ka.c.c(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.ka.n
                public void c(String str2) {
                    com.byazt.ka.c.c(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void c(int i, int[] iArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (i != 1) {
                if (i == 3) {
                    arrayList.add(g.h);
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    arrayList.add("android.permission.READ_PHONE_STATE");
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == 1) {
                        arrayList.add(g.h);
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    } else if (i2 == 2) {
                        arrayList.add("android.permission.READ_PHONE_STATE");
                    } else if (i2 == 3) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            uj.c().c(this, strArr, new n() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                @Override // com.byazt.ka.n
                public void c() {
                    com.byazt.eu.tt.c("TMe", "-------=----- onGranted");
                    com.byazt.eu.n.uj(new c());
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.ka.n
                public void c(String str) {
                    com.byazt.eu.tt.c("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                    "android.permission.READ_PHONE_STATE".equals(str);
                    com.byazt.eu.n.uj(new c());
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }
}

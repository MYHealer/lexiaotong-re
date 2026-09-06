package com.byazt.y;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.nr.m;
import com.byazt.s.t;
import com.byazt.s.u;
import com.byazt.s.uj;
import com.byazt.z.sp;
import com.byazt.z.tt;
import com.byazt.z.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS, 773})
public class JumpUnknownSourceActivity extends Activity {
    public t c;
    public JSONObject n;
    public Intent tt;
    public int uj;
    public Intent ve;

    static {
        StubApp.interface11(21747);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        sp.c().c(this);
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.tt = intent;
        if (intent != null) {
            this.ve = (Intent) intent.getParcelableExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            this.uj = intent.getIntExtra("id", -1);
            try {
                this.n = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                m.c(e);
            }
        }
        if (this.n == null) {
            ve.c((Activity) this);
            return;
        }
        tt();
        t tVar = this.c;
        if (tVar != null && !tVar.tt()) {
            this.c.c();
        } else if (this.c == null) {
            finish();
        }
    }

    private void tt() {
        if (this.c != null || this.tt == null) {
            return;
        }
        try {
            uj ujVarTt = com.byazt.z.uj.sl().tt();
            u uVarC = ujVarTt != null ? ujVarTt.c(this) : null;
            if (uVarC == null) {
                uVarC = new com.byazt.r.c(this);
            }
            String strOptString = this.n.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "提示";
            }
            uVarC.c((CharSequence) "提示").c(strOptString).c("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.y.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (!tt.c(jumpUnknownSourceActivity, jumpUnknownSourceActivity.ve, JumpUnknownSourceActivity.this.uj, JumpUnknownSourceActivity.this.n)) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        tt.c((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.ve, true);
                    } else {
                        tt.ve(JumpUnknownSourceActivity.this.uj, JumpUnknownSourceActivity.this.n);
                    }
                    tt.c(JumpUnknownSourceActivity.this.uj, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).tt("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.y.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.ve != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        tt.c((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ve, true);
                    }
                    tt.tt(JumpUnknownSourceActivity.this.uj, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).c(new DialogInterface.OnCancelListener() { // from class: com.byazt.y.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.ve != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        tt.c((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ve, true);
                    }
                    tt.tt(JumpUnknownSourceActivity.this.uj, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).c(false);
            this.c = uVarC.c();
        } catch (Exception e) {
            m.c(e);
        }
    }
}

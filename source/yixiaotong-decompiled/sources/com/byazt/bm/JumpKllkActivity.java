package com.byazt.bm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.dm.ve;
import com.byazt.gq.t;
import com.byazt.hu.x;
import com.byazt.zqa.c;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, 129, 1660})
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void c() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            ve.c().c("handleIntent is null");
            com.byazt.z.ve.c((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            ve.c().c("getPackage or id is null");
            com.byazt.z.ve.c((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            x.c((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.byazt.z.ve.c((Activity) this);
            return;
        }
        int iOptInt = t.i().optInt("ab", 0);
        x.c(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.byazt.z.ve.c((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.byazt.z.ve.c((Activity) this);
    }
}

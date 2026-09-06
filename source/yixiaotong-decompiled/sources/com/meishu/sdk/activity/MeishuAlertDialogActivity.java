package com.meishu.sdk.activity;

import android.os.Bundle;
import android.view.View;
import com.meishu.sdk.R;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuAlertDialogActivity extends SafeAppCompatActivity {
    private static CancelHandler cancelHandler;
    private static ConfirmHandler confirmHandler;

    public interface CancelHandler {
        void handle();
    }

    public interface ConfirmHandler {
        void handle();
    }

    public static void setCancelHandler(CancelHandler cancelHandler2) {
        cancelHandler = cancelHandler2;
    }

    public static void setConfirmHandler(ConfirmHandler confirmHandler2) {
        confirmHandler = confirmHandler2;
    }

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnClick(View view) {
        ConfirmHandler confirmHandler2;
        int id = view.getId();
        if (id == R.id.cancel_button) {
            CancelHandler cancelHandler2 = cancelHandler;
            if (cancelHandler2 != null) {
                cancelHandler2.handle();
            }
        } else if (id == R.id.confirm_button && (confirmHandler2 = confirmHandler) != null) {
            confirmHandler2.handle();
        }
        finish();
    }

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.ms_activity_meishu_alert_dialog);
        findViewById(R.id.cancel_button).setOnClickListener(this);
        findViewById(R.id.confirm_button).setOnClickListener(this);
    }

    @Override // com.meishu.sdk.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        confirmHandler = null;
        cancelHandler = null;
    }
}

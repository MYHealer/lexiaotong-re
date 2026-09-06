package com.baidu.passbqt.permissions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.passbqt.common.Log;
import com.baidu.passbqt.common.SharedPreferencesUtil;
import com.baidu.passbqt.view.CommonDialog;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PermissionsHelperActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1943a = 8000;
    private static final int b = 8001;
    private PermissionsDTO c;
    private PermissionsCallback d;
    private StringBuilder e;
    private boolean f;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = PassPermissions.a().b();
        PermissionsCallback permissionsCallbackC = PassPermissions.a().c();
        this.d = permissionsCallbackC;
        if (this.c == null) {
            if (permissionsCallbackC != null) {
                permissionsCallbackC.a(-1);
            }
            finish();
            return;
        }
        this.e = new StringBuilder();
        for (String str : this.c.b) {
            this.e.append(str);
        }
        SharedPreferencesUtil.a(this);
        if (!((Boolean) SharedPreferencesUtil.b(this.e.toString(), false)).booleanValue() && !TextUtils.isEmpty(this.c.c)) {
            new CommonDialog.Builder(this).a(this.c.c).a((CharSequence) this.c.d).b(this.c.i).b(this.c.e).a(this.c.f, new View.OnClickListener() { // from class: com.baidu.passbqt.permissions.PermissionsHelperActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SharedPreferencesUtil.a(PermissionsHelperActivity.this.e.toString(), true);
                    PermissionsHelperActivity permissionsHelperActivity = PermissionsHelperActivity.this;
                    permissionsHelperActivity.requestPermissions(permissionsHelperActivity.c.b, 8001);
                }
            }).b(this.c.g, new View.OnClickListener() { // from class: com.baidu.passbqt.permissions.PermissionsHelperActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PermissionsHelperActivity.this.d.a(-2);
                    PermissionsHelperActivity.this.finish();
                }
            }).a().show();
            this.f = true;
        } else {
            requestPermissions(this.c.b, 8001);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 8001) {
            return;
        }
        boolean z = false;
        boolean z2 = true;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (iArr[i2] == 0) {
                Log.b(PassPermissions.f1940a, "Permission check result is permission granted");
            } else if (TextUtils.isEmpty(this.c.d)) {
                this.d.a(-1);
                finish();
                return;
            } else if (shouldShowRequestPermissionRationale(strArr[i2])) {
                z2 = false;
            } else {
                z2 = false;
                z = true;
            }
        }
        if (z && !this.f && this.c.h) {
            new CommonDialog.Builder(this).a(this.c.c).a((CharSequence) this.c.d).b(this.c.i).a(this.c.f, new View.OnClickListener() { // from class: com.baidu.passbqt.permissions.PermissionsHelperActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", PermissionsHelperActivity.this.getPackageName(), null));
                    PermissionsHelperActivity.this.startActivityForResult(intent, 8000);
                }
            }).b(this.c.g, new View.OnClickListener() { // from class: com.baidu.passbqt.permissions.PermissionsHelperActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PermissionsHelperActivity.this.d.a(-1);
                    PermissionsHelperActivity.this.finish();
                }
            }).a().show();
        } else if (z2) {
            this.d.a();
            finish();
        } else {
            this.d.a(-1);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.a().a(PassPermissions.a().b().b)) {
                this.d.a();
            } else {
                this.d.a(-1);
            }
            finish();
        }
    }
}

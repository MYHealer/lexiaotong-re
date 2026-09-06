package com.baidu.passbqt.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PassPermissions implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1940a = "PassPermissions";
    private static PassPermissions b;
    private PermissionsDTO c;
    private PermissionsCallback d;

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c = null;
        this.d = null;
        b = null;
    }

    public PermissionsDTO b() {
        return this.c;
    }

    public PermissionsCallback c() {
        return this.d;
    }

    private PassPermissions() {
    }

    public static synchronized PassPermissions a() {
        if (b == null) {
            b = new PassPermissions();
        }
        return b;
    }

    public void a(PermissionsDTO permissionsDTO, final PermissionsCallback permissionsCallback) {
        if (permissionsDTO == null || permissionsDTO.f1942a == null || permissionsDTO.b == null || permissionsDTO.b.length == 0 || permissionsCallback == null) {
            throw new IllegalArgumentException("params is error");
        }
        this.c = permissionsDTO;
        this.d = new PermissionsCallback() { // from class: com.baidu.passbqt.permissions.PassPermissions.1
            @Override // com.baidu.passbqt.permissions.PermissionsCallback
            public void a() {
                PassPermissions.this.d();
                permissionsCallback.a();
            }

            @Override // com.baidu.passbqt.permissions.PermissionsCallback
            public void a(int i) {
                PassPermissions.this.d();
                permissionsCallback.a(i);
            }
        };
        if (a(permissionsDTO.b)) {
            this.d.a();
            return;
        }
        Intent intent = new Intent(permissionsDTO.f1942a, (Class<?>) PermissionsHelperActivity.class);
        if (permissionsDTO.f1942a instanceof Activity) {
            permissionsDTO.f1942a.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            permissionsDTO.f1942a.startActivity(intent);
        }
    }

    boolean a(String... strArr) {
        for (String str : strArr) {
            if (!a(str, this.c.f1942a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, Context context) {
        try {
            return context.checkSelfPermission(str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}

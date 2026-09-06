package com.huawei.hms.hatool;

import android.content.Context;
import android.os.UserManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class q1 {
    private static q1 c = new q1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4106a = false;
    private Context b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return c;
    }

    public boolean a() {
        if (!this.f4106a) {
            Context context = this.b;
            if (context == null) {
                return false;
            }
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager != null) {
                this.f4106a = userManager.isUserUnlocked();
            } else {
                this.f4106a = false;
            }
        }
        return this.f4106a;
    }
}

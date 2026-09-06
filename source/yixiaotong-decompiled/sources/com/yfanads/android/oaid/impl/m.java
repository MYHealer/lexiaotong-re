package com.yfanads.android.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import com.yfanads.android.oaid.utils.RomUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: OAIDManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.yfanads.android.oaid.ifs.b f9669a;

    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e7  */
    public static com.yfanads.android.oaid.ifs.b a(Context context) {
        com.yfanads.android.oaid.ifs.b iVar;
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        com.yfanads.android.oaid.ifs.b bVar = f9669a;
        if (bVar != null) {
            return bVar;
        }
        if (RomUtils.isLenovo() || RomUtils.isMotolora()) {
            iVar = new i(context);
        } else if (RomUtils.isMeizu()) {
            iVar = new j(context);
        } else if (RomUtils.isNubia()) {
            iVar = new l(context);
        } else if (RomUtils.isXiaomi() || RomUtils.isMiui() || RomUtils.isBlackShark()) {
            iVar = new u(context);
        } else if (RomUtils.isSamsung()) {
            iVar = new s(context);
        } else if (RomUtils.isVivo()) {
            iVar = new t(context);
        } else if (RomUtils.isASUS()) {
            iVar = new a(context);
        } else if (RomUtils.isHonor()) {
            iVar = new g(context);
            if (!iVar.a()) {
                if (!RomUtils.isHuawei() || RomUtils.isEmui()) {
                    iVar = new h(context);
                } else if (RomUtils.isOppo() || RomUtils.isOnePlus()) {
                    iVar = new p(context);
                    if (!iVar.a()) {
                        iVar = new o(context);
                    }
                } else if (RomUtils.isCoolpad(context)) {
                    iVar = new b(context);
                } else if (RomUtils.isCoosea()) {
                    iVar = new c(context);
                } else if (RomUtils.isFreeme()) {
                    iVar = new e(context);
                } else {
                    iVar = RomUtils.is360OS() ? new r(context) : null;
                }
            }
        } else if (RomUtils.isHuawei()) {
            iVar = new h(context);
        } else {
            iVar = new h(context);
        }
        f9669a = iVar;
        if (iVar != null && iVar.a()) {
            YFLog.debug("Manufacturer interface has been found: ".concat(f9669a.getClass().getName()));
            return f9669a;
        }
        com.yfanads.android.oaid.ifs.b kVar = new k(context);
        if (kVar.a()) {
            YFLog.debug("Mobile Security Alliance has been found: ".concat(k.class.getName()));
        } else {
            kVar = new f(context);
            if (kVar.a()) {
                YFLog.debug("Google Play Service has been found: ".concat(f.class.getName()));
            } else {
                kVar = new d();
                YFLog.debug("OAID/AAID was not supported: ".concat(d.class.getName()));
            }
        }
        f9669a = kVar;
        return kVar;
    }
}

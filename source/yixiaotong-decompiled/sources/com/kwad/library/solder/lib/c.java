package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.y;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File aEh;
    private final File aEi;
    private final com.kwad.library.solder.lib.ext.c aEj;
    private final Context mContext;

    c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mContext = origApplicationContext;
        this.aEj = cVar;
        this.aEh = origApplicationContext.getDir(cVar.Em(), 0);
        this.aEi = origApplicationContext.getCacheDir();
    }

    private boolean i(String str, String str2, boolean z) {
        if (!y.hH(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, an.getFileMD5Digest(str))) {
            return true;
        }
        delete(str);
        return false;
    }

    private static void delete(String str) {
        y.delete(str);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void cw(String str) {
        File file = new File(cx(str));
        if (file.exists()) {
            y.V(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void G(String str, String str2) {
        File file = new File(H(str, str2));
        if (file.exists()) {
            y.V(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void DI() throws IOException {
        if (this.aEh.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.aEj.Eq() != null) {
                sb.append(this.aEj.Eq());
            }
            File file = new File(this.aEi, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.aEj.Eq(), this.aEi);
    }

    private String DJ() {
        return this.aEh.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String cx(String str) {
        return DJ() + File.separator + str;
    }

    private String H(String str, String str2) {
        return DJ() + File.separator + str + File.separator + str2;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String I(String str, String str2) {
        return DJ() + File.separator + str + File.separator + str2 + File.separator + this.aEj.Er();
    }

    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return I(aVar.getId(), aVar.getVersion());
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.aEj.Es()) {
            return false;
        }
        return i(I(str, str2), str3, true);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) throws PluginError.InstallError {
        String strA = a(aVar);
        if (TextUtils.isEmpty(strA)) {
            throw new PluginError.InstallError("Can not get install path.", 3006);
        }
        aVar.getId();
        File file = new File(strA);
        if (file.exists() && !this.aEj.Es() && i(file.getAbsolutePath(), aVar.DW(), true)) {
            return strA;
        }
        String strDV = aVar.DV();
        aVar.getId();
        File file2 = new File(strDV);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        aVar.getId();
        if (!i(strDV, aVar.DW(), true)) {
            aVar.DW();
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.DW() + PPSLabelView.Code + strDV, 3003);
        }
        if (file2.renameTo(file)) {
            aVar.getId();
            return strA;
        }
        try {
            DI();
            try {
                y.h(file2, file);
                y.V(file2);
                return strA;
            } catch (Throwable th) {
                a.e("PluginInstallerImpl", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("PluginInstallerImpl", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }
}

package com.byazt.uwt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.bog.a;
import com.byazt.uq.sp;
import com.byazt.uq.u;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 273, 20})
public class c extends Plugin {
    public com.byazt.cda.c c;

    public void c(com.byazt.cda.c cVar) {
        this.c = cVar;
    }

    public c(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.byazt.cda.c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[Catch: Exception -> 0x0059, all -> 0x00d2, TRY_LEAVE, TryCatch #1 {Exception -> 0x0059, blocks: (B:20:0x0043, B:22:0x0046, B:23:0x0051), top: B:49:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    @Override // com.bytedance.pangle.plugin.Plugin
    public void init() {
        com.byazt.cda.c cVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.byazt.th.uj.tt(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strSl = u.c().sl(this.mPkgName);
                if (TextUtils.isEmpty(strSl)) {
                    strSl = this.mPkgName;
                }
                int iC = com.byazt.cda.tt.c(strSl);
                if (iC != -1) {
                    File[] fileArrDa = com.byazt.th.ve.da(strSl, iC);
                    File file = new File(com.byazt.th.ve.sl(strSl, iC));
                    if (fileArrDa != null) {
                        try {
                            if (fileArrDa.length > 0) {
                                this.c = com.byazt.cda.tt.c(file, (List<File>) Arrays.asList(fileArrDa));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            a.c(e);
                        }
                        if (fileArrDa == null && fileArrDa.length > 0 && file.isFile() && (cVar = this.c) != null && cVar.c()) {
                            updateToInstalled(iC);
                        } else {
                            iC = 0;
                        }
                        c(iC);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        u.c().c(this.mPkgName);
                        u.c().uj(this.mPkgName);
                        u.c().c(this.mPkgName, com.byazt.uq.tt.c(Zeus.getAppApplication()));
                        u.c().c(this.mPkgName, this.mApiVersionCode);
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (fileArrDa == null) {
                            iC = 0;
                        } else {
                            iC = 0;
                        }
                        c(iC);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        u.c().c(this.mPkgName);
                        u.c().uj(this.mPkgName);
                        u.c().c(this.mPkgName, com.byazt.uq.tt.c(Zeus.getAppApplication()));
                        u.c().c(this.mPkgName, this.mApiVersionCode);
                    }
                }
                c();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.byazt.gy.n nVar) {
        boolean zC = false;
        if (nVar != null) {
            try {
                if (nVar.ve != null) {
                    com.byazt.cda.c cVar = nVar.ve;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + cVar);
                    String strTt = cVar.tt();
                    int iVe = cVar.ve();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strTt + " plugin=" + this);
                        boolean zC2 = cVar.c();
                        if (zC2 && (zC = com.byazt.cda.tt.c(cVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strTt + " version=" + iVe);
                        }
                        synchronized (this) {
                            try {
                                if (zC2) {
                                    if (this.mLifeCycle == 3) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strTt + x.bQ + this.mVersionCode);
                                    } else if (zC) {
                                        updateToInstalled(iVe);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strTt + x.bQ + iVe);
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strTt + x.bQ + iVe);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strTt + x.bQ + iVe);
                                }
                                sp.c(file);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strTt + " version=" + iVe + " apkFile=" + file);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th2);
            }
        }
        return zC;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.byazt.th.uj.tt(Zeus.getAppApplication()) && u.c().i(this.mPkgName)) {
            u.c().x(this.mPkgName);
            String strC = com.byazt.th.ve.c(this.mPkgName);
            sp.c(strC);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strC);
            tt();
            ve();
        }
    }

    private void tt() {
        List<String> listU = u.c().u(this.mPkgName);
        if (listU == null || listU.size() <= 0) {
            return;
        }
        for (String str : listU) {
            if (!TextUtils.isEmpty(str)) {
                int iC = com.byazt.cda.tt.c(str);
                if (iC != -1) {
                    u.c().c(str, iC, false);
                }
                sp.c(com.byazt.th.ve.c(str));
            }
        }
        u.c().yp(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listU)));
    }

    private void ve() {
        String strSl = u.c().sl(this.mPkgName);
        if (TextUtils.isEmpty(strSl)) {
            return;
        }
        String strC = com.byazt.th.ve.c(strSl);
        sp.c(strC);
        u.c().t(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strC)));
    }

    private void c(int i) {
        if (com.byazt.th.uj.tt(Zeus.getAppApplication())) {
            tt();
            String strSl = u.c().sl(this.mPkgName);
            if (!TextUtils.isEmpty(strSl)) {
                com.byazt.cda.tt.c(strSl, i);
            } else {
                com.byazt.cda.tt.c(this.mPkgName, i);
            }
        }
    }

    public void c() {
        String strC = com.byazt.th.ve.c(this.mPkgName);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        File[] fileArrListFiles = new File(strC).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strC);
            sp.c(strC);
        }
    }
}

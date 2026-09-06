package com.byazt.xe;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 54})
public class ve implements n.c {
    @Override // com.byazt.xe.n.c
    public boolean c(String str, int i) {
        String strTt = com.byazt.th.ve.tt(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strTt)));
        String strVe = com.byazt.th.ve.ve(str, i);
        String str2 = strVe + File.separator + "compFully" + tt.tt(strTt);
        String str3 = strVe + File.separator + tt.c(strTt);
        if (!tt(strTt, str2)) {
            return false;
        }
        c(str2, str3);
        boolean zC = tt.c(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zC)));
        return zC;
    }

    private void c(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        File file2 = new File(str.replace(".odex", ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(".odex", ".vdex")));
        }
    }

    private static boolean tt(String str, String str2) {
        try {
            return c.c(tt.c(str, str2, tt.tt));
        } catch (Exception unused) {
            return false;
        }
    }
}

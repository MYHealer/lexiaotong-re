package com.byazt.fdg;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 46})
public class n {
    public static boolean c(String str, String str2, StringBuilder sb) throws Throwable {
        z zVarC;
        if (TextUtils.isEmpty(str)) {
            sb.append("apkPath null");
            return false;
        }
        try {
            if (com.byazt.uq.i.c()) {
                zVarC = uj.c(str, 1);
            } else {
                zVarC = c.c(str, true);
            }
            Signature[] signatureArr = zVarC != null ? zVarC.tt : null;
            String str3 = Zeus.getPlugin(str2).mSignature;
            byte[] bArrDecode = Base64.decode(str3, 0);
            if (bArrDecode == null || bArrDecode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                sb.append("hostSignature null ");
                if (TextUtils.isEmpty(str3)) {
                    sb.append("origin sign is null");
                }
                return false;
            }
            int length = 0;
            for (Signature signature : signatureArr) {
                length += signature.toByteArray().length;
            }
            byte[] bArr = new byte[length];
            int length2 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, length2, signature2.toByteArray().length);
                length2 += signature2.toByteArray().length;
            }
            boolean zC = z.c(bArr, bArrDecode);
            if (!zC) {
                sb.append("signature error");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return zC;
        } catch (nu e) {
            sb.append("verify e");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}

package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.domain.HttpResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: RewardTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b1 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4886a;
    public final /* synthetic */ c1.a b;
    public final /* synthetic */ File c;
    public final /* synthetic */ File d;

    public b1(String str, c1.a aVar, File file, File file2) {
        this.f4886a = str;
        this.b = aVar;
        this.c = file;
        this.d = file2;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        try {
            c1.b.remove(this.f4886a);
        } catch (Exception unused) {
        }
        c1.a aVar = this.b;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        c1.a aVar;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        try {
            if (httpResponse.isSuccessful()) {
                byte[] responseBody = httpResponse.getResponseBody();
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.c);
                try {
                    fileOutputStream2.write(responseBody);
                    fileOutputStream2.close();
                    if (this.c.renameTo(this.d)) {
                        z = true;
                    } else {
                        LogUtil.e("RewardTempUtil", "rename error");
                    }
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        th.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        aVar = this.b;
                        if (aVar == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        c1.a aVar2 = this.b;
                        if (aVar2 == null) {
                            throw th2;
                        }
                        aVar2.a(false);
                        throw th2;
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            }
            aVar = this.b;
            if (aVar == null) {
                return;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        aVar.a(z);
    }
}

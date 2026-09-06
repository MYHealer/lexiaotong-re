package com.baidu.mobads.sdk.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class ay extends ax {
    public static final String b = "logout";
    private static final String[] c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", "W", ExifInterface.LONGITUDE_EAST, "A"};

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    protected void a(int i, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory iXAdContainerFactoryC = aa.a().c();
            if (iXAdContainerFactoryC != null) {
                iXAdContainerFactoryC.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + PPSLabelView.Code + c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + IOUtils.LINE_SEPARATOR_UNIX);
            }
        } catch (Throwable unused) {
        }
    }
}

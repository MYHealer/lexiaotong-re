package com.facebook.drawee.interfaces;

import android.net.Uri;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface SimpleDraweeControllerBuilder {
    DraweeController build();

    SimpleDraweeControllerBuilder setCallerContext(Object obj);

    SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController draweeController);

    SimpleDraweeControllerBuilder setUri(Uri uri);

    SimpleDraweeControllerBuilder setUri(@Nullable String str);
}

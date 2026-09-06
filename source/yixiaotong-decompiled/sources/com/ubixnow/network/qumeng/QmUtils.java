package com.ubixnow.network.qumeng;

import com.qumeng.advlib.core.IMultiAdObject;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.o0O0o000;
import com.ubixnow.ooooo.oo0OOoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmUtils {
    public static o0O0o0 getMaterialInfo(IMultiAdObject iMultiAdObject) {
        try {
            o0O0o000 o0o0o000 = new o0O0o000();
            o0O0o0 o0o0o0 = new o0O0o0(o0o0o000);
            o0o0o000.OooO(iMultiAdObject.getTitle());
            o0o0o000.OooO0o0(iMultiAdObject.getDesc());
            o0o0o000.OooO0OO(iMultiAdObject.getIdeaId() + "");
            o0o0o000.OooO0o(iMultiAdObject.getDownloadUrl());
            o0o0o000.OooO0oo(iMultiAdObject.getLandingPageUrl());
            o0o0o000.OooO0O0(iMultiAdObject.getAppPackageName());
            o0o0o000.OooOO0(iMultiAdObject.getAppName());
            ArrayList arrayList = new ArrayList();
            o0o0o000.OooO00o(arrayList);
            if (iMultiAdObject.getMaterialType() == 4 || iMultiAdObject.getMaterialType() == 9) {
                o0o0o000.OooO00o("1");
                oo0OOoo oo0oooo = new oo0OOoo(1, iMultiAdObject.getVideoUrl());
                oo0oooo.OooO0O0(iMultiAdObject.getVideoCoverImage());
                oo0oooo.OooO0Oo(iMultiAdObject.getVideoDuration() * 1000);
                if (iMultiAdObject.getMediaSize() != null) {
                    oo0oooo.OooO00o(((Integer) iMultiAdObject.getMediaSize().second).intValue());
                    oo0oooo.OooO0OO(((Integer) iMultiAdObject.getMediaSize().first).intValue());
                }
                arrayList.add(oo0oooo);
            } else {
                o0o0o000.OooO00o("2");
                List imageUrls = iMultiAdObject.getImageUrls();
                if (imageUrls != null) {
                    Iterator it = imageUrls.iterator();
                    while (it.hasNext()) {
                        oo0OOoo oo0oooo2 = new oo0OOoo(2, (String) it.next());
                        if (iMultiAdObject.getMediaSize() != null) {
                            oo0oooo2.OooO00o(((Integer) iMultiAdObject.getMediaSize().second).intValue());
                            oo0oooo2.OooO0OO(((Integer) iMultiAdObject.getMediaSize().first).intValue());
                        }
                        arrayList.add(oo0oooo2);
                    }
                }
            }
            return o0o0o0;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

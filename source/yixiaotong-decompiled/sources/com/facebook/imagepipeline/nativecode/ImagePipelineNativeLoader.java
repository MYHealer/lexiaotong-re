package com.facebook.imagepipeline.nativecode;

import com.facebook.common.soloader.SoLoaderShim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ImagePipelineNativeLoader {
    public static final List<String> DEPENDENCIES;
    public static final String DSO_NAME = "imagepipeline";

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("webp");
        DEPENDENCIES = Collections.unmodifiableList(arrayList);
    }

    public static void load() {
        int i = 0;
        while (true) {
            List<String> list = DEPENDENCIES;
            if (i < list.size()) {
                SoLoaderShim.loadLibrary(list.get(i));
                i++;
            } else {
                SoLoaderShim.loadLibrary(DSO_NAME);
                return;
            }
        }
    }
}

package com.adprof.sdk;

import android.graphics.Bitmap;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class zb {
    static {
        HashMap map = new HashMap();
        map.put("FFD8FF", "jpg");
        map.put("89504E47", "png");
        map.put(com.huawei.openalliance.ad.constant.x.aw, "gif");
        map.put("49492A00", "tif");
        map.put("424D", "bmp");
        map.put("41433130", "dwg");
        map.put("38425053", "psd");
        map.put("7B5C727466", "rtf");
        map.put("3C3F786D6C", "xml");
        map.put("68746D6C3E", com.baidu.mobads.sdk.internal.a.f);
        map.put("44656C69766572792D646174653A", "eml");
        map.put("D0CF11E0", "doc");
        map.put("5374616E64617264204A", "mdb");
        map.put("252150532D41646F6265", "ps");
        map.put("255044462D312E", "pdf");
        map.put("504B0304", "docx");
        map.put("52617221", "rar");
        map.put("57415645", "wav");
        map.put("41564920", "avi");
        map.put("2E524D46", com.kuaishou.weapon.p0.t.w);
        map.put("000001BA", "mpg");
        map.put("000001B3", "mpg");
        map.put("6D6F6F76", "mov");
        map.put("3026B2758E66CF11", "asf");
        map.put("4D546864", "mid");
        map.put("1F8B08", "gz");
        map.put("4D5A9000", "exe/dll");
        map.put("75736167", "txt");
    }

    public static void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }
}

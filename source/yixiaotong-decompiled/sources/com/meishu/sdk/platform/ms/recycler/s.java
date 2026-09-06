package com.meishu.sdk.platform.ms.recycler;

import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.view.TouchPositionListener;
import java.sql.Timestamp;

/* JADX INFO: compiled from: SlideClickUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s {
    public static void a(IAd iAd, float f, float f2, long j, float f3, float f4) {
        if (iAd == null) {
            return;
        }
        try {
            Timestamp timestamp = new Timestamp(j);
            TouchPositionListener.TouchPosition touchPosition = iAd.getTouchData().getTouchPosition();
            if (touchPosition == null) {
                touchPosition = new TouchPositionListener.TouchPosition();
                iAd.getTouchData().setTouchPosition(touchPosition);
            }
            touchPosition.setDownX((int) f);
            touchPosition.setDownY((int) f2);
            touchPosition.setDownTime(timestamp);
            int i = (int) f3;
            if (i <= 0) {
                i = Integer.MIN_VALUE;
            }
            touchPosition.setUpX(i);
            int i2 = (int) f4;
            touchPosition.setUpY(i2 > 0 ? i2 : Integer.MIN_VALUE);
            touchPosition.setUpTime(new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.byazt.nk;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.tm.DynamicBaseWidget;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 42})
public class i {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static sp c(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, com.byazt.aq.da daVar, com.byazt.xl.u uVar) {
        if (context == null || dynamicBaseWidget == null || spVar == null) {
            return null;
        }
        String strAw = spVar.aw();
        String strYv = uVar.yv();
        strAw.hashCode();
        byte b = -1;
        switch (strAw.hashCode()) {
            case 48:
                if (strAw.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (strAw.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (strAw.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (strAw.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (strAw.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (strAw.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (strAw.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (strAw.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (strAw.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (strAw.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (strAw.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (strAw.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                    b = 11;
                }
                break;
            case 1571:
                if (strAw.equals(BaseWrapper.ENTER_ID_AD_SDK)) {
                    b = 12;
                }
                break;
            case 1573:
                if (strAw.equals("16")) {
                    b = 13;
                }
                break;
            case 1574:
                if (strAw.equals(BaseWrapper.ENTER_ID_17)) {
                    b = 14;
                }
                break;
            case 1575:
                if (strAw.equals(BaseWrapper.ENTER_ID_18)) {
                    b = 15;
                }
                break;
            case 1598:
                if (strAw.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                    b = 16;
                }
                break;
            case 1600:
                if (strAw.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
                    b = 17;
                }
                break;
            case 1601:
                if (strAw.equals(BaseWrapper.ENTER_ID_SHORTCUT)) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (strAw.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (strAw.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (strAw.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                return new n(context, dynamicBaseWidget, spVar);
            case 1:
                return new ve(context, dynamicBaseWidget, spVar);
            case 2:
                return new tt(context, dynamicBaseWidget, spVar);
            case 3:
                if (spVar.hd() == 1) {
                    return new nu(context, dynamicBaseWidget, spVar, spVar.kk());
                }
                return new m(context, dynamicBaseWidget, spVar);
            case 4:
            case 9:
                return new u(context, dynamicBaseWidget, spVar);
            case 5:
            case 12:
                return new sl(context, dynamicBaseWidget, spVar);
            case 6:
                return new t(context, dynamicBaseWidget, spVar);
            case 7:
            case 13:
                return new yp(context, dynamicBaseWidget, spVar, strAw, daVar, uVar.i(), uVar.md());
            case 8:
                return new uj(context, dynamicBaseWidget, spVar);
            case 10:
                return new m(context, dynamicBaseWidget, spVar);
            case 11:
                return new nu(context, dynamicBaseWidget, spVar);
            case 14:
            case 15:
                return new my(context, dynamicBaseWidget, spVar, strAw, daVar, uVar.i(), uVar.md());
            case 16:
                if (com.byazt.sr.uj.c()) {
                    return new da(context, dynamicBaseWidget, spVar, strYv + "static/lotties/glass-swipe/glass-swipe.json", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                }
                return new da(context, dynamicBaseWidget, spVar, TextUtils.isEmpty(strYv) ? null : strYv + "brush_mask.json", BaseWrapper.ENTER_ID_SYSTEM_HELPER);
            case 17:
                if (com.byazt.sr.uj.c()) {
                    return new da(context, dynamicBaseWidget, spVar, strYv + "static/lotties/202327swiper-up-star/index.json", BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
                }
                return new rh(context, dynamicBaseWidget, spVar);
            case 18:
                if (com.byazt.sr.uj.c()) {
                    return new da(context, dynamicBaseWidget, spVar, strYv + "static/lotties/202327swiper-up-star/click.json", BaseWrapper.ENTER_ID_SHORTCUT);
                }
                return null;
            case 19:
                if (com.byazt.sr.uj.c()) {
                    return new c(context, dynamicBaseWidget, spVar);
                }
                return new da(context, dynamicBaseWidget, spVar, TextUtils.isEmpty(strYv) ? null : strYv + "swiper_up_star.json", "24");
            case 20:
                if (com.byazt.sr.uj.c()) {
                    return new da(context, dynamicBaseWidget, spVar, strYv + "static/lotties/gesture-slide.json", "25");
                }
                return null;
            case 21:
                return new a(context, dynamicBaseWidget, spVar, daVar, uVar.i(), uVar.md());
            default:
                return null;
        }
    }
}

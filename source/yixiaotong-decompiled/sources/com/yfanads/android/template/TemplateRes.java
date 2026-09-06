package com.yfanads.android.template;

import com.yfanads.ads.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class TemplateRes {
    public static final String BANNER_VTB = "VER_TD_BP";
    public static final String BANNER_WH610 = "W640xH100_L_P_R_T";
    public static final String BANNER_WH610_ZT_YW = "640x100";
    public static final String BANNER_WH610_ZW_YT = "640x100R";
    public static final String BANNER_WH615 = "W600xH150_L_P_R_T";
    public static final String BANNER_WH615_ZT_YW = "600x150";
    public static final String BANNER_WH615_ZW_YT = "600x150R";
    public static final String BANNER_WH626 = "W600xH260_L_P_R_T";
    public static final String BANNER_WH626_ZT_YW = "600x260";
    public static final String BANNER_WH626_ZW_YT = "600x260R";
    public static final String BANNER_WH640 = "W600xH400";
    public static final String BANNER_WH640_ST_XW = "600x400";
    public static final String BANNER_WH640_SW_XT = "600x400D";
    public static final String BANNER_WH641 = "W600xH410_T_T_B_P";
    public static final String INT_V_1 = "INT_V_1";
    public static final String INT_V_2 = "INT_V_2";
    public static final String INT_V_3 = "INT_V_3";
    public static final String SHOP_MALL_FLOATING_ICON = "SH2";
    public static final String SHOP_MALL_RED_PACKET = "SH1";
    public static final String SPLASH_V1 = "SP1";
    public static final String SPLASH_V2 = "SP2";
    private static final Map<String, Integer> TEMPLATE_LIST;
    public static final String TL_V_1 = "TL_V_1";
    public static final String TOP_PUSH_1 = "TP1";
    public static final String TOP_PUSH_2 = "TP2";

    static {
        HashMap map = new HashMap();
        TEMPLATE_LIST = map;
        map.put(TOP_PUSH_1, Integer.valueOf(R.layout.tp_native_item_v1));
        map.put(TOP_PUSH_2, Integer.valueOf(R.layout.tp_native_item_v1));
        map.put(SHOP_MALL_RED_PACKET, Integer.valueOf(R.layout.yf_shop_dialog));
        map.put(SHOP_MALL_FLOATING_ICON, Integer.valueOf(R.layout.yf_shop_floating_icon));
        map.put(SPLASH_V1, Integer.valueOf(R.layout.yf_splash_item_v1));
        map.put(SPLASH_V2, Integer.valueOf(R.layout.yf_splash_item_v2));
        map.put(INT_V_1, Integer.valueOf(R.layout.inter_native_item_v2));
        map.put(INT_V_2, Integer.valueOf(R.layout.inter_native_item_v2));
        map.put(INT_V_3, Integer.valueOf(R.layout.inter_native_item_v3));
        map.put(BANNER_WH640, Integer.valueOf(R.layout.banner_native_item_wh640));
        map.put(BANNER_WH626, Integer.valueOf(R.layout.banner_native_item_wh626));
        map.put(BANNER_WH615, Integer.valueOf(R.layout.banner_native_item_wh615));
        map.put(BANNER_VTB, Integer.valueOf(R.layout.banner_native_item_vtb));
        map.put(BANNER_WH610, Integer.valueOf(R.layout.banner_native_item_wh610));
        map.put(BANNER_WH641, Integer.valueOf(R.layout.banner_native_item_wh641));
        map.put(BANNER_WH640_ST_XW, Integer.valueOf(R.layout.banner_native_item_wh640_v3_img_text));
        map.put(BANNER_WH640_SW_XT, Integer.valueOf(R.layout.banner_native_item_wh640_v3_text_img));
        map.put(BANNER_WH615_ZT_YW, Integer.valueOf(R.layout.banner_native_item_wh615_v3_img_text));
        map.put(BANNER_WH615_ZW_YT, Integer.valueOf(R.layout.banner_native_item_wh615_v3_text_img));
        map.put(BANNER_WH610_ZT_YW, Integer.valueOf(R.layout.banner_native_item_wh610_v3_img_text));
        map.put(BANNER_WH610_ZW_YT, Integer.valueOf(R.layout.banner_native_item_wh610_v3_text_img));
        map.put(BANNER_WH626_ZT_YW, Integer.valueOf(R.layout.banner_native_item_wh626_v3_img_text));
        map.put(BANNER_WH626_ZW_YT, Integer.valueOf(R.layout.banner_native_item_wh626_v3_text_img));
        map.put(TL_V_1, Integer.valueOf(R.layout.text_link_item_v1));
    }

    private TemplateRes() {
    }

    public static void addTemplate(String str, int i) {
        Map<String, Integer> map = TEMPLATE_LIST;
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, Integer.valueOf(i));
    }

    public static int getTemplate(String str) {
        Integer num = TEMPLATE_LIST.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}

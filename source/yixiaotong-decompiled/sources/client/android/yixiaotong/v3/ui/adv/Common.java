package client.android.yixiaotong.v3.ui.adv;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Common {
    public static final String AppKey_ChuangZhi = "41719";
    public static final String AppKey_FengChuan = "2121";
    public static final String POS_ID_BannerChuangZhi = "8448916392638485";
    public static final String POS_ID_InterstitialChuangZhi = "8365186415645728";
    public static final String POS_ID_InterstitialFendChuanBath = "2121003";
    public static final String POS_ID_InterstitialFendChuanChuiFeng = "2121007";
    public static final String POS_ID_InterstitialFendChuanRECHARGE = "2121011";
    public static final String POS_ID_InterstitialFendChuanShouYe = "2121001";
    public static final String POS_ID_InterstitialFendChuanYiShui = "2121006";
    public static final String POS_ID_InterstitialForShouYeChuangZhi = "4679398697539250";
    public static final String POS_ID_NativeChuangZhi = "1344532594157105";
    public static final String POS_ID_NativeFendChuanBath = "2121008";
    public static final String POS_ID_NativeFendChuanChuiFeng = "2121010";
    public static final String POS_ID_NativeFendChuanShouYe = "2121002";
    public static final String POS_ID_NativeFendChuanYiShui = "2121009";
    public static final String POS_ID_SplashChuangZhi = "3542834128896347";
    public static final String POS_ID_SplashFengChuanCold = "2121004";
    public static final String POS_ID_SplashFengChuanHot = "2121005";
    public static int SPLASH_LOGO_HEIGHT_RATIO;

    public enum AdvName {
        chuangzhi
    }

    public enum AdvType {
        advsplash,
        advbanner,
        advinsert,
        advnative
    }

    public static void saveLogoValue(Context context, int i) {
        SPLASH_LOGO_HEIGHT_RATIO = i;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("app", 0).edit();
        editorEdit.putInt("logoHeightRatio", i);
        editorEdit.apply();
    }

    public static void getLogoValue(Context context) {
        SPLASH_LOGO_HEIGHT_RATIO = context.getSharedPreferences("app", 0).getInt("logoHeightRatio", 0);
    }
}

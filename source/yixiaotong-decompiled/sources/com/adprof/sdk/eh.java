package com.adprof.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eh f1150a = new eh();

    public final String a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (gi.a(lowerCase)) {
                try {
                    String lowerCase2 = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "huawei", false, 2, (Object) null)) {
                        str3 = "com.huawei.fastapp";
                    } else if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) MediationConstant.ADN_XIAOMI, false, 2, (Object) null)) {
                        str3 = "com.miui.hybrid";
                    } else if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "oppo", false, 2, (Object) null)) {
                        str3 = "com.nearme.instant.platform";
                    } else if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "vivo", false, 2, (Object) null)) {
                        str3 = "com.vivo.hybrid";
                    } else {
                        if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "honor", false, 2, (Object) null)) {
                            return str2;
                        }
                        str3 = com.huawei.openalliance.ad.constant.x.bj;
                    }
                    return str3;
                } catch (Throwable unused) {
                    return str2;
                }
            }
            if (StringsKt.startsWith$default(lowerCase, "tbopen://", false, 2, (Object) null)) {
                pk.d("推断为淘宝");
                return "com.taobao.taobao";
            }
            if (StringsKt.startsWith$default(lowerCase, "taobaolite://", false, 2, (Object) null)) {
                pk.d("推断为淘宝特价版");
                return "com.taobao.litetao";
            }
            if (StringsKt.startsWith$default(lowerCase, "openapp.jdmobile:", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "jdmobile://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "jd://", false, 2, (Object) null)) {
                pk.d("推断为京东");
                return "com.jingdong.app.mall";
            }
            if (StringsKt.startsWith$default(lowerCase, "pddopen://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "pdd://", false, 2, (Object) null)) {
                pk.d("推断为拼多多");
                return "com.xunmeng.pinduoduo";
            }
            if (StringsKt.startsWith$default(lowerCase, "alipays://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "alipay://", false, 2, (Object) null)) {
                pk.d("推断为支付宝");
                return com.hihonor.adsdk.base.c.q.hnadsb;
            }
            if (StringsKt.startsWith$default(lowerCase, "baiduboxapp://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "baidu://", false, 2, (Object) null)) {
                pk.d("推断为百度");
                return com.hihonor.adsdk.base.c.q.hnadsa;
            }
            if (StringsKt.startsWith$default(lowerCase, "baiduboxlite://", false, 2, (Object) null)) {
                pk.d("推断为百度极速版");
                return "com.baidu.searchbox.lite";
            }
            if (StringsKt.startsWith$default(lowerCase, "imeituan://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "meituan://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "openapp.meituan:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "i.meituan.com", false, 2, (Object) null)) {
                pk.d("推断为美团");
                return "com.sankuai.meituan";
            }
            if (StringsKt.startsWith$default(lowerCase, "meituanwaimai://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "waimai.meituan.com", false, 2, (Object) null)) {
                pk.d("推断为美团外卖");
                return "com.sankuai.meituan.takeout";
            }
            if (StringsKt.startsWith$default(lowerCase, "eleme://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "openapp.ele.me:", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "h5.ele.me", false, 2, (Object) null)) {
                pk.d("推断为饿了么");
                return "me.ele";
            }
            if (StringsKt.startsWith$default(lowerCase, "kwai://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "ks://", false, 2, (Object) null)) {
                pk.d("推断为快手");
                return "com.smile.gifmaker";
            }
            if (StringsKt.startsWith$default(lowerCase, "kslite://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "kuaishou.com/lite", false, 2, (Object) null)) {
                pk.d("推断为快手极速版");
                return "com.kuaishou.nebula";
            }
            if (StringsKt.startsWith$default(lowerCase, "fleamarket://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "m.xianyu.com", false, 2, (Object) null)) {
                pk.d("推断为闲鱼");
                return "com.taobao.idlefish";
            }
            if (StringsKt.startsWith$default(lowerCase, "taobaoliveshare", false, 2, (Object) null)) {
                pk.d("推断为淘宝直播");
                return "com.taobao.live";
            }
            if (StringsKt.startsWith$default(lowerCase, "onetravel", false, 2, (Object) null)) {
                pk.d("推断为滴滴出行");
                return "com.sdu.didi.psnger";
            }
            if (StringsKt.startsWith$default(lowerCase, "iting://open", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "iting://component.xm", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "xmly://page.xm", false, 2, (Object) null)) {
                pk.d("推断为 喜马拉雅");
                return "com.ximalaya.ting.android";
            }
        }
        return str2;
    }
}

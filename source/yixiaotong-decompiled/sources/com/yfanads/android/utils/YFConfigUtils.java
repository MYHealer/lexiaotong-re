package com.yfanads.android.utils;

import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFConfigUtils {

    /* JADX INFO: renamed from: com.yfanads.android.utils.YFConfigUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType;

        static {
            int[] iArr = new int[ConfigType.values().length];
            $SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType = iArr;
            try {
                iArr[ConfigType.CUSTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType[ConfigType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType[ConfigType.EXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum ConfigType {
        CUSTOM,
        USER,
        EXT
    }

    public static boolean getBooleanValue(ConfigType configType, String str, boolean z) {
        Object value = getValue(configType, str);
        return value instanceof Boolean ? ((Boolean) value).booleanValue() : z;
    }

    public static Map<String, Object> getValue(ConfigType configType) {
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        if (yFAdsConfig == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType[configType.ordinal()];
        if (i == 1) {
            return yFAdsConfig.getCustomDefine();
        }
        if (i == 2) {
            return yFAdsConfig.getUserDefine();
        }
        if (i != 3) {
            return null;
        }
        return yFAdsConfig.getExtDefine();
    }

    public static Object getValue(ConfigType configType, String str) {
        Map<String, Object> customDefine;
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        if (yFAdsConfig == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$yfanads$android$utils$YFConfigUtils$ConfigType[configType.ordinal()];
        if (i == 1) {
            customDefine = yFAdsConfig.getCustomDefine();
        } else if (i != 2) {
            customDefine = i != 3 ? null : yFAdsConfig.getExtDefine();
        } else {
            customDefine = yFAdsConfig.getUserDefine();
        }
        if (YFListUtils.isMapEmpty(customDefine)) {
            return null;
        }
        return customDefine.get(str);
    }
}

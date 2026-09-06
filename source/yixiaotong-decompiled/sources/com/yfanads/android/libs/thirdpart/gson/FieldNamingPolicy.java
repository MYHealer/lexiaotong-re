package com.yfanads.android.libs.thirdpart.gson;

import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.1
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.2
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.3
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), PPSLabelView.Code));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.4
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.5
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), x.A).toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.yfanads.android.libs.thirdpart.gson.FieldNamingPolicy.6
        @Override // com.yfanads.android.libs.thirdpart.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        StringBuilder sbAppend;
        String strSubstring;
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i == 0) {
            sbAppend = new StringBuilder().append(upperCase);
            strSubstring = str.substring(1);
        } else {
            sbAppend = new StringBuilder().append(str.substring(0, i)).append(upperCase);
            strSubstring = str.substring(i + 1);
        }
        return sbAppend.append(strSubstring).toString();
    }
}

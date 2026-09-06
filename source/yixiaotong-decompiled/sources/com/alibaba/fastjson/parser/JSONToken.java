package com.alibaba.fastjson.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.util.i;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.ez;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONToken {
    public static final int COLON = 17;
    public static final int COMMA = 16;
    public static final int EOF = 20;
    public static final int ERROR = 1;
    public static final int FALSE = 7;
    public static final int FIELD_NAME = 19;
    public static final int IDENTIFIER = 18;
    public static final int LBRACE = 12;
    public static final int LBRACKET = 14;
    public static final int LITERAL_FLOAT = 3;
    public static final int LITERAL_INT = 2;
    public static final int LITERAL_ISO8601_DATE = 5;
    public static final int LITERAL_STRING = 4;
    public static final int LPAREN = 10;
    public static final int NEW = 9;
    public static final int NULL = 8;
    public static final int RBRACE = 13;
    public static final int RBRACKET = 15;
    public static final int RPAREN = 11;
    public static final int SET = 21;
    public static final int TREE_SET = 22;
    public static final int TRUE = 6;
    public static final int UNDEFINED = 23;

    public static String name(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            case 3:
                return TypedValues.Custom.S_FLOAT;
            case 4:
                return TypedValues.Custom.S_STRING;
            case 5:
                return "iso8601";
            case 6:
                return ez.Code;
            case 7:
                return ez.V;
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return "{";
            case 13:
                return i.d;
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return x.bQ;
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            default:
                return "Unkown";
        }
    }
}

package com.adprof.sdk;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class xi {
    public static String a(kj kjVar) {
        if (kjVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("{\"url\":");
        if (kjVar.f427a != null) {
            sb.append("\"").append(a(kjVar.f427a)).append("\"");
        } else {
            sb.append("null");
        }
        sb.append(",\"width\":");
        Integer num = kjVar.f1268a;
        if (num != null) {
            sb.append(num);
        } else {
            sb.append("null");
        }
        sb.append(",\"height\":");
        Integer num2 = kjVar.b;
        if (num2 != null) {
            sb.append(num2);
        } else {
            sb.append("null");
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(oj ojVar) {
        if (ojVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("{\"text\":");
        if (ojVar.f1347a != null) {
            sb.append("\"").append(a(ojVar.f1347a)).append("\"");
        } else {
            sb.append("null");
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(wi wiVar) {
        String string;
        if (wiVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("{\"template_type\":");
        Integer num = wiVar.f804a;
        if (num != null) {
            sb.append(num);
        } else {
            sb.append("null");
        }
        sb.append(",\"imgs\":");
        List list = wiVar.f805a;
        if (list == null || list.isEmpty()) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            sb.append("[");
            for (int i = 0; i < wiVar.f805a.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(a((kj) wiVar.f805a.get(i)));
            }
            sb.append("]");
        }
        sb.append(",\"icon\":");
        kj kjVar = wiVar.f1503a;
        if (kjVar != null) {
            sb.append(a(kjVar));
        } else {
            sb.append("null");
        }
        sb.append(",\"videos\":");
        List list2 = wiVar.f806b;
        if (list2 == null || list2.isEmpty()) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            sb.append("[");
            for (int i2 = 0; i2 < wiVar.f806b.size(); i2++) {
                if (i2 > 0) {
                    sb.append(",");
                }
                qj qjVar = (qj) wiVar.f806b.get(i2);
                if (qjVar == null) {
                    string = "null";
                } else {
                    StringBuilder sb2 = new StringBuilder("{\"url\":");
                    if (qjVar.f680a != null) {
                        sb2.append("\"").append(a(qjVar.f680a)).append("\"");
                    } else {
                        sb2.append("null");
                    }
                    sb2.append(",\"width\":");
                    Integer num2 = qjVar.f1387a;
                    if (num2 != null) {
                        sb2.append(num2);
                    } else {
                        sb2.append("null");
                    }
                    sb2.append(",\"height\":");
                    Integer num3 = qjVar.b;
                    if (num3 != null) {
                        sb2.append(num3);
                    } else {
                        sb2.append("null");
                    }
                    sb2.append(",\"duration\":");
                    Integer num4 = qjVar.c;
                    if (num4 != null) {
                        sb2.append(num4);
                    } else {
                        sb2.append("null");
                    }
                    sb2.append(com.alipay.sdk.util.i.d);
                    string = sb2.toString();
                }
                sb.append(string);
            }
            sb.append("]");
        }
        sb.append(",\"title\":");
        oj ojVar = wiVar.f803a;
        if (ojVar != null) {
            sb.append(a(ojVar));
        } else {
            sb.append("null");
        }
        sb.append(",\"desc\":");
        oj ojVar2 = wiVar.b;
        if (ojVar2 != null) {
            sb.append(a(ojVar2));
        } else {
            sb.append("null");
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    public static String a(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                str2 = "\\f";
            } else if (cCharAt == '\r') {
                str2 = "\\r";
            } else if (cCharAt == '\"') {
                str2 = "\\\"";
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        str2 = "\\b";
                        break;
                    case '\t':
                        str2 = "\\t";
                        break;
                    case '\n':
                        str2 = "\\n";
                        break;
                    default:
                        if (cCharAt < ' ') {
                            str2 = String.format("\\u%04x", Integer.valueOf(cCharAt));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            } else {
                str2 = "\\\\";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m726a(wi wiVar) {
        try {
            a("server返回数据 adm JSON = ", a(wiVar));
        } catch (Exception e) {
            pk.b("ResponseAdmJsonLogger: Failed to convert ResponseAdm to JSON", e);
        }
    }

    public static void a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            pk.d(str + str2);
            return;
        }
        int length = str2.length();
        if (length <= 3072) {
            pk.d(str + str2);
            return;
        }
        int i = (length + 3071) / 3072;
        int i2 = 0;
        int i3 = 1;
        while (i2 < length) {
            int iMin = Math.min(i2 + 3072, length);
            pk.d(str + "[Part " + i3 + "/" + i + "] " + str2.substring(i2, iMin));
            i3++;
            i2 = iMin;
        }
    }
}

package com.adprof.sdk;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class aj {
    public static String a(zi ziVar) {
        String str;
        StringBuilder sb = new StringBuilder("{\"id\":");
        if (ziVar.f918a != null) {
            sb.append("\"").append(a(ziVar.f918a)).append("\"");
        } else {
            sb.append("null");
        }
        sb.append(",\"ad_id\":");
        if (ziVar.f919b != null) {
            sb.append("\"").append(a(ziVar.f919b)).append("\"");
        } else {
            sb.append("null");
        }
        sb.append(",\"bid_price\":");
        Integer num = ziVar.f917a;
        if (num != null) {
            sb.append(num);
        } else {
            sb.append("null");
        }
        sb.append(",\"bid_type\":");
        Integer num2 = ziVar.b;
        if (num2 != null) {
            sb.append(num2);
        } else {
            sb.append("null");
        }
        sb.append(",\"action_type\":");
        Integer num3 = ziVar.c;
        if (num3 != null) {
            sb.append(num3);
        } else {
            sb.append("null");
        }
        sb.append(",\"events\":");
        ij ijVar = ziVar.f913a;
        if (ijVar != null) {
            StringBuilder sb2 = new StringBuilder("{\"download_urls\":");
            sb2.append(a(ijVar.f1233a));
            sb2.append(",\"downloaded_urls\":").append(a(ijVar.b));
            sb2.append(",\"install_urls\":").append(a(ijVar.c));
            sb2.append(",\"installed_urls\":").append(a(ijVar.d));
            sb2.append(",\"dp_urls\":").append(a(ijVar.e));
            sb2.append(",\"dp_fail_urls\":").append(a(ijVar.f));
            sb2.append(",\"imp_urls\":").append(a(ijVar.g));
            sb2.append(",\"click_urls\":").append(a(ijVar.h));
            sb2.append(",\"lose_urls\":").append(a(ijVar.i));
            sb2.append(",\"win_urls\":").append(a(ijVar.j));
            sb2.append(",\"delay_urls\":");
            List list = ijVar.k;
            if (list == null || list.isEmpty()) {
                str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                sb2.append("[");
                for (int i = 0; i < ijVar.k.size(); i++) {
                    if (i > 0) {
                        sb2.append(",");
                    }
                    ej ejVar = (ej) ijVar.k.get(i);
                    if (ejVar != null) {
                        sb2.append("{\"delay\":");
                        Object obj = ejVar.f1152a;
                        if (obj == null) {
                            obj = "null";
                        }
                        sb2.append(obj);
                        sb2.append(",\"url\":");
                        if (ejVar.f261a != null) {
                            sb2.append("\"").append(a(ejVar.f261a)).append("\"");
                        } else {
                            sb2.append("null");
                        }
                        sb2.append(com.alipay.sdk.util.i.d);
                    } else {
                        sb2.append("null");
                    }
                }
                str = "]";
            }
            sb2.append(str);
            sb2.append(com.alipay.sdk.util.i.d);
            sb.append(sb2.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\"creative\":");
        cj cjVar = ziVar.f1558a;
        if (cjVar != null) {
            StringBuilder sb3 = new StringBuilder("{\"cid\":");
            if (cjVar.f176a != null) {
                sb3.append("\"").append(a(cjVar.f176a)).append("\"");
            } else {
                sb3.append("null");
            }
            sb3.append(",\"land\":");
            if (cjVar.b != null) {
                sb3.append("\"").append(a(cjVar.b)).append("\"");
            } else {
                sb3.append("null");
            }
            sb3.append(",\"deeplink\":");
            if (cjVar.c != null) {
                sb3.append("\"").append(a(cjVar.c)).append("\"");
            } else {
                sb3.append("null");
            }
            sb3.append(",\"ddp\":");
            Integer num4 = cjVar.f175a;
            if (num4 != null) {
                sb3.append(num4);
            } else {
                sb3.append("null");
            }
            sb3.append(",\"adm\":");
            wi wiVar = cjVar.f1113a;
            if (wiVar != null) {
                sb3.append(xi.a(wiVar));
            } else {
                sb3.append("null");
            }
            sb3.append(com.alipay.sdk.util.i.d);
            sb.append(sb3.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\"ad_app\":");
        ui uiVar = ziVar.f916a;
        if (uiVar != null) {
            StringBuilder sb4 = new StringBuilder("{\"app_name\":");
            if (uiVar.f756a != null) {
                sb4.append("\"").append(a(uiVar.f756a)).append("\"");
            } else {
                sb4.append("null");
            }
            sb4.append(",\"icon_url\":");
            if (uiVar.f757b != null) {
                sb4.append("\"").append(a(uiVar.f757b)).append("\"");
            } else {
                sb4.append("null");
            }
            sb4.append(",\"package_name\":");
            if (uiVar.c != null) {
                sb4.append("\"").append(a(uiVar.c)).append("\"");
            } else {
                sb4.append("null");
            }
            sb4.append(",\"download_url\":");
            if (uiVar.j != null) {
                sb4.append("\"").append(a(uiVar.j)).append("\"");
            } else {
                sb4.append("null");
            }
            sb4.append(com.alipay.sdk.util.i.d);
            sb.append(sb4.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\"wx_info\":");
        sj sjVar = ziVar.f915a;
        if (sjVar != null) {
            StringBuilder sb5 = new StringBuilder("{\"release_type\":");
            if (sjVar.f1424a != null) {
                sb5.append("\"").append(a(sjVar.f1424a)).append("\"");
            } else {
                sb5.append("null");
            }
            sb5.append(",\"program_id\":");
            if (sjVar.b != null) {
                sb5.append("\"").append(a(sjVar.b)).append("\"");
            } else {
                sb5.append("null");
            }
            sb5.append(",\"program_path\":");
            if (sjVar.c != null) {
                sb5.append("\"").append(a(sjVar.c)).append("\"");
            } else {
                sb5.append("null");
            }
            sb5.append(",\"binded_app\":");
            if (sjVar.d != null) {
                sb5.append("\"").append(a(sjVar.d)).append("\"");
            } else {
                sb5.append("null");
            }
            sb5.append(com.alipay.sdk.util.i.d);
            sb.append(sb5.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\"ext\":");
        if (ziVar.f920c != null) {
            sb.append("\"").append(a(ziVar.f920c)).append("\"");
        } else {
            sb.append("null");
        }
        sb.append(",\"click_type\":");
        Integer num5 = ziVar.d;
        if (num5 != null) {
            sb.append(num5);
        } else {
            sb.append("null");
        }
        sb.append(",\"interaction\":");
        mj mjVar = ziVar.f914a;
        if (mjVar != null) {
            StringBuilder sb6 = new StringBuilder("{\"shake\":");
            Integer num6 = mjVar.f482a;
            if (num6 != null) {
                sb6.append(num6);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"slide\":");
            Integer num7 = mjVar.f484b;
            if (num7 != null) {
                sb6.append(num7);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"rotate\":");
            Integer num8 = mjVar.f486c;
            if (num8 != null) {
                sb6.append(num8);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"red_packet_rain\":");
            Boolean bool = mjVar.f1310a;
            if (bool != null) {
                sb6.append(bool);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"popup_countdown\":");
            Integer num9 = mjVar.f488d;
            if (num9 != null) {
                sb6.append(num9);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"popup_close_countdown\":");
            Integer num10 = mjVar.f490e;
            if (num10 != null) {
                sb6.append(num10);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"countdown\":");
            Integer num11 = mjVar.f491f;
            if (num11 != null) {
                sb6.append(num11);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"video_sound\":");
            Boolean bool2 = mjVar.b;
            if (bool2 != null) {
                sb6.append(bool2);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"close_countdown\":");
            Integer num12 = mjVar.g;
            if (num12 != null) {
                sb6.append(num12);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"full_screen_click\":");
            Boolean bool3 = mjVar.c;
            if (bool3 != null) {
                sb6.append(bool3);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_version\":");
            Integer num13 = mjVar.h;
            if (num13 != null) {
                sb6.append(num13);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_sensitivity\":");
            Long l = mjVar.f483a;
            if (l != null) {
                sb6.append(l);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_sensitivity_f\":");
            Double d = mjVar.f481a;
            if (d != null) {
                sb6.append(d);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_detection\":");
            Long l2 = mjVar.f485b;
            if (l2 != null) {
                sb6.append(l2);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_hit_count\":");
            Long l3 = mjVar.f487c;
            if (l3 != null) {
                sb6.append(l3);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"min_slide_distance\":");
            Long l4 = mjVar.f489d;
            if (l4 != null) {
                sb6.append(l4);
            } else {
                sb6.append("null");
            }
            sb6.append(",\"shake_need_vibrator\":");
            Boolean bool4 = mjVar.d;
            if (bool4 != null) {
                sb6.append(bool4);
            } else {
                sb6.append("null");
            }
            sb6.append(com.alipay.sdk.util.i.d);
            sb.append(sb6.toString());
        } else {
            sb.append("null");
        }
        sb.append(",\"block_custom\":");
        Integer num14 = ziVar.e;
        if (num14 != null) {
            sb.append(num14);
        } else {
            sb.append("null");
        }
        sb.append(",\"ad_bc\":");
        Integer num15 = ziVar.f;
        if (num15 != null) {
            sb.append(num15);
        } else {
            sb.append("null");
        }
        sb.append(",\"fdop\":");
        Integer num16 = ziVar.g;
        if (num16 != null) {
            sb.append(num16);
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

    public static String a(List list) {
        if (list == null || list.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("\"").append(a((String) list.get(i))).append("\"");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m574a(zi ziVar) {
        try {
            a("server返回数据 ads JSON = ", a(ziVar));
        } catch (Throwable th) {
            pk.b("ResponseAdsJsonLogger: Failed to convert ResponseAds to JSON", th);
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

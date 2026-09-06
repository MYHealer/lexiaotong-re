package com.google.zxing.client.result;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class ExpandedProductResultParser extends ResultParser {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:124:0x01be  */
    /* JADX WARN: Code duplicated, block: B:152:0x0210  */
    /* JADX WARN: Code duplicated, block: B:157:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:93:0x0152  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v5 int, still in use, count: 10, list:
  (r3v5 int) from 0x0055: IF  (r3v5 int) != (1536 int)  -> B:15:0x0057 A[HIDDEN]
  (r3v5 int) from 0x0059: IF  (r3v5 int) != (1537 int)  -> B:17:0x005b A[HIDDEN]
  (r3v5 int) from 0x005d: IF  (r3v5 int) != (1567 int)  -> B:19:0x005f A[HIDDEN]
  (r3v5 int) from 0x0061: IF  (r3v5 int) != (1568 int)  -> B:21:0x0063 A[HIDDEN]
  (r3v5 int) from 0x0065: IF  (r3v5 int) != (1570 int)  -> B:23:0x0067 A[HIDDEN]
  (r3v5 int) from 0x0069: IF  (r3v5 int) != (1572 int)  -> B:25:0x006b A[HIDDEN]
  (r3v5 int) from 0x006d: IF  (r3v5 int) != (1574 int)  -> B:27:0x006f A[HIDDEN]
  (r3v5 int) from 0x0073: SWITCH (r3v5 int)
 case 1568927: goto B:90:0x0148
 case 1568928: goto B:87:0x013e
 case 1568929: goto B:84:0x0134
 case 1568930: goto B:81:0x012a
 case 1568931: goto B:78:0x0120
 case 1568932: goto B:75:0x0116
 case 1568933: goto B:72:0x010c
 case 1568934: goto B:69:0x0102
 case 1568935: goto B:66:0x00f8
 case 1568936: goto B:63:0x00ee
 default: goto B:30:0x0076 A[RegionRef:SW:29]
  (r3v5 int) from 0x0076: SWITCH (r3v5 int)
 case 1575716: goto B:59:0x00dd
 case 1575717: goto B:56:0x00d3
 case 1575718: goto B:53:0x00c9
 case 1575719: goto B:50:0x00bf
 default: goto B:31:0x0079 A[RegionRef:SW:30]
  (r3v5 int) from 0x0079: SWITCH (r3v5 int)
 case 1575747: goto B:42:0x009c
 case 1575748: goto B:39:0x0092
 case 1575749: goto B:36:0x0088
 case 1575750: goto B:33:0x007e
 default: goto B:152:0x0210 A[RegionRef:SW:31]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.zxing.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result result) {
        ExpandedProductParsedResult expandedProductParsedResult = null;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = getMassagedText(result);
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        String strSubstring4 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String strFindAIvalue = findAIvalue(i, massagedText);
            if (strFindAIvalue == null) {
                return expandedProductParsedResult;
            }
            int length = i + strFindAIvalue.length() + 2;
            String strFindValue = findValue(length, massagedText);
            int length2 = length + strFindValue.length();
            String str10 = massagedText;
            if (iHashCode != 1536) {
                if (iHashCode != 1537) {
                    if (iHashCode != 1567) {
                        if (iHashCode != 1568) {
                            if (iHashCode != 1570) {
                                if (iHashCode != 1572) {
                                    if (iHashCode != 1574) {
                                        switch (strFindAIvalue) {
                                            case "3100":
                                            case "3101":
                                            case "3102":
                                            case "3103":
                                            case "3104":
                                            case "3105":
                                            case "3106":
                                            case "3107":
                                            case "3108":
                                            case "3109":
                                                strSubstring = strFindAIvalue.substring(3);
                                                str9 = ExpandedProductParsedResult.KILOGRAM;
                                                str8 = strFindValue;
                                                break;
                                            default:
                                                switch (strFindAIvalue) {
                                                    case 1568927:
                                                        if (!strFindAIvalue.equals("3200")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568928:
                                                        if (!strFindAIvalue.equals("3201")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568929:
                                                        if (!strFindAIvalue.equals("3202")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568930:
                                                        if (!strFindAIvalue.equals("3203")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568931:
                                                        if (!strFindAIvalue.equals("3204")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568932:
                                                        if (!strFindAIvalue.equals("3205")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568933:
                                                        if (!strFindAIvalue.equals("3206")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568934:
                                                        if (!strFindAIvalue.equals("3207")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568935:
                                                        if (!strFindAIvalue.equals("3208")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    case 1568936:
                                                        if (!strFindAIvalue.equals("3209")) {
                                                            map.put(strFindAIvalue, strFindValue);
                                                        } else {
                                                            strSubstring = strFindAIvalue.substring(3);
                                                            str9 = ExpandedProductParsedResult.POUND;
                                                            str8 = strFindValue;
                                                        }
                                                        break;
                                                    default:
                                                        switch (strFindAIvalue) {
                                                            case 1575716:
                                                                if (!strFindAIvalue.equals("3920")) {
                                                                    map.put(strFindAIvalue, strFindValue);
                                                                } else {
                                                                    strSubstring3 = strFindAIvalue.substring(3);
                                                                    strSubstring2 = strFindValue;
                                                                }
                                                                break;
                                                            case 1575717:
                                                                if (!strFindAIvalue.equals("3921")) {
                                                                    map.put(strFindAIvalue, strFindValue);
                                                                } else {
                                                                    strSubstring3 = strFindAIvalue.substring(3);
                                                                    strSubstring2 = strFindValue;
                                                                }
                                                                break;
                                                            case 1575718:
                                                                if (!strFindAIvalue.equals("3922")) {
                                                                    map.put(strFindAIvalue, strFindValue);
                                                                } else {
                                                                    strSubstring3 = strFindAIvalue.substring(3);
                                                                    strSubstring2 = strFindValue;
                                                                }
                                                                break;
                                                            case 1575719:
                                                                if (!strFindAIvalue.equals("3923")) {
                                                                    map.put(strFindAIvalue, strFindValue);
                                                                } else {
                                                                    strSubstring3 = strFindAIvalue.substring(3);
                                                                    strSubstring2 = strFindValue;
                                                                }
                                                                break;
                                                            default:
                                                                switch (iHashCode) {
                                                                    case 1575747:
                                                                        if (!strFindAIvalue.equals("3930")) {
                                                                            map.put(strFindAIvalue, strFindValue);
                                                                        } else {
                                                                            if (strFindValue.length() < 4) {
                                                                                return null;
                                                                            }
                                                                            strSubstring2 = strFindValue.substring(3);
                                                                            strSubstring4 = strFindValue.substring(0, 3);
                                                                            strSubstring3 = strFindAIvalue.substring(3);
                                                                        }
                                                                        break;
                                                                    case 1575748:
                                                                        if (!strFindAIvalue.equals("3931")) {
                                                                            map.put(strFindAIvalue, strFindValue);
                                                                        } else {
                                                                            if (strFindValue.length() < 4) {
                                                                                return null;
                                                                            }
                                                                            strSubstring2 = strFindValue.substring(3);
                                                                            strSubstring4 = strFindValue.substring(0, 3);
                                                                            strSubstring3 = strFindAIvalue.substring(3);
                                                                        }
                                                                        break;
                                                                    case 1575749:
                                                                        if (!strFindAIvalue.equals("3932")) {
                                                                            map.put(strFindAIvalue, strFindValue);
                                                                        } else {
                                                                            if (strFindValue.length() < 4) {
                                                                                return null;
                                                                            }
                                                                            strSubstring2 = strFindValue.substring(3);
                                                                            strSubstring4 = strFindValue.substring(0, 3);
                                                                            strSubstring3 = strFindAIvalue.substring(3);
                                                                        }
                                                                        break;
                                                                    case 1575750:
                                                                        if (!strFindAIvalue.equals("3933")) {
                                                                            map.put(strFindAIvalue, strFindValue);
                                                                        } else {
                                                                            if (strFindValue.length() < 4) {
                                                                                return null;
                                                                            }
                                                                            strSubstring2 = strFindValue.substring(3);
                                                                            strSubstring4 = strFindValue.substring(0, 3);
                                                                            strSubstring3 = strFindAIvalue.substring(3);
                                                                        }
                                                                        break;
                                                                    default:
                                                                        map.put(strFindAIvalue, strFindValue);
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                        }
                                    } else if (strFindAIvalue.equals(BaseWrapper.ENTER_ID_17)) {
                                        str7 = strFindValue;
                                    } else {
                                        map.put(strFindAIvalue, strFindValue);
                                    }
                                } else if (strFindAIvalue.equals("15")) {
                                    str6 = strFindValue;
                                } else {
                                    map.put(strFindAIvalue, strFindValue);
                                }
                            } else if (strFindAIvalue.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                                str5 = strFindValue;
                            } else {
                                map.put(strFindAIvalue, strFindValue);
                            }
                        } else if (strFindAIvalue.equals("11")) {
                            str4 = strFindValue;
                        } else {
                            map.put(strFindAIvalue, strFindValue);
                        }
                    } else if (strFindAIvalue.equals("10")) {
                        str3 = strFindValue;
                    } else {
                        map.put(strFindAIvalue, strFindValue);
                    }
                } else if (strFindAIvalue.equals("01")) {
                    str = strFindValue;
                } else {
                    map.put(strFindAIvalue, strFindValue);
                }
            } else if (strFindAIvalue.equals("00")) {
                str2 = strFindValue;
            } else {
                map.put(strFindAIvalue, strFindValue);
            }
            i = length2;
            massagedText = str10;
            expandedProductParsedResult = null;
        }
        return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, strSubstring2, strSubstring3, strSubstring4, map);
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String strSubstring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == '(') {
                if (findAIvalue(i2, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}

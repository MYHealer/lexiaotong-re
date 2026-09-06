package com.opos.exoplayer.core.f.f;

import android.text.Layout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.opos.exoplayer.core.i.g;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.i.z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.opos.exoplayer.core.f.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6442a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C0925a e = new C0925a(30.0f, 1, 1);
    private final XmlPullParserFactory f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.f.f.a$a, reason: collision with other inner class name */
    private static final class C0925a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f6443a;
        final int b;
        final int c;

        C0925a(float f, int i, int i2) {
            this.f6443a = f;
            this.b = i;
            this.c = i2;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private static long a(String str, C0925a c0925a) throws com.opos.exoplayer.core.f.f {
        double d2;
        double d3;
        Matcher matcher = f6442a.matcher(str);
        if (matcher.matches()) {
            double d4 = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
            String strGroup = matcher.group(4);
            double d5 = d4 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d6 = d5 + (strGroup2 != null ? Long.parseLong(strGroup2) / c0925a.f6443a : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d6 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) c0925a.b)) / ((double) c0925a.f6443a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = b.matcher(str);
        if (!matcher2.matches()) {
            throw new com.opos.exoplayer.core.f.f("Malformed time expression: " + str);
        }
        double d7 = Double.parseDouble(matcher2.group(1));
        String strGroup4 = matcher2.group(2);
        strGroup4.hashCode();
        switch (strGroup4) {
            case "f":
                d2 = c0925a.f6443a;
                d7 /= d2;
                return (long) (d7 * 1000000.0d);
            case "h":
                d3 = 3600.0d;
                break;
            case "m":
                d3 = 60.0d;
                break;
            case "t":
                d2 = c0925a.c;
                d7 /= d2;
                return (long) (d7 * 1000000.0d);
            case "ms":
                d2 = 1000.0d;
                d7 /= d2;
                return (long) (d7 * 1000000.0d);
            default:
                return (long) (d7 * 1000000.0d);
        }
        d7 *= d3;
        return (long) (d7 * 1000000.0d);
    }

    private C0925a a(XmlPullParser xmlPullParser) throws com.opos.exoplayer.core.f.f {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split(PPSLabelView.Code);
            if (strArrSplit.length != 2) {
                throw new com.opos.exoplayer.core.f.f("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        } else {
            f = 1.0f;
        }
        C0925a c0925a = e;
        int i2 = c0925a.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = c0925a.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new C0925a(i * f, i2, i3);
    }

    private b a(b bVar) {
        return bVar == null ? new b() : bVar;
    }

    private b a(XmlPullParser xmlPullParser, b bVar) {
        StringBuilder sb;
        b bVarA;
        Layout.Alignment alignment;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "fontStyle":
                    bVar = a(bVar).d(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    continue;
                    break;
                case "fontFamily":
                    bVar = a(bVar).a(attributeValue);
                    continue;
                    break;
                case "textAlign":
                    String strD = y.d(attributeValue);
                    strD.hashCode();
                    switch (strD) {
                        case "center":
                            bVarA = a(bVar);
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case "end":
                        case "right":
                            bVarA = a(bVar);
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case "left":
                        case "start":
                            bVarA = a(bVar);
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                        default:
                            continue;
                            break;
                    }
                    bVar = bVarA.a(alignment);
                    continue;
                    break;
                case "textDecoration":
                    String strD2 = y.d(attributeValue);
                    strD2.hashCode();
                    switch (strD2) {
                        case "nounderline":
                            bVar = a(bVar).b(false);
                            break;
                        case "underline":
                            bVar = a(bVar).b(true);
                            break;
                        case "nolinethrough":
                            bVar = a(bVar).a(false);
                            break;
                        case "linethrough":
                            bVar = a(bVar).a(true);
                            continue;
                            break;
                    }
                    break;
                case "fontWeight":
                    bVar = a(bVar).c(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    continue;
                    break;
                case "id":
                    if ("style".equals(xmlPullParser.getName())) {
                        bVar = a(bVar).b(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case "color":
                    bVar = a(bVar);
                    try {
                        bVar.a(g.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused) {
                        sb = new StringBuilder("Failed parsing color value: ");
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.append(attributeValue).toString());
                    }
                    break;
                case "fontSize":
                    try {
                        bVar = a(bVar);
                        a(attributeValue, bVar);
                        continue;
                    } catch (com.opos.exoplayer.core.f.f unused2) {
                        sb = new StringBuilder("Failed parsing fontSize value: ");
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.append(attributeValue).toString());
                    }
                    break;
                case "backgroundColor":
                    bVar = a(bVar);
                    try {
                        bVar.b(g.a(attributeValue));
                        continue;
                    } catch (IllegalArgumentException unused3) {
                        sb = new StringBuilder("Failed parsing background value: ");
                        com.opos.cmn.an.f.a.c("TtmlDecoder", sb.append(attributeValue).toString());
                    }
                    break;
                default:
                    continue;
                    break;
            }
            com.opos.cmn.an.f.a.c("TtmlDecoder", sb.append(attributeValue).toString());
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c8  */
    private c a(XmlPullParser xmlPullParser, c cVar, Map<String, d> map, C0925a c0925a) throws com.opos.exoplayer.core.f.f {
        long j;
        int attributeCount = xmlPullParser.getAttributeCount();
        b bVarA = a(xmlPullParser, (b) null);
        String[] strArr = null;
        long jA = -9223372036854775807L;
        long jA2 = -9223372036854775807L;
        long jA3 = -9223372036854775807L;
        String str = "";
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    jA3 = a(attributeValue, c0925a);
                    break;
                case "end":
                    jA2 = a(attributeValue, c0925a);
                    break;
                case "begin":
                    jA = a(attributeValue, c0925a);
                    break;
                case "style":
                    String[] strArrA = a(attributeValue);
                    if (strArrA.length > 0) {
                        strArr = strArrA;
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j2 = cVar.d;
            if (j2 != -9223372036854775807L) {
                if (jA != -9223372036854775807L) {
                    jA += j2;
                }
                if (jA2 != -9223372036854775807L) {
                    jA2 += cVar.d;
                }
            }
        }
        if (jA2 != -9223372036854775807L) {
            j = jA2;
        } else if (jA3 != -9223372036854775807L) {
            j = jA + jA3;
        } else if (cVar != null) {
            long j3 = cVar.e;
            if (j3 != -9223372036854775807L) {
                j = j3;
            } else {
                j = jA2;
            }
        } else {
            j = jA2;
        }
        return c.a(xmlPullParser.getName(), jA, j, bVarA, strArr, str);
    }

    private Map<String, b> a(XmlPullParser xmlPullParser, Map<String, b> map, Map<String, d> map2) throws XmlPullParserException, IOException {
        d dVarB;
        do {
            xmlPullParser.next();
            if (z.b(xmlPullParser, "style")) {
                String strC = z.c(xmlPullParser, "style");
                b bVarA = a(xmlPullParser, new b());
                if (strC != null) {
                    for (String str : a(strC)) {
                        bVarA.a(map.get(str));
                    }
                }
                if (bVarA.i() != null) {
                    map.put(bVarA.i(), bVarA);
                }
            } else if (z.b(xmlPullParser, "region") && (dVarB = b(xmlPullParser)) != null) {
                map2.put(dVarB.f6446a, dVarB);
            }
        } while (!z.a(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void a(String str, b bVar) throws com.opos.exoplayer.core.f.f {
        Matcher matcher;
        String[] strArrSplit = str.split("\\s+");
        if (strArrSplit.length == 1) {
            matcher = c.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new com.opos.exoplayer.core.f.f("Invalid number of entries for fontSize: " + strArrSplit.length + ".");
            }
            matcher = c.matcher(strArrSplit[1]);
            com.opos.cmn.an.f.a.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new com.opos.exoplayer.core.f.f("Invalid expression for fontSize: '" + str + "'.");
        }
        String strGroup = matcher.group(3);
        strGroup.hashCode();
        switch (strGroup) {
            case "%":
                bVar.c(3);
                break;
            case "em":
                bVar.c(2);
                break;
            case "px":
                bVar.c(1);
                break;
            default:
                throw new com.opos.exoplayer.core.f.f("Invalid unit for fontSize: '" + strGroup + "'.");
        }
        bVar.a(Float.valueOf(matcher.group(1)).floatValue());
    }

    private String[] a(String str) {
        return str.split("\\s+");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0083  */
    private d b(XmlPullParser xmlPullParser) {
        String string;
        StringBuilder sb;
        float f;
        String strC = z.c(xmlPullParser, "id");
        if (strC == null) {
            return null;
        }
        String strC2 = z.c(xmlPullParser, "origin");
        if (strC2 != null) {
            Pattern pattern = d;
            Matcher matcher = pattern.matcher(strC2);
            if (matcher.matches()) {
                int i = 1;
                try {
                    float f2 = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float f3 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String strC3 = z.c(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
                    if (strC3 != null) {
                        Matcher matcher2 = pattern.matcher(strC3);
                        if (matcher2.matches()) {
                            try {
                                float f4 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float f5 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String strC4 = z.c(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                if (strC4 != null) {
                                    String strD = y.d(strC4);
                                    strD.hashCode();
                                    if (strD.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                                        f = f3 + f5;
                                        i = 2;
                                    } else {
                                        if (strD.equals(TtmlNode.CENTER)) {
                                            f3 += f5 / 2.0f;
                                        } else {
                                            i = 0;
                                        }
                                        f = f3;
                                    }
                                } else {
                                    i = 0;
                                    f = f3;
                                }
                                return new d(strC, f2, f, 0, i, f4);
                            } catch (NumberFormatException unused) {
                                sb = new StringBuilder("Ignoring region with malformed extent: ");
                            }
                        } else {
                            sb = new StringBuilder("Ignoring region with unsupported extent: ");
                        }
                    } else {
                        string = "Ignoring region without an extent";
                    }
                } catch (NumberFormatException unused2) {
                    sb = new StringBuilder("Ignoring region with malformed origin: ");
                }
            } else {
                sb = new StringBuilder("Ignoring region with unsupported origin: ");
            }
            string = sb.append(strC2).toString();
        } else {
            string = "Ignoring region without an origin";
        }
        com.opos.cmn.an.f.a.c("TtmlDecoder", string);
        return null;
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals("p") || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(byte[] bArr, int i, boolean z) throws com.opos.exoplayer.core.f.f {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            f fVar = null;
            map2.put("", new d(null));
            int i2 = 0;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            LinkedList linkedList = new LinkedList();
            C0925a c0925aA = e;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                c cVar = (c) linkedList.peekLast();
                if (i2 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            c0925aA = a(xmlPullParserNewPullParser);
                        }
                        if (!b(name)) {
                            com.opos.cmn.an.f.a.a("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        } else if (TtmlNode.TAG_HEAD.equals(name)) {
                            a(xmlPullParserNewPullParser, map, map2);
                        } else {
                            try {
                                c cVarA = a(xmlPullParserNewPullParser, cVar, map2, c0925aA);
                                linkedList.addLast(cVarA);
                                if (cVar != null) {
                                    cVar.a(cVarA);
                                }
                            } catch (com.opos.exoplayer.core.f.f e2) {
                                com.opos.cmn.an.f.a.c("TtmlDecoder", "Suppressing parser error", e2);
                                i2++;
                            }
                        }
                        i2++;
                    } else if (eventType == 4) {
                        cVar.a(c.a(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            fVar = new f((c) linkedList.getLast(), map, map2);
                        }
                        linkedList.removeLast();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                xmlPullParserNewPullParser.next();
            }
            return fVar;
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new com.opos.exoplayer.core.f.f("Unable to decode source", e4);
        }
    }
}

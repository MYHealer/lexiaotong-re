package com.yfanads.android.libs.thirdpart.lottie.parser;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class CircleShapeParser {
    private CircleShapeParser() {
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:40:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x005d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x006b -> B:35:0x006d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:41:0x005d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static com.yfanads.android.libs.thirdpart.lottie.model.content.CircleShape parse(android.util.JsonReader r9, com.yfanads.android.libs.thirdpart.lottie.LottieComposition r10, int r11) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            r3 = 3
            if (r11 != r3) goto La
            r11 = r2
            r4 = r11
            goto L6d
        La:
            r11 = r2
            r4 = r11
        Lc:
            r5 = r0
        Ld:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L6f
            java.lang.String r6 = r9.nextName()
            r6.getClass()
            r6.hashCode()
            int r7 = r6.hashCode()
            r8 = -1
            switch(r7) {
                case 100: goto L47;
                case 112: goto L3c;
                case 115: goto L31;
                case 3519: goto L26;
                default: goto L25;
            }
        L25:
            goto L51
        L26:
            java.lang.String r7 = "nm"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L2f
            goto L51
        L2f:
            r8 = r3
            goto L51
        L31:
            java.lang.String r7 = "s"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L3a
            goto L51
        L3a:
            r8 = 2
            goto L51
        L3c:
            java.lang.String r7 = "p"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L45
            goto L51
        L45:
            r8 = r1
            goto L51
        L47:
            java.lang.String r7 = "d"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L50
            goto L51
        L50:
            r8 = r0
        L51:
            switch(r8) {
                case 0: goto L67;
                case 1: goto L62;
                case 2: goto L5d;
                case 3: goto L58;
                default: goto L54;
            }
        L54:
            r9.skipValue()
            goto Ld
        L58:
            java.lang.String r2 = r9.nextString()
            goto Ld
        L5d:
            com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue r4 = com.yfanads.android.libs.thirdpart.lottie.parser.AnimatableValueParser.parsePoint(r9, r10)
            goto Ld
        L62:
            com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue r11 = com.yfanads.android.libs.thirdpart.lottie.parser.AnimatablePathValueParser.parseSplitPath(r9, r10)
            goto Ld
        L67:
            int r5 = r9.nextInt()
            if (r5 != r3) goto Lc
        L6d:
            r5 = r1
            goto Ld
        L6f:
            com.yfanads.android.libs.thirdpart.lottie.model.content.CircleShape r9 = new com.yfanads.android.libs.thirdpart.lottie.model.content.CircleShape
            r9.<init>(r2, r11, r4, r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yfanads.android.libs.thirdpart.lottie.parser.CircleShapeParser.parse(android.util.JsonReader, com.yfanads.android.libs.thirdpart.lottie.LottieComposition, int):com.yfanads.android.libs.thirdpart.lottie.model.content.CircleShape");
    }
}

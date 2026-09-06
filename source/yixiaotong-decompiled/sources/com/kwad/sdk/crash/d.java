package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static final double bdZ = Runtime.getRuntime().maxMemory();
    public static final Pattern bea = Pattern.compile("/data/user");
    public static final Pattern beb = Pattern.compile("/data");
    public static final Pattern bec = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern bed = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int bee = 10;
    public static String bef = "sessionId";
}

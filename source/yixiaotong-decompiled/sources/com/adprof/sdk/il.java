package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class il {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static hl f1235a;
    public static hl b;
    public static hl c;

    public static synchronized hl a(String str) {
        byte b2;
        int iHashCode = str.hashCode();
        if (iHashCode != -654234114) {
            if (iHashCode != 140814288) {
                b2 = (iHashCode == 362664118 && str.equals("loc_service")) ? (byte) 2 : (byte) -1;
            } else if (str.equals("appinstall_service")) {
                b2 = 1;
            }
        } else if (str.equals("download_service")) {
            b2 = 0;
        }
        if (b2 == 0) {
            hl hlVar = c;
            if (hlVar != null) {
                return hlVar;
            }
            r8 r8Var = new r8();
            c = r8Var;
            return r8Var;
        }
        if (b2 == 1) {
            hl hlVar2 = b;
            if (hlVar2 != null) {
                return hlVar2;
            }
            p3 p3Var = new p3();
            b = p3Var;
            return p3Var;
        }
        if (b2 != 2) {
            return null;
        }
        hl hlVar3 = f1235a;
        if (hlVar3 != null) {
            return hlVar3;
        }
        zd zdVar = new zd();
        f1235a = zdVar;
        return zdVar;
    }

    public static void a(String str, boolean z) {
        hl hlVar;
        str.hashCode();
        switch (str) {
            case "download_service":
                if (!z) {
                    hlVar = c;
                    if (hlVar == null) {
                        return;
                    }
                    hlVar.mo737a();
                    return;
                }
                break;
            case "appinstall_service":
                if (!z) {
                    hlVar = b;
                    if (hlVar == null) {
                        return;
                    }
                    hlVar.mo737a();
                    return;
                }
                break;
            case "loc_service":
                if (z) {
                    a(str).mo652a();
                } else {
                    hl hlVar2 = f1235a;
                    if (hlVar2 != null) {
                        hlVar2.mo737a();
                    }
                }
                he.m644a().getClass();
                return;
            default:
                return;
        }
        a(str).mo652a();
    }
}

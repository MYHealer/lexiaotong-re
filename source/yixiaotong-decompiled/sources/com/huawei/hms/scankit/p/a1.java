package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f4211a;
    public static final a1 b;
    public static final a1 c;
    public static final a1 d;
    public static final a1 e;
    public static final a1 f;
    public static final a1 g;
    public static final a1 h;
    private static final /* synthetic */ a1[] i;

    /* JADX INFO: compiled from: DataMask.java */
    final enum a extends a1 {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.huawei.hms.scankit.p.a1
        boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f4211a = aVar;
        a1 a1Var = new a1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.a1.b
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        b = a1Var;
        a1 a1Var2 = new a1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.a1.c
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        c = a1Var2;
        a1 a1Var3 = new a1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.a1.d
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        d = a1Var3;
        a1 a1Var4 = new a1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.a1.e
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        e = a1Var4;
        a1 a1Var5 = new a1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.a1.f
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f = a1Var5;
        a1 a1Var6 = new a1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.a1.g
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        g = a1Var6;
        a1 a1Var7 = new a1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.a1.h
            {
                a aVar2 = null;
            }

            @Override // com.huawei.hms.scankit.p.a1
            boolean a(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        h = a1Var7;
        i = new a1[]{aVar, a1Var, a1Var2, a1Var3, a1Var4, a1Var5, a1Var6, a1Var7};
    }

    private a1(String str, int i2) {
        super(str, i2);
    }

    public static a1 valueOf(String str) {
        return (a1) Enum.valueOf(a1.class, str);
    }

    public static a1[] values() {
        return (a1[]) i.clone();
    }

    final void a(s sVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    sVar.a(i4, i3);
                }
            }
        }
    }

    abstract boolean a(int i2, int i3);

    /* synthetic */ a1(String str, int i2, a aVar) {
        this(str, i2);
    }
}

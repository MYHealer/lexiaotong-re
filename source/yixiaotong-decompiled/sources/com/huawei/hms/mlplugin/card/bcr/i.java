package com.huawei.hms.mlplugin.card.bcr;

/* JADX INFO: compiled from: AbstractBankIIN.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class i implements m {
    private boolean d(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String string = new StringBuffer(str).reverse().toString();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < string.length(); i3++) {
            int iDigit = Character.digit(string.charAt(i3), 10);
            if (i3 % 2 == 0) {
                i += iDigit;
            } else {
                i2 += iDigit * 2;
                if (iDigit >= 5) {
                    i2 -= 9;
                }
            }
        }
        return (i + i2) % 10 == 0;
    }

    abstract String a();

    @Override // com.huawei.hms.mlplugin.card.bcr.m
    public String a(String str) {
        if (!a((CharSequence) str) && b(str) && d(str) && c(str)) {
            return a();
        }
        return null;
    }

    abstract boolean b(String str);

    abstract boolean c(String str);

    private static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}

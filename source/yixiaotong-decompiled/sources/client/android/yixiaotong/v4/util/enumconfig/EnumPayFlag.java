package client.android.yixiaotong.v4.util.enumconfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum EnumPayFlag {
    WEIXIN("微信", 1),
    ZFB("支付宝", 2),
    WALLET("余额支付", 3);

    private String des;
    private int value;

    public String getDes() {
        return this.des;
    }

    public int getValue() {
        return this.value;
    }

    EnumPayFlag(String str, int i) {
        this.des = str;
        this.value = i;
    }

    public static EnumPayFlag getByValue(int i) {
        for (EnumPayFlag enumPayFlag : values()) {
            if (enumPayFlag.getValue() == i) {
                return enumPayFlag;
            }
        }
        return null;
    }

    public static EnumPayFlag getByDes(String str) {
        for (EnumPayFlag enumPayFlag : values()) {
            if (enumPayFlag.getDes().equals(str)) {
                return enumPayFlag;
            }
        }
        return null;
    }

    public static boolean containsValue(int i) {
        for (EnumPayFlag enumPayFlag : values()) {
            if (enumPayFlag.getValue() == i) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.des + "(" + this.value + ")";
    }
}

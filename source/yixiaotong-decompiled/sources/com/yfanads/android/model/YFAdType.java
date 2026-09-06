package com.yfanads.android.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum YFAdType {
    NONE(0),
    CUSTOM(-111),
    SPLASH(1),
    NATIV(2),
    INTR(3),
    BANNER(4),
    DRAW(5),
    FULL(6),
    REWARD(7),
    ROLL(8),
    MIXBANNER(9),
    TOPPUSH(10),
    SHOPMALL(11),
    TEXTLINK(12);

    private int type;

    YFAdType(int i) {
        setType(i);
    }

    public int getType() {
        return this.type;
    }

    public int getValue() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}

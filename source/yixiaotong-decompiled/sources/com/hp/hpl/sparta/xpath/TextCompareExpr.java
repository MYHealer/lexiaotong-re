package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class TextCompareExpr extends BooleanExpr {
    private final String value_;

    TextCompareExpr(String str) {
        this.value_ = str;
    }

    public String getValue() {
        return this.value_;
    }

    protected String toString(String str) {
        return new StringBuffer("[text()").append(str).append("'").append(this.value_).append("']").toString();
    }
}

package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class AttrExpr extends BooleanExpr {
    private final String attrName_;

    AttrExpr(String str) {
        this.attrName_ = str;
    }

    public String getAttrName() {
        return this.attrName_;
    }

    public String toString() {
        return new StringBuffer("@").append(this.attrName_).toString();
    }
}

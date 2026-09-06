package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AttrTest extends NodeTest {
    private final String attrName_;

    AttrTest(String str) {
        this.attrName_ = str;
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getAttrName() {
        return this.attrName_;
    }

    @Override // com.hp.hpl.sparta.xpath.NodeTest
    public boolean isStringValue() {
        return true;
    }

    public String toString() {
        return new StringBuffer("@").append(this.attrName_).toString();
    }
}

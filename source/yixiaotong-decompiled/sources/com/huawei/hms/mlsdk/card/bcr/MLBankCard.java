package com.huawei.hms.mlsdk.card.bcr;

import android.graphics.Bitmap;
import android.graphics.Point;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MLBankCard {
    public static final int BORDER_TYPE_EXPIRE = 2;
    public static final int BORDER_TYPE_ISSUER = 3;
    public static final int BORDER_TYPE_NUMBER = 1;
    public static final int BORDER_TYPE_OWNER = 4;
    public static final int FAILURE = 1;
    public static final int STATUS_TIPS_ANGLE = -1;
    public static final int STATUS_TIPS_ILLUMINATION = -2;
    public static final int STATUS_TIPS_SUCCESS = 0;
    public static final int SUCCESS = 0;
    private Map<Integer, Point[]> border;
    private Bitmap correct;
    private String expire;
    private String issuer;
    private String number;
    private Bitmap numberBitmap;
    private String organization;
    private Bitmap original;
    private String owner;
    private int retCode;
    private int tipsCode;
    private String type;

    public Bitmap getCorrectBitmap() {
        return this.correct;
    }

    public String getExpire() {
        return this.expire;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getNumber() {
        return this.number;
    }

    public Bitmap getNumberBitmap() {
        return this.numberBitmap;
    }

    public String getOrganization() {
        return this.organization;
    }

    public Bitmap getOriginalBitmap() {
        return this.original;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getTipsCode() {
        return this.tipsCode;
    }

    public String getType() {
        return this.type;
    }

    public void setCorrectBitmap(Bitmap bitmap) {
        this.correct = bitmap;
    }

    public void setExpire(String str) {
        this.expire = str;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setNumberBitmap(Bitmap bitmap) {
        this.numberBitmap = bitmap;
    }

    public void setOrganization(String str) {
        this.organization = str;
    }

    public void setOriginalBitmap(Bitmap bitmap) {
        this.original = bitmap;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public void setTipsCode(int i) {
        this.tipsCode = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public MLBankCard() {
        this.border = new HashMap();
        this.retCode = 1;
    }

    public MLBankCard(int i, String str, String str2, String str3, Bitmap bitmap, String str4, Bitmap bitmap2) {
        this.border = new HashMap();
        this.retCode = i;
        this.number = str;
        this.expire = str2;
        this.owner = str3;
        this.organization = str4;
        this.original = bitmap;
        this.numberBitmap = bitmap2;
    }

    public Point[] getBorder(int i) {
        return this.border.get(Integer.valueOf(i));
    }

    public void addBorder(int i, Point[] pointArr) {
        this.border.put(Integer.valueOf(i), pointArr);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.number);
        stringBuffer.append(", ");
        stringBuffer.append(this.expire);
        return stringBuffer.toString();
    }
}

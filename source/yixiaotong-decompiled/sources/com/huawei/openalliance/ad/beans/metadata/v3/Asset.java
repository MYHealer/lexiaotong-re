package com.huawei.openalliance.ad.beans.metadata.v3;

import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Data;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Image;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Title;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Video;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Asset implements Serializable {
    private static final long serialVersionUID = 5132069519973155133L;
    private String alias;
    private String context;
    private Data data;
    private String filePath;
    private int id;
    private Image img;
    private int seq;
    private Title title;
    private String type;
    private Video video;

    public Video B() {
        return this.video;
    }

    public Title C() {
        return this.title;
    }

    public int Code() {
        return this.id;
    }

    public void Code(int i) {
        this.id = i;
    }

    public void Code(Data data) {
        this.data = data;
    }

    public void Code(Image image) {
        this.img = image;
    }

    public void Code(Title title) {
        this.title = title;
    }

    public void Code(Video video) {
        this.video = video;
    }

    public void Code(String str) {
        this.alias = str;
    }

    public String D() {
        return this.type;
    }

    public String F() {
        return this.context;
    }

    public Data I() {
        return this.data;
    }

    public void I(String str) {
        this.context = str;
    }

    public int L() {
        return this.seq;
    }

    public String S() {
        return this.filePath;
    }

    public String V() {
        return this.alias;
    }

    public void V(int i) {
        this.seq = i;
    }

    public void V(String str) {
        this.filePath = str;
    }

    public Image Z() {
        return this.img;
    }

    public void Z(String str) {
        this.type = str;
    }
}

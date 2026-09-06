package client.android.yixiaotong.v4.http.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PaymentMethod {
    private int iconRes;
    private boolean isSelected = false;
    private String name;
    private int type;

    public int getIconRes() {
        return this.iconRes;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setIconRes(int i) {
        this.iconRes = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public V4PaymentMethod(String str, int i, int i2) {
        this.name = str;
        this.iconRes = i;
        this.type = i2;
    }
}

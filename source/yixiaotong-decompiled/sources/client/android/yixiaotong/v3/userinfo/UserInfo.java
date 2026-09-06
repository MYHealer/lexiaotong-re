package client.android.yixiaotong.v3.userinfo;

import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UserInfo {

    @Expose
    public List<SchoolInfosBean> schoolInfoList;

    @Expose
    public List<String> schoolList;

    @Expose
    public int studentGender;

    @Expose
    public String studentHex;

    @Expose
    public String studentId;

    @Expose
    public String studentIdentity;

    @Expose
    public String studentMobile;

    @Expose
    public String studentName;
}

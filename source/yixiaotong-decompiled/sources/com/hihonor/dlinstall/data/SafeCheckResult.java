package com.hihonor.dlinstall.data;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SafeCheckResult implements Serializable {
    public static String fraudAppCount = "fraud";
    public static String maliciousAppCount = "malicious";
    public static String riskAppCount = "risk";
    public static String scanAppCount = "scanApp";
    private static final long serialVersionUID = 1;
    public static String unknownAppCount = "unknown";
    public static String virusAppCount = "virus";
    public int grade;
    public List<Risk> riskList;

    public static class Risk implements Serializable {
        private static final long serialVersionUID = 1;
        public int riskAppCount;
        public String riskType;

        public String toString() {
            return "Risk{riskType='" + this.riskType + "', riskAppCount=" + this.riskAppCount + '}';
        }
    }

    public String toString() {
        return "SafeCheckResult{grade=" + this.grade + ", riskList=" + this.riskList + '}';
    }
}

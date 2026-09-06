package com.miui.zeus.mimo.sdk.diagnosis;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.b;
import ijiami_1011.s.s.s;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public enum DiagnosisStep {
    KEY_EXCEPTION_WHEN_INIT_MIMO_SDK { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.1
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.ESC, 6, 74, Ascii.CAN, -118, -52, -42, -116, -25, -10, -42, -42, -120, -48, -46, -117, -123, -8, -2, -116, -63, -63, -44, -29, -128}, "37c8bc");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return s.d(new byte[]{73, 9, 26, 16, -44, -67, -4, -127, -63, -23, -44, -23, -9, -35, -76, -118, -42, -69, -47, -127, -38, -32, -44, -35, -39, -41, -113, -68, -39, -102, -57, -126, -27, -25, -39, -62, -32, -41, -113, -86, 59}, "a83015") + str;
        }
    },
    KEY_FAIL_WHEN_LOAD_AD_NOT_INIT { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.2
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{Ascii.RS, 3, Ascii.FS, Ascii.ETB, -124, -40, -34, -127, -9, -24, -44, -17, -106, -38, -120, -118, -124, -59, -48, -116, -46, -57, Ascii.GS, 69, -34, -99, -109, -47, -30, -28, -119, -61, -25, -115, -115, -1, 101, 118, 126, -47, -3, -53, -124, -20, -5, -121, -106, -18, -45, -66, -93}, "6257aa");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.GS, 83, Ascii.FS, 68, -48, -113, -34, -127, -9, -24, -44, -17, -107, -118, -120, -39, -48, -119, -28, -115, -57, -39, -44, -7, -99, 49, 113, 47, -45, -86, -53, -127, -18, -1, -44, -62, -66, -121, -71, -14, -45, -66, -15, -127, -20, -3, -43, -36, -66, -121, -91, -22, -38, -118, -19, -116, -55, -43, -43, -34, -95, -123, -114, -30, -45, -72, -13, -126, -7, -57, -39, -30, -97, -121, -126, -43, -46, -84, -27, -128, -35, -63, -42, -59, -76}, "5b5d56");
        }
    },
    KEY_FAIL_WHEN_LOAD_AD_NOT_INIT_SUCCESS { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.3
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{17, 5, 17, 65, -46, -115, -34, -127, -9, -24, -44, -17, -103, -36, -123, -36, -46, -112, -48, -116, -46, -57, Ascii.GS, 69, -47, -101, -98, -121, -76, -79, -119, -61, -25, -115, -115, -1, 106, 112, 115, -121, -85, -98, -124, -20, -5, -121, -106, -18, -36, -72, -82, -121, -65, -92, -124, -18, -7}, "948a74");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{76, 3, 72, 66, -36, -97, -42, -126, -41, -32, -44, -36, -37, -41, -16, -24, -47, -113, -28, -115, -57, -39, -44, -7, -52, 97, 37, 41, -46, -84, -53, -127, -18, -1, -44, -62, -17, -41, -19, -12, -46, -72, -15, -127, -20, -3, -43, -36, -17, -41, -15, -20, -37, -116, -19, -116, -55, -43, -43, -34, -16, -43, -38, -28, -46, -66, -13, -126, -7, -57, -39, -30, -50, -41, -42, -45, -45, -86, -27, -128, -35, -63, -42, -59, -27}, "d2ab40");
        }
    },
    KEY_FAIL_WHEN_SHOW_AD_NOT_INIT { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.4
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{17, 4, Ascii.EM, 66, -35, -118, -34, -127, -9, -24, -44, -44, -84, -46, -108, -40, -35, -105, -48, -116, -46, -57, Ascii.GS, 69, -47, -102, -106, -124, -69, -74, -119, -61, -25, -115, -115, -1, 106, 113, 123, -124, -92, -103, -124, -20, -5, -121, -106, -18, -36, -71, -90}, "950b83");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{76, 1, 74, Ascii.SYN, -128, -120, -12, -125, -62, -40, -44, -36, -37, -43, -14, -68, -128, -122, -28, -115, -57, -39, -44, -7, -52, 99, 39, 125, -125, -91, -53, -127, -18, -1, -44, -62, -17, -43, -17, -96, -125, -79, -15, -127, -20, -3, -43, -36, -17, -43, -13, -72, -118, -123, -19, -116, -55, -43, -43, -34, -16, -41, -40, -80, -125, -73, -13, -126, -7, -57, -39, -30, -50, -43, -44, -121, -126, -93, -27, -128, -35, -63, -42, -59, -27}, "d0c6e9");
        }
    },
    KEY_FAIL_WHEN_SHOW_AD_NOT_INIT_SUCCESS { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.5
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{Ascii.RS, 0, 17, Ascii.EM, -127, -113, -34, -127, -9, -24, -44, -44, -93, -42, -100, -125, -127, -110, -48, -116, -46, -57, Ascii.GS, 69, -34, -98, -98, -33, -25, -77, -119, -61, -25, -115, -115, -1, 101, 117, 115, -33, -8, -100, -124, -20, -5, -121, -106, -18, -45, -67, -82, -33, -20, -90, -124, -18, -7}, "6189d6");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.CAN, 82, 72, Ascii.DC2, -45, -46, -12, -125, -62, -40, -44, -36, -113, -122, -16, -72, -45, -36, -28, -115, -57, -39, -44, -7, -104, 48, 37, 121, -48, -1, -53, -127, -18, -1, -44, -62, -69, -122, -19, -92, -48, -21, -15, -127, -20, -3, -43, -36, -69, -122, -15, -68, -39, -33, -19, -116, -55, -43, -43, -34, -92, -124, -38, -76, -48, -19, -13, -126, -7, -57, -39, -30, -102, -122, -42, -125, -47, -7, -27, -128, -35, -63, -42, -59, -79}, "0ca26c");
        }
    },
    KEY_EXCEPTION_WHEN_CREATE_AD_VIEW { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.6
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.RS, 7, Ascii.EM, 66, -37, -104, -42, -116, -25, -10, -42, -42, -115, -47, -127, -47, -44, -84, -2, -116, -63, -63, -44, -29, -123}, "660b37");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{Ascii.US, 82, 77, 70, -35, -128, -34, -127, -9, -24, -44, -44, -94, -124, -64, -36, -35, -99, -48, -116, -46, -57, Ascii.GS, 69, -46, -21, -1, -125, -125, -125, Ascii.ETB, 13, 3, Ascii.NAK, -44, -30, -115, -124, -22, -42, -34, -91, -53, -125, -7, -57, -44, -39, -75, -122, -36, -34}, "7cdf89") : s.d(new byte[]{Ascii.US, 7, Ascii.ESC, 68, -48, -114, -34, -127, -9, -24, -44, -44, -94, -47, -106, -34, -48, -109, -48, -116, -46, -57, Ascii.GS, 69, -46, -66, -87, -127, -114, -115, Ascii.ETB, 13, 3, Ascii.NAK, -44, -39, -75, -45, -118, -36, Ascii.EM, Ascii.ETB, -119, -53, -64, -124, -78, -32, -33, -111, -77, -117, -119, -83, 107}, "762d57") + str;
        }
    },
    KEY_EXCEPTION_WHEN_CREATE_ACTIVITY { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.7
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.US, 5, Ascii.ESC, Ascii.SYN, -115, -100, -42, -116, -25, -10, -42, -42, -116, -45, -125, -123, -126, -88, -2, -116, -63, -63, -44, -29, -124}, "7426e3");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{78, 4, 17, Ascii.DC2, -42, -113, -34, -127, -9, -24, -44, -44, -13, -46, -100, -120, -42, -110, -48, -116, -46, -57, Ascii.GS, 69, -125, -91, -105, -41, -71, -98, 32, 7, Ascii.DC2, 11, 71, 12, Ascii.DC2, 76, -35, -75, -119, -47, -17, -44, -128, -2, -101, -126, -7, -112, -35, -114, -79, -45, -39, -36}, "f58236") : s.d(new byte[]{17, 9, Ascii.RS, 69, -121, -115, -34, -127, -9, -24, -44, -44, -84, -33, -109, -33, -121, -112, -48, -116, -46, -57, Ascii.GS, 69, -36, -88, -104, -128, -24, -100, 32, 7, Ascii.DC2, 11, 71, 12, 77, 65, -46, -30, -40, -45, -17, -44, -125, -34, -77, -128, -127, -128, Ascii.ESC, 69, -118, -101, -57, -126, -27, -25, -39, -62, -72, -41, -117, -1, 104}, "987eb4") + str;
        }
    },
    KEY_EXCEPTION_WHEN_SHOW_AD { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.8
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason(int i, String str) {
            return b.a(i, str, 1);
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 2;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest(int i) {
            return b.a(i);
        }
    },
    KEY_EXCEPTION_WHEN_START_AD_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.9
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.CAN, 7, 76, 67, -116, -102, -42, -116, -25, -10, -42, -42, -117, -47, -44, -48, -125, -82, -2, -116, -63, -63, -44, -29, -125}, "06ecd5");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{Ascii.GS, 7, 75, 69, -35, -33, -34, -127, -9, -24, -39, -54, -126, -48, -45, -25, -35, -62, -48, -116, -46, -57, Ascii.GS, 69, -48, -90, -51, -128, -78, -50, -121, -13, -48, -121, -74, -33, -46, -72, -46, -127, -126, -32, -121, -8, -52, -123, -82, -64, -48, -118, -32, -128, -128, -34}, "56be8f") : s.d(new byte[]{75, 1, 76, 67, -46, -118, -34, -127, -9, -24, -39, -54, -44, -42, -44, -31, -46, -105, -48, -116, -46, -57, Ascii.GS, 69, -122, -96, -54, -122, -67, -101, -121, -13, -48, -121, -74, -33, -124, -66, -43, -121, -115, -75, -124, -40, -28, -121, -119, -35, 79, 16, -115, -52, -111, -43, -30, -31, -114, -59, -80, -118, -33, -86, 111}, "c0ec73") + str;
        }
    },
    KEY_FAIL_WHEN_NO_NETWORK { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.10
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{77, 6, Ascii.RS, Ascii.DC4, -35, -115, -34, -127, -9, -24, -39, -54, -46, -47, -122, -74, -35, -112, -48, -116, -46, -57, Ascii.GS, 69, -115, -104, -111, -46, -69, -79, -119, -61, -25, -115, -115, -1, -125, -96, -105, -47, -73, -101, -122, -16, -50, -123, -116, -12, -126, -116, -85}, "e77484");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.GS, 0, Ascii.US, Ascii.ETB, -126, -108, -31, -126, -7, -57, -42, -40, -92, -42, -115, -85, -126, -81, -50, -127, -10, -60, -41, -20, -90, -44, -118, -73, 110}, "5167d7") + s.d(new byte[]{76, 2, Ascii.CAN, 17, -46, -111, -31, -126, -7, -57, -42, -40, -11, -41, -118, -83, -46, -86, -50, -127, -10, -60, -44, -39, -28, -43, -95, -98, -48, -119, -62, -125, -10, -28, -34, -39, -24, -40, -98, -122, -47, -73, -46, -115, -15, -49, -43, -34, -57, -41, -95, -73, -46, -70, -9, -127, -18, -27, -41, -24, -58, -42, -71, -95, -45, -107, -38, -127, -20, -54, -42, -40, -11, -41, -118, -83, -48, -117, -22, -127, -10, -20, -44, -29, -23, -42, -124, -70, -36, -99, -12, 110}, "d01142");
        }
    },
    KEY_EXCEPTION_WHEN_EXECUTE_AD_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.11
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{16, 6, 77, 17, -39, -102, -42, -116, -25, -10, -42, -42, -125, -48, -43, -126, -42, -82, -2, -116, -63, -63, -44, -29, -117}, "87d115");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{Ascii.ESC, 3, 76, Ascii.DC4, -122, -36, -34, -127, -9, -24, -39, -54, -124, -44, -44, -74, -122, -63, -48, -116, -46, -57, Ascii.GS, 69, -43, -69, -62, -36, -62, -23, -121, -13, -48, -121, -74, -33, -44, -68, -43, -48, -39, -29, -121, -8, -52, -123, -82, -64, -42, -114, -25, -47, -37, -35}, "32e4ce") : s.d(new byte[]{75, 7, 77, 70, -48, -40, -34, -127, -9, -24, -39, -54, -44, -48, -43, -28, -48, -59, -48, -116, -46, -57, Ascii.GS, 69, -123, -65, -61, -114, -108, -19, -121, -13, -48, -121, -74, -33, -124, -72, -44, -126, -113, -25, -124, -40, -28, -121, -119, -35, 79, Ascii.SYN, -116, -55, -109, -121, -30, -31, -114, -59, -80, -118, -33, -84, 110}, "c6df5a") + str;
        }
    },
    KEY_EXCEPTION_WHEN_BUILD_AD_HTTP_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.12
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.FS, 87, 79, Ascii.CAN, -125, -109, -31, -126, -7, -57, -42, -40, -91, -127, -35, -92, -125, -88, -50, -127, -10, -60, -41, -20, -89, -125, -38, -72, 111}, "4ff8e0") + s.d(new byte[]{Ascii.EM, 7, 77, Ascii.EM, -47, -101, -31, -126, -7, -57, -42, -40, -96, -46, -33, -91, -47, -96, -50, -127, -10, -60, -44, -39, -79, -48, -12, -106, -45, -125, -62, -125, -10, -28, -34, -39, -67, -35, -53, -114, -46, -67, -46, -115, -15, -49, -43, -34, -110, -46, -12, -65, -47, -80, -9, -127, -18, -27, -41, -24, -109, -45, -20, -87, -48, -97, -38, -127, -20, -54, -42, -40, -96, -46, -33, -91, -45, -127, -22, -127, -10, -20, -44, -29, -68, -45, -47, -78, -33, -105, -12, 110}, "15d978");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{Ascii.RS, 80, 77, 69, -43, -117, -34, -127, -9, -24, -39, -54, -127, -121, -43, -25, -43, -106, -48, -116, -46, -57, Ascii.GS, 69, -48, -1, -32, -128, -117, -120, 41, 16, Ascii.DC2, Ascii.DC2, 99, 0, 71, Ascii.DC4, 1, Ascii.SYN, 68, -44, -10, -46, -125, -27, -117, -126, -72, -47, -127, -39, -78, -41, -39, -36}, "6ade02") : s.d(new byte[]{73, 2, Ascii.ESC, 19, -127, -119, -34, -127, -9, -24, -39, -54, -42, -43, -125, -79, -127, -108, -48, -116, -46, -57, Ascii.GS, 69, -121, -83, -74, -42, -33, -118, 41, 16, Ascii.DC2, Ascii.DC2, 99, 0, 16, 70, 87, SignedBytes.MAX_POWER_OF_TWO, 16, -42, -10, -46, -125, -27, -117, -126, -17, -125, -41, -113, -26, -43, -39, -36, 74, 66, -39, -54, -57, -43, -79, -74, -116, -105, -32, -117, -38, -8, 59}, "a323d0") + str;
        }
    },
    KEY_EXCEPTION_WHEN_BUILD_DOWNLOAD_HTTP_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.13
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{75, 6, 72, Ascii.DC2, -45, -111, -31, -126, -7, -57, -42, -40, -14, -48, -38, -82, -45, -86, -50, -127, -10, -60, -41, -20, -16, -46, -35, -78, Utf8.REPLACEMENT_BYTE}, "c7a252") + s.d(new byte[]{78, 2, Ascii.GS, 17, -124, -62, -31, -126, -7, -57, -42, -40, -9, -41, -113, -83, -124, -7, -50, -127, -10, -60, -44, -39, -26, -43, -92, -98, -122, -38, -62, -125, -10, -28, -34, -39, -22, -40, -101, -122, -121, -28, -46, -115, -15, -49, -43, -34, -59, -41, -92, -73, -124, -23, -9, -127, -18, -27, -41, -24, -60, -42, -68, -95, -123, -58, -38, -127, -20, -54, -42, -40, -9, -41, -113, -83, -122, -40, -22, -127, -10, -20, -44, -29, -21, -42, -127, -70, -118, -50, -12, 110}, "f041ba");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{26, 80, 76, 70, -35, -118, -34, -127, -9, -24, -42, -47, -110, -121, -8, -10, -36, -117, -22, -116, -37, -33, -44, -63, -125, -119, -47, -61, -41, -113, -19, -126, -8, -26, -44, -34, -120, 41, 17, Ascii.DC2, 72, 97, 4, Ascii.NAK, 19, 7, 66, 17, -44, -10, -45, -125, -65, -119, -122, -22, -42, -121, -115, -25, -41, -39, -35}, "2aef83") : s.d(new byte[]{26, 5, Ascii.RS, Ascii.EM, -36, -115, -34, -127, -9, -24, -42, -47, -110, -46, -86, -87, -35, -116, -22, -116, -37, -33, -44, -63, -125, -36, -125, -100, -42, -120, -19, -126, -8, -26, -44, -34, -120, 124, 67, 77, 73, 102, 4, Ascii.NAK, 19, 7, 66, 17, -44, -93, -127, -36, -66, -114, -122, -22, -42, -121, -115, -25, -41, -116, -113, Ascii.NAK, Ascii.EM, -36, -50, -62, -128, -31, -76, -115, -107, -75, -40, -123, -93, 62}, "247994") + str;
        }
    },
    KEY_EXCEPTION_WHEN_PERFORM_AD_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.14
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{17, 85, 76, 70, -121, -102, -31, -126, -7, -57, -42, -40, -88, -125, -34, -6, -121, -95, -50, -127, -10, -60, -41, -20, -86, -127, -39, -26, 107}, "9defa9") + s.d(new byte[]{16, 87, Ascii.US, 16, -33, -105, -31, -126, -7, -57, -42, -40, -87, -126, -115, -84, -33, -84, -50, -127, -10, -60, -44, -39, -72, -128, -90, -97, -35, -113, -62, -125, -10, -28, -34, -39, -76, -115, -103, -121, -36, -79, -46, -115, -15, -49, -43, -34, -101, -126, -90, -74, -33, -68, -9, -127, -18, -27, -41, -24, -102, -125, -66, -96, -34, -109, -38, -127, -20, -54, -42, -40, -87, -126, -115, -84, -35, -115, -22, -127, -10, -20, -44, -29, -75, -125, -125, -69, -47, -101, -12, 110}, "8e6094");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{Ascii.RS, 2, 76, 67, -127, -127, -34, -127, -9, -24, -39, -54, -127, -43, -44, -31, -127, -100, -48, -116, -46, -57, Ascii.GS, 69, -45, -69, -2, -122, -33, -126, -119, -53, -47, -124, -128, -25, -34, -116, -5, -123, -22, -99, -124, -29, -36, -123, -65, -43, -45, -113, -25, -122, -36, -128}, "63ecd8") : s.d(new byte[]{Ascii.US, 1, Ascii.US, 68, -124, -35, -34, -127, -9, -24, -39, -54, -128, -42, -121, -26, -124, -64, -48, -116, -46, -57, Ascii.GS, 69, -46, -72, -83, -127, -38, -34, -119, -53, -47, -124, -128, -25, -33, -113, -88, -126, -17, -63, -124, -29, -36, -123, -65, -43, -46, -116, -76, -127, -39, -36, -114, -40, -22, -118, -98, -61, -47, -77, -77, -116, -58, -27, -114, -40, -4, 104}, "706dad") + str;
        }
    },
    KEY_ERROR_WHEN_PARSE_DOWNLOAD_DATA { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.15
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{26, 82, Ascii.FS, Ascii.DC4, -36, -98, -42, -116, -25, -10, -42, -42, -119, -124, -124, -121, -45, -86, -2, -116, -63, -63, -44, -29, -127}, "2c5441");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{74, 80, Ascii.FS, 66, -48, -35, -34, -127, -9, -24, -44, -17, -62, -119, -120, -33, -48, -64, -48, -116, -46, -57, Ascii.GS, 69, -123, -43, -107, -124, -88, -12, -119, -47, -30, -124, -117, -11, -124, -12, -123, -124, -72, -54, -124, -40, -28, -121, -119, -35}, "ba5b5d") : s.d(new byte[]{Ascii.US, 0, 17, 19}, "7183cd") + str;
        }
    },
    KEY_EXCEPTION_WHEN_PERFORM_DOWNLOAD_REQUEST { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.16
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{77, 5, 75, 65, -48, -111, -31, -126, -7, -57, -42, -40, -12, -45, -39, -3, -48, -86, -50, -127, -10, -60, -41, -20, -10, -47, -34, -31, 60}, "e4ba62") + s.d(new byte[]{Ascii.FS, 4, 75, Ascii.DC4, -123, -107, -31, -126, -7, -57, -42, -40, -91, -47, -39, -88, -123, -82, -50, -127, -10, -60, -44, -39, -76, -45, -14, -101, -121, -115, -62, -125, -10, -28, -34, -39, -72, -34, -51, -125, -122, -77, -46, -115, -15, -49, -43, -34, -105, -47, -14, -78, -123, -66, -9, -127, -18, -27, -41, -24, -106, -48, -22, -92, -124, -111, -38, -127, -20, -54, -42, -40, -91, -47, -39, -88, -121, -113, -22, -127, -10, -20, -44, -29, -71, -48, -41, -65, -117, -103, -12, 110}, "46b4c6");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{77, 4, 17, 17, -43, -33, -34, -127, -9, -24, -42, -47, -59, -45, -91, -95, -44, -34, -22, -116, -37, -33, -44, -63, -44, -35, -116, -108, Ascii.FS, 70, -124, -20, -3, -121, -118, -33, -127, -115, -77, -39, -115, -37, -119, -37, -8, -124, -65, -64, -128, -78, -126, -42, -66, -42, -124, -40, -28, -121, -119, -35}, "e5810f") : s.d(new byte[]{17, 4, 74, 67, -41, -40, -34, -127, -9, -24, -43, -35, -78, -35, -34, -34, -43, -43, -63, -126, -5, -14, -44, -63, -120, -35, -41, -58, Ascii.RS, 65, -124, -20, -3, -121, -118, -33, -35, -115, -24, -117, -113, -36, -119, -37, -8, -124, -65, -64, -36, -78, -39, -124, -68, -47, -124, -40, -28, -121, -119, -35, -42, -119, -17, -117, -99, -57, -121, -25, -29, -118, -106, -28, -42, -119, -7, 105}, "95cc2a") + str;
        }
    },
    KEY_EXCEPTION_WHEN_DOWNLOAD_TO_FILE { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.17
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.CAN, 4, Ascii.FS, Ascii.ETB, -115, -97, -42, -116, -25, -10, -42, -42, -117, -46, -124, -124, -126, -85, -2, -116, -63, -63, -44, -29, -125}, "0557e0");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{26, 82, Ascii.GS, 70, -46, -119, -34, -127, -9, -24, -42, -47, -110, -123, -87, -10, -45, -120, -22, -116, -37, -33, -44, -63, -125, -117, -128, -61, Ascii.ESC, 16, -124, -30, -1, -121, -76, -64, 116, 10, 88, 3, -47, -89, -41, -127, -31, -40, -42, -21, -126, -122, -120, -28, -46, -120, -39}, "2c4f70") : s.d(new byte[]{16, 87, Ascii.FS, 67, -46, -120, -34, -127, -9, -24, -42, -47, -104, -128, -88, -13, -45, -119, -22, -116, -37, -33, -44, -63, -119, -114, -127, -58, Ascii.ESC, 17, -124, -30, -1, -121, -76, -64, 126, 15, 89, 6, -47, -90, -41, -127, -31, -40, -42, -21, -120, -125, -119, -31, -46, -119, -39, 72, 70, -118, -98, -61, -34, -27, -80, -117, -112, -80, -114, -40, -4, 104}, "8f5c71") + str;
        }
    },
    KEY_FAIL_WHEN_AD_SERVER_HTTP_STATUS_CODE_IS_NOT_200 { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.18
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason(int i, String str) {
            return (TextUtils.isEmpty(str) ? new StringBuilder().append(s.d(new byte[]{17, 82, Ascii.ESC, Ascii.DC2, -42, -33, -34, -127, -9, -24, -39, -54, -114, -123, -125, -80, -42, -62, -48, -116, -46, -57, Ascii.GS, 69, -36, -16, -65, -41, -119, -14, -121, -13, -48, -118, -114, -15, -36, -8, -84, -41, -113, -28, -124, -36, -34, -123, -69, -45, -33, -29, -77, -43, -109, -25, 77, 68, -114, -51, -105, -125, -70, -26, -38, -107, -78, -119, -35, -2, 14, Ascii.SYN, 69, Ascii.NAK, 124, 17, SignedBytes.MAX_POWER_OF_TWO, 93, 65, 37, 14, 0, 3, 66, 12, 69}, "9c223f")).append(i) : new StringBuilder().append(s.d(new byte[]{78, 7, Ascii.ESC, 19, -43, -118, -34, -127, -9, -24, -39, -54, -47, -48, -125, -79, -43, -105, -48, -116, -46, -57, Ascii.GS, 69, -125, -91, -65, -42, -118, -89, -121, -13, -48, -118, -114, -15, -125, -83, -84, -42, -116, -79, -124, -36, -34, 42, 69, 17, Ascii.SYN, -47, -72, -123, -42, -77, -32, -125, -58, -29, Ascii.GS, 69, -114, -103, -108, -43, -77, -74, -119, -61, -25, -115, -115, -1, 14, 66, 70, 67, 117, 65, 19, 11, Ascii.DC4, 33, 94, 1, 3, Ascii.SYN, 15, 19}, "f62303")).append(i).append(s.d(new byte[]{Ascii.EM, 70, 14, 68, 67, 38, 19, Ascii.SYN, 9, 16, 124, 0, 70, Ascii.NAK, 7, 87, 82, 67, 92, 68}, "5ff07c")).append(str)).toString();
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 2;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest(int i) {
            return s.d(new byte[]{76, 1, Ascii.ESC, Ascii.DC4, -48, -64, -31, -126, -7, -57, -42, -40, -11, -41, -119, -88, -48, -5, -50, -127, -10, -60, -41, -20, -9, -43, -114, -76, 60}, "d0246c") + s.d(new byte[]{Ascii.CAN, 1, Ascii.GS, Ascii.SYN, -123, -57, -31, -126, -7, -57, -42, -40, -95, -44, -113, -86, -123, -4, -50, -127, -10, -60, -44, -39, -80, -42, -92, -103, -121, -33, -62, -125, -10, -28, -34, -39, -68, -37, -101, -127, -122, -31, -46, -115, -15, -49, -43, -34, -109, -44, -92, -80, -123, -20, -9, -127, -18, -27, -41, -24, -110, -43, -68, -90, -124, -61, -38, -127, -20, -54, -42, -40, -95, -44, -113, -86, -121, -35, -22, -127, -10, -20, -44, -29, -67, -43, -127, -67, -117, -53, -12, 110}, "0346cd");
        }
    },
    KEY_FAIL_WHEN_DOWNLOAD_COMMIT_FILE_CACHE { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.19
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{74, 7, 16, 66, -115, -50, -42, -116, -25, -10, -42, -42, -39, -47, -120, -47, -126, -6, -2, -116, -63, -63, -44, -29, -47}, "b69bea");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{76, 6, 76, 17, -48, -116, -34, -127, -9, -24, -42, -47, -60, -47, -8, -95, -47, -115, -22, -116, -37, -33, -44, -63, -43, -33, -47, -108, Ascii.EM, Ascii.NAK, -124, -30, -1, -121, -76, -64, 32, 94, Ascii.SYN, 90, 121, 71, Ascii.DC4, 39, 7, 1, 89, 0, -126, -96, -45, -44, -78, -113, -122, -22, -42, -121, -115, -25, -127, -113, -35}, "d7e155") : s.d(new byte[]{75, 85, Ascii.FS, 69, -122, -36, -34, -127, -9, -24, -42, -47, -61, -126, -88, -11, -121, -35, -22, -116, -37, -33, -44, -63, -46, -116, -127, -64, 79, 69, -124, -30, -1, -121, -76, -64, 39, 13, 70, 14, 47, Ascii.ETB, Ascii.DC4, 39, 7, 1, 89, 0, -123, -13, -125, -128, -28, -33, -122, -22, -42, -121, -115, -25, -122, -36, -115, 73, 67, -115, -50, -62, -128, -31, -76, -115, -60, -27, -38, -39, -7, 111}, "cd5ece") + str;
        }
    },
    KEY_FAIL_WHEN_DOWNLOAD_HTTP_STATUS_CODE_IS_NOT_200 { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.20
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason(int i, String str) {
            return (TextUtils.isEmpty(str) ? new StringBuilder().append(s.d(new byte[]{77, 3, Ascii.FS, Ascii.CAN, -36, -127, -34, -127, -9, -24, -42, -47, -59, -44, -88, -88, -35, -128, -22, -116, -37, -33, -44, -63, -44, -38, -127, -99, Ascii.NAK, Ascii.CAN, -124, -9, -21, -121, -117, -15, -125, -91, -125, -48, -122, -84, -124, -1, -8, -121, -115, -25, -128, -118, -115, 112, 77, 76, 17, -125, -20, -44, -41, -27, -28, -43, -107, -71, Ascii.NAK, Ascii.CAN, -119, -53, -64, -124, -78, -32, -115, -107, -76, -41, -123, -94, 9, 16, Ascii.DC2, Ascii.DC2, 116, Ascii.ETB, Ascii.ETB, 93, 71, 123, 86, 92, 4, 68, 91, 66}, "e25898")).append(i) : new StringBuilder().append(s.d(new byte[]{Ascii.CAN, 4, Ascii.RS, Ascii.ETB, -45, -127, -34, -127, -9, -24, -42, -47, -112, -45, -86, -89, -46, -128, -22, -116, -37, -33, -44, -63, -127, -35, -125, -110, 26, Ascii.CAN, -124, -9, -21, -121, -117, -15, -42, -94, -127, -33, -119, -84, -124, -1, -8, -121, -115, -25, -43, -115, -113, 127, 66, 76, 17, -125, -20, -44, -41, -27, -79, -46, -105, -74, 26, Ascii.CAN, -119, -53, -64, -124, -78, -32, -40, -110, -74, -40, -118, -94, 9, 16, Ascii.DC2, Ascii.DC2, 116, Ascii.ETB, 66, 90, 69, 116, 89, 92, 4, 68, 91, 66}, "057768")).append(i).append(s.d(new byte[]{Ascii.DC4, 19, 10, Ascii.SYN, Ascii.SYN, 32, 19, Ascii.SYN, 9, 16, 124, 0, 75, SignedBytes.MAX_POWER_OF_TWO, 3, 5, 7, 69, 92, 68}, "83bbbe")).append(str)).toString();
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 2;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest(int i) {
            return s.d(new byte[]{78, 7, Ascii.RS, 70, -124, -58, -31, -126, -7, -57, -42, -40, -9, -47, -116, -6, -124, -3, -50, -127, -10, -60, -41, -20, -11, -45, -117, -26, 104}, "f67fbe") + s.d(new byte[]{Ascii.FS, 83, 76, 16, -124, -63, -31, -126, -7, -57, -42, -40, -91, -122, -34, -84, -124, -6, -50, -127, -10, -60, -44, -39, -76, -124, -11, -97, -122, -39, -62, -125, -10, -28, -34, -39, -72, -119, -54, -121, -121, -25, -46, -115, -15, -49, -43, -34, -105, -122, -11, -74, -124, -22, -9, -127, -18, -27, -41, -24, -106, -121, -19, -96, -123, -59, -38, -127, -20, -54, -42, -40, -91, -122, -34, -84, -122, -37, -22, -127, -10, -20, -44, -29, -71, -121, -48, -69, -118, -51, -12, 110}, "4ae0bb");
        }
    },
    KEY_FAIL_WHEN_SERVER_RESPONSE_IS_NULL { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.21
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{Ascii.FS, 2, 17, Ascii.NAK, -48, -38, -34, -127, -9, -24, -39, -54, -125, -43, -119, -73, -48, -57, -48, -116, -46, -57, Ascii.GS, 69, -36, -100, -98, -45, -74, -26, -119, -61, -25, -115, -115, -1, -36, -116, -84, -48, -82, -3, -122, -2, -30, -124, -92, -43, -46, -66, -106, -47, -115, -39, 47, 17, 10, 14}, "43855c");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.US, 84, Ascii.FS, Ascii.DC4, -46, -105, -31, -126, -7, -57, -42, -40, -90, -126, -114, -88, -46, -84, -50, -127, -10, -60, -41, -20, -92, -128, -119, -76, 62}, "7e5444") + s.d(new byte[]{Ascii.US, 83, 79, Ascii.CAN, -121, -63, -31, -126, -7, -57, -42, -40, -90, -122, -35, -92, -121, -6, -50, -127, -10, -60, -44, -39, -73, -124, -10, -105, -123, -39, -62, -125, -10, -28, -34, -39, -69, -119, -55, -113, -124, -25, -46, -115, -15, -49, -43, -34, -108, -122, -10, -66, -121, -22, -9, -127, -18, -27, -41, -24, -107, -121, -18, -88, -122, -59, -38, -127, -20, -54, -42, -40, -90, -122, -35, -92, -123, -37, -22, -127, -10, -20, -44, -29, -70, -121, -45, -77, -119, -51, -12, 110}, "7af8ab") + s.d(new byte[]{75, 86, Ascii.US, Ascii.DC2, -33, -107, -31, -126, -7, -57, -44, -40, -16, -128, -65, -65, -33, -82, -50, -125, -14, -54, -42, -1, -25, -128, -113, -115, -36, -89, -21, -128, -37, -17, -41, -3, -52, -128, -86, -102, -36, -90, -57, -127, -42, -19, -42, -44, -48, -128, -113, -127, -36, -71, -47, -115, -29, -17, -42, -40, -51, -125, -101, -111, -34, -105, -49}, "ce6296");
        }
    },
    KEY_FAIL_WHEN_PARSE_RESPONSE_DATA_ARRAY_IS_EMPTY { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.22
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason() {
            return s.d(new byte[]{Ascii.CAN, 80, 76, Ascii.NAK, -36, -36, -34, -127, -9, -24, -39, -54, -121, -121, -44, -73, -36, -63, -48, -116, -46, -57, Ascii.GS, 69, -40, -50, -61, -45, -70, -32, -119, -61, -25, -115, -115, -1, -42, -3, -24, -48, -77, -60, -122, -49, -55, -118, -114, -15, -43, -6, -5, -46, -93, -31, -121, -15, -42, -124, -68, -53, -44, -39, -56, -46, -93, -31, 0, 0, 47, 12, 87, 10, 67, -123, -35, -113, 119, 16, 13, 8}, "0ae59e");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 3;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{26, 80, 17, Ascii.DC2, -125, -107, -31, -126, -7, -57, -42, -40, -93, -122, -125, -82, -125, -82, -50, -127, -10, -60, -41, -20, -95, -124, -124, -78, 111}, "2a82e6") + s.d(new byte[]{76, 4, Ascii.CAN, 65, -45, -108, -31, -126, -7, -57, -42, -40, -11, -47, -118, -3, -45, -81, -50, -127, -10, -60, -44, -39, -28, -45, -95, -50, -47, -116, -62, -125, -10, -28, -34, -39, -24, -34, -98, -42, -48, -78, -46, -115, -15, -49, -43, -34, -57, -47, -95, -25, -45, -65, -9, -127, -18, -27, -41, -24, -58, -48, -71, -15, -46, -112, -38, -127, -20, -54, -42, -40, -11, -47, -118, -3, -47, -114, -22, -127, -10, -20, -44, -29, -23, -48, -124, -22, -35, -104, -12, 110}, "d61a57") + s.d(new byte[]{Ascii.US, 2, 16, Ascii.SYN, -126, -105, -31, -126, -7, -57, -44, -40, -92, -44, -80, -69, -126, -84, -50, -125, -14, -54, -42, -1, -77, -44, -128, -119, -127, -91, -21, -128, -37, -17, -41, -3, -104, -44, -91, -98, -127, -92, -57, -127, -42, -19, -42, -44, -124, -44, -128, -123, -127, -69, -47, -115, -29, -17, -42, -40, -103, -41, -108, -107, -125, -107, -49}, "7196d4");
        }
    },
    KEY_FAIL_WHEN_PARSE_RESPONSE_DATA { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.23
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{Ascii.EM, 0, Ascii.US, 17, -114, -106, -42, -116, -25, -10, -42, -42, -118, -42, -121, -126, -127, -94, -2, -116, -63, -63, -44, -29, -126}, "1161f9");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{74, 6, 74, 65, -122, -115, -34, -127, -9, -24, -39, -54, -43, -47, -46, -29, -122, -112, -48, -116, -46, -57, Ascii.GS, 69, -118, -104, -59, -121, -32, -79, -119, -61, -25, -115, -115, -1, -118, -112, -64, -121, -3, -92, -121, -8, -21, -121, -69, -60, -123, -100, -52, -119, -36, -96, -124, -1, -8, -123, -85, -31, 40, 100, 44, 47, -123, -95, -47, -126, -21, -52, -44, -30, -40, -48, -19, -47, -122, -120, -29, -127, -34, -38}, "b7cac4") : s.d(new byte[]{Ascii.CAN, 5, Ascii.US, Ascii.ETB, -42, -128, -34, -127, -9, -24, -39, -54, -121, -46, -121, -75, -42, -99, -48, -116, -46, -57, Ascii.GS, 69, -40, -101, -112, -47, -80, -68, -119, -61, -25, -115, -115, -1, -40, -109, -107, -47, -83, -87, -121, -8, -21, -121, -69, -60, -41, -97, -103, -33, -116, -83, -124, -1, -8, -123, -85, -31, 122, 103, 121, 121, -43, -84, -47, -126, -21, -52, -44, -30, -118, -45, -72, -121, -42, -123, -29, -127, -34, -38, Ascii.GS, 69, -40, -101, -112, -47, -80, -68, -119, -61, -25, -115, -115, -1, 58}, "046739") + str;
        }
    },
    KEY_FAIL_WHEN_PARSE_RESPONSE_STATUS_CODE_IS_NOT_SUCCESS { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.24
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getErrorReason(int i, String str) {
            return b.a(i, str, 0);
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 2;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest(int i) {
            return b.a(i);
        }
    },
    KEY_EXCEPTION_WHEN_CONNECT { // from class: com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep.25
        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public int getReasonLevel() {
            return 1;
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getSuggest() {
            return s.d(new byte[]{73, 0, Ascii.RS, Ascii.DC2, -117, -54, -42, -116, -25, -10, -42, -42, -38, -42, -122, -127, -124, -2, -2, -116, -63, -63, -44, -29, -46}, "a172ce");
        }

        @Override // com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep
        public String getThrowableReason(String str) {
            return TextUtils.isEmpty(str) ? s.d(new byte[]{77, 83, Ascii.US, 19, -44, -127, -34, -127, -9, -24, -39, -54, -46, -124, -121, -79, -44, -100, -48, -116, -46, -57, Ascii.GS, 69, -115, -51, -112, -43, -78, -67, -119, -61, -25, -115, -115, -1, -128, -22, -83, -42, -118, -126, -119, -53, -47, -124, -128, -25, -115, -35, -88, -43, -65, -99, -121, -13, -48, -121, -74, -33, -126, -20, -122, -43, -83, -110, -122, -5, -61, -117, -91, -4, -115, -51, -103}, "eb6318") : s.d(new byte[]{Ascii.RS, 80, Ascii.FS, 65, -128, -116, -34, -127, -9, -24, -39, -54, -127, -121, -124, -29, -128, -111, -48, -116, -46, -57, Ascii.GS, 69, -34, -50, -109, -121, -26, -80, -119, -61, -25, -115, -115, -1, -45, -23, -82, -124, -34, -113, -119, -53, -47, -124, -128, -25, -34, -34, -85, -121, -21, -112, -121, -13, -48, -121, -74, -33, -47, -17, -123, -121, -7, -97, -122, -5, -61, -117, -91, -4, -34, -50, -102, 77, 69, -35, -50, -62, -128, -31, -76, -115, -111, -32, -38, -35, -1, Utf8.REPLACEMENT_BYTE}, "6a5ae5") + str;
        }
    };

    public String getErrorReason() {
        return null;
    }

    public String getErrorReason(int i, String str) {
        return null;
    }

    public int getReasonLevel() {
        return 1;
    }

    public String getSuggest() {
        return null;
    }

    public String getSuggest(int i) {
        return null;
    }

    public String getThrowableReason(String str) {
        return null;
    }
}

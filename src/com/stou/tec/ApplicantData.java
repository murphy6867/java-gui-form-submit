package com.stou.tec;

public class ApplicantData {
    private String apId;
    private String apName;
    private String apAddress;
    private String apChw;
    private String apSex;
    private String apEd;
    private String apMaj;
    private String[] qualifications;
    private String[] positions;

    public ApplicantData() {
        qualifications = new String[5];
        positions = new String[3];
    }

    // Getters and Setters
    public String getApId() { return apId; }
    public void setApId(String apId) { this.apId = apId; }

    public String getApName() { return apName; }
    public void setApName(String apName) { this.apName = apName; }

    public String getApAddress() { return apAddress; }
    public void setApAddress(String apAddress) { this.apAddress = apAddress; }

    public String getApChw() { return apChw; }
    public void setApChw(String apChw) { this.apChw = apChw; }

    public String getApSex() { return apSex; }
    public void setApSex(String apSex) { this.apSex = apSex; }

    public String getApEd() { return apEd; }
    public void setApEd(String apEd) { this.apEd = apEd; }

    public String getApMaj() { return apMaj; }
    public void setApMaj(String apMaj) { this.apMaj = apMaj; }

    public String[] getQualifications() { return qualifications; }
    public void setQualifications(String[] qualifications) {
        this.qualifications = qualifications;
    }

    public String[] getPositions() { return positions; }
    public void setPositions(String[] positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("รายละเอียดของผู้สมัคร\n");
        sb.append("เลขประจำตัวของผู้สมัคร: ").append(apId).append("\n");
        sb.append("ชื่อ-นามสกุล: ").append(apName).append("\n");
        sb.append("ที่อยู่: ").append(apAddress).append("\n");
        sb.append("จังหวัด: ").append(apChw).append("\n");
        sb.append("เพศ: ").append(apSex).append("\n");
        sb.append("วุฒิการศึกษาชั้นสูงสุด: ").append(apEd).append("\n");
        sb.append("วิชาเอก: ").append(apMaj).append("\n");

        sb.append("\nความรู้ความสามารถ:\n");
        for (int i = 0; i < qualifications.length; i++) {
            sb.append((i + 1)).append(". ").append(qualifications[i]).append("\n");
        }

        sb.append("\nตำแหน่งที่ต้องการสมัคร:\n");
        for (int i = 0; i < positions.length; i++) {
            sb.append((i + 1)).append(". ").append(positions[i]).append("\n");
        }

        return sb.toString();
    }
}

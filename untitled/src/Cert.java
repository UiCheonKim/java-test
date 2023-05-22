
public class Cert {

    private String identity; // 카카오에서 부여하는 인증서 ID

    private String fcn; // 호출 API 의 이름
    //    @NotBlank(message = "certId 를 제대로 입력해주세요.")
    private String certId; // 인증서 ID (앞 2자리만 보이고 뒷부분 마스킹)
    //    @NotBlank(message = "uSangtae 를 제대로 입력해주세요.")
    private String uSangtae; // 상태(신규발급(재학) / 신규발급(졸업))
    //    @NotBlank(message = "certIssueDt 를 제대로 입력해주세요.")
    private String certIssueDt; // 최초발급일
    //    @NotBlank(message = "certEndDt 를 제대로 입력해주세요.")
    private String certEndDt; // 만료예정일
    //    @NotBlank(message = "discardDt 를 제대로 입력해주세요.")
    private String discardDt; // 폐기일

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFcn() {
        return fcn;
    }

    public void setFcn(String fcn) {
        this.fcn = fcn;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getuSangtae() {
        return uSangtae;
    }

    public void setuSangtae(String uSangtae) {
        this.uSangtae = uSangtae;
    }

    public String getCertIssueDt() {
        return certIssueDt;
    }

    public void setCertIssueDt(String certIssueDt) {
        this.certIssueDt = certIssueDt;
    }

    public String getCertEndDt() {
        return certEndDt;
    }

    public void setCertEndDt(String certEndDt) {
        this.certEndDt = certEndDt;
    }

    public String getDiscardDt() {
        return discardDt;
    }

    public void setDiscardDt(String discardDt) {
        this.discardDt = discardDt;
    }

    public String getReissue() {
        return reissue;
    }

    public void setReissue(String reissue) {
        this.reissue = reissue;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    private String reissue; // 재발급 여부
    //    @NotBlank(message = "timestamp 를 제대로 입력해주세요.")

    private int timestamp; // YYYY-MM-DD HH:mm:ss 형식의 호출 시간

}

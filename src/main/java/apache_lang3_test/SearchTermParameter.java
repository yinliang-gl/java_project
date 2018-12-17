package apache_lang3_test;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.Serializable;

public class SearchTermParameter implements Serializable {
    private static final long serialVersionUID = 9106117998684861561L;
    private String startDate;
    private String endDate;
    private Long campaignId;
    private Long adGroupId;
    private Long materialId;
    private String areaId;
    private String orderTime;
    private String pin;
    private Long pinId;
    private String keywords;
    private String mobileType;
    private boolean todayReport;
    private Integer page;
    private Integer size;

    public SearchTermParameter() {
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public void setAdGroupId(Long adGroupId) {
        this.adGroupId = adGroupId;
    }

    public String getPin() {
        return this.pin;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Long getCampaignId() {
        return this.campaignId;
    }

    public Long getAdGroupId() {
        return this.adGroupId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return this.size;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getMobileType() {
        return this.mobileType;
    }

    public void setTodayReport(boolean todayReport) {
        this.todayReport = todayReport;
    }

    public void setPinId(Long pinId) {
        this.pinId = pinId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public boolean isTodayReport() {
        return this.todayReport;
    }

    public Long getPinId() {
        return this.pinId;
    }

    public Long getMaterialId() {
        return this.materialId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public String toString() {
        return "startDate=" + this.startDate + ",endDate=" + this.endDate + ",campaignId=" + this.campaignId + ",adGroupId=" + this.adGroupId + ",orderTime=" + this.orderTime + ",pin=" + this.pin + ",keywords=" + this.keywords + ",page=" + this.page + ",size=" + this.size + ",mobileType=" + this.mobileType + ",materialId=" + this.materialId + ",areaId=" + this.areaId + ",pinId=" + this.pinId + ",todayReport=" + this.todayReport;
    }
}

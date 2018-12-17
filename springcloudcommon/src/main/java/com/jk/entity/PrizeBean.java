package com.jk.entity;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/14 20:33
 * @Description:
 */
public class PrizeBean {

    private Integer prizeId;
    private String prizeName;
    private String  prizeSum;

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeSum() {
        return prizeSum;
    }

    public void setPrizeSum(String prizeSum) {
        this.prizeSum = prizeSum;
    }

    @Override
    public String toString() {
        return "PrizeBean{" +
                "prizeId=" + prizeId +
                ", prizeName='" + prizeName + '\'' +
                ", prizeSum='" + prizeSum + '\'' +
                '}';
    }
}

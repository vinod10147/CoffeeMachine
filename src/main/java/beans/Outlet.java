package beans;

public class Outlet {
    private Integer serialNo;
    private Boolean isServing;

    public Outlet(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Boolean getServing() {
        return isServing;
    }

    public void setServing(Boolean serving) {
        isServing = serving;
    }
}

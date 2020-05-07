package com.aaa.entity;

public class Xiaoliang {
    private Integer xid;
    private Integer xcount;
    private String xname;

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public Integer getXcount() {
        return xcount;
    }

    public void setXcount(Integer xcount) {
        this.xcount = xcount;
    }

    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }

    @Override
    public String toString() {
        return "Xiaoliang{" +
                "xid=" + xid +
                ", xcount=" + xcount +
                ", xname='" + xname + '\'' +
                '}';
    }
}

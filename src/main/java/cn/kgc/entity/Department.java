package cn.kgc.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2021-01-13 09:55:21
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -34593492778776516L;
    
    private Integer depid;
    
    private String depname;


    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

}
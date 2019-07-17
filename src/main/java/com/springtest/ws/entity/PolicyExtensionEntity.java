package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_extensions")
public class PolicyExtensionEntity implements Serializable {
    private static final long serialVersionUID = -4428859647067791064L;

    @Id
    @Column(nullable = false, unique = true)
    private int extCode;

    @Column(nullable = false)
    private String extName;

    @Column(nullable = false)
    private int extPolCode;

    private int extSclCode;

    public int getExtCode() {
        return extCode;
    }

    public void setExtCode(int extCode) {
        this.extCode = extCode;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public int getExtPolCode() {
        return extPolCode;
    }

    public void setExtPolCode(int extPolCode) {
        this.extPolCode = extPolCode;
    }

    public int getExtSclCode() {
        return extSclCode;
    }

    public void setExtSclCode(int extSclCode) {
        this.extSclCode = extSclCode;
    }
}

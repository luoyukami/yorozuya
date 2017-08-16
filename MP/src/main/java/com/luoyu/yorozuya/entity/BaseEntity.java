package com.luoyu.yorozuya.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * MySQL数据库表公共数据 -
 *
 * @author ganxiang20970
 *         2017-08-14 08:44
 */
@MappedSuperclass
public abstract class BaseEntity {

    private Long id;//主键，自增长
    private Timestamp createTime;//数据创建时间
    private Timestamp modifyTime;//数据修改时间


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(name = "modify_time")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}

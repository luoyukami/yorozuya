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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//主键，自增长
    @Column(name = "create_time", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP comment '数据创建时间'")
    private Timestamp createTime;//数据创建时间
    @Column(name = "modify_time", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP comment '数据修改时间'")
    private Timestamp modifyTime;//数据修改时间



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}

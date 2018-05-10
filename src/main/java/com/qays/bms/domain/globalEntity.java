package com.qays.bms.domain;

import lombok.Data;
import org.hibernate.dialect.Ingres9Dialect;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 09:46
 */
@Entity
@Data
@Table(name = "global")
public class globalEntity {
    @Id
    private String id;

    @Basic
    private String name;

    @Basic
    private String description;

    @Basic
    private String content;

    @Basic
    private Integer click;

    @Basic
    private String publisher;

    @Basic
    private boolean state;

    @Basic
    private Integer tag;

    @Basic
    private String seoId;

    @Basic
    private Timestamp updateDate;

    @Basic
    private Timestamp createDate;

    @Basic
    private String coverImg;

    @Basic
    private String bannerImg;

    @Basic
    private String class1;

    @Basic
    private String class2;

    @Basic
    private String class3;

    @Basic
    private String extends1;

    @Basic
    private Integer extends2;

}

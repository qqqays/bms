package com.qays.bms.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 15:18
 */
@Entity
@Data
@Table(name = "image")
public class ImgEntity {
    @Id
    private String id;

    @Basic
    private String name;

    @Basic
    private String alt;

    @Basic
    private String title;

    @Basic
    private String url;

    @Basic
    private String relativePath;

    @Basic
    private String absolutePath;

    @Basic
    private Integer height;

    @Basic
    private Integer width;

    @Basic
    private String class1;

    @Basic
    private String class2;

    @Basic
    private String class3;

}

package com.qays.bms.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 10:05
 */
@Entity
@Data
@Table(name = "seo")
public class SeoEntity {
    @Id
    private String id;

    @Basic
    private String pageTitle;

    @Basic
    private String keywords;

    @Basic
    private String description;

    @Basic
    private String author;

    @Basic
    private boolean state;
}

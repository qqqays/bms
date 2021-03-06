package com.qays.bms.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 17:11
 */
@Entity
@Data
@Table(name = "dic_item")
public class ItemEntity {

    @Id
    private Integer id;

    @Basic
    private String typeId;

    @Basic
    private String name;

    @Basic
    private String value;

    @Basic
    private Integer sort;

    @Basic
    private String description;

}

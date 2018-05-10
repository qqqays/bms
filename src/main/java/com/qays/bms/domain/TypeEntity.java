package com.qays.bms.domain;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 10:02
 */
@Entity
@Data
@Table(name = "dic_type")
public class TypeEntity {
    @Id
    private String id;

    @Basic
    private String code;

    @Basic
    private String name;

    @Basic
    private String description;
}

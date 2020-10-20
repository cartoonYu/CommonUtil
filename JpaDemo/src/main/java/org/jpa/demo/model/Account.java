package org.jpa.demo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cartoon
 * @description
 * @date 2020/4/25 10:23
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;


}

package com.ltim.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SP_DATA_EMP")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	
	@Column(length = 20)
	private String ename;
	
	@Column(length = 20)
	private String dept;
	
	private Double sal;
}

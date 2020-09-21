package com.chandrashekar.SpringbootApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InstallationDetails")
public class InstallationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "productType")
	private String productType;

	@Column(name = "territory")
	private String territory;

	@Column(name = "division")
	private String division;

	@Column(name = "dsm")
	private String dsm;

	@Column(name = "zoneName")
	private String zoneName;

	@Column(name = "csm")
	private String csm;

	@Column(name = "ase")
	private String ase;

	@Column(name = "dcc")
	private String dcc;

	@Column(name = "dcc_Id")
	private String dccId;

	@Column(name = "dcc_Type")
	private String dccType;

	public InstallationDetails() {

	}

	public InstallationDetails(String productType, String territory, String division, String dsm, String zoneName,
			String csm, String ase, String dcc, String dccId, String dccType) {
		super();
		this.productType = productType;
		this.territory = territory;
		this.division = division;
		this.dsm = dsm;
		this.zoneName = zoneName;
		this.csm = csm;
		this.ase = ase;
		this.dcc = dcc;
		this.dccId = dccId;
		this.dccType = dccType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDsm() {
		return dsm;
	}

	public void setDsm(String dsm) {
		this.dsm = dsm;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getCsm() {
		return csm;
	}

	public void setCsm(String csm) {
		this.csm = csm;
	}

	public String getAse() {
		return ase;
	}

	public void setAse(String ase) {
		this.ase = ase;
	}

	public String getDcc() {
		return dcc;
	}

	public void setDcc(String dcc) {
		this.dcc = dcc;
	}

	public String getDccId() {
		return dccId;
	}

	public void setDccId(String dccId) {
		this.dccId = dccId;
	}

	public String getDccType() {
		return dccType;
	}

	public void setDccType(String dccType) {
		this.dccType = dccType;
	}
	
	

}

package com.boot.music.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Document implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_Start")
	private Date dateStart;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Date_End")
	private Date dateEnd;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UserID")
	public User user;
	private short statusID;
	@OneToMany(mappedBy = "document"
			, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="versionID")
	private List<Version> versionList;
	private String sumary;
	@Column(name = "Security Level")
	private int securityLevel;
	public short getStatusID() {
		return statusID;
	}
	public void setStatusID(short statusID) {
		this.statusID = statusID;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public Document(String title,String sumary, Date dateStart, Date dateEnd, User user) {
		super();
		this.title = title;
		this.sumary=sumary;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.user = user;
		this.statusID=1;
		this.securityLevel=1;
		versionList= new ArrayList<Version>();
	}
	public String getSumary() {
		return sumary;
	}
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	public Document() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public short getStatus() {
		return statusID;
	}
	public void setStatus(short status_ID) {
		this.statusID = status_ID;
	}
	public List<Version> getVersionList() {
		return versionList;
	}
	public void setVersionList(List<Version> versionList) {
		this.versionList = versionList;
	}
	public Long getId() {
		return id;
	}
}

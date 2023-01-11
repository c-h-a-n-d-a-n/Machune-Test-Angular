package com.nissan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "tblSalesVisit")
public class SalesVisit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer visit_id;
	
	private String cust_Name;
	
	private String contact_person;
	
	private Long contact_no;
	
	private String interest_product;
	
	private String visit_subject;
	
	private String description;
	private boolean is_disabled;
	private boolean is_deleted;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("date_of_visit")
	private DateTime visit_date; 
	
	private Integer emp_id;
	@OneToMany(cascade=CascadeType.ALL, targetEntity=UserRegistration.class)
	@JoinColumn(name = "emp_id", insertable = false, updatable = false)
//	private  UserRegistration userRegistration;
	
	public Integer getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(Integer visit_id) {
		this.visit_id = visit_id;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public Long getContact_no() {
		return contact_no;
	}
	public void setContact_no(Long contact_no) {
		this.contact_no = contact_no;
	}
	public String getInterest_product() {
		return interest_product;
	}
	public void setInterest_product(String interest_product) {
		this.interest_product = interest_product;
	}
	public String getVisit_subject() {
		return visit_subject;
	}
	public void setVisit_subject(String visit_subject) {
		this.visit_subject = visit_subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isIs_disabled() {
		return is_disabled;
	}
	public void setIs_disabled(boolean is_disabled) {
		this.is_disabled = is_disabled;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public DateTime getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(DateTime visit_date) {
		this.visit_date = visit_date;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
//	public UserRegistration getUserRegistration() {
//		return userRegistration;
//	}
//	public void setUserRegistration(UserRegistration userRegistration) {
//		this.userRegistration = userRegistration;
//	}
	@Override
	public String toString() {
		return "SalesVisit [visit_id=" + visit_id + ", cust_Name=" + cust_Name + ", contact_person=" + contact_person
				+ ", contact_no=" + contact_no + ", interest_product=" + interest_product + ", visit_subject="
				+ visit_subject + ", description=" + description + ", is_disabled=" + is_disabled + ", is_deleted="
				+ is_deleted + ", visit_date=" + visit_date + ", emp_id=" + emp_id + ", userRegistration="
				+ "userRegistration" + "]";
	}
	public SalesVisit(Integer visit_id, String cust_Name, String contact_person, Long contact_no,
			String interest_product, String visit_subject, String description, boolean is_disabled, boolean is_deleted,
			DateTime visit_date, Integer emp_id, UserRegistration userRegistration) {
		super();
		this.visit_id = visit_id;
		this.cust_Name = cust_Name;
		this.contact_person = contact_person;
		this.contact_no = contact_no;
		this.interest_product = interest_product;
		this.visit_subject = visit_subject;
		this.description = description;
		this.is_disabled = is_disabled;
		this.is_deleted = is_deleted;
		this.visit_date = visit_date;
		this.emp_id = emp_id;
//		this.userRegistration = userRegistration;
	}
	public SalesVisit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

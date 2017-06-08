package object;

import java.sql.Date;

public class Employees {
	private Integer n_emp;
	private Date date;
	private String f_name;
	private String l_name;
	private Gender gen;
	private Date hire_date;
	
	public static enum Gender{
		M, F
	}
	
	public Employees(Integer n_emp, Date date, String f_name, String l_name, Gender gen, Date hire_date) {
		super();
		this.n_emp = n_emp;
		this.date = date;
		this.f_name = f_name;
		this.l_name = l_name;
		this.gen = gen;
		this.hire_date = hire_date;
	}
	public Integer getN_emp() {
		return n_emp;
	}
	public void setN_emp(Integer n_emp) {
		this.n_emp = n_emp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public Gender getGen() {
		return gen;
	}
	public void setGen(Gender gen) {
		this.gen = gen;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
}

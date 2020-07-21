package cn.jiyun.pojo;

public class EmpVo extends Emp{
	private String dname;
	private String shengname;
	private String shiname;
	private String quname;
	private Emp emp;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getShengname() {
		return shengname;
	}
	public void setShengname(String shengname) {
		this.shengname = shengname;
	}
	public String getShiname() {
		return shiname;
	}
	public void setShiname(String shiname) {
		this.shiname = shiname;
	}
	public String getQuname() {
		return quname;
	}
	public void setQuname(String quname) {
		this.quname = quname;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
}

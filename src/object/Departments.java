package object;

public class Departments {
	private String ndep;
	private String name;
	public Departments(String ndep, String name) {
		super();
		this.ndep = ndep;
		this.name = name;
	}
	public String getNdep() {
		return ndep;
	}
	public void setNdep(String ndep) {
		this.ndep = ndep;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Departments [ndep=" + ndep + ", name=" + name + "]";
	}
	
	

}

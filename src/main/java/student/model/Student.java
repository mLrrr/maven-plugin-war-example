package student.model;



public class Student {
	private int sid;
	private String name;
	private String programmename;
	private String programmecode;
	private int id;
	
	public Student() {}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getProgrammename() {
		return programmename;
	}
	public void setProgrammename(String programmename) {
		this.programmename = programmename;
	}
	public String getProgrammecode() {
		return programmecode;
	}

	public void setProgrammecode(String programmecode) {
		this.programmecode = programmecode;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}

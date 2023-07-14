package student.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Borrow {
	private int borrowid;
	private Date borrowdate;
	private Timestamp borrowtime;
	private Date returndate;
	private Timestamp returntime;
	private int quantityborrowed;
	public String approval;
	private int id;
	private int eid;
	
	
	public Borrow() {}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getid() {
		return id;
	}

	public int getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(int borrowid) {
		this.borrowid = borrowid;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Timestamp getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(Timestamp borrowtime) {
		this.borrowtime = borrowtime;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public Timestamp getReturntime() {
		return returntime;
	}

	public void setReturntime(Timestamp returntime) {
		this.returntime = returntime;
	}

	public int getQuantityborrowed() {
		return quantityborrowed;
	}

	public void setQuantityborrowed(int quantityborrowed) {
		this.quantityborrowed = quantityborrowed;
	}
	
	
}


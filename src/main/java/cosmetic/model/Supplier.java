package cosmetic.model;

public class Supplier {

	private int supplier_id;
	private String supplier_name;
	private String contact_no;
	private String Place;
	
	public Supplier(int supplier_id, String supplier_name, String contact_no, String place) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.contact_no = contact_no;
		Place = place;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	
}

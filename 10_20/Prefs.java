
public class Prefs {
	private String code;
	private String prefName;
	private String region;
	private String prefCapital;
	private int area;

	public Prefs (String c, String r, String pn, String pc, int a) {
		this.setCode(c);
		this.setRegion(r);
		this.setPrefName(pn);
		this.setPrefCapital(pc);
		this.setArea(a);
	}

	public Prefs() {

	}

	public String getCode() {
		return this.code;		
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrefName() {
		return this.prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	} 

	public String getRegion() {
		return this.region;
	}

	public void setRegion (String region) {
		this.region = region;
	}

	public String getPrefCapital() {
		return this.prefCapital;
	}

	public void setPrefCapital(String prefCapital) {
		this.prefCapital = prefCapital;
	}

	public int getArea() {
		return this.area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "[Code=" + this.getCode() +",PrefsName=" + this.getPrefName() + ",PrefCapital=" + this.getPrefCapital() + ",Region=" + this.getRegion() + ",Area=" + this.getArea() + "]";
	}


}
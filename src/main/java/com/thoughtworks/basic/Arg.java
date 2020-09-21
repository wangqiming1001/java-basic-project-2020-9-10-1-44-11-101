package com.thoughtworks.basic;
/**
 * 
 * @author wqm
 *
 */
public class Arg {

	private String flag;
    private String value;
    private String type;
    
    public Arg(String flag,String value){
        this.flag = flag;
        this.value = value;
    }
    
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}

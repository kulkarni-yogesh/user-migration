package com.covisint.datamigration.enums;

public enum UsersStatus {
	
	PENDING(1, "pending"),
	REJECTED(2, "rejected"),
	ACTIVE (3, "active"),
	SUSPENDED (4, "suspended"),
	INACTIVE (5, "inactive"),
	LOCKED(6, "locked"),
	EXPIRED(7, "expired"),
	UNACTIVATED (8, "unactivated"),
	PRETERMINATED(9, "preterminated");
	
	private String codeDesc;
	private Integer code;
	
	UsersStatus(Integer code, String desc) {
		this.code = code;
		this.codeDesc = desc;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	public static String getStatusByCode(Integer code) {
		
		for (UsersStatus enums : UsersStatus.values()) {
			if(enums == null){
				return null;
			}
			
			if(enums.getCode() == code){
				return enums.getCodeDesc();
			}
		}
		return null;
		
	}

}

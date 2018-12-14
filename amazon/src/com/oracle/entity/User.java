package com.oracle.entity;

public class User {
	private long hu_user_id;
	private String hu_user_name;
	private String hu_password;
	private String hu_sex;
	private String hu_birthday;
	private String hu_identity_code;
	private String hu_email;
	private String hu_mobile;
	private String hu_adderss;
	private long hu_status;

	public User(String hu_user_name, String hu_password, String hu_sex, String hu_birthday, String hu_identity_code,
			String hu_email, String hu_mobile, String hu_adderss) {
		super();
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_code = hu_identity_code;
		this.hu_email = hu_email;
		this.hu_mobile = hu_mobile;
		this.hu_adderss = hu_adderss;
	}

	public User() {
		super();
	}

	public long getHu_user_id() {
		return hu_user_id;
	}

	public void setHu_user_id(long hu_user_id) {
		this.hu_user_id = hu_user_id;
	}

	public String getHu_user_name() {
		return hu_user_name;
	}

	public void setHu_user_name(String hu_user_name) {
		this.hu_user_name = hu_user_name;
	}

	public String getHu_password() {
		return hu_password;
	}

	public void setHu_password(String hu_password) {
		this.hu_password = hu_password;
	}

	public String getHu_sex() {
		return hu_sex;
	}

	public void setHu_sex(String hu_sex) {
		this.hu_sex = hu_sex;
	}

	public String getHu_birthday() {
		return hu_birthday;
	}

	public void setHu_birthday(String hu_birthday) {
		this.hu_birthday = hu_birthday;
	}

	public String getHu_identity_code() {
		return hu_identity_code;
	}

	public void setHu_identity_code(String hu_identity_code) {
		this.hu_identity_code = hu_identity_code;
	}

	public String getHu_email() {
		return hu_email;
	}

	public void setHu_email(String hu_email) {
		this.hu_email = hu_email;
	}

	public String getHu_mobile() {
		return hu_mobile;
	}

	public void setHu_mobile(String hu_mobile) {
		this.hu_mobile = hu_mobile;
	}

	public String getHu_adderss() {
		return hu_adderss;
	}

	public void setHu_adderss(String hu_adderss) {
		this.hu_adderss = hu_adderss;
	}

	public long getHu_status() {
		return hu_status;
	}

	public void setHu_status(long hu_status) {
		this.hu_status = hu_status;
	}

	public User(long hu_user_id, String hu_user_name, String hu_password, String hu_sex, String hu_birthday,
			String hu_identity_code, String hu_email, String hu_mobile, String hu_adderss, long hu_status) {
		super();
		this.hu_user_id = hu_user_id;
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_code = hu_identity_code;
		this.hu_email = hu_email;
		this.hu_mobile = hu_mobile;
		this.hu_adderss = hu_adderss;
		this.hu_status = hu_status;
	}

	@Override
	public String toString() {
		return "User [hu_user_id=" + hu_user_id + ", hu_user_name=" + hu_user_name + ", hu_password=" + hu_password
				+ ", hu_sex=" + hu_sex + ", hu_birthday=" + hu_birthday + ", hu_identity_code=" + hu_identity_code
				+ ", hu_email=" + hu_email + ", hu_mobile=" + hu_mobile + ", hu_adderss=" + hu_adderss + ", hu_status="
				+ hu_status + "]";
	}

}

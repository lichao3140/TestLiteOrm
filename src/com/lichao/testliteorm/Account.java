package com.lichao.testliteorm;

import com.litesuits.orm.db.annotation.Check;
import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Default;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * 用户SIP信息
 * @author LiChao
 */
@Table("account")
public class Account {

	public static final String COL_ID = "_id";

	/**
	 * SIP账号
	 */
	public static final String COL_USERNAME = "username";

	/**
	 * 密码
	 */
	public static final String COL_PASSWORD = "password";

	/**
	 * 服务器地址
	 */
	public static final String COL_DOMAIN = "domain";

	/**
	 * 用户别名
	 */
	public static final String COL_DISPLAYNAME = "display_name";

	/**
	 * 通信方式 UDP TCP TLS
	 */
	public static final String COL_TRANSPORT = "transport";

	@PrimaryKey(AssignType.AUTO_INCREMENT)
	@Column(COL_ID)
	public int id;

	@NotNull()
	@Column(COL_USERNAME)
	public String username;

	@NotNull()
	@Column(COL_PASSWORD)
	public String password;

	@NotNull()
	@Column(COL_DOMAIN)
	public String domain;

	//@Check("COL_DISPLAYNAME < 50")
	@Column(COL_DISPLAYNAME)
	public String display_name;

	@NotNull()
	@Column(COL_TRANSPORT)
	// 0-1-2 0:UDP 1:TCP 2:TLS
	//@Check("COL_TRANSPORT>=0 AND COL_TRANSPORT<3")
	@Default("0")
	public int transport;

	public Account() {

	}

	public Account(String username, String password, String domain,
			int transport) {
		super();
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.transport = transport;
	}

	public Account(int id, String username, String password, String domain,
			String display_name, int transport) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.domain = domain;
		this.display_name = display_name;
		this.transport = transport;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public int getTransport() {
		return transport;
	}

	public void setTransport(int transport) {
		this.transport = transport;
	}

	@Override
	public String toString() {
		return "Account {" + "id=" + id + ",username="
				+ username + ", password=" + password + ", domain=" + domain
				+ ", display_name=" + display_name + ", transport=" + transport
				+ "}";
	}

}

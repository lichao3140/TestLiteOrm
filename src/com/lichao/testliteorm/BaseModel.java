package com.lichao.testliteorm;

import com.litesuits.orm.db.annotation.Check;
import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Check条件检测
	@Check("description NOT NULL")
	public String description = "字段描述";

	@Ignore
	private String ignore = "标记Ignore,并不会出现在数据库中";

	@Override
	public String toString() {
		return "BaseModel{" 
					+ "description='" 
					+ description 
					+ '\'' + '}';
	}
}

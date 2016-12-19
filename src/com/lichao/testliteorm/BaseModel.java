package com.lichao.testliteorm;

import com.litesuits.orm.db.annotation.Check;
import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

public class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Check�������
	@Check("description NOT NULL")
	public String description = "�ֶ�����";

	@Ignore
	private String ignore = "���Ignore,��������������ݿ���";

	@Override
	public String toString() {
		return "BaseModel{" 
					+ "description='" 
					+ description 
					+ '\'' + '}';
	}
}

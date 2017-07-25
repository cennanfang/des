package com.fun.orm.genxml.creator;

import com.fun.orm.retrieve.ModelInfoHolder;

public interface MethodCreator {

	public void create(StringBuffer sb, ModelInfoHolder mih);
}

package com.fun.orm.mapper;

import java.io.IOException;
import java.util.List;

import com.fun.orm.retrieve.ModelInfoHolder;

public class CreateMappers {

	public void create(List<ModelInfoHolder> mihs, String classPath, String mapperPackage) throws IOException {
		CreateFunMapper cfm = new CreateFunMapper();
		for(ModelInfoHolder mih : mihs) {
			cfm.createMapper(mih, classPath, mapperPackage);
		}
	}
}

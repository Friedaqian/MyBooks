package com.example.demo.web;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

public class EntityIdResolver implements ObjectIdResolver{

	@Override
	public void bindItem(IdKey id, Object pojo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object resolveId(IdKey id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectIdResolver newForDeserialization(Object context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canUseFor(ObjectIdResolver resolverType) {
		// TODO Auto-generated method stub
		return false;
	}

}

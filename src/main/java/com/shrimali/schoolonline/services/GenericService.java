package com.shrimali.schoolonline.services;

import java.util.List;

import com.shrimali.schoolonline.exceptions.BlankOrNullArgumentException;

public interface GenericService<T> {

	public List<T> list();

	public void save(T t);

	public void update(T t);

	public void delete(Long entityId) throws BlankOrNullArgumentException;
}

package com.food2air.dataAccess;

import java.util.List;

public interface IDataAccess<T> {
	public T create(T object);

	public T update(T object);

	public void delete(T object);

	public T findById(long id);

	public List<T> getAll();

	public List<T> getAll(int from, int limit);
}

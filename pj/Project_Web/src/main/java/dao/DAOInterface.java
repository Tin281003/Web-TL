package dao;

import java.util.List;

import entity.Account;

public interface DAOInterface<T> {
	public List<T> getAll();
	public T getById(String s); 
	public boolean add(T t);
	public boolean update(T t);
	public boolean delete(T t);
}

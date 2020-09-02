package com.dxc.dao;

import java.util.ArrayList;

public interface DAO<E> {
	boolean edit(E e) throws Exception;
	boolean save(E e) throws Exception;
	boolean delete(int id) throws Exception;
	E find(int id) throws Exception;
	ArrayList<E> findAll() throws Exception;
	

}

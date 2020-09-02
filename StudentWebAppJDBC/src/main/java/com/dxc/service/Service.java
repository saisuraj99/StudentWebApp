package com.dxc.service;

import java.util.List;


public interface Service <E> {

	boolean save(E e);
	E find(int id);
	List<E> findAll();
	boolean update(E e);
	boolean delete(int id);
}
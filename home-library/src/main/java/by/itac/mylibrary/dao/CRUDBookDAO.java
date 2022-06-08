package by.itac.mylibrary.dao;

import by.itac.mylibrary.entity.Book;

import by.itac.mylibrary.dao.exception.DAOException;


public interface CRUDBookDAO {
	void add(Book book)throws DAOException;
	void delete(Book book) throws DAOException;
	void delete(int id) throws DAOException;	


}

package by.itac.mylibrary.service;

import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;

public interface BookService {
	
	void add(Book book) throws ServiceException;
	Book find(int id)  throws DAOException;
	List<Book> findByTitle(String title)  throws DAOException;
	List<Book> findByAuthor(String author)  throws DAOException;
	

}

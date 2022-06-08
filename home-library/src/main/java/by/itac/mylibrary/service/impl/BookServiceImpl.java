package by.itac.mylibrary.service.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public void add(Book book) throws ServiceException {
		try {
			DAOProvider provider = DAOProvider.getInstance();
			CRUDBookDAO dao = provider.getBookDAO();
			dao.add(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Book find(int id) throws DAOException {

		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			return dao.find(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> findByTitle(String title) throws DAOException {
		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			return dao.findByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> findByAuthor(String author) throws DAOException {

		try {
			DAOProvider provider = DAOProvider.getInstance();
			FindBookDAO dao = provider.getFindDAO();
			return dao.findByAuthor(author);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}
}

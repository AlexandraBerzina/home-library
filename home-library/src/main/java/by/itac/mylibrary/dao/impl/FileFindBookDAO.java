package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {
	

	private final String fileName = "db-home-library.txt";
	
	private final String DELIMETER = "__ __";
	private final int idInd = 0;
	private final int authorInd = 1;
	private final int titleInd = 2;
	private final int yearInd = 3;
	
	ClassLoader classLoader = getClass().getClassLoader();
	String path  = classLoader.getResource(fileName).getPath();
	File file = new File(path);

	@Override
	public Book find(int id) throws DAOException {
		int BookId;
		Book b1 = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(DELIMETER);
				BookId = Integer.parseInt(bookFields[idInd]);
				
				if (BookId == id) {
					b1.setId(BookId);
					b1.setAuthor(bookFields[authorInd]);
					b1.setTitle(bookFields[titleInd]);
					b1.setYear(Integer.parseInt(bookFields[yearInd]));
				}
			}
		} catch (IOException e) {
			throw new DAOException("Find error", e);
		}
		return finddBook;
	}

	@Override
	public List<Book> findByTitle(String title) throws DAOException {
		List<Book> findBooks = new ArrayList<>();
		Book b1 = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(DELIMETER);

				if (title.equals(bookFields[titleInd])) {

					b1.setId(Integer.parseInt(bookFields[idInd]));
					b1.setAuthor(bookFields[authorInd]);
					b1.setTitle(bookFields[titleInd]);
					b1.setYear(Integer.parseInt(bookFields[yearInd]));
					
					findBooks.add(b1);
				}

			}
		} catch (IOException e) {
			throw new DAOException("Find error", e);
		}
		return findBooks;
	}

	@Override
	public List<Book> findByAuthor(String author) throws DAOException {
		List<Book> findBooks = new ArrayList<>();
		Book b1 = new Book();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
			 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(DELIMETER);

				if (author.equals(bookFields[authorInd])) {

					b1.setId(Integer.parseInt(bookFields[idInd]));
					b1.setAuthor(bookFields[authorInd]);
					b1.setTitle(bookFields[titleInd]);
					b1.setYear(Integer.parseInt(bookFields[yearInd]));
					findBooks.add(b1);
				}

			}
		} catch (IOException e) {
			throw new DAOException("Find error", e);
		}
		return findBooks;
		return null;
	}


}

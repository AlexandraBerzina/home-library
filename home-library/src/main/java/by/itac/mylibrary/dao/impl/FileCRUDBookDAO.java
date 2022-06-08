package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {
	private final String fileName = "db-home-library.txt";
	private final int idInd = 0;

	private final String DELIMETER = "__ __";

	ClassLoader classLoader = getClass().getClassLoader();
	String path = classLoader.getResource(fileName).getPath();
	File file = new File(path);

	@Override
	public void add(Book book) throws DAOException {
		try (FileWriter fileWriter = new FileWriter(file, true)) {

			StringBuilder bookAdd = new StringBuilder();

			bookAdd.append(book.getId()).append(DELIMETER).append(book.getAuthor()).append(DELIMETER)
					.append(book.getTitle()).append(DELIMETER).append(book.getYear());

			fileWriter.write(bookAdd.toString() + System.lineSeparator());

		} catch (IOException e) {
			throw new DAOException("Error", e);
		}
	}

	@Override
	public void delete(Book book) throws DAOException {
		List<String> listBook = new ArrayList<>();
		StringBuilder bookDelete = new StringBuilder();

		bookDelete.append(book.getId()).append(DELIMETER).append(book.getAuthor()).append(DELIMETER)
				.append(book.getTitle()).append(DELIMETER).append(book.getYear());

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

			String bookFIle;

			while ((bookFIle = fileReader.readLine()) != null) {

				if (!(bookDelete.toString().equals(bookFIle))) {
					listBook.add(bookFIle);
				}
			}
			deleteBook(file);
			for (String s : listBook) {
				fileWriter.write(s);
				fileWriter.newLine();
			}
		} catch (IOException e) {
			throw new DAOException("Error", e);
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		int BookId;
		List<String> listBook = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {

			String book;

			while ((book = fileReader.readLine()) != null) {

				String[] bookFields = book.split(DELIMETER);
				BookId = Integer.parseInt(bookFields[idInd]);
				if (!(BookId == id)) {
					listBook.add(book);
				}
			}
			deleteBook(file);

			for (String s : listBook) {
				fileWriter.write(s);
				fileWriter.newLine();
			}

		} catch (IOException e) {
			throw new DAOException("Error", e);
		}
	}

	private void deleteBook(File file) throws DAOException {
		try (BufferedWriter a = new BufferedWriter(new FileWriter(file, false))) {
			a.write("");
		} catch (IOException e) {
			throw new DAOException("Error during  clearing file", e);
		}
	}

}

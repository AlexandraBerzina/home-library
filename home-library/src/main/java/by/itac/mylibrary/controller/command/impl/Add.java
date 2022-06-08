package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Add implements Command {

	private static final String DELIMETER = "__ __";
	private final char paramDelimeter = ' ';

	@Override
	public String execute(String request) {
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();
		int id = 0;

		String author = null;
		String title = null;
		int year = 0;
	

		request = request.substring(request.indexOf(paramDelimeter));
		String[] b = request.split(DELIMETER);
		id = Integer.parseInt(b[0]);
		author = b[1];
		title = b[2];
		year = Integer.parseInt(b[3]);
		

		Book b1 = new Book();

		try {
			service.add(b1);
			response = "Book save";
		} catch (ServiceException e) {
//				log;
			response = "Error in ADD_BOOK";
		}

		return response;
	}

}

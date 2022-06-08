package by.itac.mylibrary.controller.command.impl;

import java.util.List;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindByAuthor implements Command {
	private final char paramDelimeter = ' ';

	@Override
	public String execute(String request) {
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();
        try {
            request = request.substring(request.indexOf(paramDelimeter) + 1);
          List<Book> bookByAuthor =  service.findByAuthor(request);
          response = "Book founded";
        }catch (ServiceException e){
            // log
           response =  "Error";
       
        }
        return response;
    }
}
	
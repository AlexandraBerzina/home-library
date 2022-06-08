package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.controller.command.impl.Add;
import by.itac.mylibrary.controller.command.impl.Find;
import by.itac.mylibrary.controller.command.impl.FindByAuthor;
import by.itac.mylibrary.controller.command.impl.FindByTitle;
import by.itac.mylibrary.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {

		repository.put(CommandName.ADD, new Add());
		repository.put(CommandName.FIND, new Find());
		repository.put(CommandName.FIND_BY_AUTHOR, new FindByAuthor());
		repository.put(CommandName.FINDK_BY_TITLE, new FindByTitle());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

	}

	Command getCommand(String name) {
		CommandName commandName;
		Command command;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}

}

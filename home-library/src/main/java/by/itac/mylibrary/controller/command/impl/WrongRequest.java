package by.itac.mylibrary.controller.command.impl;
import by.itac.mylibrary.controller.command.Command;

public class WrongRequest implements Command {
	 @Override
	    public String execute(String request) {
	        return "Wrong command";
	    }
	}
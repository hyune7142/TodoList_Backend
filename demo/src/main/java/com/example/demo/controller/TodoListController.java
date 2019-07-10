package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TodoList;
import com.example.demo.service.TodoListService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoListController {
	
	@Autowired TodoListService todoListService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ArrayList<TodoList> index()  {
		
		ArrayList<TodoList> result = todoListService.getTodoList();
		return result;
		
	}
	
}

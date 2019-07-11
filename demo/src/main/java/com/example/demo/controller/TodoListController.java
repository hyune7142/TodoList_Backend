package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TodoList;
import com.example.demo.mapper.TodoListMapper;
import com.example.demo.service.TodoListService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoListController {
	
	@Autowired TodoListService todoListService;
	@Autowired TodoListMapper todoListMapper;
	
	
	// Get TodoList
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Map<String, Object> index()  {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("totalCnt", todoListMapper.getTotalCnt());
		result.put("todoList", todoListService.getTodoList());
		return result;
		
	}
	
	// Insert Todo
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insertTodo(TodoList todoList)  {
		System.out.println("---------- insert Todo :: ");
		todoListService.insertTodo(todoList);
	}
	

	// Update Todo Checked
	@RequestMapping(value="/checked", method=RequestMethod.POST)
	public void checkedTodo(TodoList todoList)  {
		System.out.println("---------- update Check :: ");
		todoListService.checkTodo(todoList);
	}	

	// Delete Todo
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void TodoDelete(TodoList todoList)  {
		System.out.println("---------- delete Todo :: ");
		todoListService.deleteTodo(todoList);
	}	
  
	@RequestMapping(value="/todoitem", method=RequestMethod.PATCH)
	public  void update(TodoList todoitem)  {
	System.out.println(todoitem);
			todoListService.updateItem(todoitem);
	}
	
}

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
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Map<String, Object> index()  {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("totalCnt", todoListMapper.getTotalCnt());
		result.put("todoList", todoListService.getTodoList());
		return result;
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public void insertTodo(TodoList todoList)  {
		todoListService.insertTodo(todoList);
	}
	
	@RequestMapping(value="/checked", method=RequestMethod.POST)
	public void checkedTodo(TodoList todoList)  {
		todoListService.checkTodo(todoList);
	}	
	
	
}

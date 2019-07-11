package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.TodoList;
import com.example.demo.mapper.TodoListMapper;

@Service
public class TodoListServiceImpl implements TodoListService {
	@Autowired TodoListMapper todoListMapper;

	@Override
	public ArrayList<TodoList> getTodoList() {
		
		return todoListMapper.getTodoList();
	}

	@Override
	public void insertTodo(TodoList todoList) {
		todoListMapper.insertTodo(todoList);
	}

	@Override
	public void checkTodo(TodoList todoList) {
		todoListMapper.checkTodo(todoList);
	}

	@Override
	public void deleteTodo(TodoList todoList) {
		todoListMapper.deleteTodo(todoList);
	}
	
	@Override
	public void updateItem(TodoList todoitem) {
		todoListMapper.updateItem(todoitem);
	}

}

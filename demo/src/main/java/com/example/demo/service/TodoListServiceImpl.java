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

}

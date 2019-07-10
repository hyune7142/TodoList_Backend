package com.example.demo.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.MetaData;
import com.example.demo.domain.TodoList;

@Repository
public interface TodoListMapper {
	

	// select TodoList
	public ArrayList<TodoList> getTodoList();

	
}

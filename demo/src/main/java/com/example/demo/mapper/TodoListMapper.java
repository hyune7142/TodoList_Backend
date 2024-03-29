package com.example.demo.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.TodoList;

@Repository
public interface TodoListMapper {
	
	// select All Count
	public int getTotalCnt();
	
	// select TodoList
	public ArrayList<TodoList> getTodoList();
	
	// update TodoList
	public void updateItem(TodoList todoitem);

	// insert TodoList
	public void insertTodo(TodoList todoList);
	
	// update Check
	public void checkTodo(TodoList todoList);
	
	// delete Todo
	public void deleteTodo(TodoList todoList);

}

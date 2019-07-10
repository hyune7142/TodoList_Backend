package com.example.demo.domain;

import java.sql.Timestamp;

public class TodoList {
	
	private int id;
	private String text;
	private String checked;
	private String color;
	private Timestamp moment;
	private String useyn;
	@Override
	public String toString() {
		return "TodoList [id=" + id + ", text=" + text + ", checked=" + checked + ", color=" + color + ", moment="
				+ moment + ", useyn=" + useyn + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Timestamp getMoment() {
		return moment;
	}
	public void setMoment(Timestamp moment) {
		this.moment = moment;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	
	

}

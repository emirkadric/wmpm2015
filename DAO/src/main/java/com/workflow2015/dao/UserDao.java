package com.workflow2015.dao;
import java.util.List;
import com.workflow2015.model.User;

public interface UserDao {
	public void add(User user);
	public void edit(User user);
	public void delete(int userid);
	public User getUser(int userid);
	public List getAllUser();

}

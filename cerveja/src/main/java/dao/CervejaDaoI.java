package dao;

import java.util.List;

import bean.Cerveja;

public interface CervejaDaoI {
	
	public void insert(Cerveja c);
	
	public void update(Cerveja c);
	
	public void delete(Cerveja c);
	
	public List<Cerveja> select();
	
}

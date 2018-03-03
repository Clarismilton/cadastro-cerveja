package controle;

import java.util.List;

import bean.Cerveja;
import dao.CervejaDao;
import dao.CervejaDaoI;

public class CervejaBC implements CervejaBCI {
	
	CervejaDaoI dao = new CervejaDao() ;
	
	public void insert(Cerveja c){
		dao = new CervejaDao();
		dao.insert(c);
	}
	
	public void update(Cerveja c){
		dao = new CervejaDao();
		dao.update(c);
	}
	
	public void delete(Cerveja c){
		dao = new CervejaDao();
		dao.delete(c);
	}
	
	public List<Cerveja> select(){
		dao = new CervejaDao();
		return dao.select();
	}
}
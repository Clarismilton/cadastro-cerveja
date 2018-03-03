package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import bean.Cerveja;
import controle.CervejaBC;


@SuppressWarnings("deprecation")
@ManagedBean(name = "CervejaMB")
@ViewScoped
 // não falamos de escopo ainda... mas é algo simples, ignorem que explico no sábado
public class CervejaMB {
	
	private Cerveja bean;
	private Cerveja alterar;
	private CervejaBC controle;
	private List<Cerveja> list;
	private Boolean exibirBtnAlterar;
	
	/*
	 * este método init tem uma notação PostConstruct
	 * isso faz com que o método rode automaticamente apos o construtor ser chamado
	 * ainda não falamos disso em sala mas vamos abordar isso sábado que vem
	 * */
	
	@PostConstruct
	public void init(){
		this.controle = new CervejaBC();
		this.bean = new Cerveja();
		this.list = controle.select();
		this.alterar = null;
		this.exibirBtnAlterar = false;
	}

	public Boolean getExibirBtnAlterar() {
		return exibirBtnAlterar;
	}

	public void setExibirBtnAlterar(Boolean exibirBtnAlterar) {
		this.exibirBtnAlterar = exibirBtnAlterar;
	}

	
	public Cerveja getAlterar() {
		return alterar;
	}

	public void setAlterar(Cerveja alterar) {
		this.alterar = alterar;
	}

	public Cerveja getBean() {
		return bean;
	}

	public void setBean(Cerveja bean) {
		this.bean = bean;
	}

	public List<Cerveja> getList() {
		return list;
	}

	public void setList(List<Cerveja> list) {
		this.list = list;
	}
	
	public void gravar(){
		this.controle.insert(this.bean);
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Cerveja cadastrada com sucesso!" ) );
        
		
		this.bean = new Cerveja();

	}
	
	
	public void cancelar(){
		this.init();
	}
	
	public void atualizar(){
		this.controle.update(this.bean);
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Cerveja cadastrada com sucesso!" ) );

	}
	
	
	public void excluir(){
		this.controle.delete(this.bean);
		this.init();
		FacesContext context = 
				FacesContext.getCurrentInstance();
        
        context.addMessage(null,
        		new FacesMessage("Sucesso",  
        				"Cerveja cadastrada com sucesso!" ) );

	}
	
	public void preparaUpdate(){
		this.bean = this.alterar;
		this.exibirBtnAlterar = true;
	}
}

package br.com.mfoxsistemas.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import br.com.mfoxsistemas.dao.QuemSomosDao;
import br.com.mfoxsistemas.model.Paragrafo;
import br.com.mfoxsistemas.model.QuemSomos;

public class QuemSomosBO {
	private QuemSomosDao dao;

	public QuemSomosBO() {
		this.dao  = new QuemSomosDao() ;
	}
	
	public QuemSomos inserir(QuemSomos quemSomos){
		try {
			for(Paragrafo p:quemSomos.getSomos()){
				p.setQuemSomos(quemSomos);
			}
			dao.inserir(quemSomos);
		} catch (HibernateException | SQLException e) {
			e.printStackTrace();
		}finally {
			dao.Disconnect();
		}
		return quemSomos;
	}

	public List<QuemSomos> getquemSomos() {
		List<QuemSomos> list = new ArrayList<>();
		try {
			list = dao.getQuemSomos();
		} catch (HibernateException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.Disconnect();
		}
	
		return list;
	}

	public QuemSomos getById(int id) {
		QuemSomos quemSomos = null;
		try {
			quemSomos = dao.getQuemSomosById(id);
		} catch (HibernateException | SQLException e) {
			e.printStackTrace();
		}finally {
			dao.Disconnect();
		}
		return quemSomos;
	}
	
	public QuemSomos getAtivo() {
		QuemSomos quemSomos = null;
		try {
			quemSomos = dao.getQuemSomosAtivo();
		} catch (HibernateException | SQLException e) {
			e.printStackTrace();
		}finally {
			dao.Disconnect();
		}
		return quemSomos;
	}
	
	public int setAtivo(int id) {
		int result = 0;
		try {
			dao.setQuemSomosInativo();
			dao.setQuemSomosAtivo(id);
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}finally {
			dao.Disconnect();
		}
		return result;
	}

	public int delete(int id) {
		int result = 0;
		try {
			dao.excluir(id);
		} catch (HibernateException | SQLException e) {
			result = 1;
			e.printStackTrace();
		}finally {
			dao.Disconnect();
		}
		return result;
	}

	public void endsSession() {
		dao.Disconnect();
		
	}
	
	
}

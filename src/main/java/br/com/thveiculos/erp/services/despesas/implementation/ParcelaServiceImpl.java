package br.com.thveiculos.erp.services.despesas.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thveiculos.erp.entities.despesas.Parcela;
import br.com.thveiculos.erp.repositories.despesas.ParcelaRepository;
import br.com.thveiculos.erp.services.despesas.interfaces.ParcelaService;

@Service
public class ParcelaServiceImpl implements ParcelaService{

	private ParcelaRepository repository;
	
	@Autowired
	public ParcelaServiceImpl(ParcelaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Parcela> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parcela getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parcela save(Parcela obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parcela saveAll(List<Parcela> objs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(List<Parcela> objs) {
		// TODO Auto-generated method stub
		
	}

}

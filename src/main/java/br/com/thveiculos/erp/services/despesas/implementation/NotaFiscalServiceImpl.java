package br.com.thveiculos.erp.services.despesas.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thveiculos.erp.entities.despesas.NotaFiscal;
import br.com.thveiculos.erp.repositories.despesas.NotaFiscalRepository;
import br.com.thveiculos.erp.services.despesas.interfaces.NotaFiscalService;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService{

	private NotaFiscalRepository repository;
	
	@Autowired
	public NotaFiscalServiceImpl(NotaFiscalRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<NotaFiscal> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaFiscal getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaFiscal save(NotaFiscal obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaFiscal saveAll(List<NotaFiscal> objs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(List<NotaFiscal> objs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NotaFiscal update(NotaFiscal obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Administrador;
import com.example.demo.model.AdministradorModel;
import com.example.demo.repository.AdministradorRepository;
import com.example.demo.services.AdministradorService;

@Service("administradorService")
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	@Qualifier("administradorRepository")
	private AdministradorRepository administradorRepository;
	
	@Override
	public List<AdministradorModel> listAllAdministradores() {
		List<AdministradorModel> administradores = new ArrayList<AdministradorModel>();
		for(Administrador administrador: administradorRepository.findAll())
			administradores.add(transform(administrador));
		return administradores;
	}

	@Override
	public Administrador addAdministrador(AdministradorModel administradorModel) {
		return administradorRepository.save(transform(administradorModel));
	}

	@Override
	public int removeAdministrador(int id) {
		administradorRepository.deleteById(id);
		return 0;
	}

	@Override
	public Administrador updateAdministrador(AdministradorModel administradorModel) {
		return administradorRepository.save(transform(administradorModel));
	}

	@Override
	public Administrador transform(AdministradorModel administradorModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(administradorModel, Administrador.class);
	}

	@Override
	public AdministradorModel transform(Administrador administrador) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(administrador, AdministradorModel.class);
	}

	
}

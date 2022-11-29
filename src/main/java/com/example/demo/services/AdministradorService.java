package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Administrador;
import com.example.demo.model.AdministradorModel;

public interface AdministradorService {
	public abstract List<AdministradorModel> listAllAdministradores();
	public abstract Administrador addAdministrador(AdministradorModel administradorModel);
	public abstract int removeAdministrador(int id);
	public abstract Administrador updateAdministrador(AdministradorModel administradorModel);
	public abstract Administrador transform(AdministradorModel administradorModel);
	public abstract AdministradorModel transform(Administrador administrador);
}
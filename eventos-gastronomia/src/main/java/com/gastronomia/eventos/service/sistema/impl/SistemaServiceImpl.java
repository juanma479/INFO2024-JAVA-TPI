package com.gastronomia.eventos.service.sistema.impl;

import com.gastronomia.eventos.domain.Sistema;
import com.gastronomia.eventos.service.sistema.SistemaService;

public class SistemaServiceImpl implements SistemaService{

    @Override
    public Sistema iniciarSistema() {
        return new Sistema();
    }

}

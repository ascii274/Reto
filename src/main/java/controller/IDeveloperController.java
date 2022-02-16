package controller;

import com.ascii274.reto.dto.Categoria;

public interface IDeveloperController {
    public void insertDeveloper() throws Exception;
    public Categoria getCategory(String categoriaString) throws Exception;
}

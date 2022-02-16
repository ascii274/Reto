package controller;

import com.ascii274.reto.dto.Categoria;
import com.ascii274.reto.dto.Developer;
import java.util.Scanner;

public class DeveloperController implements IDeveloperController{

    @Override
    public void insertDeveloper() throws Exception{
        Developer developer;
        Categoria categoria;

        System.out.println("************ Alta developer ******************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca nombre:");
        String name = scanner.nextLine();
        System.out.println("Introduzca email:");
        String email = scanner.nextLine();
        System.out.println("Escoja categoria[\n 0:Front\n 1:Back\n 2:Mobile\n 3:Data]");
        String categoriaString = scanner.nextLine();

        System.out.println("Introduzca telefono:");
        String phone = scanner.nextLine();
        System.out.println("Introduzca fecha: (Ejemplo: Abr 1,2021)");
        String date = scanner.nextLine();

        categoria = getCategory(categoriaString);
        developer = new Developer(name,email,categoria,phone,date);
        System.out.println(developer.toString());

    }


    @Override
    public Categoria getCategory(String categoriaString) throws Exception {
        Categoria categoria = null;
        if(categoriaString ==null) throw new Exception("Error al seleccionar categoria");

        switch (categoriaString.trim()){
            case "0": //Front:
                categoria = Categoria.Front;
                break;
            case "1": //Back
                categoria = Categoria.Back;
                break;
            case "2": //Mobile
                categoria = Categoria.Mobile;
                break;
            case "3": //Data
                categoria = Categoria.Data;
                break;
        }
        return categoria;
    }


}

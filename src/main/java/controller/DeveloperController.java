package controller;

import com.ascii274.reto.dto.Categoria;
import com.ascii274.reto.dto.Developer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Scanner;

public class DeveloperController implements IDeveloperController{

    @Override
    public Developer createDeveloper() throws Exception{
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
        System.out.println(developer.toString()); //TODO delete JJJ
        return developer;

    }

    /**
     * - POJO Developer insert
     * @param developers
     * @param developer
     * @throws Exception
     */
    @Override
    public void insertDeveloper(MongoCollection<Document> developers, Developer developer) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        final Document wrapper = new Document();
//        Document doc = new Document();
        String json = mapper.writeValueAsString(developer);
        wrapper.append("developer",json);
        developers.insertOne(Document.parse(json));

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

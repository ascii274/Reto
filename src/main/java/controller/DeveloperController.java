package controller;

import java.util.Scanner;

public class DeveloperController implements IDeveloperController{

    @Override
    public void insertDeveloper() {

        System.out.println("************ Alta developer ******************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca nombre:");
        String name = scanner.nextLine();
        System.out.println("Introduzca email:");
        String email = scanner.nextLine();
        System.out.println("Introduzca categoria[0:Fron;1:Back;2:Mobile;3:Dat]");
        String categoria = scanner.nextLine();
        System.out.println("Introduzca telefono:");
        String phone = scanner.nextLine();
        System.out.println("Introduzca fecha: (Ejemplo: Abr 1,2021)");
        String date = scanner.nextLine();
    }

}

package com.tudai.ecommerce;

public class App {
    public static void main(String[] args) {
        EccmmerceServer server = new EccmmerceServer();
        System.out.println("Iniciando prueba: simulando el escenario en el que un usuario agrega productos al carrito de compras.");

        System.out.println("Usuario 1 agrega al carrito el producto 1 con una cantidad de 5 unidades.");
        server.addItem(1, new CartEntry(1, 5));

        try {
            System.out.println("Esperando 4 segundos para simular el tiempo transcurrido entre las interacciones de los usuarios...");
            Thread.sleep(20000); // Espera 4000 milisegundos (4 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Usuario 2 agrega al carrito el producto 1 con una cantidad de 15 unidades.");
        server.addItem(2, new CartEntry(1, 15));

        System.out.println("Usuario 2 agrega al carrito el producto 2 con una cantidad de 65 unidades.");
        server.addItem(2, new CartEntry(2, 65));

        try {
            System.out.println("Esperando 4 segundos más para simular la continuación de la actividad de los usuario...");
            Thread.sleep(20000); // Espera 4000 milisegundos (4 segundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Usuario 1 agrega al carrito el producto 2 con una cantidad de 15 unidades.");
        server.addItem(1, new CartEntry(2, 15));

        System.out.println("Usuario 3 agrega al carrito el producto 2 con una cantidad de 25 unidades.");
        server.addItem(3, new CartEntry(2, 25));

        System.out.println("Usuario 4 agrega al carrito el producto 5 con una cantidad de 15 unidades.");
        server.addItem(4, new CartEntry(5, 15));

        System.out.println("Usuario 3 agrega al carrito el producto 1 con una cantidad de 6 unidades.");
        server.addItem(3, new CartEntry(1, 6));

        System.out.println("Prueba finalizada: se han agregado todos los productos a los carritos de los usuarios.");
    }
}

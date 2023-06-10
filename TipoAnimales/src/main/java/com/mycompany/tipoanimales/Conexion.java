/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tipoanimales;

import org.neo4j.driver.*;

/**
 *
 * @author PC-ELHID
 */
public class Conexion {
    private Driver driver;

    public void connect(String uri, String username, String password) {
        driver = TipoAnimales.driver(uri, AuthTokens.basic(username, password));
    }

    public void close() {
        driver.close();
    }

    public Session getSession() {
        return driver.session();
    }

    public static void main(String[] args) {
        Conexion neo4jConnection = new Conexion();
        neo4jConnection.connect("bolt://localhost:7687", "neo4j", "3546arg!");

        try (Session session = neo4jConnection.getSession()) {
            // Realiza tus operaciones con la base de datos Neo4j aquí
            // Por ejemplo, ejecuta una consulta
            String query = "MATCH (n) RETURN n LIMIT 5";

            Result result = session.run(query);

            while (result.hasNext()) {
               // Record record = result.next();
                // Procesa los datos devueltos en el registro
                System.out.println(record.get("n").asMap());
            }
        } finally {
            neo4jConnection.close();
        }
    }
    
}

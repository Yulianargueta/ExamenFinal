/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tipoanimales;

import org.neo4j.driver.*;
import static org.neo4j.driver.GraphDatabase.driver;

/**
 *
 * @author PC-ELHID
 */
public class TipoAnimales {

     public static void main(String[] args) {
        // Configuración de la conexión
        String uri = "bolt://localhost:7687"; // Reemplaza con la URI correcta de tu instancia de Neo4j
        String username = "neo4j"; // Reemplaza con tu nombre de usuario de Neo4j
        String password = "3546arg!"; // Reemplaza con tu contraseña de Neo4j
        
        

        // Crear una instancia del driver
        Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));

        // Abrir una sesión
        try (Session session = driver.session()) {
            // Iniciar una transacción
            try (Transaction tx = session.beginTransaction()) {
                // Consulta para ingresar un nodo
                String query = "CREATE (n:Animal {name: $name })";
                
                
                // Parámetros para la consulta
                Value parameters = Values.parameters("name", "Castor");

                // Ejecutar la consulta dentro de la transacción
                tx.run(query, parameters);

                // Confirmar la transacción
                tx.commit();
            }
        } catch (Exception e) {
            // Manejar errores de conexión o transacción
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            driver.close();
        }
            
        
    }

   
}

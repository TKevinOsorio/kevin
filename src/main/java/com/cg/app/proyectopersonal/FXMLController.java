package com.cg.app.proyectopersonal;

import com.cg.datos.Persona;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FXMLController implements Initializable {

    @FXML
    private WebView webView;

    private boolean mostrar;
    private WebEngine engine;
    private LinkedList<Persona> listaPersonal;

    
    // Meter informacion en la LinkedList 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = webView.getEngine();

        engine.loadContent("<html><h1 align=\"center\">Presione Mostrar para visualizar los datos</h1></html>");
        mostrar = false;
        listaPersonal = new LinkedList<>();
        listaPersonal.add(new Persona(20, "Kevin Osorio", "1115086944"));
        listaPersonal.add(new Persona(20, "Juanes Osorio", "1116098766"));
        listaPersonal.add(new Persona(26, "Rodolfo Gonzales", "1113876544"));
        listaPersonal.add(new Persona(22, "Enriquito Sesamo", "149785445"));
        listaPersonal.add(new Persona (18, "Lizeth Acosta", "1234987644"));
        listaPersonal.add(new Persona (35, "Sebastian Sierra", "1117654222"));
        listaPersonal.add(new Persona (19, "Jhon Jaramillo", "1112877644"));
        listaPersonal.add(new Persona (25, "Gustavo Montoya", "1113456788"));
        listaPersonal.add(new Persona (19, "Edier Herrera", "1110877744"));
        listaPersonal.add(new Persona (19, "Pedrito Melendez", "1112877644"));
        listaPersonal.add(new Persona(19, "hola", "123123123"));
    }

    // Mostrar datos utilizando el menu dezplegable
    @FXML
    private void mostrarDatos(ActionEvent event) {
       
            engine.loadContent(formatoHTML(listaPersonal));
        
    }

    
    // CON BOTONES
    // mostrar datos utiizando el boton
    @FXML
    private void mostrarDatosBoton(ActionEvent event){
        engine.loadContent(formatoHTML(listaPersonal));
               
    }
    
    //Organizar datos por ID utilizando el boton
    @FXML
    private void organizarDatosIdBoton(ActionEvent event) {
        Persona.Criterio = Persona.ID;
        Collections.sort(listaPersonal);
        engine.loadContent(formatoHTML(listaPersonal));
               
    }
    
    //Organizar datos por Edad utilizando el boton
    @FXML
    private void organizarDatosEdad (ActionEvent event){
       Persona.Criterio = Persona.EDAD;
        Collections.sort(listaPersonal);
        engine.loadContent(formatoHTML(listaPersonal));
        
        
    }
    
    
    // Tabla para mostrar los datos
    
    private String formatoHTML(LinkedList<Persona> l) {
        StringBuilder html = new StringBuilder("<html><table border=\"1\" align=\"center\">");
        
        html.append("<tr><td>Nombre</td><td>Identificacion</td><td>Edad</td></tr>");
        for (Persona persona : l) {
            html.append("<tr><td>").append(persona.getNombre()).append("</td>");
            html.append("<td>").append(persona.getIdentificacion()).append("</td>");
            html.append("<td>").append(persona.getEdad()).append("</td></tr>");
        }
        html.append("</table></html>");
        
        return html.toString();
    }

    
    // Presentar la informacion ordenada por edad utilizando el menu dezplegable
    @FXML
    private void ordenamientoEdad(ActionEvent event) {
        Persona.Criterio = Persona.EDAD;
        Collections.sort(listaPersonal);
        engine.loadContent(formatoHTML(listaPersonal));
    }

    // Presentar la informacion ordenada por identificacion utilizando el menu dezplegable
    @FXML
    private void ordenamientoIdentificacion(ActionEvent event) {
        Persona.Criterio = Persona.ID;
        Collections.sort(listaPersonal);
        engine.loadContent(formatoHTML(listaPersonal));
    }

    // mostrar los creditos utilizando el menu dezplegable
    
    @FXML
    private void creditos(ActionEvent event) {
                engine.loadContent("<html><h1 align=\"center\">Hecho por: Kevin Osorio</h1></html>");
    }
    
    //Salir del programa utilizando el menu dezplegable
    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }

}

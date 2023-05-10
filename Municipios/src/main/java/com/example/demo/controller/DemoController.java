package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.Municipios;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/documentation")
    public String documentation() {
        return "documentacion";
    }

    @GetMapping("/about")
    public String about(Model model) {
        Map<String, Municipios> municipios = new HashMap<>();
        municipios.put("001", createMunicipio("Calkiní", "001", 1, "Cakiní"));
        municipios.put("002", createMunicipio("San Francisco de Campeche", "002", 2, "Campeche"));
        municipios.put("003", createMunicipio("Ciudad del Carmen", "003", 3, "Carmen"));
        municipios.put("004", createMunicipio("Heroica Ciudad de Champotón", "004", 4, "Champotón"));
        municipios.put("005", createMunicipio("Hecelchakán", "005", 5, "Hecelchakán"));
        municipios.put("006", createMunicipio("Hopelchén", "006", 6, "Hopelchén"));
        municipios.put("007", createMunicipio("Palizada", "007", 7, "Palizada"));
        municipios.put("008", createMunicipio("Tenabo", "008", 8, "Tenabo"));
        municipios.put("009", createMunicipio("Escárcega", "009", 9, "Escárcega"));
        municipios.put("010", createMunicipio("Xpujil", "010", 10, "Calakmul"));
        municipios.put("011", createMunicipio("Candelaria", "011", 0, "Candelaria"));
        municipios.put("012", createMunicipio("Seybaplaya", "012", 12, "Seybaplaya"));
        municipios.put("013", createMunicipio("Dzibalché", "013", 13, "Dzibalché"));

        model.addAttribute("municipios", municipios);
        return "about";
    }

    private Municipios createMunicipio(String nombre, String cveInegi, int id, String cabecera) {
        Municipios municipio = new Municipios();
        municipio.setNombre(nombre);
        municipio.setCveInegi(cveInegi);
        municipio.setId(id);
        municipio.setCabecera(cabecera);
        return municipio;
    }
}

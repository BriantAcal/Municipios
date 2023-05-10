package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.MunicipiosDTO;

@Controller
public class MunicipiosController {

    @GetMapping("/API/Municipios/{km}")
    public String viewMunicipios(@PathVariable("km") String km, Model model) {
        String titulo = "Pagina API con Spring Boot";
        model.addAttribute("name", km);
        model.addAttribute("titulo", titulo);
        MunicipiosDTO municipiosDTO = startMunicipiosResultDTO(km);
        model.addAttribute("municipiosDTO", municipiosDTO);
        return "Municipios";
    }

    public MunicipiosDTO startMunicipiosResultDTO(String km) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MunicipiosDTO> resp =
                restTemplate.getForEntity(
                        String.format("https://Municipios.com/api/municipios/%s", km), MunicipiosDTO.class);
        return resp.getBody();
    }

    @GetMapping("/Index/{id}")
    public String index(@PathVariable("id") String id, Model model) {
        String titulo = "Página de inicio con Spring Boot";
        model.addAttribute("titulo", titulo);

        MunicipiosDTO municipiosDTO = startMunicipiosResultDTO(id);
        model.addAttribute("municipiosDTO", municipiosDTO);

        return "index";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "Se produjo un error durante la ejecución");
        return modelAndView;
    }
}

package cl2.daw.ganoza.crud.controller;

import cl2.daw.ganoza.crud.dto.FilmDTO;
import cl2.daw.ganoza.crud.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController{

    @Autowired
    FilmService filmService;

    @GetMapping
    public String getFilms(Model model) {
        System.out.println("Holi");
        List<FilmDTO> list = filmService.getAllFilms();
        list.forEach(filmDTO -> System.out.println(filmDTO.description()));
        model.addAttribute("films", list);
        return "list";
    }

}

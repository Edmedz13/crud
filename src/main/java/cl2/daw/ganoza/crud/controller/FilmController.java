package cl2.daw.ganoza.crud.controller;

import cl2.daw.ganoza.crud.dto.FilmDTO;
import cl2.daw.ganoza.crud.model.Film;
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
        List<FilmDTO> list = filmService.getAllFilms();
        model.addAttribute("films", list);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public String getDetailedFilm(@PathVariable Integer id, Model model){
        Film film = filmService.getDetailsOfFilm(id);
        model.addAttribute("film", film);
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String updateFilmView(@PathVariable Integer id, Model model){
        Film film = filmService.getDetailsOfFilm(id);
        model.addAttribute("film", film);
        return "edit";
    }

    @PostMapping("/edit-confirm")
    public String updateFilm(@ModelAttribute Film film, Model model){
        filmService.updateFilm(film);
        return "redirect:/films";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id, Model model) {
        filmService.deleteFilm(id);
        return "redirect:/films";
    }
}

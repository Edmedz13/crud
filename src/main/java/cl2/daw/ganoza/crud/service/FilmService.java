package cl2.daw.ganoza.crud.service;

import cl2.daw.ganoza.crud.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl2.daw.ganoza.crud.repository.FilmRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService implements FilmServiceIF {
    @Autowired
    FilmRepository filmRepository;

    //@Cacheable("films")
    public List<FilmDTO> getAllFilms() {
        List<FilmDTO> listOfFilms = new ArrayList<>();
        filmRepository.findAll().forEach(
                film -> {
                    FilmDTO filmDto = new FilmDTO(film.getId(),
                            film.getTitle(),
                            film.getDescription(),
                            film.getLanguage(),
                            film.getRentalDuration());
                    listOfFilms.add(filmDto);
                }
                );
        return listOfFilms;
    }
}

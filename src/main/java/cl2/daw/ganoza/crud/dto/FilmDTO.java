package cl2.daw.ganoza.crud.dto;

import cl2.daw.ganoza.crud.model.Language;

public record FilmDTO(Integer filmId,
                      String title,
                      String description,
                      Language language,
                      Integer rentalDuration) {
}
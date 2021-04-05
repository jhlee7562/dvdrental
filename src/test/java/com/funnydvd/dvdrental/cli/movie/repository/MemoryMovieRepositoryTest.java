package com.funnydvd.dvdrental.cli.movie.repository;

import com.funnydvd.dvdrental.cli.movie.domain.Movie;
import com.funnydvd.dvdrental.cli.movie.domain.SerchCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static com.funnydvd.dvdrental.cli.movie.domain.SerchCondition.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMovieRepositoryTest {

    MovieRepository repository = new MemoryMovieRepository();

    @Test
    @DisplayName("영화정보를 저장요청하면 메모리디비에 잘 저장되어야 한다.")
    void insertTest() {
        Movie newMovie = new Movie("nojam movie", "korea", 2021);

        repository.addMovie(newMovie);

        Movie findMovie = repository.serchMovieOne(newMovie.getSerialNumber());
        System.out.println("findMovie = " + findMovie);
    }

    @Test
    @DisplayName("전체조회시 모든 영화정보가 출력되어야 한다.")
    void selectAll() {
        List<Movie> movieList = repository.searchMovieList("", ALL);
        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    @Test
    @DisplayName("영화 정보 삭제시 해당 영화가 조회되면 안된다.")
    void removeTest() {
        repository.removeMovie(3);

        Movie movie = repository.serchMovieOne(3);
        System.out.println("movie = " + movie);
    }

    @Test
    @DisplayName("조건에 따라 검색결과가 리턴되어야 한다.")
    void searchTest() {

        for (Movie movie : repository.searchMovieList("타이타닉", TITLE)) {
            System.out.println(movie);
        }

        System.out.println("========================================================");

        for (Movie movie : repository.searchMovieList("미국", NATION)) {
            System.out.println(movie);
        }

        System.out.println("========================================================");

        for (Movie movie : repository.searchMovieList("1994", PUB_YEAR)) {
            System.out.println(movie);
        }

        System.out.println("========================================================");

        List<Movie> movieList = repository.searchMovieList("", ALL);
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (i % 2 == 0) {
                movie.setRental(true);
            }
        }

//        repository.searchMovieList("", POSSIBLE).forEach(out::println);


    }
}
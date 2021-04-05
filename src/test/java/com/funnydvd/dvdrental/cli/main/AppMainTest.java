package com.funnydvd.dvdrental.cli.main;

import com.funnydvd.dvdrental.cli.movie.controller.MovieController;
import com.funnydvd.dvdrental.cli.movie.domain.SerchCondition;
import com.funnydvd.dvdrental.cli.movie.repository.MemoryMovieRepository;
import com.funnydvd.dvdrental.cli.movie.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppMainTest {

    private MovieController controller = new MovieController();
    private MovieRepository repository = new MemoryMovieRepository();

    @Test
    @DisplayName("컨트롤러를 통해 영화 정보를 입력하면 잘 저장되어야 한다.")
    void insertControlTest(){
        controller.start();

        System.out.println("============================================");
        repository.searchMovieList("", SerchCondition.ALL)
                .forEach(m -> System.out.println(m));
        System.out.println("============================================");
    }

}
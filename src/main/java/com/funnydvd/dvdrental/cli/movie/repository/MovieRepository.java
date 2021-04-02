package com.funnydvd.dvdrental.cli.movie.repository;

import com.funnydvd.dvdrental.cli.movie.domain.Movie;
import com.funnydvd.dvdrental.cli.movie.domain.SerchCondition;

import java.util.List;

public interface MovieRepository {

    //영화 정보 추가
    void addMovie(Movie movie);

    //조건별 영화 검색
    /**
     * @param keyword 검색어
     * @param condition 검색조건
     * @return 검색에 따른 영화정보 리스트
     */

//    serchMovieList("메롱", PUB_YEAR);
    List<Movie> searchMovieList(String keyword, SerchCondition condition);

    //특정 영화 1개 검색
    Movie serchMovieOne(int serialNumber);

    //특정 영화 삭제
    void removeMovie(int serialNumber);

}

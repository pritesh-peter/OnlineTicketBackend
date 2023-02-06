package com.ticket.core.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer movieId;

        @Column(length = 100, nullable = false)
        private String movie_name;

        @Column(length = 10000)
        private  String description;

        private  String image;

        private  String movie_hours;

        private  String movie_language;

        private  String movie_rating;

        private Date movie_date;


    }

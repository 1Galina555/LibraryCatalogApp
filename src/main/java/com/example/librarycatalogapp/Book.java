package com.example.librarycatalogapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="library_t")
@Getter
@Setter
public class Book {
        // поля - соответствуют столбцам (атрибутам) БД
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name="name_f", nullable = false)
        private String name;

        @Column(name="author_f", nullable = false)
        private String author;

        @Column(name="genre_f", nullable = false)
        private String genre;
         @Column(name="year_f", nullable = false)
         private Integer year;

        // конструкторы
        public Book() {}

        public Book(String name,String author,String genre, Integer year) {
            this.name = name;
            this.author = author;
            this.genre = genre;
            this.year=year;
        }



        @Override
        public String toString() {
            return id + " - " + name + " - " + author + " - " + genre + " - " + year;
        }
    }



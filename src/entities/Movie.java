package entities;

import TADs.listaSimple.ListaEnlazada;

import java.util.Date;

public class Movie {

    String imbdTitleId;
    String title;
    String originalTitle;
    int year;
    Date datePublished;
    ListaEnlazada<String> genre;
    int duration;
    ListaEnlazada<String> country;
    String language;
    ListaEnlazada<String> director;
    ListaEnlazada<String> writer;

}

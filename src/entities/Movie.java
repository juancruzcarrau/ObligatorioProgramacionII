package entities;

import TADs.listaSimple.ListaEnlazada;

import java.util.Date;

public class Movie {

    private final String imbdTitleId;
    private final String title;
    private final String originalTitle;
    private final int year;
    private final Date datePublished;
    private final ListaEnlazada<String> genre;
    private final int duration;
    private final ListaEnlazada<String> country;
    private final String language;
    private final ListaEnlazada<String> director;
    private final ListaEnlazada<String> writer;
    private final String productionCompany;
    private final ListaEnlazada<String> actors;
    private final String description;
    private final float avgVote;
    private final int votes;
    private final String budget;
    private final String usaGrossIncome;
    private final String worldwideGrossIncome;
    private final float metaScore;
    private final float reviewsFromUsers;
    private final float reviewsFromCritics;

    public Movie(String imbdTitleId, String title, String originalTitle,
                 int year, Date datePublished, ListaEnlazada<String> genre,
                 int duration, ListaEnlazada<String> country, String language,
                 ListaEnlazada<String> director, ListaEnlazada<String> writer,
                 String productionCompany, ListaEnlazada<String> actors,
                 String description, float avgVote, int votes, String budget,
                 String usaGrossIncome, String worldwideGrossIncome,
                 float metaScore, float reviewsFromUsers,
                 float reviewsFromCritics) {
        this.imbdTitleId = imbdTitleId;
        this.title = title;
        this.originalTitle = originalTitle;
        this.year = year;
        this.datePublished = datePublished;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.director = director;
        this.writer = writer;
        this.productionCompany = productionCompany;
        this.actors = actors;
        this.description = description;
        this.avgVote = avgVote;
        this.votes = votes;
        this.budget = budget;
        this.usaGrossIncome = usaGrossIncome;
        this.worldwideGrossIncome = worldwideGrossIncome;
        this.metaScore = metaScore;
        this.reviewsFromUsers = reviewsFromUsers;
        this.reviewsFromCritics = reviewsFromCritics;
    }

    public String getImbdTitleId() {
        return imbdTitleId;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int getYear() {
        return year;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public ListaEnlazada<String> getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public ListaEnlazada<String> getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public ListaEnlazada<String> getDirector() {
        return director;
    }

    public ListaEnlazada<String> getWriter() {
        return writer;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public ListaEnlazada<String> getActors() {
        return actors;
    }

    public String getDescription() {
        return description;
    }

    public float getAvgVote() {
        return avgVote;
    }

    public int getVotes() {
        return votes;
    }

    public String getBudget() {
        return budget;
    }

    public String getUsaGrossIncome() {
        return usaGrossIncome;
    }

    public String getWorldwideGrossIncome() {
        return worldwideGrossIncome;
    }

    public float getMetaScore() {
        return metaScore;
    }

    public float getReviewsFromUsers() {
        return reviewsFromUsers;
    }

    public float getReviewsFromCritics() {
        return reviewsFromCritics;
    }
}

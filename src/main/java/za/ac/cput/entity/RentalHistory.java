package za.ac.cput.entity;

/*
    Movie.java
    Entity for the Movie
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RentalHistory implements Serializable {
    @Id private String movieRentalId;
    private String movieId;
    private String userId;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy") @Temporal(TemporalType.DATE) private Date dateRented;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss") @Temporal(TemporalType.TIME) private Date timeRented;

    protected RentalHistory(){}

    private RentalHistory(RentalBuilder RentalBuilder){
        this.movieRentalId = RentalBuilder.movieRentalId;
        this.movieId = RentalBuilder.movieId;
        this.userId = RentalBuilder.userId;
        this.dateRented = RentalBuilder.dateRented;
        this.timeRented = RentalBuilder.timeRented;

    }

    public String getMovieRentalId() {
        return movieRentalId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getUserId() {
        return userId;
    }

    public Date getDateRented() {
        return dateRented;
    }

    public Date getTimeRented() {
        return timeRented;
    }

    public static class RentalBuilder {
        private String movieRentalId,movieId, userId;
        private Date dateRented, timeRented;

        public RentalBuilder setMovieRentalId(String movieRentalId) {
            this.movieRentalId = movieRentalId;
            return this;
        }

        public RentalBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public RentalBuilder setUserId(String genres) {
            this.userId = genres;
            return this;
        }

        public RentalBuilder setDateRented(Date dateRented) {
            this.dateRented = dateRented;
            return this;
        }

        public RentalBuilder setTimeRented(Date timeRented) {
            this.timeRented = timeRented;
            return this;
        }

        public RentalBuilder copy(RentalHistory rentalHistory){
            this.movieId=rentalHistory.movieId;
            this.dateRented =rentalHistory.dateRented;
            this.userId =rentalHistory.userId;
            this.timeRented =rentalHistory.timeRented;
            return this;
        }

        public RentalHistory build(){
            return new RentalHistory(this);
        }
    }

}

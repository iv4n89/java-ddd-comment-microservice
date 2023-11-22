package com.films.service.comments.domain.models;

import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.ImageId;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable {
  private final FilmId filmId;
  private final String title;
  private final Date launchDate;
  private final Integer meanRating;
  private final ImageId imageId;

  private Film(Builder builder) {
    filmId = builder.filmId;
    title = builder.title;
    launchDate = builder.launchDate;
    meanRating = builder.meanRating;
    imageId = builder.imageId;
  }

  public static Builder builder() {
    return new Builder();
  }

  public FilmId getFilmId() {
    return filmId;
  }

  public String getTitle() {
    return title;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public Integer getMeanRating() {
    return meanRating;
  }

  public ImageId getImageId() {
    return imageId;
  }

  public static final class Builder {
    private FilmId filmId;
    private String title;
    private Date launchDate;
    private Integer meanRating;
    private ImageId imageId;

    private Builder() {}

    public Builder filmId(FilmId val) {
      filmId = val;
      return this;
    }

    public Builder title(String val) {
      title = val;
      return this;
    }

    public Builder launchDate(Date val) {
      launchDate = val;
      return this;
    }

    public Builder meanRating(Integer val) {
      meanRating = val;
      return this;
    }

    public Builder imageId(ImageId val) {
      imageId = val;
      return this;
    }

    public Film build() {
      return new Film(this);
    }
  }
}

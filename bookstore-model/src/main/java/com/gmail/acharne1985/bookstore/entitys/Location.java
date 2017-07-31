package com.gmail.acharne1985.bookstore.entitys;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String titleLocation;

    @Column(name = "count")
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "citys_id")
    private City city;

    @OneToMany(mappedBy = "location")
    private List<BookLocation> bookLocations;

    public Location() {

    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleLocation() {
        return titleLocation;
    }

    public void setTitleLocation(String titleLocation) {
        this.titleLocation = titleLocation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<BookLocation> getBookLocations() {
        return bookLocations;
    }

    public void setBookLocations(List<BookLocation> bookLocations) {
        this.bookLocations = bookLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (titleLocation != null ? !titleLocation.equals(location.titleLocation) : location.titleLocation != null)
            return false;
        if (count != null ? !count.equals(location.count) : location.count != null) return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (bookLocations != null ? !bookLocations.equals(location.bookLocations) : location.bookLocations != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titleLocation != null ? titleLocation.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (bookLocations != null ? bookLocations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Location [id = ");
        sb.append(id);
        sb.append(", title = ");
        sb.append(titleLocation);
        sb.append(", count = ");
        sb.append(count);
        sb.append(", city = ");
        sb.append(city);
        sb.append(", book_locations = ");
        sb.append(bookLocations);
        sb.append("]");

        return sb.toString();
    }
}

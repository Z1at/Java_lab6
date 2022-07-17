package NikandrovLab5.data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Class of city
 */
public class City implements Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double area; //Значение поля должно быть больше 0
    private Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer metersAboveSeaLevel;
    private Climate climate; //Поле может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле может быть null
    private Human governor; //Поле не может быть null


    /**
     * Class constructor
     *
     * @param aName                - name of city
     * @param aCoordinates         - coordinates of city
     * @param aArea                - area of city
     * @param aPopulation          - number of people in the city
     * @param aMetersAboveSeaLevel - number if meters above sea level
     * @param aClimate             - the climate of the city
     * @param aGovernment          - government of city
     * @param aStandardOfLiving    - standard of living in city
     * @param aGovernor            - governor of city
     */
    public City(String aName, Coordinates aCoordinates, double aArea,
                Long aPopulation, Integer aMetersAboveSeaLevel, Climate aClimate, Government aGovernment,
                StandardOfLiving aStandardOfLiving, Human aGovernor) {
//        id = aId;
        name = aName;
        coordinates = aCoordinates;
//        creationDate = aCreationDate;
        area = aArea;
        population = aPopulation;
        metersAboveSeaLevel = aMetersAboveSeaLevel;
        climate = aClimate;
        government = aGovernment;
        standardOfLiving = aStandardOfLiving;
        governor = aGovernor;
    }

    public int getId() {
        return id;
    }

    public void setId(int aId){
        id = aId;
    }

    public void setCreationDate() {
        this.creationDate = ZonedDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Integer getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public void setMetersAboveSeaLevel(Integer metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public Government getGovernment() {
        return government;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    public void setStandardOfLiving(StandardOfLiving standardOfLiving) {
        this.standardOfLiving = standardOfLiving;
    }

    public Human getGovernor() {
        return governor;
    }

    public void setGovernor(Human governor) {
        this.governor = governor;
    }

    @Override
    public String toString() {
        return "id = " + id + '\n' +
                "name = " + name + '\n' +
                "coordinates = " + "(" + coordinates.getX() + ", " + coordinates.getY() + ")" + '\n' +
                "creationDate = " + creationDate + '\n' +
                "area = " + area + '\n' +
                "population = " + population + '\n' +
                "metersAboveSeaLevel = " + metersAboveSeaLevel + '\n' +
                "climate = " + climate + '\n' +
                "government = " + government + '\n' +
                "standardOfLiving = " + standardOfLiving + '\n' +
                "name of governor = " + governor.getName() + ". height of governor: " + governor.getHeight() +
                ". " + " birthday of governor: " + governor.getBirthday() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Double.compare(city.area, area) == 0 && Objects.equals(name, city.name) &&
                Objects.equals(coordinates, city.coordinates) && Objects.equals(creationDate, city.creationDate) &&
                Objects.equals(population, city.population) &&
                Objects.equals(metersAboveSeaLevel, city.metersAboveSeaLevel) && climate == city.climate &&
                government == city.government && standardOfLiving == city.standardOfLiving &&
                Objects.equals(governor, city.governor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, climate,
                government, standardOfLiving, governor);
    }
}

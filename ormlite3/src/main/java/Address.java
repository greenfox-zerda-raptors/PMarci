import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by posam on 2016-12-14.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@DatabaseTable(tableName = "address")
public class Address {
    private static final String STREET_FIELD_NAME = "street";
    private static final String CITY_FIELD_NAME = "city";
    private static final String POSTCODE_FIELD_NAME = "postCode";
    private static final String NAME_FIELD_NAME = "name";
    private static final String COUNTRY_FIELD_NAME = "country";

    @DatabaseField(columnName = STREET_FIELD_NAME)
    private String street;
    @DatabaseField(columnName = CITY_FIELD_NAME)
    private String city;
    @DatabaseField(columnName = POSTCODE_FIELD_NAME)
    private int postCode;
    @DatabaseField(columnName = COUNTRY_FIELD_NAME)
    private String country;
    @DatabaseField(id = true, columnName = NAME_FIELD_NAME)
    private String name;

    public Address(String street, String city, int postCode, String country, String name) {
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.name = name;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("{ %npostCode = %d, %ncity = %s, %ncountry = %s, %nstreet = %s %n}", postCode, city, country, street);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

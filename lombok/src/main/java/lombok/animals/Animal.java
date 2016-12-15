package lombok.animals;

/**
 * Created by kicsen on 2016. 12. 12..
 */

public interface Animal {

//    String getName();
//
//    LocalDate getBirthDate();
//
//    List getChildren();
//
//    Integer getChildrenNumber();
//
//    Long getMovedDistanceInMilliMeters();
//
//    Double getHappiness();
//
//    Long getWeightInGram();

    void logOwnInfo();

    void move(long distanceInMilliMeters);
}

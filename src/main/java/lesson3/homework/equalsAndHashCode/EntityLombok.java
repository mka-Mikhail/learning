package lesson3.homework.equalsAndHashCode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EntityLombok {
    static int count;
    private int id;
    private String name;

    public EntityLombok(String name) {
        this.name = name;
        id = ++count;
    }

    public static void main(String[] args) {
        EntityLombok entity1 = new EntityLombok("Robot");
        EntityLombok entity2 = new EntityLombok("Car");
        EntityLombok entity3 = entity1;
        EntityLombok entity4 = new EntityLombok("Car");
        entity4.setId(entity2.getId());
        System.out.println("entity1: " + entity1);
        System.out.println("entity2: " + entity2);
        System.out.println("entity3: " + entity3);
        System.out.println("entity4: " + entity4);
        System.out.println("entity1 == entity2: " + entity1.equals(entity2));
        System.out.println("entity1 == entity3: " + entity1.equals(entity3));
        System.out.println("entity4 == entity2: " + entity4.equals(entity2));
        System.out.println("entity1 == entity2: " + (entity1.hashCode() == entity2.hashCode()));
        System.out.println("entity1 == entity3: " + (entity1.hashCode() == entity3.hashCode()));
        System.out.println("entity4 == entity2: " + (entity4.hashCode() == entity2.hashCode()));
    }
}

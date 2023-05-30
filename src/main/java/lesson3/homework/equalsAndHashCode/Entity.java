package lesson3.homework.equalsAndHashCode;

import java.util.Objects;

public class Entity {
    static int count;
    private int id;
    private String name;

    public Entity(String name) {
        this.name = name;
        id = ++count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entity: " + id + ", " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static void main(String[] args) {
        Entity entity1 = new Entity("Robot");
        Entity entity2 = new Entity("Car");
        Entity entity3 = entity1;
        Entity entity4 = new Entity("Car");
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

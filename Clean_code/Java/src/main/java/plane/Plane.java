package plane;

import java.util.Objects;

 public abstract class Plane {
    String planemodel;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.planemodel = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return planemodel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int GetMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMinLoadCapacity() {
      
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + planemodel + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Plane)) return false;
        Plane currentplane = (Plane) o;
        return maxSpeed == currentplane.maxSpeed &&
                maxFlightDistance == currentplane.maxFlightDistance &&
                maxLoadCapacity == currentplane.maxLoadCapacity &&
                Objects.equals(planemodel, currentplane.planemodel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planemodel, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}

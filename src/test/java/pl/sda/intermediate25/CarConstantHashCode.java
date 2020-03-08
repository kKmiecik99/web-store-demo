package pl.sda.intermediate25;

import java.util.Objects;

public class CarConstantHashCode {
    private String model;

    public CarConstantHashCode(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarConstantHashCode that = (CarConstantHashCode) o;
        return Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return 7;
    }
}

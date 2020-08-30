package beans;


public class IngredientContainer {
    private String name;
    private Integer curVolume;
    private Boolean isEmpty;

    public IngredientContainer(String name, Integer curVolume, Boolean isEmpty) {
        this.name = name;
        this.curVolume = curVolume;
        this.isEmpty = isEmpty;
    }

    public void refill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Integer getCurVolume() {
        return curVolume;
    }

    public void setCurVolume(Integer curVolume) {
        this.curVolume = curVolume;
    }
}

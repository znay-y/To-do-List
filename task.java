public class task {
    String name;
    String description;
    boolean complete;

    public task(String name, String description) {
        this.name = name;
        this.description = description;
        this.complete = false;
    }

    public task(String name) {
        this.name = name;
        this.description = null;
        this.complete = false;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

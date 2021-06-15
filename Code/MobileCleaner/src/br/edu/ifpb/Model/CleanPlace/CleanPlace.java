package br.edu.ifpb.Model.CleanPlace;

public class CleanPlace {

    private String name;
    private String sector;

    public CleanPlace(String name, String sector) {
        this.name = name;
        this.sector = sector;
    }

    public CleanPlace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Local de Limpeza: " + name +
                "  |  Setor: " + sector +
                "\n                          "
                ;
    }

}

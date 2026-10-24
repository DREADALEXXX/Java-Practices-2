public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String csv) {
        String[] p = csv.split(",");
        if (p.length != 4) {
            throw new IllegalArgumentException("Неверный формат: " + csv);
        }
        this.id          = p[0].trim();
        this.description = p[1].trim();
        this.color       = p[2].trim();
        this.size        = p[3].trim();
    }

    @Override
    public String toString() {
        // По заданию: «объяснение и значение полей построчно»
        return "Shirt:\n" +
                "  id:          " + id + "\n" +
                "  description: " + description + "\n" +
                "  color:       " + color + "\n" +
                "  size:        " + size;
    }

    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        Shirt[] shirtObjects = new Shirt[shirts.length];
        for (int i = 0; i < shirts.length; i++) {
            shirtObjects[i] = new Shirt(shirts[i]);
        }

        for (Shirt s : shirtObjects) {
            System.out.println(s);
            System.out.println();
        }
    }
}
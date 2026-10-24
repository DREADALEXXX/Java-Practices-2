public class Person {
    private final String surname;   // фамилия — обязательна
    private final String name;      // имя — может быть null/пусто
    private final String patronymic; // отчество — может быть null/пусто

    public Person(String surname, String name, String patronymic) {
        this.surname    = surname;
        this.name       = name;
        this.patronymic = patronymic;
    }

    /**
     * Возвращает "Фамилия И.О." с учётом отсутствия имени/отчества.
     * Оптимизировано: StringBuilder + один проход, без лишних объектов.
     */
    public String getFullName() {
        StringBuilder sb = new StringBuilder(32);   // запас ёмкости
        sb.append(surname);

        boolean hasName = name != null && !name.isEmpty();
        boolean hasPatr = patronymic != null && !patronymic.isEmpty();

        if (hasName || hasPatr) {
            sb.append(' ');
        }
        if (hasName) {
            sb.append(name.charAt(0)).append('.');
        }
        if (hasPatr) {
            sb.append(patronymic.charAt(0)).append('.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Иванов", "Иван", "Иванович").getFullName()); // Иванов И.И.
        System.out.println(new Person("Петров", "Пётр", null).getFullName());       // Петров П.
        System.out.println(new Person("Сидоров", null, "Сидорович").getFullName()); // Сидоров С.
        System.out.println(new Person("Смирнов", null, null).getFullName());        // Смирнов
    }
}
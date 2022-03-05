import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Численность несовершеннолетних " + count);
        List<String> warFamilyList = persons.stream()
                .filter(x -> x.getAge() > 18)
                .filter(y -> y.getAge() < 27)
                .map(value -> value.getFamily() + " ")
                .collect(Collectors.toList());
        System.out.println("Список лиц призывного возраста");
        System.out.println(warFamilyList);
        List<Person> hightEducation = persons.stream()
                .filter(x -> (x.getSex() == Sex.MAN && x.getAge() > 18 && x.getAge() < 60 && x.getEducation() == Education.HIGHER)
                        ||  (x.getSex() == Sex.WOMAN && x.getAge() > 18 && x.getAge() < 65 && x.getEducation() == Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Отсортированный по фамилиям список работоспособных с высшим образованием");
        System.out.println(hightEducation);

    }
}

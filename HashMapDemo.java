import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> empIds= new HashMap<>();
        empIds.put("Abrar",101);
        empIds.put("asdf",102);
        empIds.put("dgfsh",103);
        empIds.put("Abqwerrar",104);
        empIds.put("yrth",105);
        empIds.put("23r",106);
        empIds.clone();
        System.out.println(empIds.clone());
    }
}

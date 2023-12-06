package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.*;


@AllArgsConstructor
@Setter
@Getter
public class ListBook {
    private List<String> list;
    public ListBook() {
        this.list = new ArrayList<>();
    }

    public void ad(String ad) {
        list.add(ad);
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String json = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter("./file")) {
            fileWriter.write(json);
        } catch (Exception e) {
            System.out.println("Ошибка");
        }
    }

    public void input() {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./file"))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();
            List<String> books = gson.fromJson(json, listType);
            for (String book : books) {
                System.out.println(book);
                list.add(book);
            }
        } catch (Exception e) {
            System.out.println("Упс, произошла ошибка");
        }
    }
    public void search() {
        Scanner scanner1 = new Scanner(System.in);
        String searchWord = scanner1.nextLine();
        for (String fruit : list) {
            if (fruit.toString().contains(searchWord)) {
                System.out.println(fruit);
            }
        }
    }

    public void remove(String str) {
        String strRemove = "";
        for (String fruit : list) {
            if (fruit.toString().contains(str)) {
                strRemove = fruit;
                break;
            }
        }
        list.remove(strRemove);
    }

}

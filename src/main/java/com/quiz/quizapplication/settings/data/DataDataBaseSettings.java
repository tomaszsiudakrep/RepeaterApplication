package com.quiz.quizapplication.settings.controller;

import com.quiz.quizapplication.Exercises;
import com.quiz.quizapplication.database.DataFromDb;
import com.quiz.quizapplication.database.GroupExToDb;

import java.sql.SQLException;

public class DataBaseSettingsController {

    GroupExToDb groupExToDb = new GroupExToDb();
    DataFromDb dataFromDb = new DataFromDb();

    Exercises exercises = new Exercises("Bankomat", "Stwórz interfejs obsługujący bankomat (ang. ATM) zawierający:\n" +
            "•\tDwie metody wymagające implementacji – wpłata i wypłata\n" +
            "•\tMetodę domyślną – informację o połączeniu z bankiem\n" +
            "•\tMetodę statyczną – informację o zakończeniu działania bankomatu\n" +
            "Następnie zaimplementuj taki interfejs do klasy o nazwie ATMImpl (ATM Implementation) i stwórz ciała dla metod, które tego wymagają. W klasie Application w metodzie main wywołaj każdą metodę.\n");

    Exercises exercises2 = new Exercises("Odwazny rycerz", "W swojej aplikacji stwórz:\n" +
            "•\tInterfejs Quest, który będzie zawierał w metodę process().\n" +
            "•\tDwie klasy DeadIslandQuest i EliteKnightQuest, które implementują interfejs Quest – wykorzystaj polecenie System.out.println().\n" +
            "•\tStwórz klasę Knight, która w konstruktorze przyjmie różne zadania implementujące interfejs Quest. W klasie Knight stwórz też dowolną metodę, która wywoła metodę process() interfejsu Quest.\n" +
            "•\tGłówny program powinien wyświetlić informacje o zakończeniu zadania razem z jego nazwą.\n");

    Exercises exercises3 = new Exercises("Obliczamy srednia", "Napisz program obliczający wartość średnią 20 elementów tablicy. Pamiętaj, że:\n" +
            "•\telementy tablicy powinny być typu int,\n" +
            "•\twynik prawdopodobnie nie będzie wartością całkowitą,\n" +
            "•\tpętla powinna wyświetlić wszystkie elementy tablicy,\n" +
            "•\tna koniec powinna zostać wyświetlona wartość średniej.\n");

    Exercises exercises4 = new Exercises("Srednia bez skrajnych", "Zadanie składa się z dwóch części – jedna dotyczy ArrayList, a druga LinkedList. Obie części należy zrealizować wewnątrz edytora Kodilla. Oba rozwiązania powinny być w ramach jednego projektu.\n" +
            "Część 1\n" +
            "1.\tNapisz program przy użyciu listy ArrayList, zawierającej kilkanaście ocen z przedmiotu Informatyka w liceum.\n" +
            "2.\tWypełnij listę przykładowymi ocenami.\n" +
            "3.\tNastępnie przy pomocy pętli for oblicz średnią ocenę ucznia (średnia arytmetyczna), ale w taki sposób, że pominięte zostaną skrajne oceny – JEDNA najmniejsza i JEDNA największa.\n" +
            "Oceny największą i najmniejszą należy odnaleźć. Przykładowo, dla ocen:\n" +
            "1.\t3,3,4,4,4,5,5,5,6 – do obliczenia średniej wzięte zostaną oceny: 3,4,4,4,5,5,5\n" +
            "2.\t4,4,4,4,4,4,4 – do obliczenia średniej wzięte zostaną oceny: 4,4,4,4,4\n" +
            "Część 2\n" +
            "1.\tNapisz program przy użyciu listy LinkedList, zawierającej obiekty opisujące książki. Każda książka powinna posiadać tytuł i rok wydania.\n" +
            "2.\tWypełnij listę kilkoma przykładowymi pozycjami.\n" +
            "3.\tNastępnie przy pomocy pętli for-each wyświetl tylko te książki z listy, dla których rok wydania nie jest mniejszy niż 2000.\n");

    Exercises exercises5 = new Exercises("Mapa uczniow", "1.\tPrzy użyciu wewnętrznego edytora Kodilli stwórz program z użyciem HashMap, który będzie przechowywał dane uczniów oraz ich ocen.\n" +
            "2.\tProgram ma wyświetlać średnią arytmetyczną ocen każdego ucznia.\n" +
            "3.\tRozwiązane zadanie wyślij do Mentora.\n");

    public void createGroup() throws SQLException {
        groupExToDb.addGroup("Math");
        groupExToDb.addGroup("Physics");
        groupExToDb.addGroup("Code");
    }

    public void createExercises() throws SQLException {
        int id = groupExToDb.checkId("Loop");
        int id2 = groupExToDb.checkId("Tab");
        int id3 = groupExToDb.checkId("Code");

        dataFromDb.saveExercisesToDb(exercises, id3);
        dataFromDb.saveExercisesToDb(exercises2, id3);
        dataFromDb.saveExercisesToDb(exercises3, id3);
        dataFromDb.saveExercisesToDb(exercises4, id3);
        dataFromDb.saveExercisesToDb(exercises5, id3);
    }

    public void create() throws SQLException {
        DataFromDb.deleteAllGroupAndTasks();
        createGroup();
        createExercises();
    }
}

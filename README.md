# unit-testing-tdd
Projekty zawierające testy jednostkowe posiadają najczęściej następującą strukturę katalogów.

`src/main/java` - pakiety z kodem programu

`src/test/java` - testy jednostkowe (może też zawierać integracyjne)

To repozytorium zawiera przykładowe klasy i testy do nich (pakiet `examples`) oraz klasy nieotestowane. Twoim zadaniem będzie przetestować publiczne metody poniższych klas korzystając z zasad i technik które poznałeś oraz które stosowane są w przykładach (FIRST, testowanie wyjątków, testy parametryczne, złożone asercje z biblioteki AssertJ).

Metody najeżone są pułapkami, ale nie przejmuj się! Pisząc testy, nie ma jedynej słusznej drogi. Postaraj się znaleźć jak najwięcej sytuacji, w których metody nie działają tak, jakbyś się tego spodziewał, i udokumentuj te zachowania testami.

Część metod posiada komentarze `//TODO` - jest to informacja od autora, że w danej metodzie można coś zmienić lub poprawić. Kiedy uporasz się już z testami - spróbuj dokonać tych usprawnień.

### AdvancedCalculator
Klasa miała służyć jako zbiór nieco bardziej skomplikowanych lub udziwnionych operacji matematycznych niż zwykłe dodawanie.
#### Silnia

Jest iloczyn wszystkich liczb naturalnych dodatnich nie większych niż n (i zmora zadań rekrutacyjnych ;-) ). Silnię oblicza się dla naturalnych liczb dodatnich, a jej wartość może łatwo przekroczyć zakres zmiennych numerycznych.

Wzór oraz rozwiązania można znaleźć np. na [wikipedii](https://pl.wikipedia.org/wiki/Silnia)

#### Potęga

Zwykła funkcja potęgowa podnosząca do potęgi daną liczbę mogłaby operować na liczbach ułamkowych. W tym jednak przypadku autor zadeklarował argumenty jako `int`, i poprosił o przygotowanie nie tylko testów, ale też implementacji. Spróbuj taką stworzyć, a następnie dowieść za pomocą testów, że działa prawidłowo.

#### Funkcja liniowa

Trudniejsze zadanie. Ideą tej metody jest przyjęcie jako argument ciągu liczb i zwrócenie funkcji liniowej o wzorze `f(x) = ax + b`, który to wzór ma opisywać ciąg liczb (a dokładniej pierwsze jego dwie liczby). Jak przetestować metodę, która zwraca funkcję?

### StringManipulator
Klasa zawiera kilka statycznych metod służących do sprawdzeń i operacji na Stringach. Tym razem, spróbuj wywnioskować bez podpowiedzi, a jedynie z nazwy i zawartości metody, jakie jest ich przeznaczenie.

### ShoppingCart

Klasa modeluje koszyk zakupowy sklepu internetowego. Do koszyka można dodawać i usuwać zamawiane produkty. Jedyne ograniczenie - ten sam produkt nie może się w koszyku duplikować (chcemy mieć porządek!). Zamawiany produkt opisany jest przez nazwę, ilość i cenę. Idealnie byłoby, gdyby próba dodania tego samego produktu do koszyka, powiększała ilość produktu już znajdującego się w koszyku.

Metoda `listProducts()` służy wyłącznie celom pomocniczym (umożliwia sprawdzanie stanu koszyka). Nie posiada ona jednak żadnej złożonej logiki - nie wymaga więc przetestowania. Skupmy się na `addProduct` i `removeProduct`

Metoda `persist` oraz `DataAccessObject` można na razie pominąć. Staną się istotne w dalszym etapie, gdzie spróbujemy zastąpić je atrapą za pomocą biblioteki Mockito.
# **Rendszerterv**

## ***1. A rendszer célja:***
Manapság az emberek sokat utaznak munkahelyre, iskolába, vagy akár egy nyaralás helyszínére. Ezek az utak több órásak is lehetnek, és valamivel muszáj elütni az időt. Csapatunk erre a célra alkotta meg a Sudoku asztali alkalmazást, amely a kezdő játékosoktól kezdve a haladókig bárki számára alkalmas.

## ***2. Projekt terv:***
### ***Projekten dolgozó fejlesztők:***
- **Mikáczó Dávid:** vezető fejlesztő
- **Sipos Edit Adrienn:** fejlesztő
- **Csontos Réka Hanga:** fejlesztő

### ***Ütemterv:***
A projekt megvalósításához rendelkezésre álló idő: **8 hét**.

- **1.hét:** Rendszerterv megírása
- **2.hét:** Követelmény specifikáció megírása
- **3.hét:** Funkcionális specifikáció megírása
- **4.hét:** Képernyőtervek készítése, fejlesztés elkezdése
- **5.hét:** Üzleti logika megírása
- **6.hét:** GUI készítése
- **7.hét:** Adatbázis létrehozása
- **8.hét:** Tesztelés

## ***3. Funkcionális terv:***
### ***Felhasználó:***
- A kezdőlapon megadhatja a felhasználónevét
- Kiválaszthatja hogy kezdő, közepes vagy haladó szinten szeretne játszani
- A kiválasztott pályán az üres mezőket a szabályoknak megfelelően kitöltheti
- A "Restart" gombbal újrakezdheti a játékot
- A "New Game" gombbal új játékot kezdhet
- A "Back" gombbal visszaléphet a kezdőlapra

### ***Szoftver:***
- A felhasználó által megadott felhasználónevet eltárolja egy változóba
- A kiválasztott nehézségnek megfelelően, a könnyebb pályáknál több mező lesz előre kitöltve, míg a nehezebbeknél egyre kevesebb
- Mikor a felhasználó kitölti a legelső mezőt elindul egy óra, ami méri az időt
- A "New Game" gomb megnyomása után új pályát generál
- A "Restart" gomb megnyomása után ugyanazt a pályát jeleníti meg amit már a user elkezdett, csak üresen
- A "Back" gomb megnyomása után visszalép a kezdőlapra
- Miután a felhasználó helyesen kitöltötte a pályát, egy új ablakban adatbázisból megjeleníti az eddigi legjobb időket a felhasználónevekkel együtt

## ***4. Fizikai környezet:***
### ***Fejlesztői eszközök:***
- IntelliJ IDEA
- Github
- Trello
  
## ***5. Implementációs terv:***
A Sudoku Java nyelven írodik. A fejlesztés IntelliJ IDEA-ban történik, a felhasználói felületet a Java FX segítségével valósítjuk meg.

## ***6. Tesztterv:***
### ***Tesztelés elvei:***
A szoftver működésében található hibák megtalálása és javítása.
Szeretenénk, ha számológépünk hibamentesen működne, és pontosan számolna.

### ***Tesztelés folyamata:***
- Manuális tesztelés (felhasználói felület tesztelése)
- Unit tesztelés

### ***Tesztesetek:***
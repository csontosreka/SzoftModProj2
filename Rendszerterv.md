# **Rendszerterv**

## ***1. Telepítési terv:***
A kész projektből készítünk egy .jar fájlt, melyet .exe fájlra konvertálunk, így a felhasználónak csak ezt kell elindítani,hogy működjön az alkalmazás. A webes felület bármelyik böngészőből elindul. <br>
Tehát a következő böngészők közül bármelyik használható:
- Google Chrome
- Firefox
- Microsoft Edge
- Opera
- Safari

## ***2. A rendszer célja:***
Manapság az emberek sokat utaznak munkahelyre, iskolába, vagy akár egy nyaralás helyszínére. Ezek az utak több órásak is lehetnek, és valamivel muszáj elütni az időt. Csapatunk erre a célra alkotta meg a Sudoku asztali alkalmazást, amely a kezdő játékosoktól kezdve a haladókig bárki számára alkalmas. <br>
Rendszer egyéb céljai:
- Szórakoztatás
- Minőségi időtöltés
- Karbantarthatóság biztosítása
- Pontos működés

## ***3. Projekt terv:***
### ***Projekten dolgozó fejlesztők:***
- **Mikáczó Dávid:** Gigachad főfejlesztő imperátor legfőbb vezér programozó :P
- **Sipos Edit Adrienn:** fejlesztő
- **Csontos Réka Hanga:** vezető fejlesztő

### ***Ütemterv:***
A projekt megvalósításához rendelkezésre álló idő: **8 hét**. <br>
A csapat heti szinten sprinteket tart. Az első három hétben a specifikációk megírásával foglalkozunk. Az ezt követő hetekben párhuzamosan történik a webes felület és az asztali alkalmazás fejlesztése. <br> 
6. héten történő demózásra konzolosan működni kell az alkalmazásnak, a webes felületnek pedig el kell készülnie. <br>
Ezután a GUI megvalósítása következik. Utolsó héten tesztelés lesz.

### ***Mérföldkövek:***
- **1.hét:** Rendszerterv megírása
- **2.hét:** Követelmény specifikáció megírása
- **3.hét:** Funkcionális specifikáció megírása
- **4.hét:** Képernyőtervek készítése, fejlesztés elkezdése
- **5.hét:** Üzleti logika megírása
- **6.hét:** GUI készítése
- **7.hét:** Adatbázis létrehozása
- **8.hét:** Tesztelés

## ***4. Architectuális terv:***
A Java alkalmazás **MVC (Model-view-controller)** pattern-re épül. <br>
Ez a következőt jelenti:
- A program **model** része tartalmazni fogja az üzleti logikát
- A **view** rész lesz felelős az információ megjelenítéséért a felhasználó felé
- A **controller** pedig a felhasználó inputokat fogja kezelni 
![alt text](https://miro.medium.com/max/3000/1*OP0CS6O5Sb66jpc-H-IuRQ.png)

A webes felület PHP-t fog használni backend-nek, MySQL adatbázissal. Ez követni fogja a 3 rétegű architectúra elveit.
![alt text](https://i.stack.imgur.com/nZBtt.jpg)

## ***5. Funkcionális terv:***
### ***Felhasználó:***
- A kezdőlapon bejelentkezhet
- Kiválaszthatja hogy kezdő, közepes vagy haladó szinten szeretne játszani
- A kiválasztott pályán az üres mezőket a szabályoknak megfelelően kitöltheti
- A "Restart" gombbal újrakezdheti a játékot
- A "New Game" gombbal új játékot kezdhet
- A "Back" gombbal visszaléphet a kezdőlapra
- A "Done" gombbal leellenőrízheti a megoldásáta, ami ha helyes, akkor megjelenik a score-ja

### ***Szoftver:***
- A felhasználó a kezdőképernyőn elérheti a webes felületet, ahol be tud jelentkezni
- A kezdőképernyőn kiválaszthatja a neki megfelelő nehézségi szintet
- A kiválasztott nehézségnek megfelelően, a könnyebb pályáknál több mező lesz előre kitöltve, míg a nehezebbeknél egyre kevesebb
- A megfelelő pálya egy másik ablakban jelenik majd meg
- Mikor a felhasználó kitölti a legelső mezőt elindul egy óra, ami méri az időt
- Az időmérő a játékos számára látható helyre ki lesz helyezve
- A "New Game" gomb megnyomása után új pályát generál
- A "Restart" gomb megnyomása után ugyanazt a pályát jeleníti meg amit már a user elkezdett, csak üresen
- A "Back" gomb megnyomása után visszalép a kezdőlapra
- A "Done" gomd megnyomásával összehasonlítjuk a user megoldását a jó megoldással, és ha minden mező megegyezik, akkor kalkulálunk egy score-t, amit elmentünk adatbázisba
- Miután a felhasználó helyesen kitöltötte a pályát, kiírjuk neki a pontszámát és felajánljuk, hogy tekintse meg weboldalunkon a scoreboardot.
- Innen is visszaléphet a kezdőoldalra

### ***Webes felület:***
- Regisztrációs oldal felhasználóknak
- Backend adatbázis a felhasználók és az elért pontjaik tárolására
- Az elért pontokat megjelenítő oldal
- Az alkalmazás kommunikációhoz szükséges tokent konfiguráló oldal
- Az elért pontok beküldéséhez szükséges "API" oldal


### ***Adatbázis terv:***
Adatbázisnak MySQL-t használunk.

***Táblák:***
- User:
    - **id** (nem null, elsődleges kulcs)
    - **username** (max 50 karakter, egyedi, nem null)
    - **password** (max 255 karakter, nem null)
    - **scoretoken** (max 255 karakter, egyedi, nem null)
    - **created_at** (dátum, timestamp)

- ScoreBoard
    - **userid** (nem null, elsődleges kulcs)
    - **score** (max 50 karakter, nem null)
    - **created_at** (dátum, timestamp)

![alt text](https://github.com/csontosreka/SzoftModProj2/blob/master/sudoku_database_sketch.png?raw=true)

## ***Követelmények:***
| ID | Név | Kifejtés |
|----|-----|----------|
| 01 | Adatbázisban tárolás | Adatok tárolása adatbázisban |
| 02 | Könnyű bővíthetőség | Az alkalmazás könnyen kiegészíthető plusz funkciókkal |
| 03 | Tökéletes működés | Az alkalmazás működésében nem megengedhető hiba |
| 04 | Csak szám értékek elfogadása | A sudoku pálya mezőibe csak 1-9ig lévő számok vihetők be |
| 05 | Könnyű kezelhetőség | Felhasználóbarát kialakítások |
| 06 | Biztonságos bejelentkezés | A weboldalon biztonságos bejelentkezés biztosítása |
| 07 | Adatok biztonságos tárolása | A bizalmas információk (pl.: jelszavak) biztonságos tárolása |
| 08 | Sikeres tesztek | Az alkalmazásnak minden teszten át kell mennie |
| 09 | Reszponzív webdesign | A weboldal minél kényelmesebb használatának biztosítása |
| 10 | Minden felhasználó számára alkalmas | A nehézségi szintek úgy legyenek kialakítva, hogy kezdő és haladó sudoku játékosok számára egyaránt élvezhető legyen a játék |
| 11 | Platformfüggetlenség | Minden platform alkalmas az asztali és webes alkalmazás használatáta |
| 12 | Egyértelmű információk | A játékosoknak érthetően be kell mutatni a játékot a weboldalon |

## ***6. Fizikai környezet:***
### ***Fejlesztői eszközök:***
- IntelliJ IDEA
- Github
- Trello
  
## ***7. Implementációs terv:***
A Sudoku Java nyelven írodik. A fejlesztés IntelliJ IDEA-ban történik, a felhasználói felületet a Java FX segítségével valósítjuk meg.

## ***8. Üzleti folyamatok:***
![alt text](https://github.com/csontosreka/SzoftModProj2/blob/master/flowchart.drawio.png?raw=true)
Ahogy azt az ábrán is látszik, a felhasználó elérheti az asztali és a webes alkalmazásunkat is. Az asztali alkalmazás kezdőoldalán a felhasználó bejelentkezhet és választhat a három nehézségi szint közül. Szintnek megfelelően generálunk pályát. Itt kitöltés közben bármikor újrakezdhető a pálya, és vissza is lehet lépni a kezdőoldalra. Ha a felhasználó kész a kitöltéssel, akkor leellenőrízzük a megoldását, ami ha nem helyes, akkor egy üzenettel visszaküldjük a pályaválasztáshoz, ha helyes, akkor megnézzük, hogy be van-e jelentkezve. Ha be van jelentkezve, akkor elmentjük az eredményét az adatbázisba, valamint neki is kiírjuk a képernyőre. Ha nincs bejelentkezve, akkor ezt felajánljuk neki. Innen visszaláphet a kezdőoldalra. Bejelentkezéskor átirányítjuk a weboldalra. Itt regisztrálni is tud, ha még nincs fiókja. Itt tud magának tokent generálni, szabályokat olvasni, valamint megnézheti a scoreboardot. A weboldal kommunikál majd az adatbázis User és Scoreboard táblájával.

## ***9. Karbantartási terv:***
A fejlesztés során figyeltünk arra, hogy a függőségeknél megfelelő verziószámokat használjunk. Verzióváltások esetén csapatunk a lehető leghamarabb kijavítja az ez által okozott problémákat.

## ***10. Tesztterv:***
### ***Tesztelés elvei:***
A szoftver működésében található hibák megtalálása és javítása.
Szeretenénk, ha számológépünk hibamentesen működne, és pontosan számolna.

### ***Tesztelés folyamata:***
- Manuális tesztelés (felhasználói felület tesztelése)
- Unit tesztelés

### ***Tesztesetek:***

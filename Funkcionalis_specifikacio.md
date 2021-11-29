# **Funkcionális specifikáció:**

## ***1. A rendszer céljai és nem céljai:***
Célunk a felhasználó számára egy modern, esztétikus és könnyen használható Sudoku játék biztosítása, mely az alapszabályok szerint tökéletesen működik. 
Szeretnénk, ha appunk minél könnyebben kezelhető lenne, ez az asztali alkalmazásra és a webes felületre is egyaránt vonatkozik. 
Webes felületünknek egyértelmű információt kell biztosítania a játékszabályokról. Biztonságos belépést és regisztrációt biztosítunk. 
Webes felületünkön egy ScoreBoard is megtalálható, ami ösztönözheti játékosainkat arra, hogy minél ügyesebbek legyenek a játékban, 
valamit családtagjaikkal és barátaikkal is bármikor versenyezhetnek. Az asztali alkalmazásnak és a weboldalnak is bugmentesen kell működnie.
Nem célunk a Sudokun kívül más játékkal kiegészíteni az applikációnkat.

## ***2. Jelenlegi helyzet leírása:***
Cégünk egy letisztult felhasználói felülettel rendelkező, Sudoku applikációt biztosít a megrendelőink számára. 
Ezt egy asztali alkalmazás formájában valósítottuk meg. Az alkalmazásban három nehézségi szint közül választhat a felhasználó, 
így kezdőktől a profi játékosokig bárki használhatja. Lehetőség van még regisztrálásra is az alkalmazásunk weboldalán, ezzel a felhasználó hozzáfér több plusz funkcióhoz is, 
mint például a scoreboard. Regisztrálás után lehetőség van saját token generálására, amit az asztali alkalmazásban aktiválni lehet, így azonosítja a játék az adott felhasználót.

# ***3. Igényelt üzleti folyamatok modellje:***
A webalkalmazáson keresztül lehetőség lenne a felhasználónak "Coin"-okat vásárolni, amelyekkel segítségeket vehetne magának, ezzel is meggyorsítaná a pálya 
kitöltését, tehát több pontot szerezne. Ez hatalmas segítség lenne, ha épp csúfosan lemaradtunk valamelyik ismerősünktől, és vissza szeretnénk végni.
Emellett az asztali alkalmazásban lehetne mutatni a játékos energiaszintjét, ami azt korlátozná, hogy a játékos mennyi időt tölthet el egy nap a játékkal.
Ezzel is megakadályoznák a függőség kialakulását. Persze plusz energiát lehetne venni a weboldalunkon, a nagyon elszánt játékosoknak.

## ***4. Vágyálom rendszer leírása:***
Szeretnénk, ha alkalmazásunkat kiegészíthetnénk minél több plusz funkcióval. Lehetne a játszható körök mennyiségét energiapontokkal korlátozni, 
amiket a felhasználó az alkalmazáson keresztül megvásárolhatna. Ez természetesen adott idő után magától is visszatöltődne. Ugyanez megoldható lenne a segítségkérésekkel is. 
Tehát, ha a felhasználó elakad, tudna magának venni olyan pontokat, amelyeket segítségkérésre lehet felhasználni.

## ***5. A rendszerre vonatkozó szabályok:***
- Az asztali alkalmazás Java nyelven íródik
- GUI megvalósításához JavaFX használata
- A webes alkalmazás megvalósításához PHP és JavaScript használata
- Felhasználói felülethez Bootstrap használata

# ***6. Követelmény lista:***
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
| 13 | Alap Sudoku szabályok | A játék alapszabályainak pontos implementálása |
| 14 | Bejelentkezés és regisztráció | A felhasználóknak biztosítani kell a bejelentkezést és a regisztrációt a weboldalon |
| 15 | Újrakezdés | Lehetőség az adott pálya újrakezdésére |
| 16 | Feladás | A játékos bármikor feladhatja a játékot (kiléphet) |
| 17 | Befejezés | A játékot akkor lehessen befejezni, ha az összes mező ki van töltve, valamint helyes a megoldás |
| 18 | Ellenőrzés | A program pontosan le tudja ellenőrizni a felhasználó megoldását |

# ***7. Forgatókönyvek:***
- Tokennel történő bejelentkezés
- Nehézségi szint kiválasztása
- Pálya kitöltése billentyűzet használatával
- Pálya újrakezdése
- Visszalépés a Sudoku pályáról a kezdőoldalra
- Kitöltés leellenőrzése
- Pontszám kiírása
- Weboldalon bejelentkezés/Regisztrálás
- Weboldalon játékszabályok megjelenítése
- Weboldalon ScoreBoard mutatása
- Weboldalon saját token generálása

## ***8. Jelenlegi üzleti folyamatok modellje:***
- Sudoku szabályok implementálása
- Nehézségi szintnek megfelelő pálya generálása: minél nehezebb a pálya, annál kevesebb előre kitöltött mező legyen
- Az asztali alkalmazás kezdőoldalán a felhasználó ki tudja választani a nehézségi szintet gombok segítségével
- Az asztali alkalmazás kezdőoldalán a felhasználó el tudja érni a webes alkalmazást, ahol regisztrálni, valamint bejelentkezni tud
- A nehézségi szint kiválasztása után az alkalmazás ablakot vált a megfelelő pályára
- A pályákon a játékmezőt a felhasználó begépeléssel tudja kitölteni
- A pályát tartalmazó képernyőn megjelenik egy óra, amely az első mező kitöltésétől méri az időt
- A játékmező alatt a "Done" gomb megnyomása után a szoftver leellenőrzi, hogy a kitöltött játék megfelel-e a szabályoknak, és ha igen, akkor bejelentkezett játékos esetén a játékos felhasználónevét, és az időt, és a nehézségi szintet feltölti egy adatázisba
- Az "New Game" gomb megnyomásával a szoftver egy új pályát generál ugyanazzal a nehézségi szinttel
- A "Restart" gomb megnyomásával az összes eddig kitöltött mező tartalma törlésre kerül
- A "Back" gomb megnyomásával a felhasználó visszaléphet a kezdőoldalra

## ***9. Használati esetek:***
Manapság az emberek sokat utaznak munkahelyre, iskolába, vagy akár egy nyaralás helyszínére. Ezek az utak több órásak is lehetnek, és valamivel muszáj elütni az időt. 
Csapatunk erre a célra alkotta meg a Sudoku asztali alkalmazást, amely a kezdő játékosoktól kezdve a haladókig bárki számára alkalmas. <br>
Rendszer fő céljai:
- Szórakoztatás
- Minőségi időtöltés




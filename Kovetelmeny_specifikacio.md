# Követelmény specifikáció

## ***1. Jelenlegi helyzet leírása:***
Cégünk egy letisztult felhasználói felülettel rendelkező, Sudoku applikációt biztosít a megrendelőink számára. Ezt egy asztali alkalmazás formájában valósítottuk meg. Az alkalmazásban három nehézségi szint közül választhat a felhasználó, így kezdőktől a profi játékosokig bárki használhatja. Lehetőség van még regisztrálásra is az alkalmazásunk weboldalán, ezzel a felhasználó hozzáfér több plusz funkcióhoz is, mint például a scoreboard.

## ***2. Vágyálom rendszer leírása:***
Szeretnénk, ha alkalmazásunkat kiegészíthetnénk minél több plusz funkcióval. Lehetne a játszható körök mennyiségét energiapontokkal korlátozni, amiket a felhasználó az alkalmazáson keresztül megvásárolhatna. Ez természetesen adott idő után magától is visszatöltődne. Ugyanez megoldható lenne a segítségkérésekkel is. Tehát, ha a felhasználó elakad, tudna magának venni olyan pontokat, amelyeket segítségkérésre lehet felhasználni.

## ***3. A rendszerre vonatkozó szabályok:***
- Az asztali alkalmazás Java nyelven íródik
- GUI megvalósításához JavaFX használata
- A webes alkalmazás megvalósításához PHP és JavaScript használata
- Felhasználói felülethet Bootstrap használata

## ***4. Jelenlegi üzleti folyamatok modellje:***
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

# ***5. Igényelt üzleti folyamatok modellje:***
- Energiaszint mutatásának implementálása
- "Coin"-ok bevezetése, amelyekkel segítséget vehet a felhasználó
- Ezekhez szükséges elemek létrehozása a webalkalmazásban

# ***6. Követelmény lista:***
- Alap Sudoku szabályok
- Bejelentkezés/Regisztráció 
- Nehézségi szint kiválasztása
- A felhasználó tudja billentyűzet segítségével kitölteni a mezőket
- Eredmény elmentése adatbázisba
- Lehetőség a játék újrakezdésére
- Lehetőség a játék feladására
- Lehetőség a játék befejezésére
- Megoldás helyességének ellenőrzése
- Adatbázis lekérdezése a webes felületen





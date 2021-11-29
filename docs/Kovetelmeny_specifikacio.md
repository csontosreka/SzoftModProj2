# Követelmény specifikáció

## ***1. Jelenlegi helyzet leírása:***
Cégünk egy letisztult felhasználói felülettel rendelkező, Sudoku applikációt biztosít a megrendelőink számára. Ezt egy asztali alkalmazás formájában valósítottuk meg. Az alkalmazásban három nehézségi szint közül választhat a felhasználó, így kezdőktől a profi játékosokig bárki használhatja. Lehetőség van még regisztrálásra is az alkalmazásunk weboldalán, ezzel a felhasználó hozzáfér több plusz funkcióhoz is, mint például a scoreboard. Regisztrálás után lehetőség van saját token generálására, amit az asztali alkalmazásban aktiválni lehet, így azonosítja a játék az adott felhasználót.

## ***2. Vágyálom rendszer leírása:***
Szeretnénk, ha alkalmazásunkat kiegészíthetnénk minél több plusz funkcióval. Lehetne a játszható körök mennyiségét energiapontokkal korlátozni, amiket a felhasználó az alkalmazáson keresztül megvásárolhatna. Ez természetesen adott idő után magától is visszatöltődne. Ugyanez megoldható lenne a segítségkérésekkel is. Tehát, ha a felhasználó elakad, tudna magának venni olyan pontokat, amelyeket segítségkérésre lehet felhasználni.

## ***3. A rendszerre vonatkozó szabályok:***
- Az asztali alkalmazás Java nyelven íródik
- GUI megvalósításához JavaFX használata
- A webes alkalmazás megvalósításához PHP és JavaScript használata
- Felhasználói felülethez Bootstrap használata

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

## ***5. Igényelt üzleti folyamatok modellje:***
- Energiaszint mutatásának implementálása
- "Coin"-ok bevezetése, amelyekkel segítséget vehet a felhasználó
- Ezekhez szükséges elemek létrehozása a webalkalmazásban

## ***6. Követelmény lista:***
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

## ***7. Fogalomszótár:***
- **Sudoku:**  egy logikai játék, melyben megadott szabályok szerint számjegyeket kell elhelyezni egy táblázatban.
- **ScoreBoard:** egy táblázat, amelyben a felhasználók által elért eredményeket tároljuk.
- **Token:** a tokent a jelszó mellett vagy helyett használják, elektronikus kulcsként működik, hogy hozzáférjen valamihez.
- **Energiapontok:** a felhasználó játékkal töltött idejét korlátozó eszköz. 
- **Java:** a Java általános célú, objektumorientált programozási nyelv.
- **GUI:** a grafikus felhasználói felület vagy grafikus felhasználói interfész a számítástechnikában olyan, a számítógép és ember közti kapcsolatot megvalósító elemek összessége, melyek a monitor képernyőjén szöveges és rajzos elemek együtteseként jelennek meg.
- **JavaFX:** a JavaFX egy szoftverplatform asztali alkalmazások, valamint gazdag webes alkalmazások létrehozására és szállítására, amelyek sokféle eszközön futtathatók.
- **PHP:** egy általános szerveroldali szkriptnyelv dinamikus weblapok készítésére.
- **JavaScript:** egy objektumorientált programozási nyelv, prototípus-alapú szkriptnyelv, amelyet weboldalakon elterjedten használnak.
- **Bootstrap:** egy ingyenes és nyílt forráskódú CSS-keretrendszer, amely reszponzív felhasználói felület fejlesztésére irányul.
- **Coin:** a játékban használt pénznem, amelyet segítségre, vagy energiapont vásárlására költhet a felhasználó
- **Adatbázis:** az adatbázisok célja adatok megbízható, hosszú távon tartós tárolása és viszonylag gyors visszakereshetőségének biztosítása.
- **Reszponzív webdesign:** reszponzív elv alapján tervezett oldal tökéletesen igazodik a megjelenítő eszközhöz, mindezt rugalmas felépítéssel, flexibilis képekkel.
- **Platformfüggetlenség:** olyan számítógépes programokra, operációs rendszerekre, programozási nyelvekre vagy más számítógépes szoftverekre és implementációikra vonatkozik, amelyek több számítógépes platformon képesek működni.


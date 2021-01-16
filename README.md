# WatherMap

Aplicație pentru monitorizare meteorologică

<br>

## Descriere
Aplicația își propune afișarea datelor meteorologice din diferitele orașe ale lumii. Listele cu tări și orașe disponibile vor fi încarcate dintr-un fișier de intrare ce va conține pe fiecare linie: id-ul, denumirea, latitudinea, longitudinea si codul țării. Pentru obținerea datelor meteorologice despre orașe se va folosi API-ul OpenWeatherMap, realizandu-se un request de tip HTTP, cu parametri necesari atasati. Rezultatul, sub forma unui obiect JSON va fi analizat si se vor extrage informatiile necesare. 


## Utilizare
In momentul executiei aplicatiei, va aparea fereastra principala care pune la dispozitie utilizatorului doua liste de unde poate selecta tara, respectiv orasul. Intai se va selecta tara dorita, apoi in a doua lista vor fi incarcate doar orasele din tara respectiva. Odata ales si orasul, se vor incarca automat toate informatiile privind starea vremii din locatia selectata. Principalele campuri de informatii sunt: 

- Numele orasului ales si tara din care face parte
- Imagine reprezentativa care specifica vremea la momentul curent
- Temperatura
- Presiunea
- Umiditatea
- Vizibilitatea
- Viteza vantului

Fisierul de intrare contine:
```
ID	        nm		lat	        lon		 countryCode
819827          Razvilka        55.591667       37.740833        RU
524901          Moscow          55.752220       37.615555        RU
2973393         Tarascon        43.805828       4.660280         FR
2986678         Ploufragan      48.491409       -2.794580        FR
683506          Bucharest       44.4323         26.1063          RO
670609          Pitesti         44.85           24.86667         RO
5128581         New_York        40.7166638      -74.1            USA
5391959         San_Francisco   37.77493        -122.41942       USA
3128760         Barcelona       41.38879        2.15899          SP
2509954         Valencia        39.46975        -0.37739         SP
 
```

Exista posibilitatea alegerii unei alte localitati in orice moment dorit de utilizator prin selectarea unui alt oras sau a unei alte tari.

De asementea, exista si posibilitatea converisei temperaturii din grade Celsius in grade Fahrenheit.

## Realizator
Raceanu Catalin

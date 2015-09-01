#### LadaSpaceQuest

**Aihe:** Peli, jossa lennet��n avaruudessa lada-autolla. Auton ohjaaminen tapahtuu samantyyppisesti, kuin flappybird peliss�. Auton eteen tulee my�s samantyyppisesti satunnaisgeneroituja esteit�. Lis�ksi vastaan tulee my�s lent�vi� vihollisaluksia. Ladalla on flappbird pelist� poiketen my�s kyky ampua. Ohjaaminen on tarkempaa, kuin flappybirdiss�, jotta yksitt�isten pelien ajat olisivat pidempi�. Lada hypp�� yhdest� n�pp�imest� ja ampuu toiseseta, esimerkiksi hiiren vasen ja oikea n�pp�in. Riippuen kuinka paljon aikaa pelin tekoon tulee menem��n, peliin voi lis�t� pisteenlasku j�sjestelm�n, highscoret, tarinan ja lis�t� erillaisia vihollistyyppej�.

**K�ytt�j�t:** Pelaaja.

**Pelaajan toiminnot:** 

* Pelink�ynnist�minen
  * Pelin sis�ll� liikkuminen ja ampuminen
* Aiempien pisteiden listaus
* Pelin ohjeiden lukeminen
* Tarinan lukeminen


**Rakenne** Ohjelman main- luokkana toimii netbeanssin GUI-builderilla rakennettu graafinenk�ytt�liittym�. Ainoa luokka, jonka t�m� tiet�� on enn�tys, joka ainoastaan s�ilyytt�� integerin� korkeinta pistetulosta. Graafinen

k�yttis luo kayttoliittyma luokan, joka on k�yt�nn�ss� vain apuluokka varsinaisen pelin ja graafisen v�lill�. Kayttoliittyma saa graafiselta ennatyksen konstruktorilleen. Kayttoliittyma taas luo piirtoalustan ja antaa j�lleen enn�tyyksen t�lle eteenp�in. Samalla se luo ja liitt�� piirtoalustaan nappaimistonkuuntelijan, joka ohjaa hahmoa. Piirtoalusta taas luo hahmon ja esteit�. Nappia painamalla hahmo taas luo omaan listaansa ammuksia, jotka piirtoalusta saa get- pyynn�ll� haltuunsa. Kun ammus osuu esteeseen, v�hennet��n esteen kest�vyytt�. Samalla kun piirtoalusta uudelleenpiirt��, tarkistetaan yhteent�rm�ykset ja tuhoutuneet esteet. Jos hahmo menee alustan ulkopuolelle, tai osuu esteeseen, hahmo kuolee. Samalla alustan gameOver muutetaan n�kyv�ksi, joka saa hahmolta pisteet. Nyt tarkistetaan my�s, onko enn�tyst� syyt� vaihtaa. Jos nyt painetaan r, luodaan uusi kayttoliittyma, jolle annetaan p�ivitettyy enn�tys. Jos painetaan t, niin piirtoalusta tuhotaan, ja palataan alkuvalikkoon.
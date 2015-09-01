#### LadaSpaceQuest

**Aihe:** Peli, jossa lennetään avaruudessa lada-autolla. Auton ohjaaminen tapahtuu samantyyppisesti, kuin flappybird pelissä. Auton eteen tulee myös samantyyppisesti satunnaisgeneroituja esteitä. Lisäksi vastaan tulee myös lentäviä vihollisaluksia. Ladalla on flappbird pelistä poiketen myös kyky ampua. Ohjaaminen on tarkempaa, kuin flappybirdissä, jotta yksittäisten pelien ajat olisivat pidempiä. Lada hyppää yhdestä näppäimestä ja ampuu toiseseta, esimerkiksi hiiren vasen ja oikea näppäin. Riippuen kuinka paljon aikaa pelin tekoon tulee menemään, peliin voi lisätä pisteenlasku jäsjestelmän, highscoret, tarinan ja lisätä erillaisia vihollistyyppejä.

**Käyttäjät:** Pelaaja.

**Pelaajan toiminnot:** 

* Pelinkäynnistäminen
  * Pelin sisällä liikkuminen ja ampuminen
* Aiempien pisteiden listaus
* Pelin ohjeiden lukeminen
* Tarinan lukeminen


**Rakenne** Ohjelman main- luokkana toimii netbeanssin GUI-builderilla rakennettu graafinenkäyttöliittymä. Ainoa luokka, jonka tämä tietää on ennätys, joka ainoastaan säilyyttää integerinä korkeinta pistetulosta. Graafinen

käyttis luo kayttoliittyma luokan, joka on käytännössä vain apuluokka varsinaisen pelin ja graafisen välillä. Kayttoliittyma saa graafiselta ennatyksen konstruktorilleen. Kayttoliittyma taas luo piirtoalustan ja antaa jälleen ennätyyksen tälle eteenpäin. Samalla se luo ja liittää piirtoalustaan nappaimistonkuuntelijan, joka ohjaa hahmoa. Piirtoalusta taas luo hahmon ja esteitä. Nappia painamalla hahmo taas luo omaan listaansa ammuksia, jotka piirtoalusta saa get- pyynnöllä haltuunsa. Kun ammus osuu esteeseen, vähennetään esteen kestävyyttä. Samalla kun piirtoalusta uudelleenpiirtää, tarkistetaan yhteentörmäykset ja tuhoutuneet esteet. Jos hahmo menee alustan ulkopuolelle, tai osuu esteeseen, hahmo kuolee. Samalla alustan gameOver muutetaan näkyväksi, joka saa hahmolta pisteet. Nyt tarkistetaan myös, onko ennätystä syytä vaihtaa. Jos nyt painetaan r, luodaan uusi kayttoliittyma, jolle annetaan päivitettyy ennätys. Jos painetaan t, niin piirtoalusta tuhotaan, ja palataan alkuvalikkoon.
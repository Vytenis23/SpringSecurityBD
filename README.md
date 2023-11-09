jeigu norite paleisti aplikaciją su mysql arba postgresql ir naudoti docker konteinerius, Jums reikia:
1. turėti veikiantį docker kompiuteryje. galite pasitikrinti ar jį turite parašę komandinėje eilutėje `docker version` komandą
2. pasikeisti application properties pagal docker-compose.yml user, password ir t.t.
3. paleisti `docker compose up -d` komandą. ši komanda pastartuoja postgresql ir mysql duombazes
4. jeigu norite duombazes išjungti, parašykite `docker compose down` komandą
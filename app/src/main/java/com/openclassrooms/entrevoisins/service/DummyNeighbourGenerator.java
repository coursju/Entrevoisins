package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Eric", "https://uifaces.co//our-content//donated//IEmncemM.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(2, "Jack", "https://i.imgur.com//pYCekqv.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(3, "Chloé", "https://i.imgur.com//fDcmQ1T.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(4, "Vincent", "https://randomuser.me//api//portraits//men//78.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(5, "Elodie", "https://i.imgur.com//MyFbXA0.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(6, "Sylvain", "https://uifaces.co//our-content//donated//T5rm0m7W.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(7, "Laetitia", "https://i.imgur.com//fDcmQ1T.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(8, "Dan", "https://i.imgur.com//pYCekqv.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(9, "Joseph", "https://uifaces.co//our-content//donated//TRkRhV48.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(10, "Emma", "https://i.imgur.com//MyFbXA0.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(11, "Patrick", "https://uifaces.co//our-content//donated//gjk2TQkK.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."),
            new Neighbour(12, "Ludovic", "https://uifaces.co//our-content//donated//IEmncemM.jpg", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..")
//            ,new Neighbour(13, "Ludovic", "https://uifaces.co//our-content//donated//IEmncemM.jpg", "Saint-Pierre-du-Mont ; 5km",
//                          "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..")

    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}

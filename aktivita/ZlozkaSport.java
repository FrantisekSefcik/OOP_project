package aktivita;
import java.util.List;

import Objekty.Ucastnici;

interface ZlozkaSport {
List <Ucastnici> getUcastnici();
List <Sport> getSport(); 
String getMeno();
String spravaS();
String spravaH();
String vypisHotel();
String spravaD();
String spravaDP();
double getSum();
String celkovyVypis();
String financieVypis();
String financieVypis(String s);
boolean isNaplnene();
boolean isStavUbytovanie();
boolean isStavCesta();
}

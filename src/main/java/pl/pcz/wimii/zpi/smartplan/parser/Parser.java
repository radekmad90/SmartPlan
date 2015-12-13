package pl.pcz.wimii.zpi.smartplan.parser;

import java.util.List;
import org.apache.log4j.Logger;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.services.RokKierunekService;

public class Parser {

    private Logger logger = Logger.getLogger(this.getClass());

    public void parse(String url, String rok_akademicki, Integer rok, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {

        List<RokKierunek> rokKierunekList = RokKierunekService.getRokKierunek(rok_akademicki, rok, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        RokKierunek rokKierunek = null;
        if (rokKierunekList == null || rokKierunekList.isEmpty()) {
            rokKierunek = RokKierunekService.addRokKierunek(rok_akademicki, rok, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        } else {

            rokKierunek = rokKierunekList.get(0);
        }
        logger.info(rokKierunek.toString());
        
        teraz to samo ze zjazdami,parsuj date do DATE id opiero do bazy
//        List<Zjazdy> allZjazdy = ZjazyService.getZjazdy();
        //        
        //        
        //        
        //        Document doc = null;
        //        String planName = null;
        //        Calendar publicationDate = null;
        //        try {
        //            doc = Jsoup.connect(url).get();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //            throw new RuntimeException("Nie mogę się połączyć z URL");
        //        }
        //        Elements els = doc.getElementsByTag("body");
        //        Elements table = null;
        //        for (Element el : els) {
        //            table = el.getElementsByTag("table").remove();
        //            String[] splited = el.html().split("<br>");
        //            List<String> splitedFormatted = Arrays.asList(splited);
        //
        //            splitedFormatted = splitedFormatted.stream().filter(str -> !str.matches("$\\s*^"))
        //                    .collect(Collectors.toList());
        //            planName = splitedFormatted.get(0).trim();
        //            publicationDate = ParserUtils.getDateFromString(splitedFormatted.get(1));
        //            break;
        //        }
        //
        //        for (Element el : table) {
        //            Elements trs = el.getElementsByTag("tr");
        //            List<Element> zjazdy = trs.get(0).getElementsByTag("td").stream().filter(str -> !str.text().matches("^\\D"))
        //                    .collect(Collectors.toList());
        //            List<Calendar> datyZjazdow = new ArrayList<>();
        //            for (Element zjazd : zjazdy) {
        //                String[] dateAndDayOfWeek = zjazd.text().split(" ");
        //                datyZjazdow.add(ParserUtils.getDateFromString(dateAndDayOfWeek[0]));
        //
        //            }
        //
        //            // od jedynki petla bo pierwszym wierszem w tabelce sa terminy
        //            // zjazdow
        //            List<Godziny> godziny = GodzinyService.getGodziny();
        ////            for (int i = 1; i < trs.size(); i++) {
        ////                List<Element> zajeciaZGodzinami = trs.get(i).getElementsByTag("td");
        ////                String[] numerGodzinyLekcyjnejIGodziny = zajeciaZGodzinami.get(0).html().split("<br>");
        ////                String godzina = numerGodzinyLekcyjnejIGodziny[1];
        ////                // TODO
        ////                Godziny godz = new Godziny(godzina);
        ////                GodzinyService.addGodziny(godz);
        ////
        ////            }
        //
        //            List<Zajecia> zajecia = new ArrayList<>();
        //            for (int i = 1; i < trs.size(); i++) {
        //                List<Element> zajeciaZGodzinami = trs.get(i).getElementsByTag("td");
        //                Godziny godzina = godziny.get(i - 1);
        //
        //                for (int j = 1; j < zajeciaZGodzinami.size(); j++) {
        //                    List<String> daneZajec = Arrays.asList(zajeciaZGodzinami.get(j).html().split("<br>"));
        //                    Zajecia zajecie = new Zajecia();
        //                    zajecie.setGodziny(godzina);
        //                    zajecie.setNazwaPrzedmiotu(daneZajec.size() > 0 ? daneZajec.get(0) : null);
        //                    zajecie.setProwadzacyNazw(daneZajec.size() > 1 ? daneZajec.get(1) : null);
        //                    zajecie.setSala(daneZajec.size() > 2 ? daneZajec.get(2) : null);
        //                    zajecie.setDataZjazdu(datyZjazdow.get(j - 1));
        //                    zajecia.add(zajecie);
        //                }
        //            }
        //
        //            Calendar zjazdCal = Calendar.getInstance();
        //            zjazdCal.set(Calendar.YEAR, 2015);
        //            zjazdCal.set(Calendar.MONTH, 10);
        //            zjazdCal.set(Calendar.DAY_OF_MONTH, 7);
        //            for (ZajeciaBean zaj : zajecia) {
        //                if (zaj.getDataZjazdu().get(Calendar.YEAR) == zjazdCal.get(Calendar.YEAR)
        //                        && zaj.getDataZjazdu().get(Calendar.MONTH) == zjazdCal.get(Calendar.MONTH)
        //                        && zaj.getDataZjazdu().get(Calendar.DAY_OF_MONTH) == zjazdCal.get(Calendar.DAY_OF_MONTH)) {
        //                    System.out.println(zaj);
        //                }
        //
        //            }

//    }
//
    }
}

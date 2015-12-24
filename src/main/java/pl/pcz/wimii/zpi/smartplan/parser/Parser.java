package pl.pcz.wimii.zpi.smartplan.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.pcz.wimii.zpi.smartplan.entities.Godziny;
import pl.pcz.wimii.zpi.smartplan.entities.Plany;
import pl.pcz.wimii.zpi.smartplan.entities.Przedmioty;
import pl.pcz.wimii.zpi.smartplan.entities.RokKierunek;
import pl.pcz.wimii.zpi.smartplan.entities.Zajecia;
import pl.pcz.wimii.zpi.smartplan.entities.Zjazdy;
import pl.pcz.wimii.zpi.smartplan.entities.services.GodzinyService;
import pl.pcz.wimii.zpi.smartplan.entities.services.PrzedmiotyService;
import pl.pcz.wimii.zpi.smartplan.entities.services.RokKierunekService;
import pl.pcz.wimii.zpi.smartplan.entities.services.ZajeciaService;
import pl.pcz.wimii.zpi.smartplan.entities.services.ZjazdyService;

public class Parser {

    private Logger logger = Logger.getLogger(this.getClass());

    public void parse(String url, String rok_akademicki, String kierunek, String spec, Integer stopien, Integer semestr, Integer grupaDziekan, Integer grupaLab) {

        Document doc = null;
        String planName = null;
        Calendar publicationDate = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Nie mogę się połączyć z URL");
        }
        Elements els = doc.getElementsByTag("body");
        Elements table = null;
        for (Element el : els) {
            table = el.getElementsByTag("table").remove();
            String[] splited = el.html().split("<br>");
            List<String> splitedFormatted = Arrays.asList(splited);

            splitedFormatted = splitedFormatted.stream().filter(str -> !str.matches("$\\s*^"))
                    .collect(Collectors.toList());
            planName = splitedFormatted.get(0).trim();
            publicationDate = ParserUtils.getDateFromString(splitedFormatted.get(1));
            break;
        }

        List<RokKierunek> rokKierunekList = RokKierunekService.getRokKierunekAndZajecia(rok_akademicki, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        RokKierunek rokKierunek = null;

        if (rokKierunekList == null || rokKierunekList.isEmpty()) {
            Plany plan = new Plany(planName, publicationDate.getTime(), Calendar.getInstance().getTime(), 1);
            rokKierunek = RokKierunekService.addRokKierunek(plan, rok_akademicki, kierunek, spec, stopien, semestr, grupaDziekan, grupaLab);
        } else {
            logger.info("to update!");
            rokKierunek = rokKierunekList.get(0);
            RokKierunekService.clearRokKierunek(rokKierunek);
            try {

                Thread.sleep(30000);
            } catch (Exception e) {
            }
        }

        List<Godziny> godziny = GodzinyService.getGodziny();
        Plany plan = rokKierunek.getPlany();

        List<Zjazdy> allZjazdy = ZjazdyService.getZjazdy();
        List<Zjazdy> zjazdyAktualne = new ArrayList<>();
        for (Element el : table) {
            Elements trs = el.getElementsByTag("tr");
            List<Element> zjazdy = trs.get(0).getElementsByTag("td").stream().filter(str -> !str.text().matches("^\\D"))
                    .collect(Collectors.toList());
            for (Element zjazd : zjazdy) {
                String[] dateAndDayOfWeek = zjazd.text().split(" ");
                Calendar aktualCalendar = ParserUtils.getDateFromString(dateAndDayOfWeek[0]);
                Zjazdy zjazdAktualny = null;
                for (Zjazdy zj : allZjazdy) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(zj.getData());
                    if (DateUtils.isSameDay(c, aktualCalendar)) {
                        zjazdAktualny = zj;
                        break;
                    }
                }
                if (zjazdAktualny == null) {
                    zjazdAktualny = ZjazdyService.addZjazd(new Zjazdy(aktualCalendar.getTime()));
                }
                zjazdyAktualne.add(zjazdAktualny);

                // od jedynki petla bo pierwszym wierszem w tabelce sa terminy
                // zjazdow
            }
//                    for (int i = 1; i < trs.size(); i++) {
//                        List<Element> zajeciaZGodzinami = trs.get(i).getElementsByTag("td");
//                        String[] numerGodzinyLekcyjnejIGodziny = zajeciaZGodzinami.get(0).html().split("<br>");
//                        String godzina = numerGodzinyLekcyjnejIGodziny[1];
//                        // TODO
//                        Godziny godz = new Godziny(godzina);
//                        GodzinyService.addGodziny(godz);
//        
//                    }

            List<Zajecia> zajecia = new ArrayList<>();
            for (int i = 1; i < trs.size(); i++) {
                List<Element> zajeciaZGodzinami = trs.get(i).getElementsByTag("td");
                Godziny godzina = godziny.get(i - 1);

                for (int j = 1; j < zajeciaZGodzinami.size(); j++) {
                    List<String> daneZajec = Arrays.asList(zajeciaZGodzinami.get(j).html().split("<br>"));
                    if (daneZajec.get(0).equals("&nbsp;")) {
                        daneZajec.set(0, " ");
                    }
                    Zajecia zajecie = new Zajecia();
                    zajecie.setGodziny(godzina);
                    zajecie.setProwadzacyNazw(daneZajec.size() > 1 ? daneZajec.get(1) : null);
                    zajecie.setSala(daneZajec.size() > 2 ? daneZajec.get(2) : null);
                    zajecie.setZjazdy(zjazdyAktualne.get(j - 1));
                    List<Przedmioty> przedmiotyFiltered = rokKierunek.getPlany().getPrzedmioties().stream().filter(p -> p.getNazwa().equals(daneZajec.get(0))).collect(Collectors.toList());
                    Przedmioty przedmiot = null;
                    if (przedmiotyFiltered == null || przedmiotyFiltered.isEmpty()) {
                        String nazwaPrzedmiotu = daneZajec.get(0);
                        if (nazwaPrzedmiotu.equals("&nbsp;")) {

                        }
                        przedmiot = new Przedmioty(daneZajec.get(0));
                        przedmiot.setPlan(plan);
                        PrzedmiotyService.addPrzedmiot(przedmiot);
                        rokKierunek.getPlany().getPrzedmioties().add(przedmiot);
                    } else {
                        przedmiot = przedmiotyFiltered.get(0);
                    }
                    zajecie.setPrzedmioty(przedmiot);
                    zajecie.setPlany(plan);
                    if (plan.getZajecias().contains(zajecie)) {
                        logger.info("mam takiego!!");
                        continue;
                    }
                    zajecia.add(zajecie);

                }
            }
            ZajeciaService.addZajecia(zajecia);
        }

//
    }
}

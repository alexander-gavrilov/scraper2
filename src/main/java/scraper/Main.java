package scraper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alexa on 30.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, KeyManagementException, NoSuchAlgorithmException {
        //String url = args[0];

        String province = "ANCONA";


        String url = "https://www.alboautotrasporto.it/web/portale-albo/imprese-iscritte";
        Scraper scraper = new Scraper(url);

        Connection.Response response = scraper.getConnection().method(Connection.Method.GET)
                .execute();

        Document doc = response.parse();

        //Document doc = scraper.getDocument();

        Element element = doc.getElementById("_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_provinceList");
        element.getElementsByTag("option").forEach((option) -> {
            System.out.println("option = " + option.val() + "\t" + option.text());
        });
        Element pe = element.getElementsByTag("option").stream().filter((option) -> {
            if (option.text().equals(province)) {
                return true;
            }
            return false;
        }).findFirst().get();
        System.out.println("Chosen option is " + pe.text());

        // Scraper scraper1 = new Scraper("https://www.alboautotrasporto.it/web/portale-albo/imprese-iscritte?p_p_id=impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=1&_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_action=getComuniByProvincia");
        scraper.takeSSLValidationOff();

        Connection connection =
                Jsoup.connect("https://www.alboautotrasporto.it/web/portale-albo/imprese-iscritte?p_p_id=impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=1&_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_action=getComuniByProvincia")
//                .data("p_p_id","impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo")
//                .data("p_p_lifecycle","1")
//                .data("p_p_state","normal")
//                .data("p_p_mode","view")
//                .data("p_p_cacheability","cacheLevelPage")
//                .data("p_p_col_id","column-2")
//                .data("p_p_col_count","1")
//                .data("_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_action","getComuniByProvincia")
                        .data("_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_data", pe.val());

        // .cookies(response.cookies())
        System.out.println();
        connection.request().headers().forEach((s, s2) -> {
            System.out.println("s = "+s+"\t"+"s2 = "+s2);
        });
        doc = connection.post();
//        Scraper scraper2 = new Scraper();
//        scraper2.setDocument(doc);

        element = doc.getElementById("_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_comuniList");
        element.getElementsByTag("option").forEach((option) -> {
            System.out.println("option = " + option.val() + "\t" + option.text());
        });
//        pe = element.getElementsByTag("option").stream().filter((option) -> {
//            if (option.text().equals(province)) {
//                return true;
//            }
//            return false;
//        }).findFirst().get();
        System.out.println("Chosen option is " + pe.text());


    }

}

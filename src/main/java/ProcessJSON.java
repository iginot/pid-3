import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;
import java.util.Map;

/**
 * Purpose of this class is to process JSON files provided as String value and extract user details requested by user.
 */

public class ProcessJSON {

    Texts textWriter;

        public ProcessJSON()
        {
            textWriter = new Texts();
        }

    public void processPokemonData(String completePokemonInfo) {

        try {
            JSONObject pokemonAllData = (JSONObject) new JSONParser().parse(completePokemonInfo);

            String pokemonName = (String) pokemonAllData.get("name");
            long pokemonID = (Long) pokemonAllData.get("id");
            long pokemonHeight = (Long) pokemonAllData.get("height");
            long pokemonWeight = (Long) pokemonAllData.get("weight");

            textWriter.printPokemonInfo(pokemonID, pokemonName, pokemonHeight, pokemonWeight);

        } catch (Exception e) {
            textWriter.processingOfDataFailed();
        }
    }

    public void processLocationData(String completeLocationInfo) {
        try{
            JSONObject locationAllData = (JSONObject) new JSONParser().parse(completeLocationInfo);;

            Map region = (Map) locationAllData.get("region");
            String regionName = (String) region.get("name");
            textWriter.printLocationRegion(regionName);

            JSONArray allInformationAboutNames = (JSONArray) locationAllData.get("names");
            Iterator namesIterator = allInformationAboutNames.iterator();
            textWriter.printLanguagesHeader();

            while (namesIterator.hasNext())
            {
                Map oneLanguageInformation = (Map) namesIterator.next();
                String nameInThatLanguage = (String) oneLanguageInformation.get("name");
                textWriter.printLocationName(nameInThatLanguage);
            }

        } catch (Exception e) {
            textWriter.processingOfDataFailed();
        }
    }
}

package course1.may4;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuturlandParser {

    public static void writeAllGoods(FileWriter fileWriter) throws IOException, InterruptedException {
        Map<String, String> categories = FuturlandParser.parseCategory();

        List<Goods> goods = new ArrayList<>();

        for (Map.Entry<String, String> entry : categories.entrySet()) {
            List<Goods> goodsCategory = FuturlandParser.parseGoods(new URL(categories.get(entry.getKey())));
//            System.out.println(goodsCategory);

            for (Goods item : goodsCategory) {
                String code = getHtmlCode(
                        (HttpURLConnection)
                                new URL(item.getReference())
                                        .openConnection()
                );

                item.setCharacteristics(findCharacteristics(code));
                item.setImageReference(findImageReference(code));
                item.setCategoryName(entry.getKey());
                item.setCategoryReference(entry.getValue());
                System.out.println(item);

                goods.add(item);

                Thread.sleep(500);
            }
        }

        Gson gson = new Gson();
        JsonWriter jsonWriter = new JsonWriter(fileWriter);
        JsonElement jsonElement = gson.toJsonTree(goods);
        gson.toJson(jsonElement, jsonWriter);
    }

    public static List<Goods> parseGoods(URL parseUrl) throws IOException {
        List<Goods> goodsList = new ArrayList<>();

        HttpURLConnection httpURLConnection = (HttpURLConnection) parseUrl.openConnection();
        List<String> goodsHtml = findEachGood(getHtmlCode(httpURLConnection));

        for (String goodHtml : goodsHtml) {
            Goods goods = new Goods();
            goods.setName(findName(goodHtml));
            goods.setPrice(findPrice(goodHtml));
            goods.setReference(findReference(goodHtml));
            goodsList.add(goods);
        }

        return goodsList;
    }

    public static Map<String, String> parseCategory() throws IOException {
        Map<String, String> categories = new LinkedHashMap<>();

        URL parseUrl = new URL("https://futuland.ru/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) parseUrl.openConnection();

        Pattern pattern = Pattern
                .compile("<a href=\"([a-z/-]+?)\"><img alt=\".+?\" src=\".+?.png\">(.+?)</a>",
                        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(getHtmlCode(httpURLConnection));
        while (matcher.find()) {
            categories.put(matcher.group(2), "https://futuland.ru" + matcher.group(1));
        }

        return categories;
    }


    private static List<String> findEachGood(String html) {
        List<String> goods = new ArrayList<>();
        Pattern pattern = Pattern
                .compile("<div class=\"item product\" id=\"item-product\">(.+?)" +
                                "<a class=\"dofastorder click\" href=\"#\">Купить в один клик</a>",
                        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            goods.add(matcher.group(1));
        }
        return goods;
    }

    private static String getHtmlCode(HttpURLConnection connection) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private static Map<String, String> findCharacteristics(String html) {
        Map<String, String> characteristics = new LinkedHashMap<>();

        Pattern pattern = Pattern
                .compile("<div class=\"row\"><div class=\"name\">(.+?)</div><div class=\"val\">(.+?)</div></div>",
                        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            characteristics.put(matcher.group(1), matcher.group(2));
        }

        return characteristics;
    }

    private static String findImageReference(String html) {
        String pattern = "<div class=\"product-images\">&nbsp;<img class=\"image\" src=\"(/uploads.+?.jpg)\"";
        return "https://futuland.ru" + findCommon(html, pattern);
    }


    private static String findPrice(String html) {
        String pattern = "<span class=\"price\" id=\"shortProductPrice[0-9]+\">([0-9]+ [0-9]+)";
        return findCommon(html, pattern);
    }

    private static String findName(String html) {
        //+? ?-ограничивает жадность
        String pattern = "<div class=\"product-thumbnail\"><a href=\"/catalog/.+?\\.html\">" +
                "<img src=\"/uploads/.+?\" alt=\"(.+?)\" title=\"\"></a></div>";
        return findCommon(html, pattern);
    }

    private static String findReference(String html) {
        String pattern = "<div class=\"product-thumbnail\"><a href=\"(/catalog/.+?\\.html)\">";
        return "https://futuland.ru" + findCommon(html, pattern);
    }

    private static String findCommon(String html, String pattern) {
        Pattern parsePattern = Pattern
                .compile(pattern,
                        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = parsePattern.matcher(html);

        if (matcher.find()) return matcher.group(1);
        return null;
    }
}

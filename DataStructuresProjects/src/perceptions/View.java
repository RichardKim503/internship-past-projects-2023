package perceptions;

import com.google.gson.*;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 * The original View class.
 */
public class View
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); //System.in is a standard input stream.
        String[] names;
        JsonArray[] dataset;

        try
        {
            // hardwired name for input file, students should replace with the file they select
            String filename = "rows.json";
            JsonObject input = JsonParser.parseReader(new FileReader(filename)).getAsJsonObject();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
/*
            System.out.println(gson.toJson(input));
 */
            // get the columns of the data to work with
            JsonObject meta = input.getAsJsonObject("meta");
            JsonObject view = meta.getAsJsonObject("view");
            JsonArray columns = view.getAsJsonArray("columns");
            int sourceIndex = selectSource(columns, scan);
            Datum.setCategory(columns.get(sourceIndex).getAsJsonObject().get("name").getAsString());
            int numberIndex = selectNumber(columns, scan);
            Datum.setNumberName(columns.get(numberIndex).getAsJsonObject().get("name").getAsString());
            // create Datums from all the data in the json file and output them
            JsonArray data = input.getAsJsonArray("data");
            // traverse the data
            JsonArray dataItem = data.get(0).getAsJsonArray();
            for (int dataIndex = 0; dataIndex < data.size(); dataIndex+=1)
            {
                Datum toOutput = new Datum
                        (
                                data.get(dataIndex).getAsJsonArray().get(sourceIndex).getAsString(),
                                data.get(dataIndex).getAsJsonArray().get(numberIndex).getAsDouble()
                        );
                System.out.println(toOutput);
            }
        } catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }

    /** selects a column for the sources of the data from the json file */
    public static int selectSource(JsonArray cols, Scanner fromUser)
    {
        // traverse the list of columns listing all the valid source names
        for (int index = 0; index < cols.size(); index += 1)
        {
            JsonElement column = cols.get(index);
            // valid sources are all of type text
            if(column.getAsJsonObject().get("dataTypeName").toString().equals("\"text\""))
            {
                System.err.println(""+index+": "+column.getAsJsonObject().get("name"));
            }
        }
        System.err.print("Select a column number above for the name of the source category: ");
        return fromUser.nextInt();
    }// end selectSource
    public static int selectNumber(JsonArray cols, Scanner fromUser)
    {
        // traverse the list of columns listing all the valid source names
        for (int index = 0; index < cols.size(); index += 1)
        {
            JsonElement column = cols.get(index);
            // valid sources are all of type text
            if(column.getAsJsonObject().get("dataTypeName").toString().equals("\"number\""))
            {
                System.err.println(""+index+": "+column.getAsJsonObject().get("name"));
            }
        }
        System.err.print("Select a column number above for the name of the source category: ");
        return fromUser.nextInt();
    }// end selectSource
}
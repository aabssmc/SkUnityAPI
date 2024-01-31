package com.github.aabssmc.docs;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.github.aabssmc.SkUnityAPI.*;

@SuppressWarnings("unused")
public class Docs {
    /**
     * @param id The id of the syntax.
     * @return A syntax.
     */
    public static Syntax getSyntax(Integer id){
        return new Syntax(id);
    }

    /**
     * THIS IS A HIGH USAGE METHOD AND WILL CAUSE LAG.
     * @return All the syntaxes.
     */
    public static List<Syntax> getAllSyntaxes(){
        if (api_key != null) {
            List<Syntax> syntaxes = new ArrayList<>();
            String req = request(url, "docs/getAllSyntax");
            JSONObject docs = new JSONObject(req).getJSONObject("result").getJSONObject("docs");
            for (String key : docs.keySet()) {
                JSONObject subObject = docs.getJSONObject(key);
                String id = subObject.getString("id");
                syntaxes.add(new Syntax(Integer.valueOf(id)));
            }
            return syntaxes;
        }
        System.out.println("SkUnity API Key is invalid or not set!");
        return null;
    }

    /**
     * @return All the syntaxes from an addon.
     */
    public static List<Syntax> getSyntaxesFromAddon(Object NameOrID){
        if (api_key != null) {
            List<Syntax> syntaxes = new ArrayList<>();
            String req = request(url, "docs/getAddonSyntax/" + NameOrID);
            JSONObject docs = new JSONObject(req).getJSONObject("result").getJSONObject("docs");
            for (String key : docs.keySet()) {
                JSONObject subObject = docs.getJSONObject(key);
                String id = subObject.getString("id");
                syntaxes.add(new Syntax(Integer.valueOf(id)));
            }
            return syntaxes;
        }
        System.out.println("SkUnity API Key is invalid or not set!");
        return null;
    }
}

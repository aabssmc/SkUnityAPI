package com.github.aabssmc.docs;

import org.json.JSONObject;

import java.util.Objects;

import static com.github.aabssmc.SkUnityAPI.*;

@SuppressWarnings("unused")
public class Syntax {

    private JSONObject json;

    /**
     * @param id The syntax ID.
     */
    public Syntax(Integer id) {
        if (api_key != null) {
            json = new JSONObject(request(url, "docs/search/id:"+id)).getJSONArray("result").getJSONObject(0);
        } else{
            System.out.println("SkUnity API Key is invalid or not set!");
        }
    }

    /**
     * @return The ID of the syntax.
     */
    public int getId(){
        return Integer.parseInt(json.getString("id"));
    }

    /**
     * @return The name of the syntax.
     */
    public String getName(){
        return json.getString("name");
    }

    /**
     * @return The doc type of the syntax.
     */
    public String getDocType(){
        return json.getString("doc");
    }

    /**
     * @return The description of the syntax.
     */
    public String getDescription(){
        return json.getString("desc");
    }

    /**
     * @return The version of the syntax.
     */
    public String getVersion(){
        return json.getString("version");
    }

    /**
     * @return The pattern of the syntax.
     */
    public String getPattern(){
        return json.getString("pattern");
    }

    /**
     * @return The plugin of the syntax.
     */
    public String getPlugin(){
        return json.getString("plugin");
    }

    /**
     * @return The event values of the syntax.
     */
    public String getEventValues(){
        return json.getString("eventvalues");
    }

    /**
     * @return The changers of the syntax.
     */
    public String getChangers(){
        return json.getString("changers");
    }

    /**
     * @return The return type of the syntax.
     */
    public String getReturnType(){
        return json.getString("returntype");
    }

    /**
     * @return True if the syntax is an array.
     */
    public boolean isArray(){
        return !Objects.equals(json.getString("is_array"), "0");
    }

    /**
     * @return The tags of the syntax.
     */
    public String getTags(){
        return json.getString("tags");
    }

    /**
     * @return True if the syntax has been reviewed.
     */
    public boolean hasBeenReviewed(){
        return Objects.equals(json.getString("reviewed"), "true");
    }

    /**
     * @return The versions of the syntax.
     */
    public String getVersions(){
        return json.getString("versions");
    }

    /**
     * @return The checkout json id of the syntax.
     */
    public String getCheckoutJsonID(){
        return json.getString("checkout_json_id");
    }

    /**
     * @return The docs score of the syntax.
     */
    public double getDocsScore(){
        return Double.parseDouble(json.getString("docs_score"));
    }

    /**
     * @return True if the syntax has a snippet.
     */
    public boolean hasSnippet(){
        return !Objects.equals(json.getString("has_snippet"), "0");
    }

    /**
     * @return The syntax as a string.
     * g
     */
    public String toString(){
        return getName() + " " + getId();
    }
}

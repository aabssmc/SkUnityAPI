package com.github.aabssmc.resources;

import com.github.aabssmc.docs.Docs;
import org.json.JSONObject;

import static com.github.aabssmc.SkUnityAPI.*;

@SuppressWarnings("unused")
public class Resource {

    private JSONObject json;

    /**
     * @param id The resource ID.
     */
    public Resource(Integer id) {
        if (api_key != null) {
            json = new JSONObject(request(url, "resources/get/"+id)).getJSONObject("result");
        } else{
            System.out.println("SkUnity API Key is invalid or not set!");
        }
    }

    /**
     * @return The resource ID of the resource.
     */
    public int getResourceId(){
        return Integer.parseInt(json.getString("resource_id"));
    }

    /**
     * @return The title of the resource.
     */
    public String getTitle(){
        return json.getString("title");
    }

    /**
     * @return The tag line of the resource.
     */
    public String getTagLine(){
        return json.getString("tag_line");
    }

    /**
     * @return The user ID of the resource.
     */
    public int getUserID(){
        return Integer.parseInt(json.getString("user_id"));
    }

    /**
     * @return The username of the uploader of the resource.
     */
    public String getUsername(){
        return json.getString("username");
    }

    /**
     * @return The resource state of the resource.
     */
    public String getResourceState(){
        return json.getString("resource_state");
    }

    /**
     * @return The upload timestamp of the resource in unix timestamp.
     */
    public Integer getResourceDate(){
        return Integer.parseInt(json.getString("resource_date"));
    }

    /**
     * @return The resource category id of the resource.
     */
    public Integer getResourceCategoryID(){
        return Integer.parseInt(json.getString("resource_category_id"));
    }

    /**
     * @return The resource category id of the resource.
     */
    public Integer getCurrentCategoryID(){
        return Integer.parseInt(json.getString("current_category_id"));
    }

    /**
     * @return The price of the resource.
     */
    public double getPrice(){
        return Double.parseDouble(json.getString("price"));
    }

    /**
     * @return The currency of the resource.
     */
    public String getCurrency(){
        return json.getString("currency");
    }

    /**
     * @return The download count of the resource.
     */
    public Integer getDownloadCount(){
        return Integer.parseInt(json.getString("download_count"));
    }

    /**
     * @return The weighted rating of the resource.
     */
    public double getRatingWeighted(){
        return Double.parseDouble(json.getString("rating_weighted"));
    }

    /**
     * @return The update count of the resource.
     */
    public Integer getUpdateCount(){
        return Integer.parseInt(json.getString("update_count"));
    }

    /**
     * @return The review count of the resource.
     */
    public Integer getReviewCount(){
        return Integer.parseInt(json.getString("review_count"));
    }

    /**
     * @return The last update date of the resource.
     */
    public Integer getLastUpdateDate(){
        return Integer.parseInt(json.getString("last_update"));
    }

}

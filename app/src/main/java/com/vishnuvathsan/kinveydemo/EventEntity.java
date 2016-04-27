package com.vishnuvathsan.kinveydemo;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.kinvey.java.model.KinveyMetaData;

/**
 * Created by vishnuvathsan on 27-Apr-16.
 */
public class EventEntity extends GenericJson {
    @Key("_id")
    private String id;
    @Key
    private String name;
    @Key("_kmd")
    private KinveyMetaData meta; // Kinvey metadata, OPTIONAL
    @Key("_acl")
    private KinveyMetaData.AccessControlList acl; //Kinvey access control, OPTIONAL

    public EventEntity() {
    }  //GenericJson classes must have a public empty constructor

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public KinveyMetaData getMeta() {
        return meta;
    }

    public KinveyMetaData.AccessControlList getAcl() {
        return acl;
    }
}
